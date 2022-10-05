package com.colsubsidio.dotaciones.scheduled.repositorys.dto.settings;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableConfigurationProperties
@ConfigurationProperties(prefix = "service.users")
@Data
public class ConstantsService {

	private String url;
	private String create;
	private String valid;
	private String exists;
	private String tokenlife;
	
}