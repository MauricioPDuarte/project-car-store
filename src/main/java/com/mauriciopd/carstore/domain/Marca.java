package com.mauriciopd.carstore.domain;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Marca implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	private Integer id;
	private String nome;
	
	public Marca() {
	}

	public Marca(Integer id, String nome) {
		super();
		this.id = id;
		this.nome = nome;
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
