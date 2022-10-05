package com.colsubsidio.dotaciones.scheduled.config;

import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import feign.Feign;
import feign.codec.Decoder;
import feign.codec.Encoder;
import feign.gson.GsonDecoder;
import feign.gson.GsonEncoder;

@Configuration
@EnableFeignClients
public class FooClientConfig {

	@Bean
	public Feign.Builder newFeignClientBuilder() {
		return Feign.builder().encoder(new GsonEncoder()).decoder(new GsonDecoder());
	}

	@Bean
	public Encoder feignEncoder() {
		return new GsonEncoder();
	}

	@Bean
	public Decoder feignDecoder() {
		return new GsonDecoder();
	}
}
