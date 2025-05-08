package com.example.e_ticaret_sitesi.config;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.savedrequest.SavedRequest;

import java.io.IOException;

@Configuration
public class SecurityConfig {
    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public AuthenticationSuccessHandler customAuthenticationSuccessHandler() {
        return new AuthenticationSuccessHandler() {
            @Override
            public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
                                                Authentication authentication) throws IOException {
                SavedRequest savedRequest = (SavedRequest) request.getSession().getAttribute("SPRING_SECURITY_SAVED_REQUEST");
                if (savedRequest != null) {
                    String requestedUri = savedRequest.getRedirectUrl(); // Get the URL from the SavedRequest
                    if (requestedUri != null && (requestedUri.endsWith("/giris") || requestedUri.endsWith("/kayit"))) {
                        response.sendRedirect("/");
                    } else {
                        response.sendRedirect("/"); // Your default success URL
                    }
                } else {
                    // Fallback to default redirection if no saved request exists
                    response.sendRedirect("/");
                }
            }
        };
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf(AbstractHttpConfigurer::disable)
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/css/**", "/static/js/js/**", "/images/**").permitAll()
                        .requestMatchers("/urunler/liste").permitAll()
                        .requestMatchers("/kayit").permitAll()
                        .anyRequest().authenticated()
                )
                .formLogin(form -> form
                        .loginPage("/giris")
                        .loginProcessingUrl("/giris_yap")
                        .successHandler(customAuthenticationSuccessHandler()) // Use the custom success handler
                        .failureUrl("/giris?error=true")
                        .permitAll()
                )
                .logout(logout -> logout
                        .logoutUrl("/cikis_yap")
                        .logoutSuccessUrl("/giris?logout=true")
                        .permitAll()
                );
        return http.build();
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception {
        return authenticationConfiguration.getAuthenticationManager();
    }
}
