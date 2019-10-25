package com.mauriciopd.carstore.resources;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
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

import com.mauriciopd.carstore.domain.Opcional;
import com.mauriciopd.carstore.dto.OpcionalDTO;
import com.mauriciopd.carstore.services.OpcionalService;
import com.mauriciopd.carstore.services.exceptions.DataIntegrityException;

@RestController
@RequestMapping(value = "/opcionais")
public class OpcionalResource {
	
	@Autowired
	private OpcionalService service;

	@PreAuthorize("hasAnyRole('ADMIN')")
	@PostMapping
	public ResponseEntity<Void> insert(@Valid @RequestBody OpcionalDTO obj) {
		Opcional opcional = service.fromDTO(obj);
		opcional = service.insert(opcional);
		URI uri = ServletUriComponentsBuilder
				.fromCurrentRequest()
				.path("/{id}")
				.buildAndExpand(opcional.getId())
				.toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@GetMapping
	public ResponseEntity<List<OpcionalDTO>> findAll() {
		List<Opcional> list = service.findAll();
		List<OpcionalDTO> listDto = list.stream().map(x -> new OpcionalDTO(x)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDto);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<OpcionalDTO> findById(@PathVariable Integer id) {
		Opcional opcional = service.findById(id);
		OpcionalDTO objDto = new OpcionalDTO(opcional);
		return ResponseEntity.ok().body(objDto);
	}
	
	@PreAuthorize("hasAnyRole('ADMIN')")
	@PutMapping("/{id}")
	public ResponseEntity<Void> update(@PathVariable Integer id, @Valid @RequestBody OpcionalDTO objDto){
		Opcional opcional = service.fromDTO(objDto);
		opcional.setId(id);
		opcional = service.update(opcional);
		return ResponseEntity.noContent().build();
	}
	
	@PreAuthorize("hasAnyRole('ADMIN')")
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable Integer id){
		try {
			service.delete(id);			
		}catch (DataIntegrityViolationException e) {
			throw new DataIntegrityException("Não é possivel excluir um opcional que possui veiculos cadastrados");
		}
		return ResponseEntity.noContent().build();
	}
	
}
