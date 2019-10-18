package com.mauriciopd.carstore.services;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.mauriciopd.carstore.domain.Picture;
import com.mauriciopd.carstore.services.exceptions.FileStorageException;
import com.mauriciopd.carstore.services.exceptions.MyFileNotFoundException;
import com.mauriciopd.carstore.services.utils.PictureUtil;

@Service
public class UploadService {
	
	@Value("${file.upload-dir}")
	private String raiz;
	
	@Autowired
	private PictureUtil pictureUtil;

	public Picture uploadPictureVehicle(MultipartFile picture, Path path, String fileName) {
		BufferedImage jpgImage = pictureUtil.getJpgImageFromFile(picture);
		Path finalPath = Paths.get(raiz, path.toString());
		File file = new File(path.toUri());
		try {
			if((!file.exists()) && !file.isDirectory()) {
				Files.createDirectories(path);	
			}
			Files.copy(pictureUtil.getInputStream(jpgImage, "jpg"), finalPath.resolve(fileName), StandardCopyOption.REPLACE_EXISTING);
			return new Picture(null, fileName, false, null);
		} catch (IOException e) {
			throw new FileStorageException("Erro ao tentar armazenar o arquivo. Porfavor tente novamente!");
		}
	}
	
	public Resource loadPicture(Path path) {
		try {
			Path finalPath = Paths.get(raiz, path.toString());
			Resource resource = new UrlResource(finalPath.toUri());
			if (resource.exists()) {
				return resource;
			} else {
				throw new MyFileNotFoundException("Arquivo não encontrado");
			}
		} catch (MalformedURLException e) {
			throw new MyFileNotFoundException("Arquivo não encontrado. Porfavor tente novamente!", e);
		}
	}
}
