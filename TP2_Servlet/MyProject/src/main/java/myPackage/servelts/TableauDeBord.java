package myPackage.servelts;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/TableauDeBord")
public class TableauDeBord extends HttpServlet {
    private static final long serialVersionUID = 1L;
       
    public TableauDeBord() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        
        // Récupération des cookies
        Cookie[] cookies = request.getCookies();
        double poids = 0, taille = 0, imc = 0;
        
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("poids")) {
                    poids = Double.parseDouble(cookie.getValue());
                } else if (cookie.getName().equals("taille")) {
                    taille = Double.parseDouble(cookie.getValue());
                } else if (cookie.getName().equals("imc")) {
                    imc = Double.parseDouble(cookie.getValue());
                }
            }
        }
        
        PrintWriter out = response.getWriter();
        out.println("<!DOCTYPE html>"
                + "<html>"
                + "<head>"
                + "<title>Tableau de Bord</title>"
                + "</head>"
                + "<body>"
                + "<h1>Tableau de Bord</h1>"
                + "<p>Poids : " + poids + "</p>"
                + "<p>Taille : " + taille + "</p>"
                + "<p>IMC : " + imc + "</p>"
                + "</body>"
                + "</html>");
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}