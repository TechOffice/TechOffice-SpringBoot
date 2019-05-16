package com.techoffice.security.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

public class AuthenticationUtil {

	private AuthenticationUtil(){}
	
	public static Collection<GrantedAuthority> parseAuthorities(String authoritiesStr){
		List<String> authoritiesList = Arrays.asList(authoritiesStr.split(","));
		return authoritiesList.stream().map(SimpleGrantedAuthority::new).collect(Collectors.toList());
	}
	
	public static String getAuthoritiesStr(Collection<? extends GrantedAuthority> authorities){
		List<String> authoritiesList = new ArrayList<String>();
		for (GrantedAuthority authority: authorities){
			authoritiesList.add(authority.getAuthority());
		}
		return String.join(",", authoritiesList);
	}
}
