<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	</head>
	<link href="resources/css/inscrire.css" rel="stylesheet" >
	
<body>
	<div class="container">
		<%--Entete --%>
		<header>
			<h2>Veuillez vous Connectez !</h2>
		</header>
		<%--Fin entete --%>
		
		<%--Debut body --%>
		<main>
			<%--Creation du formulaitre --%>
			<form method="post" action="login">
				<input class="form_line" type="text" name="pseudo" placeholder="Pseudo" >
				
				<input class="form_line" type="password" name="password" placeholder="Mot de Passe" >
				
				<% if (request.getAttribute("erreur")!=null) { %>
					<p class="error"> <%= request.getAttribute("erreur") %></p>
				<%} %>
				
				<input class="form_line btn" style="background-color: black; color:#FFFFFF;" type="submit" value="connexion">
				
			</form>
			
			<a class="lien" href="<%=application.getContextPath()%>/acceuil">Vous n'avez pas de compte? Créer un compte!</a>
			
			<%--FIn du formulaire --%>
		</main>
	</div>
	

</body>
</html>