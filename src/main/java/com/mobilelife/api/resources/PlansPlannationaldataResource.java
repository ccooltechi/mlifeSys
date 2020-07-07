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

import com.mobilelife.api.services.PlansPlannationaldataServices;
import com.mobilelife.common.CommonUtils;
import com.mobilelife.controler.mapper.bean.PlansPlannationaldata;
import com.mobilelife.controler.mapper.request.PlansPlannationaldataRequest;

@Path("/planNationaldata")
public class PlansPlannationaldataResource {
	private static Logger logger = LoggerFactory.getLogger(PlansPlannationaldataResource.class);
	
    PlansPlannationaldataServices service = new PlansPlannationaldataServices();
    CommonUtils commonUtils = new CommonUtils();

    // CRUD -- CREATE operation
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response createNew(PlansPlannationaldataRequest request) {
        PlansPlannationaldata bean = (PlansPlannationaldata)request.getRequest();
        boolean status = service.createOrUpdate(bean);
        PlansPlannationaldata country = service.getByPlanId(bean.getPlanPrimaryId());
        Response response = commonUtils.buildResponse(country);
        return response;
    }
 
    // CRUD -- READ operation
    @GET
    @Path("/{authtoken}/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getById(@PathParam("id") Integer id) {
        PlansPlannationaldata bean  = service.getByPlanId(id);
        Response response = commonUtils.buildResponse(bean);
        return response;
    }
 
    // CRUD -- UPDATE operation
    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response updateExisting(PlansPlannationaldataRequest request) {
        PlansPlannationaldata bean = (PlansPlannationaldata)request.getRequest();
        boolean status = service.createOrUpdate(bean);
        PlansPlannationaldata country = service.getByPlanId(bean.getPlanPrimaryId());
        Response response = commonUtils.buildResponse(country);
        return response;
    }
 
}