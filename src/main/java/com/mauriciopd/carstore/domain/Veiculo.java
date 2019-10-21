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
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.mauriciopd.carstore.domain.enums.CambioVeiculo;
import com.mauriciopd.carstore.domain.enums.CombustivelVeiculo;
import com.mauriciopd.carstore.domain.enums.CorVeiculo;
import com.mauriciopd.carstore.domain.enums.PortasVeiculo;
import com.mauriciopd.carstore.domain.enums.TipoVeiculo;

@Entity
public class Veiculo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private double preco;
	private Integer ano;
	private Integer tipo;
	private Integer cor;
	private Integer combustivel;
	private Integer cambio;
	private Integer numPortas;
	private String placa;
	private String descricao;
	private Long kmRodado;
	private boolean ipvaPago;
	private boolean blindado;
	private boolean troca;
	private boolean garantiaFabrica;
	private boolean unicoDono;
	
	@ManyToMany(mappedBy = "veiculos")
	private List<Opcional> opcionais = new ArrayList<>();

	@ManyToOne
	@JoinColumn(name = "modelo_id")
	private Modelo modelo;

	@OneToMany(mappedBy = "veiculo", cascade = CascadeType.ALL)
	private List<Picture> pictures = new ArrayList<>();

	public Veiculo() {
	}
	
	public static final class Builder {
		private Integer id;
		private double preco;
		private Integer ano;
		private Integer tipo;
		private Integer cor;
		private Integer combustivel;
		private Integer cambio;
		private Integer numPortas;
		private String placa;
		private String descricao;
		private Long kmRodado;
		private boolean ipvaPago;
		private boolean blindado;
		private boolean troca;
		private boolean garantiaFabrica;
		private boolean unicoDono;
		private Modelo modelo;
		private List<Opcional> opcionais = new ArrayList<>();
		
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
		
		public Builder withTipo(Integer tipo) {
			this.tipo = tipo;
			return this;
		}
		
		public Builder withCor(Integer cor) {
			this.cor = cor;
			return this;
		}
		
		public Builder withCombustivel(Integer combustivel) {
			this.combustivel = combustivel;
			return this;
		}
		
		public Builder withCambio(Integer cambio) {
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
		
		public Builder withIpvaPago(boolean ipvaPago) {
			this.ipvaPago = ipvaPago;
			return this;
		}
		
		public Builder withBlindado(boolean blindado) {
			this.blindado = blindado;
			return this;
		}
		
		public Builder withTroca(boolean troca) {
			this.troca = troca;
			return this;
		}
		
		public Builder withGarantiaFabrica(boolean garantiaFabrica) {
			this.garantiaFabrica = garantiaFabrica;
			return this;
		}
		
		public Builder withUnicoDono(boolean unicoDono) {
			this.unicoDono = unicoDono;
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
			veiculo.setIpvaPago(ipvaPago);
			veiculo.setBlindado(blindado);
			veiculo.setTroca(troca);
			veiculo.setGarantiaFabrica(garantiaFabrica);
			veiculo.setUnicoDono(unicoDono);
			veiculo.setModelo(modelo);
			veiculo.setOpcionais(opcionais);
			
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

	public TipoVeiculo getTipo() {
		return TipoVeiculo.toEnum(tipo);
	}
	
	public void setTipo(Integer tipo) {
		this.tipo = tipo;
	}

	public CorVeiculo getCor() {
		return CorVeiculo.toEnum(cor);
	}
	
	public void setCor(Integer cor) {
		this.cor = cor;
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

	public CombustivelVeiculo getCombustivel() {
		return CombustivelVeiculo.toEnum(combustivel);
	}
	
	public void setCombustivel(Integer combustivel) {
		this.combustivel = combustivel;
	}

	public CambioVeiculo getCambio() {
		return CambioVeiculo.toEnum(cambio);
	}
	
	public void setCambio(Integer cambio) {
		this.cambio = cambio;
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

	public boolean isBlindado() {
		return blindado;
	}

	public void setBlindado(boolean blindado) {
		this.blindado = blindado;
	}

	public boolean isTroca() {
		return troca;
	}

	public void setTroca(boolean troca) {
		this.troca = troca;
	}

	public boolean isIpvaPago() {
		return ipvaPago;
	}

	public void setIpvaPago(boolean ipvaPago) {
		this.ipvaPago = ipvaPago;
	}

	public Long getKmRodado() {
		return kmRodado;
	}

	public void setKmRodado(Long kmRodado) {
		this.kmRodado = kmRodado;
	}

	public boolean isGarantiaFabrica() {
		return garantiaFabrica;
	}

	public void setGarantiaFabrica(boolean garantiaFabrica) {
		this.garantiaFabrica = garantiaFabrica;
	}

	public boolean isUnicoDono() {
		return unicoDono;
	}

	public void setUnicoDono(boolean unicoDono) {
		this.unicoDono = unicoDono;
	}
	
	public List<Opcional> getOpcionais() {
		return opcionais;
	}

	public void setOpcionais(List<Opcional> opcionais) {
		this.opcionais = opcionais;
	}

	public PortasVeiculo getNumPortas() {
		return PortasVeiculo.toEnum(numPortas);
	}

	public void setNumPortas(Integer numPortas) {
		this.numPortas = numPortas;
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
