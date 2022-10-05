package com.colsubsidio.dotaciones.scheduled.repositorys.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Response {

	@JsonProperty("codigo")
	private String code;
	@JsonProperty("descripcion")
	private String description;
	
	private byte[] bytes;

	public Response( String code, String description){
		this.code=code;
		this.description = description;
	}
}
