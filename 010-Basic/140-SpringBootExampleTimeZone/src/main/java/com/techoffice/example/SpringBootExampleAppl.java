package com.techoffice.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
@EnableAutoConfiguration
public class SpringBootExampleAppl {
	
	@RequestMapping("/")
    String home() {
        return "Hello World!";
    }

    @RequestMapping("/getHongKongTimeAsUTC")
    @ResponseBody
    public Model getHongKongTimeAsUTC(){
	    Model model = new Model();
	    model.setModeDate(TimeZoneUtil.convertDateFromTimezoneToUtc(new Date(), TimeZoneUtil.HONGKONG));
	    return model;
    }

    @RequestMapping("/getUtcTimeAsHongKong")
    @ResponseBody
    public Model getUtcTimeAsHongKong(){
        Model model = new Model();
        model.setModeDate(TimeZoneUtil.convertDateFromUtcToTimezone(new Date(), TimeZoneUtil.HONGKONG));
        return model;
    }


    public static void main(String[] args){
        SpringApplication.run(SpringBootExampleAppl.class, args);
	}
}
