package com.colsubsidio.dotaciones.scheduled.repositorys.dto;

import java.time.LocalDateTime;
import java.util.List;

import com.google.gson.annotations.Expose;

import lombok.Data;

@Data
public class ELKRequest {
	private String methodName;
	private String requestName;
	private String index;
	private String channel;
	private String enviroment;
	private String token;
	private String refresh;
	@Expose(serialize = false)
	private LocalDateTime initial;
	@Expose(serialize = false)
	private LocalDateTime ending;
	private String startDate;
	private String endDate;
	private Long timeResponser;
	@SuppressWarnings("rawtypes")
	private List<ServiceDTO> services;
	@SuppressWarnings("rawtypes")
	private List<DAODTO> daos;
	private List<AdditionalDTO> additionals;
	private Error error;
	private List<KeyValue> params;
	private UserDTO responseUser;
	private Users responseUsers;
	private String responseString;
	private Integer responseInteger;
	private Object responseObject;
	
	@Data 
	public class Error{
		private String methodName;
		private String className;
		private String localizeName;
		private String message;
	}
	
	@Data
	public class ServiceDTO<R,P>{
		private String methodName;
		private R request;
		private P response;
		private String responseString;
		private String url;
		private String token;
		@Expose(serialize = false)
		private LocalDateTime initial;
		@Expose(serialize = false)
		private LocalDateTime ending;
		private String startDate;
		private String endDate;
		private String statusCode;
		private Long timeResponser;
	}

	@Data
	public class DAODTO<R,P>{

		private String methodName;
		private Object request;
		private Object response;
		private String responseString;
		private Integer responseInteger;
		private Boolean responseBoolean;
		private Long responseLong;
		@Expose(serialize = false)
		private LocalDateTime initial;
		@Expose(serialize = false)
		private LocalDateTime ending;
		private String startDate;
		private String endDate;
		private Long timeResponse;
	}
	
	@Data
	public class AdditionalDTO{
		private String methodName;
		private String className;
		private String localizeMessage;
		private String value;
	}
	
}
