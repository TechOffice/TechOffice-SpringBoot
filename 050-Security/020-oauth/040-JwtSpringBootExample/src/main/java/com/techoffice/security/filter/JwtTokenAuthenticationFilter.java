package com.techoffice.security.filter;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.techoffice.security.util.JwtUtil;

/**
 * 
 * @author Ben Cheng
 *
 */
public class JwtTokenAuthenticationFilter extends OncePerRequestFilter {

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		
		String header = request.getHeader("Authorization");

		if (header != null && header.startsWith("Bearer ")){
			String token = header.substring(7);
			Authentication authentication = JwtUtil.parseAuthentication(token);
			SecurityContextHolder.getContext().setAuthentication(authentication);
		}
		
		filterChain.doFilter(request, response);		
	}

}
