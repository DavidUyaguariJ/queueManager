package com.udla.banner.publisher;


import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;

import com.udla.banner.attendance.models.AttendanceModel;
import com.udla.banner.publisher.configuration.PublisherConfiguration;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class Publisher {

    private final RabbitTemplate rabbitTemplate;

    public void sendTopicMessage(AttendanceModel attendance, String routingKey) {
        this.rabbitTemplate.convertAndSend(PublisherConfiguration.EXCHANGE_TOPIC, routingKey, attendance);
    }
    public void sendFanoutMessage(AttendanceModel attendance) {
        this.rabbitTemplate.convertAndSend(PublisherConfiguration.EXCHANGE_FANOUT,"",attendance);
    }
}
