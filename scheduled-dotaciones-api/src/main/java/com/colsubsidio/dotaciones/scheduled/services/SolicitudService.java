package com.colsubsidio.dotaciones.scheduled.services;

import static reactor.util.function.Tuples.of;

import java.util.List;
import java.util.Objects;
import java.util.UUID;

import com.colsubsidio.dotaciones.scheduled.enums.Parametros;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.colsubsidio.dotaciones.scheduled.daos.SolicitudDao;
import com.colsubsidio.dotaciones.scheduled.repositorys.dto.Response;
import com.colsubsidio.dotaciones.scheduled.repositorys.dto.solicitud.RequestSolicitud;
import com.colsubsidio.dotaciones.scheduled.repositorys.dto.solicitud.reserva.ResponseSolicitudReserva;

import lombok.extern.slf4j.Slf4j;
import reactor.util.function.Tuple2;

@Service
@Slf4j
public class SolicitudService {


    @Autowired
    private SolicitudDao solicitudDao;


    /**
     * Solicitud de Reserva
     * @return Tipo respuesta
     */
    public ResponseSolicitudReserva solicitudReserva() {
        ResponseSolicitudReserva response;
        List<RequestSolicitud.SolicitudDTO> solicitudReserva = solicitudDao.listaSolicitudesPendientes();
        for (RequestSolicitud.SolicitudDTO solicitudDTO: solicitudReserva){
            Tuple2<Response, Integer> respuesta = generarSolicitudReserva();
            if(respuesta.getT1().getCode() == "200"){
                solicitudDTO.setReserva(respuesta.getT2());
                solicitudDTO.setEstadoSolicitud(Parametros.PARAMETRO_SOLICITUD_RESERVA_EXITOSA.toString());
            } else {
                solicitudDTO.setReserva(null);
                solicitudDTO.setEstadoSolicitud(Parametros.PARAMETRO_SOLICITUD_RESERVA_FALLIDA.toString());
            }
        }
        response = this.guardarSolicitudReserva(solicitudReserva);
        return response;
    }

    /**
     * Generar solicitud de Reserva
     * @return respuesta reserva base de datos
     */
    public Tuple2<Response, Integer> generarSolicitudReserva() {
        String uuid = UUID.randomUUID().toString().replace("-", "");
        ResponseSolicitudReserva response = new ResponseSolicitudReserva();
        Tuple2<Response, Integer> result = null;
        try {
            Double reserva  = Math.random()*1000;
            result = of(new Response("200", "Transaccion exitosa", null), reserva.intValue());
            return result;
        } catch (Exception ex) {
            log.error("{} - {}", uuid, ex.getMessage(), ex);
            response.setResponse(new Response("500", String.format("Error Nro %s guardando la reserva de dotacion generarSolicitudReserva", uuid)));
        }
        return result;
    }

    /**
     * Solicitud de Reserva
     * @return respuesta reserva base de datos
     */
    public ResponseSolicitudReserva guardarSolicitudReserva(List<RequestSolicitud.SolicitudDTO> solicitudReserva) {
        String uuid = UUID.randomUUID().toString().replace("-", "");
        ResponseSolicitudReserva response = new ResponseSolicitudReserva();
        Tuple2<Response, int[]> result = null;
        try {
            result = solicitudDao.batchUpdateReservaSolicitud(solicitudReserva,10);
            response.setResponse(result.getT1());
            return response;
        } catch (Exception ex) {
            log.error("{} - {}", uuid, ex.getMessage(), ex);
            response.setResponse(new Response("500", String.format("Error Nro %s guardando la reserva de dotacion generarSolicitudReserva", uuid)));
        }
        return response;
    }

}
