<%@page import="com.google.gson.Gson"%>
<%@page import="com.uvaeats.proyectossw.modelo.Facultad"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang ="es">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Elección cafetería</title>
        <link rel="stylesheet" href="../css/styleFacultad.css">
    </head>
    <body>

        <%@ include file="cabeceraComun.jsp" %>

        <div class="centro">
            <form action="../SvtFacultad" method = "POST">
                <h2>Seleccionar facultad:</h2>
                <%ArrayList<Facultad> facultades = (ArrayList) request.getSession().getAttribute("listaFacultades");%>
                <select name="facultad" id="facultad" onchange="actualizarCafeterias()">
                    <option selected="true" disabled="disabled">Seleccione facultad</option>
                    <%
                        for (Facultad facultad : facultades) {
                    %>
                    <option value="<%=facultad.getNombre()%>"> <%=facultad.getNombre()%></option>
                    <%}%>
                </select>
                <h2>Seleccionar cafetería:</h2>
                <select name="cafeteria" id="cafeteria" onchange="actualizarEtiquetas()">
                    <option selected="true" disabled="disabled">Seleccione cafetería</option>
                </select>
                <div class="pedido">
                    <label id="horaApertura"></label>
                    <label id="horaCierre"></label>
                    <%
                        String error = (String) session.getAttribute("errorFacultad");
                        if (error == null){
                            error = "";
                        }
                    %>
                    <label id="error"><%=error%></label>
                    <button class="boton-pedido" type="submit" name="pedido">Hacer Pedido</button></a>
                </div>
            </form>
        </div>
        <script>
            function actualizarCafeterias() {
                var facultadSeleccionada = document.getElementById('facultad').value;
                document.getElementById('horaApertura').textContent="";
                document.getElementById('horaCierre').textContent="";
                document.getElementById('error').textContent="";

                var facultades = <%= new Gson().toJson(facultades)%>;

                var facultadObject = facultades.find(f => f.nombre === facultadSeleccionada);

                // Limpiar el select de cafeterías
                var selectCafeteria = document.getElementById('cafeteria');
                selectCafeteria.innerHTML = '<option selected="true" disabled="disabled">Seleccione cafetería</option>';

                // Rellenar el select de cafeterías con las cafeterías de la facultad seleccionada
                facultadObject.cafeterias.forEach(selectCafeteria => {
                    var option = document.createElement('option');
                    option.value = selectCafeteria.nombre;
                    option.textContent = selectCafeteria.nombre;
                    cafeteria.appendChild(option);
                });
            }

            // Función para actualizar las etiquetas según la opción seleccionada
            function actualizarEtiquetas() {
                var facultadSeleccionada = document.getElementById('facultad').value;
                var cafeteriaSeleccionada = document.getElementById('cafeteria').value;
                
                var facultades = <%= new Gson().toJson(facultades)%>;
                
                var facultadObject = facultades.find(f => f.nombre === facultadSeleccionada);
                var cafeteriaObject = facultadObject.cafeterias.find(c => c.nombre === cafeteriaSeleccionada);
                
                var horarioApertura = cafeteriaObject.horarioApertura;
                var horarioCierre = cafeteriaObject.horarioCierre;
                
                var horaAperturaString = convertirLocalTimeATexto(horarioApertura);
                var horaCierreString = convertirLocalTimeATexto(horarioCierre);

                // Actualizar el texto de la etiqueta con el horario de apertura y cierre de la facultad seleccionada
                document.getElementById('horaApertura').textContent = "Horario de apertura: " + horaAperturaString;
                document.getElementById('horaCierre').textContent = "Horario de cierre: " + horaCierreString;
            }
            
           function convertirLocalTimeATexto(localTime) {
                var hora = ('0' + localTime.hour).slice(-2);
                var minutos = ('0' + localTime.minute).slice(-2);
                return hora + ":" + minutos;
}

        </script>
    </body>
</html>
