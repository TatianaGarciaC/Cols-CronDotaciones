package com.colsubsidio.dotaciones.scheduled.services;

import com.colsubsidio.dotaciones.scheduled.repositorys.dto.Response;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Autowired;
import reactor.util.function.Tuple2;

import static org.mockito.Mockito.when;
import static reactor.util.function.Tuples.of;
public class SolicitudServiceTest {
    @InjectMocks
    SolicitudService solicitudService;

    @Before
    public void setUp() throws Exception {
    }

    @Test
    public void guardarSolicitudReserva() {
        Tuple2<Response, Integer> result = null;
        Double reserva  = Math.random()*1000;
        result = of(new Response("200", "Transaccion exitosa", null), reserva.intValue());
        when(solicitudService.generarSolicitudReserva()).thenReturn(result);
    }
}