<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="ISO-8859-1"%>
<html>
<head>
	<jsp:include page="/include/common-head.jsp">
		<jsp:param name="title" value="Perfil inexistente" />
	</jsp:include>
</head>
<body>
	<jsp:include page="/include/header.jsp"/>
	<div class="caja centered-text mt-4 lg:w-2/3 mx-auto">
			<div class="titulo-caja">Perfil inexistente</div>
			<div class="elemento-caja w-full">
				<p class="mx-auto">
					El perfil con correo "<%= request.getParameter("mail") %>" no existe. 
				</p>
			</div>
		</div>
	<jsp:include page="/include/footer.jsp"/>
</body>
</html>