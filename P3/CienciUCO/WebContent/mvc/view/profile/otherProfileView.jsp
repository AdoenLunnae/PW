<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ page import="messages.Messages" %>
<jsp:useBean id="profile" class="es.uco.pw.display.beans.ProfileBean" scope="session"/>
<head>
	<% request.setCharacterEncoding("utf-8"); %>
	<jsp:include page="/include/common-head.jsp">
		<jsp:param name="title" value="<%= profile.getName() %>" />
	</jsp:include>
	<link rel="stylesheet" href=<%= Messages.buildURL("/css/popups.css") %>>
	<script type="text/javascript" src=<%= Messages.buildURL("/js/popup.js") %>></script>
</head>
<body>
	<jsp:include page="/include/header.jsp"/>
	<div class="barra-cabecera">
	    <div class="contenedor-cabecera">
	        <div class="w-1/4">
	            <div class="circle-crop ml-6 -mt-5">
	            	<img src= "<%= "data:image/jpeg;base64, " + profile.getBase64Image() %>" alt="logo" 
	            		class="imagen-perfil" onClick="abrirPopUp('overlay-pic', 'popup-pic')"/>
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
	                    <td>
	                    	<a href="mailto:sg@uco.es" class="descripcion-elemento">
	                    		<%= profile.getMail() %>
	                    	</a>
	                    </td>
	                </tr>
	                <tr>
	                    <td><span class="nombre-elemento">Teléfono</span></td>
	                    <td><span class="descripcion-elemento"><%= profile.getPhone() %></span></td>
	                </tr>
	                <% for( es.uco.pw.display.beans.ContactInfoBean contactInfo : profile.getAllContactInfo() ) { %>
	                	<tr>
		                    <td><span class="nombre-elemento"><%= contactInfo.getName() %></span></td>
		                    <td><span class="descripcion-elemento"><%= contactInfo.getValue() %></span></td>
	                	</tr>
	                <% } %>
	            </table>
	        </div>
	        <!-- Contactos -->
	        <div class="caja">
	            <div class="titulo-caja">Contactos</div>
	            <!-- Elemento contacto -->
	            <div class="elemento-caja">
	                <div class="py-2"><a href="#"><img src=<%= Messages.buildURL("/img/perfil.png") %>
	                                                   alt="avatar"
	                                                   class="imagen-contacto"></a></div>
	                <div class="informacion-contacto">
	                    <div><a href="#"
	                            class="nombre-elemento">Pedro Sánchez</a></div>
	                    <div class="descripcion-elemento"> Presidente del Gobierno y secretario general del PSOE</div>
	                </div>
	            </div>
	            <!-- Elemento contacto -->
	            <div class="elemento-caja">
	                <div class="py-2"><a href="#"><img src=<%= Messages.buildURL("/img/perfil.png") %>
	                                                   alt="avatar"
	                                                   class="imagen-contacto"></a></div>
	                <div class="informacion-contacto">
	                    <div><a href="#"
	                            class="nombre-elemento">Pablo Casado</a></div>
	                    <div class="descripcion-elemento">Presidente del Partido Popular</div>
	                </div>
	            </div>
	            <!-- Elemento contacto -->
	            <div class="elemento-caja">
	                <div class="py-2"><a href="#"><img src=<%= Messages.buildURL("/img/perfil.png") %>
	                                                   alt="avatar"
	                                                   class="imagen-contacto"></a></div>
	                <div class="informacion-contacto">
	                    <div><a href="#"
	                            class="nombre-elemento">Santiago Abascal Conde</a></div>
	                    <div class="descripcion-elemento">Presidente de Vox</div>
	                </div>
	            </div>
	            <!-- Elemento contacto -->
	            <div class="elemento-caja">
	                <div class="py-2"><a href="#"><img src=<%= Messages.buildURL("/img/perfil.png") %>
	                                                   alt="avatar"
	                                                   class="imagen-contacto"></a></div>
	                <div class="informacion-contacto">
	                    <div><a href="#"
	                            class="nombre-elemento">Pablo Iglesias</a></div>
	                    <div class="descripcion-elemento">Secretario general de Podemos</div>
	                </div>
	            </div>
	            <!-- Elemento contacto -->
	            <div class="elemento-caja">
	                <div class="py-2"><a href="#"><img src=<%= Messages.buildURL("/img/perfil.png") %>
	                                                   alt="avatar"
	                                                   class="imagen-contacto"></a></div>
	                <div class="informacion-contacto">
	                    <div><a href="#"
	                            class="nombre-elemento">Inés Arrimadas</a></div>
	                    <div class="descripcion-elemento">Portavoz de Ciudadanos en el Congreso de los Diputados</div>
	                </div>
	            </div>
	            
	        </div>
	    </div>
	
	    <!-- Columna central -->
	    <div class="w-full lg:w-1/2 mb-4">
	        <!-- Sobre mí -->
	        <div class="caja">
	            <div class="titulo-caja">
	            	SOBRE MÍ
	            </div>
	            <div class="elemento-caja">
	                <div>
	                    <%= profile.getParsedAboutMe() %>
	                </div>
	            </div>
	        </div>
	
	        <!-- Formación -->
	        <div class="caja">
	            <div class="titulo-caja">
	            	FORMACIÓN
	            </div>
	            <!-- Elemento formación -->
	            <div class="elemento-caja">
	                <div class="py-2">
	                	<a href="./perfil-empresa.html">
	                		<img src=<%= Messages.buildURL("/img/perfil.png") %> alt="avatar" class="imagen-contacto">
	                	</a>
	                </div>
	                <div class="informacion-contacto">
	                    <div class="flex justify-between">
	                        <div>
	                        	<a href="./perfil-empresa.html" class="nombre-elemento">
	                        		IES Gran Capitán de Córdoba
	                        	</a>
	                        </div>
		                    <div class="descripcion-elemento">
		                    	2012 - 2014
		                    </div>
	                	</div>
	            	</div>
	       		</div>
	       	</div>
	
	        <!-- Experiencia -->
	        <div class="caja">
	            <div class="titulo-caja">EXPERIENCIA</div>
	            <!-- Elemento experiencia -->
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
		                    </div>
		                    <div class="descripcion-elemento">
			                    <%=  experience.getDescripcion() %>
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
	        </div>
	        <!-- Artículos  -->
	        <div class="caja">
	            <div class="titulo-caja">
	            	ARTÍCULOS PUBLICADOS
	            </div>
	            <!-- Elemento artículo -->
	            <div>
	                <div class="elemento-caja">
	                    <div class="informacion-contacto">
	                        <div class="flex justify-between">
	                            <div class="nombre-elemento">Título del artículo</div>
	                        </div>
	                        <div class="descripcion-elemento">
	                        	Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed
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
	            
	        </div>
	
	        <!-- Patentes -->
	        <div class="caja">
	            <div class="titulo-caja">
	            	PATENTES
	            </div>
	            <!-- Elemento patente -->
	            <div>
	                <div class="elemento-caja">
	                    <div class="informacion-contacto">
	                        <div class="flex justify-between">
	                            <div class="nombre-elemento">Título de la patente</div>
	                        </div>
	                        <div class="descripcion-elemento">
	                        	Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed
	                            do eiusmod tempor incididunt ut labore et dolore magna aliqua.
	                        </div>
	                    </div>
	                </div>
	                <div class="linea-colaboradores">
	                    <span><a href="#"><img src=<%= Messages.buildURL("/img/perfil.png") %>
	                                           alt="avatar"
	                                           class="imagen-contacto-peq"></a></span> &nbsp;
	                </div>
	            </div>
	        </div>
	    </div>
	</div>
	
	<div class="overlay" id="overlay-pic" onclick="cerrarPopUp('overlay-pic', 'popup-pic')">
	    <div class="popup" id="popup-pic" onclick="javascript:void(0)">
            <img src= "<%= "data:image/jpeg;base64, " + profile.getBase64Image() %>" alt="logo" class="imagen-perfil"/>
			
	    </div>
	</div>
	
	<jsp:include page=<%= Messages.buildURL( Messages.getString("Pages.footer") ) %>/>
	
</body>