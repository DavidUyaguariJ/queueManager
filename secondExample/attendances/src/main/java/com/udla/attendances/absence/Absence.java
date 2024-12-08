package com.udla.attendances.absence;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

import com.udla.attendances.consumer.configuration.ConsumerConfiguration;
import com.udla.attendances.models.AttendanceModel;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class Absence {

    @RabbitListener(queues = ConsumerConfiguration.QUEUE_ABSENCES)
    public void justificationSuccess(AttendanceModel attendance) {
        log.info("Process Absence", attendance);
    }

}
