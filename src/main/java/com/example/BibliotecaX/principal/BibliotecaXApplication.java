package com.example.BibliotecaX.principal;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BibliotecaXApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(BibliotecaXApplication.class, args);
		
	}
	
	@Override
	public void run(String... args) throws Exception {
		Principal principal = new Principal();
		principal.iniciar();
		
	}
}
