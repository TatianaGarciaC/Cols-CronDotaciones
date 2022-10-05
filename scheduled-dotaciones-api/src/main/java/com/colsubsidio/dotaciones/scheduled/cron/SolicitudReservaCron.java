package com.colsubsidio.dotaciones.scheduled.cron;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.colsubsidio.dotaciones.scheduled.repositorys.dto.solicitud.reserva.ResponseSolicitudReserva;
import com.colsubsidio.dotaciones.scheduled.services.SolicitudService;

@Component
public class SolicitudReservaCron {
  
	@Autowired
	SolicitudService solicitudService;
	
    @Scheduled(cron = "${cron.expression.reserva}")
    public void solicitudesReserva(){
    	ResponseSolicitudReserva response = solicitudService.solicitudReserva();
        System.out.println(response);
    }

}
