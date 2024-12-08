package com.udla.notifications.email;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

import com.udla.notifications.consumer.configuration.ConsumerConfiguration;
import com.udla.notifications.models.AttendanceModel;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@Slf4j
public class emailNotification {

    @RabbitListener(queues = ConsumerConfiguration.QUEUE_ATTENDANCE)
    public void registrationSuccess(AttendanceModel attendance) {
        log.info("Sending email: {}", attendance);
    }

    @RabbitListener(queues = ConsumerConfiguration.QUEUE_ABSENCES)
    public void justificationSuccess(AttendanceModel attendance) {
        log.info("Sending email: {}", attendance);
    }

}
