package com.mauriciopd.carstore.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mauriciopd.carstore.domain.Marca;
import com.mauriciopd.carstore.domain.Modelo;
import com.mauriciopd.carstore.services.MarcaService;
import com.mauriciopd.carstore.services.ModeloService;

@RestController
@RequestMapping(value = "/marcas")
public class MarcaResource {
	
	@Autowired
	private MarcaService service;
	
	@Autowired
	private ModeloService modeloService;

	@GetMapping
	public ResponseEntity<List<Marca>> findAll() {
		List<Marca> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(value = "/{marcaId}/modelos")
	public ResponseEntity<List<Modelo>> findModelos(@PathVariable Integer marcaId) {
		List<Modelo> list = modeloService.findByMarca(marcaId);
		return ResponseEntity.ok().body(list);
	}
}
