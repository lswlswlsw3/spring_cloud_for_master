package com.sicc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/**
 * application 시작점
 * @author Woongs
 */
// lombok, feign 추가 예정
@SpringBootApplication
@EnableCircuitBreaker
public class MemberApplication {
	
	@LoadBalanced	// load balance 기능을 위해 추가
	@Bean			// micro service 통신 위한 restTemplate 추가
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}
	
	public static void main(String[] args) {
		SpringApplication.run(MemberApplication.class, args);
	}

}
