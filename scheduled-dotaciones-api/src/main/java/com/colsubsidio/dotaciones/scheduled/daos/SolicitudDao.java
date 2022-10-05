package com.colsubsidio.dotaciones.scheduled.daos;

import static reactor.util.function.Tuples.of;

import java.util.*;

import com.colsubsidio.dotaciones.scheduled.enums.Parametros;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.colsubsidio.dotaciones.scheduled.config.utils.ELKUtils;
import com.colsubsidio.dotaciones.scheduled.repositorys.dto.ELKRequest.DAODTO;
import com.colsubsidio.dotaciones.scheduled.repositorys.dto.Response;
import com.colsubsidio.dotaciones.scheduled.repositorys.dto.solicitud.RequestSolicitud;
import com.colsubsidio.dotaciones.scheduled.repositorys.dto.solicitud.RequestSolicitud.SolicitudDTO;

import lombok.extern.slf4j.Slf4j;
import reactor.util.function.Tuple2;

@Slf4j
@Repository
public class SolicitudDao {
	
	@Autowired
	private NamedParameterJdbcTemplate jdbcTemplate;

	@Autowired
	ELKUtils elkUtils;

	@Value("${api.database.query.incorporaciones.pendientes}")
	private String querySolicitudesPendientes;

	
	public List<SolicitudDTO> listaSolicitudesPendientes(){
		try {
			MapSqlParameterSource params = new MapSqlParameterSource();
			params.addValue("tipoSolicitud", Parametros.PARAMETRO_TIPO_SOLICITUD_INCORPORACION.toString());
			return jdbcTemplate.query( querySolicitudesPendientes, params, new BeanPropertyRowMapper<>(SolicitudDTO.class));
		} catch (DataAccessException ex) {
			log.error("ERROR listaSolicitudesPendientes solicitudes: ", ex);
			return Collections.emptyList();
		}
	}

	public Tuple2<Response, int[]> batchUpdateReservaSolicitud(List<RequestSolicitud.SolicitudDTO> solicitudReserva, int batchSize) {
		int[] updateCounts = new int[0];
		try {
			String sql = "UPDATE Solicitud SET reserva = :reserva, FechaModificacion=getDate(), " +
					"idEstado = (SELECT idEstado FROM Estado with(nolock) WHERE Nombre = (SELECT Valor FROM Parametros with(nolock) WHERE Nombre = :estado))" +
					" WHERE idSolicitud = :idSolicitud";

			List<Map<String, Object>> batchValues = new ArrayList<>(batchSize);

			for (RequestSolicitud.SolicitudDTO solicitudDTO: solicitudReserva) {
				batchValues.add(
						new MapSqlParameterSource("reserva", solicitudDTO.getReserva())
								.addValue("idSolicitud", solicitudDTO.getIdSolicitud())
								.addValue("estado", solicitudDTO.getEstadoSolicitud())
								.getValues());
			}
			updateCounts = jdbcTemplate.batchUpdate(sql,
					batchValues.toArray(new Map[solicitudReserva.size()]));
			return of(new Response("200", "Transaccion exitosa", null), updateCounts);
		} catch (DataAccessException ex) {
			log.error("ERROR batchUpdateReservaSolicitud: ", ex);
			return of(new Response("500", "Error batchUpdateReservaSolicitud" + ex, null), updateCounts);
		}
	}

}
