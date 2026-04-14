package com.castagno.dev.bazar_api.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("Bazar API")
                        .version("1.0.0")
                        .description("API REST para gestión de productos, ventas y clientes del bazar")
                        .contact(new Contact()
                                .name("castagno.dev")));
    }

}
