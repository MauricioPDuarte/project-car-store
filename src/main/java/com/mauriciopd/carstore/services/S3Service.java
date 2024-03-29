package com.mauriciopd.carstore.services;

import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.net.URISyntaxException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.ObjectMetadata;

@Service
public class S3Service {

	@Autowired
	private AmazonS3 s3client;

	@Value("${s3.bucket}")
	private String bucketName;

	public URI uploadFile(MultipartFile file) {
		try {
			String fileName = file.getOriginalFilename();
			InputStream is = file.getInputStream();
			String contentType = file.getContentType();
			return uploadFile(is, fileName, contentType);
		} catch (IOException e) {
			throw new RuntimeException("Erro de IO: " + e.getMessage());
		}
	}
	
	public URI uploadFile(MultipartFile file, String fileName) {
		try {
			InputStream is = file.getInputStream();
			String contentType = file.getContentType();
			return uploadFile(is, fileName, contentType);
		} catch (IOException e) {
			throw new RuntimeException("Erro de IO: " + e.getMessage());
		}
	}

	public URI uploadFile(InputStream is, String fileName, String contentType) {
		try {
			ObjectMetadata meta = new ObjectMetadata();
			meta.setContentType(contentType);

			s3client.putObject(bucketName, fileName, is, meta);
			return s3client.getUrl(bucketName, fileName).toURI();
		} catch (URISyntaxException e) {
			throw new RuntimeException("Erro ao converter URL para URI");
		}
	}
}
