/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.uvaeats.proyectossw.servlet;

import com.uvaeats.proyectossw.clasesDB.ClienteDB;
import com.uvaeats.proyectossw.clasesDB.PedidoDB;
import com.uvaeats.proyectossw.modelo.Cliente;
import com.uvaeats.proyectossw.modelo.Pedido;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class SvtMiCuenta extends HttpServlet {

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
            out.println("<title>Servlet SvtPerfil</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet SvtPerfil at " + request.getContextPath() + "</h1>");
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
        if (request.getParameter("cuenta") != null) {
            String email = (String) misesion.getAttribute("idUsuario");
            Cliente actual = ClienteDB.selectCliente(email);

            misesion.setAttribute("nombre", actual.getNombre());
            misesion.setAttribute("apellidos", actual.getApellidos());
            misesion.setAttribute("email", actual.getEmail());
            misesion.setAttribute("telefono", actual.getTelefono());

            response.sendRedirect("jsp/miCuenta.jsp");
        } else if (request.getParameter("pedidos") != null) {
            ArrayList<Pedido> listaPedidos = PedidoDB.selectPedidoByEmail((String) misesion.getAttribute("idUsuario"));
          
            misesion.setAttribute("listaPedidos", listaPedidos);
            misesion.setAttribute("listaFiltro", listaPedidos);
            response.sendRedirect("jsp/misPedidos.jsp");
        } else if (request.getParameter("cerrar") != null) {
            misesion.invalidate();
            response.sendRedirect("jsp/index.jsp");
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
