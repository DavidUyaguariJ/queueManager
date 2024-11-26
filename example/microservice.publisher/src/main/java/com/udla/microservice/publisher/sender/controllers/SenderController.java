package com.udla.microservice.publisher.sender.controllers;

import java.util.concurrent.ThreadLocalRandom;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.udla.microservice.publisher.sender.services.SenderService;

@RestController
@RequestMapping("/messages")
public class SenderController {

    private final SenderService senderService;
    
    public SenderController(SenderService senderService) {
        this.senderService = senderService;
    }

    @GetMapping("/send")
    public String send() {
        String message = "Message #"+ ThreadLocalRandom.current().nextInt();
        this.senderService.send(message);
        return "Message sent: " + message;
    }

}
