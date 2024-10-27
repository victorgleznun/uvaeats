<%@page import="com.uvaeats.proyectossw.modelo.Pedido"%>
<%@page import="com.google.gson.Gson"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Actualizar estados de pedidos</title>
        <link rel="stylesheet" href="../css/styleActualizarEstado.css?v=1">
    </head>
    <body>

        <header>

            <div class="sup-izquierda">
                <a><img src="../imagenes/logo.png" alt="Imagen"></a>
                <a id="inicio" ><h1>Modo Cafeteria</h1></a>
            </div>

            <div class="sup-derecha">

                <div class="perfil">
                    <img class="imgPerfil" src="../imagenes/perfil.png" alt="Imagen">
                    <div class="contenido">

                        <form action="index.jsp" method="GET">
                            <button type="submit" class="boton2" name="cerrar">Cerrar sesión</button>
                        </form>
                        <form action="cafeteriasAdmin.jsp" method="GET">
                        </form>

                    </div>
                </div>
            </div>
        </header>

        <div class="centro">
            <form action="../SvtActualizarEstado" method = "POST">
                <h1>GESTIONAR PEDIDOS</h1>
                <div class="campo">
                    <%ArrayList<Pedido> pedidos = (ArrayList) request.getSession().getAttribute("listaPedidos");%>
                    <label for="idPedido">Introduce id del pedido:</label>
                    <select name="pedido" id="idPedido" onchange="actualizarDatosPedido()" >
                        <option selected="true" disabled="disabled">Seleccione pedido</option>
                        <%
                            for (Pedido pedido : pedidos) {
                        %>
                        <option value="<%=pedido.getId()%>"> <%=pedido.getId()%></option>
                        <%}%>
                    </select>
                </div>
                <div class="campo">
                    <label for="datosPedido">Datos del pedido:</label>
                    <textarea id="datosPedido" placeholder="Datos del pedido" name="datosPedido"></textarea>

                    <script>
                        function actualizarDatosPedido() {
                            var PedidoSeleccionado = document.getElementById('idPedido').value;
                            console.log(PedidoSeleccionado);
                            var pedidos = <%= new Gson().toJson(pedidos)%>;
                            var pedidoObject = pedidos.find(p => p.id === parseInt(PedidoSeleccionado));
                            console.log(pedidoObject);
                            
                            // Limpiar los datos pedido
                            document.getElementById("datosPedido").value = '';
                            
                            // Rellenar los datos del pedido
                            var texto = "Pedido: " + pedidoObject.id + " de " + pedidoObject.email + " con coste de " + pedidoObject.precio + "€ y estado " + pedidoObject.estado;
                            document.getElementById("datosPedido").value = texto;
                        }
                    </script>

                </div>
                <div class="campo">
                    <label for="estados">Elija un estado:</label>
                    <select id="estados" name="estados">
                        <option selected="true" disabled="disabled">Seleccione nuevo estado</option>
                        <option value="EnPreparacion">EnPreparacion</option>
                        <option value="ListoParaRecoger">ListoParaRecoger</option>
                        <option value="Entregado">Entregado</option>
                    </select>
                </div>

                <div class="pedido">
                    <button class="boton-actualizar" type="submit" name="actualizarE">Actualizar</button>
                </div>
            </form>
        </div>
    </body>
</html>

