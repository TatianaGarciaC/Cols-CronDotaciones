package com.colsubsidio.dotaciones.scheduled.repositorys.dto;

import lombok.Data;

@Data
public class TokenLoggerRequest {
	private String application;
	private String username;
	private String password;
}
