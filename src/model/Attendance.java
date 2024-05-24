/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;
import java.sql.Date;
import java.sql.Time;
/**
 *
 * @author ITC
 */
public class Attendance {
    private int attendanceId;
    private int memberId;
    private Date attendanceDate;
    private Time checkInTime;

    public Attendance() {
    }

    public Attendance(Integer attendanceId) {
        this.attendanceId = attendanceId;
    }

    public Attendance(Integer attendanceId, Integer memberId, Date attendanceDate, Time checkInTime) {
        this.attendanceId = attendanceId;
        this.memberId = memberId;
        this.attendanceDate = attendanceDate;
        this.checkInTime = checkInTime;
    }

    public Integer getAttendanceId() {
        return attendanceId;
    }

    public void setAttendanceId(Integer attendanceId) {
        this.attendanceId = attendanceId;
    }

    public Integer getMemberId() {
        return memberId;
    }

    public void setMemberId(Integer memberId) {
        this.memberId = memberId;
    }

    public Date getAttendanceDate() {
        return attendanceDate;
    }

    public void setAttendanceDate(Date attendanceDate) {
        this.attendanceDate = attendanceDate;
    }

    public Time getCheckInTime() {
        return checkInTime;
    }

    public void setCheckInTime(Time checkInTime) {
        this.checkInTime = checkInTime;
    }
}
