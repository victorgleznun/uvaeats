/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.uvaeats.proyectossw.modelo;

import java.sql.Date;

public class Detalle_menu {

    private int cantidad;
    private Date menu_del_dia;
    private int idPedido;

    public Detalle_menu(int cant, Date menu, int idPedido) {
        cantidad = cant;
        this.menu_del_dia = menu;
        this.idPedido = idPedido;
    }

    public Date getMenu_del_dia() {
        return menu_del_dia;
    }

    public void setMenu_del_dia(Date menu_del_dia) {
        this.menu_del_dia = menu_del_dia;
    }

    public int getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(int idPedido) {
        this.idPedido = idPedido;
    }

    /**
     * @return the cantidad
     */
    public int getCantidad() {
        return cantidad;
    }

    /**
     * @param cantidad the cantidad to set
     */
    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
}
