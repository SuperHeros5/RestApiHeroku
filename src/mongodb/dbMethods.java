package mongodb;

import java.util.ArrayList;


import java.util.List;

import com.mongodb.BasicDBObject;
import com.mongodb.DBCollection;
import com.mongodb.DB;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;

import com.mongodb.util.JSON;

public class dbMethods 
{
	DB db=null;
	//DBCollection coll=null;
	public dbMethods()
	{
	dbConnection dbc=new dbConnection();
	db=dbc.connectiondb();
	 //coll = db.getCollection("busroutes");
	}
	
	public void insert()
	{
		if(db!=null)
		{
	       DBCollection coll = db.getCollection("sample");
           System.out.println("Collection called successfully");
           BasicDBObject doc = new BasicDBObject("title", "rogers").
           append("description", "project").
           append("likes", 1000).
           append("url", "we can do").
           append("by", "neeharika");
		   coll.insert(doc);
		   System.out.println("Document inserted successfully");
        }
		else
		System.out.println("connection failed");
	}	
	public void jsonInsert()
	{
		if(db!=null)
		{
	     DBCollection users = db.getCollection("buses");
         //String ds = "{'name' : 'Jack', 'age' : '30', 'info' : {'dob' : '11-04-2000', 'doj' : '9-9-2012'}} ";
         //users.insert((DBObject) JSON.parse(ds));
	     String place="gachibowli";
         String ds1="{'place':'"+ place+"','timings': [{'time': '9:30AM','routes': [29],'landmark': 'Hyderabad Public School - Opp Taj Vivanta Hotel'},{'time': '8:40AM','routes': [5],'landmark': 'Hyderabad Public School -Opp Taj Vivanta Hotel'}]}";
         users.insert((DBObject) JSON.parse(ds1));
         System.out.println("inserted successfully");
		}
		else
		{
			System.out.println("connection failed");
		}
	}
	public void print()
	{
		 DBCollection coll = db.getCollection("buses");
		 DBCursor cursor = coll.find();
		 try {
		    while(cursor.hasNext()) {
		        System.out.println(cursor.next());
		    }
		 } finally {
		    cursor.close();
		 }
	}
	public DBObject findParticularKey(String place)
	{
		System.out.println(place);
		 DBCollection coll = db.getCollection("busroutes");
		 BasicDBObject query = new BasicDBObject("place", place);
		 DBCursor cursor=null;
		 try {
		 List<DBObject> busList=coll.find(query).toArray();
		 System.out.println("--------------------");
		 for(DBObject list:busList )
		 {
			 //System.out.println(list.get("timings"));
			 BasicDBObject inQuery = (BasicDBObject) list;
			 System.out.println("testing----"+inQuery);
				
				
			 //inQuery.put("timings", new BasicDBObject("$in", doc));
		     
		 }
		 return busList.get(0);
		/* BasicDBObject doc = new BasicDBObject("time", "9:15AM").
         append("routes", new BasicDBObject(41)).
         append("landmark","balapur X roads");
		 query.put("timings", doc);
		 coll.insert(query);
		 System.out.println("--------------------");*/
		 /*try {
			 if(cursor.hasNext())
			 {
				 System.out.println("hai");
			 }*/
		/* cursor = coll.find(query);
		    while(cursor.hasNext()) {
		        System.out.println(cursor.next());
		    }*/
		 } finally {
		   // cursor.close();
		 }
	}
	public DBObject findParticularKeyFrom(String place)
	{
		System.out.println(place);
		 DBCollection coll = db.getCollection("FromAdibatla");
		 BasicDBObject query = new BasicDBObject("place", place);
		 DBCursor cursor=null;
		 try {
		 List<DBObject> busList=coll.find(query).toArray();
		 System.out.println("--------------------");
		 for(DBObject list:busList )
		 {
			 //System.out.println(list.get("timings"));
			 BasicDBObject inQuery = (BasicDBObject) list;
			 System.out.println("testing----"+inQuery);
				
				
			 //inQuery.put("timings", new BasicDBObject("$in", doc));
		     
		 }
		 return busList.get(0);
	 } finally {
	   // cursor.close();
	 }
}
	public DBObject findPlacetime(String place,String time)
	{
		 DBCollection coll = db.getCollection("busroutes");
		 List<DBObject> bustime=null;
		 DBObject listTime=null;
		 //DBObject bustimings=null;
		 BasicDBObject query = new BasicDBObject("place", place);
		 System.out.println(place+"   "+time);
		 List<DBObject> busList=coll.find(query).toArray();
		 System.out.println("--------------------");
		 for(DBObject list:busList )
		 {
			 //System.out.println(list.get("timings"));
			 for (DBObject buslist : busList) {

					bustime = (List<DBObject>) buslist.get("timings");
					for (DBObject bustimings : bustime) {
						System.out.println(bustimings);
						if(bustimings.get("time").equals(time))
						{
							listTime=bustimings;
						}
					}
		     
		 }
		 }
		System.out.println(listTime);
		return listTime;
	}
	public DBObject addNewRoute(String place,String time)
	{
		 DBCollection coll = db.getCollection("buses");
		 List<DBObject> bustime=null;
		 DBObject listTime=null;
		 //DBObject bustimings=null;
		 BasicDBObject query = new BasicDBObject("place", place);
		 DBCursor cursor=null;
		 List<DBObject> busList=coll.find(query).toArray();
		 System.out.println("--------------------");
		 for(DBObject list:busList )
		 {
			 //System.out.println(list.get("timings"));
			 for (DBObject buslist : busList) {

					bustime = (List<DBObject>) buslist.get("timings");
					for (DBObject bustimings : bustime) {
						if(bustimings.get("time").equals(time))
						{
							listTime=bustimings;
						}
					}
		     
		 }
		 }
		System.out.println(listTime);
		return listTime;
	}
	
	public DBObject appendObject()
	{
		DBCollection coll = db.getCollection("buses");
		BasicDBObject query = new BasicDBObject("place", "gachibowli");
		//String s="{'timings': [{'time': '7:00AM','routes': [111],'landmark': 'SP'}]}";
		/*BasicDBObject obj=new BasicDBObject();
		obj.put("time","6:30AM");
		obj.put("routes","[51]");
		obj.put("landmark","X road");
		BasicDBObject update= new BasicDBObject();
		update.put("$push",new BasicDBObject("timings",obj));
		coll.update(query,update);*/
		
		List<DBObject> busList=coll.find(query).toArray();
        //System.out.println(busList);
		/*for (DBObject buslist : busList) {
			List<DBObject> bustime = (List<DBObject>) buslist.get("timings");
			for (DBObject bustimings : bustime) {
				System.out.println("time = " + bustimings.get("time"));
				
				System.out.println("route = " + bustimings.get("route"));
				System.out.println("land mark = " + bustimings.get("landmark"));
			}
		}*/
		System.out.println(busList);
		
		/* cursor = coll.find(query);
       while(cursor.hasNext()) {
    System.out.println(cursor.next());*/
		System.out.flush();
		return busList.get(0);
		 
		}	
	
	/*public static void main(String args[])
	{
		dbMethods dbm=new dbMethods();
		dbm.insert();
	}*/
	
	public List<String> getPlaces(){
		DBCollection coll = db.getCollection("busroutes");
		List<String> places=new ArrayList<String>();
		BasicDBObject empty = new BasicDBObject();
		BasicDBObject queryDocument = new BasicDBObject("place",1).append("_id",0);
		List<DBObject> sourceDocument = coll.find(empty,queryDocument).toArray();
		for(DBObject list:sourceDocument){
			places.add(list.get("place").toString());
		}
		System.out.println(sourceDocument);
		return places;
		
	}
	public void appendRoute(String place, String time, int routes,String landmark)
	{	
		/*BasicDBObject queryDocument = new BasicDBObject("place", place).append("timings.time", time).append("timings.landmark", landmark);
		System.out.println(queryDocument);
		List<DBObject> sourceDocument = coll.find(queryDocument).toArray();
		BasicDBObject elementToArray = new BasicDBObject("timings.routes", routes);
		BasicDBObject pushElement = new BasicDBObject("$push", elementToArray);
	    coll.update(queryDocument, pushElement);
		System.out.println(sourceDocument);
		BasicDBObject query = new BasicDBObject("place", place);
		List<DBObject> query1 = coll.find(query).toArray();
		return query1.get(0);*/
		DBCollection coll = db.getCollection("busroutes");
		 //Document sourceDocument=(Document) coll.findOne(new Document("place",place));
               /* Filters.eq("timings.time", "time"), Filters.eq("timings.landmark", landmark))).first();*/
		//coll.updateOne(new Document("id",1).append("score.mark1", "1").append("score.mark2", "2"),("$set",("score.count","three")));
        //  System.out.println(sourceDocument);
         // return sourceDocument.curr();
		
	}
}
