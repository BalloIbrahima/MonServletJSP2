<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Inscription</title>
	<link href="resources/css/inscrire.css" rel="stylesheet" >
</head>
<body>

	<div class="container">
		<%--Entete --%>
		<header>
			<h2>Bienvenue, Veuillez vous inscrire!</h2>
		</header>
		<%--Fin entete --%>
		
		<%--Debut body --%>
		<main>
			<%--Creation du formulaitre --%>
			<form method="Post" action="acceuil">
			
				<input class="form_line"  type="text" name="nom" placeholder="Nom"  >
			
				<input class="form_line" type="text" name="prenom" placeholder="Prénom" >
			
				<input class="form_line" type="text" name="pseudo" placeholder="Pseudo" >
			
				<input class="form_line" type="email" name="email" placeholder="email" >
			
				<input class="form_line" type="password" name="password"  minlength="8" placeholder="Mot de Passe" >
			
				<input class="form_line" type="password" name="password2" minlength="8" placeholder="Vérification du Mot de Passe" >
				
				<% if (request.getAttribute("erreur")!=null) { %>
					<p class="error"> <%= request.getAttribute("erreur") %></p>
				<%} %>
				
				
				<div class="submit">
				
					<input class="form_line btn" style="background-color: black; color:#FFFFFF;" type="submit" value="Inscription">
					<input class="form_line btn"  style="background-color: #FFFFFF;" type="reset" value="Annuler">
				
				</div>
				
				<a class="lien" href="<%=application.getContextPath()%>/login">Vous avez un compte? Connectez-vous!</a>
				
			</form>
			<%--FIn du formulaire --%>
		</main>
		<%--Fin body --%>
	</div>
	
	
</body>
</html>