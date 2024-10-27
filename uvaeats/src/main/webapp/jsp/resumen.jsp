<%@page import="java.math.RoundingMode"%>
<%@page import="java.math.BigDecimal"%>
<%@page import="java.util.Arrays"%>
<%@page import="java.util.List"%>
<%@page import="com.uvaeats.proyectossw.modelo.Oferta"%>
<%@page import="com.uvaeats.proyectossw.modelo.Plato"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Resumen pedido</title>
        <link rel="stylesheet" href="../css/styleResumen.css">
    </head>
    <body>

        <%@ include file="cabeceraComun.jsp" %>

        <div class="centro">
            <div class="izquierda">
                <h2>Resumen del pedido:</h2>
                <ul id="lista">
                    <%        ArrayList<Plato> platos = (ArrayList) request.getSession().getAttribute("platos");
                        ArrayList<String> valores = (ArrayList) request.getSession().getAttribute("valores");
                        String[] ofertasSeleccionadas = (String[]) request.getSession().getAttribute("ofertasSeleccionadas");
                        List<Oferta> ofertas = (List<Oferta>) request.getSession().getAttribute("listaOfertas");
                        request.getSession().setAttribute("totalPuntos", 0);
                        BigDecimal totalDinero = BigDecimal.ZERO;
                        int totalPuntos = 0;

                        for (int i = 0; i < platos.size(); i++) {
                            BigDecimal valor = new BigDecimal(valores.get(i));
                            BigDecimal precio = BigDecimal.valueOf(platos.get(i).getPrecio());
                            BigDecimal mult = valor.multiply(precio).setScale(2, RoundingMode.HALF_UP);
                            totalDinero = totalDinero.add(mult);
                            double totalDineroD = totalDinero.doubleValue();
                    %>
                    <li> <%=valores.get(i)%> <%=platos.get(i).getNombre()%> - <%=mult.toString()%>€ </li>
                        <%
                                request.getSession().setAttribute("total", totalDineroD);
                            }
                        %>
                <%if (ofertasSeleccionadas != null && ofertas != null) {
                        for (Oferta oferta : ofertas) {
                            if (Arrays.asList(ofertasSeleccionadas).contains(oferta.getNombre())) {
                                totalPuntos += oferta.getPuntos();%>
                <li> <%=oferta.getNombre()%> - <%=oferta.getPuntos()%> puntos </li>
                    <%          }
                            }
                            request.getSession().setAttribute("totalPuntos", totalPuntos);
                        }%>
                <li><hr></li>
                <li>Total del pedido - <%=totalDinero%>€</li>
                <li>Puntos a gastar - <%=totalPuntos%> puntos</li>
                </ul>

                <script>
                    var lista = document.getElementById('lista');
                    var elementos = lista.getElementsByTagName('li');
                    for (var i = 0; i < elementos.length; i++) {
                        var texto = elementos[i].innerText;
                        if (texto.startsWith('0')) {
                            elementos[i].style.display = 'none';
                        }
                    }
                </script>      

            </div>
            <div class="derecha">
                <h2>Forma de Pago:</h2>
                <form action="../SvtResumen" method="POST">
                    <input type="radio" id="efectivo" name="pago" value="efectivo">
                    <label for="efectivo">Pago en efectivo</label><br><br>
                    <input type="radio" id="tarjeta" name="pago" value="tarjeta">
                    <label for="tarjeta">Pago con tarjeta</label><br>
                    <button class="boton-Finalizar" type="submit" name="Finalizar">Finalizar Pedido</button></a><br>
                    <button class="boton-Cancelar" type="submit" name="Cancelar">Cancelar Pedido</button></a>
                </form>
            </div>
        </div>
    </body>
</html>
