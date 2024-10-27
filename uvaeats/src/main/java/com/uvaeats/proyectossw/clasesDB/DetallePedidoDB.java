/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.uvaeats.proyectossw.clasesDB;

import com.uvaeats.proyectossw.bd.ConnectionPool;
import com.uvaeats.proyectossw.modelo.Detalle_pedido;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author fagon
 */
public class DetallePedidoDB {
    public static void insert(Detalle_pedido detalle) {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps;
        String query = "INSERT INTO detalle_pedido (cantidad, nombre, idPedido) VALUES (?, ?, ?)";
        try {
            ps = connection.prepareStatement(query);
            ps.setInt(1, detalle.getCantidad());
            ps.setString(2, detalle.getNombre());
            ps.setInt(3, detalle.getIdPedido());
            
            ps.executeUpdate();
            ps.close();
            pool.freeConnection(connection);
            
        } catch (SQLException e) {
            pool.freeConnection(connection);
        }
    }
    
    public static ArrayList<Detalle_pedido> selectDetalle(int id) {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps;
        ResultSet rs;
        String query = "SELECT * FROM detalle_pedido WHERE idPedido = ?";
        ArrayList<Detalle_pedido> listaDetalles = new ArrayList<>();
        try {
            ps = connection.prepareStatement(query);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            Detalle_pedido detalle;
            while (rs.next()) {
                detalle = new Detalle_pedido(rs.getInt("cantidad"), rs.getString("nombre"), rs.getInt("idPedido"));
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
