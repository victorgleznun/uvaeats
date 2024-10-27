/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.uvaeats.proyectossw.modelo;

import java.io.Serializable;
import java.time.LocalTime;
import java.util.ArrayList;

public class Cafeteria implements Serializable{

    private LocalTime horarioApertura;
    private LocalTime horarioCierre;
    private String nombre;
    private String direccion;
    private String telefono;
    private String nombreFacultad;
    private ArrayList<Plato> listaPlatos;
    private ArrayList<Oferta> listaOfertas;

    public Cafeteria(LocalTime horarioApertura, LocalTime horarioCierre, String nombre, String direccion, String telefono, String facultad, ArrayList<Plato> listaPlatos, ArrayList<Oferta> listaOfertas) {
        this.horarioApertura = horarioApertura;
        this.horarioCierre = horarioCierre;
        this.nombre = nombre;
        this.direccion = direccion;
        this.telefono = telefono;
        this.nombreFacultad = facultad;
        this.listaPlatos = listaPlatos;
        this.listaOfertas = listaOfertas;
    }

    public LocalTime getHorarioApertura() {
        return horarioApertura;
    }
    
    public String getFacultad(){
        return this.nombreFacultad;
    }
    
    public void setFacultad(String facultad){
        this.nombreFacultad = facultad;
    }

    public void setHorarioApertura(LocalTime horarioApertura) {
        this.horarioApertura = horarioApertura;
    }

    public LocalTime getHorarioCierre() {
        return horarioCierre;
    }

    public void setHorarioCierre(LocalTime horarioCierre) {
        this.horarioCierre = horarioCierre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getNombreFacultad() {
        return nombreFacultad;
    }

    public void setNombreFacultad(String nombreFacultad) {
        this.nombreFacultad = nombreFacultad;
    }

    public ArrayList<Plato> getListaPlatos() {
        return listaPlatos;
    }

    public void setListaPlatos(ArrayList<Plato> listaPlatos) {
        this.listaPlatos = listaPlatos;
    }

    public ArrayList<Oferta> getListaOfertas() {
        return listaOfertas;
    }

    public void setListaOfertas(ArrayList<Oferta> listaOfertas) {
        this.listaOfertas = listaOfertas;
    }
    
    
}
