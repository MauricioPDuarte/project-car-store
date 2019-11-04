package com.mauriciopd.carstore.resources;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mauriciopd.carstore.domain.Cambio;
import com.mauriciopd.carstore.dto.CambioDTO;
import com.mauriciopd.carstore.services.CambioService;

@RestController
@RequestMapping("/cambios")
public class CambioResource {
	
	@Autowired
	private CambioService service;

	@GetMapping
	public ResponseEntity<List<CambioDTO>> findAll() {
		List<Cambio> list = service.findAll();
		List<CambioDTO> listDto = list.stream().map(x -> new CambioDTO(x)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDto);
	}
}
