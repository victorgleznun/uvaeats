/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.uvaeats.proyectossw.servlet;

import com.uvaeats.proyectossw.clasesDB.OfertaDB;
import com.uvaeats.proyectossw.modelo.Oferta;
import com.uvaeats.proyectossw.modelo.Plato;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class SvtRealizandoPedido extends HttpServlet {

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
            out.println("<title>Servlet SvtPedido</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet SvtPedido at " + request.getContextPath() + "</h1>");
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
        HttpSession misesion = request.getSession();
        int cont0 = 0;
        if (request.getParameter("ofertas") != null) {
            ArrayList<Oferta> lista = OfertaDB.selectOfertas((String)misesion.getAttribute("cafeteria"));
            misesion.setAttribute("listaOfertas", lista);
            response.sendRedirect("jsp/ofertas.jsp");
        } else {
            ArrayList<Plato> platos = (ArrayList) misesion.getAttribute("platos");
            ArrayList<String> valores = new ArrayList<>();
            for (Plato plato : platos) {
                misesion.removeAttribute(plato.getNombre());
                valores.add(request.getParameter(plato.getNombre()));
                cont0 = cont0 + Integer.parseInt(request.getParameter(plato.getNombre()));
            }
            if (cont0 == 0){
                misesion.setAttribute("errorPedido", "Selecciona al menos 1 producto");
                response.sendRedirect("jsp/realizandoPedido.jsp");
            }else{ 
                misesion.setAttribute("valores", valores);
                misesion.setAttribute("errorPedido", "");
                response.sendRedirect("jsp/resumen.jsp");
            }
        }
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
        processRequest(request, response);

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
