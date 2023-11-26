package com.example.lab9_20204205.model.beans;


import java.text.DateFormat;
import java.time.LocalDateTime;

public class Semestre {

    int idsemestre;
    String nombre;
    int idadministrador;

    public int getIdsemestre() {
        return idsemestre;
    }

    public void setIdsemestre(int idsemestre) {
        this.idsemestre = idsemestre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getIdadministrador() {
        return idadministrador;
    }

    public void setIdadministrador(int idadministrador) {
        this.idadministrador = idadministrador;
    }

    public boolean isHabilitado() {
        return habilitado;
    }

    public void setHabilitado(boolean habilitado) {
        this.habilitado = habilitado;
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

    boolean habilitado;
    LocalDateTime fecha_registro;
    LocalDateTime fecha_edicion;

}

