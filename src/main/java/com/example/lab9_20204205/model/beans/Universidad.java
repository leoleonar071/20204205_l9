package com.example.lab9_20204205.model.beans;


import java.time.LocalDateTime;

public class Universidad {
    public int getIdunisversidad() {
        return idunisversidad;
    }

    public void setIdunisversidad(int idunisversidad) {
        this.idunisversidad = idunisversidad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getLogo_url() {
        return logo_url;
    }

    public void setLogo_url(String logo_url) {
        this.logo_url = logo_url;
    }

    public int getIdaministrador() {
        return idaministrador;
    }

    public void setIdaministrador(int idaministrador) {
        this.idaministrador = idaministrador;
    }

    public LocalDateTime getFecha_registro() {
        return fecha_registro;
    }

    public void setFecha_registro(LocalDateTime fecha_registro) {
        this.fecha_registro = fecha_registro;
    }

    public LocalDateTime getFecha_edicion() {
        return fecha_edicion;
    }

    public void setFecha_edicion(LocalDateTime fecha_edicion) {
        this.fecha_edicion = fecha_edicion;
    }

    int idunisversidad;
    String nombre;
    String logo_url;
    int idaministrador;
    LocalDateTime fecha_registro;
    LocalDateTime fecha_edicion;
}
