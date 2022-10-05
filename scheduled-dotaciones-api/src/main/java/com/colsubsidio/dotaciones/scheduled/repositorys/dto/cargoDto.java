package com.colsubsidio.dotaciones.scheduled.repositorys.dto;


import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class cargoDto {



	    private Long IdCargo;
	    private Long idNuevoCargo;
	    private String Nombre;
	    private Date FechaRegistro;
	    private Date FechaModificacion;
	    private String Estado;	
	    private String Usuario;
	    
}
