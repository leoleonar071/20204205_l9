package com.example.lab9_20204205.model.beans;


import java.time.LocalDateTime;

public class Facultad {
    public int getIdfacultad() {
        return idfacultad;
    }

    public void setIdfacultad(int idfacultad) {
        this.idfacultad = idfacultad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getIduniversidad() {
        return iduniversidad;
    }

    public void setIduniversidad(int iduniversidad) {
        this.iduniversidad = iduniversidad;
    }

    public LocalDateTime getFechga_registro() {
        return fechga_registro;
    }

    public void setFechga_registro(LocalDateTime fechga_registro) {
        this.fechga_registro = fechga_registro;
    }

    public LocalDateTime getFecha_edicion() {
        return fecha_edicion;
    }

    public void setFecha_edicion(LocalDateTime fecha_edicion) {
        this.fecha_edicion = fecha_edicion;
    }

    int idfacultad;
    String nombre;
    int iduniversidad;
    LocalDateTime fechga_registro;
    LocalDateTime fecha_edicion;

}
