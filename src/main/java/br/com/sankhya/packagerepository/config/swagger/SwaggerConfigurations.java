package br.com.sankhya.packagerepository.config.swagger;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import br.com.sankhya.packagerepository.config.SecurityConfigurations;
import br.com.sankhya.packagerepository.models.Usuario;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@Configuration
public class SwaggerConfigurations {
	
	  @Bean
	  public Docket petApi() {
	    return new Docket(DocumentationType.SWAGGER_2)
	        .select() 
	        .apis(RequestHandlerSelectors.basePackage("br.com.sankhya.packagerepository")) 
	        .paths(PathSelectors.any()) 
	        .build() 
	        .ignoredParameterTypes(Usuario.class, SecurityConfigurations.class);

	  }

}
