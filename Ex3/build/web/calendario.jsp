<%-- 
    Document   : calendario
    Created on : 11 de set. de 2023, 13:29:38
    Author     : Fatec
--%>

<%@page import="java.util.Calendar"%>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Calendário</title>
</head>
<body>
    <h1>Calendário</h1>
        <%-- GPT (não consegui fazer!) --%>
    <form action="calendario.jsp" method="get">
        Ano:
        <select name="ano">
            <% for (int ano = 1900; ano <= 2100; ano++) { %>
                <option value="<%= ano %>"><%= ano %></option>
            <% } %>
        </select>
        Mês:
        <select name="mes">
            <%
                String[] mesesStr = {"Janeiro", "Fevereiro", "Março", "Abril", "Maio", "Junho", "Julho", "Agosto", "Setembro", "Outubro", "Novembro", "Dezembro"};
                for (int mes = 1; mes <= 12; mes++) {
                    out.println("<option value=\"" + mes + "\">" + mesesStr[mes - 1] + "</option>");
                }
            %>
        </select>
        <input type="submit" value="Mostrar Calendário">
    </form>
        <%-- GPT (não consegui fazer!) --%>

    <%
        int ano = 2023;
        int mes = 9;   

        String anoStr = request.getParameter("ano");
        String mesStr = request.getParameter("mes");

        if (anoStr != null && !anoStr.isEmpty()) {
            ano = Integer.parseInt(anoStr);
        }

        if (mesStr != null && !mesStr.isEmpty()) {
            mes = Integer.parseInt(mesStr);
        }

        if (ano >= 1900 && ano <= 2100 && mes >= 1 && mes <= 12) {
            out.println("<h2>" + mesesStr[mes - 1] + " " + ano + "</h2>");
            out.println("<table border='1'>");
            out.println("<tr>");
            out.println("<th>Dom</th>");
            out.println("<th>Seg</th>");
            out.println("<th>Ter</th>");
            out.println("<th>Qua</th>");
            out.println("<th>Qui</th>");
            out.println("<th>Sex</th>");
            out.println("<th>Sáb</th>");
            out.println("</tr>");

            java.util.Calendar calendario = java.util.Calendar.getInstance();
            calendario.set(ano, mes - 1, 1);
            int primeiroDiaSemana = calendario.get(java.util.Calendar.DAY_OF_WEEK);
            int diaAtual = 1;

            out.println("<tr>");

            for (int i = 1; i < primeiroDiaSemana; i++) {
                out.println("<td></td>");
            }

            while (calendario.get(java.util.Calendar.MONTH) == mes - 1) {
                out.println("<td>" + diaAtual + "</td>");

                if (calendario.get(java.util.Calendar.DAY_OF_WEEK) == java.util.Calendar.SATURDAY) {
                    out.println("</tr><tr>");
                }

                calendario.add(java.util.Calendar.DAY_OF_MONTH, 1);
                diaAtual++;
            }

            out.println("</tr>");
            out.println("</table>");
        }
    %>
</body>
</html>