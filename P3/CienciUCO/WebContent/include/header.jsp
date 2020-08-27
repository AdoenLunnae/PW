<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" import="messages.Messages" %>


<jsp:useBean id="customer" class="es.uco.pw.display.beans.CustomerBean" scope="session"/>
<% if(customer.getMail() == null){
	customer = new es.uco.pw.display.beans.CustomerBean("", "Guest");
	session.setAttribute("customer", customer);
} %>
<header>
	<div class="row">
	    <div class="logo">
	    	<a href='<%= Messages.buildURL("/home") %>'>
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
	            %>
	    		<a href='<%= target %>' class="button"> <%= text %>  </a>
            </div>
            
            <div class="col-3">
	    		<% 
	    		if(customer.getIdRol().equals("Guest")){
	    			target = Messages.urlFromKey("Pages.registerPage");
	    			text = "Registrarme";
	    		}
	    		else{	    			
	    			target = Messages.urlFromKey("General.profile") + customer.getMail();
	    			text = "Mi Perfil";
	    		}
	            %>
	    		<a href='<%= target %>' class="button"> <%= text %> </a>
	    		
            </div>
            
	        <div class="col-3 search-container">
	            <form action="<%= Messages.buildURL("/search") %>" style="display: flex">
	                <input type="text" placeholder="Buscar" name="mail">
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