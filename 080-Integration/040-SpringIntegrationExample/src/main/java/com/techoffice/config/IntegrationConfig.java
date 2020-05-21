package com.techoffice.config;

import com.techoffice.service.TestFlowErrorHandler;
import com.techoffice.service.TestService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.integration.config.EnableIntegration;
import org.springframework.integration.dsl.*;

import java.util.List;

@Slf4j
@Configuration
@EnableIntegration
public class IntegrationConfig {

    @Autowired
    private TestService testService;

    private TestFlowErrorHandler testFlowErrorHandler;

    @Bean
    public IntegrationFlow testFlow() {
        IntegrationFlow integrationFlow = IntegrationFlows
                .from(testService::getSourceStringList, p -> p.poller(poller()))
                .handle(testService::logSourceStringList)
                .split(e->e.discardFlow(discardFlow()))
                    .handle(testService::handle)
                .aggregate()
                .handle(testService::logSourceStringList2)
                .nullChannel();
        return integrationFlow;
    }

    @Bean
    public PollerSpec poller() {
        return Pollers.fixedDelay(10)
                .advice();
    }

    @Bean
    public IntegrationFlow discardFlow(){
        return f->f.handle(g -> {
            List<String> result = (List<String>) g.getPayload();
            log.info("discard flow: {}");
        });
    }



}
