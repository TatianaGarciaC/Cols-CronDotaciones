package com.colsubsidio.dotaciones.scheduled.config;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;

import com.colsubsidio.dotaciones.scheduled.repositorys.dto.EmpleadosAuthRequest;
import com.colsubsidio.dotaciones.scheduled.repositorys.dto.EmpleadosAuthResponse;

/**
 * @author Daniel Rojas | Interface que representa el cliente REST para el consumo
 * de los servicios expuestos en Apigee
 */
@FeignClient(name = "apigee-client", url = "${apigee.url}", configuration = RestClientConfig.class)
public interface ApigeeRestClient {
	
	@PostMapping("${apigee.path.logger}")
	EmpleadosAuthResponse empleadosAuth(@RequestBody EmpleadosAuthRequest request, @RequestHeader(name = "Authorization") String authToken, @RequestHeader(name = "Content-Type") String aplication);
}
