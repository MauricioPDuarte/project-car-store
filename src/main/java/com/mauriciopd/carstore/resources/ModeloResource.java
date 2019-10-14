package com.mauriciopd.carstore.resources;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.mauriciopd.carstore.domain.Modelo;
import com.mauriciopd.carstore.dto.ModeloNewDTO;
import com.mauriciopd.carstore.services.ModeloService;

@RestController
@RequestMapping(value = "/modelos")
public class ModeloResource {
	
	@Autowired
	private ModeloService service;
	
	@PostMapping
	public ResponseEntity<Void> insert(@RequestBody ModeloNewDTO modeloDto) {
		Modelo modelo = service.fromDTO(modeloDto);
		modelo = service.insert(modelo);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(modelo.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@GetMapping(value = "/{modeloId}")
	public ResponseEntity<Modelo> findById(@PathVariable Integer modeloId) {
		Modelo modelo = service.findById(modeloId);
		return ResponseEntity.ok().body(modelo);
	}
	
}
