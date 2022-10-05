package com.colsubsidio.dotaciones.scheduled.config.utils;

import org.apache.logging.log4j.util.Strings;

import java.util.Objects;

public class Constants {
	public final static String CONST_STATUS_ACTIVATED = "Valido";
	public final static String CONST_STATUS_UNACTIVATED = "InValido";
	public final static String CONST_BOOLEAN_TRUE = "boolean=true";
	public final static String CONST_BOOLEAN_FALSE = "boolean=false";
	public final static String HEADER_AUTHORIZATION = "authorization";
	public final static String HEADER_REFRESH = "refreshToken";
	public final static String SPACE = " ";
	public static final String AUTHORIZATION_HEADER = "Authorization";
	public final static String LOGIN_USER =  "loginUser";

	public static boolean isNullOrEmpty(String[] valores){
		for (String valor : valores) {
			if (Objects.isNull(valor) || Strings.isEmpty(valor)){
				return true;
			}
		}
		return false;
	}
}
