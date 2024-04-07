package myPackage.servelts;

import myPackage.metiers.*;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.PrintWriter;

/**
 * Servlet implementation class CalculDeMonImc
 */
@WebServlet("/CalculDeMonImc")
public class CalculDeMonImc extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private Imc monImc;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CalculDeMonImc() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
        
        // Récupération des paramètres poids et taille
        double poids = Double.parseDouble(request.getParameter("poids"));
        double taille = Double.parseDouble(request.getParameter("taille"));
        
        // Calcul de l'IMC
        this.monImc = new Imc(taille, poids);
        double imc = this.monImc.calcul();
        
        // Création des cookies
        Cookie cookiePoids = new Cookie("poids", Double.toString(poids));
        Cookie cookieTaille = new Cookie("taille", Double.toString(taille));
        Cookie cookieImc = new Cookie("imc", Double.toString(imc));
        
        // Ajout des cookies à la réponse
        response.addCookie(cookiePoids);
        response.addCookie(cookieTaille);
        response.addCookie(cookieImc);
        
        // Redirection vers la servlet TableauDeBord
        response.sendRedirect("TableauDeBord");
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
