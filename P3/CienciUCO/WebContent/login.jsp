<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@page import="messages.Messages" %>
<head>
	<% request.setCharacterEncoding("utf-8"); %>
	<jsp:include page="/include/common-head.jsp" >
		<jsp:param name="title" value="Iniciar sesión"/>
   	</jsp:include>
</head>

<body>
	<jsp:include page="/include/header.jsp" />
	<div class="contentaux">
	<div class="login" id="login">
		<form action="<%= Messages.buildURL("/loginAttempt") %>" method="POST" accept-charset="UTF-8">
			<div class="user-img">
                   <img src=<%= Messages.buildURL("/img/user.png") %> alt="Avatar"/>
            </div>
			<div class="form-group" id="user-group">
                   <input type="text" class="form-control" placeholder="Usuario" name="correo"/>
               </div>
               <div class="form-group" id="contrasena-group">
                   <input type="password" class="form-control" placeholder="Contraseña" name="password"/>
               </div>
			<div class="boton-entrar" id="boton1">
				<input type="submit" value="Entrar">
				<input type="button" onclick="window.location.href = '<%= Messages.urlFromKey("Pages.registerPage") %>'" value="Registrar">
			</div>
		
		</form>
		<% 	Boolean failed = (Boolean)request.getAttribute("failedLogin");
			if(failed != null && failed) { %>
		    <div class="login-error-message">
		    	El correo o contraseña introducidos son inválidos.
		    </div>
	    <% } %>
		<div class="forgot">
               <a href="#">¿Recordar contraseña?</a>
           </div>   
	</div>
	</div>
	<%@ include file="/include/footer.jsp" %>
</body>