package com.mercadoLibre.geolocalizacion.model.rs;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;

public class LanguagesRsDTO {
	
	@JsonProperty("code")
	private String code;
	@JsonProperty("name")
	private String name;
	@JsonProperty("native")
	private String nativeResult;
	
	public LanguagesRsDTO() {
		super();		
	}

	public LanguagesRsDTO(String code, String name, String nativeResult) {
		super();
		this.code = code;
		this.name = name;
		this.nativeResult = nativeResult;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getNativeResult() {
		return nativeResult;
	}

	public void setNativeResult(String nativeResult) {
		this.nativeResult = nativeResult;
	}

	@Override
	public int hashCode() {
		return Objects.hash(code, name, nativeResult);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		LanguagesRsDTO other = (LanguagesRsDTO) obj;
		return Objects.equals(code, other.code) && Objects.equals(name, other.name)
				&& Objects.equals(nativeResult, other.nativeResult);
	}

	@Override
	public String toString() {
		return "Languages [code=" + code + ", name=" + name + ", nativeResult=" + nativeResult + "]";
	}
	
	
	
	

}
