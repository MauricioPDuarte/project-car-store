package com.mauriciopd.carstore.domain.enums;

public enum PortasVeiculo {
	DOIS(1, "2P"),
	TRES(2, "3P"),
	QUATRO(3, "4P");

	private int cod;
	private String descricao;
	
	private PortasVeiculo(int cod, String descricao) {
		this.cod = cod;
		this.descricao = descricao;
	}

	public int getCod() {
		return cod;
	}

	public String getDescricao() {
		return descricao;
	}
	
	public static PortasVeiculo toEnum(Integer cod) {
		if(cod == null) {
			return null;
		}
		for(PortasVeiculo x : PortasVeiculo.values()) {
			if(cod.equals(x.getCod())) {
				return x;
			}
		}
		
		throw new IllegalArgumentException("Id inválido: " + cod);
	}
	
}
