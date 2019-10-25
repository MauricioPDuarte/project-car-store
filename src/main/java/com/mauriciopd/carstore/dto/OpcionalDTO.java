package com.mauriciopd.carstore.dto;

import java.io.Serializable;

import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

import com.mauriciopd.carstore.domain.Opcional;

public class OpcionalDTO implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	
	@NotEmpty(message = "Preenchimento obrigatório")
	@Length(min = 3, max = 100, message = "O tamanho deve ser entre 3 e 100 caracteres")
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
