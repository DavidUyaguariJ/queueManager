package com.udla.microservice.publisher.sender.services;

import org.springframework.stereotype.Service;

import com.udla.microservice.publisher.publisher.Publisher;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class SenderService {

    private final Publisher publisher;

    public SenderService(Publisher publisher) {
        this.publisher = publisher;
    }

    public void send(String message) {
        log.info("Sending message: {}", message);
        publisher.send(message);
    }
}