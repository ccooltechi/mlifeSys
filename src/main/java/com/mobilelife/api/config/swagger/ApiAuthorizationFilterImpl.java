package com.mobilelife.api.config.swagger;

import com.wordnik.swagger.model.*;
import com.wordnik.swagger.core.filter.SwaggerSpecFilter;

import org.slf4j.*;

import java.util.Map;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.http.HttpServlet;

public class ApiAuthorizationFilterImpl  implements SwaggerSpecFilter {
	
	static Logger logger = LoggerFactory.getLogger(ApiAuthorizationFilterImpl.class);

	  public boolean isOperationAllowed(Operation operation, ApiDescription api, Map<String, List<String>> params, Map<String, String> cookies, Map<String, List<String>> headers) {
	    boolean isAuthorized = checkKey(params, headers);
	    if(isAuthorized) {
	      return true;
	    }
	    else {
	      if(!"GET".equals(operation.method()) || api.path().indexOf("/store") != -1) {
	        return false;
	      }
	      else return true;
	    }
	  }

	  public boolean isParamAllowed(Parameter parameter, Operation operation, ApiDescription api, Map<String, List<String>> params, Map<String, String> cookies, Map<String, List<String>> headers) {
	    boolean isAuthorized = checkKey(params, headers);
	    if((parameter.paramAccess().isDefined() && parameter.paramAccess().get().equals("internal")) && !isAuthorized) 
	      return false;
	    else 
	      return true;
	  }

	  public boolean checkKey(Map<String, List<String>> params, Map<String, List<String>> headers) {
	    String keyValue = null;
	    if(params.containsKey("api_key"))
	      keyValue = params.get("api_key").get(0);
	    else {
	      if(headers.containsKey("api_key"))
	        keyValue = headers.get("api_key").get(0);
	    }
	    if("special-key".equals(keyValue))
	      return true;
	    else
	      return false;
	  }
	}