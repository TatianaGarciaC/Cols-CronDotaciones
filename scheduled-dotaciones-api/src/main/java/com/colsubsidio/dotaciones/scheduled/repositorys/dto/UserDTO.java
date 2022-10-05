package com.colsubsidio.dotaciones.scheduled.repositorys.dto;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
public class UserDTO{
	 private String id;
	 private String username;
	 private String password;
	 private String email;
	 private String name;
	 private String phone;
    private Integer role;
    private String alliance;
    private Integer enabled;
    private Integer changePassword;
    private String resetToken;
    private String createdAt;
    private String updatedAt;
    private String usrIdCreate;
    private String usrIdUpdate;
    private List<SedesDTO> sedes;
    private ZhData zhData;
    
    @Data
    public static class ZhData{
    	private String estado;
    	private String uesNombre;
    	private Long idUes;
    	private String cargo;
    	private Long idCargo;
    	private Long idPosicion;
    	private String noDocumento;
    	private String primerNombre;
    	private String segundoNombre;
    	private String primerApellido;
    	private String segundoApellido;
    	private String genero;
    	private String fechaIngreso;
    	private boolean permiteGestion;
    	private String username;
    	private String regional;    	
    	private String tipodeVinculo;
    	private String centrodeCosto;
    }
    
    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class SedesDTO{
    	 private Long idSede;
    	 private String nombreSede;
    	 private String clima;
    	 private Long idUes;
    }
}