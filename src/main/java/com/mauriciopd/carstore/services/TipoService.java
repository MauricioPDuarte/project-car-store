package com.mauriciopd.carstore.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mauriciopd.carstore.domain.Tipo;
import com.mauriciopd.carstore.repository.TipoRepository;
import com.mauriciopd.carstore.services.exceptions.ObjectNotFoundException;

@Service
public class TipoService {
	
	@Autowired
	private TipoRepository repo;
	
	public List<Tipo> findAll() {
		return repo.findAll();
	}

	public Tipo findById(Integer id) {
		Optional<Tipo> tipo = repo.findById(id);
		return tipo.orElseThrow(
				() -> new ObjectNotFoundException("Objeto não encontrado"));
	}
}
