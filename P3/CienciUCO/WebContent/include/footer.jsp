<%@page import="messages.Messages" %>
<footer>
    <div class="row">
        <div class="col-3">
            <a href="<%= Messages.urlFromKey("Pages.about")%>" class="button">Sobre nosotros</a>
        </div>
        <div class="col-3">
            <a href="<%= Messages.urlFromKey("Pages.terms")%>" class="button">T�rminos y Condiciones</a>
        </div>
        <div class="col-3">
            <a href="<%= Messages.urlFromKey("Pages.privacy")%>" class="button">Pol�tica de privacidad</a>
        </div>
    </div>
</footer>