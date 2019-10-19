package com.mauriciopd.carstore.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.mauriciopd.carstore.domain.Marca;
import com.mauriciopd.carstore.domain.Modelo;
import com.mauriciopd.carstore.domain.Veiculo;
import com.mauriciopd.carstore.domain.enums.CambioVeiculo;
import com.mauriciopd.carstore.domain.enums.CombustivelVeiculo;
import com.mauriciopd.carstore.domain.enums.CorVeiculo;
import com.mauriciopd.carstore.domain.enums.OpcionaisVeiculo;
import com.mauriciopd.carstore.domain.enums.PortasVeiculo;
import com.mauriciopd.carstore.domain.enums.TipoVeiculo;
import com.mauriciopd.carstore.repository.MarcaRepository;
import com.mauriciopd.carstore.repository.ModeloRepository;
import com.mauriciopd.carstore.repository.VeiculoRepository;

@Configuration
public class Instantiation implements CommandLineRunner {

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
		
		Veiculo v1 = Veiculo.Builder
				.newBuilder()
				.withId(null)
				.withPreco(25000.20)
				.withAno(2019)
				.withTipo(TipoVeiculo.SUV.getCod())
				.withCor(CorVeiculo.PRETO.getCod())
				.withCombustivel(CombustivelVeiculo.GASOLINA.getCod())
				.withCambio(CambioVeiculo.AUTOMATICA.getCod())
				.withNumPortas(PortasVeiculo.QUATRO.getCod())
				.withPlaca("UTY-4343")
				.withDescricao("Veiculo em ótimo estado, nunca foi batido!")
				.withKmRodado(45000L)
				.withIpvaPago(true)
				.withBlindado(false)
				.withTroca(true)
				.withGarantiaFabrica(false)
				.withUnicoDono(true)
				.withModelo(mod5)
				.withOpcionais(Arrays.asList(OpcionaisVeiculo.AIRBAG, OpcionaisVeiculo.ALARME))
				.build();
		
		Veiculo v2 = Veiculo.Builder
				.newBuilder()
				.withId(null)
				.withPreco(33000.20)
				.withAno(2017)
				.withTipo(TipoVeiculo.HATCHBACK.getCod())
				.withCor(CorVeiculo.BRANCO.getCod())
				.withCombustivel(CombustivelVeiculo.GASOLINAEGAS.getCod())
				.withCambio(CambioVeiculo.MANUAL.getCod())
				.withNumPortas(PortasVeiculo.QUATRO.getCod())
				.withPlaca("ADY-4244")
				.withDescricao("Já teve 3 donos, já foi batido")
				.withKmRodado(200000L)
				.withIpvaPago(false)
				.withBlindado(true)
				.withTroca(true)
				.withGarantiaFabrica(false)
				.withUnicoDono(false)
				.withModelo(mod3)
				.withOpcionais(Arrays.asList(OpcionaisVeiculo.ARQUENTE, OpcionaisVeiculo.ALARME, OpcionaisVeiculo.CDPLAYER))
				.build();
		
		Veiculo v3 = Veiculo.Builder
				.newBuilder()
				.withId(null)
				.withPreco(36500.70)
				.withAno(2014)
				.withTipo(TipoVeiculo.SEDAN.getCod())
				.withCor(CorVeiculo.BEGE.getCod())
				.withCombustivel(CombustivelVeiculo.GASOLINA.getCod())
				.withCambio(CambioVeiculo.AUTOMATIZADA.getCod())
				.withNumPortas(PortasVeiculo.QUATRO.getCod())
				.withPlaca("JKY-2763")
				.withDescricao("Carro super confortavel!")
				.withKmRodado(83456L)
				.withIpvaPago(true)
				.withBlindado(true)
				.withTroca(false)
				.withGarantiaFabrica(false)
				.withUnicoDono(true)
				.withModelo(mod6)
				.withOpcionais(Arrays.asList(OpcionaisVeiculo.ARQUENTE, OpcionaisVeiculo.ALARME, OpcionaisVeiculo.BANCOCOMREGULAGEMDEALTURA, OpcionaisVeiculo.CONTROLEAUTOMATICODEVELOCIDADE))
				.build();
		
		Veiculo v4 = Veiculo.Builder
				.newBuilder()
				.withId(null)
				.withPreco(55000.20)
				.withAno(2012)
				.withTipo(TipoVeiculo.SUV.getCod())
				.withCor(CorVeiculo.PRETO.getCod())
				.withCombustivel(CombustivelVeiculo.GASOLINA.getCod())
				.withCambio(CambioVeiculo.AUTOMATICA.getCod())
				.withNumPortas(PortasVeiculo.QUATRO.getCod())
				.withPlaca("JCE-8242")
				.withDescricao("Carro em perfeito estado, fazer as trocas dos pneus.")
				.withKmRodado(120000L)
				.withIpvaPago(false)
				.withBlindado(false)
				.withTroca(true)
				.withGarantiaFabrica(false)
				.withUnicoDono(false)
				.withModelo(mod1)
				.withOpcionais(Arrays.asList(OpcionaisVeiculo.AIRBAG, OpcionaisVeiculo.CDPLAYER, OpcionaisVeiculo.FREIOABS, OpcionaisVeiculo.CONTROLEDETRACAO))
				.build();
		
		Veiculo v5 = Veiculo.Builder
				.newBuilder()
				.withId(null)
				.withPreco(120000.20)
				.withAno(2019)
				.withTipo(TipoVeiculo.PICAPE.getCod())
				.withCor(CorVeiculo.AZUL.getCod())
				.withCombustivel(CombustivelVeiculo.DIESEL.getCod())
				.withCambio(CambioVeiculo.MANUAL.getCod())
				.withNumPortas(PortasVeiculo.QUATRO.getCod())
				.withPlaca("HFT-3232")
				.withDescricao("Carro era utilizado para fazer offroad.")
				.withKmRodado(92000L)
				.withIpvaPago(true)
				.withBlindado(true)
				.withTroca(true)
				.withGarantiaFabrica(false)
				.withUnicoDono(true)
				.withModelo(mod4)
				.withOpcionais(Arrays.asList(OpcionaisVeiculo.AIRBAG, OpcionaisVeiculo.CDPLAYER, OpcionaisVeiculo.FREIOABS, OpcionaisVeiculo.CONTROLEDETRACAO, OpcionaisVeiculo.ARQUENTE))
				.build();
		
		Veiculo v6 = Veiculo.Builder
				.newBuilder()
				.withId(null)
				.withPreco(126000.20)
				.withAno(2019)
				.withTipo(TipoVeiculo.MINIVAN.getCod())
				.withCor(CorVeiculo.AMARELO.getCod())
				.withCombustivel(CombustivelVeiculo.GASOLINAALCOOLEGAS.getCod())
				.withCambio(CambioVeiculo.AUTOMATICA.getCod())
				.withNumPortas(PortasVeiculo.QUATRO.getCod())
				.withPlaca("GFE-3434")
				.withDescricao("Carro era utilizado para fazer fretes, nos correios. Carro faz um barulho na roda dianteira")
				.withKmRodado(82450L)
				.withIpvaPago(false)
				.withBlindado(false)
				.withTroca(true)
				.withGarantiaFabrica(true)
				.withUnicoDono(true)
				.withModelo(mod7)
				.withOpcionais(Arrays.asList(OpcionaisVeiculo.AIRBAG, OpcionaisVeiculo.CDPLAYER, OpcionaisVeiculo.BANCOSDECOURO, OpcionaisVeiculo.CONTROLEDETRACAO))
				.build();
		
		Veiculo v7 = Veiculo.Builder
				.newBuilder()
				.withId(null)
				.withPreco(226000.20)
				.withAno(2009)
				.withTipo(TipoVeiculo.HATCHBACK.getCod())
				.withCor(CorVeiculo.PRATA.getCod())
				.withCombustivel(CombustivelVeiculo.ELETRICO.getCod())
				.withCambio(CambioVeiculo.AUTOMATICA.getCod())
				.withNumPortas(PortasVeiculo.QUATRO.getCod())
				.withPlaca("HHE-2224")
				.withDescricao("Carro em perfeito estado, utilizado apenas por uma familia")
				.withKmRodado(10300L)
				.withIpvaPago(true)
				.withBlindado(false)
				.withTroca(false)
				.withGarantiaFabrica(true)
				.withUnicoDono(true)
				.withModelo(mod8)
				.withOpcionais(Arrays.asList(OpcionaisVeiculo.AIRBAG, OpcionaisVeiculo.BANCOSDECOURO, OpcionaisVeiculo.CONTROLEDETRACAO, OpcionaisVeiculo.ALARME))
				.build();
		
		Veiculo v8 = Veiculo.Builder
				.newBuilder()
				.withId(null)
				.withPreco(23609.30)
				.withAno(2014)
				.withTipo(TipoVeiculo.SUV.getCod())
				.withCor(CorVeiculo.ROSA.getCod())
				.withCombustivel(CombustivelVeiculo.GASOLINAEELETRICO.getCod())
				.withCambio(CambioVeiculo.AUTOMATICA.getCod())
				.withNumPortas(PortasVeiculo.QUATRO.getCod())
				.withPlaca("KHK-7524")
				.withDescricao("Em ótimas condições")
				.withKmRodado(2000L)
				.withIpvaPago(true)
				.withBlindado(true)
				.withTroca(true)
				.withGarantiaFabrica(true)
				.withUnicoDono(true)
				.withModelo(mod9)
				.withOpcionais(Arrays.asList(OpcionaisVeiculo.AIRBAG, OpcionaisVeiculo.CONTROLEDETRACAO, OpcionaisVeiculo.ALARME, OpcionaisVeiculo.VOLANTECOMREGULAGEMDEALTURA))
				.build();
		
		Veiculo v9 = Veiculo.Builder
				.newBuilder()
				.withId(null)
				.withPreco(63604.64)
				.withAno(2017)
				.withTipo(TipoVeiculo.HATCHBACK.getCod())
				.withCor(CorVeiculo.VERMELHO.getCod())
				.withCombustivel(CombustivelVeiculo.GASOLINA.getCod())
				.withCambio(CambioVeiculo.MANUAL.getCod())
				.withNumPortas(PortasVeiculo.QUATRO.getCod())
				.withPlaca("GSK-6424")
				.withDescricao("Carro precisa ser reparado algumas partes da lataria")
				.withKmRodado(89600L)
				.withIpvaPago(false)
				.withBlindado(false)
				.withTroca(true)
				.withGarantiaFabrica(false)
				.withUnicoDono(false)
				.withModelo(mod8)
				.withOpcionais(Arrays.asList(OpcionaisVeiculo.ARCONDICIONADO, OpcionaisVeiculo.CONTROLEDETRACAO, OpcionaisVeiculo.ALARME))
				.build();
		
		Veiculo v10 = Veiculo.Builder
				.newBuilder()
				.withId(null)
				.withPreco(90000.64)
				.withAno(2020)
				.withTipo(TipoVeiculo.HATCHBACK.getCod())
				.withCor(CorVeiculo.BRANCO.getCod())
				.withCombustivel(CombustivelVeiculo.GASOLINA.getCod())
				.withCambio(CambioVeiculo.AUTOMATIZADA.getCod())
				.withNumPortas(PortasVeiculo.QUATRO.getCod())
				.withPlaca("LSK-9824")
				.withDescricao("Só comprar e andar")
				.withKmRodado(2000L)
				.withIpvaPago(true)
				.withBlindado(false)
				.withTroca(false)
				.withGarantiaFabrica(true)
				.withUnicoDono(true)
				.withModelo(mod10)
				.withOpcionais(Arrays.asList(OpcionaisVeiculo.ARCONDICIONADO, OpcionaisVeiculo.CONTROLEDETRACAO, OpcionaisVeiculo.ALARME))
				.build();
		
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
