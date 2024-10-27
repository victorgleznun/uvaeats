<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<link rel="stylesheet" href="../css/styleCabeceraComun.css">
<html>

    <header>

        <div class="sup-izquierda">
            <a href="facultad.jsp"><img src="../imagenes/logo.png" alt="Imagen"></a>
            <a id="inicio" href="facultad.jsp"><h1>INICIO</h1></a>
        </div>

        <div class="sup-derecha">
            <%
                int puntos = (int) request.getSession().getAttribute("puntos");
            %>

            <%= puntos%> puntos

            <div class="perfil">
                <img class="imgPerfil" src="../imagenes/perfil.png" alt="Imagen">
                <div class="contenido">
                    <form action="../SvtMiCuenta" method="GET">
                        <button type="submit" class="boton2" name="cuenta">Mi cuenta</button>
                        <button type="submit" class="boton2" name="pedidos">Mis pedidos</button>
                        <button href="index.jsp" class="boton2" name="cerrar">Cerrar sesión</button>
                    </form>
                </div>
            </div>
        </div>
    </header>
</html>