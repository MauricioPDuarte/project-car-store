package com.mauriciopd.carstore.resources;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.mauriciopd.carstore.domain.Veiculo;
import com.mauriciopd.carstore.dto.VeiculoDTO;
import com.mauriciopd.carstore.services.VeiculoService;

@RestController
@RequestMapping(value = "/veiculos")
public class VeiculoResource {
	
	@Autowired
	private VeiculoService service;
	
	@PostMapping
	public ResponseEntity<Void> insert(@RequestBody VeiculoDTO veiculoDto) {
		Veiculo veiculo = service.fromDTO(veiculoDto);
		veiculo = service.insert(veiculo);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/buscar/{id}").buildAndExpand(veiculo.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@GetMapping("/buscar/{id}")
	public ResponseEntity<Veiculo> findByMarca(@PathVariable Integer id) {
		Veiculo veiculo = service.findById(id);
		return ResponseEntity.ok().body(veiculo);
	}
	
	@GetMapping
	public ResponseEntity<List<Veiculo>> findAll() {
		List<Veiculo> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}

	@GetMapping("/{marca}")
	public ResponseEntity<List<Veiculo>> findByMarca(@PathVariable String marca) {
		List<Veiculo> list = service.findByMarca(marca);
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping("/{marca}/{modelo}")
	public ResponseEntity<List<Veiculo>> findByMarcaAndModelo(@PathVariable String marca, @PathVariable String modelo) {
		List<Veiculo> list = service.findByMarcaAndModelo(marca, modelo);
		return ResponseEntity.ok().body(list);
	}
}
