<%@page import="com.google.gson.Gson"%>
<%@page import="com.uvaeats.proyectossw.modelo.Facultad"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Formulario de Facultades y Cafeterías</title>
    <link rel="stylesheet" href="../css/stylePlatosAdmin.css?v=2">
</head>
<body>
    <%@ include file="cabeceraAdmin.jsp" %>
    <div class="centro">
        <form action="../SvtActualizarPlatos" method = "POST">
            <h1>GESTIONAR PLATOS</h1>
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
            <select name="cafeteria" id="cafeteria" onchange="actualizarPlatos()">
                <option selected="true" disabled="disabled">Seleccione cafetería</option>
            </select>
            
            <h2>Seleccionar plato:</h2>
            <select name="plato" id="plato" onchange="actualizarEtiquetas()">
                <option selected="true" disabled="disabled"> Seleccione plato </option>
            </select>

        <button class="boton-eliminar" type="submit" name="borrar">Borrar</button>
        <button class="boton-anadir" type="submit" name="anadirP">Añadir</button>
            <div class="pedido">
                <%
                    String error = (String) session.getAttribute("errorFacultad");
                    if (error == null) {
                        error = "";
                    }
                %>
                <label id="error"><%=error%></label>
            </div>
        </form>
    </div>
    <script>
        function actualizarCafeterias() {
            var facultadSeleccionada = document.getElementById('facultad').value;
            document.getElementById('error').textContent = "";

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
        function actualizarPlatos() {
            var facultadSeleccionada = document.getElementById('facultad').value;
            var cafeteriaSeleccionada = document.getElementById('cafeteria').value;

            var facultades = <%= new Gson().toJson(facultades)%>;

            var facultadObject = facultades.find(f => f.nombre === facultadSeleccionada);
            var cafeteriaObject = facultadObject.cafeterias.find(c => c.nombre === cafeteriaSeleccionada);
            
            // Limpiar el select de cafeterías
            var selectPlatos = document.getElementById('plato');
            selectPlatos.innerHTML = '<option selected="true" disabled="disabled">Seleccione plato</option>';
            
            cafeteriaObject.listaPlatos.forEach(selectPlatos => {
                var option = document.createElement('option');
                option.value = selectPlatos.nombre;
                option.textContent = selectPlatos.nombre;
                plato.appendChild(option);
            });
        }
    </script>
</body>
</html>