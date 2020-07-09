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

import com.mobilelife.api.services.PlansOperatorServices;
import com.mobilelife.common.CommonUtils;
import com.mobilelife.controler.mapper.bean.PlansOperatorBean;
import com.mobilelife.controler.mapper.request.OperatorRequest;

import com.wordnik.swagger.annotations.*;

@Path("/operators")
@Api(value = "/operators", description = "Operators")
@Produces({"application/json", "application/xml"})
public class PlansOperatorResource {
	private static Logger logger = LoggerFactory.getLogger(PlansOperatorResource.class);
	
	PlansOperatorServices service = new PlansOperatorServices();
	CommonUtils commonUtils = new CommonUtils();

    // CRUD -- CREATE operation
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @ApiOperation(produces="application/json", value = "Create New Operator", httpMethod="POST", notes = "<br>This service is used for creating new operator", response = PlansOperatorBean.class)
    @ApiResponses(value = { @ApiResponse(code = 200,response = PlansOperatorBean.class, message = "Successful operation"),@ApiResponse(code = 400, message = "Bad Request", response = Error.class), @ApiResponse(code = 422, message = "Invalid data", response = Error.class), @ApiResponse(code = 500, message = "Internal Server Error", response = Error.class) })
    public Response createNew(OperatorRequest request) {
    	PlansOperatorBean bean = (PlansOperatorBean)request.getRequest();
    	boolean status = service.createOrUpdate(bean);
        List<PlansOperatorBean> country = service.getAll();
        Response response = commonUtils.buildResponse(country);
		return response;
    }
 
    // CRUD -- READ operation
    @GET
	@Path("/{authtoken}")
    @Produces(MediaType.APPLICATION_JSON)
    @ApiOperation(produces="application/json", value = "Fetch All Operators", httpMethod="GET", notes = "<br>This service fetches all operators", response = PlansOperatorBean.class)
    @ApiResponses(value = { @ApiResponse(code = 200,response = PlansOperatorBean.class, message = "Successful operation"),@ApiResponse(code = 400, message = "Bad Request", response = Error.class), @ApiResponse(code = 422, message = "Invalid data", response = Error.class), @ApiResponse(code = 500, message = "Internal Server Error", response = Error.class) })
	public Response getAll(@PathParam("authtoken") String authtoken)
	{
        List<PlansOperatorBean> bean = service.getAll();
        Response response = commonUtils.buildResponse(bean);
		return response;
	}
 
    // CRUD -- READ operation
    @GET
    @Path("/{authtoken}/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @ApiOperation(produces="application/json", value = "Fetch Operators By operator id", httpMethod="GET", notes = "<br>This service fetches operator by id", response = PlansOperatorBean.class)
    @ApiResponses(value = { @ApiResponse(code = 200,response = PlansOperatorBean.class, message = "Successful operation"),@ApiResponse(code = 400, message = "Bad Request", response = Error.class), @ApiResponse(code = 422, message = "Invalid data", response = Error.class), @ApiResponse(code = 500, message = "Internal Server Error", response = Error.class) })
    public Response getById(@PathParam("id") Integer id) {
    	PlansOperatorBean bean  = service.getById(id);
        Response response = commonUtils.buildResponse(bean);
		return response;
    }
 
    // CRUD -- UPDATE operation
    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @ApiOperation(produces="application/json", value = "Update existing Operator By operator id", httpMethod="PUT", notes = "<br>This service updates existing operator", response = PlansOperatorBean.class)
    @ApiResponses(value = { @ApiResponse(code = 200,response = PlansOperatorBean.class, message = "Successful operation"),@ApiResponse(code = 400, message = "Bad Request", response = Error.class), @ApiResponse(code = 422, message = "Invalid data", response = Error.class), @ApiResponse(code = 500, message = "Internal Server Error", response = Error.class) })
    public Response updateExisting(OperatorRequest request) {
    	PlansOperatorBean bean = (PlansOperatorBean)request.getRequest();
    	boolean status = service.createOrUpdate(bean);
        List<PlansOperatorBean> country = service.getAll();
        Response response = commonUtils.buildResponse(country);
		return response;
    }
 
    // CRUD -- DELETE operation
    @DELETE
    @Path("/{authtoken}/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @ApiOperation(produces="application/json", value = "Delete Operator By operator id", httpMethod="DELETE", notes = "<br>This service delete operator by id", response = PlansOperatorBean.class)
    @ApiResponses(value = { @ApiResponse(code = 200,response = PlansOperatorBean.class, message = "Successful operation"),@ApiResponse(code = 400, message = "Bad Request", response = Error.class), @ApiResponse(code = 422, message = "Invalid data", response = Error.class), @ApiResponse(code = 500, message = "Internal Server Error", response = Error.class) })
    public Response deleteExisting(@PathParam("id") Integer id) {
    	boolean status = service.delete(id);
        List<PlansOperatorBean> bean = service.getAll();
        Response response = commonUtils.buildResponse(bean);
		return response;
    }

}