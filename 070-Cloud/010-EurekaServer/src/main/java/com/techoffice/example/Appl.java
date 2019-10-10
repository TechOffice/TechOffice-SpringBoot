package com.techoffice.example;

import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;


@SpringBootApplication
@EnableEurekaServer
public class Appl {

	public static void main(String[] args){
		new SpringApplicationBuilder(Appl.class).web(WebApplicationType.SERVLET).run(args);
	}

}
