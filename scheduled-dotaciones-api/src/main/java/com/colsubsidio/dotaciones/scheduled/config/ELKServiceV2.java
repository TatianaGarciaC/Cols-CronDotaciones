package com.colsubsidio.dotaciones.scheduled.config;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpClientErrorException;


import com.colsubsidio.dotaciones.scheduled.config.client.KibanaClientV2;

import com.colsubsidio.dotaciones.scheduled.repositorys.dto.KibanaRequestDto;
import com.colsubsidio.dotaciones.scheduled.repositorys.dto.TokenLoggerRequest;
import com.colsubsidio.dotaciones.scheduled.repositorys.dto.LoggerResponse;
import com.colsubsidio.dotaciones.scheduled.repositorys.dto.TokenLoggerResponse;
import com.colsubsidio.dotaciones.scheduled.repositorys.dto.settings.ELK;
import com.google.gson.Gson;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class ELKServiceV2 {

	@Autowired
	ELK service;
	@Autowired
	KibanaClientV2 client;
	
	@Value("${api.elk.index}")
	private String index;


	@Async
	public void registerLogs(KibanaRequestDto request) {
		String body = "";
		try {
			request.setIndex(this.index);
			body = new Gson().toJson(request);
			TokenLoggerResponse authorization = getToken();
			LoggerResponse response = client.insert(request, authorization.token());
			log.debug("Correct:"+response.getOk()+" \nComment:"+ response.getComment());
		} catch (Exception e) {
			log.error(body+"\n"+e.getMessage());
			if(e.getCause() instanceof HttpClientErrorException) {
				log.error(((HttpClientErrorException)e.getCause()).getStatusCode().toString());
			}
		}
	}

	@Cacheable(cacheNames = "cacheTokenELK")
	private TokenLoggerResponse getToken() {
		TokenLoggerRequest request = new TokenLoggerRequest();
		request.setApplication(service.getApp());
		request.setUsername(service.getUser());
		request.setPassword(service.getPass());
		return client.token(request);
	}

	@CacheEvict(cacheNames = "cacheTokenELK")
	public void refreshToken() {
		getToken();
	}
}
