package com.mauriciopd.carstore.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;

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
	private Integer combustivel;

	@Min(value = 1, message = "Preenchimento obrigatório")
	private Integer cambio;

	@Min(value = 1, message = "Preenchimento obrigatório")
	private Integer numPortas;

	@Min(value = 1, message = "Preenchimento obrigatório")
	private Integer modeloId;

	@NotEmpty(message = "Preenchimento obrigatório")
	private String placa;

	private String descricao;

	private Long kmRodado;

	private List<Integer> opcionais = new ArrayList<>();
	
	private List<Integer> adicionais = new ArrayList<>();

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

	public List<Integer> getOpcionais() {
		return opcionais;
	}

	public void setOpcionais(List<Integer> opcionais) {
		this.opcionais = opcionais;
	}

	public Integer getCombustivel() {
		return combustivel;
	}

	public void setCombustivel(Integer combustivel) {
		this.combustivel = combustivel;
	}

	public Integer getCambio() {
		return cambio;
	}

	public void setCambio(Integer cambio) {
		this.cambio = cambio;
	}

	public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Long getKmRodado() {
		return kmRodado;
	}

	public void setKmRodado(Long kmRodado) {
		this.kmRodado = kmRodado;
	}

	public Integer getNumPortas() {
		return numPortas;
	}

	public void setNumPortas(Integer numPortas) {
		this.numPortas = numPortas;
	}

	public List<Integer> getAdicionais() {
		return adicionais;
	}

	public void setAdicionais(List<Integer> adicionais) {
		this.adicionais = adicionais;
	}

}
