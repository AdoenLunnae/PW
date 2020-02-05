<%@ page language="java" contentType="text/html; charset=UTF-8"%>

<head>
	<jsp:include page="/include/common-head.jsp">
		<jsp:param name="title" value="Iniciar sesión"/>
   	</jsp:include>
</head>

<body>
	<div class="contentaux">
	<div class="login" id="login">
		<form action=" ">
			<div class="user-img">
                   <img src="./img/user.png" alt="Avatar"/>
               </div>
			<div class="form-group" id="user-group">
                   <input type="text" class="form-control" placeholder="Usuario" name="username"/>
               </div>
               <div class="form-group" id="contrasena-group">
                   <input type="password" class="form-control" placeholder="ContraseÃ±a" name="password"/>
               </div>
			<div class="boton-entrar" id="boton1">
				<input type="submit" value="Entrar">
				<input type="button" onclick="window.location.href = './registro.html'" value="Registrar">
			</div>
		
		</form>
		<div class="forgot">
               <a href="#">¿Recordar contraseña?</a>
           </div>   
	</div>
	</div>
	</body>