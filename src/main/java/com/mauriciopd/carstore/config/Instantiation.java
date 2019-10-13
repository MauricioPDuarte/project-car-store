package com.mauriciopd.carstore.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.mauriciopd.carstore.domain.Marca;
import com.mauriciopd.carstore.repository.MarcaRepository;

@Configuration
public class Instantiation implements CommandLineRunner{
	
	@Autowired
	private MarcaRepository marcaRepository;

	@Override
	public void run(String... args) throws Exception {
		Marca m1 = new Marca(1, "Dodge");
		Marca m2 = new Marca(2, "Fiat");
		Marca m3 = new Marca(3, "Ford");
		Marca m4 = new Marca(4, "volkswagen");
		
		marcaRepository.saveAll(Arrays.asList(m1, m2, m3, m4));
	}

}
