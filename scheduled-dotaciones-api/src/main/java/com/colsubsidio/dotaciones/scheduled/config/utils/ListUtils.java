package com.colsubsidio.dotaciones.scheduled.config.utils;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public final class ListUtils {
	
	public static final String SEPARADOR_ROLES = ";";
	
	
	@SuppressWarnings("unchecked")
	public static <T> boolean isNotEmpty(T... values) {
		return values != null && values.length > 0;
	}
	

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static List join(List... lists) {
		return (List) Arrays.asList(lists).stream()
		.filter(value -> value != null)
		.flatMap(value->value.stream())
		.filter(value->value != null)
		.collect(Collectors.toList());
	}

}
