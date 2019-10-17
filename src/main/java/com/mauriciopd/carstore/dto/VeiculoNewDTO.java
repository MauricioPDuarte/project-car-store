package com.mauriciopd.carstore.dto;

import java.io.Serializable;

import javax.validation.constraints.Min;

public class VeiculoNewDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private Integer id;
	
	@Min(value = 1, message = "Preenchimento obrigatório")
	private double preco;
	
	@Min(value = 1, message = "Preenchimento obrigatório")
	private int ano;
	
	@Min(value = 1, message = "Preenchimento obrigatório")
	private Integer tipo;
	
	@Min(value = 1, message = "Preenchimento obrigatório")
	private Integer cor;

	@Min(value = 1, message = "Preenchimento obrigatório")
	private Integer modeloId;

	public VeiculoNewDTO() {
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public double getPreco() {
		return preco;
	}

	public void setPreco(double preco) {
		this.preco = preco;
	}

	public int getAno() {
		return ano;
	}

	public void setAno(int ano) {
		this.ano = ano;
	}

	public Integer getTipo() {
		return tipo;
	}

	public void setTipo(Integer tipo) {
		this.tipo = tipo;
	}

	public Integer getCor() {
		return cor;
	}

	public void setCor(Integer cor) {
		this.cor = cor;
	}

	public Integer getModeloId() {
		return modeloId;
	}

	public void setModeloId(Integer modeloId) {
		this.modeloId = modeloId;
	}

}
