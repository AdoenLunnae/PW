<%@page import="messages.Messages" %>
<footer>
    <div class="row">
        <div class="col-3">
            <a href="<%= Messages.urlFromKey("Pages.about")%>" class="button">Sobre nosotros</a>
        </div>
        <div class="col-3">
            <a href="<%= Messages.urlFromKey("Pages.terms")%>" class="button">Términos y Condiciones</a>
        </div>
        <div class="col-3">
            <a href="<%= Messages.urlFromKey("Pages.privacy")%>" class="button">Política de privacidad</a>
        </div>
    </div>
</footer>