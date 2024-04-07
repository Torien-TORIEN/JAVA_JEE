# TP2 : Servlet 

## C'est quoi un servlet ?
Un servlet est une classe Java qui s'exécute sur le côté serveur pour gérer les requêtes et les réponses HTTP dans une application web. En d'autres termes, un servlet est une composante côté serveur qui étend les fonctionnalités d'un serveur web. Une fois déployé dans un conteneur servlet, tel que Apache Tomcat ou Jetty, un servlet est chargé, initialisé et exécuté pour traiter les demandes HTTP entrantes et générer des réponses dynamiques.

- **Générer des réponses HTTP :** Les servlets sont capables de générer des réponses HTTP dynamiques à partir des requêtes entrantes. Ils peuvent créer des pages HTML, du texte, des images, des fichiers PDF, etc., en fonction de la logique métier définie dans le code servlet.
- **Gérer les requêtes HTTP :** Les servlets peuvent gérer différents types de requêtes HTTP, tels que GET, POST, PUT, DELETE, etc. Ils peuvent extraire des données des requêtes entrantes, effectuer des opérations en fonction de ces données, puis générer des réponses appropriées.
- **Traitement des sessions :** Les servlets peuvent gérer les sessions utilisateur en utilisant des mécanismes de suivi de session. Cela leur permet de maintenir l'état de l'application entre les requêtes HTTP successives d'un même utilisateur.
- **Gestion des cycles de vie :** Les servlets suivent un cycle de vie défini par le conteneur servlet. Ils sont chargés, initialisés, exécutés pour traiter les requêtes et finalement détruits lorsqu'ils ne sont plus nécessaires.
- **Extensibilité :** Les servlets peuvent être étendus pour implémenter des fonctionnalités avancées. Ils peuvent être utilisés conjointement avec d'autres technologies Java, telles que les JSP (JavaServer Pages), les filtres servlet, les listeners servlet, etc., pour créer des applications web robustes et évolutives.

## Créer servlet
- C'est comme créer une classe mais `New > Servelet` :
![Create servlet ](../assets/TP2_create_servlet.png)

### URL : @WebServlet("/MyURL")
- Url pour acceder à ce servlet là est :`localhost:8080/MyProjectName/MyURL`

### Methodes :
- Il y a plusieurs methodes :
	- **doGet** : qui gère la requette de type GET qui arrive à cette URL
	- **doPost** : qui gèrer la requette de type POST qui arrive à cette URL

### Les paramettres de la requette : MyURL?param1=1&param2=torien
- les paramètres sont disponibles dans `request.getParameter("nom_params")` mais il faut les caster  
## 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		float poids=Float.parseFloat(request.getParameter("poids"));
		float taille=Float.parseFloat(request.getParameter("taille"));
		
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

### Comment renvoyer une reponse ?
	//Importer PrintWriter `import java.io.PrintWriter;`
	// Dans la fonction declarer 
	PrintWriter out = response.getWriter();
	//Et enfin donner la reponse
	out.println("ma reponse ")

### Type de la reponse 
	response.setContentType("text/html");
	

## COKIES 

### Ecriture 
- Import
	import javax.servlet.http.Cookie;

- Declaration et ajout `new Cookie("String_key", "String_value")`
# 
	// Création des cookies
	double poids=70;
	double taille=1.73;
	double imc=23.39;
	Cookie cookiePoids = new Cookie("poids", Double.toString(poids));
	Cookie cookieTaille = new Cookie("taille", Double.toString(taille));
	Cookie cookieImc = new Cookie("imc", Double.toString(imc));

- Ajoutt dans la reponse
#	
	response.addCookie(cookiePoids);
    response.addCookie(cookieTaille);
    response.addCookie(cookieImc);

- Redirection 
#
	// Redirection vers la servlet TableauDeBord
    response.sendRedirect("TableauDeBord");

#### Exemple 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
        
        // Récupération des paramètres poids et taille
        double poids = Double.parseDouble(request.getParameter("poids"));
        double taille = Double.parseDouble(request.getParameter("taille"));
        
        // Calcul de l'IMC
        this.monImc = new Imc(taille, poids);
        double imc = this.monImc.calcul();
        
        // Création des cookies
        Cookie cookiePoids = new Cookie("poids", Double.toString(poids));
        Cookie cookieTaille = new Cookie("taille", Double.toString(taille));
        Cookie cookieImc = new Cookie("imc", Double.toString(imc));
        
        // Ajout des cookies à la réponse
        response.addCookie(cookiePoids);
        response.addCookie(cookieTaille);
        response.addCookie(cookieImc);
        
        // Redirection vers la servlet TableauDeBord
        response.sendRedirect("TableauDeBord");
		
	}


### Lecture des cookies
- reçoit tableau de cookie   
- Acceder au cookie :`cookie.getName()`  
#### Exemple 
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        
        // Récupération des cookies
        Cookie[] cookies = request.getCookies();
        double poids = 0, taille = 0, imc = 0;
        
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("poids")) {
                    poids = Double.parseDouble(cookie.getValue());
                } else if (cookie.getName().equals("taille")) {
                    taille = Double.parseDouble(cookie.getValue());
                } else if (cookie.getName().equals("imc")) {
                    imc = Double.parseDouble(cookie.getValue());
                }
            }
        }
        
        PrintWriter out = response.getWriter();
        out.println("<!DOCTYPE html>"
                + "<html>"
                + "<head>"
                + "<title>Tableau de Bord</title>"
                + "</head>"
                + "<body>"
                + "<h1>Tableau de Bord</h1>"
                + "<p>Poids : " + poids + "</p>"
                + "<p>Taille : " + taille + "</p>"
                + "<p>IMC : " + imc + "</p>"
                + "</body>"
                + "</html>");
    }


## SESSIONS