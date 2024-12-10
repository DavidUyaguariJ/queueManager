package com.udla.banner.attendance.services;

import org.springframework.stereotype.Service;

import com.udla.banner.attendance.models.AttendanceModel;
import com.udla.banner.publisher.Publisher;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@RequiredArgsConstructor
public class AttendanceService {

    private final Publisher publisher;

    public AttendanceModel registerAttendance(AttendanceModel attendance) {
        this.publisher.sendTopicMessage(attendance, "share.register.attendance");
        return attendance;
    }

    public AttendanceModel justifyAbsences(AttendanceModel attendance) {
        this.publisher.sendFanoutMessage(attendance);
        return attendance;
    }
}
