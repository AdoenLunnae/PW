<%@ page language="java" contentType="text/html; charset=UTF-8"%>

<head>
	<% request.setCharacterEncoding("UTF-8"); %>
    <jsp:include page="/include/common-head.jsp">
			<jsp:param name="title" value="Registrarme"/>
	</jsp:include>
	   	
    <script src="./js/passwordValidation.js"></script>

</head>

<body>

<jsp:include page="/include/header.jsp" />

<div class="contentaux">
<form class="center w-3/4" action="registerAttempt" method="POST" accept-charset="UTF-8">
    <div class="conjunto-registro" id="conj-reg">
        <div class="registro">
            <div class="user-img">
                <img src="./img/user.png" alt="avatar"/>
            </div>
            <div class="form-group">
                <input type="text" class="form-control" placeholder="Nombre" name="nombre"/>
                <input type="text" class="form-control" placeholder="Apellidos" name="apellidos"/>
            </div>
            <div class="form-group">
                <input type="tel" class="form-control" placeholder="Número de móvil" name="numero"/>
            </div>
        </div>
        <div class="registro">
            <div class="form-group">
                <input type="email" class="form-control" placeholder="Correo electrónico" name="correo"/>
            </div>
            <div class="form-group" id="contrasena-group">
                <input type="password" class="form-control" placeholder="Contraseña" id="password" name="password"
                       oninput="checkPass()"/>
                <div id="invalid-pass-message" class="pass-error-message-off">
                    <p>La contraseña debe contener al menos 7 caracteres, un número y una letra.</p>
                    <p>Caracteres válidos A-Z a-z 0-9 "." "_" "-" .</p>
                </div>
                <input type="password" class="form-control" placeholder="Repita su contraseña" id="password2"
                       oninput="checkPass()"/>
            </div>
            <div id="pass-match-message" class="pass-error-message-off">
                <p>Las contraseñas deben coincidir.</p>
            </div>

            <div class="boton-entrar">
                <input type="submit" value="Registrarte" id="submit-button" disabled="disabled"/>
                <input type="button" onclick="window.location.href = './login.jsp'" value="Volver al login"/>
            </div>
            
            <div class="terminos" id="terminosycondiciones-group">
                Al hacer clic en Registrarte, aceptas nuestras Condiciones. Obtén más información sobre cṕmo
                recopilamos, usamos y compartimos tu información en la Política de datos, así como el uso que
                hacemos de las cookies y tecnologías similares en nuestra Política de cookies.
            </div>
        </div>
	</div>
</form>
</div>
<%@ include file="./include/footer.jsp" %>
</body>