package com.example.CinemaBookingOnline.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableMethodSecurity
public class SecurityConfig {
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

        http
                .csrf(csrf -> csrf.disable())
                .authorizeHttpRequests(auth -> auth

                        // PUBLIC
                        .requestMatchers(HttpMethod.GET, "/api/screenings/**").permitAll()
                        .requestMatchers(HttpMethod.GET, "/api/movies/**").permitAll()
                        .requestMatchers(HttpMethod.POST, "/api/users/register").permitAll()

                        // AUTHENTICATED
                        .requestMatchers("/api/bookings/**").authenticated()

                        // ADMIN ONLY
                        .requestMatchers(HttpMethod.POST, "/api/screenings/**").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.DELETE, "/api/screenings/**").hasRole("ADMIN")

                        // fallback
                        .anyRequest().authenticated()
                )
                .httpBasic(Customizer.withDefaults());

        return http.build();
    }
}
