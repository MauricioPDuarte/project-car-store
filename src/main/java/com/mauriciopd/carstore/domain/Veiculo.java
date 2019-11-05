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
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Veiculo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private double preco;
	private Integer ano;
	private Integer numPortas;
	private String placa;
	private String descricao;
	private Long kmRodado;
	
	@ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.REFRESH, CascadeType.MERGE})
	@JoinTable(name = "OPCIONAL_VEICULO", joinColumns = @JoinColumn(name = "veiculo_id"), inverseJoinColumns = @JoinColumn(name = "opcional_id"))
	private List<Opcional> opcionais = new ArrayList<>();
	
	@ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.REFRESH, CascadeType.MERGE})
	@JoinTable(name = "ADICIONAL_VEICULO", joinColumns = @JoinColumn(name = "veiculo_id"), inverseJoinColumns = @JoinColumn(name = "adicional_id"))
	private List<Adicional> adicionais = new ArrayList<>();
	
	@ManyToOne
	private Cor cor;
	
	@ManyToOne
	private Cambio cambio;
	
	@ManyToOne
	private Combustivel combustivel;
	
	@ManyToOne
	private Tipo tipo;

	@ManyToOne
	@JoinColumn(name = "modelo_id")
	private Modelo modelo;

	@OneToMany(mappedBy = "veiculo", cascade = CascadeType.ALL)
	private List<Picture> pictures = new ArrayList<>();

	public Veiculo() {
	}
	
	public Veiculo(Integer id) {
		super();
		this.id = id;
	}
	public static final class Builder {
		private Integer id;
		private double preco;
		private Integer ano;
		private Tipo tipo;
		private Cor cor;
		private Combustivel combustivel;
		private Cambio cambio;
		private Integer numPortas;
		private String placa;
		private String descricao;
		private Long kmRodado;
		private Modelo modelo;
		private List<Opcional> opcionais = new ArrayList<>();
		private List<Adicional> adicionais = new ArrayList<>();
		
		private Builder() {
		}
		
		public static Builder newBuilder() {
			return new Builder();
		}
		
		public Builder withId(Integer id) {
			this.id = id;
			return this;
		}
		public Builder withPreco(double preco) {
			this.preco = preco;
			return this;
		}
		
		public Builder withAno(Integer ano) {
			this.ano = ano;
			return this;
		}
		
		public Builder withTipo(Tipo tipo) {
			this.tipo = tipo;
			return this;
		}
		
		public Builder withCor(Cor cor) {
			this.cor = cor;
			return this;
		}
		
		public Builder withCombustivel(Combustivel combustivel) {
			this.combustivel = combustivel;
			return this;
		}
		
		public Builder withCambio(Cambio cambio) {
			this.cambio = cambio;
			return this;
		}
		
		public Builder withNumPortas(Integer numPortas) {
			this.numPortas = numPortas;
			return this;
		}
		
		public Builder withPlaca(String placa) {
			this.placa = placa;
			return this;
		}
		
		public Builder withDescricao(String descricao) {
			this.descricao = descricao;
			return this;
		}
		
		public Builder withKmRodado(Long kmRodado) {
			this.kmRodado = kmRodado;
			return this;
		}
		
		public Builder withModelo(Modelo modelo) {
			this.modelo = modelo;
			return this;
		}
		
		public Builder withOpcionais(List<Opcional> opcionais) {
			this.opcionais = opcionais;
			return this;
		}
		
		public Builder withAdicionais(List<Adicional> adicionais) {
			this.adicionais = adicionais;
			return this;
		}

		public Veiculo build() {
			Veiculo veiculo = new Veiculo();
			veiculo.setId(id);
			veiculo.setAno(ano);
			veiculo.setPreco(preco);
			veiculo.setTipo(tipo);
			veiculo.setCor(cor);
			veiculo.setCombustivel(combustivel);
			veiculo.setCambio(cambio);
			veiculo.setNumPortas(numPortas);
			veiculo.setPlaca(placa);
			veiculo.setDescricao(descricao);
			veiculo.setKmRodado(kmRodado);
			veiculo.setModelo(modelo);
			veiculo.setOpcionais(opcionais);
			veiculo.setAdicionais(adicionais);
			return veiculo;
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
	
	public Modelo getModelo() {
		return modelo;
	}

	public void setModelo(Modelo modelo) {
		this.modelo = modelo;
	}

	public List<Picture> getPictures() {
		return pictures;
	}

	public void setPictures(List<Picture> pictures) {
		this.pictures = pictures;
	}

	public Combustivel getCombustivel() {
		return combustivel;
	}

	public void setCombustivel(Combustivel combustivel) {
		this.combustivel = combustivel;
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
	
	public List<Opcional> getOpcionais() {
		return opcionais;
	}

	public void setOpcionais(List<Opcional> opcionais) {
		this.opcionais = opcionais;
	}

	public Integer getNumPortas() {
		return numPortas;
	}

	public void setNumPortas(Integer numPortas) {
		this.numPortas = numPortas;
	}

	public List<Adicional> getAdicionais() {
		return adicionais;
	}

	public void setAdicionais(List<Adicional> adicionais) {
		this.adicionais = adicionais;
	}

	public void setCor(Cor cor) {
		this.cor = cor;
	}
	
	public Cor getCor() {
		return cor;
	}

	public Cambio getCambio() {
		return cambio;
	}

	public void setCambio(Cambio cambio) {
		this.cambio = cambio;
	}

	public Tipo getTipo() {
		return tipo;
	}

	public void setTipo(Tipo tipo) {
		this.tipo = tipo;
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
