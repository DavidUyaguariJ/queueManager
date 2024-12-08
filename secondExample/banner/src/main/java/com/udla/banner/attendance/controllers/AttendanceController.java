package com.udla.banner.attendance.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.udla.banner.attendance.models.AttendanceModel;
import com.udla.banner.attendance.services.AttendanceService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@RequestMapping(path="/attendance")
public class AttendanceController {

    private final AttendanceService attendanceService;

    @PostMapping("/register")
    public ResponseEntity<AttendanceModel> registerAttendance(@RequestBody AttendanceModel attendance) {
        return ResponseEntity.ok(this.attendanceService.registerAttendance(attendance));
    }

    @PostMapping("/justify")
    public ResponseEntity<AttendanceModel> justifyAbsences(@RequestBody AttendanceModel attendance) {
        return ResponseEntity.ok(this.attendanceService.justifyAbsences(attendance));
    }

}
