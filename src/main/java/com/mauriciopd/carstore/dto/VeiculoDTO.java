package com.mauriciopd.carstore.dto;

import java.io.Serializable;
import java.util.List;

import com.mauriciopd.carstore.domain.Cambio;
import com.mauriciopd.carstore.domain.Combustivel;
import com.mauriciopd.carstore.domain.Cor;
import com.mauriciopd.carstore.domain.Modelo;
import com.mauriciopd.carstore.domain.Opcional;
import com.mauriciopd.carstore.domain.Picture;
import com.mauriciopd.carstore.domain.Tipo;
import com.mauriciopd.carstore.domain.Veiculo;
import com.mauriciopd.carstore.domain.Versao;

public class VeiculoDTO implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private double preco;
	private int ano;
	private Tipo tipo;
	//private Modelo modelo;
	//private Picture picture;
	private Long kmRodado;
	private Cambio cambio;
	private List<Picture> pictures;
	private List<Opcional> opcionais;
	private Versao versao;
	private Combustivel combustivel;
	
	public VeiculoDTO() {
	}

	public VeiculoDTO(Veiculo obj) {
		this.id = obj.getId();
		this.preco = obj.getPreco();
		this.ano = obj.getAno();
		this.tipo = obj.getTipo();
		this.kmRodado = obj.getKmRodado();
		this.cambio = obj.getCambio();
		//this.modelo = obj.getModelo();
		this.pictures = obj.getPictures();
		this.opcionais = obj.getOpcionais();
		this.versao = obj.getVersao();
		this.combustivel = obj.getCombustivel();
//		for(Picture picture : obj.getPictures()) {
//			if(picture.isThumbnail()) {
//				this.picture = picture;
//				return;
//			}
//		}
		
	}
	
	public Combustivel getCombustivel() {
		return combustivel;
	}

	public void setCombustivel(Combustivel combustivel) {
		this.combustivel = combustivel;
	}

	public List<Opcional> getOpcionais() {
		return opcionais;
	}

	public void setOpcionais(List<Opcional> opcionais) {
		this.opcionais = opcionais;
	}

	public List<Picture> getPictures() {
		return pictures;
	}

	public void setPictures(List<Picture> pictures) {
		this.pictures = pictures;
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

	public Tipo getTipo() {
		return tipo;
	}

	public void setTipo(Tipo tipo) {
		this.tipo = tipo;
	}

//	public Modelo getModelo() {
//		return modelo;
//	}
//	
//	public void setModelo(Modelo modelo) {
//		this.modelo = modelo;
//	}
	
	public Versao getVersao() {
		return versao;
	}

	public void setVersao(Versao versao) {
		this.versao = versao;
	}
	
//	public Picture getPicture() {
//		return picture;
//	}
//	
//	public void setPicture(Picture picture) {
//		this.picture = picture;
//	}

	public Long getKmRodado() {
		return kmRodado;
	}

	public void setKmRodado(Long kmRodado) {
		this.kmRodado = kmRodado;
	}

	public Cambio getCambio() {
		return cambio;
	}

	public void setCambio(Cambio cambio) {
		this.cambio = cambio;
	}
	
	
}
