<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang ="es">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Registro</title> 
        <link rel="stylesheet" href="../css/styleCrearCuenta.css">
    </head>

    <body>
        <header>
            <a href="index.jsp">
                <img class="logo" src="../imagenes/logo.png" width="100" height="100" alt="Logo de la empresa">
            </a>
        </header>

        <div class="contenedor">

            <form action="../SvtCrearCuenta" method="POST">

                <h2>Crear una cuenta</h2>
                <div class="form-group">
                    <label for="nombre">Nombre:</label>
                    <input type="text" id="nombre" name="nombre">
                </div>
                <div class="form-group">
                    <label for="apellidos">Apellidos:</label>
                    <input type="text" id="apellidos" name="apellidos">
                </div>
                <div class="form-group">
                    <label for="email">Email:</label>
                    <input type="email" id="email" name="email">
                </div>
                <div class="form-group">
                    <label for="telefono">Teléfono:</label>
                    <input type="tel" id="telefono" name="telefono">
                </div>
                <div class="form-group">
                    <label for="contrasena">Contraseña:</label>
                    <input type="password" id="contrasena" name="contrasena">
                </div>
                <div class="form-group">
                    <label for="confirmar-contrasena">Confirmar contraseña:</label>
                    <input type="password" id="confirmar-contrasena" name="confirmar-contrasena">
                </div>
                <div class="botones">
                    <a href="iniciarSesion.jsp"><button class ="btn-ya">¿Ya tienes cuenta?</button></a>
                    <button type="submit">Crear cuenta</button></a>
                </div>
            </form>
        </div>
    </body>
</html>
