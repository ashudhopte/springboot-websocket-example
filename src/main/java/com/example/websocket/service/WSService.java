package com.example.websocket.service;

import com.example.websocket.dto.ResponseMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Service;

@Service
public class WSService {

    private final SimpMessagingTemplate simpMessagingTemplate;

    @Autowired
    public WSService(SimpMessagingTemplate simpMessagingTemplate) {
        this.simpMessagingTemplate = simpMessagingTemplate;
    }

    public void notifyFrontend(final String message){

        ResponseMessage responseMessage = new ResponseMessage("response "+message);

        simpMessagingTemplate.convertAndSend("/topic/messages", responseMessage);
    }

    public void notifyUser(final String id, final String message){

        ResponseMessage responseMessage = new ResponseMessage("private response "+message);

        simpMessagingTemplate.convertAndSendToUser(id, "/topic/messages", responseMessage);
    }
}
