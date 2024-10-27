<%@page import="com.uvaeats.proyectossw.modelo.Cafeteria"%>
<%@page import="com.google.gson.Gson"%>
<%@page import="com.uvaeats.proyectossw.modelo.Facultad"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Añadir ofertas</title>
        <link rel="stylesheet" href="../css/styleAnadirAdmin.css?v=2">
    </head>
    <body>
        <%@ include file="cabeceraAdmin.jsp" %>
        <div class="centro">
            <h1>AÑADIR OFERTAS</h1>
            <form action ="../SvtAgregarOferta" method ="POST">
                <div class="campo">
                    <label for="nombre">Nombre oferta:</label>
                    <input type="text" id="nombre" placeholder="Nombre oferta" name="nombre">
                </div>
                <div class="campo">
                    <label for="puntos">Puntos:</label>
                    <input type="text" id="puntos" placeholder="Puntos" name="puntos">
                </div> 
                <div class="campo">
                    <label for="disponible">Disponible:</label>
                    <input type="checkbox" id="disponible" name="disponible">
                </div>
                <div class="campo">
                    <label for="puntos">Cafeteria:</label>
                    <select name="cafeteria" id="cafeteria">
                        <option selected="true" disabled="disabled">Seleccione cafeteria</option>
                    <%ArrayList<Facultad> facultades = (ArrayList) request.getSession().getAttribute("listaFacultades");%>
                    <%
                        for (Facultad facultad : facultades) {
                            for (Cafeteria cafeteria : facultad.getCafeterias()){
  
                    %>
                    <option value="<%=cafeteria.getNombre()%>"> <%=cafeteria.getNombre()%></option>
                    <%      }
                        }%>
                    </select>
                </div>
                <div class="pedido">
                    <button class="boton-cancelar" type="submit" name="cancelar">Cancelar</button>
                    <button class="boton-anadir" type="submit" name="anadir">Añadir</button>
                </div>
            </form>
        </div>
    </body>
</html>