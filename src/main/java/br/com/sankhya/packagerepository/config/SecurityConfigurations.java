package br.com.sankhya.packagerepository.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@EnableWebSecurity
@Configuration
public class SecurityConfigurations {
	
//	@Autowired
//    private AuthEntryPointJwt unauthorizedHandler;
	
//    @Bean
//    public InMemoryUserDetailsManager userDetailsService() {
//        UserDetails user = User.withDefaultPasswordEncoder()
//            .username("user")
//            .password("password")
//            .roles("USER")
//            .build();
//        return new InMemoryUserDetailsManager(user);
//    }
    
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
    	http.authorizeRequests()
    	.antMatchers(HttpMethod.GET, "/topicos").permitAll()
    	.antMatchers(HttpMethod.GET, "/topicos/*").permitAll()
    	.antMatchers("/h2-console/*").permitAll()
    	.anyRequest().authenticated();
    	
        return http.build();
    }
    
//    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
//        http.cors().and().csrf().disable().exceptionHandling().authenticationEntryPoint(unauthorizedHandler).and()
//                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).and().authorizeRequests()
//                .antMatchers("/api/auth/**").permitAll()
//                .antMatchers("/api/test/**").permitAll()
//                .antMatchers("/api/v1/**").permitAll()
//                .anyRequest().authenticated();
//        http.addFilterBefore(authenticationJwtTokenFilter(), UsernamePasswordAuthenticationFilter.class);
//        return http.build();
//    }
    
    @Bean
    public WebSecurityCustomizer webSecurityCustomizer() {
        return (web) -> web.ignoring()
        		.antMatchers("/h2-console/*");
    }
}
