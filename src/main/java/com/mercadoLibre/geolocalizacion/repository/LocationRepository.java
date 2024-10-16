package com.mercadoLibre.geolocalizacion.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.mercadoLibre.geolocalizacion.model.Location;

@Repository
public interface LocationRepository extends MongoRepository<Location, String> {
	
	@Query("{countryName:'?0'}")
	public List<Location> findLocationsByCountryName(String countryName);
	
	
	
	

}
