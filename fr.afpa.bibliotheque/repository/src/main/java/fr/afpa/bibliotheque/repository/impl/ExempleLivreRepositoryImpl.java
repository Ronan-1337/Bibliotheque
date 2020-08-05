package fr.afpa.bibliotheque.repository.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import fr.afpa.bibliotheque.repository.ExempleLivreRepository;

@Repository
public class ExempleLivreRepositoryImpl implements ExempleLivreRepository {
	
	@Autowired
	JdbcTemplate jdbcTemplate;

	@Override
	public int getNbLivreByCategory(String categoryName) {
        //TODO Faire les requetes
		return 15;
	}

}
