/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.uvaeats.proyectossw.servlet;

import com.uvaeats.proyectossw.clasesDB.ClienteDB;
import com.uvaeats.proyectossw.clasesDB.DetalleOfertaDB;
import com.uvaeats.proyectossw.clasesDB.DetallePedidoDB;
import com.uvaeats.proyectossw.clasesDB.PedidoDB;
import com.uvaeats.proyectossw.modelo.Detalle_oferta;
import com.uvaeats.proyectossw.modelo.Detalle_pedido;
import com.uvaeats.proyectossw.modelo.EstadoPedido;
import com.uvaeats.proyectossw.modelo.Oferta;
import com.uvaeats.proyectossw.modelo.Pedido;
import com.uvaeats.proyectossw.modelo.Plato;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class SvtResumen extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet SvtResumen</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet SvtResumen at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        if (request.getParameter("Finalizar") != null) {
            HttpSession misesion = request.getSession();
            LocalDate fecha = LocalDate.now();
            Date fechaActual = Date.valueOf(fecha);
            LocalTime hora = LocalTime.now();
            Time horaActual = Time.valueOf(hora);
            LocalTime horaPedido = horaActual.toLocalTime().plusMinutes(30);
            misesion.setAttribute("fechaPedido", fechaActual.toString());
            misesion.setAttribute("horaPedido", horaPedido.toString());
            double total = (double) misesion.getAttribute("total");
            String email = (String) misesion.getAttribute("idUsuario");
            String cafeteria = (String) misesion.getAttribute("cafeteria");
            Pedido pedido = new Pedido(EstadoPedido.EnPreparacion, fechaActual, horaActual, total, email, cafeteria);
            int id = PedidoDB.insert(pedido);
            pedido.setId(id);
            
            ArrayList<Plato> listaPlatos = (ArrayList)misesion.getAttribute("platos");
            ArrayList<String> valores = (ArrayList) request.getSession().getAttribute("valores");
            
            for (int i = 0; i<listaPlatos.size(); i++){
                if (!valores.get(i).equals("0")){
                    Detalle_pedido detalle = new Detalle_pedido(Integer.parseInt(valores.get(i)), listaPlatos.get(i).getNombre(), id);
                    DetallePedidoDB.insert(detalle);
                }
            }
            
            String[] ofertasSeleccionadas = (String[]) misesion.getAttribute("ofertasSeleccionadas");
            List<Oferta> ofertas = (List<Oferta>) misesion.getAttribute("listaOfertas");
            if (ofertasSeleccionadas != null && ofertas != null) {
                for (Oferta oferta : ofertas) {
                    if (Arrays.asList(ofertasSeleccionadas).contains(oferta.getNombre())) {
                        Detalle_oferta detalleOferta = new Detalle_oferta(oferta.getNombre(), id);
                        DetalleOfertaDB.insert(detalleOferta);
                    }
                }
            }

            int puntos = (int) misesion.getAttribute("puntos");
            int resta = (int) misesion.getAttribute("totalPuntos");
            double totalAPagar = (Double) misesion.getAttribute("total");
            int puntosGanados = (int)(totalAPagar*10);
            puntos = puntos - resta + puntosGanados;
            misesion.removeAttribute("puntos");
            misesion.setAttribute("puntos", puntos);
            misesion.setAttribute("puntosGanados", puntosGanados);
            ClienteDB.updatePuntos(email, puntos);

            response.sendRedirect("jsp/pedidoRealizado.jsp");
        } else {
            response.sendRedirect("jsp/facultad.jsp");
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
