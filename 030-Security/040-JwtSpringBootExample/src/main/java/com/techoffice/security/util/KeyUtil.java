package com.techoffice.security.util;

import java.security.Key;
import java.util.Base64;

import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

import io.jsonwebtoken.SignatureAlgorithm;

public class KeyUtil {
	
	private KeyUtil(){}
	
	public static String encodeKey(){
		String encodedKey = Base64.getEncoder().encodeToString(JwtUtil.getSecretKey().getEncoded());
		return encodedKey;
	}
	
	public static Key decodeKey(String encodedKey){
		byte[] decodedKey = Base64.getDecoder().decode(encodedKey);
		SecretKey key = new SecretKeySpec(decodedKey, 0, decodedKey.length, JwtUtil.getSignatureAlgorithm().getJcaName()); 
		return key;
	}
	
	public static void main(String[] args){
		decodeKey("hJ7BegqlMmhvqzCdqLH0wFEfuTu8xR2oe94n/KNyDD0=");
	}
	
}
