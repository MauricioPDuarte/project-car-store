package com.mauriciopd.carstore.resources;

import java.net.URI;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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
	
	@PreAuthorize("hasAnyRole('ADMIN')")
	@PostMapping
	public ResponseEntity<Void> insert(@Valid @RequestBody ModeloNewDTO modeloDto) {
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
	
	@PreAuthorize("hasAnyRole('ADMIN')")
	@PutMapping("/{id}")
	public ResponseEntity<Void> atualizar(@Valid @RequestBody ModeloNewDTO modeloDto, @PathVariable Integer id) {
		Modelo modelo = service.fromDTO(modeloDto);
		modelo.setId(id);
		modelo = service.atualizar(modelo);
		return ResponseEntity.noContent().build();
	}
	
	@PreAuthorize("hasAnyRole('ADMIN')")
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable Integer id) {
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
}
