package fr.afpa.bibliotheque.repository;

import java.util.Map;

import fr.afpa.bibliotheque.data.Utilisateur;

public interface  UtilisateurRepository {
	Map<String, Object>	selectByName(int id);
	
	int insertByName(Utilisateur utilisateur);
}

