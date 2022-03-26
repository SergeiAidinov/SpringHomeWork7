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

	/*
	 * @Autowired private DataSource dataSource;
	 * 
	 * @Autowired private UserService userService;
	 */
	/*
	 * @Autowired public void setDataSource(DataSource dataSource) { this.dataSource
	 * = dataSource; }
	 */

	@Autowired
	private UserDetailsService userDetailsService;
	/*
	 @Autowired public void configureGlobal(AuthenticationManagerBuilder auth)
	 throws Exception {
	 auth.userDetailsService(userDetailsService).passwordEncoder(
	 bCryptPasswordEncoder()); }
	 */
	 

	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2).select()
				.apis(RequestHandlerSelectors.basePackage("ru.yandex.incoming34")).paths(PathSelectors.any()).build()
				.apiInfo(apiInfo()).securitySchemes(securitySchemes()).securityContexts(List.of(securityContext()));
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		// Disable CSRF
		http.csrf().disable()
				// Only admin can perform HTTP delete operation
				.authorizeRequests().antMatchers(HttpMethod.DELETE).hasRole("ADMIN")
				// any authenticated user can perform all other operations
				.antMatchers("/products/**").hasAnyRole("ADMIN", "USER").and().httpBasic()
				// Permit all other request without authentication
				.and().authorizeRequests().anyRequest().permitAll()
				// We don't need sessions to be created.
				.and().sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
	}

	private List<springfox.documentation.service.SecurityScheme> securitySchemes() {
		return List.of(new BasicAuth(BASIC_AUTH));
	}

	private SecurityContext securityContext() {
		return SecurityContext.builder().securityReferences(Arrays.asList(basicAuthReference()))
				.forPaths(PathSelectors.any()).build();
	}

	private SecurityReference basicAuthReference() {
		return new SecurityReference(BASIC_AUTH, new AuthorizationScope[0]);
	}

	private ApiInfo apiInfo() {
		return new ApiInfo("Product REST API", "Product API to perform CRUD opertations", "1.0", "Terms of service",
				new Contact("Sergei Aidinov", "http://www.yandex.ru", "incoming34@yandex.ru"), "License of API",
				"API license URL", Collections.emptyList());
	}

	@Override
	public UserDetailsService userDetailsService() {
		return userDetailsService;
	}

	@Bean
	public BCryptPasswordEncoder bCryptPasswordEncoder() {
		return new BCryptPasswordEncoder();
	}

}
