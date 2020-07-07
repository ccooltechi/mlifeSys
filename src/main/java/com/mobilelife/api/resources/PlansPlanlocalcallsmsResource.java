package com.mobilelife.api.resources;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mobilelife.api.services.PlansPlanlocalcallsmsServices;
import com.mobilelife.common.CommonUtils;
import com.mobilelife.controler.mapper.bean.PlansPlanlocalcallsms;
import com.mobilelife.controler.mapper.request.PlansPlanlocalcallsmsRequest;

@Path("/planlocalcallsms")
public class PlansPlanlocalcallsmsResource {
	private static Logger logger = LoggerFactory.getLogger(PlansPlanlocalcallsmsResource.class);
	
    PlansPlanlocalcallsmsServices service = new PlansPlanlocalcallsmsServices();
    CommonUtils commonUtils = new CommonUtils();

    // CRUD -- CREATE operation
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response createNew(PlansPlanlocalcallsmsRequest request) {
        PlansPlanlocalcallsms bean = (PlansPlanlocalcallsms)request.getRequest();
        boolean status = service.createOrUpdate(bean);
        PlansPlanlocalcallsms country = service.getByPlanId(bean.getPlanPrimaryId());
        Response response = commonUtils.buildResponse(country);
        return response;
    }
 
    // CRUD -- READ operation
    @GET
    @Path("/{authtoken}/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getById(@PathParam("id") Integer id) {
        PlansPlanlocalcallsms bean  = service.getByPlanId(id);
        Response response = commonUtils.buildResponse(bean);
        return response;
    }
 
    // CRUD -- UPDATE operation
    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response updateExisting(PlansPlanlocalcallsmsRequest request) {
        PlansPlanlocalcallsms bean = (PlansPlanlocalcallsms)request.getRequest();
        boolean status = service.createOrUpdate(bean);
        PlansPlanlocalcallsms country = service.getByPlanId(bean.getPlanPrimaryId());
        Response response = commonUtils.buildResponse(country);
        return response;
    }
 
}