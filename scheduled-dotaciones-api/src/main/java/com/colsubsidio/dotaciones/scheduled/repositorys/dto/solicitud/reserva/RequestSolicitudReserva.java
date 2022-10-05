package com.colsubsidio.dotaciones.scheduled.repositorys.dto.solicitud.reserva;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
public class RequestSolicitudReserva {

    private Date dateMovimiento;
    private String centroLogistico;
    private String centroCosto;
    private String almacen;
    private CantidadDotacionDTO cantidadDotacionDTO;

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class CantidadDotacionDTO {

        @JsonProperty("idDotacion")
        private Integer idDotacion;

        @JsonProperty("idTipoVinculacion")
        private Integer idTipoVinculacion;

        @JsonProperty("cantidad")
        private Integer cantidad;

        @JsonProperty("nombreTipoVinculacion")
        private String nombreTipoVinculacion;

    }

}
