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
import java.util.HashSet;
import java.util.Random;

/**
 *
 * @author Fatec
 */
@WebServlet(name = "LoteriaServlet", urlPatterns = {"/loteria.html"})
public class LoteriaServlet extends HttpServlet {
    private static final int NUM_NUMBERS = 6;
    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 60;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<html><head><title>Numeros da Loteria</title></head><body>");
        out.println("<h1>Numeros da Loteria:</h1>");

        // Criar um array para armazenar os números únicos
        int[] uniqueNumbers = new int[NUM_NUMBERS];
        Random random = new Random();

        // Loop para gerar e armazenar os números únicos
        for (int i = 0; i < NUM_NUMBERS; i++) {
            int randomNumber;
            boolean isUnique;
            
            // Loop até encontrar um número único
            do {
                isUnique = true;
                // Gerar um número aleatório entre MIN_NUMBER e MAX_NUMBER
                randomNumber = random.nextInt(MAX_NUMBER - MIN_NUMBER + 1) + MIN_NUMBER;
                
                // Verificar se o número já existe no array
                for (int j = 0; j < i; j++) {
                    if (uniqueNumbers[j] == randomNumber) {
                        isUnique = false; // O número não é único
                        break;
                    }
                }
            } while (!isUnique); // Repetir até encontrar um número único
            
            // Armazenar o número único no array
            uniqueNumbers[i] = randomNumber;
        }

        // Exibir os números únicos na página
        out.println("<ul>");
        for (int number : uniqueNumbers) {
            out.println("<li>" + number + "</li>");
        }
        out.println("</ul>");

        out.println("</body></html>");
    }
}