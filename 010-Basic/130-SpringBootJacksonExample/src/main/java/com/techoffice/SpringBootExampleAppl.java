package com.techoffice;

import com.techoffice.model.BasicData;
import com.techoffice.model.ResponseData;
import com.techoffice.model.ReturnData;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@EnableAutoConfiguration
public class SpringBootExampleAppl {
	
	@RequestMapping("/")
    String home() {
        return "Hello World!";
    }

    @ResponseBody
    @RequestMapping("/test")
    BasicData test(){
	    ResponseData responseData = new ResponseData();
        responseData.setAddress("testing Address");
        responseData.setName("testing Name");
	    return  responseData;
    }

    @ResponseBody
    @RequestMapping("/test2")
    List<BasicData> test2(){
	    List<BasicData> result = new ArrayList<BasicData>();

	    ResponseData responseData = new ResponseData();
        responseData.setAddress("testing Address");
        responseData.setName("testing Name");

        ReturnData returnData = new ReturnData();
        returnData.setName("testing Name in return data");
        returnData.setMessage("testing message");

        result.add(responseData);
	    result.add(returnData);
        return result;
    }

	public static void main(String[] args){
        SpringApplication.run(SpringBootExampleAppl.class, args);
	}
}
