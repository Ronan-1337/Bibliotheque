package fr.afpa.bibliotheque.repository.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;

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
	
	@SuppressWarnings("unused")
	private static final class UtilisateurMapper implements RowMapper<Utilisateur> {
		public Utilisateur mapRow(ResultSet rs, int rowNum) throws SQLException {
		Utilisateur utilisateur = new Utilisateur();
		utilisateur.setId(rs.getInt("id"));
		utilisateur.setNom(rs.getString("nom"));
		utilisateur.setPrenom(rs.getString("prenom"));
		utilisateur.setRole(rs.getString("role"));
		utilisateur.setDatenaissance(rs.getDate("datenaissance"));
		utilisateur.setPseudo(rs.getString("pseudo"));
		utilisateur.setMotdepasse(rs.getString("motdepasse"));
		return utilisateur;
		}
	}
	public Map<String, Object> selectByName(Utilisateur u) {
		return jdbcTemplate.queryForMap("SELECT idutilisateur FROM utilisateur WHERE nom =? && prenom =?", u.getNom(), u.getPrenom());
	}
	
	public int insertByName(Utilisateur utilisateur) {
		return jdbcTemplate.update("INSERT INTO utilisateur (idutilisateur, nom, prenom, role, datenaissance, pseudo, motdepasse) values(?,?,?,?,?,?,?)", utilisateur.getId(), utilisateur.getNom(), utilisateur.getPrenom(), utilisateur.getRole(), utilisateur.getPseudo(), utilisateur.getDatenaissance(), utilisateur.getMotdepasse());
		
	}
}