package com.colsubsidio.dotaciones.scheduled.repositorys.dto;

import lombok.Data;

@Data
public class KeyValue {
	private String key;
	private String stringValue;
	private UserDTO userValue;
	
	public static <T> KeyValue instance(String key,T value) {
		KeyValue kv = new KeyValue();
		kv.set(key);
		kv.set(value);
		return kv;
	}
	
	public <T>void set(T value) {
		if(value instanceof UserDTO) {
			this.userValue = (UserDTO)value;
		}else if(value instanceof String) {
			this.stringValue = (String)value;
		}else if(value != null){
			this.stringValue = value.toString();
		}
	}
}
