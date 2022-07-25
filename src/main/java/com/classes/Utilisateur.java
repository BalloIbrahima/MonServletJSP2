package com.classes;

public class Utilisateur {
//	Définition des variables
	private String nom;
	private String prenom;
	private String pseudo;
	private String email;
	private String motDePasse;
	
//	Définition du constructeur avec argument
	public Utilisateur(String nom,String prenom,String pseudo,String email, String motDePasse) {
		this.nom=nom;
		this.prenom=prenom;
		this.pseudo=pseudo;
		this.email=email;
		this.motDePasse=motDePasse;
	}
	
//	Définition du constructeur sans argument
	public Utilisateur() {
		// TODO Auto-generated constructor stub
	}
	
//	getter et setter de nom
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	
//	getter et setter de prenom
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	
//	getter et setter de pseudo
	public String getPseudo() {
		return pseudo;
	}
	public void setPseudo(String pseudo) {
		this.pseudo = pseudo;
	}
	
//	getter et setter de email
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
//	getter et setter du mot de passe
	public String getMotDePasse() {
		return motDePasse;
	}
	public void setMotDePasse(String motDePasse) {
		this.motDePasse = motDePasse;
	}	
	
}
