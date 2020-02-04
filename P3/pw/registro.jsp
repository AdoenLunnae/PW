<%@ page language="java" contentType="text/html; charset=UTF-8"%>

<head>
    <title>Registro</title>
    <meta name="viewport"
          content="width=device-width, user-escalable=no, initial-scale=1, maximum-scale=1. minimum-scale=1 ">


    <link rel="stylesheet" href="./css/main.css">
    <script src="./js/passwordValidation.js"></script>

</head>

<body>
<div class="contentaux">
<form class="center w-3/4" action="registerAttempt" method="POST">
    <div class="conjunto-registro" id="conj-reg">
        <div class="registro" id="registro">
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
                <div id="invalid-pass-message" style="color: red; visibility: hidden; height: 0">
                    <p>La contraseña debe contener al menos 7 caracteres, un número y una letra.</p>
                    <p>Caracteres válidos A-Z a-z 0-9 "." "_" "-" .</p>
                </div>
                <input type="password" class="form-control" placeholder="Repita su contraseña" id="password2"
                       oninput="checkPass()"/>
            </div>
            <div id="pass-match-message" style="color: red; visibility: hidden; height: 0">
                <p>Las contraseñas deben coincidir.</p>
            </div>
            <div class="terminos" id="terminosycondiciones-group">
                Al hacer clic en Registrarte, aceptas nuestras Condiciones. Obtén más información sobre cṕmo
                recopilamos, usamos y compartimos tu información en la Política de datos, así como el uso que
                hacemos de las cookies y tecnologías similares en nuestra Política de cookies. Es posible que te
                enviemos notificaciones por SMS que podrás desactivar cuando quieras.
            </div>

            <div class="boton-entrar">
                <input type="submit" value="Registrarte" id="submit-button" disabled="disabled"/>
                <input type="button" onclick="window.location.href = './login.html'" value="Volver al login"/>
            </div>
        </div>
		</div>
    </div>
</form>
</body>