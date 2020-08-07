package fr.afpa.bibliotheque.data;

import java.sql.Date;

import fr.afpa.bibliotheque.repository.impl.JDBCUtilisateurRepository;
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
	public Utilisateur getutilisateurById(int id) {
		Utilisateur user = new Utilisateur();
		user.id = id;
		user.nom = JDBCUtilisateurRepository.nomUtilisateurById(id);
		user.prenom = JDBCUtilisateurRepository.prenomUtilisateurById(id);
		user.pseudo = JDBCUtilisateurRepository.pseudoUtilisateurById(id);
		user.role = JDBCUtilisateurRepository.roleUtilisateurById(id);
		user.datenaissance = JDBCUtilisateurRepository.dateUtilisateurById(id);
		user.motdepasse = JDBCUtilisateurRepository.motdepasseUtilisateurById(id);
		return user;
	}
}	
