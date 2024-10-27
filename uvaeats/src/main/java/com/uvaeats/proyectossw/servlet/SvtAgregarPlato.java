/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.uvaeats.proyectossw.servlet;

import com.uvaeats.proyectossw.clasesDB.PlatoDB;
import com.uvaeats.proyectossw.modelo.Plato;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author fagon
 */
public class SvtAgregarPlato extends HttpServlet {

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
            out.println("<title>Servlet SvtAgregarPlato</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet SvtAgregarPlato at " + request.getContextPath() + "</h1>");
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
        if (request.getParameter("cancelar")==null){
            String nombre = request.getParameter("nombre");
            double precio;
            if (request.getParameter("precio").equals("")){
                precio = 0.0;
            }else{
                precio = Double.parseDouble(request.getParameter("precio"));
            }
            String descripcion = request.getParameter("descripcion");
            String ingredientes = request.getParameter("ingredientes");
            boolean disponible = Boolean.parseBoolean(request.getParameter("disponible"));
            System.out.println(disponible);
            System.out.println(precio);
            String cafeteria = request.getParameter("cafeteria");
            if (nombre != null && cafeteria != null && precio != 0.0){
                PlatoDB.insert(new Plato(nombre, precio, descripcion, ingredientes, disponible, null, cafeteria));
            }
        }
        response.sendRedirect("jsp/cafeteriasAdmin.jsp");
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
