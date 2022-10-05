package com.colsubsidio.dotaciones.scheduled.repositorys.dto;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;



@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class UniformeDto {

	 private Integer idUniforme;

	    private String nombre;
	    private Date fechaRegistro;
	    private Date fechaModificacion;
	    private String estado;	
	    private String usuario;
	
}
