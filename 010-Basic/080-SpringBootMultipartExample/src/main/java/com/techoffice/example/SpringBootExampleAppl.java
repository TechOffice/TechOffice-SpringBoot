package com.techoffice.example;

import java.io.File;
import java.nio.charset.StandardCharsets;
import java.util.List;

import lombok.Data;
import org.apache.commons.io.FileUtils;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@EnableAutoConfiguration
public class SpringBootExampleAppl {

	@RequestMapping("/")
    String home() {
        return "Hello World!";
    }
	
	@RequestMapping(value = "/api/testMultipart", method = RequestMethod.POST)
	public Test testMultipart(@RequestPart(value = "files", required = false) List<MultipartFile> files,
					   @RequestPart(value = "content", required = false) Test test){
		try{
			for (MultipartFile file: files){
				File tempFile = File.createTempFile("test", ".tmp");
				file.transferTo(tempFile);
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return test;
	} 
	
	public static void main(String[] args){
        SpringApplication.run(SpringBootExampleAppl.class, args);
	}

}
