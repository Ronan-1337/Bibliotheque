package fr.afpa.bibliotheque.repository.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import fr.afpa.bibliotheque.data.ExempleLivre;


public class ExempleLivreMapper implements RowMapper<ExempleLivre>{

	@Override
	public ExempleLivre mapRow(ResultSet rs, int rowNum) throws SQLException {
		ExempleLivre exempleLivre = new ExempleLivre();
		
		exempleLivre.setId(rs.getInt("id"));
		exempleLivre.setTitle(rs.getString("title"));
		exempleLivre.setCategory(rs.getString("category"));
		exempleLivre.setDateMiseEnRayon(rs.getDate("dateMiseEnRayon"));
		return exempleLivre;
		
	}

}
