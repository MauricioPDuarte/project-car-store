package com.mauriciopd.carstore.dto;

import java.io.Serializable;

import com.mauriciopd.carstore.domain.Tipo;

public class TipoDTO implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private String nome;
	
	public TipoDTO() {
	}
	
	public TipoDTO(Tipo obj) {
		this.id = obj.getId();
		this.nome = obj.getNome();
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	

}
