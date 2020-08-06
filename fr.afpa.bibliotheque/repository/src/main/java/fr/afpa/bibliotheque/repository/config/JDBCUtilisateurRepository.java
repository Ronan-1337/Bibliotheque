package fr.afpa.bibliotheque.repository.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import fr.afpa.bibliotheque.data.Utilisateur;
import fr.afpa.bibliotheque.repository.UtilisateurRepository;

@Repository("JDBCUtilisateurRepository")
public class JDBCUtilisateurRepository implements UtilisateurRepository{
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public Map<String, Object>	selectById(int id) {
		return jdbcTemplate.queryForMap("select * from enbois where id = ?", id);
	}
	
	public int save(Enbois enbois) {
		return jdbcTemplate.update("insert into enbois (id, longueur, largeur, matiere) values(?,?,?,?)", enbois.getId(), enbois.getLongueur(), enbois.getLargeur(), enbois.getMatiere());
	}

}