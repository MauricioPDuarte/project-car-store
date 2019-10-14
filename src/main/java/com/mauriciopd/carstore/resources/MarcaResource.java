package com.mauriciopd.carstore.resources;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mauriciopd.carstore.domain.Marca;
import com.mauriciopd.carstore.domain.Modelo;
import com.mauriciopd.carstore.dto.MarcaDTO;
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
	public ResponseEntity<List<MarcaDTO>> findAll() {
		List<Marca> list = service.findAll();
		List<MarcaDTO> listDto = list.stream().map(x -> new MarcaDTO(x)).collect(Collectors.toList()); 
		return ResponseEntity.ok().body(listDto);
	}
	
	@GetMapping(value = "/{marcaId}/modelos")
	public ResponseEntity<List<Modelo>> findModelos(@PathVariable Integer marcaId) {
		List<Modelo> list = modeloService.findByMarca(marcaId);
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(value = "/{marcaId}")
	public ResponseEntity<Marca> findById(@PathVariable Integer marcaId) {
		Marca marca = service.findById(marcaId);
		return ResponseEntity.ok().body(marca);
	}
	
}
