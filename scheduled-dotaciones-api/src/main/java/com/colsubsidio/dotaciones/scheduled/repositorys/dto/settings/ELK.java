package com.colsubsidio.dotaciones.scheduled.repositorys.dto.settings;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableConfigurationProperties
@ConfigurationProperties(prefix = "api.elk")
@Data
public class ELK {

	private String endpoint;
	private String token;
	private String logger;
	private String user;
	private String pass;
	private String app;
	private String index;
}