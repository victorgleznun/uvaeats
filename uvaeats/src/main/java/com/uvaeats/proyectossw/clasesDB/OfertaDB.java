/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.uvaeats.proyectossw.clasesDB;

import com.uvaeats.proyectossw.bd.ConnectionPool;
import com.uvaeats.proyectossw.modelo.Oferta;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class OfertaDB {

    public static ArrayList<Oferta> selectOfertas(String cafeteria) {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps;
        ResultSet rs;
        String query = "SELECT * FROM oferta where nombreCafeteria = ?";
        ArrayList<Oferta> lista = new ArrayList<>();
        try {
            ps = connection.prepareStatement(query);
            ps.setString(1, cafeteria);
            rs = ps.executeQuery();
            Oferta oferta;
            while (rs.next()) {
                oferta = new Oferta(rs.getString("nombre"), rs.getInt("puntos"), rs.getBoolean("disponible"), rs.getString("nombreCafeteria"));
                lista.add(oferta);
            }
            rs.close();
            ps.close();
            pool.freeConnection(connection);
            return lista;
        } catch (SQLException e) {
            return null;
        }
    }
    
    public static void insert(Oferta oferta) {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps;
        String query = "INSERT INTO oferta (nombre, puntos, disponible, nombreCafeteria) VALUES (?, ?, ?, ?)";
        try {
            ps = connection.prepareStatement(query);
            ps.setString(1, oferta.getNombre());
            ps.setInt(2, oferta.getPuntos());
            ps.setBoolean(3, oferta.isDisponible());
            ps.setString(4, oferta.getNombreCafeteria());
            
            ps.executeUpdate();
            ps.close();
            pool.freeConnection(connection);
            
        } catch (SQLException e) {
            pool.freeConnection(connection);
        }
    }
    
    public static void delete(String nombreOferta, String cafeteria) {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps;
        String query = "DELETE FROM oferta WHERE nombre = ? and nombreCafeteria = ?";
        try {
            ps = connection.prepareStatement(query);
            ps.setString(1, nombreOferta);
            ps.setString(2, cafeteria);
            ps.executeUpdate();
            ps.close();
            pool.freeConnection(connection);
        } catch (SQLException e) {
            pool.freeConnection(connection);
        }
    }
}
