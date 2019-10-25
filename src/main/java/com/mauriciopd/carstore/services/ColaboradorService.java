package com.mauriciopd.carstore.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.mauriciopd.carstore.domain.Colaborador;
import com.mauriciopd.carstore.repository.ColaboradorRepository;
import com.mauriciopd.carstore.services.exceptions.ObjectNotFoundException;

@Service
public class ColaboradorService {

	@Autowired
	private ColaboradorRepository repo;
	
	@Autowired
	private BCryptPasswordEncoder pe;

	public List<Colaborador> findAll() {
		return repo.findAll();
	}
	
	public Colaborador findById(Integer id) {
		Optional<Colaborador> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado: " + id));
	}

	public Colaborador insert(Colaborador obj) {
		obj.setId(null);
		obj.setSenha(pe.encode(obj.getSenha()));
		return repo.save(obj);
	}
	
}
