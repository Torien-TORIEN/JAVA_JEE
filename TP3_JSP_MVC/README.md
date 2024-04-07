# TP3 Java Server Page (JSP)
Une Java Server Page (JSP) est une page html avec du code(Java) s’exécutant coté serveur.

![jsp](../assets/jsp.png)
- Tout ce qui peut être fait avec une servlet peut être fait par une jsp (et inversement). 

## Servlets vs JSP
- Les servlets sont peu adaptées à la génération de contenu.  
- Les pages JSP sont peu adaptées à la gestion de la logique de l’application et à l’extension de fonctions du serveur.  

## Exemple du code :
``` <%-- Ceci est un commentaire JSP --%>
<%@ page contentType="text/html" %>
<%@ page errorPage="erreur.jsp" %>
<%@ page import="java.util.*" %>
<html>
<head><title>Une page JSP</title></head>
<body>
<%! int nombreVisites = 0; %>
<% //Il est possible d'écrire du code Java ici
Date date = new Date();
nombreVisites++; // portée de cette variable ?
%>
<h1>Exemple de page JSP</h1>
Au moment de l'exécution de cette jsp, nous sommes le <%= date %>.
Cette page a été affichée <%= nombreVisites %> fois !
</body>
</html> ```


