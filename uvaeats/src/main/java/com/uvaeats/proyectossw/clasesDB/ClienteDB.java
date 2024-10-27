/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.uvaeats.proyectossw.clasesDB;

import com.uvaeats.proyectossw.bd.ConnectionPool;
import com.uvaeats.proyectossw.modelo.Cliente;
import java.sql.*;

public class ClienteDB {

    public static int insert(Cliente cliente) {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps;
        String query = "INSERT INTO cliente (nombre, apellidos, telefono, email, contraseña, puntos)  VALUES (?, ?, ?, ?, ?, ?)";
        try {
            ps = connection.prepareStatement(query);
            ps.setString(1, cliente.getNombre());
            ps.setString(2, cliente.getApellidos());
            ps.setString(3, cliente.getTelefono());
            ps.setString(4, cliente.getEmail());
            ps.setString(5, cliente.getContraseña());
            ps.setInt(6, cliente.getPuntos());
            int res = ps.executeUpdate();
            ps.close();
            pool.freeConnection(connection);
            return res;
        } catch (SQLException e) {
            return 0;
        }
    }

    public static Cliente selectCliente(String emailAddress) {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps;
        ResultSet rs;
        String query = "SELECT * FROM cliente WHERE email = ?";
        try {
            ps = connection.prepareStatement(query);
            ps.setString(1, emailAddress);
            rs = ps.executeQuery();
            Cliente cliente = null;
            if (rs.next()) {
                cliente = new Cliente(rs.getString("nombre"), rs.getString("apellidos"), rs.getString("telefono"), rs.getString("email"), rs.getString("contraseña"));
                cliente.setPuntos(rs.getInt("puntos"));
            }
            rs.close();
            ps.close();
            pool.freeConnection(connection);
            return cliente;
        } catch (SQLException e) {
            return null;
        }
    }

    public static int updatePuntos(String emailAddress, int puntos) {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps;
        String query = "UPDATE cliente SET puntos = ? WHERE email = ?";
        try {
            ps = connection.prepareStatement(query);
            ps.setInt(1, puntos);
            ps.setString(2, emailAddress);
            int res = ps.executeUpdate();
            ps.close();
            pool.freeConnection(connection);
            return res;
        } catch (SQLException e) {
            return 0;
        }
    }

    public static void updateCliente(String email, String nombre, String apellido, String telefono) {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps;
        String query = "UPDATE cliente SET nombre = ?, apellidos = ?, telefono = ? WHERE email = ?";
        try {
            ps = connection.prepareStatement(query);
            ps.setString(1, nombre);
            ps.setString(2, apellido);
            ps.setString(3, telefono);
            ps.setString(4, email);
            ps.executeUpdate();
            ps.close();
            pool.freeConnection(connection);
        } catch (SQLException e) {
        }
    }
}
