/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.uvaeats.proyectossw.clasesDB;

import com.uvaeats.proyectossw.bd.ConnectionPool;
import com.uvaeats.proyectossw.modelo.Cafeteria;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.util.ArrayList;

/**
 *
 * @author izanm
 */
public class CafeteriaDB {
    public static ArrayList<Cafeteria> selectCafeteriasByFacultad(String facultad) {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps;
        ResultSet rs;
        String query = "SELECT * FROM cafeteria C WHERE nombreFacultad = ?";
        try {
            ps = connection.prepareStatement(query);
            ps.setString(1, facultad);
            rs = ps.executeQuery();
            ArrayList<Cafeteria> cafeterias = new ArrayList<>();
            while (rs.next()) {
                cafeterias.add(new Cafeteria(rs.getTime("horaApertura").toLocalTime(), rs.getTime("horaCierre").toLocalTime(), rs.getString("nombre"),
                rs.getString("direccion"), rs.getString("telefono"), facultad, PlatoDB.selectPlatos(rs.getString("nombre")), OfertaDB.selectOfertas(rs.getString("nombre"))));
            }
            rs.close();
            ps.close();
            pool.freeConnection(connection);
            return cafeterias;
        } catch (SQLException e) {
            return null;
        }
    }
    
     public static Cafeteria selectCafeteria(String nombre, String facultad) {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps;
        ResultSet rs;
        String query = "SELECT * FROM cafeteria WHERE nombre = ?";
        try {
            ps = connection.prepareStatement(query);
            ps.setString(1, nombre);
            rs = ps.executeQuery();
            Cafeteria cafeteria = null;
            if (rs.next()) {
                cafeteria = new Cafeteria(rs.getTime("horaApertura").toLocalTime(), rs.getTime("horaCierre").toLocalTime(), rs.getString("nombre"),
                rs.getString("direccion"), rs.getString("telefono"), facultad, PlatoDB.selectPlatos(rs.getString("nombre")), OfertaDB.selectOfertas(rs.getString("nombre")));
            }
            rs.close();
            ps.close();
            pool.freeConnection(connection);
            return cafeteria;
        } catch (SQLException e) {
            return null;
        }
    }
     
    public static void insert(Cafeteria cafeteria) {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps;
        String query = "INSERT INTO cafeteria (horaApertura, horaCierre, nombre, direccion, telefono, nombreFacultad) VALUES (?, ?, ?, ?, ?, ?)";
        try {
            ps = connection.prepareStatement(query);
            ps.setTime(1, Time.valueOf(cafeteria.getHorarioApertura()));
            ps.setTime(2, Time.valueOf(cafeteria.getHorarioCierre()));
            ps.setString(3, cafeteria.getNombre());
            ps.setString(4, cafeteria.getDireccion());
            ps.setString(5, cafeteria.getTelefono());
            ps.setString(6, cafeteria.getFacultad());
            
            ps.executeUpdate();
            ps.close();
            pool.freeConnection(connection);
            
        } catch (SQLException e) {
            pool.freeConnection(connection);
        }
    }
    
    public static void delete(String cafeteria) {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps;
        String query = "DELETE FROM cafeteria WHERE nombre = ?";
        try {
            ps = connection.prepareStatement(query);
            ps.setString(1, cafeteria);
            ps.executeUpdate();
            ps.close();
            pool.freeConnection(connection);
        } catch (SQLException e) {
            pool.freeConnection(connection);
        }
    }
}
