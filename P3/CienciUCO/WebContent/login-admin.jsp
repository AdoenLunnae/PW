<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@page import="messages.Messages" %>
<head>
    <% request.setCharacterEncoding("utf-8"); %>
	<jsp:include page="/include/common-head.jsp" >
		<jsp:param name="title" value="Administración"/>
   	</jsp:include>

</head>

<body>
<jsp:include page="/include/header.jsp" />
<div class="contentaux">
	<div class="login-admin" id="login">
	    <form action='<%= Messages.buildURL("/adminLogin") %>' method="post">
	        <div class="user-img">
	            <img src=<%= Messages.buildURL("/img/admin.png") %> alt="avatar admin"/>
	        </div>
	        <div class="form-group" id="user-group">
	            <input type="text" class="form-control" placeholder="Usuario" name="mail"/>
	        </div>
	        <div class="form-group" id="contrasena-group">
	            <input type="password" class="form-control" placeholder="Contraseña" name="password"/>
	        </div>
	        <div class="boton-entrar-admin center">
	            <input type="submit" value="Entrar">
	        </div>
	    </form>
	    <% if(Boolean.valueOf(request.getParameter("failedLogin"))) { %>
		    <div class="login-error-message">
		    	El correo o contraseña introducidos son inválidos.
		    </div>
	    <% } %>
	</div>
</div>
<%@ include file="/include/footer.jsp" %>
</body>
</html>