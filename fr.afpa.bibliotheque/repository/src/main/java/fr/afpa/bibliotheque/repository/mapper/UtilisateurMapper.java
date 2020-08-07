package fr.afpa.bibliotheque.repository.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;
import fr.afpa.bibliotheque.data.Utilisateur;


public class UtilisateurMapper implements RowMapper<Utilisateur>{

	@Override
	public Utilisateur mapRow(ResultSet rs, int rowNum) throws SQLException {
		Utilisateur utilisateur = new Utilisateur();

		utilisateur.setId(rs.getInt("id"));
		utilisateur.setNom(rs.getString("nom"));
		utilisateur.setPrenom(rs.getString("prenom"));
		utilisateur.setRole(rs.getString("role"));
		return utilisateur;

	}

}