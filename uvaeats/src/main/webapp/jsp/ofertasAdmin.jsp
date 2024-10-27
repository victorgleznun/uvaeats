<%@page import="com.google.gson.Gson"%>
<%@page import="com.uvaeats.proyectossw.modelo.Facultad"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Formulario de Ofertas</title>
        <link rel="stylesheet" href="../css/stylePlatosAdmin.css?v=2">
    </head>
    <body>
        <%@ include file="cabeceraAdmin.jsp" %>
        <div class="centro">
            <form action="../SvtActualizarOferta" method = "POST">
                <h1>GESTIONAR OFERTAS</h1>
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
                <select name="cafeteria" id="cafeteria" onchange="actualizarOfertas()">
                    <option selected="true" disabled="disabled">Seleccione cafetería</option>
                </select>

                <h2>Seleccionar oferta:</h2>
                <select name="oferta" id="oferta">
                    <option selected="true" disabled="disabled"> Seleccione oferta </option>
                </select>

                <button class="boton-eliminar" type="submit" name="borrar">Borrar</button>
                <button class="boton-anadir" type="submit" name="anadirO">Añadir</button>
            </form>
        </div>
        <script>
            function actualizarCafeterias() {
                var facultadSeleccionada = document.getElementById('facultad').value;

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
            
            function actualizarOfertas() {
                var facultadSeleccionada = document.getElementById('facultad').value;
                var cafeteriaSeleccionada = document.getElementById('cafeteria').value;

                var facultades = <%= new Gson().toJson(facultades)%>;

                var facultadObject = facultades.find(f => f.nombre === facultadSeleccionada);
                 var cafeteriaObject = facultadObject.cafeterias.find(c => c.nombre === cafeteriaSeleccionada);

                // Limpiar el select de cafeterías
                var selectOferta = document.getElementById('oferta');
                selectOferta.innerHTML = '<option selected="true" disabled="disabled">Seleccione oferta</option>';

                // Rellenar el select de cafeterías con las cafeterías de la facultad seleccionada
                cafeteriaObject.listaOfertas.forEach(selectOferta => {
                    var option = document.createElement('option');
                    option.value = selectOferta.nombre;
                    option.textContent = selectOferta.nombre;
                    oferta.appendChild(option);
                });
            }
        </script>
    </body>
</html>