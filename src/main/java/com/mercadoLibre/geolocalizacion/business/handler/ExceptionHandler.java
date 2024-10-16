package com.mercadoLibre.geolocalizacion.business.handler;

import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.mercadoLibre.geolocalizacion.business.handler.exception.GeneralException;
import com.mercadoLibre.geolocalizacion.model.rs.GenericRsDTO;
import com.mercadoLibre.geolocalizacion.utilidad.Constants;

import javax.servlet.http.HttpServletRequest;

import java.net.BindException;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@RestControllerAdvice
public class ExceptionHandler {
	
	@ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
	@org.springframework.web.bind.annotation.ExceptionHandler(value = {Exception.class, GeneralException.class})
	public ResponseEntity<GenericRsDTO> genericExceptionHandlerDefault(HttpServletRequest request, GeneralException generalException){
		GenericRsDTO response = new GenericRsDTO();
		response.setResponse(Boolean.FALSE, 
				             generalException.getMessage()==null?Constants.MENSAJE_ERROR:generalException.getMessage(), 
				             generalException.getErrorType()==null?Constants.MENSAJE_ERROR:generalException.getErrorType());
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
	}
	
	@ResponseStatus(value = HttpStatus.BAD_REQUEST)
	@org.springframework.web.bind.annotation.ExceptionHandler(value = {BindException.class})
	public ResponseEntity<GenericRsDTO> genericExceptionHandler(HttpServletRequest request, MethodArgumentNotValidException e){		
		GenericRsDTO response = new GenericRsDTO();
		String errors = e.getBindingResult().getFieldErrors().stream().map(fieldError -> String.format("[%s]:%s ", fieldError.getField(),
				fieldError.getDefaultMessage())).collect(Collectors.joining(" \n "));
		response.setResponse(Boolean.FALSE, Constants.MENSAJE_ERROR, errors);
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
	}

}
