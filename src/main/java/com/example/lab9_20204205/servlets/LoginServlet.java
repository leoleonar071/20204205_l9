package com.example.lab9_20204205.servlets;


import com.example.lab9_20204205.model.beans.Usuario;
import com.example.lab9_20204205.model.daos.UsuarioDao;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "LoginServlet", value = "/LoginServlet")
public class LoginServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession httpSession = request.getSession();
        Usuario UsuarioLooged = (Usuario) httpSession.getAttribute("usuarioLogueado");



        if(UsuarioLooged != null && UsuarioLooged.getIdusuario() > 0){

            if(request.getParameter("a") != null){//logout
                httpSession.invalidate();
            }
            response.sendRedirect(request.getContextPath());
        }else{
            request.getRequestDispatcher("LoginForm.jsp").forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        System.out.println("username: " + username + " | password: " + password);
        UsuarioDao usuarioDao = new UsuarioDao();


        if(usuarioDao.validarPassword(username,password)){
            System.out.println("usuario y password válidos");
            Usuario usuario = usuarioDao.obtenerUsuarioPorCorreo(username);
            HttpSession httpSession = request.getSession();


            httpSession.setAttribute("usuarioLogueado",usuario);



            System.out.println("se registro bien");

            switch (usuario.getIdrol()){
                case 1:
                    response.sendRedirect("Administrador");
                    break;

                case 2:
                    response.sendRedirect("Rector");
                    break;

                case 3:
                    response.sendRedirect("Decano");
                    break;

            }





        }else{
            System.out.println("usuario o password incorrectos");
            request.setAttribute("err","Usuario o password incorrectos");
            request.getRequestDispatcher("LoginForm.jsp").forward(request,response);
            System.out.println("se registro mal");

        }
    }
}
