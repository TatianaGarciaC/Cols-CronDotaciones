package com.colsubsidio.dotaciones.scheduled.config;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.core.Version;
import com.fasterxml.jackson.databind.*;
import com.fasterxml.jackson.databind.deser.std.StringDeserializer;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.fasterxml.jackson.databind.util.StdDateFormat;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import feign.Logger;
import feign.codec.Decoder;

import java.io.IOException;
import java.util.TimeZone;

import org.springframework.beans.factory.ObjectFactory;
import org.springframework.boot.autoconfigure.http.HttpMessageConverters;
import org.springframework.cloud.openfeign.support.ResponseEntityDecoder;
import org.springframework.cloud.openfeign.support.SpringDecoder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;

/**
 * @author Daniel Rojas | Componente de configuracion encargado
 * de parametrizar el cliente rest de OpenFeign
 */
@Configuration
public class RestClientConfig {
	 /**
     * Método encargado de configurar el decodificador de Jackson para el cliente REST
     * de OpenFeign
     * @return decodificador de cliente rest OpenFeign
     */
    @Bean
    public Decoder feignDecoder() {
        HttpMessageConverter<?> jacksonConverter = new MappingJackson2HttpMessageConverter(customObjectMapper());
        ObjectFactory<HttpMessageConverters> objectFactory = () -> new HttpMessageConverters(jacksonConverter);
        return new ResponseEntityDecoder(new SpringDecoder(objectFactory));
    }

    /**
     * Configuración de mapper para la respuesta del cliente REST en el cual no se envían
     * como JSON los valores nulos
     * @return Objeto de mapeo de Jackson para convertir la respuesta del cliente en un POJO
     */
    @Bean
    public ObjectMapper customObjectMapper() {
        SimpleModule nullTextToNullModule = new SimpleModule("nullTextToNullModule", Version.unknownVersion())
                .addDeserializer(String.class, nullTextDeserializer());

        ObjectMapper objectMapper = new ObjectMapper();
        StdDateFormat dateFormat = new StdDateFormat();
        dateFormat.setTimeZone(TimeZone.getDefault());
        objectMapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        objectMapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
        objectMapper.setDateFormat(dateFormat);
        objectMapper.registerModule(nullTextToNullModule);
        objectMapper.registerModule(new JavaTimeModule());
        return objectMapper;
    }

    /**
     * Componente encargado de convertir la respuesta { "propiedad": "null" } en un texto vacío
     * de la forma { "propiedad": "" }
     * @return Deserealizador de JSON
     */
    @Bean
    public JsonDeserializer<String> nullTextDeserializer() {
        return new JsonDeserializer<String>() {
            @Override
            public String deserialize(JsonParser jsonParser, DeserializationContext ctxt) throws IOException {
                if (jsonParser.getCurrentToken() == JsonToken.VALUE_STRING && jsonParser.getText().trim().equals("null")) {
                    return "";
                }
                return StringDeserializer.instance.deserialize(jsonParser, ctxt);
            }
        };
    }

    /**
     * Componente encarga de marcar el log del cliente Feign como FULL
     * @return Nivel del log del cliente Feign
     */
    @Bean
    public Logger.Level feignLoggerLevel() {
        return Logger.Level.FULL;
    }
}
