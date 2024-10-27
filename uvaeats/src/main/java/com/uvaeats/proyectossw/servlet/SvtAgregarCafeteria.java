/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.uvaeats.proyectossw.servlet;

import com.uvaeats.proyectossw.clasesDB.CafeteriaDB;
import com.uvaeats.proyectossw.modelo.Cafeteria;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalTime;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author fagon
 */
public class SvtAgregarCafeteria extends HttpServlet {

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
            out.println("<title>Servlet SvtAgregarCafeteria</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet SvtAgregarCafeteria at " + request.getContextPath() + "</h1>");
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
        if (request.getParameter("cancelar") == null){
            LocalTime hora = LocalTime.parse(request.getParameter("horaApertura"));
            LocalTime cierre = LocalTime.parse(request.getParameter("horaCierre"));
            String nombre = request.getParameter("nombreCafeteria");
            String direccion = request.getParameter("direccion");
            String telefono = request.getParameter("telefono");
            String nombreFacultad = request.getParameter("nombreFacultad");
            if (hora != null && cierre != null && nombre != null && !direccion.equals("") && !telefono.equals("") && !nombreFacultad.equals("")){
                CafeteriaDB.insert(new Cafeteria(hora, cierre, nombre, direccion, telefono, nombreFacultad, null, null));
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
