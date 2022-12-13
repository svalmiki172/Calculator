package com.eaiesb;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;

@SpringBootTest(classes = CalculatorApplication.class, webEnvironment =SpringBootTest.WebEnvironment.RANDOM_PORT)
public class CalculatorControllerTest {
	
	@Autowired
	private TestRestTemplate template;
	
	@Test
	public void add() throws Exception {		
		ResponseEntity <String> response = template.getForEntity("/add?num1=3&num2=6", String.class);
		assertThat(response.getBody()).isEqualTo ("9");		
	}
	
	@Test
	public void sub() throws Exception {		
		ResponseEntity <String> response = template.getForEntity("/sub?num1=6&num2=3", String.class);
		assertThat(response.getBody()).isEqualTo ("3");		
	}
	
	@Test
	public void mul() throws Exception {		
		ResponseEntity <String> response = template.getForEntity("/mul?num1=3&num2=6", String.class);
		assertThat(response.getBody()).isEqualTo ("18");		
	}
	
	@Test
	public void div() throws Exception {		
		ResponseEntity <String> response = template.getForEntity("/div?num1=12&num2=6", String.class);
		assertThat(response.getBody()).isEqualTo ("2");		
	}

}
