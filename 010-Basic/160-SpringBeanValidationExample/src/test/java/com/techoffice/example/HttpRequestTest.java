package com.techoffice.example;

import com.techoffice.example.model.TestModel;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT,
        classes = SpringBootExampleAppl.class)
public class HttpRequestTest {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void echoTestModel_ok() {
        TestModel requestTestModel = new TestModel();
        requestTestModel.setAddress1("Testing Address");
        ResponseEntity<TestModel> response = this.restTemplate.postForEntity(
                "http://localhost:" + port + "/echoTestModel", requestTestModel, TestModel.class);
        Assert.assertEquals(HttpStatus.OK, response.getStatusCode());
    }

    @Test
    public void echoTestModel_notOk() {
        TestModel requestTestModel = new TestModel();
        ResponseEntity<TestModel> response = this.restTemplate.postForEntity(
                "http://localhost:" + port + "/echoTestModel", requestTestModel, TestModel.class);
        Assert.assertNotEquals(HttpStatus.OK, response.getStatusCode());
    }

    @Test
    public void echoTestModel_notOk_getterValidaton() {
        TestModel requestTestModel = new TestModel();
        requestTestModel.setAddress1("Testing Address");
        requestTestModel.setAddress2("Testing Address");
        ResponseEntity<TestModel> response = this.restTemplate.postForEntity(
                "http://localhost:" + port + "/echoTestModel", requestTestModel, TestModel.class);
        Assert.assertEquals(HttpStatus.OK, response.getStatusCode());
    }
}
