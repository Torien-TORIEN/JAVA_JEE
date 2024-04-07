package myPackage.servelts;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import myPackage.metiers.Imc;

/**
 * Servlet implementation class CalculDeMonImc2
 */
@WebServlet("/CalculDeMonImc2")
public class CalculDeMonImc2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private Imc monImc;
       

    public CalculDeMonImc2() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Récupération des paramètres poids et taille
        double poids = Double.parseDouble(request.getParameter("poids"));
        double taille = Double.parseDouble(request.getParameter("taille"));
        
        // Calcul de l'IMC
        this.monImc = new Imc(taille, poids);
        double imc = this.monImc.calcul();
		
		// Stockage des données dans la session
	    HttpSession session = request.getSession();
	    session.setAttribute("poids", poids);
	    session.setAttribute("taille", taille);
	    session.setAttribute("imc", imc);
	    
	 // Redirection vers la servlet TableauDeBord
        response.sendRedirect("TableauDeBord2");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
