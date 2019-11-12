package com.mauriciopd.carstore.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Modelo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String nome;
	
	@ManyToOne
	@JoinColumn(name = "marca_id")
	private Marca marca;
	
	@JsonIgnore
	@OneToMany(mappedBy = "modelo")
	private List<Versao> versoes = new ArrayList<>();

//	@JsonIgnore
//	@OneToMany(mappedBy = "modelo")
//	private List<Veiculo> veiculos = new ArrayList<>();

	public Modelo() {
	}

	public Modelo(Integer id, String nome, Marca marca) {
		super();
		this.id = id;
		this.nome = nome;
		this.marca = marca;
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

	public Marca getMarca() {
		return marca;
	}

	public void setMarca(Marca marca) {
		this.marca = marca;
	}

//	public List<Veiculo> getVeiculos() {
//		return veiculos;
//	}
//
//	public void setVeiculos(List<Veiculo> veiculos) {
//		this.veiculos = veiculos;
//	}

	public List<Versao> getVersoes() {
		return versoes;
	}

	public void setVersoes(List<Versao> versoes) {
		this.versoes = versoes;
	}

}
