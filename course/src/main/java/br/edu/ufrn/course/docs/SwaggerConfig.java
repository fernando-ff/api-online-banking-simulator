package br.edu.ufrn.course.docs;

import org.springframework.context.annotation.Configuration;

import br.edu.ufrn.core.docs.BaseSwaggerConfig;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author William Suane
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig extends BaseSwaggerConfig {
    public SwaggerConfig() {
        super("br.edu.ufrn.course.endpoint.controller");
    }
}
