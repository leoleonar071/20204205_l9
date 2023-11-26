package com.example.lab9_20204205.model.daos;

import com.example.lab9_20204205.model.beans.Usuario;

import java.sql.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class UsuarioDao extends DaoBase{


    // Funciones para usuarios con idrol=3 , decanos

    public List<Usuario> listarUsuariosConIdRolTres() {
        List<Usuario> usuarios = new ArrayList<>();
        String sql = "SELECT * FROM usuario WHERE idrol = 3";
        try (Connection conn = this.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Usuario usuario = fetchUsuarioData(rs);
                usuarios.add(usuario);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return usuarios;
    }

    public void guardarUsuarioConIdRolTres(Usuario usuario) throws SQLException {
        String sql = "INSERT INTO usuarios (nombre, correo, password, fecha_registro, idrol) "
                + "VALUES (?, ?, ?, ?, 3)";
        try (Connection conn = this.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            setUsuarioParams(pstmt, usuario);
            pstmt.executeUpdate();
        }
    }

    public void actualizarUsuarioConIdRolTres(Usuario usuario) throws SQLException {
        String sql = "UPDATE usuarios SET nombre = ?, correo = ?, password = ?, fecha_edicion = ? "
                + "WHERE idusuario = ? AND idrol = 3";
        try (Connection conn = this.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            setUsuarioParams(pstmt, usuario);
            pstmt.setInt(5, usuario.getIdusuario());
            pstmt.executeUpdate();
        }
    }

    // Funciones para usuarios con idrol=4

    public List<Usuario> listarUsuariosConIdRolCuatro() {
        List<Usuario> usuarios = new ArrayList<>();
        String sql = "SELECT * FROM usuarios WHERE idrol = 4";
        try (Connection conn = this.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Usuario usuario = fetchUsuarioData(rs);
                usuarios.add(usuario);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return usuarios;
    }

    public void guardarUsuarioConIdRolCuatro(Usuario usuario) throws SQLException {
        String sql = "INSERT INTO usuarios (nombre, correo, password, fecha_registro, idrol) "
                + "VALUES (?, ?, ?, ?, 4)";
        try (Connection conn = this.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            setUsuarioParams(pstmt, usuario);
            pstmt.executeUpdate();
        }
    }

    public void actualizarUsuarioConIdRolCuatro(Usuario usuario) throws SQLException {
        String sql = "UPDATE usuarios SET nombre = ?, correo = ?, password = ?, fecha_edicion = ? "
                + "WHERE idusuario = ? AND idrol = 4";
        try (Connection conn = this.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            setUsuarioParams(pstmt, usuario);
            pstmt.setInt(5, usuario.getIdusuario());
            pstmt.executeUpdate();
        }
    }



    public Usuario obtenerUsuarioPorCorreo(String correo) {
        Usuario usuario = null;

        String sql = "SELECT * FROM usuarios WHERE correo = ?";

        try (Connection conn = this.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, correo);

            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    usuario = fetchUsuarioData(rs);
                }
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return usuario;
    }



    private void setUsuarioParams(PreparedStatement pstmt, Usuario usuario) throws SQLException {
        pstmt.setString(1, usuario.getNombre());
        pstmt.setString(2, usuario.getCorreo());
        pstmt.setString(3, usuario.getPassword());
        pstmt.setObject(4, usuario.getFecha_edicion(), Types.TIMESTAMP);
    }

    private Usuario fetchUsuarioData(ResultSet rs) throws SQLException {
        Usuario usuario = new Usuario();
        usuario.setIdusuario(rs.getInt("idusuario"));
        usuario.setNombre(rs.getString("nombre"));
        usuario.setCorreo(rs.getString("correo"));
        usuario.setPassword(rs.getString("password"));
        usuario.setFecha_registro(rs.getObject("fecha_registro", LocalDateTime.class));
        usuario.setFecha_edicion(rs.getObject("fecha_edicion", LocalDateTime.class));
        usuario.setIdrol(rs.getInt("idrol"));
        return usuario;
    }










    public boolean validarPassword(String correo, String password) {
        String sql = "SELECT * FROM usuarios WHERE correo = ? AND password = ?";
        boolean exito = false;
        try (Connection conn = this.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, correo);
            pstmt.setString(2, password);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    exito = true;
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return exito;
    }
}
