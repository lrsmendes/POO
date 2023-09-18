<%-- 
    Document   : juros-compostos
    Created on : 18 de set. de 2023, 14:24:45
    Author     : Fatec
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Calculadora de Juros</title>
    </head>
    <body>
    <%@include file="WEB-INF/jspf/menu.jspf" %>
    <div style="display: inline-block;"> <!-- Adicione margem para espaçamento -->
    <form action="juros-compostos.jsp" method="post">
        <label for="c">Capital Inicial:</label>
        <input type="text" name="c" id="c">
        <br>
        <label for="i">Taxa de Juros:</label>
        <input type="text" name="i" id="i">
        <br>
        <label for="n">Tempo:</label>
        <input type="text" name="n" id="n">
        <input type="submit" value="Calcular">
    </form>
    </div>
        <%
         String n1Str = request.getParameter("c");
         String n2Str = request.getParameter("i");
         String n3Str = request.getParameter("n");
         
         double c = 0.0; // Valor padrão para evitar NullPointerException
         double i = 0.0;
         double n = 0.0;
         
         if (n1Str != null && !n1Str.isEmpty()) {
             c = Double.parseDouble(n1Str);
         }
         if (n2Str != null && !n2Str.isEmpty()) {
             i = Double.parseDouble(n2Str);
             i = i / 100; // Converta a taxa de porcentagem para decimal
         }
         if (n3Str != null && !n3Str.isEmpty()) {
             n = Double.parseDouble(n3Str);
         }
         
         double m = c * Math.pow(1 + i, n);
         String m2 = String.format("%.2f", m);
        %>
        
        <p>Capital Inicial: <%= c %></p>
        <p>Taxa de Juros: <%= i %></p>
        <p>Tempo: <%= n %></p>
        <h1>O montante será de: <%= m2 %>R$.</h1>
    </body>
</html>
