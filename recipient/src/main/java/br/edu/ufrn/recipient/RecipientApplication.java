package br.edu.ufrn.recipient;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import br.edu.ufrn.core.property.JwtConfiguration;

@SpringBootApplication
@EntityScan({"br.edu.ufrn.core.model"})
@EnableJpaRepositories({"br.edu.ufrn.core.repository"})
@EnableConfigurationProperties(value = JwtConfiguration.class)
@ComponentScan("br.edu.ufrn")
public class RecipientApplication {

    public static void main(String[] args) {
        SpringApplication.run(RecipientApplication.class, args);
    }

}
