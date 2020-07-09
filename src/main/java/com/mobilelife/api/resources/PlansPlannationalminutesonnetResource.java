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

import com.mobilelife.api.services.PlansPlannationalminutesonnetServices;
import com.mobilelife.common.CommonUtils;
import com.mobilelife.controler.mapper.bean.PlansPlannationalminutesonnetBean;
import com.mobilelife.controler.mapper.request.PlansPlannationalminutesonnetRequest;

@Path("/planNationalonnetminutes")
public class PlansPlannationalminutesonnetResource {
	private static Logger logger = LoggerFactory.getLogger(PlansPlannationalminutesonnetResource.class);
	
    PlansPlannationalminutesonnetServices service = new PlansPlannationalminutesonnetServices();
    CommonUtils commonUtils = new CommonUtils();

    // CRUD -- CREATE operation
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response createNew(PlansPlannationalminutesonnetRequest request) {
        PlansPlannationalminutesonnetBean bean = (PlansPlannationalminutesonnetBean)request.getRequest();
        boolean status = service.createOrUpdate(bean);
        PlansPlannationalminutesonnetBean country = service.getByPlanId(bean.getPlanPrimaryId());
        Response response = commonUtils.buildResponse(country);
        return response;
    }
 
    // CRUD -- READ operation
    @GET
    @Path("/{authtoken}/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getById(@PathParam("id") Integer id) {
        PlansPlannationalminutesonnetBean bean  = service.getByPlanId(id);
        Response response = commonUtils.buildResponse(bean);
        return response;
    }
 
    // CRUD -- UPDATE operation
    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response updateExisting(PlansPlannationalminutesonnetRequest request) {
        PlansPlannationalminutesonnetBean bean = (PlansPlannationalminutesonnetBean)request.getRequest();
        boolean status = service.createOrUpdate(bean);
        PlansPlannationalminutesonnetBean country = service.getByPlanId(bean.getPlanPrimaryId());
        Response response = commonUtils.buildResponse(country);
        return response;
    }
 
}