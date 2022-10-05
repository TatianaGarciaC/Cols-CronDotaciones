package com.colsubsidio.dotaciones.scheduled.repositorys.dto.user;

import java.util.List;

import com.colsubsidio.dotaciones.scheduled.repositorys.dto.Response;
import com.colsubsidio.dotaciones.scheduled.repositorys.dto.UserDTO.SedesDTO;
import com.colsubsidio.dotaciones.scheduled.repositorys.dto.UserDTO.ZhData;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class UserDataResponse{
	@JsonProperty("resultado")
	private Response response;
	
	private ZhData zhData;
	private List<SedesDTO> sedes;
	
}