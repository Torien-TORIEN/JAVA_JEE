<%@ page import="java.util.*" %>
<!DOCTYPE html>
<html>
	<head> <meta charset="UTF-8"> <title>Quand et où ? </title> </head>
	<body>
		<p>
		<% Date date = new Date(); %>
			Nous sommes le <%= date %><br>
			Le nom du serveur sur lequel vous êtes connecté : localhost <br>
		</p>
	</body>
</html>