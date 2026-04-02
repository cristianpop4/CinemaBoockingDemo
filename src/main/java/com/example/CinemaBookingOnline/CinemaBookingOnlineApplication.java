package com.example.CinemaBookingOnline;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@OpenAPIDefinition(info = @Info(title = "OpenApi for Cinema Booking Online (CBO)", version = "1.0", description = "Apis for managing a cinema"))
public class CinemaBookingOnlineApplication {

	public static void main(String[] args) {
		SpringApplication.run(CinemaBookingOnlineApplication.class, args);
	}

}
