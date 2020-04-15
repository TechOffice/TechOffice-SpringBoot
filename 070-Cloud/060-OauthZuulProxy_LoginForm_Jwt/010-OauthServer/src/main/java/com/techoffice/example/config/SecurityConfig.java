package com.techoffice.example.config;

import com.techoffice.example.security.custom.CustomEntryPoint;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.BeanIds;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configurers.provisioning.InMemoryUserDetailsManagerConfigurer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
@Order(2)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        InMemoryUserDetailsManagerConfigurer<AuthenticationManagerBuilder> configurer =
                auth.inMemoryAuthentication();
        configurer.withUser("user").password(passwordEncoder().encode("password")).roles("USER");
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
//        web.ignoring().antMatchers("/oauth/token");
    }

    @Override
    public void configure(HttpSecurity http) throws Exception {
        http.antMatcher("/**")
                .authorizeRequests()
                .anyRequest()
                .authenticated()
                .and().formLogin().loginPage("/login").permitAll()
                .and().exceptionHandling().authenticationEntryPoint(new CustomEntryPoint("/login"));
        http.csrf().disable().cors();
        http.headers().httpStrictTransportSecurity().disable();
    }


    @Bean(name = BeanIds.AUTHENTICATION_MANAGER)
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        PasswordEncoder encoder = new BCryptPasswordEncoder();
        return encoder;
    }

}
