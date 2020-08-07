<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<jsp:useBean id="customer" class="es.uco.pw.display.beans.CustomerBean" scope="session"/>
<html>
	<head>
		<% request.setCharacterEncoding("utf-8"); %>
		<jsp:include page="/include/common-head.jsp">
			<jsp:param name="title" value="Registro Completado"/>
    	</jsp:include>
    	
   		<meta http-equiv = "refresh" content = '5; url = /pw/profile?mail=<jsp:getProperty name="customer" property="mail"/>' />
	</head>
	<body>
		<jsp:include page="/include/header.jsp" />
		<div class="caja">
			<div class="titulo-caja">Registro completado con éxito</div>
			<div class="elemento-caja">
				<p>
				Su registro ha sido completado con éxito. Ahora será redirigido a su perfil, donde podrá
				editar su información personal. Si la redirección no funciona automáticamente pulse 
				<a href='/pw/profile?mail=<jsp:getProperty name="customer" property="mail"/>'>aquí</a>.
			</div>
		</div>
		            
		
		<%@ include file="/include/footer.jsp" %>
	</body>
</html>