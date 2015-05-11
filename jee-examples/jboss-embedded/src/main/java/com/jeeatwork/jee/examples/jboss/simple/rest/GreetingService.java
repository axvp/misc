package com.jeeatwork.jee.examples.jboss.simple.rest;

import javax.ejb.Stateless;
import javax.enterprise.context.Dependent;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Stateless
@Path("/greeting")
@Dependent
@Produces(MediaType.APPLICATION_JSON)
public class GreetingService {

    @GET
    public String message() {
        return "Hi REST!";
    }

    @POST
    public String lowerCase(final String message) {
        return "Hi REST!".toLowerCase();
    }
}
	