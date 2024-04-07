<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Erreur</title>
</head>
<body>
    <h1>Une erreur s'est produite</h1>
    <p>Une erreur est survenue lors du traitement de votre demande. Veuillez réessayer ultérieurement.</p>
    <p>Erreur : <%= exception.getMessage() %></p>
</body>
</html>
