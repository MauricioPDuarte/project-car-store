package com.mauriciopd.carstore.resources.exceptions;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.mauriciopd.carstore.services.exceptions.DataIntegrityException;
import com.mauriciopd.carstore.services.exceptions.FileStorageException;
import com.mauriciopd.carstore.services.exceptions.MyFileNotFoundException;
import com.mauriciopd.carstore.services.exceptions.ObjectNotFoundException;

@RestControllerAdvice
public class ResourceExceptionHandler {
	
	@ExceptionHandler(ObjectNotFoundException.class)
	public ResponseEntity<StandartError> objectNotFound(ObjectNotFoundException e, HttpServletRequest request) {
		StandartError err = StandartError
				.Builder
				.newBuilder()
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
				.Builder
				.newBuilder()
				.withTimestamp(System.currentTimeMillis())
				.withStatus(HttpStatus.BAD_REQUEST.value())
				.withError("Integridade de dados")
				.withMessage(e.getMessage())
				.withPath(request.getRequestURI())
				.build();
		
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(err);	
	}
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<ValidationError> methodArgumentNotValid(MethodArgumentNotValidException e, HttpServletRequest request) {
		ValidationError err = ValidationError
				.Builder
				.newBuilder()
				.withTimestamp(System.currentTimeMillis())
				.withStatus(HttpStatus.UNPROCESSABLE_ENTITY.value())
				.withError("Erro de validação")
				.withMessage("Erro de validação")
				.withPath(request.getRequestURI())
				.build();
		
		for(FieldError x : e.getBindingResult().getFieldErrors()) {
			err.addErrors(x.getField(), x.getDefaultMessage());
		}
	
		return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).body(err);	
	}
	
	@ExceptionHandler(FileStorageException.class)
	public ResponseEntity<StandartError> dataIntegrity(FileStorageException e, HttpServletRequest request) {
		StandartError err = StandartError
				.Builder
				.newBuilder()
				.withTimestamp(System.currentTimeMillis())
				.withStatus(HttpStatus.BAD_REQUEST.value())
				.withError("Erro de armazenamento")
				.withMessage(e.getMessage())
				.withPath(request.getRequestURI())
				.build();
		
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(err);	
	}
	
	@ExceptionHandler(MyFileNotFoundException.class)
	public ResponseEntity<StandartError> dataIntegrity(MyFileNotFoundException e, HttpServletRequest request) {
		StandartError err = StandartError
				.Builder
				.newBuilder()
				.withTimestamp(System.currentTimeMillis())
				.withStatus(HttpStatus.NOT_FOUND.value())
				.withError("Arquivo não encontrado")
				.withMessage(e.getMessage())
				.withPath(request.getRequestURI())
				.build();
		
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(err);	
	}
	
	
	
}
