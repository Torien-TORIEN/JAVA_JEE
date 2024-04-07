package myPackage.servelts;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/BandesDessinees")
public class BandesDessinees extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ArrayList<String> listeBandesDessinees;

    public BandesDessinees() {
        super();
        listeBandesDessinees = new ArrayList<String>();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<html>"
				+ "<head><title>Liste de nos bandes dessinées préférées</title></head>"
				+ "<body>"
				+ "<h4>Liste de nos bandes dessinées préférées </h4><ul>");
		for(String s : listeBandesDessinees) {
			out.println("<li>"+s+"</li>");
		}
				out.println("</ul><hr><form method=\"POST\" action=\"BandesDessinees\">"
				+ "Entrez un nom de bande dessinée :"
				+ "<input type=\"text\" name=\"bd\"><br/><br/>"
				+ "<input type=\"submit\" name=\"action\" value=\"Ajouter\">"
				+ "<input type=\"submit\" name=\"action\" value=\"Retirer\">"
				+ "</form>"
				+ "</body>"
				+ "</html>");
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
				String bd=request.getParameter("bd");
				response.setContentType("text/html");
				PrintWriter out = response.getWriter();
				out.println("<html>"
						+ "<head>");
				
				if(request.getParameter("action").equals("Ajouter") && !listeBandesDessinees.contains(bd)) {
					listeBandesDessinees.add(bd);
					out.println("<title>Ajout de bandes dessinées</title></head><body><h4>La bande dessinée "+bd+" a été enregistrée </h4> <hr> <a href=\"http://localhost:8080/MonProjet/BandesDessinees\">Retour au formulaire</a>");
					
					
				}else if(request.getParameter("action").equals("Retirer")) {
					String html="<title>Suppression de bandes dessinées</title></head><body><h4>La bande dessinée "+bd+" n'existe pas 404!  </h4> <hr> <a href=\"http://localhost:8080/MonProjet/BandesDessinees\">Retour au formulaire</a>";
					int notfound=1;
					for(String s :listeBandesDessinees) {
						if(s.equals(bd)) {
							listeBandesDessinees.remove(bd);
							out.println("<title>Suppression de bandes dessinées</title></head><body><h4>La bande dessinée "+bd+" a été supprimée </h4> <hr> <a href=\"http://localhost:8080/MonProjet/BandesDessinees\">Retour au formulaire</a>");
							notfound=0;
						}
					}
					if(notfound==0)
						out.println(html);
				}
				out.println("</body></html>");
	}

}
