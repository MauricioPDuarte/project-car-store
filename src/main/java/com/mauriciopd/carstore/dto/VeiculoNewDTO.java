package com.mauriciopd.carstore.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;

import com.mauriciopd.carstore.domain.enums.OpcionaisVeiculo;

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
	private Integer modeloId;
	
	@NotEmpty(message = "Preenchimento obrigatório")
	private String placa;
	
	private String descricao;
	
	private Long kmRodado;
	
	private boolean ipvaPago;
	
	private boolean blindado;
	
	private boolean troca;
	
	private boolean garantiaFabrica;
	
	private boolean unicoDono;
	
	private List<OpcionaisVeiculo> opcionais = new ArrayList<>();

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

	public List<OpcionaisVeiculo> getOpcionais() {
		return opcionais;
	}

	public void setOpcionais(List<OpcionaisVeiculo> opcionais) {
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

	public boolean isIpvaPago() {
		return ipvaPago;
	}

	public void setIpvaPago(boolean ipvaPago) {
		this.ipvaPago = ipvaPago;
	}

	public boolean isBlindado() {
		return blindado;
	}

	public void setBlindado(boolean blindado) {
		this.blindado = blindado;
	}

	public boolean isTroca() {
		return troca;
	}

	public void setTroca(boolean troca) {
		this.troca = troca;
	}

	public boolean isGarantiaFabrica() {
		return garantiaFabrica;
	}

	public void setGarantiaFabrica(boolean garantiaFabrica) {
		this.garantiaFabrica = garantiaFabrica;
	}

	public boolean isUnicoDono() {
		return unicoDono;
	}

	public void setUnicoDono(boolean unicoDono) {
		this.unicoDono = unicoDono;
	}

}
