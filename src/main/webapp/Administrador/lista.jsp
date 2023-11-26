<%@page import="java.util.ArrayList" %>
<%@ page import="com.example.lab9_20204205.model.beans.Usuario" %>
<%@page contentType="text/html" pageEncoding="UTF-8" %>
<jsp:useBean id="listaRectores" type="java.util.ArrayList<com.example.lab9_20204205.model.beans.Usuario>" scope="request"/>
<jsp:useBean id="usuarioLogueado" class="com.example.lab9_20204205.model.beans.Usuario" type="com.example.lab9_20204205.model.beans.Usuario" scope="session" />
<!DOCTYPE html>
<html>
<head>
    <title>Lista Rectores</title>
    <jsp:include page="../includes/headCss.jsp"></jsp:include>
</head>
<body>
<div class='container'>
    <jsp:include page="../includes/navbarAdministrador.jsp">
        <jsp:param name="currentPage" value="emp"/>
    </jsp:include>
    <div class="row mb-5 mt-4">
        <div class="col-md-7">
            <h1>Lista de Rectores</h1>
        </div>
        <div class="col-md-5 col-lg-4 ms-auto my-auto text-md-end">
            <a href="<%= request.getContextPath()%>/rector?action=agregar_decano" class="btn btn-primary">Agregar
                nuevo Decano</a>
        </div>
    </div>
    <% if (request.getParameter("msg") != null) {%>
    <div class="alert alert-success" role="alert"><%=request.getParameter("msg")%>
    </div>
    <% } %>
    <% if (request.getParameter("err") != null) {%>
    <div class="alert alert-danger" role="alert"><%=request.getParameter("err")%>
    </div>
    <% } %>

    <table class="table">
        <thead>
        <tr>
            <th>#</th>
            <th>Nombre de Decano</th>
            <th>Email</th>
            <th>fecha_registro</th>
            <th>fecha_edicion</th>

            <% if(usuarioLogueado != null && usuarioLogueado.getIdusuario() > 0) {%>
            <th></th>
            <th></th>
            <% } %>
        </tr>
        </thead>
        <tbody>
        <%
            int i = 1;
            for (Usuario e : listaRectores) {
        %>
        <tr>
            <td><%= i%>
            </td>
            <td><%= e.getNombre() %>
            </td>
            <td><%= e.getCorreo()%>
            </td>
            <td><%= e.getFecha_edicion()%>
            </td>
            <td><%= e.getFecha_registro()%>
            </td>

            <% if(usuarioLogueado != null && usuarioLogueado.getIdusuario() > 0) {%>
            <td>
                <a href="<%=request.getContextPath()%>/rector?action=editar&id=<%= e.getCorreo()%>"
                   type="button" class="btn btn-primary">
                    <i class="bi bi-pencil-square"></i>
                </a>
            </td>
            <td>
                <a onclick="return confirm('¿Estas seguro de borrar?');"
                   href="<%=request.getContextPath()%>/rector?action=editar&id=<%= e.getCorreo()%>"
                   type="button" class="btn btn-danger">
                    <i class="bi bi-trash"></i>
                </a>
            </td>
            <% } %>
        </tr>
        <%
                i++;
            }
        %>
        </tbody>
    </table>
    <jsp:include page="../includes/footer.jsp"/>
</div>
</body>
</html>
