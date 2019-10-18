package com.mauriciopd.carstore.domain.enums;

public enum CambioVeiculo {
	MANUAL(1, "Manual"),
	AUTOMATICA(2, "Automática"),
	AUTOMATIZADA(3, "Automátizada"),
	CVT(3, "Cvt");
	
	private int cod;
	private String descricao;
	
	private CambioVeiculo(int cod, String descricao) {
		this.cod = cod;
		this.descricao = descricao;
	}

	public int getCod() {
		return cod;
	}

	public String getDescricao() {
		return descricao;
	}
	
	public static CambioVeiculo toEnum(Integer cod) {
		if(cod == null) {
			return null;
		}
		for(CambioVeiculo x : CambioVeiculo.values()) {
			if(cod.equals(x.getCod())) {
				return x;
			}
		}
		
		throw new IllegalArgumentException("Id inválido: " + cod);
	}
	
}
