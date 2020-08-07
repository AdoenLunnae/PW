<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>


<jsp:useBean id="customer" class="es.uco.pw.display.beans.CustomerBean" scope="session"/>
<header>
	<div class="row">
	    <div class="logo circle" onclick="window.location.href='../pages/home.html'"></div>
	    <nav>
	    	<div class="col-3">
	            <a href="/pw/logout" class="button">Cerrar Sesión</a>
	        </div>
	        <div class="double-col-3 search-container">
	            <form action="../pages/resultados.html"
	                  style="display: flex">
	                <input type="text"
	                       placeholder="Buscar..."
	                       name="search">
	                <button type="submit">Enviar</button>
	            </form>
	        </div>
	    </nav>
	</div>
</header>