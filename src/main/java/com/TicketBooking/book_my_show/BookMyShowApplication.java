package com.TicketBooking.book_my_show;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@OpenAPIDefinition(
		info = @Info(
				title = "TicketNow",
				version = "1.0.0",
				description = "This is a movie ticket booking application",
				termsOfService = "Run Application",
				contact = @Contact(
						name = "Mr.Abhishek Adhav",
						email = "abhiadhav2843@gmail.com"
				)
		)
)
public class BookMyShowApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookMyShowApplication.class, args);
	}

}
