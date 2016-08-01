package mongodb;

import com.mongodb.MongoClient;


import com.mongodb.MongoException;
import com.mongodb.WriteConcern;

import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;
import com.mongodb.DBCursor;
import com.mongodb.MongoClientURI;

import com.mongodb.ServerAddress;
import java.util.Arrays;
import java.util.List;

public class dbConnection 
{
   DB db=null;
   @SuppressWarnings("deprecation")
public DB connectiondb() 
   {
	
      try{
		
         // To connect to mongodb server
    	  String dbURI = "mongodb://siva:siva@ds015335.mlab.com:15335/busroutes";
         MongoClient mongoClient = new MongoClient( new MongoClientURI(dbURI));
         //MongoClient mongoClient = new MongoClient( "localhost" , 27017 );
         System.out.println(mongoClient);
         // Now connect to your databases
         //db = mongoClient.getDB( "busroutes" );
         
         db = mongoClient.getDB("busroutes");
         //List<String> databases = mongoClient.getDatabaseNames();
         //System.out.println(databases);
        // boolean auth = db.authenticate("siva", "siva".toCharArray());
        // System.out.println(auth);
         System.out.println("Connect to database successfully");
         System.out.println("Authentication:");
         
        }catch(Exception e){
         System.err.println( e.getClass().getName() + ": " + e.getMessage() );
      }
      return db;
   }
}