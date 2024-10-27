/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.uvaeats.proyectossw.clasesDB;

import com.uvaeats.proyectossw.bd.ConnectionPool;
import com.uvaeats.proyectossw.modelo.EstadoPedido;
import com.uvaeats.proyectossw.modelo.Pedido;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class PedidoDB {

    public static int insert(Pedido pedido) {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps;
        String query = "INSERT INTO pedido (estado, fecha, hora, precio, emailCliente, nombreCafeteria)  VALUES (?, ?, ?, ?, ?, ?)";
        try {
            ps = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, pedido.getEstado().toString());
            ps.setDate(2, pedido.getFecha());
            ps.setTime(3, pedido.getHora());
            ps.setDouble(4, pedido.getPrecio());
            ps.setString(5, pedido.getEmail());
            ps.setString(6, pedido.getNombreCafeteria());
            int res = 0;
            ps.executeUpdate();
            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                res = rs.getInt(1);
            }
            ps.close();
            pool.freeConnection(connection);
            return res;
        } catch (SQLException e) {
            return 0;
        }
    }

    public static ArrayList<Pedido> selectPedidoByEmail(String emailAddress) {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps;
        ResultSet rs;
        String query = "SELECT * FROM pedido WHERE emailCliente = ?";
        ArrayList<Pedido> listaPedidos = new ArrayList<>();
        try {
            ps = connection.prepareStatement(query);
            ps.setString(1, emailAddress);
            rs = ps.executeQuery();
            Pedido pedido;
            while (rs.next()) {
                pedido = new Pedido(EstadoPedido.valueOf(rs.getString("estado")), rs.getDate("fecha"), rs.getTime("hora"),
                        rs.getDouble("precio"), rs.getInt("id"), rs.getString("emailCliente"), rs.getString("nombreCafeteria"),
                        DetallePedidoDB.selectDetalle(rs.getInt("id")), DetalleOfertaDB.selectDetalleOferta(rs.getInt("id")));
                listaPedidos.add(pedido);
            }
            rs.close();
            ps.close();
            pool.freeConnection(connection);
            return listaPedidos;
        } catch (SQLException e) {
            return null;
        }
    }

    public static ArrayList<Pedido> selectPedidoByCafeteria(String cafeteria) {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps;
        ResultSet rs;
        String query = "SELECT * FROM pedido WHERE nombreCafeteria = ?";
        ArrayList<Pedido> listaPedidos = new ArrayList<>();
        try {
            ps = connection.prepareStatement(query);
            ps.setString(1, cafeteria);
            rs = ps.executeQuery();
            Pedido pedido;
            while (rs.next()) {
                pedido = new Pedido(EstadoPedido.valueOf(rs.getString("estado")), rs.getDate("fecha"),
                        rs.getTime("hora"), rs.getDouble("precio"), rs.getInt("id"), rs.getString("emailCliente"), rs.getString("nombreCafeteria"),
                        DetallePedidoDB.selectDetalle(rs.getInt("id")), DetalleOfertaDB.selectDetalleOferta(rs.getInt("id")));
                listaPedidos.add(pedido);
            }
            rs.close();
            ps.close();
            pool.freeConnection(connection);
            return listaPedidos;
        } catch (SQLException e) {
            return null;
        }
    }
    
    public static int updatePedido(String nuevoEstado, int idPedido ) {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps;
        String query = "UPDATE pedido SET estado = ? WHERE id = ?";
        try {
            ps = connection.prepareStatement(query);
            ps.setString(1, nuevoEstado);
            ps.setInt(2, idPedido);
            int res = ps.executeUpdate();
            
            ps.close();
            pool.freeConnection(connection);
            return res;
        } catch (SQLException e) {
            return 0;
        }
    }
}
