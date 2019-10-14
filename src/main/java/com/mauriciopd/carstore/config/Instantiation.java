package com.mauriciopd.carstore.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.mauriciopd.carstore.domain.Marca;
import com.mauriciopd.carstore.domain.Modelo;
import com.mauriciopd.carstore.domain.Veiculo;
import com.mauriciopd.carstore.domain.enums.CorVeiculo;
import com.mauriciopd.carstore.domain.enums.TipoVeiculo;
import com.mauriciopd.carstore.repository.MarcaRepository;
import com.mauriciopd.carstore.repository.ModeloRepository;
import com.mauriciopd.carstore.repository.VeiculoRepository;

@Configuration
public class Instantiation implements CommandLineRunner{
	
	@Autowired
	private MarcaRepository marcaRepository;
	
	@Autowired 
	private ModeloRepository modeloRepository;
	
	@Autowired
	private VeiculoRepository veiculoRepository;

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
		
		Veiculo v1 = new Veiculo(null, 25000.20, 2019, TipoVeiculo.SUV, CorVeiculo.PRETO, mod5);
		Veiculo v2 = new Veiculo(null, 33000.20, 2017, TipoVeiculo.HATCHBACK, CorVeiculo.BRANCO, mod3);
		Veiculo v3 = new Veiculo(null, 36500.70, 2014, TipoVeiculo.SEDAN, CorVeiculo.BEGE, mod6);
		Veiculo v4 = new Veiculo(null, 55000.20, 2012, TipoVeiculo.SUV, CorVeiculo.PRETO, mod1);
		Veiculo v5 = new Veiculo(null, 120000.20, 2019, TipoVeiculo.PICAPE, CorVeiculo.AZUL, mod4);
		
		mod1.getVeiculos().addAll(Arrays.asList(v4));
		mod2.getVeiculos().addAll(Arrays.asList());
		mod3.getVeiculos().addAll(Arrays.asList(v2));
		mod4.getVeiculos().addAll(Arrays.asList(v5));
		mod5.getVeiculos().addAll(Arrays.asList(v1));
		mod6.getVeiculos().addAll(Arrays.asList(v3));
		
		marcaRepository.saveAll(Arrays.asList(m1, m2, m3, m4));
		modeloRepository.saveAll(Arrays.asList(mod1, mod2, mod3, mod4, mod5, mod6));
		veiculoRepository.saveAll(Arrays.asList(v1, v2, v3, v4, v5));
	}

}
