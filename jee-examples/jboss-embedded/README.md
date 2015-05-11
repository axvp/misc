Examples derived from here:

http://arquillian.org/guides/getting_started/


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