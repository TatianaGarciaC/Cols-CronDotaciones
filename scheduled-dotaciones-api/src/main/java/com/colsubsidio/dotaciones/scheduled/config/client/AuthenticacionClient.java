package com.colsubsidio.dotaciones.scheduled.config.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;

import com.colsubsidio.dotaciones.scheduled.config.FooClientConfig;
import com.colsubsidio.dotaciones.scheduled.repositorys.dto.InformationUser;
import com.colsubsidio.dotaciones.scheduled.repositorys.dto.Users;

import feign.Headers;

@FeignClient(name = "Authentication-ldap", url="${service.users.url}",configuration = FooClientConfig.class)
public interface AuthenticacionClient {
	
	@GetMapping(value="${service.users.exists}{user}",produces = MediaType.APPLICATION_JSON_VALUE,consumes =MediaType.APPLICATION_JSON_VALUE)
	@Headers("Accept: application/json")
	public InformationUser exists(@RequestHeader("iplanetDirectoryPro") String token,@PathVariable("user") String user);

	@PostMapping(value="${service.users.valid}",produces = MediaType.APPLICATION_JSON_VALUE,consumes =MediaType.APPLICATION_JSON_VALUE)
	@Headers("Accept: application/json")
	public Boolean validate(@RequestParam("tokenid") String token );

	@PostMapping(value="${service.users.create}",produces = MediaType.APPLICATION_JSON_VALUE,consumes =MediaType.APPLICATION_JSON_VALUE)
	@Headers("Accept: application/json")
	public Users create(@RequestHeader("X-OpenAM-Username")String username,@RequestHeader("X-OpenAM-Password")String password);
}
