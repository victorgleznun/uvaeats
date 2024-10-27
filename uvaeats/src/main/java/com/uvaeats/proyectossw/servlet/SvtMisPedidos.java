/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.uvaeats.proyectossw.servlet;

import com.uvaeats.proyectossw.modelo.Pedido;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author fagon
 */
public class SvtMisPedidos extends HttpServlet {

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
            out.println("<title>Servlet SvtMisPedidos</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet SvtMisPedidos at " + request.getContextPath() + "</h1>");
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
        HttpSession misesion = request.getSession();
        ArrayList<Pedido> listaPedidos = (ArrayList) misesion.getAttribute("listaPedidos");
        if (request.getParameter("filtrar") != null) {
            ArrayList<Pedido> listaFiltro = new ArrayList<>();
            String filtro = request.getParameter("cafeteria");
            String estado = request.getParameter("estado");
            boolean valido = true;
            for (int i = 0; i < listaPedidos.size(); i++) {
                for (int j = 0; j < filtro.length(); j++) {
                    if (listaPedidos.get(i).getNombreCafeteria().charAt(j) != filtro.charAt(j)) {
                        valido = false;
                    }
                }
                if (valido) {
                    switch (estado) {
                        case "preparacion":
                            if (listaPedidos.get(i).getEstado().toString().equals("EnPreparacion")) {
                                listaFiltro.add(listaPedidos.get(i));
                            }
                            break;

                        case "recoger":
                            if (listaPedidos.get(i).getEstado().toString().equals("ListoParaRecoger")) {
                                listaFiltro.add(listaPedidos.get(i));
                            }
                            break;

                        case "entregado":
                            if (listaPedidos.get(i).getEstado().toString().equals("Entregado")) {
                                listaFiltro.add(listaPedidos.get(i));
                            }
                            break;

                        default:
                            listaFiltro.add(listaPedidos.get(i));
                            break;
                    }
                }
                valido = true;
            }
            misesion.setAttribute("listaFiltro", listaFiltro);
        }
        response.sendRedirect("jsp/misPedidos.jsp");
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
