package com.claudio.braga.bank.of.america.api.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;

import com.claudio.braga.bank.of.america.domain.model.UrlShortener;
import com.claudio.braga.bank.of.america.domain.model.repository.UrlRepository;
import com.claudio.braga.bank.of.america.domain.service.CreateShortUrlService;

import io.restassured.http.ContentType;

import static io.restassured.module.mockmvc.RestAssuredMockMvc.*;

@WebMvcTest
public class UrlControllerTest {
	
	@Autowired
	private UrlController urlController;
	
	@MockBean
	private UrlRepository urlRepository;
	
	@MockBean
	private UrlShortener urlShortener;
	
	@MockBean
	private CreateShortUrlService createShortUrlService;
	
	@BeforeEach
	public void setup() {
		standaloneSetup(this.urlController);
	}
	
	@Test
	public void shouldReturnSuccess_WhenGetUrls() {
		
		given()
			.accept(ContentType.JSON)
		.when()
			.get("/urls")
		.then()
			.statusCode(HttpStatus.OK.value());
	}
	
	@Test
	public void shouldReturnSuccess_WhenGetUrlsByDescription() {
		
		given()
			.accept(ContentType.JSON)
		.when()
			.get("/urls/description?description=dev")
		.then()
			.statusCode(HttpStatus.OK.value());
	}
	
	@Test
	public void shouldReturnBadRequest_WhenGivenUrl() {
		
		given()
			.accept(ContentType.JSON)
		.when()
			.post("/urls")
		.then()
			.statusCode(HttpStatus.BAD_REQUEST.value());
	}
	
	@Test
	public void shouldReturnNotFund_WhenGetShortLink() {
		
		given()
			.accept(ContentType.JSON)
		.when()
			.get("/urls/customalias/customAlias=10")
		.then()
			.statusCode(HttpStatus.NOT_FOUND.value());
	}

}
