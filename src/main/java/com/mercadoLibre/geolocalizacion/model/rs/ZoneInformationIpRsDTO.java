package com.mercadoLibre.geolocalizacion.model.rs;

import java.util.Date;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ZoneInformationIpRsDTO {
	
	@JsonProperty("zoneName")
	private String zoneName;
	@JsonProperty("currentlyDate")
	private String currentlyDate;
	
	public ZoneInformationIpRsDTO() {
		super();		
	}

	public ZoneInformationIpRsDTO(String zoneName, String currentlyDate) {
		super();
		this.zoneName = zoneName;
		this.currentlyDate = currentlyDate;
	}

	public String getZoneName() {
		return zoneName;
	}

	public void setZoneName(String zoneName) {
		this.zoneName = zoneName;
	}

	public String getCurrentlyDate() {
		return currentlyDate;
	}

	public void setCurrentlyDate(String currentlyDate) {
		this.currentlyDate = currentlyDate;
	}

	@Override
	public int hashCode() {
		return Objects.hash(currentlyDate, zoneName);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ZoneInformationIpRsDTO other = (ZoneInformationIpRsDTO) obj;
		return Objects.equals(currentlyDate, other.currentlyDate) && Objects.equals(zoneName, other.zoneName);
	}

	@Override
	public String toString() {
		return "ZoneInformationIpRsDTO [zoneName=" + zoneName + ", currentlyDate=" + currentlyDate + "]";
	}
	
	
	
	

}
