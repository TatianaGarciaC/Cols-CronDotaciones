package com.colsubsidio.dotaciones.scheduled.repositorys.dto.solicitud.reserva;

import com.colsubsidio.dotaciones.scheduled.repositorys.dto.Response;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class ResponseSolicitudReserva {

    @JsonProperty("resultado")
    private Response response;

}
