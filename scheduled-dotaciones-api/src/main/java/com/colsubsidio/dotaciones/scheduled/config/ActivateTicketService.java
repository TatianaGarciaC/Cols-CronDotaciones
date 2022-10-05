package com.colsubsidio.dotaciones.scheduled.config;

import java.util.List;
import static java.util.Arrays.asList;
import javax.ws.rs.core.MultivaluedHashMap;
import javax.ws.rs.core.MultivaluedMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.util.UriComponentsBuilder;

import com.colsubsidio.dotaciones.scheduled.config.exceptions.TicketOfficeException;
import com.colsubsidio.dotaciones.scheduled.repositorys.dto.ELKRequest.ServiceDTO;
import com.colsubsidio.dotaciones.scheduled.repositorys.dto.settings.Services;
import com.colsubsidio.dotaciones.scheduled.config.utils.ELKUtils;

import lombok.extern.slf4j.Slf4j;
import reactor.util.function.Tuple2;
import reactor.util.function.Tuples;

@Slf4j
@Component
public class ActivateTicketService {

	@Autowired
	Services services;
	@Autowired
	ELKUtils elkUtils;

	@Autowired
	private RestTemplateUtil restTemplateUtil;

	@SuppressWarnings("rawtypes")
	public Tuple2<ResponseEntity<Boolean>,List> getActiveTicket(boolean activate, String ticket, String mifareId) {
		ResponseEntity<Boolean> response = null;
		ServiceDTO<MultivaluedMap<String, Object>, ResponseEntity> elk = null;
		try {
			String url = services.getTicketManagement();
			MultivaluedMap<String, Object> params = new MultivaluedHashMap<>();
			params.add("activar", activate);
			params.add("codigo", ticket);
			params.add("mifare", mifareId);
			
			elk = elkUtils.initialService("getActiveTicket", url, params, null, ResponseEntity.class);

			UriComponentsBuilder uri = UriComponentsBuilder.fromHttpUrl(url)
					.queryParam("activar", activate).queryParam("codigo", ticket).queryParam("mifare", mifareId);
			response = restTemplateUtil.sendRequest(uri, HttpMethod.GET, null, Boolean.class);
			elkUtils.endService(elk, response);
			return Tuples.of(response,asList(elk));
		} catch (Exception ex) {
			throw new TicketOfficeException(ex).setClass(getClass()).setMethodName("getActiveTicket").addELK(elk);
		}
	}
}
