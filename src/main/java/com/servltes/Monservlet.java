package com.servltes;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.classes.Utilisateur;

/**
 * Servlet implementation class Monservlet
 */
public class Monservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Monservlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session=request.getSession();
		Utilisateur user=(Utilisateur) session.getAttribute("utilisateur");
		
		if(user==null) {
//			si l'utilisateur recuperer est null => qu'il n'existe pas ds la session => on va aller ds la page d'inscription
			this.getServletContext().getRequestDispatcher("/Inscrire.jsp").forward(request, response);

		}else {
			
//			S'il existe => qu'il a deja un compte donc on va aller dans l'acceuil
			this.getServletContext().getRequestDispatcher("/Acceuil.jsp").forward(request, response);

		}
    
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		String nom,prenom,pseudo,motDePasse,motDePasseVerif,email;
		
		nom=request.getParameter("nom");
		prenom=request.getParameter("prenom");
		pseudo=request.getParameter("pseudo");
		email=request.getParameter("email");
		motDePasse=request.getParameter("password");
		motDePasseVerif=request.getParameter("password2");
		
		HttpSession session=request.getSession();
		
		List<Utilisateur> utilisateurs =(List)session.getAttribute("utilisateurs");
		if(utilisateurs==null) {
			utilisateurs=new ArrayList<Utilisateur>();
		}
		
		
		if(nom.trim().equals("") || prenom.trim().equals("") || pseudo.trim().equals("") || email.trim().equals("") || motDePasse.trim().equals("")|| motDePasseVerif.trim().equals("") ) {
			request.setAttribute("erreur","Veuillez remplir tout les champs !");
	        this.getServletContext().getRequestDispatcher("/Inscrire.jsp").forward(request, response);
		
		}else {
			if(!motDePasse.equals(motDePasseVerif)) {

				request.setAttribute("erreur","Vos mots de passe ne correspondent pas !");
		        this.getServletContext().getRequestDispatcher("/Inscrire.jsp").forward(request, response);
		        
			}else {
				
				for(Utilisateur u:utilisateurs) {
					
					if(pseudo.equals(u.getPseudo()) || email.equals(u.getEmail())) {
						
						request.setAttribute("erreur","Cet utilisateur existe deja !");
						this.getServletContext().getRequestDispatcher("/Inscrire.jsp").forward(request, response);
						break;
					}
				}
				
				Utilisateur user=new Utilisateur(nom,prenom,pseudo,email,motDePasse);
				utilisateurs.add(user);
				session.setAttribute("utilisateurs", utilisateurs);
				session.setAttribute("utilisateur", user);
				System.out.println(utilisateurs);
				this.getServletContext().getRequestDispatcher("/Acceuil.jsp").forward(request, response);

			}
		
		}
	}

}
