<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<jsp:useBean id="customer" class="pw.CustomerBean"/>
<jsp:setProperty name="customer" property="mail" value="testmail"/>
<html>
	<head>
		<jsp:include page="/include/common-head.jsp">
			<jsp:param name="title" value="Registration Completed"/>
    	</jsp:include>
    	<meta http-equiv = "refresh" content = '10; url = /perfil?mail=<jsp:getProperty name="customer" property="mail"/>' />
	</head>
	<body>
		<%@ include file="/include/header.jsp" %>
		
		<div class="caja">
			<div class="titulo-caja">Registro completado exitosamente</div>
			<div class="elemento-caja">
				<p>
				Su registro ha sido completado con éxito. Ahora será redirigido a su perfil, donde podrá
				editar su información personal. Si la redirección no funciona automáticamente pulse 
				<a href='/perfil?mail=<jsp:getProperty name="customer" property="mail"/>'>aquí</a>.
			</div>
		</div>
		            
		
		<%@ include file="/include/footer.jsp" %>
	</body>
</html>