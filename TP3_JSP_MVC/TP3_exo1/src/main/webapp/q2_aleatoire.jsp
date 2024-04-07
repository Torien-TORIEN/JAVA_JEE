<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.Random" %>
<!DOCTYPE html>
<html>
	<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Ne pas oublier l'import de java.util.Random ;-)</title>
	</head>
	<body>
		<% //code JAVA ICI
		Random random = new Random();
		// Génération d'un entier aléatoire entre 0 (inclus) et 100 (exclus)
        int randomNumber = random.nextInt(100);
		%>
	
	
		Le nombre aléatoire généré est <%= randomNumber %>. <br>
		<a href="<%= request.getRequestURI() %>">Recommencer !</a>
	</body>
</html>