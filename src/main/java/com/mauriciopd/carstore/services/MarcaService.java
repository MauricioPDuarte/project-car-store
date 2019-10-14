package com.mauriciopd.carstore.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mauriciopd.carstore.domain.Marca;
import com.mauriciopd.carstore.repository.MarcaRepository;

@Service
public class MarcaService {
	
	@Autowired
	private MarcaRepository repo;
	
	public Marca findById(Integer id) {
		Optional<Marca> marca = repo.findById(id);
		return marca.orElseThrow(() -> new RuntimeException("Objeto não encontrado: " + id));
	}

	public List<Marca> findAll() {
		return repo.findAll();
	}
}
