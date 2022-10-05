package com.colsubsidio.dotaciones.scheduled.repositorys.dto;
import static com.colsubsidio.dotaciones.scheduled.config.utils.Constants.SPACE;
import lombok.Data;

@Data
public class TokenLoggerResponse {
	private String access_token;
	private String type;
	private String userName;
	private Long issued_at;
	private String expires_id;
	
	public String token(){
		return type+SPACE+access_token;
	}
}
