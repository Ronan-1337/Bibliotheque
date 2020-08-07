package fr.afpa.bibliotheque.data;

import java.sql.Date;

import lombok.Data;

@Data
public class Utilisateur {
	
	private int id;
	private String nom;
	private String prenom;
	private String role;
	private Date datenaissance;
	private String pseudo;
	private String motdepasse;
	public Utilisateur(int id, String nom, String prenom, String role, Date datenaissance, String pseudo,
			String motdepasse) {
		this.id = id;
		this.nom = nom;
		this.prenom = prenom;
		this.role = role;
		this.datenaissance = datenaissance;
		this.pseudo = pseudo;
		this.motdepasse = motdepasse;
	}
	public Utilisateur(String nom, String prenom) {
		this.nom = nom;
		this.prenom = prenom;
	}
	public Utilisateur() {
	}
}	
