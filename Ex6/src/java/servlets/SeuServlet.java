/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/raziel.json")
public class SeuServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("application/json");
        
        PrintWriter out = response.getWriter();
        out.print("{\"RA\":\"1290482212011\", \"nome\":\"Lucas Raziel\", \"disciplinas\":[\"Banco de Dados\",\"Engenharia de Software III\",\"Programacao Orientada a Objetos\"]}");
        out.flush();
    }
}
