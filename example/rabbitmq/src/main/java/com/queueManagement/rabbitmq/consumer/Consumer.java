package com.queueManagement.rabbitmq.consumer;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class Consumer {
    @RabbitListener(queues = { "${queueManagement.queue.name}" })
	public void receive(@Payload String message) {

		log.info("Received message {}", message);

		makeSlow();
    }

	private void makeSlow() {
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
