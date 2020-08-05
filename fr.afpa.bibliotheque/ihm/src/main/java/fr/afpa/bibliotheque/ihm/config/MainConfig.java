/**
 * 
 */
package fr.afpa.bibliotheque.ihm.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import fr.afpa.bibliotheque.business.config.BusinessConfig;
import fr.afpa.bibliotheque.jdbc.config.DataSourceConfig;
import fr.afpa.bibliotheque.repository.config.RepositoryConfig;
import fr.afpa.bibliotheque.service.config.ServiceConfig;

/**
 * @author bilonjea
 *
 */

@Configuration
@Import(value = {
BusinessConfig.class
} )
@ComponentScan("fr.afpa.bibliotheque.ihm")
public class MainConfig {
	

}
