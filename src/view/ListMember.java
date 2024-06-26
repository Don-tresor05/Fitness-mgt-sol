package view;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
import java.sql.*;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author ITC 
 */
public class ListMember extends javax.swing.JFrame {
     DefaultTableModel tablemodel = new DefaultTableModel();
    String db_url="jdbc:mysql://localhost:8080/fitness_center_mgt_solution";
    String db_username="root";
    String db_passwd="Tresor92@";

    /**
     * Creates new form ListMember
     */
    public ListMember() {
        initComponents();
        addcolumntable();
        retrievedata();
    }
      private void addcolumntable(){
        tablemodel.addColumn("Member ID");
        tablemodel.addColumn("Member Name");
        tablemodel.addColumn("Phone number");
        tablemodel.addColumn("Email");
        tablemodel.addColumn("Gender");
        tablemodel.addColumn("Location");
        tablemodel.addColumn("Age");
        tablemodel.addColumn("Amount");
        tabledata.setModel(tablemodel); 
    }
      private void retrievedata() {
    try {
        Connection con = DriverManager.getConnection(db_url, db_username, db_passwd);
        PreparedStatement st = con.prepareStatement("select * from member");
        ResultSet result = st.executeQuery();
        
        // Clear existing data in the table model
        tablemodel.setRowCount(0);

        while (result.next()) {
            tablemodel.addRow(new Object[]{
                result.getString(1),
                result.getString(2),
                result.getString(3),
                result.getString(4),
                result.getString(5),
                result.getString(6),
                result.getString(7),
                result.getString(8)
            });
        }
        con.close();
    } catch (SQLException ex) {
    }
}

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabledata = new javax.swing.JTable();
        addmemberbutton = new javax.swing.JButton();
        exitBtn = new javax.swing.JButton();
        refreshBtn = new javax.swing.JButton();
        deleteBtn = new javax.swing.JButton();
        updatememberBtn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("List Member Form");

        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 3, 18)); // NOI18N
        jLabel1.setText("GYM MEMBERS");

        tabledata.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tabledata.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jScrollPane1.setViewportView(tabledata);
        if (tabledata.getColumnModel().getColumnCount() > 0) {
            tabledata.getColumnModel().getColumn(0).setResizable(false);
            tabledata.getColumnModel().getColumn(1).setResizable(false);
        }

        addmemberbutton.setText("ADD MEMBER");
        addmemberbutton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        addmemberbutton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addmemberbuttonActionPerformed(evt);
            }
        });

        exitBtn.setBackground(new java.awt.Color(153, 153, 255));
        exitBtn.setText("Exit");
        exitBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        exitBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitBtnActionPerformed(evt);
            }
        });

        refreshBtn.setText("Refresh");
        refreshBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        refreshBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                refreshBtnActionPerformed(evt);
            }
        });

        deleteBtn.setText("Delete");
        deleteBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        deleteBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteBtnActionPerformed(evt);
            }
        });

        updatememberBtn.setText("Update");
        updatememberBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        updatememberBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updatememberBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(156, 156, 156)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(refreshBtn))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(addmemberbutton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(updatememberBtn)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(deleteBtn)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(exitBtn)
                .addGap(75, 75, 75))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 478, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(refreshBtn))
                .addGap(21, 21, 21)
                .addComponent(jScrollPane1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(addmemberbutton)
                    .addComponent(exitBtn)
                    .addComponent(deleteBtn)
                    .addComponent(updatememberBtn))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void addmemberbuttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addmemberbuttonActionPerformed
        // TODO add your handling code here:
        dispose();
        NewMember member=new NewMember();
        member.setVisible(true);
    }//GEN-LAST:event_addmemberbuttonActionPerformed

    private void exitBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitBtnActionPerformed
        // TODO add your handling code here:
         setVisible(false);
            new Home().setVisible(true);
    }//GEN-LAST:event_exitBtnActionPerformed

    private void refreshBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_refreshBtnActionPerformed
        // TODO add your handling code here:
         retrievedata();
    }//GEN-LAST:event_refreshBtnActionPerformed

    private void deleteBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteBtnActionPerformed
        // TODO add your handling code here:
      int selectedRow = tabledata.getSelectedRow();
    if (selectedRow == -1) {
        JOptionPane.showMessageDialog(this, "Please select a member to delete.");
        return; // Exit the method if no row is selected
    }

    int memberId = Integer.parseInt(tablemodel.getValueAt(selectedRow, 0).toString());

    int choice = JOptionPane.showConfirmDialog(this, "Are you sure you want to delete this member?", "Confirmation", JOptionPane.YES_NO_OPTION);
    if (choice == JOptionPane.YES_OPTION) {
        try {
            Connection con = DriverManager.getConnection(db_url, db_username, db_passwd);
            PreparedStatement st = con.prepareStatement("DELETE FROM member WHERE member_id = ?");
            st.setInt(1, memberId);
            int rowsAffected = st.executeUpdate();
            con.close();

            if (rowsAffected > 0) {
                JOptionPane.showMessageDialog(this, "Member deleted successfully.");
                retrievedata();
            } else {
                JOptionPane.showMessageDialog(this, "Failed to delete member.");
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this, "An error occurred while deleting the member.");
        }
    }
    }//GEN-LAST:event_deleteBtnActionPerformed

    private void updatememberBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updatememberBtnActionPerformed
        // TODO add your handling code here:
        dispose();
         setVisible(false);
            new Update().setVisible(true);
    }//GEN-LAST:event_updatememberBtnActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ListMember.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ListMember.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ListMember.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ListMember.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ListMember().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addmemberbutton;
    private javax.swing.JButton deleteBtn;
    private javax.swing.JButton exitBtn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton refreshBtn;
    private javax.swing.JTable tabledata;
    private javax.swing.JButton updatememberBtn;
    // End of variables declaration//GEN-END:variables
}
