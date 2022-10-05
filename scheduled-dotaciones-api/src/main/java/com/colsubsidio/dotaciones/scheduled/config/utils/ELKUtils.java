package com.colsubsidio.dotaciones.scheduled.config.utils;

import static java.time.LocalDateTime.now;
import static java.util.Arrays.asList;
import static org.apache.commons.lang3.StringUtils.isNotBlank;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.colsubsidio.dotaciones.scheduled.repositorys.dto.KeyValue;
import com.colsubsidio.dotaciones.scheduled.repositorys.dto.UserDTO;
import com.colsubsidio.dotaciones.scheduled.repositorys.dto.Users;
import com.colsubsidio.dotaciones.scheduled.config.ELKService;
import com.colsubsidio.dotaciones.scheduled.config.exceptions.TicketOfficeException;
import com.colsubsidio.dotaciones.scheduled.repositorys.dto.ELKRequest;
import com.colsubsidio.dotaciones.scheduled.repositorys.dto.ELKRequest.AdditionalDTO;
import com.colsubsidio.dotaciones.scheduled.repositorys.dto.ELKRequest.DAODTO;
import com.colsubsidio.dotaciones.scheduled.repositorys.dto.ELKRequest.ServiceDTO;
import com.colsubsidio.dotaciones.scheduled.repositorys.dto.settings.ConstantAPI;
import com.colsubsidio.dotaciones.scheduled.repositorys.dto.settings.ELK;
import com.google.gson.Gson;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class ELKUtils implements Serializable {
	@Autowired
	ELK service;
	@Autowired
	ConstantAPI enviromentConst;
	@Autowired
	ELKService elkService;

	public <R, P> ServiceDTO<R, P> initialService(String methodName, String url, R request, String token,
			Class<P> response) {
		ServiceDTO<R, P> service = new ELKRequest().new ServiceDTO<>();
		service.setMethodName(methodName);
		service.setInitial(now());
		service.setRequest(request);
		service.setUrl(url);
		service.setToken(token);
		return service;
	}

	public <R, P> void endService(ServiceDTO<R, P> service, P response) {
		service.setEnding(now());
		if(response instanceof String) {
			service.setResponseString((String)response);
		}else {
			service.setResponse(response);
		}
		Long timeResponser = timeResponser(service.getInitial(), service.getEnding());
		service.setStartDate(service.getInitial().toString());
		service.setEndDate(service.getEnding().toString());
		service.setInitial(null);
		service.setEnding(null);
		service.setTimeResponser(timeResponser);
	}

	public <R, P> DAODTO<R, P> initialDAO(String methodName, R request, Class<P> response) {
		DAODTO<R, P> dao = new ELKRequest().new DAODTO<>();
		dao.setMethodName(methodName);
		dao.setInitial(now());
		dao.setRequest(request);
		return dao;
	}

	public <R, P> void endDAO(DAODTO<R, P> dao, P response) {
		if(response instanceof String) {
			dao.setResponseString((String)response);
		}else if(response instanceof Integer) {
			dao.setResponseInteger((Integer)response);
		}else if(response instanceof Object) {
			dao.setResponse(response);		
		}else if(response instanceof Long) {
			dao.setResponseLong((Long)response);
		}else if(response instanceof Long) {
			dao.setResponseBoolean((Boolean)response);
		}else if(response instanceof  UserDTO) {
			dao.setResponse(response);
		}
		else {
			dao.setResponseString(String.valueOf(response));
		}
		dao.setEnding(now());
		Long timeResponser = timeResponser(dao.getInitial(), dao.getEnding());
		dao.setStartDate(dao.getInitial().toString());
		dao.setEndDate(dao.getEnding().toString());
		dao.setInitial(null);
		dao.setEnding(null);
		dao.setTimeResponse(timeResponser);
	}

	private Long timeResponser(LocalDateTime initial, LocalDateTime end) {
		return end.toInstant(ZoneOffset.UTC).toEpochMilli() - initial.toInstant(ZoneOffset.UTC).toEpochMilli();
	}

	public ELKRequest initialRequest(String methodName, String requestName, String token, String refreshTime,
			KeyValue... params) {
		ELKRequest request = new ELKRequest();
		request.setChannel(service.getApp());
		request.setEnviroment(enviromentConst.getEnviroment());
		request.setMethodName(methodName);
		request.setIndex(service.getIndex());
		request.setInitial(now());
		request.setToken(token);
		request.setRefresh(refreshTime);
		request.setRequestName(requestName);
		if (ListUtils.isNotEmpty(params)) {
			request.setParams(asList(params));
		}
		return request;
	}

	public void endRequest(ELKRequest elk) {
		elk.setEnding(now());
		Long timeResponser = timeResponser(elk.getInitial(), elk.getEnding());
		elk.setTimeResponser(timeResponser);
		elk.setStartDate(elk.getInitial().toString());
		elk.setEndDate(elk.getEnding().toString());
		elk.setInitial(null);
		elk.setEnding(null);
		elkService.registerLogs(elk);
	}

	@SuppressWarnings("rawtypes")
	public void addCalls(ELKRequest elk, List list) {
		if (list != null) {
			for (Object o : list) {
				if (o instanceof AdditionalDTO) {
					if (elk.getAdditionals() == null) {
						elk.setAdditionals(new ArrayList<>());
					}
					elk.getAdditionals().add((AdditionalDTO) o);
				} else if (o instanceof ServiceDTO) {
					if (elk.getServices() == null) {
						elk.setServices(new ArrayList<>());
					}
					elk.getServices().add((ServiceDTO) o);
				} else if (o instanceof DAODTO) {
					if (elk.getDaos() == null) {
						elk.setDaos(new ArrayList<>());
					}
					elk.getDaos().add((DAODTO) o);
				} else {
					log.error("No se logro identificar el tipo de dato:: " + new Gson().toJson(o));
				}
			}
		}
	}

	public <E extends Throwable> void error(ELKRequest elk, E e) {
		if (e instanceof TicketOfficeException) {
			elk.setError(elk.new Error());
			elk.getError().setMessage(e.getMessage());
			elk.getError().setLocalizeName(e.getLocalizedMessage());
			elk.getError().setMethodName(((TicketOfficeException) e).getMethodName());
			elk.getError().setClassName(((TicketOfficeException) e).getClazzError().getSimpleName());
			addCalls(elk, ((TicketOfficeException) e).getList());
		} else if (e instanceof Exception) {
			elk.setError(elk.new Error());
			if (isNotBlank(e.getMessage())) {
				elk.getError().setMessage(e.getMessage());
			} else {
				elk.getError().setMessage(e.getCause().getMessage());
			}
			elk.getError().setLocalizeName(e.getLocalizedMessage());
		}
	}

	public <T> void response(ELKRequest request, T response) {
		if (response instanceof String) {
			request.setResponseString((String) response);
		} else if (response instanceof Integer) {
			request.setResponseInteger((Integer) response);
		} else if(response instanceof Object) {
			request.setResponseObject(response);
		}else if (response instanceof Users) {
			request.setResponseUsers((Users) response);
		} else if (	response instanceof UserDTO) {
			request.setResponseUser((UserDTO) response);
		}else {
			request.setResponseString(response.toString());
		}
	}
}
