package com.mauriciopd.carstore.services;

import java.text.ParseException;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.mauriciopd.carstore.domain.Adicional;
import com.mauriciopd.carstore.domain.Cambio;
import com.mauriciopd.carstore.domain.Colaborador;
import com.mauriciopd.carstore.domain.Combustivel;
import com.mauriciopd.carstore.domain.Cor;
import com.mauriciopd.carstore.domain.Marca;
import com.mauriciopd.carstore.domain.Modelo;
import com.mauriciopd.carstore.domain.Opcional;
import com.mauriciopd.carstore.domain.Tipo;
import com.mauriciopd.carstore.domain.Veiculo;
import com.mauriciopd.carstore.domain.Versao;
import com.mauriciopd.carstore.domain.enums.Perfil;
import com.mauriciopd.carstore.repository.AdicionalRepository;
import com.mauriciopd.carstore.repository.CambioRepository;
import com.mauriciopd.carstore.repository.ColaboradorRepository;
import com.mauriciopd.carstore.repository.CombustivelRepository;
import com.mauriciopd.carstore.repository.CorRepository;
import com.mauriciopd.carstore.repository.MarcaRepository;
import com.mauriciopd.carstore.repository.ModeloRepository;
import com.mauriciopd.carstore.repository.OpcionalRepository;
import com.mauriciopd.carstore.repository.TipoRepository;
import com.mauriciopd.carstore.repository.VeiculoRepository;
import com.mauriciopd.carstore.repository.VersaoRepository;

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
	private CambioRepository cambioRepository;
	
	@Autowired
	private CombustivelRepository combustivelRepository;
	
	@Autowired
	private TipoRepository tipoRepository;
	
	@Autowired
	private BCryptPasswordEncoder pe;
	
	@Autowired
	private VersaoRepository versaoRepository;
	
	@Autowired
	private CorRepository corRepository;
	
	public void instantiateTestDatabase() throws ParseException {
		Marca m1 = new Marca(null, "Dodge");
		Marca m2 = new Marca(null, "Fiat");
		Marca m3 = new Marca(null, "Ford");
		Marca m4 = new Marca(null, "Volkswagen");
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
		
		//Dodge - Journey
		Versao ver1 = new Versao(null, "JOURNEY RT 2.7 V6 185CV AUT.", mod1);
		Versao ver2 = new Versao(null, "JOURNEY SE 2.7 V6 185CV AUT.", mod1);
		Versao ver3 = new Versao(null, "JOURNEY SXT 2.7 V6 185CV AUT.", mod1);
		Versao ver4 = new Versao(null, "JOURNEY SXT 3.6 V6 AUT.", mod1);
		Versao ver5 = new Versao(null, "JOURNEY RT  3.6 V6 AUT.", mod1);
		Versao ver6 = new Versao(null, "JOURNEY CROSSROAD 3.6 V6 AUT.", mod1);
		Versao ver7 = new Versao(null, "JOURNEY RT 3.6 AWD V6 AUT.", mod1);
		
		//Dodge - Durango
		Versao ver8 = new Versao(null, "DURANGO CREW 3.6 24V 4X4 AUT.", mod2);
		Versao ver9 = new Versao(null, "DURANGO CITADEL 3.6 24V 4X4 AUT.", mod2);
		Versao ver10 = new Versao(null, "DURANGO LIMITED 3.6 24V 4X4 AUT.", mod2);
		
		//Fiat - Grand Siena
		Versao ver11 = new Versao(null, "GRAND SIENA ESSENCE 1.6 FLEX 16V", mod3);
		Versao ver12 = new Versao(null, "GRAND SIENA TETRAFUEL 1.4 EVO F. FLEX 8V", mod3);
		Versao ver13 = new Versao(null, "GRAND SIENA ATTRAC. 1.4 EVO F.FLEX 8V", mod3);
		Versao ver14 = new Versao(null, "GRAND SIENA ESSENCE DUAL. 1.6 FLEX 16V", mod3);
		Versao ver15 = new Versao(null, "GRAND SIENA ESSEN.SUBLIME 1.6 FLEX", mod3);
		Versao ver16 = new Versao(null, "GRAND SIENA ESSEN.SUBLIME DUAL. 1.6 FLEX", mod3);
		Versao ver17 = new Versao(null, "GRAND SIENA ESSEN. ITALIA DUAL. 1.6 FLEX", mod3);
		Versao ver18 = new Versao(null, "GRAND SIENA ESSENCE ITALIA 1.6 FLEX 16V", mod3);
		Versao ver19 = new Versao(null, "GRAND SIENA ATTRACTIVE 1.0 FLEX 8V 4P", mod3);
		
		//Ford - Fusion
		Versao ver20 = new Versao(null, "FUSION HYBRID 2.5 16V 193CV AUT.", mod5);
		Versao ver21 = new Versao(null, "FUSION SEL 2.3 16V  162CV AUT.", mod5);
		Versao ver22 = new Versao(null, "FUSION SEL 2.5 16V 173CV AUT.", mod5);
		Versao ver23 = new Versao(null, "FUSION SEL 3.0 V6  24V 243CV AUT.", mod5);
		Versao ver24 = new Versao(null, "FUSION SEL 3.0 V6 AWD 24V 243CV AUT.", mod5);
		Versao ver25 = new Versao(null, "FUSION TITANIUM 2.0 GTDI ECO. AWD AUT.", mod5);
		Versao ver26 = new Versao(null, "FUSION TITANIUM 2.0 GTDI ECO. FWD AUT.", mod5);
		Versao ver27 = new Versao(null, "FUSION 2.5L I-VCT FLEX AUT.", mod5);
		Versao ver28 = new Versao(null, "FUSION TITANIUM HYBRID 2.0 145CV AUT.", mod5);
		Versao ver29 = new Versao(null, "FUSION SE 2.5 I-VCT FLEX 16V AUT.", mod5);
		Versao ver30 = new Versao(null, "FUSION SEL 2.0 ECOBO. 16V 248CV AUT.", mod5);
		
		//Ford - Focus
		Versao ver31 = new Versao(null, "FUSION HYBRID 2.5 16V 193CV AUT.", mod6);
		Versao ver32 = new Versao(null, "FUSION SEL 2.3 16V  162CV AUT.", mod6);
		Versao ver33 = new Versao(null, "FUSION SEL 2.5 16V 173CV AUT.", mod6);
		Versao ver34 = new Versao(null, "FUSION SEL 3.0 V6  24V 243CV AUT.", mod6);
		Versao ver35 = new Versao(null, "FUSION SEL 3.0 V6 AWD 24V 243CV AUT.", mod6);
		Versao ver36 = new Versao(null, "FUSION TITANIUM 2.0 GTDI ECO. AWD AUT.", mod6);
		Versao ver37 = new Versao(null, "FUSION TITANIUM 2.0 GTDI ECO. FWD AUT.", mod6);
		Versao ver38 = new Versao(null, "FUSION 2.5L I-VCT FLEX AUT.", mod6);
		Versao ver39 = new Versao(null, "FUSION TITANIUM HYBRID 2.0 145CV AUT.", mod6);
		Versao ver40 = new Versao(null, "FUSION SE 2.5 I-VCT FLEX 16V AUT.", mod6);
		Versao ver41 = new Versao(null, "FUSION SEL 2.0 ECOBO. 16V 248CV AUT.", mod6);
		Versao ver42 = new Versao(null, "FUSION SEL 3.0 V6  24V 243CV AUT.", mod6);
		Versao ver43 = new Versao(null, "FUSION SEL 3.0 V6 AWD 24V 243CV AUT.", mod6);
		Versao ver44 = new Versao(null, "FUSION TITANIUM 2.0 GTDI ECO. AWD AUT.", mod6);
		Versao ver45 = new Versao(null, "FUSION TITANIUM 2.0 GTDI ECO. FWD AUT.", mod6);
		Versao ver46 = new Versao(null, "FUSION 2.5L I-VCT FLEX AUT.", mod6);
		Versao ver47 = new Versao(null, "FUSION TITANIUM HYBRID 2.0 145CV AUT.", mod6);
		Versao ver48 = new Versao(null, "FUSION SE 2.5 I-VCT FLEX 16V AUT.", mod6);
		Versao ver49 = new Versao(null, "FUSION SEL 2.0 ECOBO. 16V 248CV AUT.", mod6);
		
		//Volkswagen - POLO
		Versao ver50 = new Versao(null, "POLO BLUEMOTION 1.6 TOTAL FLEX 8V 5P", mod4);
		Versao ver51 = new Versao(null, "POLO GT 2.0 MI TOTAL FLEX 8V 5P", mod4);
		Versao ver52 = new Versao(null, "POLO 1.0 MI 79CV 16V 5P", mod4);
		Versao ver53 = new Versao(null, "POLO 1.6 E-FLEX 8V 5P", mod4);
		Versao ver54 = new Versao(null, "POLO 1.6 MI/ S.OURO 1.6MI 101CV 8V 5P", mod4);
		Versao ver55 = new Versao(null, "POLO 1.6 MI/S.OURO 1.6 MI TOT.FLEX 8V 5P", mod4);
		Versao ver56 = new Versao(null, "POLO 2.0 MI 116CV 8V 5P", mod4);
		Versao ver57 = new Versao(null, "POLO CLASSIC 1.0 MI 16V  65CV 4P", mod4);
		Versao ver58 = new Versao(null, "POLO CLASSIC/ SPECIAL 1.8 MI", mod4);
		Versao ver59 = new Versao(null, "POLO GTI 1.8 MI 150CV 20V TURBO 3P", mod4);
		Versao ver60 = new Versao(null, "POLO I MOTION 1.6 TOTAL FLEX  5P", mod4);
		Versao ver61 = new Versao(null, "POLO NEXT 1.6 MI 101CV 8V 5P", mod4);
		Versao ver62 = new Versao(null, "POLO SPORTLINE 1.6 MI TOTAL FLEX 8V 5P", mod4);
		Versao ver63 = new Versao(null, "POLO SPORTLINE I MOTION 1.6 T.FLEX 5P", mod4);
		Versao ver64 = new Versao(null, "POLO SED. COMFORT. 1.6 MI TOT. FLEX 8V", mod4);
		Versao ver65 = new Versao(null, "POLO SED./SED. COMF. 2.0/2.0 FLEX 8V 4P", mod4);
		Versao ver66 = new Versao(null, "POLO SED.COMFORT. I MOTION 1.6 T.FLEX 4P", mod4);
		Versao ver67 = new Versao(null, "POLO SEDAN 1.6 MI 101CV 8V 4P", mod4);
		Versao ver68 = new Versao(null, "POLO SEDAN 1.6 MI TOTAL FLEX 8V 4P", mod4);
		Versao ver69 = new Versao(null, "POLO SEDAN EVIDENCE 1.6 MI T.FLEX 8V 4P", mod4);
		Versao ver70 = new Versao(null, "POLO SEDAN I MOTION  1.6 TOTAL FLEX  4P", mod4);
		Versao ver71 = new Versao(null, "POLO SPORTLINE 2.0 MI TOTAL FLEX 8V 5P", mod4);
		Versao ver72 = new Versao(null, "POLO 1.6 MI FLEX 8V 4P", mod4);
		Versao ver73 = new Versao(null, "POLO 1.0 FLEX 12V 5P", mod4);
		Versao ver74 = new Versao(null, "POLO 1.6 MSI FLEX 16V 5P", mod4);
		Versao ver75 = new Versao(null, "POLO COMFORT. 200 TSI 1.0 FLEX 12V AUT.", mod4);
		Versao ver76 = new Versao(null, "POLO HIGHLINE 200 TSI 1.0 FLEX 12V AUT.", mod4);
		Versao ver77 = new Versao(null, "POLO 1.6 MSI TOTAL FLEX 16V 5P AUT", mod4);
		Versao ver78 = new Versao(null, "POLO SENSE 200 TSI 1.0 FLEX 12V AUT(PCD)", mod4);

		//Chevrolet - Spin
		Versao ver79 = new Versao(null, "SPIN LTZ 1.8 8V ECONO.FLEX 5P AUT.", mod7);
		Versao ver80 = new Versao(null, "SPIN LT 1.8 8V ECONO.FLEX 5P MEC.", mod7);
		Versao ver81 = new Versao(null, "SPIN LTZ 1.8 8V ECONO.FLEX 5P MEC.", mod7);
		Versao ver82 = new Versao(null, "SPIN LT 1.8 8V ECONO.FLEX 5P AUT.", mod7);
		Versao ver83 = new Versao(null, "SPIN LS 1.8 8V ECONO.FLEX 5P MEC.", mod7);
		Versao ver84 = new Versao(null, "SPIN ADVANTAGE 1.8 8V ECONO.FLEX 5P AUT.", mod7);
		Versao ver85 = new Versao(null, "SPIN ADVANTAGE 1.8 8V ECONO.FLEX 5P MEC.", mod7);
		Versao ver86 = new Versao(null, "SPIN ACTIV 1.8 8V ECONO. FLEX 5P AUT.", mod7);
		Versao ver87 = new Versao(null, "SPIN ACTIV 1.8 8V ECONO. FLEX 5P MEC.", mod7);
		Versao ver88 = new Versao(null, "SPIN ACTIV7 1.8 8V ECONO.FLEX 5P AUT.", mod7);
		Versao ver89 = new Versao(null, "SPIN PREMIER 1.8 8V ECONO.FLEX 5P AUT.", mod7);
		Versao ver90 = new Versao(null, "SPIN PREMIER 1.8 8V ECONO.FLEX 5P MEC.", mod7);
		
		//Hyundai - HB20
		Versao ver91 = new Versao(null, "HB20 C./C.PLUS/C.STYLE 1.6 FLEX 16V MEC.", mod8);
		Versao ver92 = new Versao(null, "HB20 PREMIUM 1.6 FLEX 16V MEC.", mod8);
		Versao ver93 = new Versao(null, "HB20 COMF./C.PLUS/C.STYLE 1.0 FLEX 12V", mod8);
		Versao ver94 = new Versao(null, "HB20 C.STYLE/C.PLUS 1.6 FLEX 16V AUT.", mod8);
		Versao ver95 = new Versao(null, "HB20 PREMIUM 1.6 FLEX 16V AUT.", mod8);
		Versao ver96 = new Versao(null, "HB20 COPA DO MUNDO 1.0 FLEX 12V MEC.", mod8);
		Versao ver97 = new Versao(null, "HB20 COPA DO MUNDO 1.6 FLEX 16V AUT.", mod8);
		Versao ver98 = new Versao(null, "HB20 COPA DO MUNDO 1.6 FLEX 16V MEC.", mod8);
		Versao ver99 = new Versao(null, "HB20 FOR YOU 1.0 FLEX 12V 5P", mod8);
		Versao ver100 = new Versao(null, "HB20 S FOR YOU 1.0 FLEX 12V 4P", mod8);
		Versao ver101 = new Versao(null, "HB20 SPICY 1.0 FLEX 12V MEC.", mod8);
		Versao ver102 = new Versao(null, "HB20 SPICY 1.6 FLEX 16V AUT.", mod8);
		Versao ver103 = new Versao(null, "HB20 SPICY 1.6 FLEX 16V MEC.", mod8);
		Versao ver104 = new Versao(null, "HB20 R SPEC 1.6 AUTOMATICO.", mod8);
		Versao ver105 = new Versao(null, "HB20 R SPEC 1.6 MANUAL", mod8);
		Versao ver106 = new Versao(null, "HB20 R SPEC 1.6 FLEX 16V AUT.", mod8);
		Versao ver107 = new Versao(null, "HB20 R SPEC 1.6 FLEX 16V MEC.", mod8);
		Versao ver108 = new Versao(null, "HB20 COMFORT PLUS 1.0 TB FLEX 12V MEC.", mod8);
		Versao ver109 = new Versao(null, "HB20 COMFORT STYLE 1.0 TB FLEX 12V MEC.", mod8);
		Versao ver110 = new Versao(null, "HB20 OCEAN 1.0 FLEX 12V 5P MEC.", mod8);
		Versao ver111 = new Versao(null, "HB20 OCEAN 1.6 FLEX 16V 5P AUT.", mod8);
		Versao ver112 = new Versao(null, "HB20 OCEAN 1.6 FLEX 16V 5P MEC.", mod8);
		Versao ver113 = new Versao(null, "1.0 OCEAN", mod8);
		Versao ver114 = new Versao(null, "COMFORT STYLE 1.0 TURBO", mod8);
		Versao ver115 = new Versao(null, "R-SPEC 1.6 AUTOMATICO", mod8);
		Versao ver116 = new Versao(null, "R-SPEC 1.6 MANUAL", mod8);
		Versao ver117 = new Versao(null, "HB20 5 ANOS 1.0 FLEX 12V MEC.", mod8);
		Versao ver118 = new Versao(null, "HB20 5 ANOS 1.6 FLEX 16V AUT.", mod8);
		Versao ver119 = new Versao(null, "HB20 R SPEC LIMITED 1.6 FLEX 16V AUT.", mod8);
		Versao ver120 = new Versao(null, "HB20 1 MILLION 1.6 FLEX 16V AUT.", mod8);
		Versao ver121 = new Versao(null, "HB20 UNIQUE 1.0 FLEX 12V MEC.", mod8);
		
		//Hyundai - Elantra
		Versao ver122 = new Versao(null, "ELANTRA GL", mod10);
		Versao ver123 = new Versao(null, "ELANTRA GLS 1.6", mod10);
		Versao ver124 = new Versao(null, "ELANTRA GLS 1.8 16V", mod10);
		Versao ver125 = new Versao(null, "ELANTRA GLS 2.0 16V AUT.", mod10);
		Versao ver126 = new Versao(null, "ELANTRA GLS 2.0 16V MEC.", mod10);
		Versao ver127 = new Versao(null, "ELANTRA WAGON 1.8 16V", mod10);
		Versao ver128 = new Versao(null, "ELANTRA GLS 2.0 16V FLEX AUT.", mod10);
		Versao ver129 = new Versao(null, "ELANTRA GLS 1.8 16V MEC.", mod10);
		Versao ver130 = new Versao(null, "ELANTRA GLS 1.8 16V AUT.", mod10);
		Versao ver131 = new Versao(null, "ELANTRA 2.0 16V FLEX AUT.", mod10);
		Versao ver132 = new Versao(null, "ELANTRA SPECIAL EDIT. 2.0 16V FLEX AUT.", mod10);
		
		//BMW - X1
		Versao ver133 = new Versao(null, "ELANTRA GLS 2.0 16V MEC.", mod9);
		Versao ver134 = new Versao(null, "ELANTRA WAGON 1.8 16V", mod9);
		Versao ver135 = new Versao(null, "ELANTRA GLS 2.0 16V FLEX AUT.", mod9);
		Versao ver136 = new Versao(null, "ELANTRA GLS 1.8 16V MEC.", mod9);
		Versao ver137 = new Versao(null, "ELANTRA GLS 1.8 16V AUT.", mod9);
		Versao ver138 = new Versao(null, "ELANTRA 2.0 16V FLEX AUT.", mod9);
		Versao ver139 = new Versao(null, "ELANTRA SPECIAL EDIT. 2.0 16V FLEX AUT.", mod9);
		
		
		mod1.getVersoes().addAll(Arrays.asList(ver1, ver3));
		mod2.getVersoes().addAll(Arrays.asList(ver2));
		
		
		Cor cor1 = new Cor(null, "Preto");
		Cor cor2 = new Cor(null, "Branco");
		Cor cor3 = new Cor(null, "Azul");
		Cor cor4 = new Cor(null, "Bege");
		Cor cor5 = new Cor(null, "Prata");
		
		Cambio cb1 = new Cambio(null, "Automática");
		Cambio cb2 = new Cambio(null, "Manual");
		Cambio cb3 = new Cambio(null, "CVT");
		Cambio cb4 = new Cambio(null, "Automátizada");
		
		Combustivel comb1 = new Combustivel(null, "Gasolina");
		Combustivel comb2 = new Combustivel(null, "Álcool");
		Combustivel comb3 = new Combustivel(null, "Diesel");
		Combustivel comb4 = new Combustivel(null, "Elétrico");
		Combustivel comb5 = new Combustivel(null, "Gasolina e álcool");
		Combustivel comb6 = new Combustivel(null, "Gasolina e elétrico");
		Combustivel comb7 = new Combustivel(null, "Gasolina, álcool e gás natural");
		Combustivel comb8 = new Combustivel(null, "Gasolina e gás natural");
		Combustivel comb9 = new Combustivel(null, "Álcool e gás natural");
		
		Tipo t1 = new Tipo(null, "Hatchback");
		Tipo t2 = new Tipo(null, "Sedan");
		Tipo t3 = new Tipo(null, "SUV");
		Tipo t4 = new Tipo(null, "Picape");
		Tipo t5 = new Tipo(null, "Minivan");
		Tipo t6 = new Tipo(null, "Esportivo");
		
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
				.withTipo(t3)
				.withCor(cor1)
				.withCombustivel(comb1)
				.withCambio(cb1)
				.withNumPortas(4)
				.withPlaca("UTY-4343")
				.withDescricao("Veiculo em ótimo estado, nunca foi batido!")
				.withKmRodado(45000L)
				//.withModelo(mod5)
				.withVersao(ver20)
				.withOpcionais(Arrays.asList(op1, op2, op3, op4, op5))
				.withAdicionais(Arrays.asList(ad1, ad2, ad5))
				.build();
		
		Veiculo v2 = Veiculo.Builder
				.newBuilder()
				.withId(null)
				.withPreco(33000.20)
				.withAno(2017)
				.withTipo(t1)
				.withCor(cor2)
				.withCombustivel(comb8)
				.withCambio(cb2)
				.withNumPortas(4)
				.withPlaca("ADY-4244")
				.withDescricao("Já teve 3 donos, já foi batido")
				.withKmRodado(200000L)
				//.withModelo(mod3)
				.withVersao(ver11)
				.withOpcionais(Arrays.asList(op6, op7, op8, op9, op10))
				.withAdicionais(Arrays.asList(ad1))
				.build();
		
		Veiculo v3 = Veiculo.Builder
				.newBuilder()
				.withId(null)
				.withPreco(36500.70)
				.withAno(2014)
				.withTipo(t2)
				.withCor(cor3)
				.withCombustivel(comb1)
				.withCambio(cb4)
				.withNumPortas(4)
				.withPlaca("JKY-2763")
				.withDescricao("Carro super confortavel!")
				.withKmRodado(83456L)
				//.withModelo(mod6)
				.withVersao(ver31)
				.withOpcionais(Arrays.asList(op11, op12, op13, op14, op15, op1))
				.withAdicionais(Arrays.asList(ad3, ad5, ad4))
				.build();
		
		Veiculo v4 = Veiculo.Builder
				.newBuilder()
				.withId(null)
				.withPreco(55000.20)
				.withAno(2012)
				.withTipo(t3)
				.withCor(cor4)
				.withCombustivel(comb7)
				.withCambio(cb2)
				.withNumPortas(4)
				.withPlaca("JCE-8242")
				.withDescricao("Carro em perfeito estado, fazer as trocas dos pneus.")
				.withKmRodado(120000L)
				//.withModelo(mod1)
				.withVersao(ver3)
				.withOpcionais(Arrays.asList(op16, op17, op18, op19, op20))
				.withAdicionais(Arrays.asList(ad1, ad2, ad5, ad4))
				.build();
		
		Veiculo v5 = Veiculo.Builder
				.newBuilder()
				.withId(null)
				.withPreco(120000.20)
				.withAno(2019)
				.withTipo(t4)
				.withCor(cor5)
				.withCombustivel(comb3)
				.withCambio(cb3)
				.withNumPortas(4)
				.withPlaca("HFT-3232")
				.withDescricao("Carro era utilizado para fazer offroad.")
				.withKmRodado(92000L)
				//.withModelo(mod4)
				.withVersao(ver50)
				.withOpcionais(Arrays.asList(op21, op22, op23, op10, op12))
				.withAdicionais(Arrays.asList(ad1, ad2))
				.build();
		
		Veiculo v6 = Veiculo.Builder
				.newBuilder()
				.withId(null)
				.withPreco(126000.20)
				.withAno(2019)
				.withTipo(t5)
				.withCor(cor1)
				.withCombustivel(comb7)
				.withCambio(cb3)
				.withNumPortas(4)
				.withPlaca("GFE-3434")
				.withDescricao("Carro era utilizado para fazer fretes, nos correios. Carro faz um barulho na roda dianteira")
				.withKmRodado(82450L)
				//.withModelo(mod7)
				.withVersao(ver86)
				.withOpcionais(Arrays.asList(op17, op3, op23, op15, op19))
				.withAdicionais(Arrays.asList(ad2, ad5, ad3))
				.build();
		
		Veiculo v7 = Veiculo.Builder
				.newBuilder()
				.withId(null)
				.withPreco(226000.20)
				.withAno(2009)
				.withTipo(t1)
				.withCor(cor4)
				.withCombustivel(comb4)
				.withCambio(cb4)
				.withNumPortas(4)
				.withPlaca("HHE-2224")
				.withDescricao("Carro em perfeito estado, utilizado apenas por uma familia")
				.withKmRodado(10300L)
				//.withModelo(mod8)
				.withVersao(ver92)
				.withOpcionais(Arrays.asList(op1, op2, op9, op15, op17))
				.withAdicionais(Arrays.asList(ad1, ad5))
				.build();
		
		Veiculo v8 = Veiculo.Builder
				.newBuilder()
				.withId(null)
				.withPreco(23609.30)
				.withAno(2014)
				.withTipo(t2)
				.withCor(cor3)
				.withCombustivel(comb6)
				.withCambio(cb3)
				.withNumPortas(4)
				.withPlaca("KHK-7524")
				.withDescricao("Em ótimas condições")
				.withKmRodado(2000L)
				//.withModelo(mod9)
				.withVersao(ver139)
				.withOpcionais(Arrays.asList(op8, op2, op12, op20, op23))
				.withAdicionais(Arrays.asList(ad1, ad2, ad3))
				.build();
		
		Veiculo v9 = Veiculo.Builder
				.newBuilder()
				.withId(null)
				.withPreco(63604.64)
				.withAno(2017)
				.withTipo(t1)
				.withCor(cor2)
				.withCombustivel(comb1)
				.withCambio(cb1)
				.withNumPortas(4)
				.withPlaca("GSK-6424")
				.withDescricao("Carro precisa ser reparado algumas partes da lataria")
				.withKmRodado(89600L)
				//.withModelo(mod8)
				.withVersao(ver103)
				.withOpcionais(Arrays.asList(op23, op22, op7, op21, op17))
				.withAdicionais(Arrays.asList(ad1, ad2, ad3, ad4, ad5))
				.build();
		
		Veiculo v10 = Veiculo.Builder
				.newBuilder()
				.withId(null)
				.withPreco(90000.64)
				.withAno(2020)
				.withTipo(t1)
				.withCor(cor1)
				.withCombustivel(comb8)
				.withCambio(cb1)
				.withNumPortas(4)
				.withPlaca("LSK-9824")
				.withDescricao("Só comprar e andar")
				.withKmRodado(2000L)
				//.withModelo(mod10)
				.withVersao(ver128)
				.withOpcionais(Arrays.asList(op9, op10, op23, op11, op14))
				.withAdicionais(Arrays.asList(ad1, ad2))
				.build();
		
		Veiculo v11 = Veiculo.Builder
				.newBuilder()
				.withId(null)
				.withPreco(99000.64)
				.withAno(2020)
				.withTipo(t6)
				.withCor(cor4)
				.withCombustivel(comb1)
				.withCambio(cb2)
				.withNumPortas(4)
				.withPlaca("LGK-5824")
				.withDescricao("Muito bom!")
				.withKmRodado(9000L)
				//.withModelo(mod5)
				.withVersao(ver28)
				.withOpcionais(Arrays.asList(op1, op2, op6))
				.withAdicionais(Arrays.asList(ad2))
				.build();
		
		ver3.getVeiculos().addAll(Arrays.asList(v4));
		ver11.getVeiculos().addAll(Arrays.asList(v2));
		ver20.getVeiculos().addAll(Arrays.asList(v1));
		ver28.getVeiculos().addAll(Arrays.asList(v11));
		ver31.getVeiculos().addAll(Arrays.asList(v3));
		ver50.getVeiculos().addAll(Arrays.asList(v5));
		ver86.getVeiculos().addAll(Arrays.asList(v6));
		ver92.getVeiculos().addAll(Arrays.asList(v7));
		ver103.getVeiculos().addAll(Arrays.asList(v9));
		ver128.getVeiculos().addAll(Arrays.asList(v10));
		ver139.getVeiculos().addAll(Arrays.asList(v8));
		
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
		
//		mod1.getVeiculos().addAll(Arrays.asList(v4));
//		mod2.getVeiculos().addAll(Arrays.asList());
//		mod3.getVeiculos().addAll(Arrays.asList(v2));
//		mod4.getVeiculos().addAll(Arrays.asList(v5));
//		mod5.getVeiculos().addAll(Arrays.asList(v1, v11));
//		mod6.getVeiculos().addAll(Arrays.asList(v3));
//		mod7.getVeiculos().addAll(Arrays.asList(v6));
//		mod8.getVeiculos().addAll(Arrays.asList(v7, v9));
//		mod9.getVeiculos().addAll(Arrays.asList(v8));
//		mod9.getVeiculos().addAll(Arrays.asList(v10));
		
		cor1.getVeiculos().addAll(Arrays.asList(v1, v10, v6));
		cor2.getVeiculos().addAll(Arrays.asList(v2, v9));
		cor3.getVeiculos().addAll(Arrays.asList(v3, v8));
		cor4.getVeiculos().addAll(Arrays.asList(v4, v7, v11));
		cor5.getVeiculos().addAll(Arrays.asList(v5));
		
		cb1.getVeiculos().addAll(Arrays.asList(v1, v10));
		cb2.getVeiculos().addAll(Arrays.asList(v2, v4, v11));
		cb3.getVeiculos().addAll(Arrays.asList(v5, v6, v8));
		cb4.getVeiculos().addAll(Arrays.asList(v3, v7));
		
		comb1.getVeiculos().addAll(Arrays.asList(v1, v3, v9, v11));
		comb2.getVeiculos().addAll(Arrays.asList());
		comb3.getVeiculos().addAll(Arrays.asList(v5));
		comb4.getVeiculos().addAll(Arrays.asList(v7));
		comb5.getVeiculos().addAll(Arrays.asList());
		comb6.getVeiculos().addAll(Arrays.asList(v8));
		comb7.getVeiculos().addAll(Arrays.asList(v4, v6));
		comb8.getVeiculos().addAll(Arrays.asList(v2, v10));
		
		t1.getVeiculos().addAll(Arrays.asList(v2, v7, v9, v10));
		t2.getVeiculos().addAll(Arrays.asList(v3, v8));
		t3.getVeiculos().addAll(Arrays.asList(v1, v4));
		t4.getVeiculos().addAll(Arrays.asList(v5));
		t5.getVeiculos().addAll(Arrays.asList(v6));
		t6.getVeiculos().addAll(Arrays.asList(v11));
		
		//-----
		
		Colaborador c1 = new Colaborador(null, "Mauricio Pruss Duarte", "prussdev@gmail.com", pe.encode("123")); 
		c1.addPerfil(Perfil.ADMIN);
		
		Colaborador c2 = new Colaborador(null, "Carlos da Silva", "prussdesign@gmail.com", pe.encode("1234")); 
		Colaborador c3 = new Colaborador(null, "Julia Pruss Duarte", "julia.prussduarte@hotmail.com", pe.encode("12345")); 
		colaboradorRepository.saveAll(Arrays.asList(c1, c2, c3));
		
		marcaRepository.saveAll(Arrays.asList(m1, m2, m3, m4, m5, m6, m7));
		modeloRepository.saveAll(Arrays.asList(mod1, mod2, mod3, mod4, mod5, mod6, mod7, mod8, mod9, mod10));
		
		versaoRepository.saveAll(Arrays.asList(ver1, ver2, ver3, ver4 , ver5, ver6, ver7, ver8, ver9, ver10, ver11, ver12, ver13, ver14, ver15, ver16, ver17, ver17,
				ver18, ver19, ver20, ver21, ver22, ver23, ver24, ver25, ver26, ver27, ver28, ver29, ver30, ver31, ver32, ver34, ver35, ver37, ver38, ver39, ver40,
				ver41, ver42, ver43, ver44, ver45, ver46, ver47, ver48, ver49, ver50, ver51, ver52, ver53, ver54, ver55, ver56, ver57, ver58, ver59, ver60, ver61, ver62,
				ver63, ver64, ver65, ver66, ver67, ver68, ver69, ver70, ver71, ver71, ver72, ver73, ver74, ver75, ver76, ver77, ver78, ver79, ver80, ver81, ver82, ver82,
				ver83, ver84, ver85, ver86, ver87, ver88, ver89, ver90, ver91, ver91, ver92, ver93, ver94, ver95, ver96, ver97, ver98, ver99, ver100, ver100, ver101, ver102, 
				ver103, ver104, ver105, ver106, ver107, ver108, ver109, ver110, ver111, ver112, ver113, ver114, ver115, ver116, ver117, ver118, ver119, ver120, ver121, ver122,
				ver123, ver124, ver125, ver126, ver127, ver128, ver129, ver130, ver131, ver132, ver133, ver134, ver135, ver136, ver137, ver138, ver139));
		
		corRepository.saveAll(Arrays.asList(cor1, cor2, cor3, cor4, cor5));
		cambioRepository.saveAll((Arrays.asList(cb1, cb2, cb3, cb4)));
		combustivelRepository.saveAll(Arrays.asList(comb1, comb2, comb3, comb4, comb5, comb6, comb7, comb8, comb9));
		tipoRepository.saveAll(Arrays.asList(t1, t2, t3, t4, t5, t6));
		veiculoRepository.saveAll(Arrays.asList(v1, v2, v3, v4, v5, v6, v7, v8, v9, v10, v11));
		opcionalRepository.saveAll(Arrays.asList(op1, op2, op3, op4, op5, op6, op7, op8, op9, op10, op11, op12, op13, op14, op15, op16, op17, op18, op19, op20, op21, op22, op23));
		adicionalRepository.saveAll(Arrays.asList(ad1, ad2, ad3, ad4, ad5));
		
	}
}
