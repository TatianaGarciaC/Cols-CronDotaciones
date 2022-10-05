package com.colsubsidio.dotaciones.scheduled.repositorys.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
public class HistoryCode {

	@JsonProperty("controlAcceso")
	private List<AccessControl> accessControl;
	@JsonProperty("controlConsumo")
	private List<ConsumeControl> consumeControl;
	@JsonProperty("auditoriaCodigoUnico")
	private List<AuditUniqueCode> auditUniqueCode;

}
