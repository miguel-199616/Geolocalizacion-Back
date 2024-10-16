package com.mercadoLibre.geolocalizacion.model.rs;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonProperty;

public class AverageDistanceRsDTO {
	
	@JsonProperty("nameCountryShortestDistance")
	private String nameCountryShortestDistance;
	@JsonProperty("distanceCountryShortestDistance")
	private String distanceCountryShortestDistance;
	@JsonProperty("quantityInvocationsShortestDistance")
	private int quantityInvocationsShortestDistance;
	@JsonProperty("nameCountryLongestDistance")
	private String nameCountryLongestDistance;
	@JsonProperty("distanceCountryLongestDistance")
	private String distanceCountryLongestDistance;
	@JsonProperty("quantityInvocationsLongestDistance")
	private int quantityInvocationsLongestDistance;
	@JsonProperty("averageDistance")
	private String averageDistance;
	
	public AverageDistanceRsDTO() {
		super();
	}

	public AverageDistanceRsDTO(String nameCountryShortestDistance, String distanceCountryShortestDistance,
			int quantityInvocationsShortestDistance, String nameCountryLongestDistance,
			String distanceCountryLongestDistance, int quantityInvocationsLongestDistance, String averageDistance) {
		super();
		this.nameCountryShortestDistance = nameCountryShortestDistance;
		this.distanceCountryShortestDistance = distanceCountryShortestDistance;
		this.quantityInvocationsShortestDistance = quantityInvocationsShortestDistance;
		this.nameCountryLongestDistance = nameCountryLongestDistance;
		this.distanceCountryLongestDistance = distanceCountryLongestDistance;
		this.quantityInvocationsLongestDistance = quantityInvocationsLongestDistance;
		this.averageDistance=averageDistance;
	}

	public String getNameCountryShortestDistance() {
		return nameCountryShortestDistance;
	}

	public void setNameCountryShortestDistance(String nameCountryShortestDistance) {
		this.nameCountryShortestDistance = nameCountryShortestDistance;
	}

	public String getDistanceCountryShortestDistance() {
		return distanceCountryShortestDistance;
	}

	public void setDistanceCountryShortestDistance(String distanceCountryShortestDistance) {
		this.distanceCountryShortestDistance = distanceCountryShortestDistance;
	}

	public int getQuantityInvocationsShortestDistance() {
		return quantityInvocationsShortestDistance;
	}

	public void setQuantityInvocationsShortestDistance(int quantityInvocationsShortestDistance) {
		this.quantityInvocationsShortestDistance = quantityInvocationsShortestDistance;
	}

	public String getNameCountryLongestDistance() {
		return nameCountryLongestDistance;
	}

	public void setNameCountryLongestDistance(String nameCountryLongestDistance) {
		this.nameCountryLongestDistance = nameCountryLongestDistance;
	}

	public String getDistanceCountryLongestDistance() {
		return distanceCountryLongestDistance;
	}

	public void setDistanceCountryLongestDistance(String distanceCountryLongestDistance) {
		this.distanceCountryLongestDistance = distanceCountryLongestDistance;
	}

	public int getQuantityInvocationsLongestDistance() {
		return quantityInvocationsLongestDistance;
	}

	public void setQuantityInvocationsLongestDistance(int quantityInvocationsLongestDistance) {
		this.quantityInvocationsLongestDistance = quantityInvocationsLongestDistance;
	}

	public String getAverageDistance() {
		return averageDistance;
	}

	public void setAverageDistance(String averageDistance) {
		this.averageDistance = averageDistance;
	}

	@Override
	public int hashCode() {
		return Objects.hash(distanceCountryLongestDistance, distanceCountryShortestDistance, nameCountryLongestDistance,
				nameCountryShortestDistance, quantityInvocationsLongestDistance, quantityInvocationsShortestDistance, averageDistance);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AverageDistanceRsDTO other = (AverageDistanceRsDTO) obj;
		return Objects.equals(distanceCountryLongestDistance, other.distanceCountryLongestDistance)
				&& Objects.equals(distanceCountryShortestDistance, other.distanceCountryShortestDistance)
				&& Objects.equals(nameCountryLongestDistance, other.nameCountryLongestDistance)
				&& Objects.equals(nameCountryShortestDistance, other.nameCountryShortestDistance)
				&& Objects.equals(quantityInvocationsLongestDistance, other.quantityInvocationsLongestDistance)
				&& Objects.equals(quantityInvocationsShortestDistance, other.quantityInvocationsShortestDistance)
				&& Objects.equals(averageDistance, other.averageDistance);
	}

	@Override
	public String toString() {
		return "AverageDistanceRsDTO [nameCountryShortestDistance=" + nameCountryShortestDistance
				+ ", distanceCountryShortestDistance=" + distanceCountryShortestDistance
				+ ", quantityInvocationsShortestDistance=" + quantityInvocationsShortestDistance
				+ ", nameCountryLongestDistance=" + nameCountryLongestDistance + ", distanceCountryLongestDistance="
				+ distanceCountryLongestDistance + ", quantityInvocationsLongestDistance="
				+ quantityInvocationsLongestDistance  + ", averageDistance="
						+ averageDistance + "]";
	}
	
	
	
	

}
