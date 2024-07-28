package com.luv2code.springboot.cruddemo.security;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class DemoSecurityConfig {

	// add support for Jdbc .. no more hardcoded users
	@Bean
	public UserDetailsManager userDetailsManager(DataSource dataSource) {
		return new JdbcUserDetailsManager(dataSource);
	}

//	@Bean
//	public InMemoryUserDetailsManager userDetailsManager() {
//		UserDetails viraj = User.builder().username("viraj").password(passwordEncoder().encode("sjpv@5555"))
//				.roles("EMPLOYEE", "MANAGER", "ADMIN").build();
//
//		UserDetails piyush = User.builder().username("piyush").password(passwordEncoder().encode("piyush@1234"))
//				.roles("EMPLOYEE", "MANAGER").build();
//
//		UserDetails john = User.builder().username("john").password(passwordEncoder().encode("john@1234"))
//				.roles("EMPLOYEE").build();
//
//		return new InMemoryUserDetailsManager(viraj, piyush, john);
//	}

//	@Bean
//	public PasswordEncoder passwordEncoder() {
//		return new BCryptPasswordEncoder();
//	}

	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		http.authorizeHttpRequests(authz -> authz.requestMatchers(HttpMethod.GET, "/api/employees")
				.hasAnyRole("EMPLOYEE", "MANAGER", "ADMIN").requestMatchers(HttpMethod.GET, "/api/employees/{id}")
				.hasAnyRole("EMPLOYEE", "MANAGER", "ADMIN").requestMatchers(HttpMethod.PUT, "/api/employees/**")
				.hasAnyRole("MANAGER", "ADMIN").requestMatchers(HttpMethod.POST, "/api/employees")
				.hasAnyRole("MANAGER", "ADMIN").requestMatchers(HttpMethod.DELETE, "/api/employees/**")
				.hasRole("ADMIN"));

		http.httpBasic(Customizer.withDefaults());
		http.csrf(csrf -> csrf.disable());
		return http.build();

	}
}
