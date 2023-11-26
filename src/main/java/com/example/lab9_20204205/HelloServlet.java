package com.example.lab9_20204205;

import java.io.*;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;


@WebServlet(name = "helloServlet", value = "/hello-servlet")
public class HelloServlet extends HttpServlet {
    private String message;

    public void init() {
        message = "Hello Woraaald!";
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        // Obtener un RequestDispatcher para tu JSP
        RequestDispatcher dispatcher = request.getRequestDispatcher("/.jsp");

        // Reenviar la solicitud al archivo JSP
    }

    public void destroy() {
    }
}