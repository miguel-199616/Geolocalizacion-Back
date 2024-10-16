package com.mercadoLibre.geolocalizacion.model.rs;

import java.util.List;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonProperty;

public class TimeZoneRsDTO {
	
	@JsonProperty("status")
	private String status;
	@JsonProperty("message")
	private String message;
	@JsonProperty("zones")
	private List<ZonesDTO> zones;
	
	public TimeZoneRsDTO() {
		super();		
	}

	public TimeZoneRsDTO(String status, String message, List<ZonesDTO> zones) {
		super();
		this.status = status;
		this.message = message;
		this.zones = zones;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public List<ZonesDTO> getZones() {
		return zones;
	}

	public void setZones(List<ZonesDTO> zones) {
		this.zones = zones;
	}

	@Override
	public int hashCode() {
		return Objects.hash(message, status, zones);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TimeZoneRsDTO other = (TimeZoneRsDTO) obj;
		return Objects.equals(message, other.message) && Objects.equals(status, other.status)
				&& Objects.equals(zones, other.zones);
	}

	@Override
	public String toString() {
		return "TimeZoneDTO [status=" + status + ", message=" + message + ", zones=" + zones + "]";
	}
	
	
	
	

}
