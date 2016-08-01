package rest;

import java.util.List;


import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.glassfish.jersey.server.monitoring.RequestEventListener;

import com.mongodb.DBCursor;
import com.mongodb.DBObject;


import mongodb.dbConnection;
import mongodb.dbMethods;


@Path("/helloworld")
public class Restservice{

	@GET
	@Path("/toadibatla")
	@Produces(MediaType.APPLICATION_JSON)
	public Response sayPlainTextHello(@QueryParam("place") String place ) {
		System.out.println(place);
		//hello db=new hello();
		//db.print();
		dbMethods db1=new dbMethods();
		//db1.jsonInsert();
		//db1.print();
		 System.out.println("Hello World");
		    System.out.println(distance(17.456294,78.367759,17.233333,78.55,"K"));
		DBObject busList=db1.findParticularKey(place);
		return Response.status(200).entity(busList)
		.header("Access-Control-Allow-Origin", "*")
		.allow("OPTIONS").build();
	}
	@GET
	@Path("/fromadibatla")
	@Produces(MediaType.APPLICATION_JSON)
	public Response sayPlainTextHello1(@QueryParam("place") String place ) {
		System.out.println(place);
		//hello db=new hello();
		//db.print();
		dbMethods db1=new dbMethods();
		//db1.jsonInsert();
		//db1.print();
		DBObject busList=db1.findParticularKeyFrom(place);
		return Response.status(200).entity(busList)
		.header("Access-Control-Allow-Origin", "*")
		.allow("OPTIONS").build();
	}
	@GET
	@Path("/Time")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getPlaceTime(@QueryParam("place") String place,@QueryParam("time") String time ) {
		System.out.println(place);
		//hello db=new hello();
		//db.print();
		dbMethods db1=new dbMethods();
		//db1.jsonInsert();
		//db1.print();
		DBObject busList= db1.findPlacetime(place,time);
		return Response.status(200).entity(busList)
		.header("Access-Control-Allow-Origin", "*")
		.allow("OPTIONS").build();
	}

	@GET
	@Path("/xml")
	@Produces(MediaType.APPLICATION_JSON)
	public Response sayXMLHello() {
		dbMethods db1=new dbMethods();
		List<String> names=db1.getPlaces();
		return Response.status(200).entity(names)
		.header("Access-Control-Allow-Origin", "*")
		.allow("OPTIONS").build();
	}

	@GET
	@Path("/html")
	@Produces(MediaType.APPLICATION_JSON)
	public void sayHtmlHello(@QueryParam("place") String place,@QueryParam("time") String time,@QueryParam("routes") int routes,@QueryParam("landmark") String landmark) {
		dbMethods db1=new dbMethods();
	/*	DBObject names=*/db1.appendRoute(place,time,routes,landmark);
		/*return Response.status(200).entity(names)
		.header("Access-Control-Allow-Origin", "*")
		.allow("OPTIONS").build();*/
	}
	 private static double distance(double lat1, double lon1, double lat2, double lon2, String unit) {
		    double theta = lon1 - lon2;
		    double dist = Math.sin(deg2rad(lat1)) * Math.sin(deg2rad(lat2)) + Math.cos(deg2rad(lat1)) * Math.cos(deg2rad(lat2)) * Math.cos(deg2rad(theta));
		    dist = Math.acos(dist);
		    dist = rad2deg(dist);
		    dist = dist * 60 * 1.1515;
		    if (unit == "K") {
		        dist = dist * 1.609344;
		    } else if (unit == "N") {
		        dist = dist * 0.8684;
		    }

		    return (dist);
		}

		/*:::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::*/
		/*::    This function converts decimal degrees to radians                        :*/
		/*:::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::*/
		private static double deg2rad(double deg) {
		    return (deg * Math.PI / 180.0);
		}
		private static double rad2deg(double rad) {
		    return (rad * 180 / Math.PI);
		}

}