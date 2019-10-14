package com.mauriciopd.carstore.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mauriciopd.carstore.domain.Marca;
import com.mauriciopd.carstore.domain.Modelo;
import com.mauriciopd.carstore.dto.ModeloNewDTO;
import com.mauriciopd.carstore.repository.ModeloRepository;

@Service
public class ModeloService {
	
	@Autowired
	private ModeloRepository repo;

	public Modelo insert(Modelo modelo) {
		return repo.save(modelo);
	}
	
	public Modelo findById(Integer id) {
		Optional<Modelo> modelo = repo.findById(id);
		return modelo.orElseThrow(() -> new RuntimeException("Objeto não encontrado: " + id));
	}
	
	public List<Modelo> findByMarca(Integer marcaId) {
		return repo.findMarca(marcaId);
	}
	
	public Modelo fromDTO(ModeloNewDTO obj) {
		Marca marca = new Marca(obj.getMarcaId(), null);
		Modelo modelo = new Modelo(obj.getId(), obj.getNome(), marca);
		return modelo;
	}
	
	
}
