package com.company.U2M1CloudConfigServer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@SpringBootApplication
@EnableConfigServer
public class U2M1CloudConfigServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(U2M1CloudConfigServerApplication.class, args);
	}

}
