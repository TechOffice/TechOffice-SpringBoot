package com.techoffice.example;

import java.awt.Desktop;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@EnableAutoConfiguration
public class SpringBootExampleAppl {
	
	@RequestMapping("/")
    String home() {
        return "Hello World!";
    }
	
	public static void main(String[] args) throws IOException, URISyntaxException{
        ConfigurableApplicationContext context = new SpringApplicationBuilder(SpringBootExampleAppl.class).headless(false).run(args);
    	Desktop desktop = Desktop.getDesktop();
		desktop.browse(new URI("http://localhost:8080"));
    }
}
