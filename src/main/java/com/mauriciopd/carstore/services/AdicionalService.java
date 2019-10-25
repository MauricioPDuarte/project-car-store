package com.mauriciopd.carstore.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mauriciopd.carstore.domain.Adicional;
import com.mauriciopd.carstore.dto.AdicionalDTO;
import com.mauriciopd.carstore.repository.AdicionalRepository;
import com.mauriciopd.carstore.services.exceptions.ObjectNotFoundException;

@Service
public class AdicionalService {

	@Autowired
	private AdicionalRepository repo;
	
	public List<Adicional> findAll() {
		return repo.findAll();
	}
	
	public Adicional findById(Integer id) {
		Optional<Adicional> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado: " + id));
	}
	
	public Adicional insert(Adicional obj) {
		obj.setId(null);
		return repo.save(obj);
		
	}
	
	public void deleteById(Integer id) {
		findById(id);
		repo.deleteById(id);
	}
	
	public void update(Adicional obj) {
		findById(obj.getId());
		repo.save(obj);
	}
	
	public Adicional fromDTO(AdicionalDTO objDto) {
		return new Adicional(objDto.getId(), objDto.getNome());
	}
}
