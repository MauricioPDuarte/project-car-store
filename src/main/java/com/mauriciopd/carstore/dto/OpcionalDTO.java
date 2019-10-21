package com.mauriciopd.carstore.dto;

import java.io.Serializable;

import com.mauriciopd.carstore.domain.Opcional;

public class OpcionalDTO implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private String nome;
	
	public OpcionalDTO() {
	}
	
	public OpcionalDTO(Opcional obj) {
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
