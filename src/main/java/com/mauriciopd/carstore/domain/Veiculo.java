package com.mauriciopd.carstore.domain;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.mauriciopd.carstore.domain.enums.CorVeiculo;
import com.mauriciopd.carstore.domain.enums.TipoVeiculo;

@Entity
public class Veiculo implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private double preco;
	private int ano;
	private Integer tipo;
	private Integer cor;
	
	public Veiculo() {
	}

	public Veiculo(Integer id, double preco, int ano, TipoVeiculo tipo, CorVeiculo cor) {
		super();
		this.id = id;
		this.preco = preco;
		this.ano = ano;
		this.tipo = (tipo == null) ? null : tipo.getCod();
		this.cor = (cor == null) ? null : cor.getCod();
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

	public TipoVeiculo getTipo() {
		return TipoVeiculo.toEnum(tipo);
	}

	public void setTipo(TipoVeiculo tipo) {
		this.tipo = tipo.getCod();
	}

	public CorVeiculo getCor() {
		return CorVeiculo.toEnum(cor);
	}

	public void setCor(CorVeiculo cor) {
		this.cor = cor.getCod();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Veiculo other = (Veiculo) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
