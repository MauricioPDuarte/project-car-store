package com.mauriciopd.carstore.resources;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.mauriciopd.carstore.domain.Colaborador;
import com.mauriciopd.carstore.services.ColaboradorService;

@RestController
@RequestMapping(value = "/colaboradores")
public class ColaboradorResource {
	
	@Autowired
	private ColaboradorService service;

	@GetMapping
	public ResponseEntity<List<Colaborador>> findAll() {
		List<Colaborador> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping("/id")
	public ResponseEntity<Colaborador> findById(@PathVariable Integer id) {
		Colaborador obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}
	
	@PostMapping
	public ResponseEntity<Void> insert(@Valid @RequestBody Colaborador colaborador) {
		Colaborador obj = service.insert(colaborador);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
}
