package com.issue.tracker.issuetracker.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
public class ApplicationSecurity extends WebSecurityConfigurerAdapter {

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		BCryptPasswordEncoder encoder = passwordEncoder();
		auth.inMemoryAuthentication().passwordEncoder(encoder)
				.withUser("user").password(encoder.encode("password")).roles("USER").and()
				.withUser("admin").password(encoder.encode("password")).roles("USER", "ADMIN");
	}
	
	@Override
	public void configure(WebSecurity web) throws Exception {
		super.configure(web);
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		 //http.authorizeRequests().anyRequest().authenticated().and().formLogin().and().httpBasic();
		 http
         //HTTP Basic authentication
         .httpBasic()
         .and()
         .authorizeRequests()
         .antMatchers(HttpMethod.GET, "/hi**").hasAnyRole("USER","ADMIN")
         .antMatchers(HttpMethod.GET, "/getIssues/**").hasAnyRole("USER","ADMIN")
         .antMatchers(HttpMethod.POST, "/saveIssue").hasRole("ADMIN")
         .antMatchers(HttpMethod.PUT, "/updateIssue/**").hasRole("ADMIN")
         //.antMatchers(HttpMethod.PATCH, "/books/**").hasRole("ADMIN")
         .antMatchers(HttpMethod.DELETE, "/deleteIssue/**").hasRole("ADMIN")
         .and()
         .csrf().disable()
         .formLogin().disable();
	}

	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
}
