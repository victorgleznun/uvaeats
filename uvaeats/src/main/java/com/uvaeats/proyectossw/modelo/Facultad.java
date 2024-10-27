/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.uvaeats.proyectossw.modelo;

import java.io.Serializable;
import java.util.ArrayList;

public class Facultad implements Serializable{

    private String nombre;
    private ArrayList<Cafeteria> cafeterias;

    public Facultad(String nomb, ArrayList<Cafeteria> cafeterias) {
        nombre = nomb;
        this.cafeterias = cafeterias;
    }

    /**
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public ArrayList<Cafeteria> getCafeterias() {
        return cafeterias;
    }

    public void setCafeterias(ArrayList<Cafeteria> cafeterias) {
        this.cafeterias = cafeterias;
    }
}
