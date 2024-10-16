package com.mercadoLibre.geolocalizacion.model.rs;

import java.util.Objects;

public class LanguageInformationIpRsDTO {
	
	private String code;
	private String languageName;
	
	public LanguageInformationIpRsDTO() {
		super();
	}

	public LanguageInformationIpRsDTO(String code, String languageName) {
		super();
		this.code = code;
		this.languageName = languageName;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getLanguageName() {
		return languageName;
	}

	public void setLanguageName(String languageName) {
		this.languageName = languageName;
	}

	@Override
	public int hashCode() {
		return Objects.hash(code, languageName);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		LanguageInformationIpRsDTO other = (LanguageInformationIpRsDTO) obj;
		return Objects.equals(code, other.code) && Objects.equals(languageName, other.languageName);
	}

	@Override
	public String toString() {
		return "LanguageInformationIpRsDTO [code=" + code + ", languageName=" + languageName + "]";
	}
	
	
	
	

}
