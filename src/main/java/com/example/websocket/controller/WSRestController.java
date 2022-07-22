package com.example.websocket.controller;

import com.example.websocket.dto.Message;
import com.example.websocket.service.WSService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WSRestController {

    @Autowired
    private WSService wsService;

    @PostMapping("/send-message")
    public void sendMessage(@RequestBody final Message message){
        wsService.notifyFrontend(message.getMessageContent());
    }

    @PostMapping("/send-private-message/{id}")
    public void sendPrivateMessage(@PathVariable final String id, @RequestBody final Message message){
        wsService.notifyUser(id, message.getMessageContent());
    }
}
