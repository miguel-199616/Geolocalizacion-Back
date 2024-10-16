package com.mercadoLibre.geolocalizacion.business.imp;

import org.bson.Document;
import org.springframework.stereotype.Service;

import com.mercadoLibre.geolocalizacion.business.IGenerateDatabaseConnection;
import com.mercadoLibre.geolocalizacion.utilidad.Constants;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

@Service
public class GenerateDatabaseConnectionService implements IGenerateDatabaseConnection {

	/**
	 * {@inheritDoc}
	 */
	@Override
	public MongoCollection<Document> generateConnecionCollectionLocation() {
		MongoClient mongoClient = MongoClients.create(Constants.URL_CONECCTION);
	    MongoDatabase database = mongoClient.getDatabase(Constants.NAME_DATABASE);
	    MongoCollection<Document> collection = database.getCollection(Constants.NAME_COLLECTION_LOCATION);
		return collection;
	}

}
