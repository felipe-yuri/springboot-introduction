package br.com.sankhya.packagerepository.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@EnableWebSecurity
@Configuration
public class SecurityConfigurations {

	@Autowired
	PasswordEncoder passwordEncoder;

	@Bean
	public PasswordEncoder passwordEncoder(){
		return PasswordEncoderFactories.createDelegatingPasswordEncoder();
	}
	
    @Bean
    public InMemoryUserDetailsManager userDetailsService() {
        UserDetails user = User.builder()
        	.passwordEncoder(passwordEncoder::encode)
            .username("admin")
            .password("admin")
            .roles("USER")
            .build();
        return new InMemoryUserDetailsManager(user);
    }
    
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
    	http.authorizeRequests()
    	.antMatchers("/h2-console/*").permitAll()
    	.antMatchers("/swagger*/**").permitAll()
    	.antMatchers("/swagger-ui/**").permitAll();
    	
    	return http.build();
    }
    
    @Bean
    public WebSecurityCustomizer webSecurityCustomizer() {
        return (web) -> web.ignoring().antMatchers(
        		"/h2-console/*",
				"/configuration/**",
        		"/**.html",
                "/v2/api-docs/**",
                "/v2/api-docs/swagger-config",
                "/swagger-ui/**",
                "/webjars/**",
                "/swagger*/**",
                "/bus/v3/api-docs/**");
    }
}
