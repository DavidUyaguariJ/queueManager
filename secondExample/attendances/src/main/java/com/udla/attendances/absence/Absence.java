package com.udla.attendances.absence;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

import com.udla.attendances.consumer.configuration.ConsumerConfiguration;
import com.udla.attendances.models.AttendanceModel;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class Absence {

    @RabbitListener(queues = ConsumerConfiguration.QUEUE_ATTENDANCES)
    public void registrationSuccess(AttendanceModel attendance) {
        StringBuilder message = new StringBuilder();
        message.append(attendance.getSubject()).append("\n")
            .append("Nombre: ").append(attendance.getStudentName()).append("\n")
            .append("Clase: ").append(attendance.getIdClassroom()).append("\n")
            .append("Docente: ").append(attendance.getTeacherName()).append("\n");   
        log.info(message.toString());
    }
}