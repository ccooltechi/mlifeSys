package com.mobilelife.api.resources;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
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

import com.mobilelife.api.services.PlanDevicebrandServices;
import com.mobilelife.common.CommonUtils;
import com.mobilelife.controler.mapper.bean.PlanDevicebrandBean;
import com.mobilelife.controler.mapper.request.PlanDevicebrandRequest;

@Path("/devicebrand")
public class PlanDevicebrandResource {
	private static Logger logger = LoggerFactory.getLogger(PlanDevicebrandResource.class);
	
	PlanDevicebrandServices service = new PlanDevicebrandServices();
    CommonUtils commonUtils = new CommonUtils();

    // CRUD -- CREATE operation
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response createNew(PlanDevicebrandRequest request) {
    	PlanDevicebrandBean bean = (PlanDevicebrandBean)request.getRequest();
        boolean status = service.createOrUpdate(bean);
        List<PlanDevicebrandBean> country = service.getAll();
        Response response = commonUtils.buildResponse(country);
        return response;
    }
 
    // CRUD -- READ operation
    @GET
    @Path("/{authtoken}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAll(@PathParam("authtoken") String authtoken)
    {
        List<PlanDevicebrandBean> bean = service.getAll();
        Response response = commonUtils.buildResponse(bean);
        return response;
    }
 
    // CRUD -- READ operation
    @GET
    @Path("/{authtoken}/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getById(@PathParam("id") Integer id) {
    	PlanDevicebrandBean bean  = service.getById(id);
        Response response = commonUtils.buildResponse(bean);
        return response;
    }
 
    // CRUD -- UPDATE operation
    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response updateExisting(PlanDevicebrandRequest request) {
    	PlanDevicebrandBean bean = (PlanDevicebrandBean)request.getRequest();
        boolean status = service.createOrUpdate(bean);
        List<PlanDevicebrandBean> country = service.getAll();
        Response response = commonUtils.buildResponse(country);
        return response;
    }
 
    // CRUD -- DELETE operation
    @DELETE
    @Path("/{authtoken}/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response deleteExisting(@PathParam("id") Integer id) {
        boolean status = service.delete(id);
        List<PlanDevicebrandBean> bean = service.getAll();
        Response response = commonUtils.buildResponse(bean);
        return response;
    }
 
}