package common;

import java.util.Properties;

import org.bson.Document;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

public class MongoConnection {

	Properties prop;
	
	public MongoConnection()
	{
		prop = PropertiesLoader.initLoad("prod");
	}
	
	public static MongoClient mongoClient = null;

	public MongoDatabase getMongoConnection() {
		
		MongoDatabase db = null;
		
		try{
			// To connect to mongodb server
			String mongoURI = "mongodb://"+prop.getProperty("mongo.username")+ ":" 
									+ prop.getProperty("mongo.password") + "@" 
									+ prop.getProperty("mongo.host")+ ":"
									+ prop.getProperty("mongo.port")+ "/"
									+ prop.getProperty("mongo.db");
			
			//( String mongoURI = "mongodb://" + mongoUser + ":" + mongoPassword + "@" + mongoHost + ":" + mongoPort + "/" + mongoDBName;
		   
			System.out.println("[INFO] Connection string: " + mongoURI);
			MongoClientURI uri = new MongoClientURI(mongoURI);
			mongoClient = new MongoClient(uri);
			// Now connect to your databases
			db = mongoClient.getDatabase( prop.getProperty("mongo.db") );
			System.out.println("Connected to database successfully");
			
		}catch(Exception e){
			System.err.println( e.getClass().getName() + ": " + e.getMessage() );
		}
		
		return db;
	}

	public MongoCollection<Document> getMongoDBCollection(MongoDatabase db, String collection) {	

		MongoCollection<Document> coll = db.getCollection(collection);

		System.out.println("Collection created/selected successfully");
		System.out.println(coll);
		return coll;
	}
}
