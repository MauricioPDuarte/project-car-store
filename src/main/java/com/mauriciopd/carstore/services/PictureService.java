package com.mauriciopd.carstore.services;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Date;
import java.util.Optional;

import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.mauriciopd.carstore.domain.Picture;
import com.mauriciopd.carstore.domain.Veiculo;
import com.mauriciopd.carstore.repository.PictureRepository;
import com.mauriciopd.carstore.services.exceptions.FileStorageException;
import com.mauriciopd.carstore.services.exceptions.MyFileNotFoundException;
import com.mauriciopd.carstore.services.exceptions.ObjectNotFoundException;

@Service
public class PictureService {

	@Value("${file.upload-dir}")
	private String raiz;

	@Autowired
	private ImageService imageService;

	@Autowired
	private PictureRepository repo;

	public Picture uploadFile(MultipartFile file, Veiculo obj) {

		Path pathDiretorio = obterDiretorioFoto(obj);
		BufferedImage jpgImage = imageService.getJpgImageFromFile(file);

		String fileName = obj.getModelo().getNome() + "-" + obj.getModelo().getMarca().getNome() + "-" + obj.getId()
				+ "-" + new Date().getTime() + ".jpg";

		Path pathPicture = pathDiretorio.resolve(fileName);
		try {
			Files.createDirectories(pathDiretorio);
			Files.copy(imageService.getInputStream(jpgImage, "jpg"), pathPicture, StandardCopyOption.REPLACE_EXISTING);

			return repo.save(new Picture(null, fileName, false, obj));
		} catch (IOException e) {
			throw new FileStorageException("Erro ao tentar armazenar o arquivo. Porfavor tente novamente!");
		}
	}

	public Resource loadPicture(String fileName, Veiculo obj) {
		try {
			Path path = obterDiretorioFoto(obj);
			Path pathNovo = path.resolve(fileName);
			Resource resource = new UrlResource(pathNovo.toUri());
			if (resource.exists()) {
				return resource;
			} else {
				throw new MyFileNotFoundException("Arquivo não encontrado " + fileName);
			}
		} catch (MalformedURLException e) {
			throw new MyFileNotFoundException("Arquivo " + fileName + " não encontrado ", e);
		}
	}

	public void deleteFile(Veiculo obj, String fileName) {
		Picture picture = findByNomeFile(fileName);
		Path path = obterDiretorioFoto(obj);
		path.resolve(fileName);
		File file = new File(path.toString());
		file.delete();
		repo.delete(picture);
	
	}

	public void deleteFileAndDirectory(Veiculo obj) {
		File file = new File(obterDiretorioFoto(obj).toString());
		try {
			FileUtils.deleteDirectory(file);
		} catch (IOException e) {
			throw new MyFileNotFoundException("Diretorio não encontrado");
		}

	}
	
	public Picture findByNomeFile(String fileName) {
		Optional<Picture> picture = repo.findByFileName(fileName);
		return picture.orElseThrow(() -> new ObjectNotFoundException("Arquivo não encontrado: " + fileName));
	}

	private Path obterDiretorioFoto(Veiculo veiculo) {
		String modelo = veiculo.getModelo().getNome();
		String marca = veiculo.getModelo().getMarca().getNome();
		return Paths.get(raiz, marca, modelo, veiculo.getId().toString());
	}

}
