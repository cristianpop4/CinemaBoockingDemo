package com.example.CinemaBookingOnline.security;

import com.example.CinemaBookingOnline.model.entity.User;
import com.example.CinemaBookingOnline.model.enums.Role;
import com.example.CinemaBookingOnline.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@RequiredArgsConstructor
public class DataLoader {
    private final UserRepository userRepository;
    private final PasswordEncoder encoder;

    @Bean
    CommandLineRunner init() {
        return args -> {

            if (userRepository.findByEmail("admin@gmail.com").isEmpty()) {
                User admin = new User();
                admin.setName("Admin");
                admin.setEmail("admin@gmail.com");
                admin.setPassword(encoder.encode("admin123"));
                admin.setRole(Role.ROLE_ADMIN);
                userRepository.save(admin);
            }

            if (userRepository.findByEmail("user@gmail.com").isEmpty()) {
                User user = new User();
                user.setName("User");
                user.setEmail("user@gmail.com");
                user.setPassword(encoder.encode("user123"));
                user.setRole(Role.ROLE_USER);
                userRepository.save(user);
            }
        };
    }
}
