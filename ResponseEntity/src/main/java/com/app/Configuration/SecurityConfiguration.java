package com.app.Configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration {

	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		 http
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
					auth.requestMatchers("/user/**").hasRole("USER");
					auth.requestMatchers("/admin/**").hasRole("ADMIN");
					auth.anyRequest().permitAll();
				})
//				.httpBasic(Customizer.withDefaults()).build();
				.formLogin()
				.loginPage("/login/form")//dia chi url
				.loginProcessingUrl("/login")//action form login
				.defaultSuccessUrl("/login/success",false)//trang sau khi dang nhap thanh cong
				.failureUrl("/login/error")// dia chi url khi co loi
				.usernameParameter("username")
				.passwordParameter("password")
				.and()
				.logout()
				.logoutUrl("/logout")
				.logoutSuccessUrl("/logout/success");
			return http.build();
	}
	
	@Bean
	public InMemoryUserDetailsManager userDetailsManager() {
		//create a user account
		UserDetails user = User.withUsername("user")
				.password(passwordEncoder().encode("password"))
				.roles("USER")
				.build();
		//create a admin account
		UserDetails admin = User.withUsername("admin")
				.password(passwordEncoder().encode("password"))
				.roles("ADMIN")
				.build();
		return new InMemoryUserDetailsManager(user, admin);
	}
	
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

}
