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

import com.mobilelife.api.services.CountriesService;
import com.mobilelife.common.CommonUtils;
import com.mobilelife.controler.mapper.bean.CountriesBean;
import com.mobilelife.persistance.entities.Countries;

@Path("/country")
public class CountryResource {
	private static Logger logger = LoggerFactory.getLogger(CountryResource.class);

	CountriesService service = new CountriesService();
	CommonUtils commonUtils = new CommonUtils();

    // CRUD -- CREATE operation
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response createUser(Countries countries) {
    	boolean status = service.createOrUpdate(countries);
        List<CountriesBean> country = service.getAll();
        Response response = commonUtils.buildResponse(country);
		return response;
    }
 
    // CRUD -- READ operation
    @GET
	@Path("/{authtoken}")
    @Produces(MediaType.APPLICATION_JSON)
	public Response getAllCountries(@PathParam("authtoken") String authtoken)
	{
        List<CountriesBean> bean = service.getAll();
        Response response = commonUtils.buildResponse(bean);
		return response;
	}
 
    // CRUD -- READ operation
    @GET
    @Path("/{authtoken}/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getCountryForId(@PathParam("id") Integer id) {
    	CountriesBean bean  = service.getById(id);
        Response response = commonUtils.buildResponse(bean);
		return response;
    }
 
    // CRUD -- UPDATE operation
    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response updateUser(Countries countries) {
    	boolean status = service.createOrUpdate(countries);
        List<CountriesBean> country = service.getAll();
        Response response = commonUtils.buildResponse(country);
		return response;
    }
 
    // CRUD -- DELETE operation
    @DELETE
    @Path("/{authtoken}/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response deleteeUser(@PathParam("id") Integer id) {
    	boolean status = service.delete(id);
        List<CountriesBean> bean = service.getAll();
        Response response = commonUtils.buildResponse(bean);
		return response;
    }
}
