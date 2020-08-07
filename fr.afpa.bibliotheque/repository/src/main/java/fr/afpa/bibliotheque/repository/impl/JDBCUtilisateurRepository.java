package fr.afpa.bibliotheque.repository.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.sun.javafx.collections.MappingChange.Map;

import fr.afpa.bibliotheque.data.Utilisateur;
import fr.afpa.bibliotheque.repository.UtilisateurRepository;

@Repository("JDBCUtilisateurRepository")
public class JDBCUtilisateurRepository implements UtilisateurRepository{
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@SuppressWarnings("unchecked")
	public Map<String, Object>	selectById(String name, int id) {
		return (Map<String, Object>) jdbcTemplate.queryForMap("select * from enbois where id = ?", id);
	}
	
	public int save(Utilisateur utilisateur ) {
		return jdbcTemplate.update("insert into enbois (id, longueur, largeur, matiere) values(?,?,?,?)", utilisateur.getId(), utilisateur.getNom(), utilisateur.getPrenom(), utilisateur.getRole());
	}
}