package com.techoffice;

import ch.qos.logback.core.util.TimeUtil;
import com.techoffice.service.TestService;
import com.techoffice.service.TestServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.stubbing.Answer;
import org.powermock.api.mockito.PowerMockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.ImportAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.*;
import org.springframework.integration.dsl.StandardIntegrationFlow;
import org.springframework.integration.dsl.context.IntegrationFlowContext;
import org.springframework.integration.test.context.MockIntegrationContext;
import org.springframework.integration.test.context.SpringIntegrationTest;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageHandler;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.atLeast;
import static org.powermock.api.mockito.PowerMockito.when;
import static org.springframework.integration.test.mock.MockIntegration.mockMessageHandler;

@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest(
        webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT,
        classes = {Application.class, IntegrationConfigTest.MockBeanConfig.class})
@SpringIntegrationTest(noAutoStartup = {"*SourcePollingChannelAdapter*"})
public class IntegrationConfigTest {

    @Autowired
    private TestService testService;

    @Autowired
    private StandardIntegrationFlow printUpperCase;

    @Autowired
    private IntegrationFlowContext integrationFlowContext;

    @Autowired
    private MockIntegrationContext mockIntegrationContext;

    @TestConfiguration
    public static class MockBeanConfig {

        @Bean
        @Primary
        public TestService testService() {
            TestService testService = new TestServiceImpl();
            return PowerMockito.spy(testService);
        }

    }

    @Test
    public void test() throws InterruptedException {
        printUpperCase.start();
        TimeUnit.SECONDS.sleep(30);
    }

}
