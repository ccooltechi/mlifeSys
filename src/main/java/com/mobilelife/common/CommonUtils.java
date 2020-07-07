package com.mobilelife.common;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.gson.Gson;

public class CommonUtils {
	private static Logger logger = LoggerFactory.getLogger(CommonUtils.class);

	public String convertJsonToString(Object responses)
	{
		ObjectMapper Obj = new ObjectMapper(); 
		String jsonStr ="{\"tokenID\":\"000\",\"status\":\"FORBIDDEN\"}";
		
		try {
			jsonStr = Obj.writeValueAsString(responses);
		} catch (JsonGenerationException e) {
			jsonStr ="{\"tokenID\":\"001\",\"status\":\"FORBIDDEN\"}";
			e.printStackTrace();
		} catch (JsonMappingException e) {
			jsonStr ="{\"tokenID\":\"002\",\"status\":\"FORBIDDEN\"}";
			e.printStackTrace();
		} catch (IOException e) {
			jsonStr ="{\"tokenID\":\"003\",\"status\":\"FORBIDDEN\"}";
			e.printStackTrace();
		} 
		
        logger.debug("CommonUtils convertJsonToString for "+responses.getClass().getName()+" =  "+jsonStr);
		return jsonStr;
	}

//	public SearchRequest convertJsonToObject(String jsonStr)
//	{
//		Gson gson = new Gson(); 
//		SearchRequest searchRequest = gson.fromJson(jsonStr, SearchRequest.class);
//		
//		return searchRequest;
//	}
	
	public Response buildResponse(Object responses) {
		String jsonStr = convertJsonToString(responses);
		System.out.println("jsonStr  "+jsonStr);
		return Response.status(Response.Status.OK.getStatusCode()).type(MediaType.APPLICATION_JSON)
               .entity(jsonStr).build();
	}
	public String buildString(Object responses) {
		String jsonStr = convertJsonToString(responses);
		return jsonStr;
	}
	

	public void showRequestAttributes(HttpServletRequest request) {
	    	new ClientInfo().printClientInfo(request);
	}

	public static void main(String[] args)
	{
	}

}
