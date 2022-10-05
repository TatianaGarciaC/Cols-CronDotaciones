package com.colsubsidio.dotaciones.scheduled.repositorys.dto;

import java.io.Serializable;
import java.util.List;

import lombok.Getter;
import lombok.Setter;

/**
 * @author Daniel Rojas | componente DTO que encapsula la informacion
 * genérica de una petición http a Apigee
 */
@SuppressWarnings("serial")
@Getter
@Setter
public class GeneralApigeeResponse implements Serializable {
	public static final String SUCCESS_RESPONSE = "SUCCESS";
	private List<Result> resultado;
	
	@Getter
    @Setter
    public static class Result implements Serializable {
		private String codigo;
        private String descripcion;
    }
}
