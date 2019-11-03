package com.mauriciopd.carstore.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mauriciopd.carstore.domain.Cor;
import com.mauriciopd.carstore.repository.CorRepository;
import com.mauriciopd.carstore.services.exceptions.ObjectNotFoundException;

@Service
public class CorService {
	
	@Autowired
	private CorRepository repo;
	
	public List<Cor> findAll() {
		return repo.findAll();
	}

	public Cor findById(Integer id) {
		Optional<Cor> cor = repo.findById(id);
		return cor.orElseThrow(
				() -> new ObjectNotFoundException("Objeto não encontrado"));
	}
}
