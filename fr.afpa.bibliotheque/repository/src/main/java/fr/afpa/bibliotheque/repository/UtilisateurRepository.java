package fr.afpa.bibliotheque.repository;

import java.util.Map;
import java.util.Objects;

public interface  UtilisateurRepository {
	Map<String, Objects> selectByName(int name);
	
	int save(UtilisateurRepository utilisateur);
}
