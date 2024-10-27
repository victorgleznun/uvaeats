/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.uvaeats.proyectossw.modelo;

import java.sql.Date;
import java.sql.Time;
import java.util.ArrayList;

public class Pedido {

    private EstadoPedido estado;
    private Date fecha;
    private Time hora;
    private double precio;
    private int id;
    private String email;
    private String nombreCafeteria;
    private ArrayList<Detalle_pedido> listaDetalles;
    private ArrayList<Detalle_oferta> listaOfertas;

    //Contructor para la instancia inicial
    public Pedido(EstadoPedido estado, Date fecha, Time hora, double precio, String email, String nombre) {
        this.estado = estado;
        this.fecha = fecha;
        this.hora = hora;
        this.precio = precio;
        this.email = email;
        this.nombreCafeteria = nombre;
    }
    
    //Contructor para pedidos que se tengan que consultar en la base de datos
    public Pedido(EstadoPedido estado, Date fecha, Time hora, double precio, int id, String email, String nombre, ArrayList<Detalle_pedido> detallesP, ArrayList<Detalle_oferta> detallesO) {
        this.estado = estado;
        this.fecha = fecha;
        this.hora = hora;
        this.precio = precio;
        this.id = id;
        this.email = email;
        this.nombreCafeteria = nombre;
        this.listaDetalles = detallesP;
        this.listaOfertas = detallesO;
    }

    public EstadoPedido getEstado() {
        return estado;
    }

    public void setEstado(EstadoPedido estado) {
        this.estado = estado;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Time getHora() {
        return hora;
    }

    public void setHora(Time hora) {
        this.hora = hora;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNombreCafeteria() {
        return nombreCafeteria;
    }

    public void setNombreCafeteria(String nombreCafeteria) {
        this.nombreCafeteria = nombreCafeteria;
    }

    public ArrayList<Detalle_pedido> getListaDetalles() {
        return listaDetalles;
    }

    public void setListaDetalles(ArrayList<Detalle_pedido> listaDetalles) {
        this.listaDetalles = listaDetalles;
    }

    public ArrayList<Detalle_oferta> getListaOfertas() {
        return listaOfertas;
    }

    public void setListaOfertas(ArrayList<Detalle_oferta> listaOfertas) {
        this.listaOfertas = listaOfertas;
    }
    
    
}
