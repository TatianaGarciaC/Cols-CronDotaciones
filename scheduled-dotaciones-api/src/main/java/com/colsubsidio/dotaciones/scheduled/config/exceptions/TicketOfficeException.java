package com.colsubsidio.dotaciones.scheduled.config.exceptions;

import java.util.ArrayList;
import java.util.List;

import lombok.Data;

@Data
public class TicketOfficeException extends RuntimeException {

	private static final long serialVersionUID = -7641095497424839261L;
	@SuppressWarnings("rawtypes")
	private List list;
	private String methodName;
	@SuppressWarnings("rawtypes")
	private Class clazzError;
	@SuppressWarnings("rawtypes")
	public TicketOfficeException() {
		super();
		list = new ArrayList();
	}

	@SuppressWarnings("rawtypes")
	public TicketOfficeException(String error) {
		super(error);
		list = new ArrayList();
	}

	@SuppressWarnings("rawtypes")
	public TicketOfficeException(Throwable error) {
		super(error);
		list = new ArrayList();
	}

	@SuppressWarnings("rawtypes")
	public <T extends Exception> TicketOfficeException(T error) {
		super(error);
		list = new ArrayList();
	}

	@SuppressWarnings("rawtypes")
	public TicketOfficeException(String message, Throwable cause) {
		super(message, cause);
		list = new ArrayList();
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public TicketOfficeException addELK(Object elk) {
		if(elk instanceof List) {
			((List)elk).forEach(list::add);
		}else if(elk != null){
			list.add(elk);
		}
		return this;
	}
	
	public TicketOfficeException setMethodName(String methodName){
		this.methodName = methodName;
		return this;
	}
	
	@SuppressWarnings("rawtypes")
	public TicketOfficeException setClass(Class clazz) {
		this.clazzError = clazz;
		return this;
	}


	

}
