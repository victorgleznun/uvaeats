/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.uvaeats.proyectossw.modelo;

import java.sql.Date;

public class Plato {

    private String nombre;
    private double precio;
    private String descripcion;
    private String ingredientes;
    private boolean disponible;
    private Date menu_del_dia;
    private String nombreCafeteria;

    public Plato(String nombre, double precio, String descripcion, String ingredientes, boolean disponible, Date menu_del_dia, String nombreCafeteria) {
        this.nombre = nombre;
        this.precio = precio;
        this.descripcion = descripcion;
        this.ingredientes = ingredientes;
        this.disponible = disponible;
        this.menu_del_dia = menu_del_dia;
        this.nombreCafeteria = nombreCafeteria;
    }

    public String getNombre() {
        return nombre;
    }
    
    public Date getMenuDelDia(){
        return this.menu_del_dia;
    }
    public void setMenuDelDia(Date menu){
        menu_del_dia = menu;
    }
    
    public String getCafeteria(){
        return this.nombreCafeteria;
    }
    
    public void setCafeteria(String nombre){
        this.nombreCafeteria = nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getIngredientes() {
        return ingredientes;
    }

    public void setIngredientes(String ingredientes) {
        this.ingredientes = ingredientes;
    }

    public boolean isDisponible() {
        return disponible;
    }

    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }
}
