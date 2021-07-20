package org.acme.demo.expose;

import org.acme.demo.expose.dto.MessageDto;
import org.acme.demo.expose.dto.ResponseDto;
import org.acme.demo.service.RegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/demo/")
public class DemoController {

  @Autowired
  private RegisterService registerService;

  @PostMapping("")
  @ResponseStatus(HttpStatus.CREATED)
  public ResponseEntity<ResponseDto> registerText(
    @RequestBody MessageDto messageDto
  ) {
    return ResponseEntity.ok(registerService.registerText(messageDto));
  }
}
