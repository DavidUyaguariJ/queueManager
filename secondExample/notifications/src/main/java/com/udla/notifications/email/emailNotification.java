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

    @RabbitListener(queues = ConsumerConfiguration.QUEUE_NOTIFICATIONS)
    public void justificationSuccess(AttendanceModel attendance) {
        StringBuilder message = new StringBuilder();
        message.append(attendance.getSubject()).append("\n")
            .append("Nombre: ").append(attendance.getStudentName()).append("\n")
            .append("Clase: ").append(attendance.getIdClassroom()).append("\n")
            .append("Docente: ").append(attendance.getTeacherName()).append("\n");
        log.info(message.toString());
    }
}