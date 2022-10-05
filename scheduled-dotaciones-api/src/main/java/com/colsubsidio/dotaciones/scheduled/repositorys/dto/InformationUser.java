package com.colsubsidio.dotaciones.scheduled.repositorys.dto;
import java.util.List;

import lombok.Data;

@Data
public class InformationUser {

	private String username;
	 private List<String> uid;
	 private List<String> email;
	 private List<String> name;
	 private List<String> telephoneNumber;
     private List<String> createdTimeStamp;
}
