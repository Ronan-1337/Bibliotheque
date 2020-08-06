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
		utilisateur.setTitle(rs.getString("title"));
		utilisateur.setCategory(rs.getString("category"));
		utilisateur.setDateMiseEnRayon(rs.getDate("dateMiseEnRayon"));
		return utilisateur;

	}

}