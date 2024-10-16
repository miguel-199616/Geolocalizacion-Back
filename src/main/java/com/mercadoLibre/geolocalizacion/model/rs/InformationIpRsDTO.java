package com.mercadoLibre.geolocalizacion.model.rs;

import java.util.Date;
import java.util.List;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonProperty;

public class InformationIpRsDTO {
	
	@JsonProperty("ip")
	private String ip;
	@JsonProperty("currentlyDate")
	private String currentlyDate;
	@JsonProperty("country")
	private String country;
	@JsonProperty("isoCode")
	private String isoCode;
	@JsonProperty("languages")
	private List<LanguageInformationIpRsDTO> languages;
	@JsonProperty("currency")
	private String currency;
	@JsonProperty("timeZones")
	private List<ZoneInformationIpRsDTO> timeZones;
	@JsonProperty("estimatedDistance")
	private String estimatedDistance;
	
	
	public InformationIpRsDTO() {
		super();
	}

	public InformationIpRsDTO(String ip, String currentlyDate, String country, String isoCode, List<LanguageInformationIpRsDTO> languages, String currency,
			List<ZoneInformationIpRsDTO> timeZones, String estimatedDistance) {
		super();
		this.ip = ip;
		this.currentlyDate = currentlyDate;
		this.country=country;
		this.isoCode = isoCode;
		this.languages = languages;
		this.currency = currency;
		this.timeZones = timeZones;
		this.estimatedDistance = estimatedDistance;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public String getCurrentlyDate() {
		return currentlyDate;
	}

	public void setCurrentlyDate(String currentlyDate) {
		this.currentlyDate = currentlyDate;
	}

	public String getIsoCode() {
		return isoCode;
	}

	public void setIsoCode(String isoCode) {
		this.isoCode = isoCode;
	}

	public List<LanguageInformationIpRsDTO> getLanguages() {
		return languages;
	}

	public void setLanguages(List<LanguageInformationIpRsDTO> languages) {
		this.languages = languages;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public List<ZoneInformationIpRsDTO> getTimeZones() {
		return timeZones;
	}

	public void setTimeZones(List<ZoneInformationIpRsDTO> timeZones) {
		this.timeZones = timeZones;
	}

	public String getEstimatedDistance() {
		return estimatedDistance;
	}

	public void setEstimatedDistance(String estimatedDistance) {
		this.estimatedDistance = estimatedDistance;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	@Override
	public int hashCode() {
		return Objects.hash(country, currency, currentlyDate, estimatedDistance, ip, isoCode, languages, timeZones);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		InformationIpRsDTO other = (InformationIpRsDTO) obj;
		return Objects.equals(country, other.country) && Objects.equals(currency, other.currency) && Objects.equals(currentlyDate, other.currentlyDate)
				&& Objects.equals(estimatedDistance, other.estimatedDistance) && Objects.equals(ip, other.ip)
				&& Objects.equals(isoCode, other.isoCode) && Objects.equals(languages, other.languages)
				&& Objects.equals(timeZones, other.timeZones);
	}

	@Override
	public String toString() {
		return "InformationIpRsDTO [ip=" + ip + ", currentlyDate=" + currentlyDate + ", country=" + country+ ", isoCode=" + isoCode
				+ ", languages=" + languages + ", currency=" + currency + ", timeZones=" + timeZones
				+ ", estimatedDistance=" + estimatedDistance + "]";
	}
	
	
	
	
	

}
