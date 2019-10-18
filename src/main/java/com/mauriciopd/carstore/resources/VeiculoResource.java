package com.mauriciopd.carstore.resources;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

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

import com.mauriciopd.carstore.domain.Picture;
import com.mauriciopd.carstore.domain.Veiculo;
import com.mauriciopd.carstore.dto.VeiculoDTO;
import com.mauriciopd.carstore.dto.VeiculoNewDTO;
import com.mauriciopd.carstore.services.VeiculoService;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value = "/veiculos")
public class VeiculoResource {
	
	@Autowired
	private VeiculoService service;
	
	@Value("${file.prefix}")
	private String prefix;
	
	@ApiOperation(value="Inserir novo")
	@PostMapping
	public ResponseEntity<Void> insert(@Valid @RequestBody VeiculoNewDTO veiculoDto) {
		Veiculo veiculo = service.fromDTO(veiculoDto);
		veiculo = service.insert(veiculo);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/buscar/{id}").buildAndExpand(veiculo.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@ApiOperation(value="Atualizar por id")
	@PutMapping("/{id}")
	public ResponseEntity<Void> atualizar(@Valid @RequestBody VeiculoNewDTO veiculoDto, @PathVariable Integer id) {
		Veiculo veiculo = service.fromDTO(veiculoDto);
		veiculo.setId(id);
		veiculo = service.atualizar(veiculo);
		return ResponseEntity.noContent().build();
	}
	
	@ApiOperation(value="Buscar por id")
	@GetMapping("/{id}")
	public ResponseEntity<Veiculo> findById(@PathVariable Integer id) {
		Veiculo veiculo = service.findById(id);
		return ResponseEntity.ok().body(veiculo);
	}
	
	@ApiOperation(value="Buscar todos")
	@GetMapping
	public ResponseEntity<List<VeiculoDTO>> findAll() {
		List<Veiculo> list = service.findAll();
		List<VeiculoDTO> listDto = list.stream().map(x -> new VeiculoDTO(x)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDto);
	}

	@ApiOperation(value="Buscar por marca")
	@GetMapping("/buscar/{marca}")
	public ResponseEntity<List<VeiculoDTO>> findByMarca(@PathVariable String marca) {
		List<Veiculo> list = service.findByMarca(marca);
		List<VeiculoDTO> listDto = list.stream().map(x -> new VeiculoDTO(x)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDto);
	}
	
	@ApiOperation(value="Buscar por modelo")
	@GetMapping("/buscar/{marca}/{modelo}")
	public ResponseEntity<List<VeiculoDTO>> findByMarcaAndModelo(@PathVariable String marca, @PathVariable String modelo) {
		List<Veiculo> list = service.findByMarcaAndModelo(marca, modelo);
		List<VeiculoDTO> listDto = list.stream().map(x -> new VeiculoDTO(x)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDto);
	}
	
	@ApiOperation(value="Deletar por id")
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable Integer id) {
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
	
	@ApiOperation(value="Inserir foto por id do veiculo")
	@PostMapping("/picture/{id}")
	public ResponseEntity<List<Picture>> insertVehiclePicture(@RequestParam(name = "file") List<MultipartFile> files, @PathVariable("id") Integer id) {
		Veiculo veiculo = service.findById(id);
		List<Picture> pictures = files.stream().map(x -> service.uploadVehiclePicture(veiculo, x)).collect(Collectors.toList());
		return ResponseEntity.ok().body(pictures);
	}
	
	@ApiOperation(value="Altera thumbnail veiculo")
	@PutMapping("{vehicleId}/picture/{pictureId}")
	public ResponseEntity<List<Picture>> updateVehiclePicture(@PathVariable("vehicleId") Integer vehicleId, @PathVariable("pictureId") Integer pictureId) {
		Veiculo veiculo = service.findById(vehicleId);
		service.updateThumbnailVehicle(pictureId, veiculo);
		return ResponseEntity.noContent().build();
	}
	
	@ApiOperation(value="Deletar determinada foto do veiculo")
	@DeleteMapping("/picture/{id}/{fileName:.+}")
	public ResponseEntity<List<Picture>> deleteVehiclePicture(@PathVariable("fileName") String fileName, @PathVariable("id") Integer id) {
		service.deleteVehiclePicture(id, fileName);
		return ResponseEntity.noContent().build();
	}
	
	@ApiOperation(value="Buscar/exibir foto por nome")
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
