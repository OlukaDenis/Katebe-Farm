/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app;

import app.models.Deworming;
import app.screens.HealthScreen;
import app.utils.AppUtils;
import connector.DbConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import org.jdesktop.swingx.autocomplete.AutoCompleteDecorator;

/**
 *
 * @author Eco
 */
public class AddDeworming extends javax.swing.JFrame {

    /**
     * Creates new form AddDeworming
     */
    Deworming deworming;
    private static Connection conn;
    
    public AddDeworming() {
        initComponents();
        deworming = new Deworming();
        conn = DbConnection.getConnection();
       
       AutoCompleteDecorator.decorate(goatTags);
       populateGoatTags();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        dDewormingDate = new com.toedter.calendar.JDateChooser();
        jLabel3 = new javax.swing.JLabel();
        dNextDueDate = new com.toedter.calendar.JDateChooser();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        dDewormerUsed = new javax.swing.JTextField();
        dDoseAdministered = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        cancelDeworm = new javax.swing.JButton();
        addDeworming = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        goatTags = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(61, 149, 119));

        jLabel1.setFont(new java.awt.Font("sansserif", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("New Deworming Record");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(291, 291, 291)
                .addComponent(jLabel1)
                .addContainerGap(386, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jLabel1)
                .addContainerGap(20, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 890, 60));
        getContentPane().add(dDewormingDate, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 190, 220, 30));

        jLabel3.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        jLabel3.setText("Next Due Date");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 190, -1, 30));
        getContentPane().add(dNextDueDate, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 190, 220, 30));

        jLabel4.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        jLabel4.setText("Deworming Date");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 190, -1, 30));

        jLabel5.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        jLabel5.setText("Dewormer Used");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 270, -1, 30));
        getContentPane().add(dDewormerUsed, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 270, 220, -1));
        getContentPane().add(dDoseAdministered, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 270, 220, -1));

        jLabel6.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        jLabel6.setText("Dose Administered");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 270, -1, 30));

        cancelDeworm.setBackground(new java.awt.Color(255, 102, 102));
        cancelDeworm.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        cancelDeworm.setForeground(new java.awt.Color(255, 255, 255));
        cancelDeworm.setText("CANCEL");
        cancelDeworm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelDewormActionPerformed(evt);
            }
        });
        getContentPane().add(cancelDeworm, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 400, 150, 40));

        addDeworming.setBackground(new java.awt.Color(61, 149, 119));
        addDeworming.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        addDeworming.setForeground(new java.awt.Color(255, 255, 255));
        addDeworming.setText("ADD");
        addDeworming.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addDewormingActionPerformed(evt);
            }
        });
        getContentPane().add(addDeworming, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 400, 160, 40));

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.add(goatTags, new org.netbeans.lib.awtextra.AbsoluteConstraints(343, 42, 153, -1));

        jLabel2.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        jLabel2.setText("Goat Tag");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(278, 41, -1, 30));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 810, 430));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void addDewormingActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addDewormingActionPerformed
        deworming.setDewormUsed(dDewormerUsed.getText());
        deworming.setGoatTag(String.valueOf(goatTags.getSelectedItem()));
        deworming.setDoseAdministered(dDoseAdministered.getText());
      

        if (validateText()) {
             SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            String dueDate = dateFormat.format(dNextDueDate.getDate());            
            String dDate = dateFormat.format(dDewormingDate.getDate());

            deworming.setNextDueDate(dueDate);
            deworming.setDewormingDate(dDate);
            
            AppUtils.addDeworming(deworming, this);
            HealthScreen.dewormingTable.setModel(new DefaultTableModel(null, new Object[]{"ID", "DewormingDate", "Dewormer Used", "Dose Admnistered", "Next Due Date", "Goat Tag"}));
            AppUtils.fillGoatTable(HealthScreen.dewormingTable, "");
        }
    }//GEN-LAST:event_addDewormingActionPerformed

    private void cancelDewormActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelDewormActionPerformed
        this.dispose();
    }//GEN-LAST:event_cancelDewormActionPerformed

    private void populateGoatTags() {
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement("SELECT * FROM goat");
            
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()) {
                goatTags.addItem(rs.getString(1));
            }
        } catch (SQLException ex) {
            Logger.getLogger(AppUtils.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    public boolean validateText() {
        
        if (dDewormerUsed.getText().equals("") || dDoseAdministered.getText().equals("")
                || dDewormingDate.getDate() == null || dNextDueDate.getDate() == null ) {
            JOptionPane.showMessageDialog(null, "All fields must be filled!");
            return false;
        } else if (dDewormingDate.getDate().compareTo(new Date()) > 0) {
            JOptionPane.showMessageDialog(null, "Please choose date which is not in the future.");
            return false;
        } else {       
            return true;
        }
    }
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
            java.util.logging.Logger.getLogger(AddDeworming.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AddDeworming.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AddDeworming.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AddDeworming.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AddDeworming().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addDeworming;
    private javax.swing.JButton cancelDeworm;
    private javax.swing.JTextField dDewormerUsed;
    private com.toedter.calendar.JDateChooser dDewormingDate;
    private javax.swing.JTextField dDoseAdministered;
    private com.toedter.calendar.JDateChooser dNextDueDate;
    private javax.swing.JComboBox<String> goatTags;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    // End of variables declaration//GEN-END:variables
}
