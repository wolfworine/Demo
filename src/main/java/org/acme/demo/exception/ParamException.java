package org.acme.demo.exception;

import java.util.ArrayList;
import java.util.List;

import lombok.Getter;

@SuppressWarnings("serial")
public class ParamException  extends RuntimeException{
	@Getter
	private final String idRastreo;
	@Getter
	private final List<String> errores;
	
	public ParamException(String idRastreo) {
		super("ParamException");
		this.idRastreo = idRastreo;
		this.errores = new ArrayList<>();
	}
	
	public ParamException(String message, String idRastreo) {
		super(message);
		this.idRastreo = idRastreo;
		this.errores = new ArrayList<>();
	}
	public ParamException(String message, String idRastreo, List<String> errores) {
		super(message);
		this.idRastreo = idRastreo;
		this.errores = errores;
	}
}
