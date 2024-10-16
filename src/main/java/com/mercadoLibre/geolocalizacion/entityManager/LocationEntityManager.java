package com.mercadoLibre.geolocalizacion.entityManager;

import java.util.Arrays;

import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mercadoLibre.geolocalizacion.business.IGenerateDatabaseConnection;
import com.mercadoLibre.geolocalizacion.business.handler.exception.GeneralException;
import com.mercadoLibre.geolocalizacion.model.Location;
import com.mercadoLibre.geolocalizacion.utilidad.Constants;
import com.mongodb.client.AggregateIterable;
import com.mongodb.client.MongoCollection;

@Repository
public class LocationEntityManager {
	
	@Autowired
	private IGenerateDatabaseConnection generateDatabaseConnection;
	
	/**
	 * Method for querying the country with the shortest distance from where the service was consumed
	 * @return finded object
	 * @author Miguel Hernandez
	 */
	public Location findShortestDistance() {		
		Location locationShortest = new Location();		
		try {
			MongoCollection<Document> collection = this.generateDatabaseConnection.generateConnecionCollectionLocation();
			AggregateIterable<Document> resultado = collection.aggregate(Arrays.asList(
					new Document("$sort", new Document("distance", 1)),  
					new Document("$limit", 1)                           
					));
			for (Document doc : resultado) {		        
				locationShortest.setDistance(doc.getDouble("distance"));
				locationShortest.setCountryName(doc.getString("countryName"));	            
			}
		} catch (Exception e) {
			throw new GeneralException(Constants.MENSAJE_ERROR, e.getMessage());
		}
		return locationShortest;
	}
	
	/**
	 * Method for querying the country with the largest distance from where the service was consumed
	 * @return finded object
	 * @author Miguel Hernandez
	 */
	public Location findLargestDistance() {
		Location locationLargest = new Location();		
		try {
			MongoCollection<Document> collection = this.generateDatabaseConnection.generateConnecionCollectionLocation();
			AggregateIterable<Document> resultado = collection.aggregate(Arrays.asList(
					new Document("$sort", new Document("distance", -1)),  
					new Document("$limit", 1)                           
					));
			for (Document doc : resultado) {		        
				locationLargest.setDistance(doc.getDouble("distance"));
				locationLargest.setCountryName(doc.getString("countryName"));	            
			}
		} catch (Exception e) {
			throw new GeneralException(Constants.MENSAJE_ERROR, e.getMessage());
		}
		return locationLargest;
	}
    
    
    
    

}
