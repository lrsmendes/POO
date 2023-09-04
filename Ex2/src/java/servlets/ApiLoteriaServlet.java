package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.HashSet;
import java.util.Random;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.json.JSONObject;

@WebServlet(name = "ApiLoteriaServlet", urlPatterns = {"/loteria.json"})
public class ApiLoteriaServlet extends HttpServlet {
    private final int[] numerosLoteria = new int[6];
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        gerarNumerosLoteria();
        response.setContentType("application/json;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            JSONObject obj = new JSONObject();
            obj.append("dataHora", new Date().toString());
            obj.append("numerosLoteria", numerosLoteria);
            out.print(obj.toString());
        }
    }

    private void gerarNumerosLoteria() {
        Random gerador = new Random();
        HashSet<Integer> numerosGerados = new HashSet<>();

        while (numerosGerados.size() < 6) {
            int numeroAleatorio = gerador.nextInt(60) + 1; 
            numerosGerados.add(numeroAleatorio);
        }

        int i = 0;
        for (int numero : numerosGerados) {
            numerosLoteria[i++] = numero;
        }
    }

}
