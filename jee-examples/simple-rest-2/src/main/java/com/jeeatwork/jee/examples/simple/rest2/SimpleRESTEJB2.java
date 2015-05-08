package com.jeeatwork.jee.examples.simple.rest2;

import java.util.Date;

import javax.ejb.Lock;
import javax.ejb.LockType;
import javax.ejb.Singleton;
import javax.ws.rs.GET;
import javax.ws.rs.Path;

@Singleton
@Lock(LockType.READ)
@Path("/ejb2")
public class SimpleRESTEJB2 {
	@GET
	public String ejb() {
		return "ejb2 ok @ " + new Date().toString();
	}
}