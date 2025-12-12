package com.example.demo;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.http.MediaType;
import org.springframework.restdocs.RestDocumentationContextProvider;
import org.springframework.test.web.servlet.client.RestTestClient;
import org.springframework.web.context.WebApplicationContext;


import static org.assertj.core.api.Assertions.*;

@Import(TestcontainersConfiguration.class)
@SpringBootTest
class DemoApplicationTests {

	RestTestClient client;

	@BeforeEach
	void setUp(WebApplicationContext context, RestDocumentationContextProvider restDocumentation) {
		client = RestTestClient.bindToApplicationContext(context)
				.build();
	}

	@Test
	void shouldFetchHello() {
		client.get()
				.uri("/api/hello")
				.exchange()
				.expectStatus()
				.isOk()
				.expectHeader()
				.contentTypeCompatibleWith(MediaType.TEXT_PLAIN)
				.expectBody(String.class)
				.consumeWith(message -> assertThat(message.getResponseBody()).isEqualTo("Hello World"));
	}
}
