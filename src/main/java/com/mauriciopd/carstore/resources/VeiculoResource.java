package com.mauriciopd.carstore.resources;

import java.net.URI;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.mauriciopd.carstore.domain.Veiculo;
import com.mauriciopd.carstore.dto.VeiculoDTO;
import com.mauriciopd.carstore.services.VeiculoService;

@RestController
@RequestMapping(value = "/veiculos")
public class VeiculoResource {
	
	@Autowired
	private VeiculoService service;
	
	@Value("${file.prefix}")
	private String prefix;
	
	@PostMapping
	public ResponseEntity<Void> insert(@Valid @RequestBody VeiculoDTO veiculoDto) {
		Veiculo veiculo = service.fromDTO(veiculoDto);
		veiculo = service.insert(veiculo);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/buscar/{id}").buildAndExpand(veiculo.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Void> atualizar(@Valid @RequestBody VeiculoDTO veiculoDto, @PathVariable Integer id) {
		Veiculo veiculo = service.fromDTO(veiculoDto);
		veiculo.setId(id);
		veiculo = service.atualizar(veiculo);
		return ResponseEntity.noContent().build();
	}
	
	@GetMapping("/buscar/{id}")
	public ResponseEntity<Veiculo> findById(@PathVariable Integer id) {
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
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable Integer id) {
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
	
	@PostMapping("/picture/{id}")
	public ResponseEntity<Void> uploadVehiclePicture(@RequestParam(name = "file") MultipartFile file, @PathVariable("id") Integer id) {
		Veiculo veiculo = service.findById(id);
		URI uri = service.uploadVehiclePicture(veiculo, file);
		return ResponseEntity.created(uri).build();
	}
	
	@GetMapping("/picture/{id}/{fileName}")
	public ResponseEntity<Resource> loadPictureVehicle(@PathVariable("id") Integer id, @PathVariable("fileName") String fileName,
			HttpServletRequest request
			) {
		Veiculo veiculo = service.findById(id);
		Resource resource = service.loadPictureVehicle(fileName, veiculo);
		return ResponseEntity.ok()
				.contentType(MediaType.IMAGE_JPEG)
				.header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + resource.getFilename() + "\"")
				.body(resource);
						
	}
}
