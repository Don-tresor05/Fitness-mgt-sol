package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import model.Member;

public class MemberDao {
    private String jdbcUrl = "jdbc:mysql://localhost:8080/fitness_center_mgt_solution";
    private String dbUsername = "root";
    private String dbPasswd = "Tresor92@";

    public Integer saveMember(Member member) {
        try {
            Connection con = DriverManager.getConnection(jdbcUrl, dbUsername, dbPasswd);
        String sql = "INSERT INTO member (member_id, member_name, phone_number, email, gender, location, age, amount) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        PreparedStatement pst = con.prepareStatement(sql);
        pst.setInt(1, member.getMemberId());
        pst.setString(2, member.getName());
        pst.setString(3, member.getPhoneNumber());
        pst.setString(4, member.getEmail());
        pst.setString(5, member.getGender());
        pst.setString(6, member.getLocation());
        pst.setInt(7, member.getAge());
        pst.setDouble(8, member.getAmount());
        int rowAffected = pst.executeUpdate();
        con.close();
        return rowAffected;
    } catch (Exception ex) {
        ex.printStackTrace();
        }
        return null;
    }

   public Integer updateMember(Member member) {
    try {
        // Check if the member with the given ID exists
        if (findMemberById(member.getMemberId()) != null) {
            Connection con = DriverManager.getConnection(jdbcUrl, dbUsername, dbPasswd);
            String sql = "UPDATE member SET member_name=?, phone_number=?, email=?, gender=?, location=?, age=?, amount=? WHERE member_id=?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, member.getName());
            pst.setString(2, member.getPhoneNumber());
            pst.setString(3, member.getEmail());
            pst.setString(4, member.getGender());
            pst.setString(5, member.getLocation());
            pst.setInt(6, member.getAge());
            pst.setDouble(7, member.getAmount());
            pst.setInt(8, member.getMemberId());
            Integer rowAffected = pst.executeUpdate();
            con.close();
            return rowAffected;
        } else {
            // Member with the given ID not found
            return null;
        }
    } catch (Exception ex) {
        ex.printStackTrace();
    }
    return null;
}


    public Integer SearchDeleteMember(Member member) {
    try {
        // Check if the member with the given ID exists
        if (findMemberById(member.getMemberId()) != null) {
            Connection con = DriverManager.getConnection(jdbcUrl, dbUsername, dbPasswd);
            String sql = "DELETE FROM member WHERE member_id=?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setInt(1, member.getMemberId());
            Integer rowAffected = pst.executeUpdate();
            con.close();
            return rowAffected;
        } else {
            // Member with the given ID not found
            return null;
        }
    } catch (Exception ex) {
        ex.printStackTrace();
    }
    return null;
}
    
    
    public Integer deleteMember(Member member) {
    try {
        // Check if the member with the given ID exists
        if (findMemberById(member.getMemberId()) != null) {
            Connection con = DriverManager.getConnection(jdbcUrl, dbUsername, dbPasswd);
            String sql = "DELETE FROM member WHERE member_id=?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setInt(1, member.getMemberId());
            Integer rowAffected = pst.executeUpdate();
            con.close();
            return rowAffected;
        } else {
            // Member with the given ID not found
            return null;
        }
    } catch (Exception ex) {
        ex.printStackTrace();
        return null;
    }
}



    public Member findMemberById(int memberId) {
    try {
        Connection con = DriverManager.getConnection(jdbcUrl, dbUsername, dbPasswd);
        String sql = "SELECT * FROM member WHERE member_id = ?";
        PreparedStatement pst = con.prepareStatement(sql);
        pst.setInt(1, memberId);
        ResultSet rs = pst.executeQuery();
        
        // Check if a member with the given ID exists
        if (rs.next()) {
            // Retrieve member details from the result set and create a Member object
            Member member = new Member();
            member.setMemberId(rs.getInt("member_id"));
            member.setName(rs.getString("member_name")); // Corrected column name
            member.setPhoneNumber(rs.getString("phone_number"));
            member.setEmail(rs.getString("email"));
            member.setGender(rs.getString("gender"));
            member.setLocation(rs.getString("location"));
            member.setAge(rs.getInt("age"));
            member.setAmount(rs.getDouble("amount"));
            
            con.close();
            return member;
        } else {
            // No member found with the given ID
            return null;
        }
    } catch (Exception ex) {
        ex.printStackTrace();
    }
    return null;
}


    public List<Member> retrieveAllMembers() {
        try {
            Connection con = DriverManager.getConnection(jdbcUrl, dbUsername, dbPasswd);
            String sql = "SELECT * FROM member";
            PreparedStatement pst = con.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            List<Member> memberList = new ArrayList<>();
            while (rs.next()) {
                Member member = new Member();
                member.setMemberId(rs.getInt("member_id"));
                member.setName(rs.getString("name"));
                member.setPhoneNumber(rs.getString("phone_number"));
                member.setEmail(rs.getString("email"));
                member.setGender(rs.getString("gender"));
                member.setLocation(rs.getString("location"));
                member.setAge(rs.getInt("age"));
                member.setAmount(rs.getDouble("amount"));
                memberList.add(member);
            }
            con.close();
            return memberList;
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }

   


    
    }

