package com.techoffice.test;

import lombok.extern.slf4j.Slf4j;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

@Slf4j
public class Verifier {

    private static final String DEFAULT_ALGORITHM = "HMACSHA256";
    private static final String key = "testing";

    public static String sign(String token) throws NoSuchAlgorithmException, InvalidKeyException {
        Mac mac = Mac.getInstance(DEFAULT_ALGORITHM);
        mac.init(new SecretKeySpec(key.getBytes(), DEFAULT_ALGORITHM));
        byte[] result = mac.doFinal(token.getBytes());
        return new String(result);
    }
}
