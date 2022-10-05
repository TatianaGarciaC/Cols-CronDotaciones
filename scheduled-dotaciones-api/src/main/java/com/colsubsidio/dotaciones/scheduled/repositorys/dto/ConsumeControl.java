package com.colsubsidio.dotaciones.scheduled.repositorys.dto;

import lombok.Data;

@Data
public class ConsumeControl {

    private String id;
    private String idVenta;
    private String idDetalleVenta;
    private String nombre;
    private String status;
    private String fechaCreacion;
    private String fechaRedencion;
    private String fechaVigencia;
    private String fechaReactivacion;
    private String numeroFactura;
    private String producto_id;
    private String idObjeto;
    private String puntoRedencion;
    private String usuarioRedencion;
    private String puntoReactivacion;
    private String usuarioReactivacion;
    private String codBarras;

}
