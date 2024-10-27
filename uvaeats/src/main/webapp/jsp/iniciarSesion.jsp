<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Iniciar Sesión</title>
        <link rel="stylesheet" href="../css/styleIniciarSesion.css?v=1">
    </head>

    <body>
        <header>
            <a href="index.jsp">
                <img class="logo" src="../imagenes/logo.png" width="100" height="100" alt="Logo de la empresa">
            </a>
        </header>

        <div class="contenedor">
            <form action="../SvtIniciarSesion" method="POST">
                <h2>Iniciar Sesión</h2>
                <div class="form-group">
                    <label for="username">Usuario:</label>
                    <input type="text" id="username" name="username">
                </div>
                <div class="form-group">
                    <label for="password">Contraseña:</label>
                    <input type="password" id="password" name="password" >
                </div>
                <%
                    HttpSession misesion = request.getSession();
                    String error = (String) misesion.getAttribute("error");
                    if (error == null) {
                        error = "";
                    }
                %>
                <label for="error"><%=error%></label>
                <a href="facultad.jsp"><button class ="ini" name = "ini">Iniciar Sesión</button></a>
                <a href="crearCuenta.jsp"><button class ="reg" name = "reg">No estoy registrado</button></a> 
            </form>
        </div>
    </body>
</html>