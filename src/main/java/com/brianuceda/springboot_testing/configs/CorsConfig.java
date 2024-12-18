package com.brianuceda.springboot_testing.configs;

import java.util.Arrays;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

@Configuration
public class CorsConfig {
    private final String[] ALLOWED_ORIGINS = {
        "http://localhost:4200",
        "http://localhost:4300"
    };

    @Bean
    CorsFilter corsFilter() {
        // Configuración de CORS
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        CorsConfiguration config = new CorsConfiguration();
        
        // Definir los orígenes permitidos
        config.setAllowedOrigins(Arrays.asList(ALLOWED_ORIGINS));
            
        // Permitir métodos específicos
        config.addAllowedMethod("GET");
        config.addAllowedMethod("POST");
        config.addAllowedMethod("PUT");
        config.addAllowedMethod("DELETE");
        
        // Permitir encabezados específicos
        config.addAllowedHeader("Authorization");
        config.addAllowedHeader("Content-Type");

        // Permitir el uso de credenciales (cookies, sesiones)
        config.setAllowCredentials(true);
        
        // Registrar configuración
        source.registerCorsConfiguration("/**", config); // Todas las rutas
        return new CorsFilter(source);
    }
}
