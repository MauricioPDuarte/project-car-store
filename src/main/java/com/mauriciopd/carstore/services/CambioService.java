package com.mauriciopd.carstore.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mauriciopd.carstore.domain.Cambio;
import com.mauriciopd.carstore.repository.CambioRepository;
import com.mauriciopd.carstore.services.exceptions.ObjectNotFoundException;

@Service
public class CambioService {
	
	@Autowired
	private CambioRepository repo;
	
	public List<Cambio> findAll() {
		return repo.findAll();
	}

	public Cambio findById(Integer id) {
		Optional<Cambio> cambio = repo.findById(id);
		return cambio.orElseThrow(
				() -> new ObjectNotFoundException("Objeto não encontrado"));
	}
}
