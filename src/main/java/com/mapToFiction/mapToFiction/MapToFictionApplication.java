package com.mapToFiction.mapToFiction;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class MapToFictionApplication {

	public static void main(String[] args) {
		SpringApplication.run(MapToFictionApplication.class, args);
	}

}
