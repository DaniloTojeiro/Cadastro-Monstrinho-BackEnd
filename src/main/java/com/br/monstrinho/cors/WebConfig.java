package com.br.monstrinho.cors;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOrigins("http://127.0.0.1:5500/index.html") // Permitir requisições somente do frontend
                .allowedMethods("GET", "POST", "PUT", "DELETE"); // Permitir os métodos HTTP especificados
    }
}