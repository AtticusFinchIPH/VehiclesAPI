package com.udacity.pricing;

import com.udacity.pricing.domain.price.Price;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
//@AutoConfigureMockMvc
public class PricingServiceApplicationTests {
	@LocalServerPort
	private int port;
	@Autowired
	private TestRestTemplate restTemplate;

	@Test
	public void contextLoads() {}

	@Test
	public void get() {
		ResponseEntity<Price> okResponse = this.restTemplate.getForEntity("http://localhost:" + port + "/services/price?vehicleId=2", Price.class);
		assertEquals(okResponse.getStatusCode(), HttpStatus.OK);
		ResponseEntity<Price> notfoundResponse = this.restTemplate.getForEntity("http://localhost:" + port + "/services/price?vehicleId=21", Price.class);
		assertEquals(notfoundResponse.getStatusCode(), HttpStatus.NOT_FOUND);
	}


}
