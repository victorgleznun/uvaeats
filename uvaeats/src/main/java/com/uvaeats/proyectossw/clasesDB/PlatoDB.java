/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.uvaeats.proyectossw.clasesDB;

import com.uvaeats.proyectossw.bd.ConnectionPool;
import com.uvaeats.proyectossw.modelo.Plato;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class PlatoDB {

    public static ArrayList<Plato> selectPlatos(String nombreCafeteria) {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps;
        ResultSet rs;
        String query = "SELECT * FROM Plato WHERE nombreCafeteria = ?";
        ArrayList<Plato> listaPlatos = new ArrayList<>();
        try {
            ps = connection.prepareStatement(query);
            ps.setString(1, nombreCafeteria);
            rs = ps.executeQuery();
            Plato plato;
            while (rs.next()) {
                plato = new Plato(rs.getString("nombre"), rs.getDouble("precio"), rs.getString("descripcion"), rs.getString("ingredientes"), rs.getBoolean("disponible"), rs.getDate("menu_del_dia"), rs.getString("nombreCafeteria"));
                listaPlatos.add(plato);
            }
            rs.close();
            ps.close();
            pool.freeConnection(connection);
            return listaPlatos;
        } catch (SQLException e) {
            return null;
        }
    }
    
    public static void insert(Plato plato) {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps;
        String query = "INSERT INTO plato (nombre, precio, descripcion, ingredientes, disponible, menu_del_dia, nombreCafeteria) VALUES (?, ?, ?, ?, ?, ?, ?)";
        try {
            ps = connection.prepareStatement(query);
            ps.setString(1, plato.getNombre());
            ps.setDouble(2, plato.getPrecio());
            ps.setString(3, plato.getDescripcion());
            ps.setString(4, plato.getIngredientes());
            ps.setBoolean(5, plato.isDisponible());
            ps.setDate(6, plato.getMenuDelDia());
            ps.setString(7, plato.getCafeteria());
            ps.executeUpdate();
            ps.close();
            pool.freeConnection(connection);
            
        } catch (SQLException e) {
            pool.freeConnection(connection);
        }
    }
    
    public static void delete(String plato, String cafeteria) {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps;
        String query = "DELETE FROM plato WHERE nombre = ? and nombreCafeteria = ?";
        try {
            ps = connection.prepareStatement(query);
            ps.setString(1, plato);
            ps.setString(2, cafeteria);
            ps.executeUpdate();
            ps.close();
            pool.freeConnection(connection);
        } catch (SQLException e) {
            pool.freeConnection(connection);
        }
    }
}
