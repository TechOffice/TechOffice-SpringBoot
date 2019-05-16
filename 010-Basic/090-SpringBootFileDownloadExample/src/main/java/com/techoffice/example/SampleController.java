package com.techoffice.example;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
@EnableAutoConfiguration
public class SampleController {
    
	@RequestMapping("/")
	public String home() {
        return "welcome";
    }
	
	@RequestMapping(value = "/getFile", method = { RequestMethod.POST, RequestMethod.GET }, produces = { MediaType.APPLICATION_OCTET_STREAM_VALUE, MediaType.APPLICATION_JSON_VALUE })
	public HttpEntity<byte[]> getFile() throws IOException{
		File file = new File( SampleController.class.getClassLoader().getResource("data/testing.zip").getFile());
		HttpEntity<byte[]> httpEntity = new HttpEntity<byte[]>(FileUtils.readFileToByteArray(file));
		HttpHeaders headers = new HttpHeaders();
		headers.set(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=" + file.getName());
		headers.set(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_OCTET_STREAM_VALUE);
		return httpEntity;
	}
	
    public static void main(String[] args) throws Exception {
    	SpringApplication.run(SampleController.class, args);
    }

}
