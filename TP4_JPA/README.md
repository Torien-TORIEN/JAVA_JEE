# TP3 Java Server Page (JSP)
Une Java Server Page (JSP) est une page html avec du code(Java) s’exécutant coté serveur.

![jsp](../assets/jsp.png)
- Tout ce qui peut être fait avec une servlet peut être fait par une jsp (et inversement). 

## Servlets vs JSP
- Les servlets sont peu adaptées à la génération de contenu.  
- Les pages JSP sont peu adaptées à la gestion de la logique de l’application et à l’extension de fonctions du serveur.  

## Exemple du code :
	<%-- Ceci est un commentaire JSP --%>
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
	</html> 
	

## 1 - Commentaire
	<%-- Ceci est un test --%>.

## 2- Directives (Import)
	<%@ page import="java.util.*" %>
#
	Avant JSP 2.0 :
	<%@ NomDirective{attribut="valeur"}%>
	
	Depuis JSP 2.0 :
	<jsp:directive.NomDirective attribut="valeur" />

### Exemple :
	<%@ page import="java.util.Date" %>
	<jsp:directive.page import="java.util.Date" />
	
	<%@ include file="maPage.jsp" %>
	<jsp:directive.include file="maPage.jsp" />

## 3- Scriplets (des codes java)
	<% Date date = new Date(); %>

## 4- Declarations
	<%! int nombreVisites = 0; %>
#
	Avant JSP 2.0 :
	<%! private classe objet = valeur %>
	
	Depuis JSP 2.0 :
	<jsp:declaration> ... </jsp:declaration>
	
### Exemple 
	<%! private int VariableDInstance = 5 %>
	<%! private void methodeBlabla() {...} %>
#
	<H1>Un titre</H1>
	<jsp:declaration>
	private String randomHeading() {
	return("<H2>"+ Math.random() + "</H2>"); }
	</jsp:declaration>
	<%= randomHeading() %>

## 5- Expression (ou appel) transformé en chaine 
	<%= nombreVisites %>
#
	Avant JSP 2.0 : 
		<%= CodeGenerantString %>
	Depuis JSP 2.0 :
		<jsp:expression> CodeGenerantString </jsp:expression>
### Exemple 
	Avant JSP 2.0 : 
		<%= a.ToString() %>
	Depuis JSP 2.0 :
		<jsp:expression> a.ToString() </jsp:expression>



# Créer un projet 
`File > New > Dynamyc web Project ` dans webapp Créer des fichier jsp


