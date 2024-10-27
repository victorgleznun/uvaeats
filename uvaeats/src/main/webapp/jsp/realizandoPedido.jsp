<%@page import="com.uvaeats.proyectossw.modelo.Plato"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.Arrays"%>
<%@page import="com.uvaeats.proyectossw.modelo.Oferta"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Pedido</title>
        <link rel="stylesheet" href="../css/stylePedido.css">
    </head>
    <body>

        <%@ include file="cabeceraComun.jsp" %>

        <div id="contenedor">
            <div id="contenido">
                <h1>Selecciona la cantidad de cada elemento:</h1>
                <hr><br>
                <h2>Platos y refrescos:</h2>
                <form action="../SvtRealizandoPedido" method="GET">
                    <%  String errorPedido = (String)request.getSession().getAttribute("errorPedido");
                        if (errorPedido == null){
                            errorPedido = "";
                        }
                        ArrayList<Plato> platos = (ArrayList) request.getSession().getAttribute("platos");
                        for (Plato plato : platos) {
                    %>
                    <div>
                        <label for="elemento1"><%=plato.getNombre()%> (<%=plato.getIngredientes()%>) --- <%=plato.getPrecio()%>€ :  </label>
                        <input type="number" min="0" name="<%=plato.getNombre()%>" value="0">
                    </div>
                    <%  }%>
                    <label name ="error"><%= errorPedido%></label>
                    <button type="submit" class="boton-pedido">Proceder al pago</button></a>
                    <button type="submit" name = "ofertas" class="boton-pedido">Ver ofertas</button></a>
                </form>
            </div>

            <div id="ofertas">
                <h1>Ofertas añadidas:</h1>
                <hr>
                <ul>
                    <%  String[] ofertasSeleccionadas = (String[]) request.getSession().getAttribute("ofertasSeleccionadas");
                        List<Oferta> ofertas = (List<Oferta>) request.getSession().getAttribute("listaOfertas");
                        if (ofertasSeleccionadas != null && ofertas != null) {
                            for (Oferta oferta : ofertas) {
                                if (Arrays.asList(ofertasSeleccionadas).contains(oferta.getNombre())) {
                    %>
                    <li><%=oferta.getNombre()%> --- <%=oferta.getPuntos()%> puntos</li>
                        <%
                                    }
                                }
                            }
                        %>
                </ul>
            </div>
        </div>
    </body>
</html>
