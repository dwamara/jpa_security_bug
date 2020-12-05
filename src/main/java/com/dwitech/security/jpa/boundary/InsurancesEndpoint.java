package com.dwitech.security.jpa.boundary;

import javax.annotation.security.PermitAll;
import javax.enterprise.context.RequestScoped;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.SecurityContext;
import java.security.Principal;

@RequestScoped
@Path("/insurances")
public class InsurancesEndpoint {
	@Context private HttpHeaders httpHeaders;
	@Context SecurityContext securityContext;


	@GET
	@PermitAll
	//@RolesAllowed("InsuranceEmployee")
	@Path("/{request}")
	public String retrieve(@PathParam("request") final String request) {
		Principal user = securityContext.getUserPrincipal();
		String name = user != null ? user.getName() : "anonymous";
		System.out.println("NAme: " + name);
		System.out.println("Data from principal: " + securityContext.getUserPrincipal());
		//System.out.println("Name from principal: " + securityContext.getUserPrincipal().getName());
		return request;
	}
}