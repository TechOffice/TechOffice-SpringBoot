package com.techoffice.example;

import java.io.File;
import java.nio.charset.StandardCharsets;

import org.apache.commons.io.FileUtils;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.techoffice.example.model.Staff;

@RestController
@EnableAutoConfiguration
public class SpringBootExampleAppl {
	
	@RequestMapping("/")
    String home() {
        return "Hello World!";
    }
	
	@RequestMapping("/testMultipart")
	String testMultipart(@RequestPart("profilePic") MultipartFile file, @RequestPart("data") Staff staff){
		try{
			File tempFile = File.createTempFile("test", ".tmp");
			file.transferTo(tempFile);
			String content = FileUtils.readFileToString(tempFile, StandardCharsets.UTF_8);
			return content;
		}catch(Exception e){
			e.printStackTrace();
		}
		return "done";
	} 
	
	public static void main(String[] args){
        SpringApplication.run(SpringBootExampleAppl.class, args);
	}
}
