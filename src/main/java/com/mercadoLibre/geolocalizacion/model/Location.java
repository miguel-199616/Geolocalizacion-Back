package com.mercadoLibre.geolocalizacion.model;

import java.util.Objects;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("Location")
public class Location {
	
	@Id
	private String id;
	private String countryName;
	private double distance;
	
	public Location() {
		super();
	}

	public Location(String id, String countryName, double distance) {
		super();
		this.id = id;
		this.countryName = countryName;
		this.distance = distance;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getCountryName() {
		return countryName;
	}

	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}

	public double getDistance() {
		return distance;
	}

	public void setDistance(double distance) {
		this.distance = distance;
	}

	@Override
	public int hashCode() {
		return Objects.hash(distance, id, countryName);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Location other = (Location) obj;
		return Double.doubleToLongBits(distance) == Double.doubleToLongBits(other.distance)
				&& Objects.equals(id, other.id) && Objects.equals(countryName, other.countryName);
	}

	@Override
	public String toString() {
		return "Location [id=" + id + ", countryName=" + countryName + ", distance=" + distance + "]";
	}
	
	
	
	
}
