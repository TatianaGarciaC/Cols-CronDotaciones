package com.colsubsidio.dotaciones.scheduled.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class RestTemplateUtil {

	@Autowired
	RestTemplate restTemplate;

	public <T> ResponseEntity<T> sendRequest(UriComponentsBuilder uri, HttpMethod method, Object body,
			Class<T> classOfT) throws RestClientException {
		long startTimeTry = System.currentTimeMillis();
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		HttpEntity<Object> entity = null;
		entity = (body != null) ? new HttpEntity<>(body, headers) : new HttpEntity<>(headers);
		ResponseEntity<T> resp = restTemplate.exchange(uri.toUriString(), method, entity, classOfT);
		long endTimeConn = System.currentTimeMillis() - startTimeTry;

		log.info("URL : " + uri.toUriString() + "; body : " + body + "; response : " + resp.getBody() + "; method : "
				+ method + "; codeResponse : " + resp.getStatusCode() + "; time : " + endTimeConn + ";");
		return resp;
	}
}
