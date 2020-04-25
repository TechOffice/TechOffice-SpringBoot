package com.techoffice.test;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.apache.http.client.fluent.Request;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.message.BasicHeader;

import java.io.IOException;
import java.net.URISyntaxException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

@Slf4j
public class Application {
    private static String getAccessToken() throws IOException {
        String result = Request.Post("http://client:secret@localhost:8080/oauth/token")
                .bodyForm(
                        new BasicHeader("grant_type", "password"),
                        new BasicHeader("username", "user"),
                        new BasicHeader("password", "password"))
                .execute().returnContent().asString();
        log.info("access token response: {}", result);
        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode accessTokenNode = objectMapper.readTree(result).get("access_token");
        String accessToken = accessTokenNode.asText();
        return accessToken;
    }

    private static String getCheckedAccessTokenResponse(String accessToken) throws IOException, URISyntaxException {
        URIBuilder builder = new URIBuilder("http://user:password@localhost:8080/oauth/check_token/");
        builder.addParameter("token", accessToken);
        String url = builder.build().toURL().toString();
        log.info("check token url: {}", url);

        String result = Request.Get(url)
                .execute().returnContent().asString();
        return result;
    }

    public static void main(String[] args) throws IOException, URISyntaxException, InvalidKeyException, NoSuchAlgorithmException {
        String accessToken = getAccessToken();
        log.info("obtained access token: {}", accessToken);
        String checkedAccessTokenResponse = getCheckedAccessTokenResponse(accessToken);
        log.info("checked access token response: {}", checkedAccessTokenResponse);
        String result = Verifier.sign(accessToken);
        System.out.println(result);
    }

}
