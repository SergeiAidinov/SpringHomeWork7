package ru.yandex.incoming34.SpringHomeWork7.conf;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import springfox.documentation.spi.service.contexts.SecurityContext;
import io.swagger.v3.oas.annotations.security.SecurityScheme;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.AuthorizationScope;
import springfox.documentation.service.BasicAuth;
import springfox.documentation.service.Contact;
import springfox.documentation.service.SecurityReference;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
@EnableWebSecurity
@EnableGlobalMethodSecurity(securedEnabled = true)
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
	private static final String BASIC_AUTH = "basicAuth";
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
        http
        .cors().and()
        .csrf().disable().authorizeRequests()
        .antMatchers("/api").hasRole("ADMIN")
        .anyRequest().authenticated()
        .and()
        .formLogin();
	}

	@Override
	 protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
                .withUser("Piglet")
                .password(passwordEncoder().encode("123"))
                .authorities("ADMIN");
    }
	
	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2).select()
				.apis(RequestHandlerSelectors.basePackage("ru.yandex.incoming34")).paths(PathSelectors.any()).build()
				.apiInfo(apiInfo())
				.securitySchemes(securitySchemes())
				.securityContexts(List.of(securityContext()));
	}
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	private ApiInfo apiInfo() {
		return new ApiInfo("Product REST API", "Product API to perform CRUD opertations", "1.0", "Terms of service",
				new Contact("Sergei Aidinov", "http://www.yandex.ru", "incoming34@yandex.ru"), "License of API",
				"API license URL", Collections.emptyList());
	}
	
	private SecurityContext securityContext() {
		return SecurityContext.builder()
				.securityReferences(Arrays.asList(basicAuthReference()))
				.forPaths(PathSelectors.any()).build();
	}
	
	private SecurityReference basicAuthReference() {
		return new SecurityReference(BASIC_AUTH, new AuthorizationScope[0]);
	}
	
	private List<springfox.documentation.service.SecurityScheme> securitySchemes() {
		return List.of(new BasicAuth(BASIC_AUTH));
	}

}
