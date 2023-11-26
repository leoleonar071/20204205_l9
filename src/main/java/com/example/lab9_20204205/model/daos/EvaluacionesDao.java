package com.example.lab9_20204205.model.daos;


import com.example.lab9_20204205.model.beans.Evaluaciones;

import java.sql.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class EvaluacionesDao extends DaoBase {

    public List<Evaluaciones> listarEvaluaciones() {
        List<Evaluaciones> listaEvaluaciones = new ArrayList<>();

        String sql = "SELECT * FROM evaluaciones";

        try (Connection conn = this.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Evaluaciones evaluacion = fetchEvaluacionData(rs);
                listaEvaluaciones.add(evaluacion);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();

        }
        return listaEvaluaciones;
    }



    public Evaluaciones obtenerEvaluacion(int idEvaluacion) {
        Evaluaciones evaluacion = null;

        String sql = "SELECT * FROM evaluaciones WHERE idevaluaciones = ?";

        try (Connection conn = this.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, idEvaluacion);

            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    evaluacion = fetchEvaluacionData(rs);
                }
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return evaluacion;
    }

    public void guardarEvaluacion(Evaluaciones evaluacion) {
        String sql = "INSERT INTO evaluaciones (nombre_estudiantes, codigo_estudiantes, correo_estudiantes, nota, idcurso, idsemestre, fecha_registro, fecha_edicion) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

        try (Connection conn = this.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, evaluacion.getNombre_estudiantes());
            pstmt.setString(2, evaluacion.getCodigo_estudiantes());
            pstmt.setString(3, evaluacion.getCorreo_estudiantes());
            pstmt.setInt(4, evaluacion.getNota());
            pstmt.setInt(5, evaluacion.getIdcurso());
            pstmt.setInt(6, evaluacion.getIdsemestre());
            pstmt.setObject(7, evaluacion.getFecha_registro());
            pstmt.setObject(8, evaluacion.getFecha_edicion());

            pstmt.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public void actualizarEvaluacion(Evaluaciones evaluacion) {
        String sql = "UPDATE evaluaciones SET nombre_estudiantes = ?, codigo_estudiantes = ?, correo_estudiantes = ?, " +
                "nota = ?, idcurso = ?, idsemestre = ?, fecha_registro = ?, fecha_edicion = ? WHERE idevaluaciones = ?";

        try (Connection conn = this.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, evaluacion.getNombre_estudiantes());
            pstmt.setString(2, evaluacion.getCodigo_estudiantes());
            pstmt.setString(3, evaluacion.getCorreo_estudiantes());
            pstmt.setInt(4, evaluacion.getNota());
            pstmt.setInt(5, evaluacion.getIdcurso());
            pstmt.setInt(6, evaluacion.getIdsemestre());
            pstmt.setObject(7, evaluacion.getFecha_registro());
            pstmt.setObject(8, evaluacion.getFecha_edicion());
            pstmt.setInt(9, evaluacion.getIdevaluaciones());

            pstmt.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public void borrarEvaluacion(int idEvaluacion) {
        String sql = "DELETE FROM evaluaciones WHERE idevaluaciones = ?";

        try (Connection conn = this.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, idEvaluacion);
            pstmt.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    private Evaluaciones fetchEvaluacionData(ResultSet rs) throws SQLException {
        Evaluaciones evaluacion = new Evaluaciones();
        evaluacion.setIdevaluaciones(rs.getInt("idevaluaciones"));
        evaluacion.setNombre_estudiantes(rs.getString("nombre_estudiantes"));
        evaluacion.setCodigo_estudiantes(rs.getString("codigo_estudiantes"));
        evaluacion.setCorreo_estudiantes(rs.getString("correo_estudiantes"));
        evaluacion.setNota(rs.getInt("nota"));
        evaluacion.setIdcurso(rs.getInt("idcurso"));
        evaluacion.setIdsemestre(rs.getInt("idsemestre"));
        evaluacion.setFecha_registro(rs.getObject("fecha_registro", LocalDateTime.class));
        evaluacion.setFecha_edicion(rs.getObject("fecha_edicion", LocalDateTime.class));
        return evaluacion;
    }
}
