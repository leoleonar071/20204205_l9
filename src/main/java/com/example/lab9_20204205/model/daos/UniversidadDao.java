package com.example.lab9_20204205.model.daos;


import com.example.lab9_20204205.model.beans.Universidad;

import java.sql.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class UniversidadDao extends DaoBase {

    public List<Universidad> listarUniversidades() {
        List<Universidad> listaUniversidades = new ArrayList<>();

        String sql = "SELECT * FROM universidades";

        try (Connection conn = this.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Universidad universidad = fetchUniversidadData(rs);
                listaUniversidades.add(universidad);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return listaUniversidades;
    }

    public Universidad obtenerUniversidad(int idUniversidad) {
        Universidad universidad = null;

        String sql = "SELECT * FROM universidades WHERE idunisversidad = ?";

        try (Connection conn = this.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, idUniversidad);

            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    universidad = fetchUniversidadData(rs);
                }
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return universidad;
    }

    public void guardarUniversidad(Universidad universidad) {
        String sql = "INSERT INTO universidades (nombre, logo_url, idaministrador, fecha_registro, fecha_edicion) " +
                "VALUES (?, ?, ?, ?, ?)";

        try (Connection conn = this.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, universidad.getNombre());
            pstmt.setString(2, universidad.getLogo_url());
            pstmt.setInt(3, universidad.getIdaministrador());
            pstmt.setObject(4, universidad.getFecha_registro());
            pstmt.setObject(5, universidad.getFecha_edicion());

            pstmt.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public void actualizarUniversidad(Universidad universidad) {
        String sql = "UPDATE universidades SET nombre = ?, logo_url = ?, idaministrador = ?, fecha_registro = ?, " +
                "fecha_edicion = ? WHERE idunisversidad = ?";

        try (Connection conn = this.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, universidad.getNombre());
            pstmt.setString(2, universidad.getLogo_url());
            pstmt.setInt(3, universidad.getIdaministrador());
            pstmt.setObject(4, universidad.getFecha_registro());
            pstmt.setObject(5, universidad.getFecha_edicion());
            pstmt.setInt(6, universidad.getIdunisversidad());

            pstmt.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public void borrarUniversidad(int idUniversidad) {
        String sql = "DELETE FROM universidades WHERE idunisversidad = ?";

        try (Connection conn = this.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, idUniversidad);
            pstmt.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    private Universidad fetchUniversidadData(ResultSet rs) throws SQLException {
        Universidad universidad = new Universidad();
        universidad.setIdunisversidad(rs.getInt("idunisversidad"));
        universidad.setNombre(rs.getString("nombre"));
        universidad.setLogo_url(rs.getString("logo_url"));
        universidad.setIdaministrador(rs.getInt("idaministrador"));
        universidad.setFecha_registro(rs.getObject("fecha_registro", LocalDateTime.class));
        universidad.setFecha_edicion(rs.getObject("fecha_edicion", LocalDateTime.class));
        return universidad;
    }
}

