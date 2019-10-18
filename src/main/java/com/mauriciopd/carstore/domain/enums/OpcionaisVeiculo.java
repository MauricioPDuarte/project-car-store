package com.mauriciopd.carstore.domain.enums;

public enum OpcionaisVeiculo {

	AIRBAG(1, "Airbag"),
	ALARME(2, "Alarme"),
	ARQUENTE(3, "Ar Quente"),
	BANCOCOMREGULAGEMDEALTURA(4, "Banco com regulagem de altura"),
	CDPLAYER(5, "CD Player"),
	RADIO(6, "Rádio"),
	COMPUTADORDEBORDO(7, "Computador de bordo"),
	CONTROLEDETRACAO(8, "Controle de tração"),
	DESEMBACADORTRASEIRO(9, "Desembaçador traseiro"),
	ARCONDICIONADO(10, "Ar condicionado"),
	ENCOSTODECABECATRASEIRO(11, "Encosto de cabeça traseiro"),
	FREIOABS(12, "Freio ABS"),
	CONTROLEAUTOMATICODEVELOCIDADE(13, "Controle automático de velocidade"),
	RETROVISORESELETRICOS(14, "Retrovisores elétricos"),
	RODASDELIGALEVE(15, "Rodas de liga leve"),
	TRAVASELETRICAS(16, "Travas elétricas"),
	VIDROSELETRICOS(17, "Vidros elétricos"),
	VOLANTECOMREGULAGEMDEALTURA(18, "Volante com regulagem de altura"),
	BANCOSDECOURO(19, "Bancos de couro"),
	DIRECAOHIDRAULICA(20, "Direção hidraulica"),
	GPS(21, "GPS"),
	SENSORDECHIVA(22, "Sensor de chuva"),
	TETOSOLAR(23, "Teto solar");
	
	private int cod;
	private String descricao;
	
	private OpcionaisVeiculo(int cod, String descricao) {
		this.cod = cod;
		this.descricao = descricao;
	}

	public int getCod() {
		return cod;
	}

	public String getDescricao() {
		return descricao;
	}
	
	public static OpcionaisVeiculo toEnum(Integer cod) {
		if(cod == null) {
			return null;
		}
		for(OpcionaisVeiculo x : OpcionaisVeiculo.values()) {
			if(cod.equals(x.getCod())) {
				return x;
			}
		}
		
		throw new IllegalArgumentException("Id inválido: " + cod);
	}
	
}
