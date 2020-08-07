/**
 * 
 */
package fr.afpa.bibliotheque.jdbc.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;


@Configuration
@ComponentScan("fr.afpa.bibliotheque.jdbc")
public class DataSourceConfig {

	@Bean(name="datasource")
	public DriverManagerDataSource provideSource() {
        DriverManagerDataSource dataSource = new org.springframework.jdbc.datasource.DriverManagerDataSource();
        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        dataSource.setUsername("admin_biblio");
        dataSource.setPassword("admin_biblio");
        dataSource.setUrl("jdbc:mysql://localhost:3308/dbibliotheque?useSSL=false&serverTimezone=UTC");
        return dataSource;
    }

    @Bean(name = "jdbcTemplate")
    public JdbcTemplate applicationDataConnection(){
        return new JdbcTemplate(provideSource());
    }
	
}
