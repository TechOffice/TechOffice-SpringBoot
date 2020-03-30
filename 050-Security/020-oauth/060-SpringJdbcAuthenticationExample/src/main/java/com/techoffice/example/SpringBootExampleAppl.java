package com.techoffice.example;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.techoffice.example.model.Authorities;
import com.techoffice.example.model.Users;
import com.techoffice.example.repository.AuthoritiesRepository;
import com.techoffice.example.repository.UsersRepository;

@RestController
@SpringBootApplication
public class SpringBootExampleAppl extends WebSecurityConfigurerAdapter{
	
	@Autowired
	private DataSource dataSource;
	
	@Autowired
	private UsersRepository usersRepository;
	
	@Autowired
	private AuthoritiesRepository authoritiesRepository;
	
	protected void configure(AuthenticationManagerBuilder builder) throws Exception {
		builder.jdbcAuthentication().dataSource(dataSource);
		builder.inMemoryAuthentication()
			.withUser("user")
			.password("password")
			.roles("USER");
	}
	
	@RequestMapping("/")
    String home() {
        return "Hello World!";
    }

	@RequestMapping("/createUser")
    String createUser() {
		Users user = new Users();
		user.setUsername("Testing");
		user.setPassword("Testing");
		user.setEnabled(true);
		
		this.usersRepository.save(user);
        
		Authorities authority = new Authorities();
		authority.setUsername("Testing");
		authority.setAuthority("USER");
		this.authoritiesRepository.save(authority);
		
		return "Created Users!";
    }

	
	public static void main(String[] args){
        SpringApplication.run(SpringBootExampleAppl.class, args);
	}
}
