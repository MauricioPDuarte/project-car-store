package com.mauriciopd.carstore.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mauriciopd.carstore.domain.Modelo;
import com.mauriciopd.carstore.repository.ModeloRepository;

@Service
public class ModeloService {
	
	@Autowired
	private ModeloRepository repo;

	public List<Modelo> findByMarca(Integer marcaId) {
		return repo.findMarca(marcaId);
	}
}
