package myPackage.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ToUpperCase")
public class ToUpperCase extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Récupérer la valeur du paramètre "nom"
        String nom = request.getParameter("nom");
        
        // Vérifier si le paramètre "nom" est présent
        if(nom != null) {
            // Mettre en majuscule le nom
            String nomEnMajuscule = nom.toUpperCase();
            
            // Ajouter l'attribut à l'objet request
            request.setAttribute("AttributNomEnMajuscule", nomEnMajuscule);
        }
        
        // Transmettre automatiquement le traitement à la page vue.jsp
        request.getRequestDispatcher("/WEB-INF/vue.jsp").forward(request, response);
    }
}
