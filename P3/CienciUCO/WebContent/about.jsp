<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@page import="messages.Messages" %>
<head>
	<% request.setCharacterEncoding("utf-8"); %>
    <jsp:include page="/include/common-head.jsp">
			<jsp:param name="title" value="Sobre Nosotros"/>
   	</jsp:include>
</head>

<body>


<%@ include file="/include/header.jsp" %>

<!-- Información del perfil -->
<div class="container mx-auto flex flex-row mt-3 text-sm leading-normal">
    <div class="w-full lg:w-1/4 lg:pl-0 pr-6 mr-6 mt-8 mb-4">
        <!-- información de contacto -->
        <div class="caja">
            <div class="titulo-caja">Información de contacto</div>
            <table border="0" width="95%" height="auto">
                <tr>
                    <td><span class="nombre-elemento">País</span></td>
                    <td><span class="descripcion-elemento">España</span></td>
                </tr>
                <tr>
                    <td><span class="nombre-elemento">Comunidad</span></td>
                    <td><span class="descripcion-elemento">Andalucía</span></td>
                </tr>
                <tr>
                    <td><span class="nombre-elemento">Ciudad</span></td>
                    <td><span class="descripcion-elemento">Córdoba, Córdoba</span></td>
                </tr>
                <tr>
                    <td><span class="nombre-elemento">Correo electrónico</span></td>
                    <td><span class="descripcion-elemento">mail@mail.es</span></td>
                </tr>
                <tr>
                    <td><span class="nombre-elemento">Teléfono</span></td>
                    <td><span class="descripcion-elemento">(+34)987654321</span></td>
                </tr>
            </table>
            <div class="accion-caja"></div>
        </div>
        <!-- Contactos -->
        <div class="caja">
            <div class="titulo-caja">Nuestra plantilla</div>
            <!-- Elemento contacto -->
            <div class="elemento-caja">
                <div class="py-2">
                	<img src=<%= Messages.buildURL("/img/perfil.png") %> alt="avatar" class="imagen-contacto">
                </div>
                <div class="informacion-contacto">
                    <div class="nombre-elemento">Álvaro Prieto</div>
                </div>
            </div>
            <!-- Elemento contacto -->
            <div class="elemento-caja">
                <div class="py-2">
                	<img src=<%= Messages.buildURL("/img/perfil.png") %> alt="avatar" class="imagen-contacto">
                </div>
                <div class="informacion-contacto">
                    <div class="nombre-elemento">Ángel Sevilla</div>
                </div>
            </div>
            <!-- Elemento contacto -->
            <div class="elemento-caja">
                <div class="py-2">
                	<img src=<%= Messages.buildURL("/img/perfil.png") %> alt="avatar" class="imagen-contacto">
                </div>
                <div class="informacion-contacto">
                    <div class="nombre-elemento">Juan Pedro Muñoz</div>
                </div>
            </div>
            <!-- Elemento contacto -->
            <div class="elemento-caja">
                <div class="py-2">
                	<img src=<%= Messages.buildURL("/img/perfil.png") %> alt="avatar" class="imagen-contacto">
                </div>
                <div class="informacion-contacto">
                    <div class="nombre-elemento">Carlos David Serrano</div>
                </div>
            </div>
        </div>
    </div>

    <!-- Columna central -->
    <div class="w-full lg:w-1/2 mb-4">
        <!-- Sobre mí -->
        <div class="caja">
            <div class="titulo-caja">Quién somos</div>
            <div class="elemento-caja">
                <div>
                    <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut
                        labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco
                        laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in
                        voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat
                        non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.</p>
                    <p>Sed ut perspiciatis unde omnis iste natus error sit voluptatem accusantium doloremque laudantium,
                        totam rem aperiam, eaque ipsa quae ab illo inventore veritatis et quasi architecto beatae vitae
                        dicta sunt explicabo. Nemo enim ipsam voluptatem quia voluptas sit aspernatur aut odit aut
                        fugit, sed quia consequuntur magni dolores eos qui ratione voluptatem sequi nesciunt. Neque
                        porro quisquam est, qui dolorem ipsum quia dolor sit amet, consectetur, adipisci velit, sed quia
                        non numquam eius modi tempora incidunt ut labore et dolore magnam aliquam quaerat voluptatem. Ut
                        enim ad minima veniam, quis nostrum exercitationem ullam corporis suscipit laboriosam, nisi ut
                        aliquid ex ea commodi consequatur? Quis autem vel eum iure reprehenderit qui in ea </p>
                </div>
            </div>
        </div>
    </div>
</div>
<%@ include file="/include/footer.jsp" %>
</body>
