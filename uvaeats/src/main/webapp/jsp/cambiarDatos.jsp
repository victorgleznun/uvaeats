<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang ="es">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Cambiar datos</title>
        <link rel="stylesheet" href="../css/styleCambiarDatos.css">
    </head>
    <body>

        <%@ include file="cabeceraComun.jsp" %>

        <div class="recuadro">
            <form action="../SvtCambiarDatos" method="POST">
                <h1 id="cambiarDatos">Cambiar datos</h1>
                <label for="nombre">Nuevo nombre:</label><br>
                <input type="text" id="nombre" name="nombre" value =""><br>
                <label for="apellidos">Nuevos apellidos:</label><br>
                <input type="text" id="apellidos" name="apellidos" value = ""><br>
                <label for="telefono">Nuevo teléfono:</label><br>
                <input type="tel" id="telefono" name="telefono" value = ""><br><br>
                <button class="confirmarCambios" type =submit name = "conf">Confirmar cambios</button>
                <a href="miCuenta.jsp"><button class="cancelarCambios" >Cancelar Cambios</button></a>
            </form>
        </div>
    </body>
</html>
