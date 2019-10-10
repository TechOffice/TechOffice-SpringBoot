package com.techoffice.security.util;

import java.security.Key;
import java.util.Collection;
import java.util.Date;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;

public class JwtUtil {
	
	private static final SignatureAlgorithm signatureAlgorithm = SignatureAlgorithm.HS256;

	private static Key secretKey = Keys.secretKeyFor(signatureAlgorithm);
	
	public static Key getSecretKey(){
		return JwtUtil.secretKey;
	}
	
	public static void setSecretKey(Key key){
		JwtUtil.secretKey = key;
	}
	
	public static SignatureAlgorithm getSignatureAlgorithm(){
		return JwtUtil.signatureAlgorithm;
	}
	
	public static Claims parseClaims(String token){
		Claims claims = Jwts.parser().setSigningKey(secretKey).parseClaimsJws(token).getBody();
		return claims;
	}
	
	public static Authentication parseAuthentication(String token){
		Claims claims = parseClaims(token);
		String username = claims.getSubject();
		if (username != null){
			String authoritiesStr = claims.get("authorities").toString();
			Collection<GrantedAuthority> authorities = AuthenticationUtil.parseAuthorities(authoritiesStr);
			UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(username, null, authorities);
			return authToken;
		}
		return null;
	}
	
	public static String buildToken(Authentication authentication){
		JwtBuilder jwtBuilder = Jwts.builder();
		jwtBuilder.setSubject(authentication.getName());
		String authoritiesStr = AuthenticationUtil.getAuthoritiesStr(authentication.getAuthorities());
		jwtBuilder.claim("authorities", authoritiesStr);
		Long now = System.currentTimeMillis();
		jwtBuilder.setIssuedAt(new Date(now));
		jwtBuilder.setExpiration(getExpireDate(now));
		jwtBuilder.signWith(getSecretKey());
		return jwtBuilder.compact();
	}
	
	public static Date getExpireDate(Long date){
		Long expirationMinutes = 5L;
		Long expiration = expirationMinutes * 60 * 1000;
		return new Date(date + expiration);
	}


}
