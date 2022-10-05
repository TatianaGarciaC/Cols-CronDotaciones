package com.colsubsidio.dotaciones.scheduled.repositorys.dto;

import com.colsubsidio.dotaciones.scheduled.repositorys.dto.user.UserDataResponse;

import lombok.Data;

@Data
public class Users{
	private String username;
	private String token;
	private String successUrl;
	private String refreshToken;
	private String rol;
	private UserDataResponse userDataResponse;
}