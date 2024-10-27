/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.uvaeats.proyectossw.modelo;

public class Oferta {

	private String nombre;
	private int puntos;
	private boolean disponible;
        private String nombreCafeteria;
	
	
	public Oferta(String nomb,int points,boolean disp,String nombreC) {
		nombre=nomb;
		puntos=points;
		disponible=disp;
                nombreCafeteria = nombreC;
		
	}

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getPuntos() {
        return puntos;
    }

    public void setPuntos(int puntos) {
        this.puntos = puntos;
    }

    public boolean isDisponible() {
        return disponible;
    }

    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }

    public String getNombreCafeteria() {
        return nombreCafeteria;
    }

    public void setNombreCafeteria(String nombreCafeteria) {
        this.nombreCafeteria = nombreCafeteria;
    }
   
}
