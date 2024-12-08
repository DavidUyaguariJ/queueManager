package com.udla.notifications.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AttendanceModel {
    private long idAttendance;
    private long idClassroom;
    private long idTeacher;
    private String idSudentBanner;
    private String studentName;
    private String className;
    private String teacherName;
}
