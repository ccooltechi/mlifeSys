package com.mobilelife.api.resources;

import java.util.Date;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Context;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

//import com.mobilelife.api.beans.AuthRequest;
//import com.mobilelife.api.beans.AuthResponse;
//import com.mobilelife.api.beans.BillSlasherRequest;
//import com.mobilelife.api.beans.ErrorReposne;
//import com.mobilelife.api.beans.FeedbackRequest;
//import com.mobilelife.api.beans.FilterDeviceResponse;
//import com.mobilelife.api.beans.FilterResponse;
//import com.mobilelife.api.beans.SearchDevicePlanRequest;
//import com.mobilelife.api.beans.SearchPlanRequest;
//import com.mobilelife.api.beans.SearchRequest;
//import com.mobilelife.api.beans.SearchResponse;
import com.mobilelife.common.CommonUtils;
import com.mobilelife.controler.AuthenticationPojo;
//import com.mobilelife.controler.FiltersPojo;
//import com.mobilelife.controler.GenericServicesPojo;
//import com.mobilelife.controler.SearchDevicePlansPojo;
//import com.mobilelife.controler.SearchPlansPojo;
//import com.mobilelife.controler.SlasherSearchPrePaidPlans;
//import com.mobilelife.controler.SlasherSearchPlansPojo;

@Path("/mobile")
public class MobileServices {
	private static Logger logger = LoggerFactory.getLogger(MobileServices.class);
	private static final String text = "status :Server is running \ntime : %s";
    
	@GET
	@Consumes(MediaType.TEXT_PLAIN)
	public Response getText() {
		String response = String.format(text, new Date())+" --  ip = ";
		return Response.status(Response.Status.OK).entity(response).type(MediaType.TEXT_PLAIN).build();
	}
	
//	http://localhost:8080/mlife/api/mobile/auth
//	@POST
//	@Path("/auth")
//	@Produces(MediaType.APPLICATION_JSON)
//	public Response authenticate(AuthRequest credential) {
//		AuthResponse authResponse = buildEmptyAuthResponse();
//		AuthenticationPojo aPojo = new AuthenticationPojo();
//		authResponse = aPojo.authenticate(credential);
//    	CommonUtils commonUtils = new CommonUtils();
//        Response response = commonUtils.buildResponse(authResponse);
//		return response;
//	}
   

}
