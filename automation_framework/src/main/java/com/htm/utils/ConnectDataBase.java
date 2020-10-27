package com.htm.utils;

import static com.htm.utils.Constants.CONCISHARE_STG_DATABASENAME;
import static com.htm.utils.Constants.MONGO_DB_URL;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.bson.Document;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;

/**
 * This class contains mongo-db connect
 * 
 * @author Bharat Puri
 *
 */
public class ConnectDataBase {
	static Properties config = ConfigurationUtil.getConfig();
	MongoClient mongoClient;

	static Logger log = Logger.getLogger(ConnectDataBase.class);

	/**
	 * Connect to the Mongo-db based on database URL
	 * 
	 * @return client
	 */
	public static MongoClient createMongoClient() {
		MongoClient mongo = new MongoClient(new MongoClientURI(
				config.getProperty(MONGO_DB_URL)));
		log.info("Connected to the Database successfully");
		return mongo;
	}

	/**
	 * Access the database based on database name
	 * 
	 * @return database
	 */
	public MongoDatabase accessConcishareStgDatabase() {
		mongoClient = createMongoClient();
		log.info("Access to the Database successfully");
		return mongoClient.getDatabase(config
				.getProperty(CONCISHARE_STG_DATABASENAME));

		//
		// MongoClient mongoClient;
		// MongoDatabase database;
		// mongoClient = this.createMongoClient();
		// return database = mongoClient.getDatabase(config
		// .getProperty(CONCISHARE_STG_DATABASENAME));

	}

	/**
	 * Return provider id based on phone number from Provider collection
	 * 
	 * @param phoneNumber
	 * @return providerID
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public String getProviderIDBasadOnPhoneNumber(String phoneNumber) {
		Object providerID = null;
		MongoDatabase database;
		database = accessConcishareStgDatabase();
		MongoCollection<Document> col = database.getCollection("providers");

		try (MongoCursor<Document> cur = col.find().iterator()) {
			while (cur.hasNext()) {

				Document doc = cur.next();

				List list = new ArrayList(doc.values());
				if (list.get(6).equals(phoneNumber)) {
					providerID = list.get(0);
				}
			}
		}
		mongoClient.close();
		return providerID.toString();
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public String getOrderIdBasedOnProviderId(String providerId) {
		Object orderId = null;
		MongoDatabase database;
		database = accessConcishareStgDatabase();
		MongoCollection<Document> col = database
				.getCollection("backgroundchecks");

		try (MongoCursor<Document> cur = col.find().iterator()) {
			while (cur.hasNext()) {

				Document doc = cur.next();

				List list = new ArrayList(doc.values());
				if (list.get(3).equals(providerId)) {
					orderId = list.get(5);
				}
			}
		}
		mongoClient.close();
		return orderId.toString();
	}

}
