package com.colsubsidio.dotaciones.scheduled.repositorys.dto;

import lombok.Data;

@Data
public class AuditUniqueCode {
    private String id;
    private String fechaCambioCodigo;
    private String codigoViejo;
    private String codigoNuevo;
    private String idVenta;
    private String idDetalle;
    private String cajero;
}
