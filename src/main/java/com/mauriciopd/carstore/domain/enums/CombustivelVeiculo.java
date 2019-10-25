package com.mauriciopd.carstore.domain.enums;

import com.fasterxml.jackson.annotation.JsonFormat;

@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum CombustivelVeiculo {
	GASOLINA(1, "Gasolina"),
	DIESEL(2, "Diesel"),
	ALCOOL(3, "Alcool"),
	GASOLINAEALCOOL(4, "Gasolina/Alcool"),
	ELETRICO(5, "Elético"),
	GASOLINAEELETRICO(6, "Gasolina/Elétrico"),
	GAS(6, "Gás"),
	GASOLINAEGAS(7, "Gasolina/Gás natural"),
	GASOLINAALCOOLEGAS(8, "Gasolina, alcool e gás natural");
	
	private int cod;
	private String descricao;
	
	private CombustivelVeiculo(int cod, String descricao) {
		this.cod = cod;
		this.descricao = descricao;
	}

	public int getCod() {
		return cod;
	}

	public String getDescricao() {
		return descricao;
	}
	
	public static CombustivelVeiculo toEnum(Integer cod) {
		if(cod == null) {
			return null;
		}
		for(CombustivelVeiculo x : CombustivelVeiculo.values()) {
			if(cod.equals(x.getCod())) {
				return x;
			}
		}
		
		throw new IllegalArgumentException("Id inválido: " + cod);
	}
	
}
