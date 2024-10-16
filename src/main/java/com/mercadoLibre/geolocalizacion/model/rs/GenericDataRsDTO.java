package com.mercadoLibre.geolocalizacion.model.rs;

public class GenericDataRsDTO<T> extends GenericRsDTO {
	
	private T data;

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}
	
	

}
