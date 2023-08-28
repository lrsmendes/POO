package web;

import jakarta.servlet.annotation.WebServlet;
import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(name = "EuServlet", urlPatterns = {"/eu.html"})


public class EuServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    
    private final String meuRA = "1290482212011";
    private final String meuNome = "Lucas Raziel Silva Mendes";
    private final int minhaIdade = 19;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        out.println("<html>");
        out.println("<head><title>Meu Perfil</title></head>");
        out.println("<body>");
        out.println("<h1>Meu RA: " + meuRA + "</h1>");
        out.println("<h2>Meu Nome: " + meuNome + "</h2>");
        out.println("<h2>Minha Idade: " + minhaIdade + "</h2>");
        out.println("</body>");
        out.println("</html>");
    }
}
