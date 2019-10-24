package com.mauriciopd.carstore.domain.enums;

public enum CorVeiculo {
	PRETO(1, "Preto"),
	BRANCO(2, "Branco"),
	VERMELHO(3, "Vermelho"),
	AZUL(4, "Azul"),
	AMARELO(5, "Amarelo"),
	BEGE(6, "Bege"),
	ROSA(7, "Rosa"),
	PRATA(8, "Prata");
	
	
	private int cod;
	private String descricao;
	
	private CorVeiculo(int cod, String descricao) {
		this.cod = cod;
		this.descricao = descricao;
	}

	public int getCod() {
		return cod;
	}

	public String getDescricao() {
		return descricao;
	}
	
	public static CorVeiculo toEnum(Integer cod) {
		if(cod == null) {
			return null;
		}
		for(CorVeiculo x : CorVeiculo.values()) {
			if(cod.equals(x.getCod())) {
				return x;
			}
		}
		
		throw new IllegalArgumentException("Id inválido: " + cod);
	}
	
}
