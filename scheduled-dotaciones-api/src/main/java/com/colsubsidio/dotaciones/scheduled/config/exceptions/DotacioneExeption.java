package com.colsubsidio.dotaciones.scheduled.config.exceptions;


import lombok.Getter;

import lombok.Setter;

@Getter
@Setter
public class DotacioneExeption  extends RuntimeException{
	
	
	private static final long serialVersionUID = 1L;
	
	
	private String methodName;
	private String className;
	private String msjFinal;
	private String state;
	
	public DotacioneExeption() {
		super();
	}
	
	public DotacioneExeption(String error) {
		super(error);
	
	}

	public DotacioneExeption(String error, String _className,  String _methodName, String _msjFinal) {
		super(error);
		this.className = _className;
		this.methodName = _methodName;
		this.msjFinal = _msjFinal;
	}

	public DotacioneExeption(String error, String className,String methodName, String msjFinal, String state) {
		super();
		this.methodName = methodName;
		this.className = className;
		this.msjFinal = msjFinal;
		this.state = state;
	}
	
	
	
	
	
	
	
	

}
