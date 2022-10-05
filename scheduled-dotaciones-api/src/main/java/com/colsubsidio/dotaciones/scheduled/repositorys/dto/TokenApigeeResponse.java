package com.colsubsidio.dotaciones.scheduled.repositorys.dto;

import com.google.gson.annotations.SerializedName;

import lombok.Data;

@Data
public class TokenApigeeResponse {
	private String refresh_token_expires_in;
	private String api_product_list;
	private String[] api_product_list_json;
	private String organizaction_name;
	@SerializedName(value = "developer.email")
	private String developer_email;
	private String token_type;
	private String issued_at;
	private String client_id;
	private String access_token;
	private String application_name;
	private String scope;
	private String expires_in;
	private String refresh_count;
	private String status;
}
