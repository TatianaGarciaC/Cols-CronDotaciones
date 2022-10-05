package com.colsubsidio.dotaciones.scheduled.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import lombok.extern.slf4j.Slf4j;

@EnableScheduling
@Configuration
@Slf4j
public class Scheduler {

	@Autowired
	private ELKService service;
	
	@Scheduled(fixedRateString = "2400000")
	public void refreshTokenELK(){
		log.info("Token ELK is refresh");
		service.refreshToken();
		log.info("Token ELK was refresh");
	}
	
}
