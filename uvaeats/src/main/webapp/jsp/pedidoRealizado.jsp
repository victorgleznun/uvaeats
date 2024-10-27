<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Pedido Realizado</title>
        <link rel="stylesheet" href="../css/stylePedidoRealizado.css">
    </head>

    <body>

        <%@ include file="cabeceraComun.jsp" %>

        <div class="container">
            <img src="../imagenes/tick.png" width="280" height="280" alt="Imagen tick">
            <h1>Pedido Realizado con éxito</h1>
            <%
                String fecha = (String) request.getSession().getAttribute("fechaPedido");
                String hora = (String) request.getSession().getAttribute("horaPedido");
                String cafeteria = (String) request.getSession().getAttribute("cafeteria");
                int puntosActuales = (Integer) request.getSession().getAttribute("puntos"); 
                int puntosGanados = (Integer) request.getSession().getAttribute("puntosGanados"); 
            %>
            <h1>Recogida aproximada: <%=hora%> <%=fecha%></h1>
            <p>- <%=cafeteria%> -</p>
            <p id ="puntos">Has ganado <%=puntosGanados%> puntos -> Puntos actuales: <%=puntosActuales%></p>
            <a href="facultad.jsp" class="boton">Volver a la página principal</a>
            <form action = "../SvtMiCuenta" method = "GET">
                <button class="boton" type = "submit" name = "pedidos">Mis pedidos</button>
            </form>
        </div>
    </body>
</html>
