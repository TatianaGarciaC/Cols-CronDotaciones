package com.colsubsidio.dotaciones.scheduled.config.utils;




import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


import com.colsubsidio.dotaciones.scheduled.repositorys.dto.KibanaRequestDto;


import com.colsubsidio.dotaciones.scheduled.config.ELKServiceV2;

import com.colsubsidio.dotaciones.scheduled.repositorys.dto.settings.ConstantAPI;
import com.colsubsidio.dotaciones.scheduled.repositorys.dto.settings.ELK;




@Component
public class ELKUtilsV2 {
	@Autowired
	ELK service;
	
	@Autowired
	ConstantAPI enviromentConst;
	
	@Autowired
	ELKServiceV2 elkService;



	public void SendRequest(KibanaRequestDto elk) {
		elkService.registerLogs(elk);
	}



	

}
