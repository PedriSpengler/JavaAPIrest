package com.pedrispengler.cadastro_usuario.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.context.annotation.Configuration;

@Configuration
@OpenAPIDefinition(
        info = @Info(
                title = "API de Cadastro de Usuários",
                version = "1.0",
                description = "Documentação da API REST desenvolvida com Spring Boot, JPA e Swagger."
        )
)
public class OpenApiConfig {
}