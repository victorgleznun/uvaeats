<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Mi Cuenta</title>
        <link rel="stylesheet" href="../css/styleMiCuenta.css">
    </head>

    <body>
        <%@ include file="cabeceraComun.jsp" %>

        <div class="recuadro">
            <h1>Mi Cuenta</h1>
            <div id="formulario">
                <%                String nombre = (String) request.getSession().getAttribute("nombre");
                    String apellidos = (String) request.getSession().getAttribute("apellidos");
                    String email = (String) request.getSession().getAttribute("email");
                    String telefono = (String) request.getSession().getAttribute("telefono");
                %>
                <label for="nombre">Nombre:</label><br>
                <input type="text" id="nombre" name="nombre" value="<%=nombre%>"readonly><br>
                <label for="apellidos">Apellidos:</label><br>
                <input type="text" id="apellidos" name="apellidos" value="<%=apellidos%>"readonly><br>
                <label for="email">Email:</label><br>
                <input type="email" id="email" name="email" value="<%=email%>"readonly><br>
                <label for="telefono">Teléfono:</label><br>
                <input type="tel" id="telefono" name="telefono" value="<%=telefono%>"readonly><br><br>
                <a href="cambiarDatos.jsp"><button class="cambiarDatos">Cambiar datos</button></a>
            </div>
        </div>
    </body>
</html>
