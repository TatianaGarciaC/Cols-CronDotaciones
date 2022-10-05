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
@AllArgsConstructor
@NoArgsConstructor
public class UserAdmin {

	private Integer id;

	private String usuario;

	private Boolean estado;
	
	private Date fechaRegistro;
	
	private  String roles;
	
	
	

}
