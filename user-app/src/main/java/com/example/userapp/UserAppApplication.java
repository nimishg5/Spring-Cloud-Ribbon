package com.example.userapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.ribbon.RibbonAutoConfiguration;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@RestController
@RequestMapping("/user-app")
@RibbonClient(name="chatbook-lb", configuration=RibbonAutoConfiguration.class)
public class UserAppApplication {
	
	@Autowired
	private RestTemplate restTemplate;
	
	@GetMapping("/start")
	public String startApp() {
		String url = "http://chatbook-lb/chatbook/chat";
		return restTemplate.getForObject(url, String.class);
	}
	
	@Bean
	@LoadBalanced
	public RestTemplate getRestTemplate() {
		return new RestTemplate(); 
	}

	public static void main(String[] args) {
		SpringApplication.run(UserAppApplication.class, args);
	}
}
