package com.mercadoLibre.geolocalizacion.model.rs;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;

public class IpRsDTO {
	
	@JsonProperty("ip")
	private String ip;
	@JsonProperty("type")
	private String type;
	@JsonProperty("continent_code")
	private String continentCode;
	@JsonProperty("continent_name")
	private String continentName;
	@JsonProperty("country_code")
	private String countryCode;
	@JsonProperty("country_name")
	private String countryName;
	@JsonProperty("region_code")
	private String regionCode;
	@JsonProperty("region_name")
	private String regionName;
	@JsonProperty("city")
	private String city;
	@JsonProperty("zip")
	private String zip;
	@JsonProperty("latitude")
	private double latitude;
	@JsonProperty("longitude")
	private double longitude;
	@JsonProperty("location")
	private LocationRsDTO location;

	public IpRsDTO() {
		super();
	}

	public IpRsDTO(String ip, String type, String continentCode, String continentName, String countryCode,
			String countryName, String regionCode, String regionName, String city, String zip, double latitude,
			double longitude, LocationRsDTO location) {
		super();
		this.ip = ip;
		this.type = type;
		this.continentCode = continentCode;
		this.continentName = continentName;
		this.countryCode = countryCode;
		this.countryName = countryName;
		this.regionCode = regionCode;
		this.regionName = regionName;
		this.city = city;
		this.zip = zip;
		this.latitude = latitude;
		this.longitude = longitude;
		this.location=location;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getContinentCode() {
		return continentCode;
	}

	public void setContinentCode(String continentCode) {
		this.continentCode = continentCode;
	}

	public String getContinentName() {
		return continentName;
	}

	public void setContinentName(String continentName) {
		this.continentName = continentName;
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

	public String getRegionCode() {
		return regionCode;
	}

	public void setRegionCode(String regionCode) {
		this.regionCode = regionCode;
	}

	public String getRegionName() {
		return regionName;
	}

	public void setRegionName(String regionName) {
		this.regionName = regionName;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getZip() {
		return zip;
	}

	public void setZip(String zip) {
		this.zip = zip;
	}

	public double getLatitude() {
		return latitude;
	}

	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}

	public double getLongitude() {
		return longitude;
	}

	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}

	public LocationRsDTO getLocation() {
		return location;
	}

	public void setLocation(LocationRsDTO location) {
		this.location = location;
	}

	@Override
	public int hashCode() {
		return Objects.hash(city, continentCode, continentName, countryCode, countryName, ip, latitude, longitude,
				regionCode, regionName, type, zip, location);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		IpRsDTO other = (IpRsDTO) obj;
		return Objects.equals(city, other.city) && Objects.equals(continentCode, other.continentCode)
				&& Objects.equals(continentName, other.continentName)
				&& Objects.equals(countryCode, other.countryCode) && Objects.equals(countryName, other.countryName)
				&& Objects.equals(ip, other.ip) && Objects.equals(latitude, other.latitude)
				&& Objects.equals(longitude, other.longitude) && Objects.equals(regionCode, other.regionCode)
				&& Objects.equals(regionName, other.regionName) && Objects.equals(type, other.type)
				&& Objects.equals(zip, other.zip) && Objects.equals(location, other.location);
	}

	@Override
	public String toString() {
		return "IpRsDTO [ip=" + ip + ", type=" + type + ", continentCode=" + continentCode + ", continentName="
				+ continentName + ", countryCode=" + countryCode + ", countryName=" + countryName + ", regionCode="
				+ regionCode + ", regionName=" + regionName + ", city=" + city + ", zip=" + zip + ", latitude="
				+ latitude + ", longitude=" + longitude + ", location=" + location + "]";
	}








}
