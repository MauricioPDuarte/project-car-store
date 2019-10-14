package com.mauriciopd.carstore.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mauriciopd.carstore.domain.Veiculo;
import com.mauriciopd.carstore.repository.VeiculoRepository;

@Service
public class VeiculoService {
	
	@Autowired
	private VeiculoRepository repo;

	public List<Veiculo> findAll() {
		return repo.findAll();
	}
	
	public List<Veiculo> findByModelo(Integer modeloId) {
		return repo.findModelo(modeloId);
	}
	
	public List<Veiculo> findByMarca(Integer marcaId) {
		return repo.findMarca(marcaId);
	}
	
}
