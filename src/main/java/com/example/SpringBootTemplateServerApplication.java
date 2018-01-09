package com.example;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.example.config.CustomUserDetails;
import com.example.dao.UserRepository;
import com.example.entity.Role;
import com.example.entity.User;
import com.example.service.UserService;

//@EnableAutoConfiguration
@SpringBootApplication
public class SpringBootTemplateServerApplication {

	// http://localhost:8080/springBootTemplateServer/oauth/token?grant_type=password&username=user&password=user
	// http://localhost:8080/springBootTemplateServer/persons?access_token=d6c3dfe9-bdf2-4978-b008-1f1ffbb78ad3
	// http://localhost:8080/springBootTemplateServer/oauth/token?grant_type=refresh_token&refresh_token=dfea499c-0eb8-4394-8c25-a7af5b1aa3d9
	 
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	public static void main(String[] args) {
		SpringApplication.run(SpringBootTemplateServerApplication.class, args);
	}
	
	@Autowired
	public void authenticationManager(AuthenticationManagerBuilder builder, UserRepository repository, UserService service) throws Exception {
		//Setup a default user if db is empty
		if (repository.count()==0)
			service.save(new User("user", "user", Arrays.asList(new Role("USER"), new Role("ACTUATOR"))));
		builder.userDetailsService(userDetailsService(repository)).passwordEncoder(passwordEncoder);
	}

	private UserDetailsService userDetailsService(final UserRepository repository) {
		return username -> new CustomUserDetails(repository.findByUsername(username));
	}
	
}




