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
		// G�n�ration d'un entier al�atoire entre 0 (inclus) et 100 (exclus)
        int randomNumber = random.nextInt(100);
		%>
	
	
		Le nombre al�atoire g�n�r� est <%= randomNumber %>. <br>
		<a href="<%= request.getRequestURI() %>">Recommencer !</a>
	</body>
</html>