package com.abnerlima.my_post_its.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        // Aplica o CORS diretamente dentro do HttpSecurity
        http.authorizeHttpRequests(authorize -> authorize
                .anyRequest().permitAll()
        );

        // Desabilita o CSRF (caso não esteja utilizando autenticação baseada em CSRF)
        http.csrf(AbstractHttpConfigurer::disable);

        // Aplicar as configurações de CORS
        http.cors(c -> c.configurationSource(corsConfigurationSource()));

        return http.build();
    }

    @Bean
    public CorsConfigurationSource corsConfigurationSource() {
        CorsConfiguration configuration = new CorsConfiguration();
        configuration.addAllowedOrigin("http://localhost:5173");  // Origem permitida
        configuration.addAllowedMethod("*"); // Permitir todos os métodos HTTP
        configuration.addAllowedHeader("*"); // Permitir todos os cabeçalhos

        // Configuração global para todas as rotas
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", configuration);

        return source;
    }
}
