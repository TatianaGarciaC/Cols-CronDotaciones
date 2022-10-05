package com.colsubsidio.dotaciones.scheduled.config.utils;

import static java.time.Duration.parse;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.colsubsidio.dotaciones.scheduled.repositorys.dto.settings.ConstantsService;

@Component
public class RefreshTime {
	@Autowired
	private ConstantsService constants;
	
	public String getRefreshTime() {
		Duration duration = parse(constants.getTokenlife());
		long refresh = LocalDateTime.now().plus(duration.toMillis(), ChronoUnit.MILLIS)
				.atZone(ZoneId.systemDefault())
				.toInstant()
				.toEpochMilli();
		return String.valueOf(refresh);
	}
}
