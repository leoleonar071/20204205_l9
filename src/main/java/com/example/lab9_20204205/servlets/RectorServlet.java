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
@WebServlet(name = "rector", value = "/rector")


public class RectorServlet extends HttpServlet{

    UsuarioDao usuarioDao=new UsuarioDao();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        String action = request.getParameter("action") == null? "lista" : request.getParameter("action");
        RequestDispatcher view;

        switch (action){
            case "lista":

                HttpSession session = request.getSession(); //Estaba en False

                if (session != null) {

                    request.setAttribute("listaDecanos", usuarioDao.listarUsuariosConIdRolTres());
                    view = request.getRequestDispatcher("/rector/lista.jsp");
                    view.forward(request, response);




                } else {
                    request.getRequestDispatcher("login?action=unvalid_session").forward(request,response);
                }
                break;


            case "lista_facultades":



                UniversidadDao universidadDao=new UniversidadDao();
                request.setAttribute("listar_facultades", universidadDao.listarfacultades());
                view = request.getRequestDispatcher("/rector/facultades.jsp");
                view.forward(request, response);





                break;

            case "agregar_decano":

                request.setAttribute("listadecanos", usuarioDao.listarUsuariosConIdRolTres());



                view = request.getRequestDispatcher("/rector/crear_decano.jsp");
                view.forward(request, response);


                request.getRequestDispatcher("rector/lista.jsp").forward(request,response);

                break;

            case "edit_decano":
                HttpSession httpSession = request.getSession();

                String correo = request.getParameter("correo");
                Usuario rectorBuscado = usuarioDao.obtenerUsuarioPorCorreo(correo);

                if(rectorBuscado != null){
                    request.setAttribute("rectorBuscado", rectorBuscado);
                    request.getRequestDispatcher("/rector/edit_ decano.jsp").forward(request,response);
                }else{
                    response.sendRedirect("rector");
                }


                break;

            case "borrar_decano":
                String correo_decano_eliminar = request.getParameter("correo_decano_eliminar");

                usuarioDao.eliminarUsuarioPorCorreo(correo_decano_eliminar);



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

                Usuario new_decano=new Usuario();

                new_decano.setNombre(request.getParameter("nombre"));
                new_decano.setCorreo(request.getParameter("correo"));
                new_decano.setPassword(request.getParameter("password"));





                if (request.getParameter("usuario_id") == null) {
                try {
                    usuarioDao.guardarUsuarioConIdRolTres(new_decano);
                    response.sendRedirect("rector?msg=Decano creado exitosamente");
                } catch (SQLException ex) {
                    response.sendRedirect("rector?err=Decano al crear empleado");
                }
                } else {
                     new_decano.setIdusuario(Integer.parseInt(request.getParameter("usuario_id")));
                    try {
                        usuarioDao.actualizarUsuarioConIdRolTres(new_decano);
                        response.sendRedirect("rector?msg=Empleado actualizado exitosamente");
                    } catch (SQLException ex) {
                        response.sendRedirect("rector?err=Error al actualizar empleado");
                    }

                }



                break;








        }
    }














}
