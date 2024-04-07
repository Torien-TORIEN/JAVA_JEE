package peter.zaineb;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.*;

/**
 * Servlet implementation class TableauDeBord
 */
@WebServlet("/TableauDeBord")
public class TableauDeBord extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TableauDeBord() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		HttpSession session =request.getSession();
		Imc monImc=new Imc(Double.parseDouble(session.getAttribute("poids").toString()),Double.parseDouble(session.getAttribute("taille").toString()));
		PrintWriter out = response.getWriter();
		out.println("<!DOCTYPE html>"
				+ "<html>"
				+ "<head>"
				+ "<title>Example</title>"
				+ "</head>"
				+ "<body>"
				+ "<p> La masse corporelle est "+monImc.calcul()+"</p>"
				+ "</body>"
				+ "</html>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
