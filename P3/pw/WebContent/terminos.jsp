<%@ page language="java" contentType="text/html; charset=UTF-8"%>

<html>
<head>
	<jsp:include page="./include/common-head.jsp">
        <jsp:param name="title" value="Términos y Condiciones"/>
    </jsp:include>
</head>

<body>

<%@ include file="/include/header.jsp" %>

<!-- Información del perfil -->
<div class="container mx-auto flex flex-row mt-3 text-sm leading-normal">
    <!-- Columna central -->
    <div class="w-3/4 mb-4 center">
        <!-- Sobre mÃ­ -->
        <div class="caja">
            <div class="titulo-caja">Términos y condiciones de uso</div>
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

</html>