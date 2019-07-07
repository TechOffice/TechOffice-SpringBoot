package com.techoffice.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configurers.provisioning.InMemoryUserDetailsManagerConfigurer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.techoffice.security.filter.JwtTokenAuthenticationFilter;
import com.techoffice.security.filter.JwtUsernamePasswordAuthenticationFilter;
import com.techoffice.security.web.JwtAuthenticationEntryPoint;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	
	public void configure(WebSecurity web) throws Exception {
		web.ignoring().antMatchers("/", "/webjars/**");
	}
	
	@Configuration
	@Order(1)
	public static class Authentication extends WebSecurityConfigurerAdapter {
		
		@Autowired
		private JwtAuthenticationEntryPoint unauthorizedHandler;
		
		@Override
		protected void configure(AuthenticationManagerBuilder auth) throws Exception {
			InMemoryUserDetailsManagerConfigurer<AuthenticationManagerBuilder> configurer = auth.inMemoryAuthentication();
			configurer.withUser("user").password("password").roles("USER");
		}
		
		@Override
		protected void configure(HttpSecurity http) throws Exception {
			JwtUsernamePasswordAuthenticationFilter filter = new JwtUsernamePasswordAuthenticationFilter();
			filter.setAuthenticationManager(this.authenticationManager());
			http.exceptionHandling()
				.authenticationEntryPoint(unauthorizedHandler)
				.and().sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
				.and().csrf()
				.and().csrf().disable()
				.antMatcher("/auth").authorizeRequests().anyRequest().permitAll().and()
				.addFilterBefore(filter, UsernamePasswordAuthenticationFilter.class);
		}
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
				.and().csrf()
				.and().csrf().disable()
				.antMatcher("/*").authorizeRequests().anyRequest().authenticated()
				.and().addFilterBefore(new JwtTokenAuthenticationFilter(), UsernamePasswordAuthenticationFilter.class);
		}
	}
	
	

}
