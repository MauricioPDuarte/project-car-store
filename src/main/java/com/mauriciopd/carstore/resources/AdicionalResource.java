package com.mauriciopd.carstore.resources;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

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

import com.mauriciopd.carstore.domain.Adicional;
import com.mauriciopd.carstore.dto.AdicionalDTO;
import com.mauriciopd.carstore.services.AdicionalService;

@RestController
@RequestMapping(value = "/adicionais")
public class AdicionalResource {

	@Autowired
	private AdicionalService service;
	
	@GetMapping
	public ResponseEntity<List<AdicionalDTO>> findAll() {
		List<Adicional> adicionais = service.findAll();
		List<AdicionalDTO> listDto = adicionais.stream().map(x -> new AdicionalDTO(x)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDto);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<AdicionalDTO> findById(@PathVariable Integer id) {
		Adicional obj = service.findById(id);
		AdicionalDTO objDto = new AdicionalDTO(obj);
		return ResponseEntity.ok().body(objDto);
	}
	
	@PostMapping
	public ResponseEntity<Void> insert(@Valid @RequestBody AdicionalDTO objDto) {
		Adicional obj = service.fromDTO(objDto);
		obj = service.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	
}
