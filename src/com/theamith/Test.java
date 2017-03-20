package com.theamith;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.json.JSONException;
import org.json.JSONObject;

/*
 * PATH www.someamazonelasticbeanstackurl/webapp/test
 */
@Path("/test")
public class Test {
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	
	public Response sayHello() throws JSONException{
		JSONObject json = new JSONObject();
		json.put("message", "Hello!");
		
		String response = "@Produces(\"application/json\") Message: \n \n "+json;
		
		return Response.status(200).entity(response).build();	
	}
	
	@Path("{m}")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	
	public Response sayWhatEverItSends(@PathParam("m") String message) throws JSONException{
		JSONObject json = new JSONObject();
		json.put("message", message);
		
		String response = "@Produces(\"application/json\") Message: \n \n "+json;
		
		return Response.status(200).entity(response).build();	
	}
	
	@Path("/healthcheck")
    @GET
    @Produces(MediaType.TEXT_HTML)
    public String healthCheck() {
        return Response.Status.OK.name();
    }
}
