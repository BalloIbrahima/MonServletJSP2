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
 * Servlet implementation class monservlet2
 */
public class monservlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public monservlet2() {
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
			this.getServletContext().getRequestDispatcher("/Login.jsp").forward(request, response);
		}else {
			this.getServletContext().getRequestDispatcher("/Acceuil.jsp").forward(request, response);
		
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String pseudo,motDePasse;
		pseudo=request.getParameter("pseudo");		
		motDePasse=request.getParameter("password");
		
		HttpSession session=request.getSession();
		List<Utilisateur> utilisateurs=(List)session.getAttribute("utilisateurs");
		System.out.println(utilisateurs);
//		Verification de la présence de l'utilisateur dans la session
		
		if(pseudo==null) {
			session.setAttribute("utilisateur", null);
			this.getServletContext().getRequestDispatcher("/Login.jsp").forward(request, response);
		}else {	
			
			if(pseudo.equals("") || motDePasse.equals("")) {
				
				request.setAttribute("erreur","Veuillez remplir tout les champs !");
				this.getServletContext().getRequestDispatcher("/Login.jsp").forward(request, response);
			}else {
				
				try {
					for(Utilisateur u:utilisateurs) {
						if(u.getPseudo().equals(pseudo) && u.getMotDePasse().equals(motDePasse)) {
							this.getServletContext().getRequestDispatcher("/Acceuil.jsp").forward(request, response);
							
							Utilisateur user=new Utilisateur(u.getNom(),u.getPrenom(),u.getPseudo(),u.getEmail(),u.getMotDePasse());
							session.setAttribute("utilisateur", user);
							break;
						}
					}
					request.setAttribute("erreur","Pseudo ou mot de passe incorrect !");
					this.getServletContext().getRequestDispatcher("/Login.jsp").forward(request, response);
				}catch (Exception e) {
					request.setAttribute("erreur","Pseudo ou mot de passe incorrect !");
					this.getServletContext().getRequestDispatcher("/Login.jsp").forward(request, response);
				}
				
			}
		}
	}

}
