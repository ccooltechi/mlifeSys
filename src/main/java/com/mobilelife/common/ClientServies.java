package com.mobilelife.common;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class ClientServies {

	private static Logger logger = LoggerFactory.getLogger(ClientServies.class);
	public String baseUri = "http://localhost:8080/PodsAPI/api/";
//	public String baseUri = "http://dev.api.mobiles.life/mlife/api/";
//	public String baseUri = "http://localhost:8080/mlife/api/";

	public String getEndpoint()
	{
		return this.baseUri;
	}
	
	public void setEndpoint(String baseUri)
	{
		this.baseUri = baseUri;
	}
    public String postRequestObject(String target, String inputString) {
        StringBuilder content = new StringBuilder();
        try {
        	logger.debug(target+" \n \t Request \n \t\t"+inputString);
            URL url = new URL(baseUri+target);
            HttpURLConnection httpConnection  = (HttpURLConnection) url.openConnection();
            httpConnection.setDoOutput(true);
            httpConnection.setRequestMethod("POST");
            httpConnection.setRequestProperty("Content-Type", "application/json");
            httpConnection.setRequestProperty("Accept", "application/json");
            DataOutputStream wr = new DataOutputStream(httpConnection.getOutputStream());
            wr.write(inputString.getBytes());
            Integer responseCode = httpConnection.getResponseCode();

            BufferedReader bufferedReader;

            // Creates a reader buffer
            if (responseCode > 199 && responseCode < 300) {
                bufferedReader = new BufferedReader(new InputStreamReader(httpConnection.getInputStream()));
            } else {
                bufferedReader = new BufferedReader(new InputStreamReader(httpConnection.getErrorStream()));
            }

            // To receive the response
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                content.append(line).append("\n");
            }
            bufferedReader.close();

            // Prints the response
            logger.debug(" \n \t Response  \n \t\t"+content.toString());

        } catch (Exception e) {
        	e.printStackTrace();
        }
        return content.toString();
    }
    
	public String postRequestString(String target, String inputString) {
		StringBuilder content = new StringBuilder();
		logger.debug(baseUri+target+" \n \t Request \n \t\t"+inputString);
        try {
            URL url = new URL(baseUri+target+inputString);
	  		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
	  		conn.setDoOutput(true);
	  		conn.setRequestMethod("POST");
	  		conn.setRequestProperty("Content-Type", "application/json");
	
	  		BufferedReader br = new BufferedReader(new InputStreamReader((conn.getInputStream())));
	  		String output;
	  		System.out.println("Output from Server .... \n");
	  		while ((output = br.readLine()) != null) {
	  			content.append(output);
	  		}
	  		conn.disconnect();
        } catch (MalformedURLException e) {
        	e.printStackTrace();
  	  	} catch (IOException e) {
  	  		e.printStackTrace();
  	  	}
        logger.debug("\t Response  \n \t\t"+content.toString());
		return content.toString();
	}
    
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
		logger.debug(responses.getClass().getSimpleName());
		return jsonStr;
	}

	public String convertJsonToString(Object responses, String token, String podsReff)
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
		
		logger.debug(responses.getClass().getSimpleName()+" \n \t Request \n \t\t"+jsonStr);
		return jsonStr;
	}

	
	private void test() {

//		SearchRequest object = new SearchRequest();
//		SearchingCriteria search_criteria = new SearchingCriteria();
//		SearchFilters filters = new SearchFilters();
//		List<DeviceFilters> deviceModels = new ArrayList<DeviceFilters>();
//		List<DeviceFilters> deviceColors = new ArrayList<DeviceFilters>();
//		List<DeviceFilters> deviceMemorys = new ArrayList<DeviceFilters>();
//		DeviceFilters deviceModel = new DeviceFilters();
//		List<DeviceFilter>
//		deviceModel.setDeviceFilter(deviceFilter);
//		DeviceFilters deviceColor = new DeviceFilters();
//		DeviceFilters deviceMemory = new DeviceFilters();
//		
//		deviceModels.add(deviceModel);
//		filters.setDeviceModels(deviceModels);
//		filters.setDeviceColor(deviceColor);
//		filters.setDeviceMemory(deviceMemory);
//		search_criteria.setFilters(filters);
//		object.setSearch_criteria(search_criteria);
//		
//        String target = "authenticate/authRequest/";
//        String inputString = convertJsonToString(object);
//        postRequestObject(target, inputString);
	}
	

	public static void main(String[] args) throws Exception
    {
    	ClientServies authService = new ClientServies();

    	authService.test();
    }

}
