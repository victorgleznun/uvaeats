/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.uvaeats.proyectossw.clasesDB;

import com.uvaeats.proyectossw.bd.ConnectionPool;
import com.uvaeats.proyectossw.modelo.Detalle_oferta;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author fagon
 */
public class DetalleOfertaDB {
    public static void insert(Detalle_oferta detalle) {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps;
        String query = "INSERT INTO detalle_oferta (nombre, idPedido) VALUES (?, ?)";
        try {
            ps = connection.prepareStatement(query);
            ps.setString(1, detalle.getNombre());
            ps.setInt(2, detalle.getIdPedido());
            
            ps.executeUpdate();
            ps.close();
            pool.freeConnection(connection);
            
        } catch (SQLException e) {
            pool.freeConnection(connection);
        }
    }
    
    public static ArrayList<Detalle_oferta> selectDetalleOferta(int id) {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps;
        ResultSet rs;
        String query = "SELECT * FROM detalle_oferta WHERE idPedido = ?";
        ArrayList<Detalle_oferta> listaDetalles = new ArrayList<>();
        try {
            ps = connection.prepareStatement(query);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            Detalle_oferta detalle;
            while (rs.next()) {
                detalle = new Detalle_oferta(rs.getString("nombre"), rs.getInt("idPedido"));
                listaDetalles.add(detalle);
            }
            rs.close();
            ps.close();
            pool.freeConnection(connection);
            return listaDetalles;
        } catch (SQLException e) {
            return null;
        }
    }
}
