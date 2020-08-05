/**
 * 
 */
package fr.afpa.bibliotheque.business;

import org.springframework.stereotype.Component;

import lombok.extern.log4j.Log4j;

/**
 * @author bilonjea
 *
 */
@Component
@Log4j
public class TestBusiness {
	
	public void sayHello() {
		
		log.info("Hello business");
		
	}
	

}
