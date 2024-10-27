/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.uvaeats.proyectossw.clasesDB;

import com.uvaeats.proyectossw.bd.ConnectionPool;
import com.uvaeats.proyectossw.modelo.Empleado;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author izanm
 */
public class EmpleadoDB {
    public static Empleado selectEmpleado(String emailAddress) {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps;
        ResultSet rs;
        String query = "SELECT * FROM empleado WHERE email = ?";
        try {
            ps = connection.prepareStatement(query);
            ps.setString(1, emailAddress);
            rs = ps.executeQuery();
            Empleado emp = null;
            if (rs.next()) {
                emp = new Empleado(rs.getString("nombre"), rs.getString("apellidos"), rs.getString("telefono"), rs.getString("email"), rs.getString("contraseña"), rs.getString("nombreCafeteria"));
            }
            rs.close();
            ps.close();
            pool.freeConnection(connection);
            return emp;
        } catch (SQLException e) {
            return null;
        }
    }
}
