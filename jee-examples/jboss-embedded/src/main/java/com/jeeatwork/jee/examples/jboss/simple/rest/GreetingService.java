package com.jeeatwork.jee.examples.jboss.simple.rest;

import javax.ejb.Singleton;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;

@Singleton
@Path("/greeting")
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
	