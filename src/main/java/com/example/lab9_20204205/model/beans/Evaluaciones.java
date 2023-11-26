package com.example.lab9_20204205.model.beans;


import java.time.LocalDateTime;

public class Evaluaciones {
    int idevaluaciones;
    String nombre_estudiantes;

    public int getIdevaluaciones() {
        return idevaluaciones;
    }

    public void setIdevaluaciones(int idevaluaciones) {
        this.idevaluaciones = idevaluaciones;
    }

    public String getNombre_estudiantes() {
        return nombre_estudiantes;
    }

    public void setNombre_estudiantes(String nombre_estudiantes) {
        this.nombre_estudiantes = nombre_estudiantes;
    }

    public String getCodigo_estudiantes() {
        return codigo_estudiantes;
    }

    public void setCodigo_estudiantes(String codigo_estudiantes) {
        this.codigo_estudiantes = codigo_estudiantes;
    }

    public String getCorreo_estudiantes() {
        return correo_estudiantes;
    }

    public void setCorreo_estudiantes(String correo_estudiantes) {
        this.correo_estudiantes = correo_estudiantes;
    }

    public int getNota() {
        return nota;
    }

    public void setNota(int nota) {
        this.nota = nota;
    }

    public int getIdcurso() {
        return idcurso;
    }

    public void setIdcurso(int idcurso) {
        this.idcurso = idcurso;
    }

    public int getIdsemestre() {
        return idsemestre;
    }

    public void setIdsemestre(int idsemestre) {
        this.idsemestre = idsemestre;
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

    String codigo_estudiantes;
    String correo_estudiantes;
    int nota;
    int idcurso;
    int idsemestre;
    LocalDateTime fecha_registro;
    LocalDateTime fecha_edicion;
}
