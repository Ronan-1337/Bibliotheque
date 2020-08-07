package fr.afpa.bibliotheque.repository;

import java.util.Map;

import fr.afpa.bibliotheque.data.Utilisateur;

public interface  UtilisateurRepository {
	Map<String, Object>	selectByName(Utilisateur u);
	
	int insertByName(Utilisateur utilisateur);
}

