package com.colsubsidio.dotaciones.scheduled.config;

import static java.util.Arrays.asList;
import static reactor.util.function.Tuples.of;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.colsubsidio.dotaciones.scheduled.config.client.AuthenticacionClient;
import com.colsubsidio.dotaciones.scheduled.repositorys.dto.InformationUser;
import com.colsubsidio.dotaciones.scheduled.repositorys.dto.Users;
import com.colsubsidio.dotaciones.scheduled.config.exceptions.TicketOfficeException;
import com.colsubsidio.dotaciones.scheduled.repositorys.dto.ELKRequest.ServiceDTO;
import com.colsubsidio.dotaciones.scheduled.repositorys.dto.settings.ConstantsService;
import com.colsubsidio.dotaciones.scheduled.config.utils.ELKUtils;

import lombok.extern.slf4j.Slf4j;
import reactor.util.function.Tuple2;

@Component
@Slf4j
public class AuthenticationService {
	@Autowired
	private ConstantsService service;
	@Autowired
	private ELKUtils elkUtils;
	@Autowired
	private AuthenticacionClient client;

	@SuppressWarnings("rawtypes")
	//@Cacheable(cacheNames = "user", key = "#key")
	public Tuple2<Users, List> create(String username, String password, String key) {
		ServiceDTO<HttpHeaders, Users> elk = null;
		String url = service.getUrl() + service.getCreate();
		try {
			HttpHeaders headers = new HttpHeaders();
			headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
			headers.set("X-OpenAM-Username", username);
			headers.set("X-OpenAM-Password", password);

			elk = elkUtils.initialService("create", url, headers, null, Users.class);

			Users response = client.create(username, password);
			elkUtils.endService(elk, response);

			return of(response, asList(elk));
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new TicketOfficeException(e).setClass(getClass()).setMethodName("create").addELK(elk);
		}
	}

	@SuppressWarnings("rawtypes")
	public Tuple2<InformationUser, List> exists(String user, String token) {
		String url = service.getUrl() + service.getExists() + user;
		ServiceDTO<HttpHeaders, InformationUser> elk = null;
		try {
			HttpHeaders headers = new HttpHeaders();
			headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
			headers.set("iplanetDirectoryPro", token);

			elk = elkUtils.initialService("exists", url, headers, token, InformationUser.class);

			InformationUser response = client.exists(token,user);
			elkUtils.endService(elk, response);
			return of(response, asList(elk));
		} catch (Exception e) {
			throw new TicketOfficeException(e).setClass(getClass()).setMethodName("exists").addELK(elk);
		}
	}

	@SuppressWarnings("rawtypes")
	public Tuple2<String, List> validate(String token) {
		ServiceDTO<HttpHeaders, String> elk = null;
		String url = service.getUrl() + service.getValid() + "?tokenid=" + token;
		try {
			RestTemplate rest = new RestTemplate();
			HttpHeaders headers = new HttpHeaders();
			headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
			elk = elkUtils.initialService("create", url, headers, token, String.class);

			HttpEntity<String> entity = new HttpEntity<>("", headers);
			String response = rest.postForObject(url, entity, String.class);
			elkUtils.endService(elk, response);
			return of(response, asList(elk));
		} catch (Exception e) {
			throw new TicketOfficeException(e).setClass(getClass()).setMethodName("validate").addELK(elk);
		}
	}
}