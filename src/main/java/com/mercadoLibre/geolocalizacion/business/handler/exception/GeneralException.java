/**
 * 
 */
package com.mercadoLibre.geolocalizacion.business.handler.exception;

/**
 * @author HP
 *
 */
public class GeneralException extends RuntimeException {
	
	private String errorType;
	
	public GeneralException(String errorType, String message) {
		super(message);
		this.errorType=errorType;
	}

	public String getErrorType() {
		return errorType;
	}

	public void setErrorType(String errorType) {
		this.errorType = errorType;
	}
	
	

}
