package com.mercadoLibre.geolocalizacion.model.rs;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonProperty;

public class GenericRsDTO {
	
	@JsonProperty("successful")
	private Boolean successful;
	@JsonProperty("errorType")
	private String errorType;
	@JsonProperty("errorDescription")
	private String errorDescription;
	
	public GenericRsDTO setResponse (Boolean successful, String errorType, String errorDescription) {		
		this.successful = successful;
		this.errorType = errorType;
		this.errorDescription = errorDescription;
		return this;
	}

	public Boolean getSuccessful() {
		return successful;
	}

	public void setSuccessful(Boolean successful) {
		this.successful = successful;
	}

	public String getErrorType() {
		return errorType;
	}

	public void setErrorType(String errorType) {
		this.errorType = errorType;
	}

	public String getErrorDescription() {
		return errorDescription;
	}

	public void setErrorDescription(String errorDescription) {
		this.errorDescription = errorDescription;
	}

	@Override
	public int hashCode() {
		return Objects.hash(errorDescription, errorType, successful);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		GenericRsDTO other = (GenericRsDTO) obj;
		return Objects.equals(errorDescription, other.errorDescription) && Objects.equals(errorType, other.errorType)
				&& Objects.equals(successful, other.successful);
	}

	@Override
	public String toString() {
		return "GenericoRsDTO [successful=" + successful + ", errorType=" + errorType + ", errorDescription="
				+ errorDescription + "]";
	}
	
	
	
	
	
	/*public GenericoRsDTO setResponse(Boolean pSuccessful, String pErrorType, String pErrorDescription) {
		this.set
	}*/

}
