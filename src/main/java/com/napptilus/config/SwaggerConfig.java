package com.napptilus.config;


import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;



@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("PRICES-SQL-REST API Documentation")
                        .version("1.0.0")
                        .description("Documentación de la API REST para gestionar precios"));
//                .externalDocs(new ExternalDocumentation()
//                        .description("Enlace a más información")
//                        .url("https://tu-enlace-de-documentacion.com"));
    }
}
