<%-- 
    Document   : index
    Created on : 25 de set. de 2023, 13:59:24
    Author     : Fatec
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Index - SessionApp</title>
        <%@include file="WEB-INF/jspf/html-head-libs.jspf"%>
    </head>
    <body>
        <%@include file="WEB-INF/jspf/navbar.jspf"%>
        <div class="m-2">
            <%if(userName!=null){%>
            <h2>Página Inicial</h2>
            <div>Conteúdo da página</div>
        </div>
            <%}%>
        <%@include file="WEB-INF/jspf/html-body-libs.jspf"%>
    </body>
</html>
