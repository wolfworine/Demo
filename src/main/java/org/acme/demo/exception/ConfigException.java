package org.acme.demo.exception;

import java.util.ArrayList;
import java.util.List;

import lombok.Getter;

@SuppressWarnings("serial")
public class ConfigException  extends RuntimeException{
	@Getter
	private final String idRastreo;
	@Getter
	private final List<String> errores;
	
	public ConfigException(String idRastreo) {
		super("ConfigException");
		this.idRastreo = idRastreo;
		this.errores = new ArrayList<>();
	}
	
	public ConfigException(String message, String idRastreo) {
		super(message);
		this.idRastreo = idRastreo;
		this.errores = new ArrayList<>();
	}
	public ConfigException(String message, String idRastreo, List<String> errores) {
		super(message);
		this.idRastreo = idRastreo;
		this.errores = errores;
	}
}
