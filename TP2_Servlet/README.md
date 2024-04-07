## TP2 : Servlet 

### C'est quoi un servlet ?
Un servlet est une classe Java qui s'exécute sur le côté serveur pour gérer les requêtes et les réponses HTTP dans une application web. En d'autres termes, un servlet est une composante côté serveur qui étend les fonctionnalités d'un serveur web. Une fois déployé dans un conteneur servlet, tel que Apache Tomcat ou Jetty, un servlet est chargé, initialisé et exécuté pour traiter les demandes HTTP entrantes et générer des réponses dynamiques.

- **Générer des réponses HTTP :** Les servlets sont capables de générer des réponses HTTP dynamiques à partir des requêtes entrantes. Ils peuvent créer des pages HTML, du texte, des images, des fichiers PDF, etc., en fonction de la logique métier définie dans le code servlet.
- **Gérer les requêtes HTTP :** Les servlets peuvent gérer différents types de requêtes HTTP, tels que GET, POST, PUT, DELETE, etc. Ils peuvent extraire des données des requêtes entrantes, effectuer des opérations en fonction de ces données, puis générer des réponses appropriées.
- **Traitement des sessions :** Les servlets peuvent gérer les sessions utilisateur en utilisant des mécanismes de suivi de session. Cela leur permet de maintenir l'état de l'application entre les requêtes HTTP successives d'un même utilisateur.
- **Gestion des cycles de vie :** Les servlets suivent un cycle de vie défini par le conteneur servlet. Ils sont chargés, initialisés, exécutés pour traiter les requêtes et finalement détruits lorsqu'ils ne sont plus nécessaires.
- **Extensibilité :** Les servlets peuvent être étendus pour implémenter des fonctionnalités avancées. Ils peuvent être utilisés conjointement avec d'autres technologies Java, telles que les JSP (JavaServer Pages), les filtres servlet, les listeners servlet, etc., pour créer des applications web robustes et évolutives.
