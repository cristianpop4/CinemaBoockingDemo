package com.example.CinemaBookingOnline.controller;

import com.example.CinemaBookingOnline.model.entity.User;
import com.example.CinemaBookingOnline.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserController {

    private final UserRepository userRepository;
    private final PasswordEncoder encoder;

    @PostMapping("/register")
    public User register(@RequestBody User user) {
        user.setPassword(encoder.encode(user.getPassword()));
        return userRepository.save(user);
    }

    @GetMapping("/me")
    public User me(Principal principal) {
        return userRepository.findByEmail(principal.getName()).orElseThrow();
    }
}