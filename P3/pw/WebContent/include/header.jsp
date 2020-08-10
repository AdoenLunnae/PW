<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>


<jsp:useBean id="customer" class="es.uco.pw.display.beans.CustomerBean" scope="session"/>
<header>
	<div class="row">
	    <div class="logo" onclick="window.location.href='../pages/home.html'"></div>
	    <nav>
	    	<div class="col-3">
	    		<% 
	    		String target, text;
	    		if(customer.getMail() == null){
	    			customer = new es.uco.pw.display.beans.CustomerBean("", "Guest");
	    			session.setAttribute("customer", customer);
	    		}
	    		
	    		if(customer.getIdRol().equals("Guest")){
	    			target = "\"/pw/login.jsp\"";
	    			text = "Iniciar Sesión";
	    		}
	    		else{	    			
	    			target = "\"/pw/logout\"";
	    			text = "Cerrar Sesión";
	    		}
	    		out.print("<a href=" + target + " class=\"button\">"+ text + "</a>");
	            %>
            </div>
	        <div class="double-col-3 search-container">
	            <form action="../pages/resultados.html"
	                  style="display: flex">
	                <input type="text"
	                       placeholder="Buscar"
	                       name="search">
	                <button type="submit"><div class="rotate">&#9906;</div></button>
	            </form>
	        </div>
	    </nav>
	</div>
</header>