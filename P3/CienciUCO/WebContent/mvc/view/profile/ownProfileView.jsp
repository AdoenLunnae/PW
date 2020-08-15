<%@page import="java.sql.Date"%>
<%@page import="messages.Messages"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<jsp:useBean id="profile" class="es.uco.pw.display.beans.ProfileBean" scope="session"/>

<head>
	<% request.setCharacterEncoding("utf-8"); %>
	<jsp:include page="/include/common-head.jsp">
		<jsp:param name="title" value="<%= profile.getName() %>" />
	</jsp:include>
	
	<link rel="stylesheet" href=<%= Messages.buildURL("/css/popups.css")%>>
	<script type="text/javascript" src="<%= Messages.buildURL("/js/popup.js")%>" ></script>
	<script type="text/javascript" src="<%= Messages.buildURL("/js/editUtilities.js")%>"></script>
</head>
<body>
	<jsp:include page="/include/header.jsp"/>
	<div class="barra-cabecera">
	    <div class="contenedor-cabecera">
	        <div class="w-1/4">
	            <div class="circle-crop ml-6 -mt-5">
	            	<img class="imagen-perfil" src= "<%= "data:image/jpeg;base64, " + profile.getBase64Image() %>" 
	            		alt="Foto de perfil" onClick="abrirPopUp('overlay-pic', 'popup-pic')"/>
	            </div>
	        </div>
	        <div class="informacion-contacto ml-12">
	            <div class="nombre-perfil -mt-2 ml-5"><%= profile.getName() %></div>
	            <!--  <div class="descripcion-elemento">Estudiante de Grado de Ingeniería Informática</div> -->
	        </div>
	        <!-- <div class="mr-20"><button>Conectar</button></div> -->
	    </div>
	</div>
	
	<!-- Información del perfil -->
	<div class="container mx-auto flex flex-row mt-3 text-sm leading-normal">
	    <!-- Columna izquierda -->
	    <div class="lg:w-1/3 lg:pl-0 pr-6 mr-6 mt-8 mb-4">
	        <!-- información de contacto -->
	        <div class="caja">
	            <div class="titulo-caja">Información de contacto</div>
	            <table class="contact-data">
                     <tr>
	                    <td><span class="nombre-elemento">Email</span></td>
	                    <td><a href="<%= "mailto:" + profile.getMail() %> " class="descripcion-elemento"><%= profile.getMail() %></a></td>
	                </tr>
	                <tr>
	                    <td><span class="nombre-elemento">Teléfono</span></td>
	                    <td><span class="descripcion-elemento"><%= profile.getPhone() %></span></td>
	                    <td>
	                    	<a href="#" class="enlace-pu" onclick="abrirPopUp('overlay-edit-phone', 'popup-edit-phone')">
	                    		Editar
	                    	</a>
	                    </td>
                    </tr>
	                <% for( es.uco.pw.display.beans.ContactInfoBean contactInfo : profile.getAllContactInfo() ) { %>
	                	<tr>
		                    <td><div class="nombre-elemento"><%= contactInfo.getName() %></div></td>
		                    <td><div class="descripcion-elemento"><%= contactInfo.getValue() %></div></td>
		                    <td><a href="#" class="enlace-pu" onclick="abrirPopUp('<%= "overlay-contact-" + contactInfo.getId() %>', '<%= "popup-contact-"+ contactInfo.getId() %>')">Editar</a></td>
		                    <td><a href="#" class="boton-borrar" onclick="submitForm('<%="delete-contact-" + contactInfo.getId() %>')">Borrar</a></td>
	                	</tr>
	                <% } %>
	            </table>
	            
	            <% for( es.uco.pw.display.beans.ContactInfoBean contactInfo : profile.getAllContactInfo() ) { %>
	            	<form class="nodisplay" id= '<%="delete-contact-" + contactInfo.getId() %>' action='<%= Messages.buildURL("/deleteContactInfo")%>' method='post' accept-charset='UTF-8'>
	                	<input type="hidden" name="id" value=<%= contactInfo.getId() %> >
	                	<input type="hidden" name="mail" value=<%= profile.getMail() %> >
	                </form>
	            <% } %>
	            
	            <div class="accion-caja">
	            	<a href="#" class="enlace-pu" onclick="abrirPopUp('overlay-contact-add', 'popup-contact-add')">
	            		Añadir
	            	</a>
	            </div>
	        </div>
	        <!-- Contactos -->
	        <div class="caja">
	            <div class="titulo-caja">Contactos</div>
	            <!-- Elemento contacto -->
	            <div class="elemento-caja">
	                <div class="py-2">
	                	<a href="#">
	                		<img src=<%= Messages.buildURL("/img/perfil.png") %> alt="avatar"  class="imagen-contacto">
	                	</a>
	                </div>
	                <div class="informacion-contacto">
	                    <div>
		                    <a href="#" class="nombre-elemento">
		                    	Pedro Sánchez
		                    </a>
		                </div>
	                    <div class="descripcion-elemento"> Presidente del Gobierno y secretario general del PSOE</div>
	                </div>
	            </div>
	            <div class="accion-caja">
	            	<a href="resultados.html" class="enlace-pu">
	            		Ver más
	            	</a>
	            </div>
	        </div>
	    </div>
	
	    <!-- Columna central -->
	    <div class="lg:w-2/3 mb-4">
	        <!-- Sobre mí -->
	        <div class="caja">
	            <div class="titulo-caja">SOBRE MÍ</div>
	            <div class="elemento-caja">
	                <div>
	                    <%= profile.getParsedAboutMe() %>
	                </div>
	            </div>
	            <!-- Añadir información personal -->
	            <div class="accion-caja">
	            	<a href="#" class="enlace-pu" onclick="abrirPopUp('overlay', 'popup')">
	            		Editar
	            	</a>
	            </div>
	        </div>
	
	        <!-- Formación -->
	        <div class="caja">
	            <div class="titulo-caja">FORMACIÓN</div>
	            <!-- Elemento formación -->
	            <div class="elemento-caja">
	                <div class="py-2">
	                	<a href="./perfil-empresa.html">
	                		<img src=<%= Messages.buildURL("/img/perfil.png") %> alt="avatar" class="imagen-contacto">
	                	</a>
	                </div>
	                <div class="informacion-contacto">
	                    <div class="flex justify-between">
	                        <div><a href="./perfil-empresa.html"
	                                class="nombre-elemento">Universidad de Córdoba</a></div>
	                        <div><a href="#"
	                                class="enlace-pu"
	                                onclick="abrirPopUp('overlay5', 'popup5')">Editar</a></div>
	                    </div>
	                    <div class="descripcion-elemento">2014 - 2019</div>
	                </div>
	            </div>
	            <!-- Añadir formación -->
	            <div class="accion-caja"><a href="#"
	                                        class="enlace-pu"
	                                        onclick="abrirPopUp('overlay4', 'popup4')">Añadir</a>
	            </div>
	        </div>
	
	        <!-- Experiencia -->
	        <div class="caja">
	            <div class="titulo-caja">EXPERIENCIA</div>
	            <% for ( es.uco.pw.display.beans.ExperienceBean experience : profile.getExperiences() ) { %>
       				<div class="elemento-caja">
		                <div class="py-2">
							<img src=<%= Messages.buildURL("/img/perfil.png") %> alt="avatar" class="imagen-contacto">
						</div>
		                <div class="informacion-contacto">
		                    <div class="flex justify-between">
		                        <div class="nombre-elemento">
		                        	<%= experience.getNombre() %>
		                        </div>
		                        <div>
		                        	<a href="#" class="enlace-pu"  onclick="abrirPopUp('<%= "overlay-exp-" + experience.getId() %>', '<%= "popup-exp-" + experience.getId() %>')">
		                        		Editar
		                        	</a>
		                        </div>
		                    </div>
		                    <div class="flex justify-between">
			                    <div class="descripcion-elemento">
				                    <%=  experience.getDescripcion() %>
			                    </div>
			                    <div>
			                    	<% String formId =  "delete-exp-" + experience.getId() ; %>
			                    	<form class="nodisplay" id=<%= formId %> action=<%= Messages.buildURL("/deleteExperience") %> method="POST">
			                    		<input type="hidden" name="id" value=<%= experience.getId() %>>
			                    		<input type="hidden" name="mail" value=<%= profile.getMail() %>>
		                        	</form>
		                        	<a href='#' class="boton-borrar" onClick="submitForm('<%= formId %>')" >
		                        		Borrar
		                        	</a>
		                        </div>
		                    </div>
		                    <br/>
		                    <div class="descripcion-elemento">
			                    En <%=  experience.getLugar() %>
		                    </div>
		                    <div class="descripcion-elemento">
			                    Desde <%= experience.getStart() %>
			                    <% if(experience.getEnd() != null) { %>
			                    	&nbsp;
			                    	&nbsp;
			                    	<b>&#8594;</b>
			                    	&nbsp;
			                    	&nbsp;
			                    	Hasta <%= experience.getEnd() %>
			                    <% } %>
		                    </div>
		                </div>
	            	</div>
    			<% } %>
	            <!-- Añadir experiencia -->
	            <div class="accion-caja">
	            	<a href="#" class="enlace-pu" onclick="abrirPopUp('overlay-exp-add', 'popup-exp-add')">
	            		Añadir
	            	</a>
	            </div>
	        </div>
	
	        <!-- Artículos  -->
	        <div class="caja">
	            <div class="titulo-caja">ARTÍCULOS PUBLICADOS</div>
	            <!-- Elemento artículo -->
	            <div>
	                <div class="elemento-caja">
	                    <div class="informacion-contacto">
	                        <div class="flex justify-between">
	                            <div class="nombre-elemento">Título del artículo</div>
	                            <div><a href="#"
	                                    class="enlace-pu"
	                                    onclick="abrirPopUp('overlay12', 'popup12')">Editar</a>
	                            </div>
	                        </div>
	                        <div class="descripcion-elemento">Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed
	                            do eiusmod tempor incididunt ut labore et dolore magna aliqua.
	                        </div>
	                    </div>
	                </div>
	                <div class="linea-colaboradores">
	                    <span>
	                    	<a href="#">
	                    		<img src="<%= Messages.buildURL("/img/perfil.png") %>" alt="avatar" class="imagen-contacto-peq">
	                    	</a>
	                    </span>
	                    &nbsp;
	                    <span>
	                    	<a href="#">
	                    		<img src="<%= Messages.buildURL("/img/perfil.png") %>" alt="avatar" class="imagen-contacto-peq">
	                    	</a>
	                    </span>
	                    &nbsp;
	                </div>
	            </div>
	            <!-- Elemento artículo -->
	            <div>
	                <div class="elemento-caja">
	                    <div class="informacion-contacto">
	                        <div class="flex justify-between">
	                            <div class="nombre-elemento">Título del artículo</div>
	                            <div><a href="#"
	                                    class="enlace-pu"
	                                    onclick="abrirPopUp('overlay12', 'popup12')">Editar</a>
	                            </div>
	                        </div>
	                        <div class="descripcion-elemento">Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed
	                            do eiusmod tempor incididunt ut labore et dolore magna aliqua.
	                        </div>
	                    </div>
	                </div>
	                <div class="linea-colaboradores">
	                    <span><a href="#"><img src=<%= Messages.buildURL("/img/perfil.png") %>
	                                           alt="avatar"
	                                           class="imagen-contacto-peq"></a></span> &nbsp;
	                    <span><a href="#"><img src=<%= Messages.buildURL("/img/perfil.png") %>
	                                           alt="avatar"
	                                           class="imagen-contacto-peq"></a></span> &nbsp;
	                    <span><a href="#"><img src=<%= Messages.buildURL("/img/perfil.png") %>
	                                           alt="avatar"
	                                           class="imagen-contacto-peq"></a></span> &nbsp;
	                </div>
	            </div>
	            <!-- Añadir artículo -->
	            <div class="accion-caja"><a href="#"
	                                        class="enlace-pu"
	                                        onclick="abrirPopUp('overlay10', 'popup10')">Añadir</a></div>
	        </div>
	
	        <!-- Patentes -->
	        <div class="caja">
	            <div class="titulo-caja">PATENTES</div>
	            <!-- Elemento patente -->
	            <div>
	                <div class="elemento-caja">
	                    <div class="informacion-contacto">
	                        <div class="flex justify-between">
	                            <div class="nombre-elemento">Título de la patente</div>
	                            <div><a href="#"
	                                    class="enlace-pu"
	                                    onclick="abrirPopUp('overlay11', 'popup11')">Editar</a>
	                            </div>
	                        </div>
	                        <div class="descripcion-elemento">Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed
	                            do eiusmod tempor incididunt ut labore et dolore magna aliqua.
	                        </div>
	                    </div>
	                </div>
	                <div class="linea-colaboradores">
	                    <span><a href="#"><img src=<%= Messages.buildURL("/img/perfil.png") %>
	                                           alt="avatar"
	                                           class="imagen-contacto-peq"></a></span> &nbsp;
	                    <span><a href="#"><img src=<%= Messages.buildURL("/img/perfil.png") %>
	                                           alt="avatar"
	                                           class="imagen-contacto-peq"></a></span> &nbsp;
	                    <span><a href="#"><img src=<%= Messages.buildURL("/img/perfil.png") %>
	                                           alt="avatar"
	                                           class="imagen-contacto-peq"></a></span> &nbsp;
	                </div>
	            </div>
	            <!-- Añadir patente -->
	            <div class="accion-caja"><a href="#"
	                                        class="enlace-pu"
	                                        onclick="abrirPopUp('overlay8', 'popup8')">Añadir</a>
	            </div>
	        </div>
	    </div>
	</div>
	
	<!-- POP-UPS -->
	<!-- POP-UPS Editar Sobre Mí-->
	<div class="overlay" id="overlay">
	    <div class="popup" id="popup">
	        <h3>Editar información personalizada</h3>
	        <form action=<%= Messages.buildURL("/editAboutme") %> method="POST" accept-charset="UTF-8">
	            <div class="contenedor-inputs">
	                <textarea name="value" placeholder="Editar información personalizada" rows="10" cols="50">
	                	<%= profile.getAboutMe() %>
	                </textarea>
	            </div>
	            
	            <input type="hidden" name="mail" value="<%= profile.getMail() %>">
	            <button type="button" class="btn-submit" onclick="cerrarPopUp('overlay', 'popup')">
	                    Volver
	            </button>
	            <button type="submit"
	                    class="btn-submit"
	                    onclick="cerrarPopUp('overlay', 'popup')">Aceptar
	            </button>
	
	        </form>
	    </div>
	</div>
	<!-- POP-UPS Fin Editar Sobre Mí-->
	
	
	
	
	<!-- POP-UPS Añadir información-->
	<div class="overlay"
	     id="overlay4">
	    <div class="popup"
	         id="popup4">
	        <a href="#"
	           id="btn-cerrar-popup4"
	           class="btn-cerrar-popup"
	           onclick="cerrarPopUp('overlay4', 'popup4')"><i
	                class="fas fa-times"></i></a>
	        <h3>#21 Añadir Formación</h3>
	        <form action="javascript:void(0)">
	            <div class="contenedor-inputs">
	
	                <input type="text"
	                       placeholder="Lugar de Formación">
	                <input type="text"
	                       placeholder="Titulo">
	                <div id="popup44">
	                    <input type="text"
	                           placeholder="Año inicial">
	                    <input type="text"
	                           placeholder="Año Final">
	                </div>
	                <textarea name="textarea"
	                          placeholder="Descripción"
	                          rows="10"
	                          cols="50"></textarea>
	            </div>
	            <button type="submit"
	                    class="btn-submit"
	                    onclick="cerrarPopUp('overlay4', 'popup4')">Volver
	            </button>
	            <button type="submit"
	                    class="btn-submit"
	                    onclick="cerrarPopUp('overlay4', 'popup4')">Aceptar
	            </button>
	        </form>
	    </div>
	</div>
	<!-- POP-UPS Fin Añadir formación-->
	
	
	<!-- POP-UPS Editar formación-->
	<div class="overlay"
	     id="overlay5">
	    <div class="popup"
	         id="popup5">
	        <a href="#"
	           id="btn-cerrar-popup5"
	           class="btn-cerrar-popup"
	           onclick="cerrarPopUp('overlay5', 'popup5')"><i
	                class="fas fa-times"></i></a>
	        <h3>Editar Formación</h3>
	        <form action="javascript:void(0)">
	            <div class="contenedor-inputs">
	
	                <input type="text"
	                       placeholder="Lugar de Formación">
	                <input type="text"
	                       placeholder="Titulo">
	                <div id="popup45"
	                     class="estilotam">
	                    <input type="text"
	                           placeholder="Año inicial">
	                    <input type="text"
	                           placeholder="Año Final">
	                </div>
	                <textarea name="textarea"
	                          placeholder="Descripción"
	                          rows="10"
	                          cols="50"></textarea>
	            </div>
	            <button type="submit"
	                    class="btn-submit"
	                    onclick="cerrarPopUp('overlay5', 'popup5')">Volver
	            </button>
	            <button type="submit"
	                    class="btn-submit"
	                    onclick="cerrarPopUp('overlay5', 'popup5')">Aceptar
	            </button>
	        </form>
	    </div>
	</div>
	<!-- POP-UPS Fin Editar formación-->
	
	
	
	
	<!-- POP-UPS Añadir Experiencia-->
	<div class="overlay" id="overlay-exp-add">
	    <div class="popup" id="popup-exp-add">
	        <h3>Añadir Experiencia</h3>
	        <form action=<%= Messages.buildURL("/addExperience") %> method="POST" accept-charset="UTF-8">
		            <div class="contenedor-inputs">
		            	<input type="text" name="nombre" placeholder="Nombre">
		                <input type="text" name="lugar" placeholder="Lugar de trabajo">		               
	                    <input type="date" name="start" placeholder="Fecha de inicio">
	                    <input type="date" name="end" placeholder="Fecha de finalización">
		                <textarea name="descripcion" placeholder="Descripción" rows="10" cols="50"></textarea>
		            </div>
		            <input type="hidden" name="mail" value= <%= profile.getMail() %> >
		            <button type ="button" class="btn-submit" onclick="cerrarPopUp('overlay-exp-add', 'popup-exp-add')">
		            	Volver
		            </button>
		            <button type="submit" class="btn-submit">
		            	Aceptar
		            </button>
		        </form>
	    </div>
	</div>
	<!-- POP-UPS Fin Añadir Experiencia-->
	
	
	<!-- POP-UPS Editar Experiencia-->
	<% for ( es.uco.pw.display.beans.ExperienceBean experience : profile.getExperiences() ) { %>
		<div class="overlay" id= <%= "overlay-exp-" + experience.getId() %> >
		    <div class="popup"  id= <%= "popup-exp-" + experience.getId() %> >
		        <h3>Editar Experiencia</h3>
		        <form action=<%= Messages.buildURL("/editExperience") %> method="POST" accept-charset="UTF-8">
		            <div class="contenedor-inputs">
		            	<input type="text" name="nombre" placeholder="Nombre" value="<%= experience.getNombre() %>">
		                <input type="text" name="lugar" placeholder="Lugar de trabajo" value="<%= experience.getLugar() %>">		               
	                    <input type="date" name="start" placeholder="Fecha de inicio" value=<%= experience.getStart() %>>
	                    <input type="date" name="end" placeholder="Fecha de finalización" value=<%= experience.getStart() %>>
		                <textarea name="descripcion" placeholder="Descripción" rows="10" cols="50">
		                	<%= experience.getDescripcion() %>
		                </textarea>
		            </div>
		            <input type="hidden" name="id" value= <%= experience.getId() %> >
		            <input type="hidden" name="mail" value= <%= profile.getMail() %> >
		            <button type ="button" class="btn-submit" onclick="cerrarPopUp('<%= "overlay-exp-" + experience.getId() %>', '<%= "popup-exp-" + experience.getId() %>')">
		            	Volver
		            </button>
		            <button type="submit" class="btn-submit">
		            	Aceptar
		            </button>
		        </form>
		    </div>
		</div>
	<% } %>
	
	<!-- POP-UPS Fin Editar Experiencia-->
	<!-- POP-UPS Editar información de contacto-->
	<% for ( es.uco.pw.display.beans.ContactInfoBean contactInfo : profile.getAllContactInfo() ) { %>
		<div class="overlay" id='<%= "overlay-contact-" + contactInfo.getId() %>' >
		    <div class="popup"  id='<%= "popup-contact-" + contactInfo.getId() %>' >
		        <h3>Editar información de contacto</h3>
		        <form action=<%= Messages.buildURL("/editContactInfo") %> method="post" accept-charset="utf-8">
		            <div class="contenedor-inputs">
						<input type="text" name='name' placeholder="Nombre" value='<%= contactInfo.getName() %>' > 
		                <input type="text" name='value' placeholder="Valor" value='<%= contactInfo.getValue() %>' >
		                <input type="hidden" name='id' value=<%= contactInfo.getId() %>>
		                <input type="hidden" name='mail' value=<%= profile.getMail() %>>
		            </div>
		            <button type="button" class="btn-submit"  onclick="cerrarPopUp('<%= "overlay-contact-" + contactInfo.getId() %>', '<%= "popup-contact-" + contactInfo.getId() %>')">
		            	Volver
		            </button>
		            <button type="submit" class="btn-submit">
		            	Aceptar
		            </button>
		        </form>
		    </div>
		</div>
	<% } %>
	<!-- POP-UPS Fin Editar información de contacto-->
	
	<!-- POP-UPS Añadir información de contacto-->
	<div class="overlay" id='<%= "overlay-contact-add" %>' >
	    <div class="popup"  id='<%= "popup-contact-add" %>' >
	        <h3>Añadir información de contacto</h3>
	        <form action=<%= Messages.buildURL("/addContactInfo") %> method="post" accept-charset="utf-8">
	            <div class="contenedor-inputs">
					<input type="text" name='name' placeholder="Nombre" > 
	                <input type="text" name='value' placeholder="Valor" >
	                <input type="hidden" name='mail' value=<%= profile.getMail() %>>
	            </div>
	            <button type="button" class="btn-submit"  onclick="cerrarPopUp('overlay-contact-add', 'popup-contact-add')">
	            	Volver
	            </button>
	            <button type="submit" class="btn-submit">
	            	Aceptar
	            </button>
	        </form>
	    </div>
	</div>
	<!-- POP-UPS Fin Añadir información de contacto-->
	
	<!-- POP-UPS Añadir Publicación-->
	<div class="overlay"
	     id="overlay10">
	    <div class="popup"
	         id="popup10">
	        <a href="#"
	           id="btn-cerrar-popup10"
	           class="btn-cerrar-popup"
	           onclick="cerrarPopUp('overlay10', 'popup10')"><i
	                class="fas fa-times"></i></a>
	        <h3>Añadir Publicación</h3>
	        <form action="javascript:void(0)">
	            <div class="contenedor-inputs">
	                <input type="text"
	                       placeholder="Nombre">
	                <input type="text"
	                       placeholder="Enlace">
	                <textarea name="textarea"
	                          placeholder="Descripción"
	                          rows="10"
	                          cols="50"></textarea>
	                <h4>Colaboradores</h4>
	                <div id="popup50">
	                    <div class="estilotam3">
	                        <input type="text"
	                               placeholder="Nombre">
	                        <button type="button"
	                                onclick="addNodo('container3')"><i class="fas fa-plus"></i></button>
	                        <button type="button"
	                                onclick="deleteNodo('container3')"><i class="fas fa-minus"></i></button>
	                    </div>
	                    <div id="container3"></div>
	                </div>
	            </div>
	            <!--<Hemos puesto la función de cerrar popups hasta que se tenga la función>-->
	            <button type="submit"
	                    class="btn-submit"
	                    onclick="cerrarPopUp('overlay10', 'popup10')">Volver
	            </button>
	            <button type="submit"
	                    class="btn-submit"
	                    onclick="cerrarPopUp('overlay10', 'popup10')">Aceptar
	            </button>
	
	        </form>
	    </div>
	</div>
	<!-- POP-UPS Fin Añadir Publicación-->
	
	<!-- POP-UPS Editar Publicación-->
	<div class="overlay"
	     id="overlay12">
	    <div class="popup"
	         id="popup12">
	        <a href="#"
	           id="btn-cerrar-popup12"
	           class="btn-cerrar-popup"
	           onclick="cerrarPopUp('overlay12', 'popup12')"><i
	                class="fas fa-times"></i></a>
	        <h3>Editar Publicación</h3>
	        <form action="javascript:void(0)">
	            <div class="contenedor-inputs">
	                <input type="text"
	                       placeholder="Titulo">
	                <input type="text"
	                       placeholder="Enlace">
	                <textarea name="textarea"
	                          placeholder="Descripción"
	                          rows="10"
	                          cols="50"></textarea>
	                <h4>Colaboradores</h4>
	                <div id="popup52">
	                    <div class="estilotam3">
	                        <input type="text"
	                               placeholder="Nombre">
	                        <button type="button"
	                                onclick="addNodo('container2')"><i class="fas fa-plus"></i></button>
	                        <button type="button"
	                                onclick="deleteNodo('container2')"><i class="fas fa-minus"></i></button>
	                    </div>
	                    <div id="container2"></div>
	                </div>
	            </div>
	
	            <!--<Hemos puesto la función de cerrar popups hasta que se tenga la función>-->
	            <button type="submit"
	                    class="btn-submit"
	                    onclick="cerrarPopUp('overlay12', 'popup12')">Volver
	            </button>
	            <button type="submit"
	                    class="btn-submit"
	                    onclick="cerrarPopUp('overlay12', 'popup12')">Aceptar
	            </button>
	
	        </form>
	    </div>
	</div>
	<!-- POP-UPS Fin Editar Publicación-->
	<!-- POP-UPS Editar Foto-->
	<div class="overlay" id="overlay-pic">
	    <div class="popup" id="popup-pic">
	        <h3>Editar Foto</h3>
	        <form action=<%= Messages.buildURL("/editProfilePic") %> method="post" accept-charset="UTF-8" enctype="multipart/form-data">
		        <div class="contenedor2">
	                <input class="fileinput" type="file" id="newPhoto" name="newPhoto" accept="image/*" onChange="showPreview(this)">
	                <label for="newPhoto">Seleccione archivo</label>
		            <img id="pic-preview" src="http://placehold.it/200" alt="Nueva Foto"></img>
	                <input type="hidden" name="mail" value='<%= profile.getMail() %>'>
		        </div>
	            <button type="button" class="btn-submit" onclick="cerrarPopUp('overlay-pic', 'popup-pic')">
	            	Volver
	            </button>
	            <button type="submit" class="btn-submit">
	            	Aceptar
	            </button>
	        </form>
	    </div>
	</div>
	<!-- POP-UPS Fin Editar Foto-->
	
	<!-- Fin POP-UPS -->
	<jsp:include page="/include/footer.jsp"/>
	
</body>