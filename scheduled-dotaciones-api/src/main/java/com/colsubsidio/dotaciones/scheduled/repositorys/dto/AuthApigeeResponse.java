package com.colsubsidio.dotaciones.scheduled.repositorys.dto;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;

/**
 * @author Daniel Rojas | Componente DTO que encapsula
 * la respuesta del JWT para la autorizacion de las peticiones REST
 * a traves de APIGEE
 */
@SuppressWarnings("serial")
@Getter
@Setter
public class AuthApigeeResponse implements Serializable {
	/**
     * JWT de acceso Apigee
     */
    @JsonProperty("access_token")
    private String accessToken;

    /**
     * Fecha de creación del JWT en milisegundos
     */
    @JsonProperty("issued_at")
    private Long issuedAt;
}
