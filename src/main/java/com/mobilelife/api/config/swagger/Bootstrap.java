package com.mobilelife.api.config.swagger;

import com.wordnik.swagger.model.*;
import com.wordnik.swagger.config.*;
import com.wordnik.swagger.config.FilterFactory;

import javax.servlet.http.HttpServlet;

import java.util.List;
import java.util.ArrayList;

public class Bootstrap extends HttpServlet {
  static {
    // do any additional initialization here, such as set your base path programmatically as such:
    // ConfigFactory.config().setBasePath("http://www.foo.com/");

    // add a custom filter
    FilterFactory.setFilter(new CustomFilter());

    ApiInfo info = new ApiInfo(
      "Alaadin Sys Admin CMS" ,                             /* title */
      "", 
      "",                  /* TOS URL */
      "",                            /* Contact */
      "",                                     /* license */
      "" /* license URL */
    );

    List<AuthorizationScope> scopes = new ArrayList<AuthorizationScope>();
    scopes.add(new AuthorizationScope("email", "Access to your email address"));
    scopes.add(new AuthorizationScope("pets", "Access to your pets"));

    List<GrantType> grantTypes = new ArrayList<GrantType>();

    ImplicitGrant implicitGrant = new ImplicitGrant(
      new LoginEndpoint("http://localhost:9090/oauth/dialog"),
      "access_code");

    grantTypes.add(implicitGrant);

    AuthorizationType oauth = new OAuthBuilder().scopes(scopes).grantTypes(grantTypes).build();

    ConfigFactory.config().addAuthorization(oauth);
    ConfigFactory.config().setApiInfo(info);
  }
}