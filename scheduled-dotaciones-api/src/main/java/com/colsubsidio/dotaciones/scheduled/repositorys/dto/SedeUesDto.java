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
public class SedeUesDto {

	


	    private Integer idSede;

	    private String sede;

	    private String ciudad;

	    private String direccion;

	    private Date fechaRegistro;

	    private String clima;

	    private Integer idUes;
	    
	    private String nombreUes;
	    
	    
	    private Date fechaModificacion;
	    
	    private String estado;
	    
	    private String usuario;
	    
}

