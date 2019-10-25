package com.mauriciopd.carstore.domain.enums;

import com.fasterxml.jackson.annotation.JsonFormat;

@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum TipoVeiculo {
	HATCHBACK(1, "Hatchback"),
	SEDAN(2, "Sedan"),
	MINIVAN(3, "Minivan"),
	PICAPE(4, "Picape"),
	SUV(5, "SUV"),
	ESPORTIVO(6, "Esportivo");
	
	private int cod;
	private String descricao;
	
	private TipoVeiculo(int cod, String descricao) {
		this.cod = cod;
		this.descricao = descricao;
	}

	public int getCod() {
		return cod;
	}

	public String getDescricao() {
		return descricao;
	}
	
	public static TipoVeiculo toEnum(Integer cod) {
		if(cod == null) {
			return null;
		}
		for(TipoVeiculo x : TipoVeiculo.values()) {
			if(cod.equals(x.getCod())) {
				return x;
			}
		}
		
		throw new IllegalArgumentException("Id inválido: " + cod);
	}
	
}
