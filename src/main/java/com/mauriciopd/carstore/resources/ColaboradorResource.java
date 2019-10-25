package com.mauriciopd.carstore.resources;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

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

import com.mauriciopd.carstore.domain.Colaborador;
import com.mauriciopd.carstore.dto.ColaboradorDTO;
import com.mauriciopd.carstore.dto.ColaboradorNewDTO;
import com.mauriciopd.carstore.services.ColaboradorService;

@RestController
@RequestMapping(value = "/colaboradores")
public class ColaboradorResource {

	@Autowired
	private ColaboradorService service;

	@GetMapping
	public ResponseEntity<List<ColaboradorDTO>> findAll() {
		List<Colaborador> list = service.findAll();
		List<ColaboradorDTO> listDto = list.stream().map(x -> new ColaboradorDTO(x)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDto);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Colaborador> findById(@PathVariable Integer id) {
		Colaborador obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}

	@PreAuthorize("hasAnyRole('ADMIN')")
	@PostMapping
	public ResponseEntity<Void> insert(@Valid @RequestBody ColaboradorNewDTO colaboradorNewDTO) {
		Colaborador obj = service.fromDTO(colaboradorNewDTO);
		obj = service.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}

	@PreAuthorize("hasAnyRole('ADMIN')")
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable Integer id) {
		service.deleteById(id);
		return ResponseEntity.ok().build();
	}
	
	@PreAuthorize("hasAnyRole('ADMIN')")
	@PutMapping("/{id}")
	public ResponseEntity<Void> atualizar(@PathVariable Integer id, @Valid @RequestBody ColaboradorNewDTO objDto) {
		objDto.setId(id);
		Colaborador obj = service.fromDTO(objDto);
		service.update(obj);
		return ResponseEntity.ok().build();
	}
}
