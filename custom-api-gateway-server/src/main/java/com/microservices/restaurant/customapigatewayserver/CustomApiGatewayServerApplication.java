package com.microservices.restaurant.customapigatewayserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients("com.microservices.restaurant.customapigatewayserver")
public class CustomApiGatewayServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(CustomApiGatewayServerApplication.class, args);
	}

}

