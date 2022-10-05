package com.colsubsidio.dotaciones.scheduled.repositorys.dto;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonProperty;

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
public class UesDto implements Serializable {

    private static final long serialVersionUID = 1L;
    

    private Integer idUES;

    private String nombre;

    private Date fechaRegistro;
    
    private Date FechaModificacion;
    private String Estado;	
    private String Usuario;
    


	
}
