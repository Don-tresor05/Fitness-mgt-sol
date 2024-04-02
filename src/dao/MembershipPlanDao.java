/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import model.MembershipPlan;
/**
 *
 * @author ITC
 */
public class MembershipPlanDao {
     private String jdbcUrl = "jdbc:mysql://localhost:8080/fitness_center_mgt_solution";
    private String dbUsername = "root";
    private String dbPasswd = "Tresor92@";

     public Integer saveMembershipPlan(MembershipPlan plan) {
        try (Connection con = DriverManager.getConnection(jdbcUrl, dbUsername, dbPasswd)) {
            String sql = "INSERT INTO MembershipPlans (plan_id, plan_name, details, duration, price) VALUES (?, ?, ?, ?, ?)";
            try (PreparedStatement pst = con.prepareStatement(sql)) {
                pst.setInt(1, plan.getPlanId());
                pst.setString(2, plan.getPlanName());
                pst.setString(3, plan.getPlanDetails());
                pst.setInt(4, plan.getPlanDuration());
                pst.setDouble(5, plan.getPlanPrice());
                return pst.executeUpdate();
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }

    public Integer updateMembershipPlan(MembershipPlan plan) {
        try (Connection con = DriverManager.getConnection(jdbcUrl, dbUsername, dbPasswd)) {
            String sql = "UPDATE MembershipPlans SET plan_name=?, details=?, duration=?, price=? WHERE plan_id=?";
            try (PreparedStatement pst = con.prepareStatement(sql)) {
                pst.setString(1, plan.getPlanName());
                pst.setString(2, plan.getPlanDetails());
                pst.setInt(3, plan.getPlanDuration());
                pst.setDouble(4, plan.getPlanPrice());
                pst.setInt(5, plan.getPlanId());
                return pst.executeUpdate();
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }

    public Integer deleteMembershipPlan(int planId) {
        try (Connection con = DriverManager.getConnection(jdbcUrl, dbUsername, dbPasswd)) {
            String sql = "DELETE FROM MembershipPlans WHERE plan_id=?";
            try (PreparedStatement pst = con.prepareStatement(sql)) {
                pst.setInt(1, planId);
                return pst.executeUpdate();
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }

    public MembershipPlan findMembershipPlanById(int planId) {
        try (Connection con = DriverManager.getConnection(jdbcUrl, dbUsername, dbPasswd)) {
            String sql = "SELECT * FROM MembershipPlans WHERE plan_id=?";
            try (PreparedStatement pst = con.prepareStatement(sql)) {
                pst.setInt(1, planId);
                try (ResultSet rs = pst.executeQuery()) {
                    if (rs.next()) {
                        MembershipPlan plan = new MembershipPlan();
                        plan.setPlanId(rs.getInt("plan_id"));
                        plan.setPlanName(rs.getString("plan_name"));
                        plan.setPlanDetails(rs.getString("details"));
                        plan.setPlanDuration(rs.getInt("duration"));
                        plan.setPlanPrice(rs.getDouble("price"));
                        return plan;
                    }
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }

    public List<MembershipPlan> retrieveAllMembershipPlans() {
        List<MembershipPlan> plans = new ArrayList<>();
        try (Connection con = DriverManager.getConnection(jdbcUrl, dbUsername, dbPasswd)) {
            String sql = "SELECT * FROM MembershipPlans";
            try (PreparedStatement pst = con.prepareStatement(sql)) {
                try (ResultSet rs = pst.executeQuery()) {
                    while (rs.next()) {
                        MembershipPlan plan = new MembershipPlan();
                        plan.setPlanId(rs.getInt("plan_id"));
                        plan.setPlanName(rs.getString("plan_name"));
                        plan.setPlanDetails(rs.getString("details"));
                        plan.setPlanDuration(rs.getInt("duration"));
                        plan.setPlanPrice(rs.getDouble("price"));
                        plans.add(plan);
                    }
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return plans;
    }
}
