<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="com.classes.Utilisateur"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>ACceuil</title>
	<link href="resources/css/acceuil.css" rel="stylesheet" >

</head>
<body>
	<div class="container">
	
		<% 	HttpSession sess=request.getSession();
			List<Utilisateur> utilisateurs=(List)sess.getAttribute("utilisateurs");
			
			Utilisateur u=(Utilisateur) sess.getAttribute("utilisateur");
		%>
		<p class="textBienvenu">Bienvenu <%= u.getNom() %>!</p>
		
		<!-- Création d'un tableau pour l'affichege de la liste des utilisateurs -->
		
		<table border="1" cellpadding="5">
	        <caption><h2>List des utilisateurs</h2></caption>
	        <tr>
	            <th>Nom</th>
	            <th>Prénom</th>
	            <th>Pseudo</th>
	            <th>Email</th>
	        </tr>
	
			<% for(Utilisateur user:utilisateurs) { %> 			
		 		<tr>
				    <td><%=user.getNom() %></td>
				 	<td><%=user.getPrenom() %></td>
				 	<td><%=user.getPseudo() %></td>
				    <td><%=user.getEmail() %></td>
			 
			 	</tr>
			<%} %>
		</table>
		
		
		
		
		<form method="post" action="login">
			<input class="btn" type="submit" value="Deconnection"/>
		</form>
	</div>
	
</body>
</html>