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
	
	@Autowired
	private MarcaService marcaService;

	public Modelo insert(Modelo modelo) {
		return repo.save(modelo);
	}
	
	public List<Modelo> findByMarca(Integer marcaId) {
		return repo.findMarca(marcaId);
	}
	
	public Modelo findById(Integer id) {
		Optional<Modelo> modelo = repo.findById(id);
		return modelo.orElseThrow(() -> new RuntimeException("Objeto não encontrado: " + id));
	}
	
	public Modelo fromDTO(ModeloNewDTO obj) {
		Marca marca = marcaService.findById(obj.getMarcaId());
		Modelo modelo = new Modelo();
		modelo.setId(obj.getId());
		modelo.setNome(obj.getNome());
		modelo.setMarca(marca);
		return modelo;
	}
	
	
}
