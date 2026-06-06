package com.udemy.ecommerce.sportcenter.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

//This applies CORS rules globally to all controllers.
//If you have Spring Security enabled, you must also configure CORS inside your SecurityFilterChain:
/*
Definition: CORS is an HTTP header‑based mechanism that lets a server specify which origins (domains, protocols, or ports) are permitted to access its resources.

Default Rule: Browsers enforce the Same‑Origin Policy — scripts can only request data from the same origin they were loaded from.

Problem Solved: Without CORS, a frontend app (e.g., React at http://localhost:3000) cannot call a backend API running at http://localhost:8080.
 */
@Configuration
@EnableWebMvc
public class CorsConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry){
        registry.addMapping("/**")
                .allowedOrigins("*")
                .allowedMethods("GET", "POST", "DELETE", "PUT")
                .allowedHeaders("*");
    }
}
