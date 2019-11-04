package com.mauriciopd.carstore.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mauriciopd.carstore.domain.Combustivel;
import com.mauriciopd.carstore.repository.CombustivelRepository;
import com.mauriciopd.carstore.services.exceptions.ObjectNotFoundException;

@Service
public class CombustivelService {
	
	@Autowired
	private CombustivelRepository repo;
	
	public List<Combustivel> findAll() {
		return repo.findAll();
	}

	public Combustivel findById(Integer id) {
		Optional<Combustivel> cor = repo.findById(id);
		return cor.orElseThrow(
				() -> new ObjectNotFoundException("Objeto não encontrado"));
	}
}
