package com.colsubsidio.dotaciones.scheduled.repositorys.dto.settings;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableConfigurationProperties
@ConfigurationProperties(prefix = "api.constants.code")
@Data
public class ConstantsCode {

	private String successProcess;
	private String errorProcess;
	private String exception;
	
}