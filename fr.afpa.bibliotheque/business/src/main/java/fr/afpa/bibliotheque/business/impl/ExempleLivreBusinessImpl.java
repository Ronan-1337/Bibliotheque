/**
 * 
 */
package fr.afpa.bibliotheque.business.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import fr.afpa.bibliotheque.business.ExempleLivreBusiness;
import fr.afpa.bibliotheque.service.ExempleLivreService;

/**
 * @author bilonjea
 *
 */
@Component
public class ExempleLivreBusinessImpl implements ExempleLivreBusiness{
	
	@Autowired
	ExempleLivreService serviceLivre;
	
	public int getLibreByCategory(String cat) {
		return serviceLivre.getNbLivre(cat);
	}

}
