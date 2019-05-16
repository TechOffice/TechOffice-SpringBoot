package com.techoffice.security.config;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.techoffice.security.filter.JwtTokenAuthenticationFilter;
import com.techoffice.security.util.JwtUtil;
import com.techoffice.security.util.KeyUtil;
import com.techoffice.security.web.JwtAuthenticationEntryPoint;

@Configuration
@Order(3)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	@Value("${secretKey}")
	private String secretKey;
	
	@PostConstruct
	public void init(){
		JwtUtil.setSecretKey(KeyUtil.decodeKey(secretKey));
	}
	
	public void configure(WebSecurity web) throws Exception {
		web.ignoring().antMatchers("/", "/index", "/webjars/**", "/key");
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable().cors().disable();
	}
	
	@Configuration
	@Order(2)
	public static class Authorization extends WebSecurityConfigurerAdapter {
		
		@Autowired
		private JwtAuthenticationEntryPoint unauthorizedHandler;
		
		@Override
		protected void configure(HttpSecurity http) throws Exception {
			http.exceptionHandling()
				.authenticationEntryPoint(unauthorizedHandler)
				.and().sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
				.and().csrf().disable().cors().disable()
				.antMatcher("/*").authorizeRequests().anyRequest().authenticated()
				.and().addFilterBefore(new JwtTokenAuthenticationFilter(), UsernamePasswordAuthenticationFilter.class);
		}
	}
	
	

}
