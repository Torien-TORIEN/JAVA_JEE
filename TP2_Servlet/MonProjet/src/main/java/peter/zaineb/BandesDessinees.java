package peter.zaineb;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class BandesDessinees
 */
@WebServlet("/BandesDessinees")
public class BandesDessinees extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ArrayList<String> listeBandesDessinees;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BandesDessinees() {
        super();
        listeBandesDessinees = new ArrayList<String>();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<html>"
				+ "<head><title>Liste de nos bandes dessin�es pr�f�r�es</title></head>"
				+ "<body>"
				+ "<h4>Liste de nos bandes dessin�es pr�f�r�es </h4><ul>");
		for(String s : listeBandesDessinees) {
			out.println("<li>"+s+"</li>");
		}
				out.println("</ul><hr><form method=\"POST\" action=\"BandesDessinees\">"
				+ "Entrez un nom de bande dessin�e :"
				+ "<input type=\"text\" name=\"bd\"><br/><br/>"
				+ "<input type=\"submit\" name=\"action\" value=\"Ajouter\">"
				+ "<input type=\"submit\" name=\"action\" value=\"Retirer\">"
				+ "</form>"
				+ "</body>"
				+ "</html>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		String bd=request.getParameter("bd");
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<html>"
				+ "<head>");
		
		if(request.getParameter("action").equals("Ajouter") && !listeBandesDessinees.contains(bd)) {
			listeBandesDessinees.add(bd);
			out.println("<title>Ajout de bandes dessin�es</title></head><body><h4>La bande dessin�e "+bd+" a �t� enregistr�e </h4> <hr> <a href=\"http://localhost:8080/MonProjet/BandesDessinees\">Retour au formulaire</a>");
			
			
		}else if(request.getParameter("action").equals("Retirer")) {
			String html="<title>Suppression de bandes dessin�es</title></head><body><h4>La bande dessin�e "+bd+" n'existe pas 404!  </h4> <hr> <a href=\"http://localhost:8080/MonProjet/BandesDessinees\">Retour au formulaire</a>";
			int notfound=1;
			for(String s :listeBandesDessinees) {
				if(s.equals(bd)) {
					listeBandesDessinees.remove(bd);
					out.println("<title>Suppression de bandes dessin�es</title></head><body><h4>La bande dessin�e "+bd+" a �t� supprim�e </h4> <hr> <a href=\"http://localhost:8080/MonProjet/BandesDessinees\">Retour au formulaire</a>");
					notfound=0;
				}
			}
			if(notfound==0)
				out.println(html);
		}
		out.println("</body></html>");
	}
	
	
}
	
	
	


