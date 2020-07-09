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

import com.mobilelife.api.services.PlansPlanprimaryServices;
import com.mobilelife.common.CommonUtils;
import com.mobilelife.controler.mapper.bean.PlansPlanprimaryBean;
import com.mobilelife.controler.mapper.request.PlansPlanprimaryRequest;

@Path("/plans")
public class PlansPlanprimaryResource {
	private static Logger logger = LoggerFactory.getLogger(PlansPlanprimaryResource.class);
	
    PlansPlanprimaryServices service = new PlansPlanprimaryServices();
    CommonUtils commonUtils = new CommonUtils();

    // CRUD -- CREATE operation
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response createNew(PlansPlanprimaryRequest request) {
        PlansPlanprimaryBean bean = (PlansPlanprimaryBean)request.getRequest();
        Integer planrefid = service.createOrUpdate(bean);
        PlansPlanprimaryBean country = service.getById(planrefid);
        Response response = commonUtils.buildResponse(country);
        return response;
    }
 
    // CRUD -- READ operation
    @GET
    @Path("/{authtoken}/{operator}/{pageno}/{resultperpage}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getPlanOperatorWiseAll(@PathParam("authtoken") String authtoken, @PathParam("operator") int operator
    		, @PathParam("pageno") int pageno, @PathParam("resultperpage") int resultperpage)
    {
        List<PlansPlanprimaryBean> bean = service.getAll(pageno, resultperpage, operator, 0);
        Response response = commonUtils.buildResponse(bean);
        return response;
    }

    @GET
    @Path("/{authtoken}/{operator}/{plantype}/{pageno}/{resultperpage}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getPlanOperatorPlanTypeWiseAll(@PathParam("authtoken") String authtoken, @PathParam("operator") int operator
    		, @PathParam("plantype") int plantype, @PathParam("pageno") int pageno, @PathParam("resultperpage") int resultperpage)
    {
        List<PlansPlanprimaryBean> bean = service.getAll(pageno, resultperpage, operator, plantype);
        Response response = commonUtils.buildResponse(bean);
        return response;
    }

    // CRUD -- READ operation
    @GET
    @Path("/{authtoken}/{pageno}/{resultperpage}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAll(@PathParam("authtoken") String authtoken, @PathParam("pageno") int pageno, @PathParam("resultperpage") int resultperpage)
    {
        List<PlansPlanprimaryBean> bean = service.getAll(pageno, resultperpage, 0, 0);
        Response response = commonUtils.buildResponse(bean);
        return response;
    }
 

    // CRUD -- READ operation
    @GET
    @Path("/{authtoken}/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getById(@PathParam("id") Integer id) {
        PlansPlanprimaryBean bean  = service.getById(id);
        Response response = commonUtils.buildResponse(bean);
        return response;
    }
 
    // CRUD -- UPDATE operation
    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response updateExisting(PlansPlanprimaryRequest request) {
        PlansPlanprimaryBean bean = (PlansPlanprimaryBean)request.getRequest();
        Integer planrefid = service.createOrUpdate(bean);
        PlansPlanprimaryBean retObj = service.getById(planrefid);
        Response response = commonUtils.buildResponse(retObj);
        return response;
    }
 
    // CRUD -- DELETE operation
    @DELETE
    @Path("/{authtoken}/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response deleteExisting(@PathParam("id") Integer id) {
        boolean status = service.delete(id);
//        List<PlansPlanprimary> bean = service.getAll();
        Response response = commonUtils.buildResponse(status);
        return response;
    }
 
}