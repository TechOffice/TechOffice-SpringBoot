package com.techoffice.example;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.techoffice.example.aware.AuditorAwareImpl;

@EnableJpaAuditing
@SpringBootApplication
public class Appl extends WebMvcConfigurerAdapter {
	
	private static final Logger log = LoggerFactory.getLogger(Appl.class);

	@Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry
          .addResourceHandler("/webjars/**")
          .addResourceLocations("/webjars/");
    }
	
	@Bean
	public AuditorAware<String> auditorProvider() {
	    return new AuditorAwareImpl();
	}

	public static void main(String[] args) throws Exception {
		SpringApplication.run(Appl.class, args);
	}

}
