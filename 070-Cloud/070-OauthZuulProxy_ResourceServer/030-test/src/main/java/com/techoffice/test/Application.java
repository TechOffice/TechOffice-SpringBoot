package com.techoffice.test;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.apache.http.client.fluent.Request;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.message.BasicHeader;
import org.springframework.security.jwt.Jwt;
import org.springframework.security.jwt.JwtHelper;
import org.springframework.security.jwt.crypto.sign.MacSigner;

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

    private static String getResoruceServerResponse(String accessToken) throws IOException {
        String result = Request.Get("http://localhost:19000")
                .addHeader("Authorization", "Bearer " + accessToken)
                .execute().returnContent().asString();
        return result;
    }

    public static void main(String[] args) throws IOException, URISyntaxException, InvalidKeyException, NoSuchAlgorithmException {
        String accessToken = getAccessToken();
        log.info("obtained access token: {}", accessToken);
        String checkedAccessTokenResponse = getCheckedAccessTokenResponse(accessToken);
        log.info("checked access token response: {}", checkedAccessTokenResponse);
        Jwt jwt = JwtHelper.decode(accessToken);
        log.info("jwt encoded content: {}", jwt.getClaims());
        MacSigner macSigner = new MacSigner("testing");
        try{
            jwt.verifySignature(macSigner);
            log.info("valid singing key by jwt verify singuature");
        }catch (Exception e){
            log.error("invalid signing key");
        }
        String resourceServerResponse = getResoruceServerResponse(accessToken);
        log.info("Resource Server Response: {} ", resourceServerResponse);
    }

}
