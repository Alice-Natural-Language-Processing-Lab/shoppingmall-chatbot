package com.theamith;


import javax.ws.rs.Path;

@Path("/webhook")
public class WebHook {
	
	/*when the endpoint is registered as a webhook, it must echo back
	the 'hub.challenge' value it receives in the query arguments*/
	
	/*@Context
	  private HttpServletRequest httpRequest;
	@GET
	
	public Response verify() throws JSONException{
		String hubMode = httpRequest.getParameter("hub.mode");
		String hubChallenge = httpRequest.getParameter("hub.challenge");
		String hubVerificationToken = httpRequest.getParameter("hub.verify_token");
		
		String response = "";
		int status = 0;
		
		if(hubMode.equalsIgnoreCase("subscribe") && !hubChallenge.trim().isEmpty()){
			if(hubVerificationToken.equalsIgnoreCase("2015ht12215")){
				response = hubChallenge;
				status = 200;
			}else{
				response = "Verification token mismatch";
				status = 403;
			}
		}else{
			response = "Hello World";
			status = 200;
		}
		return Response.status(status).entity(response).build();	
	}
	
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	
	public Response webHook() throws JSONException{
		JSONObject json = new JSONObject();
		json.put("message", "Hello!");
		
		String response = "@Produces(\"application/json\") Message: \n \n "+json;
		
		return Response.status(200).entity(response).build();	
	}*/
}
