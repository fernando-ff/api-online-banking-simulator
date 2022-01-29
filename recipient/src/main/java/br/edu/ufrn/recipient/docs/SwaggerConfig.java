package br.edu.ufrn.recipient.docs;

import org.springframework.context.annotation.Configuration;

import br.edu.ufrn.core.docs.BaseSwaggerConfig;
import springfox.documentation.swagger2.annotations.EnableSwagger2;


@Configuration
@EnableSwagger2
public class SwaggerConfig extends BaseSwaggerConfig {
    public SwaggerConfig() {
        super("br.edu.ufrn.recipient.endpoint.controller");
    }
}
