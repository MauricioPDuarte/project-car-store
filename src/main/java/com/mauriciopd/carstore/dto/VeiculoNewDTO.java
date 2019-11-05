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
	private Integer tipoId;

	@Min(value = 1, message = "Preenchimento obrigatório")
	private Integer corId;

	@Min(value = 1, message = "Preenchimento obrigatório")
	private Integer combustivelId;

	@Min(value = 1, message = "Preenchimento obrigatório")
	private Integer cambioId;

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

	public Integer getTipoId() {
		return tipoId;
	}

	public void setTipoId(Integer tipoId) {
		this.tipoId = tipoId;
	}

	public Integer getCorId() {
		return corId;
	}

	public void setCorId(Integer corId) {
		this.corId = corId;
	}

	public Integer getCombustivelId() {
		return combustivelId;
	}

	public void setCombustivelId(Integer combustivelId) {
		this.combustivelId = combustivelId;
	}

	public Integer getCambioId() {
		return cambioId;
	}

	public void setCambioId(Integer cambioId) {
		this.cambioId = cambioId;
	}
	
	

}
