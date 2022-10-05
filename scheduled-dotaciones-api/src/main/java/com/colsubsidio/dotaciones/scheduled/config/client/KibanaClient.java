package com.colsubsidio.dotaciones.scheduled.config.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;

import com.colsubsidio.dotaciones.scheduled.config.FooClientConfig;
import com.colsubsidio.dotaciones.scheduled.repositorys.dto.ELKRequest;
import com.colsubsidio.dotaciones.scheduled.repositorys.dto.TokenLoggerRequest;
import com.colsubsidio.dotaciones.scheduled.repositorys.dto.LoggerResponse;
import com.colsubsidio.dotaciones.scheduled.repositorys.dto.TokenLoggerResponse;

import feign.Headers;

@FeignClient(name = "kibana-logger", url="${api.elk.endpoint}",configuration = FooClientConfig.class)
public interface KibanaClient {
	
	@PostMapping(value="/registerlog/",produces = MediaType.APPLICATION_JSON_VALUE,consumes =MediaType.APPLICATION_JSON_VALUE)
	@Headers("Accept: application/json")
	public LoggerResponse insert(@RequestBody ELKRequest request,@RequestHeader("Authorization")String token);
	
	@PostMapping(value="/auth", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public TokenLoggerResponse token(@RequestBody TokenLoggerRequest body); 

}
