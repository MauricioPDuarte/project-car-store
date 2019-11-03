package com.mauriciopd.carstore.dto;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import com.mauriciopd.carstore.domain.Colaborador;
import com.mauriciopd.carstore.domain.enums.Perfil;

public class ColaboradorDTO implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private String nome;
	private Set<Perfil> perfis = new HashSet<>();
	
	public ColaboradorDTO() {
	}

	public ColaboradorDTO(Colaborador obj) {
		this.id = obj.getId();
		this.nome = obj.getNome();
		this.perfis = obj.getPerfis();
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

	public Set<Perfil> getPerfis() {
		return perfis;
	}

	public void setPerfis(Set<Perfil> perfis) {
		this.perfis = perfis;
	}

}
