package com.mercadoLibre.geolocalizacion.model.rs;

import java.math.BigDecimal;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ZonesDTO {
	
	@JsonProperty("countryCode")
	private String countryCode;
	@JsonProperty("countryName")
	private String countryName;
	@JsonProperty("zoneName")
	private String zoneName;
	@JsonProperty("gmtOffset")
	private long gmtOffset;
	@JsonProperty("timestamp")
	private long timestamp;
	
	public ZonesDTO() {
		super();	
	}

	public ZonesDTO(String countryCode, String countryName, String zoneName, long gmtOffset, long timestamp) {
		super();
		this.countryCode = countryCode;
		this.countryName = countryName;
		this.zoneName = zoneName;
		this.gmtOffset = gmtOffset;
		this.timestamp = timestamp;
	}

	public String getCountryCode() {
		return countryCode;
	}

	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}

	public String getCountryName() {
		return countryName;
	}

	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}

	public String getZoneName() {
		return zoneName;
	}

	public void setZoneName(String zoneName) {
		this.zoneName = zoneName;
	}

	public long getGmtOffset() {
		return gmtOffset;
	}

	public void setGmtOffset(long gmtOffset) {
		this.gmtOffset = gmtOffset;
	}

	public long getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(long timestamp) {
		this.timestamp = timestamp;
	}

	@Override
	public int hashCode() {
		return Objects.hash(countryCode, countryName, gmtOffset, timestamp, zoneName);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ZonesDTO other = (ZonesDTO) obj;
		return Objects.equals(countryCode, other.countryCode) && Objects.equals(countryName, other.countryName)
				&& Objects.equals(gmtOffset, other.gmtOffset) && Objects.equals(timestamp, other.timestamp)
				&& Objects.equals(zoneName, other.zoneName);
	}

	@Override
	public String toString() {
		return "ZonesDTO [countryCode=" + countryCode + ", countryName=" + countryName + ", zoneName=" + zoneName
				+ ", gmtOffset=" + gmtOffset + ", timestamp=" + timestamp + "]";
	}
	
	
	
	

}
