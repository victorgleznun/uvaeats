/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.uvaeats.proyectossw.servlet;

import com.uvaeats.proyectossw.clasesDB.CafeteriaDB;
import com.uvaeats.proyectossw.clasesDB.PlatoDB;
import com.uvaeats.proyectossw.modelo.Cafeteria;
import com.uvaeats.proyectossw.modelo.Plato;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalTime;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author izanm
 */
public class SvtFacultad extends HttpServlet {

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
            out.println("<title>Servlet SvtFacultad</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet SvtFacultad at " + request.getContextPath() + "</h1>");
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
        
        String nombreFacultad = request.getParameter("facultad");
        String nombreCafeteria = request.getParameter("cafeteria");

        Cafeteria cafeteria = CafeteriaDB.selectCafeteria(nombreCafeteria, nombreFacultad);
        
        if (nombreCafeteria == null || nombreFacultad == null){
            misesion.setAttribute("errorFacultad", "Debe seleccionar una facultad y cafeteria");
            response.sendRedirect("jsp/facultad.jsp");
        }else{
            if (cafeteria.getHorarioApertura().isBefore(LocalTime.now()) && cafeteria.getHorarioCierre().isAfter(LocalTime.now())) {
                misesion.removeAttribute("ofertasSeleccionadas");
                misesion.removeAttribute("listaOfertas");
                misesion.removeAttribute("valores");
                misesion.removeAttribute("platos");

                misesion.setAttribute("cafeteria", nombreCafeteria);
                ArrayList<Plato> platos = PlatoDB.selectPlatos(nombreCafeteria);
                misesion.setAttribute("platos", platos);
                misesion.setAttribute("errorFacultad", "");
                misesion.setAttribute("errorPedido", "");
                response.sendRedirect("jsp/realizandoPedido.jsp");
            } else {
                misesion.setAttribute("errorFacultad", "No se puede pedir fuera del horario");
                response.sendRedirect("jsp/facultad.jsp");
            }
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
