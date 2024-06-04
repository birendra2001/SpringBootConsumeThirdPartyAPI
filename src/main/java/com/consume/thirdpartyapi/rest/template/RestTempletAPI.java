package com.consume.thirdpartyapi.rest.template;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class RestTempletAPI {
	
	@Bean
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}
	
}
