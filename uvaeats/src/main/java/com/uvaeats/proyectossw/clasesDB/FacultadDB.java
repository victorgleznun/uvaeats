/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.uvaeats.proyectossw.clasesDB;

import com.uvaeats.proyectossw.bd.ConnectionPool;
import com.uvaeats.proyectossw.modelo.Facultad;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author izanm
 */
public class FacultadDB {
    public static ArrayList<Facultad> selectFacultades() {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps;
        ResultSet rs;
        String query = "SELECT F.nombre FROM facultad F";
        try {
            ps = connection.prepareStatement(query);
            rs = ps.executeQuery();
            ArrayList<Facultad> facultades = new ArrayList<>();
            while (rs.next()) {
                facultades.add(new Facultad(rs.getString("nombre"), CafeteriaDB.selectCafeteriasByFacultad(rs.getString("nombre"))));
            }
            rs.close();
            ps.close();
            pool.freeConnection(connection);
            return facultades;
        } catch (SQLException e) {
            return null;
        }
    }
}
