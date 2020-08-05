/**
 * 
 */
package fr.afpa.bibliotheque.repository.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import fr.afpa.bibliotheque.jdbc.config.DataSourceConfig;

/**
 * @author bilonjea
 *
 */
@Configuration
@Import(value = {
DataSourceConfig.class
} )
@ComponentScan("fr.afpa.bibliotheque.repository")
public class RepositoryConfig {

}
