package br.com.sankhya.packagerepository.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import br.com.sankhya.packagerepository.repositories.UsuarioRepository;

@EnableWebSecurity
@Configuration
public class SecurityConfigurations {

	@Autowired
	PasswordEncoder passwordEncoder;
	
	@Autowired
	private TokenService tokenService;

	@Autowired
	private UsuarioRepository usuarioRepository;

	@Bean
	public PasswordEncoder passwordEncoder(){
		return PasswordEncoderFactories.createDelegatingPasswordEncoder();
	}
	
    @Bean
    public AuthenticationManager authenticationManager(AuthenticationManagerBuilder auth ) throws Exception {
       return auth.userDetailsService(userDetailsService())
                  .passwordEncoder(passwordEncoder()).and().build();
    }
    
    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception {
        return authenticationConfiguration.getAuthenticationManager();
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
    	.antMatchers("/auth").permitAll()
    	.anyRequest().authenticated()
    	.and().csrf().disable()
    	.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
    	.and().addFilterBefore(new AutenticacaoTokenFilter(tokenService, usuarioRepository), UsernamePasswordAuthenticationFilter.class);
    	
        return http.build();
    }
//    @Bean
//    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
//    	http.authorizeRequests()
//    	.antMatchers("/h2-console/*").permitAll()
//    	.antMatchers("/auth").permitAll()
//    	.anyRequest().authenticated()
//    	.and().csrf().disable()
//    	.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
//    	
//    	return http.build();
//    }
//    @Bean
//    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
//    	http.authorizeRequests()
//    	.antMatchers("/h2-console/*").permitAll()
//    	.anyRequest().authenticated()
//    	.and().formLogin();
//    	
//    	return http.build();
//    }
    
    @Bean
    public WebSecurityCustomizer webSecurityCustomizer() {
        return (web) -> web.ignoring()
        		.antMatchers("/h2-console/*",
        				"/configuration/**",
                        "/swagger-resources/**");
    }
}
