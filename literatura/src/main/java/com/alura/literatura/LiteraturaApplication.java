package com.alura.literatura;

import com.alura.literatura.literatura.principal.Principal;
import com.alura.literatura.literatura.repositoy.AutorRepository;
import com.alura.literatura.literatura.repositoy.LibroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class LiteraturaApplication {

	public static void main(String[] args) {
		SpringApplication.run(LiteraturaApplication.class, args);
	}

	@SpringBootApplication
	public static class LiteraluraApplication implements CommandLineRunner {

		@Autowired
		private LibroRepository repository;
		@Autowired
		private AutorRepository repositoryAutor;

		public static void main(String[] args) {
			SpringApplication.run(LiteraluraApplication.class, args);
		}

		@Override
		public void run(String... args) throws Exception {
			Principal principal = new Principal(repository, repositoryAutor);
			principal.iniciarApp();


		}
	}
}
