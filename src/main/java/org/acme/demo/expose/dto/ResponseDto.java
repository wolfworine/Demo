package org.acme.demo.expose.dto;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ResponseDto implements Serializable {
	private static final long serialVersionUID = -4056607182697359570L;
	private Integer codigo;
    private String mensajeExito;

}
