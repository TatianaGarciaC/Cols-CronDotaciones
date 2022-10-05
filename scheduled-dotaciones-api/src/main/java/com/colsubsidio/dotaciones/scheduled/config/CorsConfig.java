package com.colsubsidio.dotaciones.scheduled.config;

import static com.colsubsidio.dotaciones.scheduled.config.utils.Constants.HEADER_AUTHORIZATION;
import static com.colsubsidio.dotaciones.scheduled.config.utils.Constants.HEADER_REFRESH;

import javax.ws.rs.HttpMethod;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
@Configuration
public class CorsConfig {

	@Bean
	public  WebMvcConfigurer corsConfigurer(){
		return new WebMvcConfigurer() {
			@Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**")
                		.allowedOrigins("*")
                		.allowedHeaders(HEADER_AUTHORIZATION,HEADER_REFRESH,HEADER_AUTHORIZATION.toLowerCase(),HEADER_REFRESH.toLowerCase(),"*")
                		.allowedMethods(HttpMethod.GET,HttpMethod.POST,HttpMethod.DELETE,HttpMethod.HEAD,HttpMethod.OPTIONS,HttpMethod.PATCH,HttpMethod.PUT)
						.exposedHeaders(HEADER_AUTHORIZATION,HEADER_REFRESH,HEADER_AUTHORIZATION.toLowerCase(),HEADER_REFRESH.toLowerCase());
            }
		};
	}

}
