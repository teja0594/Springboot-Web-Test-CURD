package com.vm.spring.security;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@SuppressWarnings("deprecation")
@EnableWebSecurity
public class ProductSecurity extends WebSecurityConfigurerAdapter {

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		
		//super.configure(auth);
		auth.inMemoryAuthentication().withUser("Teja").password("Kedari").roles("ADMIN").and()
		                             .withUser("Prem").password("Kumar").roles("USER").and()
		                             .withUser("Asritha").password("Asri").roles("USER");
		

	}
	
	@Bean
	public PasswordEncoder getPasswordEncoder()
	{
		return NoOpPasswordEncoder.getInstance();
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
	
		//super.configure(http);
		http.authorizeRequests().antMatchers("/admin").hasRole("ADMIN")
		                        .antMatchers("/").permitAll().and().formLogin();
		}

	
}
