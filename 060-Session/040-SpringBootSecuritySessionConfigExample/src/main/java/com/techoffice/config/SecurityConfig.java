package com.techoffice.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter{

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable();
        http.httpBasic().disable();
        http.authorizeRequests().antMatchers("/").permitAll().anyRequest().authenticated();
        http.formLogin().permitAll();
        http.logout().permitAll();
        http.headers().frameOptions().disable();
    }

}
