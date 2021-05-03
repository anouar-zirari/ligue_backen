package com.myApp.backendLigue;

import com.myApp.backendLigue.entity.Player;
import com.myApp.backendLigue.repository.PlayerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class BackendLigueApplication {

	public static void main(String[] args) {
		SpringApplication.run(BackendLigueApplication.class, args);


	}

	@Bean
	CommandLineRunner runner(PlayerRepository repo){
		return args -> {
			repo.save(new Player("anouar","anouar",14));
		};
	}

}
