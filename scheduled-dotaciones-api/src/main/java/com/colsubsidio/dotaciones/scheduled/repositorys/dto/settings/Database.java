package com.colsubsidio.dotaciones.scheduled.repositorys.dto.settings;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableConfigurationProperties
@ConfigurationProperties(prefix = "api.database.sp")
@Data
public class Database {
	private String  saveDotacion;
	private String  delDotacion;
	private String getReportDates;
	private String guardaNuevaDotacion;
	private String editarDotacion;
	private String borrarDotacion;
	private String getReport;
	private String nuevaTalla;
	private String asignaTalla;
	private String desAsignaTalla;
	private String desAsignaPersonalizacion;
	private String borrarPersonalizacion;
	private String editarTalla;
	private String borrarTalla;
	private String crearUsuarioDotacion;
	private String editarUsuarioDotacion;
	private String eliminarUsuarioDotacion;
	private String guardaNuevaSolicitud;
	private String guardaNuevoDetalleSolicitud;
	private String guardaSolicitudEditar;
	private String guardaDetalleSolicitudEditada;
	private String guardaNuevaCantidadDotacion;
	private String guardaEdicionCantidadDotacion;
	
}