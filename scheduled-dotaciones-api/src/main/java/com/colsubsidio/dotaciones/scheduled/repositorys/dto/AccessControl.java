package com.colsubsidio.dotaciones.scheduled.repositorys.dto;

import lombok.Data;

@Data
public class AccessControl {

	private String id;
	private String cardUID;
	private String codBarras;
	private String fechaCreacion;
	private String fechaProximoIntento;
	private String fechaReactivacion;
	private String fechaRedencion;
	private String idDetalleVenta;
	private String idObjeto;
	private String idVenta;
	private String nombre;
	private String numeroFactura;
	private String puntoRedencion;
	private String status;
	private String tarjetaMS;
	private String tipoAcceso;
	private String usuarioReactivacion;
	private String producto_id;
	private String prioridad;
	private String fechaVencimiento;
	private String tipoTarifa;
	private String tipoBoleta;

}
