package com.mauriciopd.carstore.services;

import java.text.ParseException;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.mauriciopd.carstore.domain.Adicional;
import com.mauriciopd.carstore.domain.Colaborador;
import com.mauriciopd.carstore.domain.Cor;
import com.mauriciopd.carstore.domain.Marca;
import com.mauriciopd.carstore.domain.Modelo;
import com.mauriciopd.carstore.domain.Opcional;
import com.mauriciopd.carstore.domain.Veiculo;
import com.mauriciopd.carstore.domain.enums.CambioVeiculo;
import com.mauriciopd.carstore.domain.enums.CombustivelVeiculo;
import com.mauriciopd.carstore.domain.enums.Perfil;
import com.mauriciopd.carstore.domain.enums.TipoVeiculo;
import com.mauriciopd.carstore.repository.AdicionalRepository;
import com.mauriciopd.carstore.repository.ColaboradorRepository;
import com.mauriciopd.carstore.repository.CorRepository;
import com.mauriciopd.carstore.repository.MarcaRepository;
import com.mauriciopd.carstore.repository.ModeloRepository;
import com.mauriciopd.carstore.repository.OpcionalRepository;
import com.mauriciopd.carstore.repository.VeiculoRepository;

@Service
public class DBService {
	
	@Autowired
	private MarcaRepository marcaRepository;

	@Autowired
	private ModeloRepository modeloRepository;

	@Autowired
	private VeiculoRepository veiculoRepository;
	
	@Autowired
	private OpcionalRepository opcionalRepository;
	
	@Autowired
	private AdicionalRepository adicionalRepository;
	
	@Autowired
	private ColaboradorRepository colaboradorRepository;
	
	@Autowired
	private BCryptPasswordEncoder pe;
	
	@Autowired
	private CorRepository corRepository;
	
	public void instantiateTestDatabase() throws ParseException {
		Marca m1 = new Marca(null, "Dodge");
		Marca m2 = new Marca(null, "Fiat");
		Marca m3 = new Marca(null, "Ford");
		Marca m4 = new Marca(null, "volkswagen");
		Marca m5 = new Marca(null, "Chevrolet");
		Marca m6 = new Marca(null, "Hyundai");
		Marca m7 = new Marca(null, "BMW");
		
		Opcional op1 = new Opcional(null, "Airbag");
		Opcional op2 = new Opcional(null, "Alarme");
		Opcional op3 = new Opcional(null, "Ar quente");
		Opcional op4 = new Opcional(null, "Banco com regulagem de altura");
		Opcional op5 = new Opcional(null, "CD Player");
		Opcional op6 = new Opcional(null, "Rádio");
		Opcional op7 = new Opcional(null, "Computador de bordo");
		Opcional op8 = new Opcional(null, "Controle de tração");
		Opcional op9 = new Opcional(null, "Desembaçador traseiro");
		Opcional op10 = new Opcional(null, "Ar condicionado");
		Opcional op11 = new Opcional(null, "Encosto de cabeça traseiro");
		Opcional op12 = new Opcional(null, "Freio ABS");
		Opcional op13 = new Opcional(null, "Controle automático de velocidade");
		Opcional op14 = new Opcional(null, "Retrovisores elétricos");
		Opcional op15 = new Opcional(null, "Rodas de liga leve");
		Opcional op16 = new Opcional(null, "Travas elétricas");
		Opcional op17 = new Opcional(null, "Vidros elétricos");
		Opcional op18 = new Opcional(null, "Volante com regulagem de altura");
		Opcional op19 = new Opcional(null, "Bancos de couro");
		Opcional op20 = new Opcional(null, "Direção hidraulica");
		Opcional op21 = new Opcional(null, "GPS");
		Opcional op22 = new Opcional(null, "Sensor de chuva");
		Opcional op23 = new Opcional(null, "Teto solar");
		
		Adicional ad1 = new Adicional(null, "IPVA Pago");
		Adicional ad2 = new Adicional(null, "Blindado");
		Adicional ad3 = new Adicional(null, "Uníco dono");
		Adicional ad4= new Adicional(null, "Garantia de fábrica");
		Adicional ad5= new Adicional(null, "Aceita troca");
		
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
		
		Cor cor1 = new Cor(null, "Preto");
		Cor cor2 = new Cor(null, "Branco");
		Cor cor3 = new Cor(null, "Azul");
		Cor cor4 = new Cor(null, "Bege");
		Cor cor5 = new Cor(null, "Prata");
		
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
				.withCor(cor1)
				.withCombustivel(CombustivelVeiculo.GASOLINA.getCod())
				.withCambio(CambioVeiculo.AUTOMATICA.getCod())
				.withNumPortas(4)
				.withPlaca("UTY-4343")
				.withDescricao("Veiculo em ótimo estado, nunca foi batido!")
				.withKmRodado(45000L)
				.withModelo(mod5)
				.withOpcionais(Arrays.asList(op1, op2, op3, op4, op5))
				.withAdicionais(Arrays.asList(ad1, ad2, ad5))
				.build();
		
		Veiculo v2 = Veiculo.Builder
				.newBuilder()
				.withId(null)
				.withPreco(33000.20)
				.withAno(2017)
				.withTipo(TipoVeiculo.HATCHBACK.getCod())
				.withCor(cor2)
				.withCombustivel(CombustivelVeiculo.GASOLINAEGAS.getCod())
				.withCambio(CambioVeiculo.MANUAL.getCod())
				.withNumPortas(4)
				.withPlaca("ADY-4244")
				.withDescricao("Já teve 3 donos, já foi batido")
				.withKmRodado(200000L)
				.withModelo(mod3)
				.withOpcionais(Arrays.asList(op6, op7, op8, op9, op10))
				.withAdicionais(Arrays.asList(ad1))
				.build();
		
		Veiculo v3 = Veiculo.Builder
				.newBuilder()
				.withId(null)
				.withPreco(36500.70)
				.withAno(2014)
				.withTipo(TipoVeiculo.SEDAN.getCod())
				.withCor(cor3)
				.withCombustivel(CombustivelVeiculo.GASOLINA.getCod())
				.withCambio(CambioVeiculo.AUTOMATIZADA.getCod())
				.withNumPortas(4)
				.withPlaca("JKY-2763")
				.withDescricao("Carro super confortavel!")
				.withKmRodado(83456L)
				.withModelo(mod6)
				.withOpcionais(Arrays.asList(op11, op12, op13, op14, op15, op1))
				.withAdicionais(Arrays.asList(ad3, ad5, ad4))
				.build();
		
		Veiculo v4 = Veiculo.Builder
				.newBuilder()
				.withId(null)
				.withPreco(55000.20)
				.withAno(2012)
				.withTipo(TipoVeiculo.SUV.getCod())
				.withCor(cor4)
				.withCombustivel(CombustivelVeiculo.GASOLINA.getCod())
				.withCambio(CambioVeiculo.AUTOMATICA.getCod())
				.withNumPortas(4)
				.withPlaca("JCE-8242")
				.withDescricao("Carro em perfeito estado, fazer as trocas dos pneus.")
				.withKmRodado(120000L)
				.withModelo(mod1)
				.withOpcionais(Arrays.asList(op16, op17, op18, op19, op20))
				.withAdicionais(Arrays.asList(ad1, ad2, ad5, ad4))
				.build();
		
		Veiculo v5 = Veiculo.Builder
				.newBuilder()
				.withId(null)
				.withPreco(120000.20)
				.withAno(2019)
				.withTipo(TipoVeiculo.PICAPE.getCod())
				.withCor(cor5)
				.withCombustivel(CombustivelVeiculo.DIESEL.getCod())
				.withCambio(CambioVeiculo.MANUAL.getCod())
				.withNumPortas(4)
				.withPlaca("HFT-3232")
				.withDescricao("Carro era utilizado para fazer offroad.")
				.withKmRodado(92000L)
				.withModelo(mod4)
				.withOpcionais(Arrays.asList(op21, op22, op23, op10, op12))
				.withAdicionais(Arrays.asList(ad1, ad2))
				.build();
		
		Veiculo v6 = Veiculo.Builder
				.newBuilder()
				.withId(null)
				.withPreco(126000.20)
				.withAno(2019)
				.withTipo(TipoVeiculo.MINIVAN.getCod())
				.withCor(cor1)
				.withCombustivel(CombustivelVeiculo.GASOLINAALCOOLEGAS.getCod())
				.withCambio(CambioVeiculo.AUTOMATICA.getCod())
				.withNumPortas(4)
				.withPlaca("GFE-3434")
				.withDescricao("Carro era utilizado para fazer fretes, nos correios. Carro faz um barulho na roda dianteira")
				.withKmRodado(82450L)
				.withModelo(mod7)
				.withOpcionais(Arrays.asList(op17, op3, op23, op15, op19))
				.withAdicionais(Arrays.asList(ad2, ad5, ad3))
				.build();
		
		Veiculo v7 = Veiculo.Builder
				.newBuilder()
				.withId(null)
				.withPreco(226000.20)
				.withAno(2009)
				.withTipo(TipoVeiculo.HATCHBACK.getCod())
				.withCor(cor4)
				.withCombustivel(CombustivelVeiculo.ELETRICO.getCod())
				.withCambio(CambioVeiculo.AUTOMATICA.getCod())
				.withNumPortas(4)
				.withPlaca("HHE-2224")
				.withDescricao("Carro em perfeito estado, utilizado apenas por uma familia")
				.withKmRodado(10300L)
				.withModelo(mod8)
				.withOpcionais(Arrays.asList(op1, op2, op9, op15, op17))
				.withAdicionais(Arrays.asList(ad1, ad5))
				.build();
		
		Veiculo v8 = Veiculo.Builder
				.newBuilder()
				.withId(null)
				.withPreco(23609.30)
				.withAno(2014)
				.withTipo(TipoVeiculo.SUV.getCod())
				.withCor(cor3)
				.withCombustivel(CombustivelVeiculo.GASOLINAEELETRICO.getCod())
				.withCambio(CambioVeiculo.AUTOMATICA.getCod())
				.withNumPortas(4)
				.withPlaca("KHK-7524")
				.withDescricao("Em ótimas condições")
				.withKmRodado(2000L)
				.withModelo(mod9)
				.withOpcionais(Arrays.asList(op8, op2, op12, op20, op23))
				.withAdicionais(Arrays.asList(ad1, ad2, ad3))
				.build();
		
		Veiculo v9 = Veiculo.Builder
				.newBuilder()
				.withId(null)
				.withPreco(63604.64)
				.withAno(2017)
				.withTipo(TipoVeiculo.HATCHBACK.getCod())
				.withCor(cor2)
				.withCombustivel(CombustivelVeiculo.GASOLINA.getCod())
				.withCambio(CambioVeiculo.MANUAL.getCod())
				.withNumPortas(4)
				.withPlaca("GSK-6424")
				.withDescricao("Carro precisa ser reparado algumas partes da lataria")
				.withKmRodado(89600L)
				.withModelo(mod8)
				.withOpcionais(Arrays.asList(op23, op22, op7, op21, op17))
				.withAdicionais(Arrays.asList(ad1, ad2, ad3, ad4, ad5))
				.build();
		
		Veiculo v10 = Veiculo.Builder
				.newBuilder()
				.withId(null)
				.withPreco(90000.64)
				.withAno(2020)
				.withTipo(TipoVeiculo.HATCHBACK.getCod())
				.withCor(cor1)
				.withCombustivel(CombustivelVeiculo.GASOLINA.getCod())
				.withCambio(CambioVeiculo.AUTOMATIZADA.getCod())
				.withNumPortas(4)
				.withPlaca("LSK-9824")
				.withDescricao("Só comprar e andar")
				.withKmRodado(2000L)
				.withModelo(mod10)
				.withOpcionais(Arrays.asList(op9, op10, op23, op11, op14))
				.withAdicionais(Arrays.asList(ad1, ad2))
				.build();
		
		Veiculo v11 = Veiculo.Builder
				.newBuilder()
				.withId(null)
				.withPreco(99000.64)
				.withAno(2020)
				.withTipo(TipoVeiculo.HATCHBACK.getCod())
				.withCor(cor4)
				.withCombustivel(CombustivelVeiculo.GASOLINA.getCod())
				.withCambio(CambioVeiculo.AUTOMATIZADA.getCod())
				.withNumPortas(4)
				.withPlaca("LGK-5824")
				.withDescricao("Muito bom!")
				.withKmRodado(9000L)
				.withModelo(mod5)
				.withOpcionais(Arrays.asList(op1, op2, op6))
				.withAdicionais(Arrays.asList(ad2))
				.build();
		
		op1.getVeiculos().addAll(Arrays.asList(v1, v7, v3, v11));
		op2.getVeiculos().addAll(Arrays.asList(v8, v7, v1, v11));
		op3.getVeiculos().addAll(Arrays.asList(v6, v1));
		op4.getVeiculos().addAll(Arrays.asList(v1));
		op5.getVeiculos().addAll(Arrays.asList(v1));
		op6.getVeiculos().addAll(Arrays.asList(v2, v11));
		op7.getVeiculos().addAll(Arrays.asList(v9, v2));
		op8.getVeiculos().addAll(Arrays.asList(v8, v2));
		op9.getVeiculos().addAll(Arrays.asList(v10, v7, v2));
		op10.getVeiculos().addAll(Arrays.asList(v10, v5, v2));
		op11.getVeiculos().addAll(Arrays.asList(v10, v3));
		op12.getVeiculos().addAll(Arrays.asList(v8, v5, v3));
		op13.getVeiculos().addAll(Arrays.asList(v3));
		op14.getVeiculos().addAll(Arrays.asList(v10, v3));
		op15.getVeiculos().addAll(Arrays.asList(v7, v6, v3));
		op16.getVeiculos().addAll(Arrays.asList(v4));
		op17.getVeiculos().addAll(Arrays.asList(v9, v7, v6, v4));
		op18.getVeiculos().addAll(Arrays.asList(v4));
		op19.getVeiculos().addAll(Arrays.asList(v6, v4));
		op20.getVeiculos().addAll(Arrays.asList(v8, v4));
		op21.getVeiculos().addAll(Arrays.asList(v9, v5));
		op22.getVeiculos().addAll(Arrays.asList(v9, v5));
		op23.getVeiculos().addAll(Arrays.asList(v10, v9, v8, v6, v5));
		
		ad1.getVeiculos().addAll(Arrays.asList(v1, v2, v4, v5, v7, v8, v9, v10));
		ad2.getVeiculos().addAll(Arrays.asList(v1, v4, v5, v6, v8, v9, v10, v11));
		ad3.getVeiculos().addAll(Arrays.asList(v3, v6, v8, v9));
		ad4.getVeiculos().addAll(Arrays.asList(v3, v4, v9));
		ad5.getVeiculos().addAll(Arrays.asList(v1, v3, v4, v6, v7, v9));
		
		mod1.getVeiculos().addAll(Arrays.asList(v4));
		mod2.getVeiculos().addAll(Arrays.asList());
		mod3.getVeiculos().addAll(Arrays.asList(v2));
		mod4.getVeiculos().addAll(Arrays.asList(v5));
		mod5.getVeiculos().addAll(Arrays.asList(v1, v11));
		mod6.getVeiculos().addAll(Arrays.asList(v3));
		mod7.getVeiculos().addAll(Arrays.asList(v6));
		mod8.getVeiculos().addAll(Arrays.asList(v7, v9));
		mod9.getVeiculos().addAll(Arrays.asList(v8));
		mod9.getVeiculos().addAll(Arrays.asList(v10));
		
		cor1.getVeiculos().addAll(Arrays.asList(v1, v10, v6));
		cor2.getVeiculos().addAll(Arrays.asList(v2, v9));
		cor3.getVeiculos().addAll(Arrays.asList(v3, v8));
		cor4.getVeiculos().addAll(Arrays.asList(v4, v7, v11));
		cor5.getVeiculos().addAll(Arrays.asList(v5));
		
		//-----
		
		Colaborador c1 = new Colaborador(null, "Mauricio Pruss Duarte", "prussdev@gmail.com", pe.encode("123")); 
		c1.addPerfil(Perfil.ADMIN);
		
		Colaborador c2 = new Colaborador(null, "Carlos da Silva", "prussdesign@gmail.com", pe.encode("1234")); 
		Colaborador c3 = new Colaborador(null, "Julia Pruss Duarte", "julia.prussduarte@hotmail.com", pe.encode("12345")); 
		colaboradorRepository.saveAll(Arrays.asList(c1, c2, c3));
		
		marcaRepository.saveAll(Arrays.asList(m1, m2, m3, m4, m5, m6, m7));
		modeloRepository.saveAll(Arrays.asList(mod1, mod2, mod3, mod4, mod5, mod6, mod7, mod8, mod9, mod10));
		corRepository.saveAll(Arrays.asList(cor1, cor2, cor3, cor4, cor5));
		veiculoRepository.saveAll(Arrays.asList(v1, v2, v3, v4, v5, v6, v7, v8, v9, v10, v11));
		opcionalRepository.saveAll(Arrays.asList(op1, op2, op3, op4, op5, op6, op7, op8, op9, op10, op11, op12, op13, op14, op15, op16, op17, op18, op19, op20, op21, op22, op23));
		adicionalRepository.saveAll(Arrays.asList(ad1, ad2, ad3, ad4, ad5));
		
	}
}
