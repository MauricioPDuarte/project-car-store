package com.mauriciopd.carstore.services;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Date;
import java.util.Optional;

import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.mauriciopd.carstore.domain.Picture;
import com.mauriciopd.carstore.domain.Veiculo;
import com.mauriciopd.carstore.repository.PictureRepository;
import com.mauriciopd.carstore.services.exceptions.MyFileNotFoundException;
import com.mauriciopd.carstore.services.exceptions.ObjectNotFoundException;

@Service
public class PictureService {

	@Autowired
	private PictureRepository repo;
	
	@Autowired
	private UploadService uploadService;
	
	public Picture salvarPicture(Picture picture) {
		return repo.save(picture);
	}

	public Picture findByNomeFile(String fileName) {
		Optional<Picture> picture = repo.findByFileName(fileName);
		return picture.orElseThrow(() -> new ObjectNotFoundException("Arquivo não encontrado: " + fileName));
	}
	
	public Picture findById(Integer id) {
		Optional<Picture> picture = repo.findById(id);
		return picture.orElseThrow(() -> new ObjectNotFoundException("Arquivo não encontrado: " + id));
	}
	
	public Picture uploadPictureVehicle(MultipartFile file, Veiculo obj) {
		Path path = obterDiretorioFotoVeiculo(obj);
		String fileName = obterNovoFileName(obj);
		Picture picture = uploadService.uploadPicture(file, path, fileName);
		picture.setVeiculo(obj);
		return repo.save(picture);
	}
	
	public Resource loadPicture(String fileName, Veiculo obj) {
		Path path = obterDiretorioFotoVeiculo(obj);
		return uploadService.loadPicture(path.resolve(fileName));
	}

	public void deleteFile(Veiculo obj, String fileName) {
		Picture picture = findByNomeFile(fileName);
		Path path = obterDiretorioFotoVeiculo(obj);
		path.resolve(fileName);
		File file = new File(path.toString());
		file.delete();
		repo.delete(picture);
	
	}

	public void deleteFileAndDirectory(Veiculo obj) {
		File file = new File(obterDiretorioFotoVeiculo(obj).toString());
		try {
			FileUtils.deleteDirectory(file);
		} catch (IOException e) {
			throw new MyFileNotFoundException("Erro ao excluir o diretorio/arquivos do veiculo");
		}

	}
	
	public String obterNovoFileName(Veiculo obj) {
		return obj.getVersao().getModelo().getNome() + "-" +
				obj.getVersao().getModelo().getMarca().getNome() + "-" +
				obj.getId() + "-" + new Date().getTime() + ".jpg";
	}
	
	private Path obterDiretorioFotoVeiculo(Veiculo veiculo) {
		String modelo = veiculo.getVersao().getModelo().getNome();
		String marca = veiculo.getVersao().getModelo().getMarca().getNome();
		return Paths.get(marca, modelo, veiculo.getId().toString());
	}

}
