/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.uvaeats.proyectossw.modelo;

import java.time.LocalDate;

public class Menu_del_dia {

    private LocalDate dia;
    private double precio;

    public Menu_del_dia(LocalDate day, double price) {
        dia = day;
        precio = price;
    }

    /**
     * @return the dia
     */
    public LocalDate getDia() {
        return dia;
    }

    /**
     * @param dia the dia to set
     */
    public void setDia(LocalDate dia) {
        this.dia = dia;
    }

    /**
     * @return the precio
     */
    public double getPrecio() {
        return precio;
    }

    /**
     * @param precio the precio to set
     */
    public void setPrecio(double precio) {
        this.precio = precio;
    }

}
