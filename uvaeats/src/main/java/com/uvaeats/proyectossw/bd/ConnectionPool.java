/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.uvaeats.proyectossw.bd;

import java.sql.*;
import javax.sql.DataSource;
import javax.naming.InitialContext;
import javax.naming.NamingException;

public class ConnectionPool {
    private static ConnectionPool pool = null;
    private static DataSource dataSource = null;
    private ConnectionPool() {
        try {
            InitialContext ic = new InitialContext();
            dataSource = (DataSource) ic.lookup("java:/comp/env/jdbc/bdssw");
        }
        catch(NamingException e) {
        }
    }

public static ConnectionPool getInstance() {
    if (pool == null) {
        pool = new ConnectionPool();
    }
    return pool;
}

public Connection getConnection() {
    try {
        return dataSource.getConnection();
    }
    catch (SQLException sqle) {
        return null;
    }
}

public void freeConnection(Connection c) {
    try {
        c.close();
    }
    catch (SQLException sqle) {
    }
}

}
