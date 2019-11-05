package com.mauriciopd.carstore.resources;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mauriciopd.carstore.domain.Tipo;
import com.mauriciopd.carstore.dto.TipoDTO;
import com.mauriciopd.carstore.services.TipoService;

@RestController
@RequestMapping("/tipos")
public class TipoResource {
	
	@Autowired
	private TipoService service;

	@GetMapping
	public ResponseEntity<List<TipoDTO>> findAll() {
		List<Tipo> list = service.findAll();
		List<TipoDTO> listDto = list.stream().map(x -> new TipoDTO(x)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDto);
	}
}
