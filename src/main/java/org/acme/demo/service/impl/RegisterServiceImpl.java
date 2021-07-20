package org.acme.demo.service.impl;


import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.util.Base64;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;

import org.acme.demo.dao.entity.MessageEntity;
import org.acme.demo.dao.repository.MessageRepository;
import org.acme.demo.exception.ConfigException;
import org.acme.demo.exception.ParamException;
import org.acme.demo.expose.dto.MessageDto;
import org.acme.demo.expose.dto.ResponseDto;
import org.acme.demo.service.RegisterService;
import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class RegisterServiceImpl implements RegisterService {

  @Value("${list.of.destinys}")
  private List<String> destinys;

  @Value("${list.of.type.messages}")
  private List<String> typeMessages;
  
  @Value("${folder.directory}")
  private String folderDir;


  @Autowired
  private MessageRepository messageRepository;

  @Override
  public ResponseDto registerText(MessageDto messageDto) {
    try {
      validateConfigurate(destinys, typeMessages);
      validateMessage(messageDto);
      updateMessage(typeMessages,messageDto);
      destinys.stream().parallel().forEach(
          r -> {operation(r, messageDto);}
        );
    } catch (ConfigException | ParamException e) {
      e.printStackTrace();
      log.error(e.toString());
    }catch (Exception e) {
        e.printStackTrace();
        log.error(e.toString());
      }

    return null;
  }

  private void operation(String operator, MessageDto messageDto) {
    if (operator.equals("Database")) saveDb(messageDto);

    if (operator.equals("Console")) saveLog(messageDto);

    if (operator.equals("File")) saveFile(messageDto);
  }

  private void updateMessage(List<String>  typeMessages,MessageDto messageDto) {
 	  String l="%text " + DateFormat.getDateInstance(DateFormat.LONG).format(new Date()) + " %txt2";
 	  int i=0;
 	  for (String string : typeMessages) {
 		 i++;
 		 if(string.equals(messageDto.getMessageType())){
 			String cadena=l.replace("%text",messageDto.getMessageType()).replace("%txt2", messageDto.getMessageText());
 			messageDto.setMessageText(cadena);
 			messageDto.setIdType(Long.valueOf(i));
 		  }
	  }

	  }

  private void saveDb(MessageDto messageDto) {
    MessageEntity entity = new MessageEntity();
    entity.setMessage(messageDto.getMessageText());
    entity.setIdType(messageDto.getIdType());
    messageRepository.save(entity);
  }

private void saveLog(MessageDto messageDto) {
    log.info(Level.INFO + " " + messageDto.getMessageText());
  }

private void saveFile(MessageDto messageDto){
	  File logFile = new File (folderDir,"logFile.txt");
      if (!logFile.exists()) {
    	  try {
    		  byte[] archivoByte = messageDto.getMessageText().getBytes();
              FileUtils.writeByteArrayToFile(logFile, archivoByte);
              log.info(Level.INFO + " " + messageDto.getMessageText());
		} catch (IOException e) {
		    e.printStackTrace();
		      log.error(e.toString());
		}
    
      }

  }

  private void validateConfigurate(List<String> list1, List<String> list2) {
    if (list1.isEmpty() && list2.isEmpty()) throw new ConfigException(
      "Invalid configuration"
    );
  }

  private void validateMessage(MessageDto messageDto) {
    if (
      messageDto.getMessageText().trim().isEmpty() &&
      messageDto.getMessageType().isEmpty()
    ) throw new ParamException("MessageText or optiosn must be specified");
  }
}
