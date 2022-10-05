package com.colsubsidio.dotaciones.scheduled.repositorys.dto;

import java.util.Date;
import java.util.Map;

import lombok.Builder;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;



@Getter
@Setter
@ToString
public class KibanaRequestDto {
	

	private String index;
	private String userName;
	private String methodName;
	private String className;
	private String enviroment;
	private Date fechaEvento;
	
	private String MsjError;
	private String UserMsjError;
	
	private DaoDto daoDto;
	
	private CLientDto cLientDto;
	
	
	@Builder
	@Getter
	@Setter
	@ToString
	public static class DaoDto{
		private String dataBase;
		private String query;
		Map<String, Object> paramsRequest;
	}
	
	@Builder
	@Getter
	@Setter
	@ToString
	public static  class CLientDto{
		private String dataBase;
		private String query;
		private Object Request;
		private Object response;
	}

	public KibanaRequestDto(String userName, String methodName, String className, String enviroment, String msjError,
			String userMsjError) {
		super();
		this.userName = userName;
		this.methodName = methodName;
		this.className = className;
		this.enviroment = enviroment;
		MsjError = msjError;
		UserMsjError = userMsjError;
		
		this.fechaEvento =  new Date();
	}
	

	public KibanaRequestDto(String userName, String methodName, String className, String enviroment, String msjError,
			String userMsjError , DaoDto dao , CLientDto client) {
		super();
		this.userName = userName;
		this.methodName = methodName;
		this.className = className;
		this.enviroment = enviroment;
		MsjError = msjError;
		UserMsjError = userMsjError;
		this.fechaEvento =  new Date();
		this.daoDto = dao;
		this.cLientDto = client;
		
		
	}
	
	
	public KibanaRequestDto() {
	
		
	}
	

}
