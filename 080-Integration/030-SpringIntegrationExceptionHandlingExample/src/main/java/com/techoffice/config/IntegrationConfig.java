package com.techoffice.config;

import com.techoffice.service.TestService;
import com.techoffice.service.TestServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.integration.config.EnableIntegration;
import org.springframework.integration.dsl.IntegrationFlow;
import org.springframework.integration.dsl.IntegrationFlows;
import org.springframework.integration.dsl.Pollers;

@Configuration
@EnableIntegration
public class IntegrationConfig {

    @Autowired
    private TestService testService;

    @Bean
    public IntegrationFlow printUpperCase() {
        IntegrationFlow integrationFlow = IntegrationFlows
                .from(testService::getSourceStringList, p -> p.poller(Pollers.fixedDelay(10)))
                .split()
                .<String, String>transform(String::toUpperCase)
                .handle(testService::handle)
                .handle(testService::handle1)
                .get();
        return integrationFlow;
    }


}
