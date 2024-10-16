package com.mercadoLibre.geolocalizacion.business;

import org.bson.Document;

import com.mongodb.client.MongoCollection;

public interface IGenerateDatabaseConnection {
	
	/**
	 * Method in charge of making the connection to the database for Location collection.
	 * @return connection to the Location collection
	 * @author Miguel Hernandez
	 */
	public MongoCollection<Document> generateConnecionCollectionLocation();

}
