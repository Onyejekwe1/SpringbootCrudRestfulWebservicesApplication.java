package net.javaguides.springboot.configuration;

import org.springframework.context.annotation.Bean;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

public class SwaggerConfig {
    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("user Api")
                .select()
                .apis(RequestHandlerSelectors.basePackage("net.javaguides.springboot.controller"))
                .build();
    }
}
