package org.acme.demo.service;

import org.acme.demo.expose.dto.MessageDto;
import org.acme.demo.expose.dto.ResponseDto;

public interface RegisterService {

	ResponseDto registerText(MessageDto messageDto);
}
