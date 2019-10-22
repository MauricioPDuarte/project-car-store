package com.mauriciopd.carstore.dto;

import java.io.Serializable;

import com.mauriciopd.carstore.domain.Modelo;
import com.mauriciopd.carstore.domain.Picture;
import com.mauriciopd.carstore.domain.Veiculo;

public class VeiculoDTO implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private double preco;
	private int ano;
	private String tipo;
	private String cor;
	private Modelo modelo;
	private Picture picture;
	
	public VeiculoDTO() {
	}

	public VeiculoDTO(Veiculo obj) {
		this.id = obj.getId();
		this.preco = obj.getPreco();
		this.ano = obj.getAno();
		this.tipo = obj.getTipo();
		this.cor = obj.getCor();
		
		this.modelo = obj.getModelo();
		for(Picture picture : obj.getPictures()) {
			if(picture.isThumbnail()) {
				this.picture = picture;
				return;
			}
		}
		
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

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public void setCor(String cor) {
		this.cor = cor;
	}
	
	public String getCor() {
		return cor;
	}

	public Modelo getModelo() {
		return modelo;
	}
	public void setModelo(Modelo modelo) {
		this.modelo = modelo;
	}
	public Picture getPicture() {
		return picture;
	}
	public void setPicture(Picture picture) {
		this.picture = picture;
	}

	
}
