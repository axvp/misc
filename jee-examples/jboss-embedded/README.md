# JBoss Maven Integration

This folder contains an example on how to ues [JBoss/Wildfly](http://wildfly.org/) with [Maven](https://maven.apache.org/) and [JUnit](http://junit.org/) to quickly and easily develop JEE applications.

The goal was to provide an easy way to develop and test JEE components without the need to have a JBoss installed. Primarily for components that provide REST-ful services.

The basis for the examples is the [Getting started Guide](http://arquillian.org/guides/getting_started/) from [Arquillian](http://arquillian.org/).

## Pitfalls
One of the mayor problems encountered was, that I could not test EJBs and REST-ful services in the same Unit test. After testing I found out that I had the wrong client mode as described [here](https://docs.jboss.org/author/display/ARQ/Test+run+modes?_sscc=t).

## Further tests
Examine [ShrinkWrap](https://github.com/shrinkwrap) and how it can aid testing and deployment of JEE applications.

TODO:
See if test of rest service succeedes with:

http://stackoverflow.com/questions/18360596/how-can-i-test-restful-methods-with-arquillian

Problem is with:
	@Deployment(testable = false)
	
=> If set to false the rest service can be tested:

	@Test
	public void create_account_validation_test(@ArquillianResource URL baseURI) {
		System.out.println(baseURI);
	}

=> if set to true the ejb service can  be added:

	@Test
	public void testEJB() {
		String message = this.greetingService.message();
		assertEquals("Hi REST!", message);
	} 


REST-Service access url:
http://localhost:8080/jboss-embedded-web/rest/greeting


Use ShrinkWrap to create whole application:
http://www.hostettler.net/blog/2012/04/05/programmatically-build-web-archives-using-shrinkwrap/


Useful web resources:
http://arquillian.org/blog/2014/07/02/arquillian-extension-rest-1-0-0-Alpha3/
https://github.com/arquillian/arquillian-extension-rest/tree/master/rest-client