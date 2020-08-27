<%@page import="messages.Messages" import="java.util.*" import="es.uco.pw.display.beans.PostBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<html>
	<head>
		<% request.setCharacterEncoding("utf-8"); %>
		<jsp:include page="/include/common-head.jsp">
			<jsp:param name="title" value="Página Principal"/>
	   	</jsp:include>
	   	<script type="text/javascript" src="<%= Messages.buildURL("/js/editUtilities.js")%>"></script>
	</head>

	<body>
	
		<%@ include file="/include/header.jsp" %>
		
		<% if( customer.getIdRol().equals(Messages.getString("General.userRoleName"))) { %>
		<div class="container mx-auto flex flex-row mt-3 text-sm leading-normal">
		    <div class="col-narrow">
		    	<div class="circle-crop w-auto h-full mt-2 mb-2"> 
		        	<img class="imagen-perfil" src="<%= "data:image/jpeg;base64, " + session.getAttribute("image") %>"
		             alt="Imagen de perfil"/>
		        </div>
		    </div>
		    <div class="col-wide">
		        <div class="caja container mx-3">
		            <div class="titulo-caja center">
		                ¿Alguna idea?
		            </div>
		            <div class="elemento-caja container">
		            	<form action="<%= Messages.buildURL("/createPost") %>" method="post" accept-charset="utf-8">
		            		<div class="contenedor-inputs">
		            			<input type="text" name="title" placeholder="Título">
		            			<input type="hidden" name="mail" value="<%= customer.getMail() %>"> 
			            		<textarea rows="3" cols="100" placeholder="Publica algún descubrimiento interesante..." name="content"></textarea>
		            			<button type="submit" class="btn-submit relative move-left">Enviar</button>
		            		</div>
		            	</form>
		            </div>
		        </div>
		    </div>
		</div>
		<% } %>
		<%
		ArrayList<PostBean> posts = (ArrayList<PostBean>)session.getAttribute("posts");
		for(PostBean post : posts) { %>
		<div class="container mx-auto flex flex-row mt-3 text-sm leading-normal">
		    <div class="caja container">
			    <div class="titulo-caja">
			    	<div class="flex justify-between">
			    	<div> <%= post.getTitle() %> </div>
			    	
			    	<%	
			    		Boolean isAdmin = customer.getIdRol().equals(Messages.getString("General.adminRoleName"));
			    		Boolean isAuthor = customer.getMail().equals(post.getAuthor());
			    		if( isAdmin || isAuthor ) { 
			    	%>
			    		<form action='<%= Messages.buildURL("/deletePost") %>' id='<%="delete-post-" + post.getId() %>' method='post'>
			    			<input type="hidden" value='<%= post.getId() %>' name="id">
			    		</form>
			    		<a href="#" class="boton-borrar" onclick="submitForm('<%="delete-post-" + post.getId() %>')">
                    		<img class="icon-button delete-button" alt="Borrar" src=<%= Messages.urlFromKey("General.deleteIcon")%> >
	                    </a>
			    	<% } %>
			    	</div>
	                <div class="subtitulo">
	                	<% 	Calendar calendar = Calendar.getInstance(); 
	                		calendar.setTime(post.getCreated_at());	
	                	%>
	                	<%= post.getAuthor() + ", el " + calendar.get(Calendar.DATE) + "/" + (calendar.get(Calendar.MONTH) + 1) + "/" + (calendar.get(Calendar.YEAR)) + " a las " + calendar.get(Calendar.HOUR_OF_DAY) + ":" + calendar.get(Calendar.MINUTE) %>
	                </div>
			    </div>
		        <div class="elemento-caja">
		            <%= post.getContent() %>
		        </div>
		    </div>
		</div>
		<% } %>
		<%@ include file="/include/footer.jsp" %>
	
	</body>
</html>