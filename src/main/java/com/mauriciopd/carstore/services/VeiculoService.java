package com.mauriciopd.carstore.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.mauriciopd.carstore.domain.Adicional;
import com.mauriciopd.carstore.domain.Cambio;
import com.mauriciopd.carstore.domain.Combustivel;
import com.mauriciopd.carstore.domain.Cor;
import com.mauriciopd.carstore.domain.Opcional;
import com.mauriciopd.carstore.domain.Picture;
import com.mauriciopd.carstore.domain.Tipo;
import com.mauriciopd.carstore.domain.Veiculo;
import com.mauriciopd.carstore.domain.Versao;
import com.mauriciopd.carstore.dto.VeiculoNewDTO;
import com.mauriciopd.carstore.repository.VeiculoRepository;
import com.mauriciopd.carstore.repository.specification.VeiculoSpecs;
import com.mauriciopd.carstore.services.exceptions.ObjectNotFoundException;

@Service
public class VeiculoService {
	
	@Autowired
	private VeiculoRepository repo;
	
	@Autowired
	private PictureService pictureService;
	
	@Autowired
	private OpcionalService opcionalService;
	
	@Autowired
	private AdicionalService adicionalService;
	
	@Transactional
	public Veiculo insert(Veiculo obj) {
		obj.setId(null);
		return repo.save(obj);
	}
	
	public Veiculo atualizar(Veiculo obj) {
		findById(obj.getId());
		return repo.save(obj);
		
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
		return repo.findByVersaoModeloMarcaNomeIgnoreCase(marca);
	}
	
	public Page<Veiculo> findByMarcaPage(String marca, Integer page, Integer linesPerPage, String orderBy, String direction) {
		PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy);
		return repo.findByVersaoModeloMarcaNomeIgnoreCase(marca, pageRequest);
	}
	
	public List<Veiculo> findByMarcaAndModelo(String marca, String modelo) {
		return repo.findByVersaoModeloMarcaNomeAndVersaoModeloNomeAllIgnoreCase(marca, modelo);
	}
	
	public Page<Veiculo> findByModeloPage(String marca, String modelo, Integer page, Integer linesPerPage, String orderBy, String direction) {
		PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy);
		return repo.findByVersaoModeloMarcaNomeAndVersaoModeloNomeAllIgnoreCase(marca, modelo, pageRequest);
	}
	
	public Page<Veiculo> findByCarroCustom(
			String marca,
			String modelo, 
			String versao,
			List<String> opcionais,
			Integer deAno,
			Integer ateAno,
			Double dePreco,
			Double atePreco,
			Long deKm,
			Long ateKm,
			List<String> cores,
			List<String> cambios,
			List<String> combustiveis,
			List<String> tipos,
			List<String> nomeAdicionais,
			Integer page,
			Integer linesPerPage,
			String orderBy,
			String direction){
		PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy);
		Specification<Veiculo> spec = Specification.where(VeiculoSpecs.findByCarroCustom(marca, modelo, versao, opcionais, deAno, ateAno, dePreco, atePreco,  deKm, ateKm, cores, cambios, combustiveis, tipos, nomeAdicionais));
		return repo.findAll(spec, pageRequest);
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
		Versao versao = new Versao(obj.getVersaoId(), null, null);
		Cor cor = new Cor(obj.getCorId(), null);
		Cambio cambio = new Cambio(obj.getCambioId(), null);
		Combustivel combustivel = new Combustivel(obj.getCombustivelId(), null);
		Tipo tipo = new Tipo(obj.getTipoId(), null);

		List<Opcional> opcionais = obj.getOpcionais()
				.stream()
				.map(x -> opcionalService.findById(x))
				.collect(Collectors.toList());
		
		List<Adicional> adicionais = obj.getAdicionais()
				.stream()
				.map(x -> adicionalService.findById(x))
				.collect(Collectors.toList());
			
		return Veiculo.Builder
				.newBuilder()
				.withId(obj.getId())
				.withPreco(obj.getPreco())
				.withAno(obj.getAno())
				.withTipo(tipo)
				.withCor(cor)
				.withCombustivel(combustivel)
				.withCambio(cambio)
				.withNumPortas(obj.getNumPortas())
				.withPlaca(obj.getPlaca())
				.withDescricao(obj.getDescricao())
				.withKmRodado(obj.getKmRodado())
				//.withModelo(modelo)
				.withVersao(versao)
				.withOpcionais(opcionais)
				.withAdicionais(adicionais)
				.build();	
	}
	
}
