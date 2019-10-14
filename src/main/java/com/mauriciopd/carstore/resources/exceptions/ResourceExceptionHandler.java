package com.mauriciopd.carstore.resources.exceptions;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.mauriciopd.carstore.services.exceptions.DataIntegrityException;
import com.mauriciopd.carstore.services.exceptions.ObjectNotFoundException;

@RestControllerAdvice
public class ResourceExceptionHandler {
	
	@ExceptionHandler(ObjectNotFoundException.class)
	public ResponseEntity<StandartError> objectNotFound(ObjectNotFoundException e, HttpServletRequest request) {
		StandartError err = StandartError
				.builder()
				.withTimestamp(System.currentTimeMillis())
				.withStatus(HttpStatus.NOT_FOUND.value())
				.withError("Não encontrado")
				.withMessage(e.getMessage())
				.withPath(request.getRequestURI())
				.build();
		
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(err);	
	}

	@ExceptionHandler(DataIntegrityException.class)
	public ResponseEntity<StandartError> dataIntegrity(DataIntegrityException e, HttpServletRequest request) {
		StandartError err = StandartError
				.builder()
				.withTimestamp(System.currentTimeMillis())
				.withStatus(HttpStatus.BAD_REQUEST.value())
				.withError("Integridade de dados")
				.withMessage(e.getMessage())
				.withPath(request.getRequestURI())
				.build();
		
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(err);	
	}
}
