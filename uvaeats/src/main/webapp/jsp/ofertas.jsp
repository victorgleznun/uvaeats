<%@page import="com.google.gson.Gson"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.uvaeats.proyectossw.modelo.Oferta"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <!DOCTYPE html>
    <html lang="es">
        <head>
            <meta charset="UTF-8">
            <meta name="viewport" content="width=device-width, initial-scale=1.0">
            <title>Ofertas</title>
            <link rel="stylesheet" href="../css/styleOfertas.css?v=2">
        </head>
        <body>

            <%@ include file="cabeceraComun.jsp" %>

            <div id="contenedor">
                <div id="contenido">
                    <h1>Ofertas disponibles en cafetería ciencias</h1>
                    <hr><br>
                    <form id="formulario" action="../SvtOferta" method = "POST">
                        <div id="parte1">
                            <%                                HttpSession misesion = request.getSession();
                                ArrayList<Oferta> lista = (ArrayList) misesion.getAttribute("listaOfertas");
                                for (int i = 0; i < lista.size(); i++) {
                            %>

                            <div>
                                <input type="checkbox" name = "checkbox" value="<%=lista.get(i).getNombre()%>" onclick="updateLabel()"><%=lista.get(i).getNombre()%><br>
                                <label for="checkbox1"><%=lista.get(i).getPuntos()%> puntos</label>
                            </div>
                            <%  }%>  
                        </div>
                        <button class="boton-anadir" type="submit" name="Anadir">Canjear y añadir al pedido</button>
                        <button class="boton-cancelar" type="submit" name="Cancelar">Volver al pedido</button>
                    </form>
                </div>
                <div id="ofertas">
                    <label id="puntos">Puntos restantes: <%=puntos%> puntos</label>
                </div>
                <script>
                    function updateLabel() {
                        const form = document.getElementById('formulario');
                        const checkboxes = form.querySelectorAll('input[type="checkbox"]:checked');
                        var puntos = <%= (Integer) session.getAttribute("puntos")%>;

                        const selectedValues = Array.from(checkboxes).map(checkbox => checkbox.value);
                        var ofertas = <%= new Gson().toJson(lista)%>;

                        let totalPoints = 0;
                        selectedValues.forEach(value => {
                            const oferta = ofertas.find(o => o.nombre === value);
                            if (oferta) {
                                totalPoints += oferta.puntos;
                            }
                        });

                        let remainingPoints = puntos - totalPoints;

                        if (remainingPoints < 0) {
                            // Recalcular los puntos restantes sin las casillas seleccionadas
                            remainingPoints = puntos;

                            // Mostrar mensaje de advertencia
                            alert("No tienes suficientes puntos para estas selecciones.");

                            selectedValues.forEach(oferta => {
                                const checkbox = form.querySelector('input[type="checkbox"][value="' + oferta + '"]');
                                checkbox.checked = false;
                            });
                        }

                        const label = document.getElementById('puntos');
                        label.textContent = 'Puntos restantes: ' + remainingPoints + ' puntos';
                    }
                </script>
            </div>
        </body>
    </html>
</html>
