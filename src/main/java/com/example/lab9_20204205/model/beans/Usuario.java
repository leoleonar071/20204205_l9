package com.example.lab9_20204205.model.beans;

import java.text.DateFormat;
import java.time.LocalDateTime;


public class Usuario {

    int idusuario;
    String nombre;
    String correo;
    String password;

    public int getIdusuario() {
        return idusuario;
    }

    public void setIdusuario(int idusuario) {
        this.idusuario = idusuario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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

    public int getIdrol() {
        return idrol;
    }

    public void setIdrol(int idrol) {
        this.idrol = idrol;
    }

    LocalDateTime fecha_registro;
    LocalDateTime fecha_edicion;
    int idrol;





}
