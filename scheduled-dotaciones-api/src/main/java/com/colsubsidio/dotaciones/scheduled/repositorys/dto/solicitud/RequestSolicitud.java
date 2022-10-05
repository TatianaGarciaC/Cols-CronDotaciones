package com.colsubsidio.dotaciones.scheduled.repositorys.dto.solicitud;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
public class RequestSolicitud {
	
	private String username;
	private Long idUes;
	private Long idCargo;
	private String genero;
	private String clima;
	private Long celular;
	private String usuarioGuarda;
	private Long idSede;
	private String regional;
	private String tipodeVinculo;
	private Integer idSolicitud;
	private String estadoSolicitud;
	private String tipoSolicitud;
	private String observaciones;
	private String documento;
	private Boolean editar;
	private String centrodeCosto;
	private List<DotacionTallaDTO> dotacion;
	private Integer reserva;
	
	@Data
	@NoArgsConstructor
	@AllArgsConstructor
	@XmlAccessorType(XmlAccessType.FIELD)
	@XmlType(name = "dotacion", propOrder = {
		    "idDotacion",
		    "nombre",
		    "talla"
		})
	public static class DotacionTallaDTO {
		@JsonProperty("idDotacion")
		private Long idDotacion;
		@JsonProperty("nombre")
		private String nombreDotacion;
		@JsonProperty("talla")
		private TallaDTO talla;
	}

	@Data
	@NoArgsConstructor
	@AllArgsConstructor
	@XmlAccessorType(XmlAccessType.FIELD)
	@XmlType(name = "dotacion", propOrder = {
			"idDotacion",
			"nombre",
			"clima",
			"genero",
			"estado"
	})
	public static class DotacionDTO {
		@JsonProperty("idDotacion")
		private Integer idDotacion;
		@JsonProperty("nombre")
		private String nombre;
		@JsonProperty("clima")
		private String clima;
		@JsonProperty("genero")
		private String genero;
		@JsonProperty("estado")
		private String estado;
		@JsonProperty("username")
		private String username;
		@JsonProperty("fechaRegistro")
		private String fechaRegistro;
		@JsonProperty("fechaActualizacion")
		private String fechaActualizacion;
		@JsonProperty("documento")
		private String documento;
		@JsonProperty("celular")
		private String celular;
		@JsonProperty("observaciones")
		private String observaciones;
		@JsonProperty("idCargo")
		private Integer idCargo;
		@JsonProperty("idUes")
		private Integer idUes;
		@JsonProperty("idSede")
		private Integer idSede;
		@JsonProperty(value = "tallas", required = false)
		private List<TallaDTO> tallas;
	}
	
	@Data
	@NoArgsConstructor
	@AllArgsConstructor
	@XmlAccessorType(XmlAccessType.FIELD)
	@XmlType(name = "solicitud", propOrder = {
			"idSolicitud",
			"nombre",
			"cargo",
			"clima",
			"genero",
			"estadoSolicitud",
			"idRegional",
			"IdDotacion",
			"IdTalla",
			"idTipoVinculacion",
			"observaciones",
			"idSede",
			"celular",
			"sede",
			"fechaRegistro",
			"usuarioRegistro",
			"regional",
			"tipoVinculacion",
			"centroLogistico",
			"almacen",
			"centrodeCosto",
			"ciudad",
			"direccion",
			"reserva"
	})
	public static class SolicitudDTO {
		@JsonProperty("idSolicitud")
		private Integer idSolicitud;
		@JsonProperty("nombre")
		private String nombre;
		@JsonProperty("clima")
		private String clima;
		@JsonProperty("genero")
		private String genero;
		@JsonProperty("username")
		private String username;
		@JsonProperty("fechaRegistro")
		private String fechaRegistro;
		@JsonProperty("fechaActualizacion")
		private String fechaActualizacion;
		@JsonProperty("idRegional")
		private Integer idRegional;
		@JsonProperty("idTipoVinculacion")
		private Integer idTipoVinculacion;
		@JsonProperty("estadoSolicitud")
		private String estadoSolicitud;
		@JsonProperty("tipoSolicitud")
		private String tipoSolicitud;
		@JsonProperty("documento")
		private String documento;
		@JsonProperty("celular")
		private String celular;
		@JsonProperty("observaciones")
		private String observaciones;
		@JsonProperty("Cargo")
		private String cargo;
		@JsonProperty("idCargo")
		private Integer idCargo;
		@JsonProperty("idUes")
		private Integer idUes;
		@JsonProperty("idSede")
		private Integer idSede;
		@JsonProperty("sede")
		private String sede;
		@JsonProperty("IdDotacion")
		private Integer IdDotacion;
		@JsonProperty("IdTalla")
		private String IdTalla;
		@JsonProperty("usuarioRegistro")
		private String usuarioRegistro;
		@JsonProperty("regional")
		private String regional;
		@JsonProperty("tipoVinculacion")
		private String tipoVinculacion;
		@JsonProperty("centroLogistico")
		private String centroLogistico;
		@JsonProperty("almacen")
		private String almacen;
		@JsonProperty("centrodeCosto")
		private String centrodeCosto;
		@JsonProperty("ciudad")
		private String ciudad;
		@JsonProperty("direccion")
		private String direccion;
		@JsonProperty("reserva")
		private Integer reserva;

	}

	@Data
	@NoArgsConstructor
	@AllArgsConstructor
	@XmlAccessorType(XmlAccessType.FIELD)
	@XmlType(name = "dotacion", propOrder = {
			"documento",
			"nombre"
	})
	public static class EmpleadoDto{
		@JsonProperty("documento")
		private String documento;
		@JsonProperty("nombre")
		private String nombre;
		@JsonProperty("cargo")
		private String cargo;
		@JsonProperty("genero")
		private String genero;
		@JsonProperty("textoBusqueda")
		private String textoBusqueda;
		@JsonProperty(value = "personalizaciones",required = false)
		private List<RequestSolicitud.DotacionDTO> personalizaciones;
		@JsonProperty("nombreCompleto")
		private String nombreCompleto;
		@JsonProperty(value = "dotaciones", required = false)
		private List<Integer> dotaciones;
	}
	
	@Data
	@NoArgsConstructor
	@AllArgsConstructor
	public static class TallaDTO {
		private Long idTalla;
		private Integer idDotacion;

		@JsonProperty("nombre")
		private String nombre;

		@JsonProperty("fechaActualizacion")
		private String fechaActualizacion;

		@JsonProperty("fechaCreacion")
		private String fechaCreacion;

		@JsonProperty("estado")
		private String estado;

		@JsonProperty("username")
		private String username;
	}
	@Data
	@NoArgsConstructor
	@AllArgsConstructor
	@XmlAccessorType(XmlAccessType.FIELD)
	@XmlType(name = "regional", propOrder = {
			"idRegional",
			"Nombre"
	})
	public static class RegionalDTO {
		@JsonProperty("idRegional")
		private Integer idRegional;
		@JsonProperty("Nombre")
		private String nombre;
		@JsonProperty("FechaRegistro")
		private String fechaRegistro;	
		@JsonProperty("Almacen")
		private String almacen;
		@JsonProperty("CentroLogistico")
		private String centroLogistico;
		}
	@Data
	@NoArgsConstructor
	@AllArgsConstructor
	@XmlAccessorType(XmlAccessType.FIELD)
	@XmlType(name = "tipovinculacion", propOrder = {
			"idTipoVinculacion",
			"Nombre",
			
	})
	public static class TipoVinculacionDTO {
		@JsonProperty("idTipoVinculacion")
		private Integer idTipoVinculacion;
		@JsonProperty("Nombre")
		private String nombre;
		@JsonProperty("FechaSistema")
		private String fechaRegistro;	
		}

}
