package com.mauriciopd.carstore.resources;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mauriciopd.carstore.domain.Combustivel;
import com.mauriciopd.carstore.dto.CombustivelDTO;
import com.mauriciopd.carstore.services.CombustivelService;

@RestController
@RequestMapping("/combustiveis")
public class CombustivelResource {
	
	@Autowired
	private CombustivelService service;

	@GetMapping
	public ResponseEntity<List<CombustivelDTO>> findAll() {
		List<Combustivel> list = service.findAll();
		List<CombustivelDTO> listDto = list.stream().map(x -> new CombustivelDTO(x)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDto);
	}
}
