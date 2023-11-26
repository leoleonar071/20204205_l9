package com.example.lab9_20204205.model.daos;


import com.example.lab9_20204205.model.beans.Curso;

import java.sql.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class CursoDao extends DaoBase {

    public List<Curso> listarCursos() {
        List<Curso> listaCursos = new ArrayList<>();

        String sql = "SELECT * FROM curso";

        try (Connection conn = this.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Curso curso = fetchCursoData(rs);
                listaCursos.add(curso);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return listaCursos;
    }

    public Curso obtenerCurso(int idCurso) {
        Curso curso = null;

        String sql = "SELECT * FROM curso WHERE idcurso = ?";

        try (Connection conn = this.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, idCurso);

            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    curso = fetchCursoData(rs);
                }
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return curso;
    }

    public void guardarCurso(Curso curso) {
        String sql = "INSERT INTO curso (codigo, nombre, idfacultad, fecha_registro, fecha_edicion) " +
                "VALUES (?, ?, ?, ?, ?)";

        try (Connection conn = this.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, curso.getCodigo());
            pstmt.setString(2, curso.getNombre());
            pstmt.setInt(3, curso.getIdfacultad());
            pstmt.setObject(4, curso.getFecha_registro());
            pstmt.setObject(5, curso.getFecha_edicion());

            pstmt.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public void actualizarCurso(Curso curso) {
        String sql = "UPDATE curso SET codigo = ?, nombre = ?, idfacultad = ?, fecha_registro = ?, " +
                "fecha_edicion = ? WHERE idcurso = ?";

        try (Connection conn = this.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, curso.getCodigo());
            pstmt.setString(2, curso.getNombre());
            pstmt.setInt(3, curso.getIdfacultad());
            pstmt.setObject(4, curso.getFecha_registro());
            pstmt.setObject(5, curso.getFecha_edicion());
            pstmt.setInt(6, curso.getIdcurso());

            pstmt.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public void borrarCurso(int idCurso) {
        String sql = "DELETE FROM curso WHERE idcurso = ?";

        try (Connection conn = this.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, idCurso);
            pstmt.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    private Curso fetchCursoData(ResultSet rs) throws SQLException {
        Curso curso = new Curso();
        curso.setIdcurso(rs.getInt("idcurso"));
        curso.setCodigo(rs.getString("codigo"));
        curso.setNombre(rs.getString("nombre"));
        curso.setIdfacultad(rs.getInt("idfacultad"));
        curso.setFecha_registro(rs.getObject("fecha_registro", LocalDateTime.class));
        curso.setFecha_edicion(rs.getObject("fecha_edicion", LocalDateTime.class));
        return curso;
    }
}

