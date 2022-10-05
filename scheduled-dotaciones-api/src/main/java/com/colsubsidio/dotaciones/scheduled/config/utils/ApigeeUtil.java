package com.colsubsidio.dotaciones.scheduled.config.utils;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;

import org.springframework.stereotype.Component;

/**
 * @author Daniel Rojas | Componente utilitario para el manejo de Apigee
 */

@Component
public class ApigeeUtil {
	 /**
     * Metodo encargado de validar si el JWT de Apigee se encuentra expirado
     * @param dateLong fecha de creacion del token en ms
     * @param expirationMinutes minutos expira el JWT
     * @return true si el JWT expiro
     */
	public boolean isAuthExpired(Long dateLong, Integer expirationMinutes) {
		LocalDateTime oAuthDate = LocalDateTime.ofInstant(Instant.ofEpochMilli(dateLong), ZoneId.systemDefault());
		long minutesSinceGettedToken = oAuthDate.until(LocalDateTime.now(), ChronoUnit.MINUTES);
		return minutesSinceGettedToken >= expirationMinutes;
	}
}
