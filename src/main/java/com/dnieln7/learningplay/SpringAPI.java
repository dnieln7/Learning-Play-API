package com.dnieln7.learningplay;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
public class SpringAPI {

    public static void main(String[] args) {
        SpringApplication.run(SpringAPI.class, args);
    }

    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/users").allowedOrigins("*");
                registry.addMapping("/users/login").allowedOrigins("*");
                registry.addMapping("/users/sign-up").allowedOrigins("*");
                registry.addMapping("/forms/teacher").allowedOrigins("*");
                registry.addMapping("/forms/student").allowedOrigins("*");
            }
        };
    }
}
