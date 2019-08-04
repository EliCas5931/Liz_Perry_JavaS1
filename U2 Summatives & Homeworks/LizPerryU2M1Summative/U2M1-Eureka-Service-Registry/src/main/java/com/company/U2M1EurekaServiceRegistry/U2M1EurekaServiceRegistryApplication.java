package com.company.U2M1EurekaServiceRegistry;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class U2M1EurekaServiceRegistryApplication {

	public static void main(String[] args) {
		SpringApplication.run(U2M1EurekaServiceRegistryApplication.class, args);
	}

}
