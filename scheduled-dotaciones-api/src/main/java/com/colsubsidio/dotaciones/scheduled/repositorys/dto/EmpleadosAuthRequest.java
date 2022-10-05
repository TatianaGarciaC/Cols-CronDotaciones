package com.colsubsidio.dotaciones.scheduled.repositorys.dto;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@SuppressWarnings("serial")
@Getter
@Setter
@AllArgsConstructor
public class EmpleadosAuthRequest implements Serializable {
	  private String username;
	  private String password;
}
