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

import com.mobilelife.api.services.PlansPlaninternationalminutesServices;
import com.mobilelife.common.CommonUtils;
import com.mobilelife.controler.mapper.bean.PlansPlaninternationalminutes;
import com.mobilelife.controler.mapper.request.PlansPlaninternationalminutesRequest;

@Path("/planInternationalminutes")
public class PlansPlaninternationalminutesResource {
	private static Logger logger = LoggerFactory.getLogger(PlansPlaninternationalminutesResource.class);

    PlansPlaninternationalminutesServices service = new PlansPlaninternationalminutesServices();
    CommonUtils commonUtils = new CommonUtils();

    // CRUD -- CREATE operation
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response createNew(PlansPlaninternationalminutesRequest request) {
        PlansPlaninternationalminutes bean = (PlansPlaninternationalminutes)request.getRequest();
        boolean status = service.createOrUpdate(bean);
        PlansPlaninternationalminutes country = service.getByPlanId(bean.getPlanPrimaryId());
        Response response = commonUtils.buildResponse(country);
        return response;
    }
 
    // CRUD -- READ operation
    @GET
    @Path("/{authtoken}/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getById(@PathParam("id") Integer id) {
        PlansPlaninternationalminutes bean  = service.getByPlanId(id);
        Response response = commonUtils.buildResponse(bean);
        return response;
    }
 
    // CRUD -- UPDATE operation
    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response updateExisting(PlansPlaninternationalminutesRequest request) {
        PlansPlaninternationalminutes bean = (PlansPlaninternationalminutes)request.getRequest();
        boolean status = service.createOrUpdate(bean);
        PlansPlaninternationalminutes country = service.getByPlanId(bean.getPlanPrimaryId());
        Response response = commonUtils.buildResponse(country);
        return response;
    }
 
}