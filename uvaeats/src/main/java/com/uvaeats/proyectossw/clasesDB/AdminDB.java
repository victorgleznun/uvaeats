
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.uvaeats.proyectossw.clasesDB;

import com.uvaeats.proyectossw.bd.ConnectionPool;
import com.uvaeats.proyectossw.modelo.Admin;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author fagon
 */
public class AdminDB {
    public static Admin selectAdmin(String emailAddress) {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps;
        ResultSet rs;
        String query = "SELECT * FROM admin WHERE email = ?";
        try {
            ps = connection.prepareStatement(query);
            ps.setString(1, emailAddress);
            rs = ps.executeQuery();
            Admin admin = null;
            if (rs.next()) {
                admin = new Admin(rs.getString("nombre"), rs.getString("apellidos"), rs.getString("telefono"), rs.getString("email"), rs.getString("contraseña"));
            }
            rs.close();
            ps.close();
            pool.freeConnection(connection);
            return admin;
        } catch (SQLException e) {
            return null;
        }
    }
}
