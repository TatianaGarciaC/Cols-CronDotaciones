package com.colsubsidio.dotaciones.scheduled.repositorys.dto;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;

/**
 * @author Daniel Rojas | componente DTO que encapsula la informacion a la consulta de autentificación
 */
@SuppressWarnings("serial")
@Getter
@Setter
public class EmpleadosAuthResponse extends GeneralApigeeResponse implements Serializable{
	private boolean ok;
	private String message;
}
