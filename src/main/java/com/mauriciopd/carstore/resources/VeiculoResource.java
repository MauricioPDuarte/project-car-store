package com.mauriciopd.carstore.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mauriciopd.carstore.domain.Veiculo;
import com.mauriciopd.carstore.services.VeiculoService;

@RestController
@RequestMapping(value = "/veiculos")
public class VeiculoResource {
	
	@Autowired
	private VeiculoService service;
	
	@GetMapping
	public ResponseEntity<List<Veiculo>> findAll() {
		List<Veiculo> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}

	@GetMapping(value = "/modelo/{modeloId}")
	public ResponseEntity<List<Veiculo>> findByModelo(@PathVariable Integer modeloId) {
		List<Veiculo> list = service.findByModelo(modeloId);
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(value = "/marca/{marcaId}")
	public ResponseEntity<List<Veiculo>> findByMarca(@PathVariable Integer marcaId) {
		List<Veiculo> list = service.findByMarca(marcaId);
		return ResponseEntity.ok().body(list);
	}
	
}
