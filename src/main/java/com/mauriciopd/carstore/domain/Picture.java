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

}
