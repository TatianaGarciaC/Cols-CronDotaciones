package com.colsubsidio.dotaciones.scheduled.repositorys.dto.solicitud;

import com.colsubsidio.dotaciones.scheduled.repositorys.dto.Response;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class ResponseSolicitud {
	
	
	@JsonProperty("resultado")
	private Response response;

}
