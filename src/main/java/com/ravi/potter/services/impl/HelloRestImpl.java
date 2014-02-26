package com.ravi.potter.services.impl;


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
import org.springframework.stereotype.Service;

import com.ravi.potter.services.HelloRest;
import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;
import com.wordnik.swagger.annotations.ApiResponse;
import com.wordnik.swagger.annotations.ApiResponses;

@Service
@Path("/life")
@Produces({"application/json"})
@Api(value = "/life", description = "Sample of Life as we know it")
public class HelloRestImpl implements HelloRest {
	
	Logger logger = LoggerFactory.getLogger(HelloRestImpl.class);

	@GET
	@Path("/check/{number}")
	@Produces(MediaType.TEXT_PLAIN)
	@ApiOperation(value = "Check to see if number is Even. Returns true if it is, else it Odd number, duh!", notes = "Provide a number and I will tell you if it is even or odd", response = HelloRestImpl.class)
	@ApiResponses(value = {
	  @ApiResponse(code = 400, message = "Number not supplied"),
	  @ApiResponse(code = 404, message = "Number not found") })
	public Response isEven(@PathParam("number") Long number) {
		logger.info("Number is {}", number);
		return Response.ok().entity((number%2==0)).build();
	}
	
	
	
	@GET
	@Path("/talk/{name}")
	@Produces(MediaType.TEXT_PLAIN)
	@ApiOperation(value = "I will talk to you in Klingon", notes = "Provide a name and I will talk to you in Klingon", response = HelloRestImpl.class)
	@ApiResponses(value = {
	  @ApiResponse(code = 400, message = "Name not supplied")})
	public Response sayHi(@PathParam("name") String name) {
		return Response.ok().entity("nuqneh "+name.trim()+", qaStaH nuq?\n\nTranslation: Hi "+name.trim()+", how are you?").build();
	}

	@PUT
	@Path("/resource/{name}")
	@Produces(MediaType.TEXT_PLAIN)
	@ApiOperation(value = "Add your name to Lottery. Win a date with Fabio", notes = "Provide a name and I will hook you up with Fabio", response = HelloRestImpl.class)
	@ApiResponses(value = {
	  @ApiResponse(code = 400, message = "Name not supplied")})
	public Response hookMeUpWithFabio(@PathParam("name") String name) {
		logger.info("Date with Fabio is confirmed for {}", name);
		return Response.ok().entity(((1 + (int)(Math.random() * ((1000 - 1) + 1))) % 2 == 0) ? "Confirmed Date with Fabio" : "Sorry you are not Fabio\'s type").build();
	}
	
	
	@POST
	@Path("/post/{name}")
	@Produces(MediaType.TEXT_PLAIN)
	@ApiOperation(value = "Post your name and find out if you are Darth Vaders love child", notes = "Provide a name and I will tell you if you are Luke Skywalker", response = HelloRestImpl.class)
	@ApiResponses(value = {
	  @ApiResponse(code = 400, message = "Name not supplied")})
	public Response postToSeeIfIamLuke(@PathParam("name") String name) {
		logger.info("Date with Fabio is confirmed for {}", name);
		return Response.ok().entity(((1 + (int)(Math.random() * ((1000 - 1) + 1))) % 2 == 0) ? "Darth Vader is your father" : "Sorry to say this but you are son of Jar Jar Binks").build();
	}
	

}
