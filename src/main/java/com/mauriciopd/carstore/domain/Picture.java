package com.mauriciopd.carstore.domain;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Picture implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String fileName;
	private boolean thumbnail;

	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "veiculo_id")
	private Veiculo veiculo;

	public Picture() {
	}

	public Picture(Integer id, String fileName, boolean thumbnail, Veiculo veiculo) {
		super();
		this.id = id;
		this.fileName = fileName;
		this.thumbnail = thumbnail;
		this.veiculo = veiculo;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileDownloadUri(String fileDownloadUri) {
		this.fileName = fileDownloadUri;
	}

	public boolean isThumbnail() {
		return thumbnail;
	}

	public void setThumbnail(boolean thumbnail) {
		this.thumbnail = thumbnail;
	}

	public Veiculo getVeiculo() {
		return veiculo;
	}

	public void setVeiculo(Veiculo veiculo) {
		this.veiculo = veiculo;
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
		Picture other = (Picture) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
