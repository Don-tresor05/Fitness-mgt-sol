package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Attendance;

public class AttendanceDao {
    private String jdbcUrl = "jdbc:mysql://localhost:8080/fitness_center_mgt_solution"; // Corrected JDBC URL port
    private String dbUsername = "root";
    private String dbPasswd = "Tresor92@";

    public Integer addAttendance(Attendance attendance) {
        try (Connection con = DriverManager.getConnection(jdbcUrl, dbUsername, dbPasswd);
             PreparedStatement pst = con.prepareStatement("INSERT INTO Attendance (member_id, attendance_date, check_in_time) VALUES (?, ?, ?)")) {
            pst.setInt(1, attendance.getMemberId());
            pst.setDate(2, attendance.getAttendanceDate());
            pst.setTime(3, attendance.getCheckInTime());
            int rowAffected = pst.executeUpdate();
            return rowAffected;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return null;
        }
    }

    public Integer updateAttendance(Attendance attendance) {
    try (Connection con = DriverManager.getConnection(jdbcUrl, dbUsername, dbPasswd);
         PreparedStatement pst = con.prepareStatement("UPDATE Attendance SET member_id = ?, attendance_date = ?, check_in_time = ? WHERE attendance_id = ?")) {
        pst.setInt(1, attendance.getMemberId());
        pst.setDate(2, attendance.getAttendanceDate());
        pst.setTime(3, attendance.getCheckInTime());
        pst.setInt(4, attendance.getAttendanceId());
        int rowsAffected = pst.executeUpdate();
        return rowsAffected;
    } catch (SQLException ex) {
        ex.printStackTrace();
        return null;
    }
}

public Integer deleteAttendance(int attendanceId) {
    try (Connection con = DriverManager.getConnection(jdbcUrl, dbUsername, dbPasswd);
         PreparedStatement pst = con.prepareStatement("DELETE FROM Attendance WHERE attendance_id = ?")) {
        pst.setInt(1, attendanceId);
        int rowsAffected = pst.executeUpdate();
        return rowsAffected;
    } catch (SQLException ex) {
        ex.printStackTrace();
        return null;
    }
}

    
    
    public List<Attendance> retrieveAllAttendances() {
        List<Attendance> attendanceList = new ArrayList<>();
        try (Connection con = DriverManager.getConnection(jdbcUrl, dbUsername, dbPasswd);
             PreparedStatement pst = con.prepareStatement("SELECT * FROM Attendance");
             ResultSet rs = pst.executeQuery()) {
            while (rs.next()) {
                Attendance attendance = new Attendance();
                attendance.setAttendanceId(rs.getInt("attendance_id"));
                attendance.setMemberId(rs.getInt("member_id"));
                attendance.setAttendanceDate(rs.getDate("attendance_date"));
                attendance.setCheckInTime(rs.getTime("check_in_time"));
                attendanceList.add(attendance);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return attendanceList;
    }

    public List<Attendance> retrieveAttendanceByMemberId(int memberId) {
        List<Attendance> attendanceList = new ArrayList<>();
        try (Connection con = DriverManager.getConnection(jdbcUrl, dbUsername, dbPasswd);
             PreparedStatement pst = con.prepareStatement("SELECT * FROM Attendance WHERE member_id = ?")) {
            pst.setInt(1, memberId);
            try (ResultSet rs = pst.executeQuery()) {
                while (rs.next()) {
                    Attendance attendance = new Attendance();
                    attendance.setAttendanceId(rs.getInt("attendance_id"));
                    attendance.setMemberId(rs.getInt("member_id"));
                    attendance.setAttendanceDate(rs.getDate("attendance_date"));
                    attendance.setCheckInTime(rs.getTime("check_in_time"));
                    attendanceList.add(attendance);
                }
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return attendanceList;
    }

   
}
