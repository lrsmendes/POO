/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package web;

import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.Calendar;

/**
 *
 * @author Fatec
 */
@WebServlet(name = "GreetingServlet", urlPatterns = {"/greeting.html"})
public class GreetingServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        Calendar calendar = Calendar.getInstance();
        int hourOfDay = calendar.get(Calendar.HOUR_OF_DAY);

        String greetingMessage;

        if (hourOfDay >= 6 && hourOfDay < 12) {
            greetingMessage = "Bom dia";
        } else if (hourOfDay >= 12 && hourOfDay < 18) {
            greetingMessage = "Boa tarde";
        } else {
            greetingMessage = "Vá dormir";
        }

        out.println("<html>");
        out.println("<head><title>Cumprimento</title></head>");
        out.println("<body>");
        out.println("<h1>" + greetingMessage + "</h1>");
        out.println("</body>");
        out.println("</html>");
    }
}