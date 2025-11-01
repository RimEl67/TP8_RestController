package ma.rest.spring;

import ma.rest.spring.entities.Compte;
import ma.rest.spring.entities.TypeCompte;
import ma.rest.spring.repositories.CompteRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Date;

@SpringBootApplication
public class Application {
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Bean
	CommandLineRunner start(CompteRepository repo) {
		return args -> {
			repo.save(new Compte(null, Math.random()*9000, new Date(), TypeCompte.EPARGNE));
			repo.save(new Compte(null, Math.random()*9000, new Date(), TypeCompte.COURANT));
			repo.save(new Compte(null, Math.random()*9000, new Date(), TypeCompte.EPARGNE));
			repo.findAll().forEach(System.out::println);
		};
	}
}