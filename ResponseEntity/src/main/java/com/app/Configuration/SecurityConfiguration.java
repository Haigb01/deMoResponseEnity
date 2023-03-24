package com.app.Configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration {

	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		return http
//	        	.csrf().disable()
//	        	.authorizeHttpRequests()
//	            .requestMatchers("/").permitAll()
//	            .requestMatchers("/user").hasRole("USER")
//	            .requestMatchers("/admin").hasRole("ADMIN")
//	            .anyRequest().authenticated()
//	            .and()
//	            .httpBasic()
//	            .and().build();
				// another way
				.csrf(csrf -> csrf.disable()).authorizeHttpRequests(auth -> {
					auth.requestMatchers("/").permitAll();
					auth.requestMatchers("/user").hasRole("USER");
					auth.requestMatchers("/admin").hasRole("ADMIN");
				}).httpBasic(Customizer.withDefaults()).build();

	}
	
	@Bean
	public InMemoryUserDetailsManager userDetailsManager() {
		//create a user account
		UserDetails user = User.withDefaultPasswordEncoder()
				.username("user")
				.password("password")
				.roles("USER")
				.build();
		//create a admin account
		UserDetails admin = User.withDefaultPasswordEncoder()
				.username("admin")
				.password("password")
				.roles("ADMIN")
				.build();
		return new InMemoryUserDetailsManager(user, admin);
	}

}
