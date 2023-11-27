package net.alepuzio.cellexercise;

import javax.sql.DataSource;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;

@SpringBootApplication
@ComponentScan(basePackages = { "net.alepuzio.cellexercise" })
@EnableJpaRepositories("net.alepuzio.cellexercise.*")
@EntityScan("net.alepuzio.cellexercise.*")  
public class CellExercise {
	
	private Logger logger = LogManager.getLogger(this.getClass());
	
    public static void main(String[] args) {
        SpringApplication.run(CellExercise.class, args);
    }
    

    @Bean
    public DataSource dataSource() {
      try {
      	EmbeddedDatabaseBuilder dbBuilder = new EmbeddedDatabaseBuilder();
      	return dbBuilder.setType(EmbeddedDatabaseType.H2)
            .addScripts("classpath:h2/schema.sql", "classpath:h2/test-data.sql")
            .build();
      } catch (Exception e) {
      	logger.error("Embedded DataSource bean cannot be created!", e);
        return null;
      }
    }

}