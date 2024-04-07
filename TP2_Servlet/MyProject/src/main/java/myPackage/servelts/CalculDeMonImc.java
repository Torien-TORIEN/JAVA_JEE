package myPackage.servelts;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
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
		// Type du retour
		response.setContentType("text/html");
		//Get parametters
		float poids=Float.parseFloat(request.getParameter("poids"));
		float taille=Float.parseFloat(request.getParameter("taille"));
		// Writter
		PrintWriter out = response.getWriter();
		
		out.println("<!DOCTYPE html>"
				+ "<html>"
				+ "<head>"
				+ "<title>Example</title>"
				+ "</head>"
				+ "<body>"
				+ "<p> La masse corporelle est "+poids/(taille*taille)+"</p>"
				+ "</body>"
				+ "</html>");
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		// Type du retour
				response.setContentType("text/html");
				//Get parametters
				float poids=Float.parseFloat(request.getParameter("poids"));
				float taille=Float.parseFloat(request.getParameter("taille"));
				// Writter
				PrintWriter out = response.getWriter();
				
				out.println("<!DOCTYPE html>"
						+ "<html>"
						+ "<head>"
						+ "<title>Example</title>"
						+ "</head>"
						+ "<body>"
						+ "<p> La masse corporelle est "+poids/(taille*taille)+"</p>"
						+ "</body>"
						+ "</html>");
	}

}
