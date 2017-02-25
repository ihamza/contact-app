package com.ihamza.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable().authorizeRequests().antMatchers(HttpMethod.GET, "/v1.0/employee/**").authenticated()
				.antMatchers(HttpMethod.POST, "/v1.0/employee/**").authenticated()
				.antMatchers(HttpMethod.PUT, "/v1.0/employee/**").authenticated()
				.antMatchers(HttpMethod.DELETE, "/v1.0/employee/**").authenticated().anyRequest().permitAll().and()
				.httpBasic().and().sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
	}
}
