package com.colsubsidio.dotaciones.scheduled.config.utils;

import java.net.ConnectException;




import com.colsubsidio.dotaciones.scheduled.config.exceptions.DotacionNotAccets;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.colsubsidio.dotaciones.scheduled.config.exceptions.TicketOfficeException;

import feign.FeignException;
import feign.FeignException.Unauthorized;

public final class ResponseUtils {
	
	public static final String codigoRespuesta = "codigoRespuesta";
	public static final String descRespuesta = "descRespuesta";
	
	public static final String spOK = "200";
	
	public static <T, E extends Throwable> ResponseEntity<T> responseError(E e) {
		if (e instanceof ConnectException || e.getCause() instanceof ConnectException) {
			return ResponseEntity.status(503).build();
		}else if (e instanceof DotacionNotAccets){
			return ResponseEntity.status(402).build();
		}
		else if (e instanceof FeignException || e  instanceof TicketOfficeException || e.getCause() instanceof Unauthorized
				|| Unauthorized.class.cast(e.getCause()).status() == HttpStatus.UNAUTHORIZED.value()) {
			return ResponseEntity.status(401).build();
		}
		return ResponseEntity.status(500).build();
	}
}
