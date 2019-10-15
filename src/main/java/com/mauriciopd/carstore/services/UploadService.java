package com.mauriciopd.carstore.services;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URI;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.mauriciopd.carstore.domain.Veiculo;
import com.mauriciopd.carstore.services.exceptions.FileStorageException;
import com.mauriciopd.carstore.services.exceptions.MyFileNotFoundException;

@Service
public class UploadService {
	
	@Value("${file.upload-dir}")
	private String raiz;
	
	@Value("${file.content-type}")
	private String contentType;
	
	public URI uploadFile(MultipartFile file, Veiculo obj) {
	
		Path pathDiretorio = obterDiretorioFoto(obj);
		Path pathPicture = pathDiretorio.resolve(file.getOriginalFilename());
		
		try {
			Files.createDirectories(pathDiretorio);
			Files.copy(file.getInputStream(), pathPicture, StandardCopyOption.REPLACE_EXISTING);
			
			return ServletUriComponentsBuilder
					.fromCurrentRequest()
					.path("/" + file.getOriginalFilename())
					.build()
					.toUri();
		}catch (IOException e) {
			throw new FileStorageException("Erro ao tentar armazenar o arquivo. Porfavor tente novamente!");
		}
	}
	
	public Resource loadPicture(String fileName, Veiculo obj) {
		try {
			fileName += contentType;
			Path path = obterDiretorioFoto(obj);
			Path pathNovo = path.resolve(fileName);
			Resource resource = new UrlResource(pathNovo.toUri());
			if(resource.exists()) {
				return resource;
			} else {
				throw new MyFileNotFoundException("Arquivo não encontrado " + fileName);
			}
		}catch (MalformedURLException e) {
			throw new MyFileNotFoundException("Arquivo " + fileName + " não encontrado ", e);
		}
	}
	
	private Path obterDiretorioFoto(Veiculo veiculo) {
		String modelo = veiculo.getModelo().getNome();
		String marca = veiculo.getModelo().getMarca().getNome();
		return Paths.get(raiz, marca, modelo, veiculo.getId().toString());
	}
	
}
