/**
 * 
 */
package fr.afpa.bibliotheque.service.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import fr.afpa.bibliotheque.repository.config.RepositoryConfig;

/**
 * @author bilonjea
 *
 */

@Configuration
@Import(value = {
RepositoryConfig.class
} )
@ComponentScan("fr.afpa.bibliotheque.service")
public class ServiceConfig {

}
