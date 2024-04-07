<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8" errorPage="error.jsp" %>
<!DOCTYPE html>

<html>
	<head>
	<meta charset="UTF-8">
	<title>Division par zero !</title>
	</head>
	<body>
		<%
		if(request.getParameter("attention") == null)
			{response.getWriter().append("Cette page fonctionne !<br>"); }
		else
			{int i = 1/0;}
		%>
	</body>
</html>