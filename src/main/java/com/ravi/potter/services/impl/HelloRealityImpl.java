package com.ravi.potter.services.impl;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.springframework.stereotype.Service;

import com.ravi.potter.services.HelloReality;
import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;
import com.wordnik.swagger.annotations.ApiResponse;
import com.wordnik.swagger.annotations.ApiResponses;

@Service
@Path("/reality")
@Produces(MediaType.TEXT_PLAIN)
@Api(value = "/reality", description = "Sample of Reality as we know it")
public class HelloRealityImpl implements HelloReality {

	@GET
	@Path("/check/{name}")
	@Produces(MediaType.TEXT_PLAIN)
	@ApiOperation(value = "Check to see if where your life would end up", notes = "Provide a name and I will tell you if you are going to be rich or not", response = HelloRealityImpl.class)
	@ApiResponses(value = {
	  @ApiResponse(code = 400, message = "Name not supplied"),
	  @ApiResponse(code = 404, message = "Name not found") })
	public Response getRealityBlues(@PathParam("name") String name) {
		System.out.println("Name is: "+ name);
		return Response.ok().entity(((1 + (int)(Math.random() * ((1000 - 1) + 1))) % 2 == 0) ? "You will be on welfare, sorry buddy" : "You will fire Donald Trump").build();
	}

}
