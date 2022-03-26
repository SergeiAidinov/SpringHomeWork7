package ru.yandex.incoming34.SpringHomeWork7.conf;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.AuthorizationScope;
import springfox.documentation.service.BasicAuth;
import springfox.documentation.service.Contact;
import springfox.documentation.service.SecurityReference;
import springfox.documentation.service.SecurityScheme;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.service.contexts.SecurityContext;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@ComponentScan(basePackages = { "ru.yandex.incoming34.SpringHomeWork7",
		"ru.yandex.incoming34.SpringHomeWork7.controllers" })
@EnableTransactionManagement
public class ApplicationConfiguration {
	private static final String BASIC_AUTH = "basicAuth";
	@Value("${spring.driver-class-name}")
	String driver;
	@Value("${spring.datasource.url}")
	String url;
	@Value("${spring.datasource.username}")
	String userName;
	@Value("${spring.datasource.password}")
	String password;

	@Bean
	public DataSource getDataSource() {
		DataSourceBuilder<?> dataSourceBuilder = DataSourceBuilder.create();
		dataSourceBuilder.driverClassName(driver);
		dataSourceBuilder.url(url);
		dataSourceBuilder.username(userName);
		dataSourceBuilder.password(password);
		return dataSourceBuilder.build();
	}
/*
	@Bean
    public Docket api() { 
        return new Docket(DocumentationType.SWAGGER_2)
        		.select()
        		.apis(RequestHandlerSelectors.basePackage("ru.yandex.incoming34.SpringHomeWork7"))
        		.paths(PathSelectors.any()).build()
                .securitySchemes(securitySchemes()).securityContexts(List.of(securityContext()));
    }
    

	private List<SecurityScheme> securitySchemes() {
		return List.of(new BasicAuth(BASIC_AUTH));
	}

	private SecurityContext securityContext() {
		return SecurityContext.builder().securityReferences(Arrays.asList(basicAuthReference()))
				.forPaths(PathSelectors.any()).build();
	}

	private SecurityReference basicAuthReference() {
		return new SecurityReference(BASIC_AUTH, new AuthorizationScope[0]);
	}
	*/

}
