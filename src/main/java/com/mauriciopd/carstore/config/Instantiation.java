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
		Marca m5 = new Marca(null, "Chevrolet");
		Marca m6 = new Marca(null, "Hyundai");
		Marca m7 = new Marca(null, "BMW");
		
		Modelo mod1 = new Modelo(null, "Journey", m1);
		Modelo mod2 = new Modelo(null, "Durango", m1);
		Modelo mod3 = new Modelo(null, "Grand Siena", m2);
		Modelo mod4 = new Modelo(null, "Polo", m4);
		Modelo mod5 = new Modelo(null, "Fusion", m3);
		Modelo mod6 = new Modelo(null, "Focus", m3);
		Modelo mod7 = new Modelo(null, "Spin", m5);
		Modelo mod8 = new Modelo(null, "HB20", m6);
		Modelo mod9 = new Modelo(null, "X1", m7);
		Modelo mod10 = new Modelo(null, "Elantra", m6);
		
		m1.getModelos().addAll(Arrays.asList(mod1, mod2));
		m2.getModelos().addAll(Arrays.asList(mod3));
		m4.getModelos().addAll(Arrays.asList(mod4));
		m3.getModelos().addAll(Arrays.asList(mod5, mod6));
		m5.getModelos().addAll(Arrays.asList(mod7));
		m6.getModelos().addAll(Arrays.asList(mod8, mod10));
		m7.getModelos().addAll(Arrays.asList(mod9));
		
		Veiculo v1 = new Veiculo(null, 25000.20, 2019, TipoVeiculo.SUV, CorVeiculo.PRETO, mod5);
		Veiculo v2 = new Veiculo(null, 33000.20, 2017, TipoVeiculo.HATCHBACK, CorVeiculo.BRANCO, mod3);
		Veiculo v3 = new Veiculo(null, 36500.70, 2014, TipoVeiculo.SEDAN, CorVeiculo.BEGE, mod6);
		Veiculo v4 = new Veiculo(null, 55000.20, 2012, TipoVeiculo.SUV, CorVeiculo.PRETO, mod1);
		Veiculo v5 = new Veiculo(null, 120000.20, 2019, TipoVeiculo.PICAPE, CorVeiculo.AZUL, mod4);
		Veiculo v6 = new Veiculo(null, 120000.20, 2019, TipoVeiculo.MINIVAN, CorVeiculo.AMARELO, mod7);
		Veiculo v7 = new Veiculo(null, 120000.20, 2019, TipoVeiculo.HATCHBACK, CorVeiculo.PRATA, mod8);
		Veiculo v8 = new Veiculo(null, 120000.20, 2019, TipoVeiculo.SUV, CorVeiculo.ROSA, mod9);
		Veiculo v9 = new Veiculo(null, 120000.20, 2019, TipoVeiculo.HATCHBACK, CorVeiculo.VERMELHO, mod8);
		Veiculo v10 = new Veiculo(null, 120000.20, 2019, TipoVeiculo.HATCHBACK, CorVeiculo.BRANCO, mod10);
		
		mod1.getVeiculos().addAll(Arrays.asList(v4));
		mod2.getVeiculos().addAll(Arrays.asList());
		mod3.getVeiculos().addAll(Arrays.asList(v2));
		mod4.getVeiculos().addAll(Arrays.asList(v5));
		mod5.getVeiculos().addAll(Arrays.asList(v1));
		mod6.getVeiculos().addAll(Arrays.asList(v3));
		mod7.getVeiculos().addAll(Arrays.asList(v6));
		mod8.getVeiculos().addAll(Arrays.asList(v7, v9));
		mod9.getVeiculos().addAll(Arrays.asList(v8));
		mod9.getVeiculos().addAll(Arrays.asList(v10));
		
		marcaRepository.saveAll(Arrays.asList(m1, m2, m3, m4, m5, m6, m7));
		modeloRepository.saveAll(Arrays.asList(mod1, mod2, mod3, mod4, mod5, mod6, mod7, mod8, mod9, mod10));
		veiculoRepository.saveAll(Arrays.asList(v1, v2, v3, v4, v5, v6, v7, v8, v9, v10));
	}

}
