package com.techoffice.example.controller;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/github")
public class GithubController {

    private static final String clientId = "2049f225422b053f5980";
    private static final String clientSecret = "f03aaacddaec4920fd523983c398f15fe3ec9da0";
    private static final String userInfoUrl = "https://api.github.com/user";
    private static final String accessTokenUrl = "https://github.com/login/oauth/access_token";

    @Data
    private static class OauthAccessToken {

        @JsonProperty("access_token")
        private String accessToken;

    }

    @Autowired
    private RestTemplate restTemplate;

    private OauthAccessToken getOAuthAccessToken(String code){
        HttpHeaders headers = new HttpHeaders();
        headers.add("Accept", "application/json");
        Map<String, String> params = new HashMap<>();
        params.put("client_id", clientId);
        params.put("client_secret", clientSecret);
        params.put("code", code);
        HttpEntity<Map> request = new HttpEntity<>(params, headers);
        OauthAccessToken accessTokenReponse = this.restTemplate.postForObject(accessTokenUrl, request, OauthAccessToken.class);
        return accessTokenReponse;
    }

    private String getUserInfo(String accessToken){
        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", "token " + accessToken);
        HttpEntity<String> entity = new HttpEntity<String>("", headers);
        return this.restTemplate.exchange(userInfoUrl, HttpMethod.GET, entity, String.class).getBody();
    }

    @RequestMapping("login")
    @ResponseBody
    public String login(@RequestParam("code") String code){
       OauthAccessToken oauthAccessToken =  getOAuthAccessToken(code);
       String userInfo = getUserInfo(oauthAccessToken.getAccessToken());
       return userInfo;
    }
}
