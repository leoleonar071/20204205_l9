package com.example.lab9_20204205.servlets;
import com.example.lab9_20204205.model.beans.*;
import com.example.lab9_20204205.model.daos.UniversidadDao;
import com.example.lab9_20204205.model.daos.UsuarioDao;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;

@MultipartConfig
@WebServlet(name = "Administrador", value = "/Administrador")

public class AdministradorServlet extends HttpServlet {

    UsuarioDao usuarioDao=new UsuarioDao();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        String action = request.getParameter("action") == null? "lista" : request.getParameter("action");
        RequestDispatcher view;

        switch (action){
            case "lista":

                HttpSession session = request.getSession(); //Estaba en False

                if (session != null) {

                    request.setAttribute("listaRectores", usuarioDao.listarUsuariosConIdRolDos());
                    view = request.getRequestDispatcher("/Administrador/lista.jsp");
                    view.forward(request, response);




                } else {
                    request.getRequestDispatcher("login?action=unvalid_session").forward(request,response);
                }
                break;




            case "agregar_rector":

                request.setAttribute("listarectores", usuarioDao.listarUsuariosConIdRolDos());



                view = request.getRequestDispatcher("/rector/formularioNuevo.jsp");
                view.forward(request, response);



                break;



            case "agregar_univ":





            view = request.getRequestDispatcher("/Administrador/crear_univ.jsp");
            view.forward(request, response);



            break;

            case "edit_rector":
                HttpSession httpSession = request.getSession();

                String correo = request.getParameter("correo");
                Usuario rectorBuscado = usuarioDao.obtenerUsuarioPorCorreo(correo);

                if(rectorBuscado != null){
                    request.setAttribute("rectorBuscado", rectorBuscado);
                    request.getRequestDispatcher("/Administrador/edit_ rector.jsp").forward(request,response);
                }else{
                    response.sendRedirect("rector");
                }


                break;

            case "borrar_rector":
                String correo_rector_eliminar = request.getParameter("correo_decano_eliminar");

                usuarioDao.eliminarUsuarioPorCorreo(correo_rector_eliminar);



                response.sendRedirect("RectorServlet");
                break;





        }
    }



    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String action = request.getParameter("action") == null? "filtros" : request.getParameter("action");
        String ac = request.getParameter("ac") == null? "eventosXfecha" : request.getParameter("ac");
        String idEvento = request.getParameter("idEvento");

        switch (action){




            case "guardar":

                Usuario new_rector=new Usuario();

                new_rector.setNombre(request.getParameter("nombre"));
                new_rector.setCorreo(request.getParameter("correo"));
                new_rector.setPassword(request.getParameter("password"));





                if (request.getParameter("usuario_id") == null) {
                    try {
                        usuarioDao.guardarUsuarioConIdRolTres(new_rector);
                        response.sendRedirect("Administrador?msg=Rector creado exitosamente");
                    } catch (SQLException ex) {
                        response.sendRedirect("Administrador?err=Rector al crear empleado");
                    }
                } else {
                    new_rector.setIdusuario(Integer.parseInt(request.getParameter("usuario_id")));
                    try {
                        usuarioDao.actualizarUsuarioConIdRolTres(new_rector);
                        response.sendRedirect("Administrador?msg=Empleado actualizado exitosamente");
                    } catch (SQLException ex) {
                        response.sendRedirect("Administrador?err=Error al actualizar empleado");
                    }

                }



                break;


            case "guardar_univ":

                Universidad universidad=new Universidad();
                UniversidadDao universidadDao=new UniversidadDao();

                universidad.setNombre(request.getParameter("nombre"));
                universidad.setIdaministrador(4);
                universidad.setLogo_url(request.getParameter("logo"));








                break;








        }
    }
}
