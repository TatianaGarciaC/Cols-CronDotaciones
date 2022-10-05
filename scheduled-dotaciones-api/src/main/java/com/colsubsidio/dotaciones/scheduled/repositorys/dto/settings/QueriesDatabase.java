package com.colsubsidio.dotaciones.scheduled.repositorys.dto.settings;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import lombok.Data;

@Configuration
@EnableConfigurationProperties
@ConfigurationProperties(prefix = "api.database.query")
@Data
public class QueriesDatabase {

	private String queryUserZh;
	private String queryUserData;
	private String querySedes;	
	private String queryTallas;
	private String queryTallasByDocumento;
	private String queryDotacion;
	private String queryUserZhGestor;
	private String queryUserAdmin;
	private String getQueryUserDataCedula;
}