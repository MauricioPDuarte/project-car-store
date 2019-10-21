package com.mauriciopd.carstore.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mauriciopd.carstore.domain.Opcional;
import com.mauriciopd.carstore.repository.OpcionalRepository;
import com.mauriciopd.carstore.services.exceptions.ObjectNotFoundException;

@Service
public class OpcionalService {

	@Autowired
	private OpcionalRepository repo;
	
	public Opcional findById(Integer id) {
		Optional<Opcional> opcional = repo.findById(id);
		return opcional.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
	}
	
	public Opcional insert(Opcional obj) {
		obj.setId(null);
		return repo.save(obj);
	}
	
	public List<Opcional> findAll() {
		return repo.findAll();
	}
	
	public Opcional atualizar(Opcional obj) {
		findById(obj.getId());
		return repo.save(obj);
	}
}
