<%@page import="com.google.gson.Gson"%>
<%@page import="com.uvaeats.proyectossw.modelo.Facultad"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Añadir cafeterías</title>
        <link rel="stylesheet" href="../css/styleAnadirAdmin.css?v=2">
    </head>
    <body>
        <%@ include file="cabeceraAdmin.jsp" %>
        <div class="centro">
            <h1>AÑADIR CAFETERIA</h1>
            <form action ="../SvtAgregarCafeteria" method ="POST">
                <div class="campo">
                    <label for="horaApertura">Hora Apertura:</label>
                    <input type="time" id="horaApertura" placeholder="Hora Apertura" name="horaApertura">
                </div>
                <div class="campo">
                    <label for="horaCierre">Hora Cierre:</label>
                    <input type="time" id="horaCierre" placeholder="Hora Cierre" name="horaCierre">
                </div> 
                <div class="campo">
                    <label for="nombreCafeteria">Nombre Cafetería:</label>
                    <input type="text" id="nombreCafeteria" placeholder="Nombre Cafeteria" name="nombreCafeteria">
                </div>
                <div class="campo">
                    <label for="direccion">Dirección:</label>
                    <input type="text" id="direccion" placeholder="Dirección" name="direccion">
                </div>
                <div class="campo">
                    <label for="telefono">Teléfono:</label>
                    <input type="text" id="telefono" placeholder="Teléfono" name="telefono">
                </div>
                <div class="campo">
                    <label for="puntos">Facultad:</label>
                    <select name="facultad" id="facultad">
                        <option selected="true" disabled="disabled">Seleccione facultad</option>
                        <%ArrayList<Facultad> facultades = (ArrayList) request.getSession().getAttribute("listaFacultades");%>
                        <%
                            for (Facultad facultad : facultades) {
                        %>
                        <option value="<%=facultad.getNombre()%>"> <%=facultad.getNombre()%></option>
                        <%}%>
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