package com.mobilelife.api.config.swagger;

import com.wordnik.swagger.core.filter.SwaggerSpecFilter;
import com.wordnik.swagger.model.*;

public class CustomFilter implements SwaggerSpecFilter {
  @Override
  public boolean isOperationAllowed(
    Operation operation,
    ApiDescription api, 
    java.util.Map<String, java.util.List<String>> params, 
    java.util.Map<String, String> cookies, 
    java.util.Map<String, java.util.List<String>> headers) {
    return true;
  }

  @Override
  public boolean isParamAllowed(
    Parameter parameter, 
    Operation operation, 
    ApiDescription api,
    java.util.Map<String, java.util.List<String>> params, 
    java.util.Map<String, String> cookies,
    java.util.Map<String, java.util.List<String>>  headers) {
    return true;
  }
}