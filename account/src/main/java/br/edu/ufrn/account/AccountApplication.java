package br.edu.ufrn.account;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import br.edu.ufrn.core.property.JwtConfiguration;

@SpringBootApplication
@EntityScan({"br.edu.ufrn.account.model", "br.edu.ufrn.core.model"})
@EnableJpaRepositories({"br.edu.ufrn.core.repository", "br.edu.ufrn.account.dao"})
@EnableConfigurationProperties(value = JwtConfiguration.class)
@ComponentScan("br.edu.ufrn")
public class AccountApplication {

    public static void main(String[] args) {
        SpringApplication.run(AccountApplication.class, args);
    }

}
