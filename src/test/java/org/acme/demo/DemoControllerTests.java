package org.acme.demo;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.acme.demo.expose.DemoController;
import org.acme.demo.expose.dto.MessageDto;
import org.acme.demo.expose.dto.ResponseDto;
import org.acme.demo.service.RegisterService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

@SpringBootTest
public class DemoControllerTests {

	@Autowired
	private  DemoController demoController;
	@MockBean
	private RegisterService registerService;
	
	@Test
	void registerTextOK() {
		Mockito.when(this.registerService.registerText(Mockito.any(MessageDto.class)))
			.thenReturn(ResponseDto.builder().build());
		assertNotNull(this.demoController.registerText( Mockito.any(MessageDto.class)));
	}
}
