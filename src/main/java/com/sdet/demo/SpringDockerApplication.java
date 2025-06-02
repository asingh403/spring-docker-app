package com.sdet.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
public class SpringDockerApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringDockerApplication.class, args);
        System.out.println("🚀 Spring Boot Docker Demo Application Started Successfully!");
        System.out.println("📊 Swagger UI: http://localhost:8080/swagger-ui.html");
        System.out.println("🔍 Health Check: http://localhost:8080/actuator/health");
    }

    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**")
                        .allowedOrigins("*")
                        .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS")
                        .allowedHeaders("*");
            }
        };
    }
}
