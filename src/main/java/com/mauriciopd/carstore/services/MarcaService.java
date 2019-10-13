package com.mauriciopd.carstore.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mauriciopd.carstore.domain.Marca;
import com.mauriciopd.carstore.repository.MarcaRepository;

@Service
public class MarcaService {
	
	@Autowired
	private MarcaRepository repo;

	public List<Marca> findAll() {
		return repo.findAll();
	}
}
