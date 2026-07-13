package br.com.philance.backend.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration // 1. Avisa ao Spring que este arquivo traz regras de configuração do sistema
public class CorsConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**") // 2. Aplica essa regra para TODAS as URLs do seu sistema
                .allowedOrigins("http://127.0.0.1:5500", "https://philance.com.br") // 3. Quem pode acessar
                .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS") // 4. Quais verbos são aceitos
                .allowedHeaders("*") // 5. Permite qualquer tipo de cabeçalho (como Content-Type)
                .allowCredentials(true); // 6. Ativa a segurança para troca de logins e cookies
    }
}