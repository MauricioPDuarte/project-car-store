package com.mauriciopd.carstore.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mauriciopd.carstore.domain.Marca;
import com.mauriciopd.carstore.services.MarcaService;

@RestController
@RequestMapping(value = "/marcas")
public class MarcaResource {
	
	@Autowired
	private MarcaService service;

	@GetMapping
	public ResponseEntity<List<Marca>> findAll() {
		List<Marca> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}
}
