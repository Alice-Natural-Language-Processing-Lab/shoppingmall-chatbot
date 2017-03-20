package com.theamith;

import java.util.Map;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.json.JSONException;

import com.ibm.watson.developer_cloud.conversation.v1.ConversationService;
import com.ibm.watson.developer_cloud.conversation.v1.model.MessageRequest;
import com.ibm.watson.developer_cloud.conversation.v1.model.MessageResponse;

@Path("/shoppingmall")
public class ShoppingMall {
	@POST
	@Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	@Produces({MediaType.TEXT_PLAIN})
	
	public Response doWatson(PostData postData) throws JSONException{
		String result = "Sorry. It seems Greek to me. Please try something else!";
		
		String message = postData.getMessage();
		System.out.println("got message-"+message);
		
		ConversationService service = new ConversationService(ConversationService.VERSION_DATE_2017_02_03);
		System.out.println("WATSON_USERNAME-"+System.getenv("WATSON_USERNAME"));
		System.out.println("WATSON_PASSWORD-"+System.getenv("WATSON_PASSWORD"));
		System.out.println("WATSON_WORKSPACEID-"+System.getenv("WATSON_WORKSPACEID"));
		service.setUsernameAndPassword(System.getenv("WATSON_USERNAME"), System.getenv("WATSON_PASSWORD"));
		Map<String, Object> context = null;
		MessageRequest newMessage = new MessageRequest.Builder().inputText(message).alternateIntents(true).context(context).build();
		MessageResponse response = service.message(System.getenv("WATSON_WORKSPACEID"), newMessage).execute();
		context = response.getContext();
		System.out.println(response);
		if(response != null && response.getText() != null && response.getText().size() != 0){
			System.out.println("Response:"+response.getText().get(0).toString());
			result = response.getText().get(0);
		}
		
		return Response.status(200).entity(result).build();	
	}
}
