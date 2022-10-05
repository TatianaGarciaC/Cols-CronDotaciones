package com.colsubsidio.dotaciones.scheduled.repositorys.dto;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/**
 * @author Daniel Rojas | componente DTO que encapsula la informacion
 * necesario para realizar una petición de un token de acceso a Apigee
 */

@SuppressWarnings("serial")
@Getter
@Setter
@AllArgsConstructor
public class AuthApigeeRequest implements Serializable{
	/**
     * Identificador del cliente durante la petición del token de acceso
     */
    private String clienteId;

    /**
     * Cliente secreto durante la petición del token de acceso
     */
    private String clienteSecreto;
}
