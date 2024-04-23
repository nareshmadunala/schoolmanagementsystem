package com.naresh.schoolmanagement.discovery;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication
public class RegistryDiscoveryApplication {

	public static void main(String[] args) {
		SpringApplication.run(RegistryDiscoveryApplication.class, args);
	}

}
