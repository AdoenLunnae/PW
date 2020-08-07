<%@ page language="java" contentType="text/html; charset=UTF-8"%>

<html>
	<head>
		<% request.setCharacterEncoding("utf-8"); %>
		<jsp:include page="/include/common-head.jsp">
			<jsp:param name="title" value="Error al registrar"/>
    	</jsp:include>
	</head>
	<body>
		<%@ include file="/include/header.jsp" %>
		<!-- RELLENAR -->
		<%@ include file="/include/footer.jsp" %>
</body>
</html>