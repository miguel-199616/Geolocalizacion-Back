package com.mercadoLibre.geolocalizacion.model.rs;

import java.math.BigDecimal;
import java.util.List;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonProperty;

public class LocationRsDTO {
	
	@JsonProperty("geoname_id")
	private BigDecimal geonameId;
	@JsonProperty("capital")
	private String capital;
	@JsonProperty("languages")
	private List<LanguagesRsDTO> languages;
	@JsonProperty("country_flag")
	private String countryFlag;
	@JsonProperty("country_flag_emoji")
	private String countryFlagEmoji;
	@JsonProperty("country_flag_emoji_unicode")
	private String countryFlagEmojiUnicode;
	@JsonProperty("calling_code")
	private String callingCode;
	@JsonProperty("is_eu")
	private String isEu;
	
	public LocationRsDTO() {
		super();		
	}

	public LocationRsDTO(BigDecimal geonameId, String capital, List<LanguagesRsDTO> languages, String countryFlag,
			String countryFlagEmoji, String countryFlagEmojiUnicode, String callingCode, String isEu) {
		super();
		this.geonameId = geonameId;
		this.capital = capital;
		this.languages = languages;
		this.countryFlag = countryFlag;
		this.countryFlagEmoji = countryFlagEmoji;
		this.countryFlagEmojiUnicode = countryFlagEmojiUnicode;
		this.callingCode = callingCode;
		this.isEu = isEu;
	}

	public BigDecimal getGeonameId() {
		return geonameId;
	}

	public void setGeonameId(BigDecimal geonameId) {
		this.geonameId = geonameId;
	}

	public String getCapital() {
		return capital;
	}

	public void setCapital(String capital) {
		this.capital = capital;
	}

	public List<LanguagesRsDTO> getLanguages() {
		return languages;
	}

	public void setLanguages(List<LanguagesRsDTO> languages) {
		this.languages = languages;
	}

	public String getCountryFlag() {
		return countryFlag;
	}

	public void setCountryFlag(String countryFlag) {
		this.countryFlag = countryFlag;
	}

	public String getCountryFlagEmoji() {
		return countryFlagEmoji;
	}

	public void setCountryFlagEmoji(String countryFlagEmoji) {
		this.countryFlagEmoji = countryFlagEmoji;
	}

	public String getCountryFlagEmojiUnicode() {
		return countryFlagEmojiUnicode;
	}

	public void setCountryFlagEmojiUnicode(String countryFlagEmojiUnicode) {
		this.countryFlagEmojiUnicode = countryFlagEmojiUnicode;
	}

	public String getCallingCode() {
		return callingCode;
	}

	public void setCallingCode(String callingCode) {
		this.callingCode = callingCode;
	}

	public String getIsEu() {
		return isEu;
	}

	public void setIsEu(String isEu) {
		this.isEu = isEu;
	}

	@Override
	public int hashCode() {
		return Objects.hash(callingCode, capital, countryFlagEmoji, countryFlagEmojiUnicode, countryFlag, geonameId, isEu,
				languages);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		LocationRsDTO other = (LocationRsDTO) obj;
		return Objects.equals(callingCode, other.callingCode) && Objects.equals(capital, other.capital)
				&& Objects.equals(countryFlagEmoji, other.countryFlagEmoji)
				&& Objects.equals(countryFlagEmojiUnicode, other.countryFlagEmojiUnicode)
				&& Objects.equals(countryFlag, other.countryFlag) && Objects.equals(geonameId, other.geonameId)
				&& Objects.equals(isEu, other.isEu) && Objects.equals(languages, other.languages);
	}

	@Override
	public String toString() {
		return "Location [geonameId=" + geonameId + ", capital=" + capital + ", languages=" + languages
				+ ", countryFlag=" + countryFlag + ", countryFlagEmoji=" + countryFlagEmoji + ", countryFlagEmojiUnicode="
				+ countryFlagEmojiUnicode + ", callingCode=" + callingCode + ", isEu=" + isEu + "]";
	}
	
	
	
	

}
