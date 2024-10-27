/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.uvaeats.proyectossw.modelo;

/**
 *
 * @author izanm
 */
public class Empleado {

    private String nombre;
    private String apellidos;
    private String telefono;
    private String email;
    private String contraseña;
    private String nombreCafeteria;

    public Empleado(String nombre, String apellidos, String telefono, String email, String contraseña, String nombreCafeteria) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.telefono = telefono;
        this.email = email;
        this.contraseña = contraseña;
        this.nombreCafeteria = nombreCafeteria;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public String getNombreCafeteria() {
        return nombreCafeteria;
    }

    public void setNombreCafeteria(String nombreCafeteria) {
        this.nombreCafeteria = nombreCafeteria;
    }

}
