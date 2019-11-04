package com.mauriciopd.carstore.resources;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mauriciopd.carstore.domain.Cor;
import com.mauriciopd.carstore.dto.CorDTO;
import com.mauriciopd.carstore.services.CorService;

@RestController("/cores")
public class CorResource {
	
	@Autowired
	private CorService service;

	@GetMapping
	public ResponseEntity<List<CorDTO>> findAll() {
		List<Cor> list = service.findAll();
		List<CorDTO> listDto = list.stream().map(x -> new CorDTO(x)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDto);
	}
}
