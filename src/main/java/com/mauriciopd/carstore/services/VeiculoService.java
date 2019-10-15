package com.mauriciopd.carstore.services;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.mauriciopd.carstore.domain.Modelo;
import com.mauriciopd.carstore.domain.Veiculo;
import com.mauriciopd.carstore.domain.enums.CorVeiculo;
import com.mauriciopd.carstore.domain.enums.TipoVeiculo;
import com.mauriciopd.carstore.dto.VeiculoDTO;
import com.mauriciopd.carstore.repository.VeiculoRepository;
import com.mauriciopd.carstore.services.exceptions.ObjectNotFoundException;

@Service
public class VeiculoService {
	
	@Autowired
	private VeiculoRepository repo;
	
	@Autowired
	private UploadService uploadService;
	
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
	
	public List<Veiculo> findByMarca(String marca) {
		return repo.findMarca(marca);
	}
	
	public List<Veiculo> findByMarcaAndModelo(String marca, String modelo) {
		return repo.findModelo(marca, modelo);
	}
	
	public void delete(Integer id) {
		findById(id);
		repo.deleteById(id);
	}
	
	
	public Veiculo atualizar(Veiculo obj) {
		Veiculo newVeiculo = findById(obj.getId());
		updateData(newVeiculo, obj);
		return repo.save(newVeiculo);
	}
	
	public URI uploadVehiclePicture(Veiculo obj, MultipartFile file) {
		URI uri = uploadService.uploadFile(file, obj);
		return uri;
	}
	
	public Resource loadPictureVehicle(String fileName, Veiculo obj) {
		return uploadService.loadPicture(fileName, obj);
	}
	
	private void updateData(Veiculo newVeiculo, Veiculo obj) {
		Modelo modelo = new Modelo(obj.getModelo().getId(), null, null);
		newVeiculo.setAno(obj.getAno());
		newVeiculo.setCor(obj.getCor());
		newVeiculo.setModelo(modelo);
		newVeiculo.setPreco(obj.getPreco());
		newVeiculo.setTipo(obj.getTipo());
	}

	public Veiculo fromDTO(VeiculoDTO obj) {
		Modelo modelo = new Modelo(obj.getModeloId(), null, null);
		Veiculo veiculo = new Veiculo(obj.getId(), obj.getPreco(), obj.getAno(), TipoVeiculo.toEnum(obj.getTipo()), CorVeiculo.toEnum(obj.getCor()), modelo);
		return veiculo;
	}
	
}
