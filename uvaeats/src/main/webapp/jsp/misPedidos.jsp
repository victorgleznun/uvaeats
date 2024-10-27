<%@page import="com.uvaeats.proyectossw.modelo.Pedido"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Historial de Pedidos</title>
        <link rel="stylesheet" href="../css/stylePedidos.css">
    </head>
    <body>

        <%@ include file="cabeceraComun.jsp" %>

        <div id="contenedor">

            <div id="filtros">
                <form action="../SvtMisPedidos" method="POST">
                    <input type="text" id="busqueda" placeholder="Buscar por cafeteria" name = "cafeteria">
                    <select id="estado" name = "estado">
                        <option value="todos">Todos</option>
                        <option value="preparacion">En preparacion</option>
                        <option value="recoger">Listo para recoger</option>
                        <option value="entregado">Entregado</option>
                    </select>
                    <button type = "submit" name = "filtrar" id="filtrar">Filtrar</button>
                </form>
            </div>

            <div id="pedidos">
                <table id="tabla" cellspacing="0" cellpadding="5" style="width: 100%">

                    <tr>
                        <th>Estado</th>
                        <th>Cafeteria</th>
                        <th>Fecha</th>
                        <th>Hora</th>
                    </tr>
                    <%          ArrayList<Pedido> lista = (ArrayList) request.getSession().getAttribute("listaFiltro");
                        for (int i = 0; i < lista.size(); i++) {
                            String descripcion = "Platos: ";
                            for (int j = 0; j<lista.get(i).getListaDetalles().size(); j++){
                                descripcion = descripcion + lista.get(i).getListaDetalles().get(j).getCantidad() + " " 
                                + lista.get(i).getListaDetalles().get(j).getNombre();
                                if (j < lista.get(i).getListaDetalles().size()-1){
                                    descripcion = descripcion + " -- ";
                                }
                            }
                            if (lista.get(i).getListaOfertas() != null) {
                                for (int k = 0; k < lista.get(i).getListaOfertas().size(); k++) {
                                    descripcion = descripcion + " || Ofertas: " + lista.get(i).getListaOfertas().get(k).getNombre();
                                    if (k < lista.get(i).getListaOfertas().size() - 1) {
                                        descripcion = descripcion + " -- ";
                                    }
                                }
                            }
                        
                    %>
                    <tr onclick="mostrarDescripcion('<%= descripcion %>')">
                        <td><%=lista.get(i).getEstado()%></td>
                        <td><%=lista.get(i).getNombreCafeteria()%></td>
                        <td><%=lista.get(i).getFecha()%></td>
                        <td><%=lista.get(i).getHora()%></td>
                    </tr>
                    <%
                        }
                    %>
                </table>
                <!-- Div para mostrar la descripción -->
                <div id="descripcionDiv" style="display:none; position:fixed; top:20%; left:20%; background:white; border:1px solid black; padding:10px; z-index:1000;">
                    <p id="descripcionTexto"></p>
                    <button id="cerrar" onclick="cerrarDescripcion()">Cerrar</button>
                </div>

                <!-- JavaScript para manejar la descripción -->
                <script type="text/javascript">
                function mostrarDescripcion(descripcion) {
                    var descripcionDiv = document.getElementById("descripcionDiv");
                    var descripcionTexto = document.getElementById("descripcionTexto");
                    descripcionTexto.innerText = descripcion;
                    descripcionDiv.style.display = "block";
                }

                function cerrarDescripcion() {
                    var descripcionDiv = document.getElementById("descripcionDiv");
                    descripcionDiv.style.display = "none";
                }
                </script>
            </div>
        </div>
    </body>
</html>
