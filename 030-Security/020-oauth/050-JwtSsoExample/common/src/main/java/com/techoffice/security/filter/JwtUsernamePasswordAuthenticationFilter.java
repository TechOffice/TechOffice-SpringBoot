package com.techoffice.security.filter;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.stereotype.Component;

import com.techoffice.security.model.UserCredentials;
import com.techoffice.security.util.JsonUtil;
import com.techoffice.security.util.JwtUtil;

/**
 * 
 * @author Ben Cheng
 *
 */
public class JwtUsernamePasswordAuthenticationFilter extends UsernamePasswordAuthenticationFilter {

	private static Log log = LogFactory.getLog(JwtUsernamePasswordAuthenticationFilter.class);
	
	public JwtUsernamePasswordAuthenticationFilter(){
		super.setRequiresAuthenticationRequestMatcher(new AntPathRequestMatcher("/*"));
	}
	
	@Override
	public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException {
		try {
			UserCredentials userCredentials = JsonUtil.getObject(request.getInputStream(), UserCredentials.class);
			if (userCredentials == null){
				throw new BadCredentialsException("Invalid Authentication: No Input");
			}
			Authentication authentication = new UsernamePasswordAuthenticationToken(userCredentials.getUsername(), userCredentials.getPassword());
			return this.getAuthenticationManager().authenticate(authentication);
		} catch (IOException e) {
			log.error(e.getMessage(), e);
			throw new BadCredentialsException(e.getMessage(), e);
		}
	}
	
	@Override
	protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain,
			Authentication auth) throws IOException, ServletException {
		response.addHeader("Authorization", "Bearer " + JwtUtil.buildToken(auth));
        chain.doFilter(request, response);
	}
}
