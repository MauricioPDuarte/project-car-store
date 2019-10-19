package com.mauriciopd.carstore.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.mauriciopd.carstore.domain.Modelo;
import com.mauriciopd.carstore.domain.Picture;
import com.mauriciopd.carstore.domain.Veiculo;
import com.mauriciopd.carstore.dto.VeiculoNewDTO;
import com.mauriciopd.carstore.repository.VeiculoRepository;
import com.mauriciopd.carstore.services.exceptions.ObjectNotFoundException;

@Service
public class VeiculoService {
	
	@Autowired
	private VeiculoRepository repo;
	
	@Autowired
	private PictureService pictureService;
	
	public Veiculo insert(Veiculo veiculo) {
		return repo.save(veiculo);
	}
	
	public Veiculo findById(Integer id) {
		Optional<Veiculo> veiculo = repo.findById(id); 
		return veiculo.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado: " + id));
	}

	public List<Veiculo> findAll() {
		return repo.findAll();
	}
	
	public Page<Veiculo> findAllPage(Integer page, Integer linesPerPage, String orderBy, String direction) {
		PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy);
		return repo.findAll(pageRequest);
	}
	
	public List<Veiculo> findByMarca(String marca) {
		return repo.findMarca(marca);
	}
	
	public Page<Veiculo> findByMarcaPage(String marca, Integer page, Integer linesPerPage, String orderBy, String direction) {
		PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy);
		return repo.findMarcaPage(marca, pageRequest);
	}
	
	public List<Veiculo> findByMarcaAndModelo(String marca, String modelo) {
		return repo.findModelo(marca, modelo);
	}
	
	public Page<Veiculo> findByModeloPage(String marca, String modelo, Integer page, Integer linesPerPage, String orderBy, String direction) {
		PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy);
		return repo.findModeloPage(marca, modelo, pageRequest);
	}

	
	public void delete(Integer id) {
		Veiculo veiculo = findById(id);
		repo.deleteById(id);
		pictureService.deleteFileAndDirectory(veiculo);
	}
	
	public void deleteVehiclePicture(Integer id, String fileName) {
		Veiculo veiculo = findById(id);
		pictureService.deleteFile(veiculo, fileName);
	}
	
	
	public Veiculo atualizar(Veiculo obj) {
		findById(obj.getId());
		return repo.save(obj);
	}
	
	public Picture uploadVehiclePicture(Veiculo obj, MultipartFile file) {
		Picture picture = pictureService.uploadPictureVehicle(file, obj);
		obj.getPictures().add(picture);
		repo.save(obj);
		return picture;
	}
	
	public void updateThumbnailVehicle(Integer pictureId, Integer veiculoId) {
		Veiculo veiculo = findById(veiculoId);
		Picture picture = pictureService.findById(pictureId);
		for(Picture obj : veiculo.getPictures()) {
			if(obj.equals(picture)) {
				obj.setThumbnail(true);
			}else {
				obj.setThumbnail(false);				
			}
		}
		repo.save(veiculo);
	}
	
	public Resource loadPictureVehicle(String fileName, Integer veiculoId) {
		Veiculo obj = findById(veiculoId);
		return pictureService.loadPicture(fileName, obj);
	}

	public Veiculo fromDTO(VeiculoNewDTO obj) {
		Modelo modelo = new Modelo(obj.getModeloId(), null, null);
		
		return Veiculo.Builder
				.newBuilder()
				.withId(obj.getId())
				.withPreco(obj.getPreco())
				.withAno(obj.getAno())
				.withTipo(obj.getTipo())
				.withCor(obj.getCor())
				.withCombustivel(obj.getCombustivel())
				.withCambio(obj.getCambio())
				.withNumPortas(obj.getNumPortas())
				.withPlaca(obj.getPlaca())
				.withDescricao(obj.getDescricao())
				.withKmRodado(obj.getKmRodado())
				.withIpvaPago(obj.isIpvaPago())
				.withBlindado(obj.isBlindado())
				.withTroca(obj.isTroca())
				.withGarantiaFabrica(obj.isGarantiaFabrica())
				.withUnicoDono(obj.isUnicoDono())
				.withModelo(modelo)
				.withOpcionais(obj.getOpcionais())
				.build();	
	}
	
}
