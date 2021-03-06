/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app;

/**
 *
 * @author Eco
 */


import app.models.Vaccination;
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

public class AddVaccine extends javax.swing.JFrame {

    /**
     * Creates new form AddVaccine
     */
       private static Connection conn;
       Vaccination vaccination;
       
    public AddVaccine() {
        initComponents();
        
        conn = DbConnection.getConnection();
        
        vaccination = new Vaccination();
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
        jPanel1 = new javax.swing.JPanel();
        goatTags = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        vaccinationDate = new com.toedter.calendar.JDateChooser();
        jLabel3 = new javax.swing.JLabel();
        nextDueDate = new com.toedter.calendar.JDateChooser();
        vaccinaitonName = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        cancelDeworm = new javax.swing.JButton();
        addVaccinationBtn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(61, 149, 119));

        jLabel1.setFont(new java.awt.Font("sansserif", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("New Vaccination Record");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(291, 291, 291)
                .addComponent(jLabel1)
                .addContainerGap(315, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jLabel1)
                .addContainerGap(20, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 820, 60));

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.add(goatTags, new org.netbeans.lib.awtextra.AbsoluteConstraints(343, 42, 153, -1));

        jLabel2.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        jLabel2.setText("Goat Tag");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(278, 41, -1, 30));

        jLabel4.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        jLabel4.setText("Vaccination Date");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 120, -1, 30));
        jPanel1.add(vaccinationDate, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 120, 220, 30));

        jLabel3.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        jLabel3.setText("Next Due Date");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 120, -1, 30));
        jPanel1.add(nextDueDate, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 120, 220, 30));
        jPanel1.add(vaccinaitonName, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 200, 220, -1));

        jLabel5.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        jLabel5.setText("Vaccinnation Name");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 200, -1, 30));

        cancelDeworm.setBackground(new java.awt.Color(255, 102, 102));
        cancelDeworm.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        cancelDeworm.setForeground(new java.awt.Color(255, 255, 255));
        cancelDeworm.setText("CANCEL");
        cancelDeworm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelDewormActionPerformed(evt);
            }
        });
        jPanel1.add(cancelDeworm, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 330, 150, 40));

        addVaccinationBtn.setBackground(new java.awt.Color(61, 149, 119));
        addVaccinationBtn.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        addVaccinationBtn.setForeground(new java.awt.Color(255, 255, 255));
        addVaccinationBtn.setText("ADD");
        addVaccinationBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addVaccinationBtnActionPerformed(evt);
            }
        });
        jPanel1.add(addVaccinationBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 330, 160, 40));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 820, 390));

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
        
        if (vaccinaitonName.getText().equals("") 
                || vaccinationDate.getDate() == null || nextDueDate.getDate() == null ) {
            JOptionPane.showMessageDialog(null, "All fields must be filled!");
            return false;
        } else if (vaccinationDate.getDate().compareTo(new Date()) > 0) {
            JOptionPane.showMessageDialog(null, "Please choose date which is not in the future.");
            return false;
        } else {       
            return true;
        }
    }
     
    private void addVaccinationBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addVaccinationBtnActionPerformed
        vaccination.setVaccineName(vaccinaitonName.getText());
        vaccination.setGoatTag(String.valueOf(goatTags.getSelectedItem()));

        if (validateText()) {
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            String dueDate = dateFormat.format(nextDueDate.getDate());
            String vDate = dateFormat.format(vaccinationDate.getDate());

            vaccination.setNextDueDate(dueDate);
            vaccination.setVaccinationDate(vDate);

            AppUtils.addVaccination(vaccination, this);
            HealthScreen.vaccinationTable.setModel(new DefaultTableModel(null, new Object[]{"ID", "Vaccination Date", "Vaccinaiton Name", "Next Due Date", "Goat Tag"}));
            AppUtils.fillVaccinationTable(HealthScreen.vaccinationTable, "");
        }
    }//GEN-LAST:event_addVaccinationBtnActionPerformed

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
            java.util.logging.Logger.getLogger(AddVaccine.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AddVaccine.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AddVaccine.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AddVaccine.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AddVaccine().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addVaccinationBtn;
    private javax.swing.JButton cancelDeworm;
    private javax.swing.JComboBox<String> goatTags;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private com.toedter.calendar.JDateChooser nextDueDate;
    private javax.swing.JTextField vaccinaitonName;
    private com.toedter.calendar.JDateChooser vaccinationDate;
    // End of variables declaration//GEN-END:variables
}
