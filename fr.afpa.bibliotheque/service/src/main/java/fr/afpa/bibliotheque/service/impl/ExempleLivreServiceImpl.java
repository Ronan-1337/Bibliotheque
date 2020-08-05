/**
 * 
 */
package fr.afpa.bibliotheque.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.afpa.bibliotheque.repository.ExempleLivreRepository;
import fr.afpa.bibliotheque.service.ExempleLivreService;

/**
 * @author bilonjea
 *
 */
@Service
public class ExempleLivreServiceImpl implements ExempleLivreService {
	
	@Autowired
	ExempleLivreRepository  repoLivre;

	@Override
	public int getNbLivre(String category) {
		
		return repoLivre.getNbLivreByCategory(category);
	}

}
