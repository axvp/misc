package com.jeeatwork.microservices.spring.boot.swagger;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.boot.test.TestRestTemplate;
import org.springframework.boot.test.WebIntegrationTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.client.RestTemplate;

import com.jeeatwork.microservices.spring.boot.swagger.SwaggerSpringBootSampleApplication;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = SwaggerSpringBootSampleApplication.class)
@WebIntegrationTest({ "server.port=9999", "management.port=0" })
public class SampleApplicationTest {

	private RestTemplate restTemplate = new TestRestTemplate();

	@Test
	public void test1() {
		ResponseEntity<String> response = restTemplate.getForEntity("http://localhost:9999/helloworld", String.class);
		assertEquals(response.getStatusCode(), HttpStatus.OK);
		assertEquals("Hello World!", response.getBody());
	}

}
