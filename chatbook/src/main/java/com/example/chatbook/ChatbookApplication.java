package com.example.chatbook;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
@RequestMapping("/chatbook")
public class ChatbookApplication {

	@Value("${server.port}")
	public String port;
	
	@GetMapping("/chat")
	public String chat() {
		return "Server running on port " + port;
	}
	
	public static void main(String[] args) {
		SpringApplication.run(ChatbookApplication.class, args);
	}

}
