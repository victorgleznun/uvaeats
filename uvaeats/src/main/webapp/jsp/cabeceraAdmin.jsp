<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<link rel="stylesheet" href="../css/styleCabeceraComun.css?v=2">
<html>

    <header>

        <div class="sup-izquierda">
            <a><img src="../imagenes/logo.png" alt="Imagen"></a>
            <a id="inicio" ><h1>Modo Admin</h1></a>
        </div>

        <div class="sup-derecha">

            <div class="perfil">
                <img class="imgPerfil" src="../imagenes/perfil.png" alt="Imagen">
                <div class="contenido">
                    
                        <form action="index.jsp" method="GET">
                            <button type="submit" class="boton2" name="cerrar">Cerrar sesión</button>
                        </form>
                        <form action="cafeteriasAdmin.jsp" method="GET">
                      
                            <button type="submit" class="boton2" name="cafeterias">Gestionar cafeterias</button>
                        </form>
                        <form action="platosAdmin.jsp" method="GET">
                            <button href="gestionarPlatos.jsp" class="boton2" name="platos">Gestionar platos</button>
                        </form>
                        <form action="ofertasAdmin.jsp" method="GET">
                            <button href="ofertasAdmin.jsp" class="boton2" name="platos">Gestionar ofertas</button>
                        </form>
                </div>
            </div>
        </div>
    </header>
</html>