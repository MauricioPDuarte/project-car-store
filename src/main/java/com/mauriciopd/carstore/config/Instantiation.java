package com.mauriciopd.carstore.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.mauriciopd.carstore.domain.Marca;
import com.mauriciopd.carstore.domain.Modelo;
import com.mauriciopd.carstore.repository.MarcaRepository;
import com.mauriciopd.carstore.repository.ModeloRepository;

@Configuration
public class Instantiation implements CommandLineRunner{
	
	@Autowired
	private MarcaRepository marcaRepository;
	
	@Autowired 
	private ModeloRepository modeloRepository;

	@Override
	public void run(String... args) throws Exception {
		Marca m1 = new Marca(null, "Dodge");
		Marca m2 = new Marca(null, "Fiat");
		Marca m3 = new Marca(null, "Ford");
		Marca m4 = new Marca(null, "volkswagen");
		
		Modelo mod1 = new Modelo(null, "Journey", m1);
		Modelo mod2 = new Modelo(null, "Durango", m1);
		Modelo mod3 = new Modelo(null, "Grand Siena", m2);
		Modelo mod4 = new Modelo(null, "Polo", m4);
		Modelo mod5 = new Modelo(null, "Fusion", m3);
		Modelo mod6 = new Modelo(null, "Focus", m3);
		
		m1.getModelos().addAll(Arrays.asList(mod1, mod2));
		m2.getModelos().addAll(Arrays.asList(mod3));
		m4.getModelos().addAll(Arrays.asList(mod4));
		m3.getModelos().addAll(Arrays.asList(mod5, mod6));
		
		marcaRepository.saveAll(Arrays.asList(m1, m2, m3, m4));
		modeloRepository.saveAll(Arrays.asList(mod1, mod2, mod3, mod4, mod5, mod6));
	}

}
