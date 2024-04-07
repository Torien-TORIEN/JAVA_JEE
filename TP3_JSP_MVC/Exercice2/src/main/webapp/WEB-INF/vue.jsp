<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Page Vue</title>
</head>
<body>
    <%-- Récupérer la valeur de l'attribut "AttributNomEnMajuscule" --%>
    <% String nomEnMajuscule = (String) request.getAttribute("AttributNomEnMajuscule"); %>
    
    <%-- Vérifier si l'attribut est présent --%>
    <% if(nomEnMajuscule != null) { %>
        <h2>Bonjour <%= nomEnMajuscule %></h2>
    <% } else { %>
        <h2>Le nom en majuscule n'est pas disponible</h2>
    <% } %>
</body>
</html>
