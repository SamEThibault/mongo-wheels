package com.ms.mongowheels.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Lazy;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;


@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Autowired
	private LoggingAccessDeniedHandler accessDeniedHandler;

	@Override
	public void configure(WebSecurity web)  {
		web
				.ignoring().antMatchers("/resources/**", "/static/**", "/css/**")
				.antMatchers("/javax.faces.resource/**");

	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable();
		http.headers().frameOptions().disable();
	
		http
		.authorizeRequests()
		.antMatchers("/community").hasAnyRole("ADMIN", "USER")
		.antMatchers("/").permitAll() 
		.antMatchers("/explore").permitAll()
		.antMatchers("/favorites").hasRole("USER") 
		.antMatchers("/search").permitAll() 
		.antMatchers(HttpMethod.POST, "/search").permitAll()
		.antMatchers("/getCars").permitAll()
		.antMatchers("/fuel").permitAll() 
		.antMatchers("/engine").permitAll() 
		.antMatchers("/body").permitAll() 
		.antMatchers("/h2-console/**").permitAll()
		.antMatchers("/registerUser").permitAll()
		.antMatchers(HttpMethod.POST, "/registerUser").permitAll()
		.anyRequest().authenticated()
	.and()
		.formLogin()
			.loginPage("/login")
			.permitAll()
	.and()
			.logout()
			.invalidateHttpSession(true)
			.clearAuthentication(true)
			.logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
			.logoutSuccessUrl("/?logout")
			.permitAll()
	.and()
			.exceptionHandling()
				.accessDeniedHandler(accessDeniedHandler);
			
	}
	
	
	@Bean
    public BCryptPasswordEncoder passwordEncoder()
    {
        return new BCryptPasswordEncoder();
    
}

    
    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception{
     auth.inMemoryAuthentication().passwordEncoder(NoOpPasswordEncoder.getInstance())
      .withUser("user").password("123").roles("USER")
      .and()
      .withUser("admin").password("123").roles("USER","ADMIN");
    }
	
}

