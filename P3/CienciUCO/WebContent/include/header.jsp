<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" import="messages.Messages" %>


<jsp:useBean id="customer" class="es.uco.pw.display.beans.CustomerBean" scope="session"/>
<% if(customer.getMail() == null){
	customer = new es.uco.pw.display.beans.CustomerBean("", "Guest");
	session.setAttribute("customer", customer);
} %>
<header>
	<div class="row">
	    <div class="logo" onclick="window.location.href='../pages/home.html'">
	    	<a href='<% out.println(customer.getMail().equals("")?"#":Messages.urlFromKey("General.profile") + customer.getMail()); %>'>
	    		<img src="<%= Messages.urlFromKey("General.logoPath") %>" alt="Logo No Cargado"></img>
	    	</a>
	    </div>
	    <nav>
	    	<div class="col-3">
	    		<% 
	    		String target, text;
	    		
	    		
	    		if(customer.getIdRol().equals("Guest")){
	    			target = Messages.urlFromKey("Pages.loginPage");
	    			text = "Iniciar Sesión";
	    		}
	    		else{	    			
	    			target = Messages.urlFromKey("Pages.logoutPage");
	    			text = "Cerrar Sesión";
	    		}
	    		out.print("<a href='" + target + "' class=\"button\">"+ text + "</a>");
	            %>
            </div>
	        <div class="double-col-3 search-container">
	            <form action="../pages/resultados.html" style="display: flex">
	                <input type="text" placeholder="Buscar" name="search">
	                <button type="submit">
	                	<div class="rotate">
	                		&#9906;
	                	</div>
	                </button>
	            </form>
	        </div>
	    </nav>
	</div>
</header>