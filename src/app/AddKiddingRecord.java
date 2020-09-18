/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app;

import app.models.Kidding;
import app.screens.DewormingScreen;
import app.screens.DoeKidding;
import app.utils.AppUtils;
import connector.DbConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ButtonGroup;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import org.jdesktop.swingx.autocomplete.AutoCompleteDecorator;

/**
 *
 * @author Eco
 */
public class AddKiddingRecord extends javax.swing.JFrame {

    /**
     * Creates new form AddKiddingRecord
     */
    Kidding kidding;
    private static Connection conn;
    public AddKiddingRecord() {
        initComponents();
        kidding = new Kidding();
        
        conn = DbConnection.getConnection();
       
       AutoCompleteDecorator.decorate(goatTags);      
       AutoCompleteDecorator.decorate(kidsire);
       
        ButtonGroup bg = new ButtonGroup();
        bg.add(rbMale);
        bg.add(rbFemale);
        rbMale.setSelected(true);

       populateGoatTags();
       populateKidSire();
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
        kidsire = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        dateBred = new com.toedter.calendar.JDateChooser();
        kidName = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        rbMale = new javax.swing.JRadioButton();
        jLabel7 = new javax.swing.JLabel();
        rbFemale = new javax.swing.JRadioButton();
        goatTags = new javax.swing.JComboBox<>();
        birthWeight = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        tattoo = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        addNewKiddingBtn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(61, 149, 119));

        jLabel1.setFont(new java.awt.Font("sansserif", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("New Kidding Record");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(315, 315, 315)
                .addComponent(jLabel1)
                .addContainerGap(346, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jLabel1)
                .addContainerGap(21, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 840, 60));

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.add(kidsire, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 120, 220, -1));

        jLabel2.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        jLabel2.setText("Goat Tag");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 50, -1, 30));

        jLabel4.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        jLabel4.setText("Date Bred");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 120, -1, 30));
        jPanel1.add(dateBred, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 120, 220, 30));
        jPanel1.add(kidName, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 200, 220, -1));

        jLabel5.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        jLabel5.setText("Kid Name");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 200, 70, 30));

        jLabel6.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        jLabel6.setText("Kid Sire");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 120, 60, 30));

        rbMale.setText("Male");
        rbMale.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbMaleActionPerformed(evt);
            }
        });
        jPanel1.add(rbMale, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 260, -1, -1));

        jLabel7.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N
        jLabel7.setText("Sex");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 260, -1, -1));

        rbFemale.setText("Female");
        rbFemale.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbFemaleActionPerformed(evt);
            }
        });
        jPanel1.add(rbFemale, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 260, -1, -1));

        jPanel1.add(goatTags, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 50, 210, -1));

        birthWeight.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                birthWeightKeyPressed(evt);
            }
        });
        jPanel1.add(birthWeight, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 200, 220, -1));

        jLabel8.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        jLabel8.setText("Birth Weight (kg)");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 200, 100, 30));
        jPanel1.add(tattoo, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 50, 220, -1));

        jLabel9.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        jLabel9.setText("Tattoo");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 50, 60, 30));

        jButton1.setBackground(new java.awt.Color(255, 102, 102));
        jButton1.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("CANCEL");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 370, 140, 40));

        addNewKiddingBtn.setBackground(new java.awt.Color(61, 149, 119));
        addNewKiddingBtn.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        addNewKiddingBtn.setForeground(new java.awt.Color(255, 255, 255));
        addNewKiddingBtn.setText("ADD");
        addNewKiddingBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addNewKiddingBtnActionPerformed(evt);
            }
        });
        jPanel1.add(addNewKiddingBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 370, 140, 40));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 830, 460));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void rbMaleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbMaleActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rbMaleActionPerformed

    private void rbFemaleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbFemaleActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rbFemaleActionPerformed

    public boolean validateText() {
        
        if (tattoo.getText().equals("") || birthWeight.getText().equals("") 
                || birthWeight.getText() == null
                || kidName.getText().equals("")
                || dateBred.getDate() == null ) {
            JOptionPane.showMessageDialog(null, "All fields must be filled!");
            return false;
        } else if (dateBred.getDate().compareTo(new Date()) > 0) {
            JOptionPane.showMessageDialog(null, "Please choose date which is not in the future.");
            return false;
        } else {       
            return true;
        }
    }
    
     private void populateGoatTags() {
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement("SELECT * FROM `goat` WHERE `sex` = 'Female' ");
            
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()) {
                goatTags.addItem(rs.getString(1));
            }
        } catch (SQLException ex) {
            Logger.getLogger(AppUtils.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
     
     private void populateKidSire() {
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement("SELECT * FROM `goat` WHERE `sex` = 'Male' ");
            
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()) {
                kidsire.addItem(rs.getString(1));
            }
        } catch (SQLException ex) {
            Logger.getLogger(AppUtils.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
     
    private void addNewKiddingBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addNewKiddingBtnActionPerformed
        
        String sex = "Male";
        if (rbFemale.isSelected()) {
            sex = "Female";
        }
        
        double weight = Double.parseDouble(birthWeight.getText());
        kidding.setSex(sex);
        kidding.setKidName(kidName.getText());
        kidding.setBirthWeight(weight);
        kidding.setTattoo(tattoo.getText());
        kidding.setGoatTag(String.valueOf(goatTags.getSelectedItem()));
        kidding.setKidSire(String.valueOf(kidsire.getSelectedItem()));
        

        
        if (validateText()) {
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            String dBred = dateFormat.format(dateBred.getDate());
            kidding.setDateBred(dBred);
            
            Calendar calendar = Calendar.getInstance();
            
            try {
                calendar.setTime(dateFormat.parse(dBred));
                calendar.add(Calendar.DATE, 155); //Add estimated day of birth
                String kidDate = dateFormat.format(calendar.getTime());
                System.out.println("Estimate day: " + kidDate);
                kidding.setKiddingDate(kidDate);              
                
                AppUtils.addKidding(kidding, this);
                DoeKidding.kiddingTable.setModel(new DefaultTableModel(null, new Object[]{"ID", "Doe Tag", "Date Bred", "Kidding Date", "Kid Name", "Kid Sire", "Birth Weight", "Tattoo", "Days Remaining"}));
                AppUtils.fillKiddingTable(DoeKidding.kiddingTable, "");
                                
            } catch (ParseException ex) {
                Logger.getLogger(AddKiddingRecord.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
             JOptionPane.showMessageDialog(null, "Please check the missing fields.");
        }
    }//GEN-LAST:event_addNewKiddingBtnActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void birthWeightKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_birthWeightKeyPressed
        char c = evt.getKeyChar();
        if(Character.isLetter(c)) {
            birthWeight.setEditable(false);
        } else {
            birthWeight.setEditable(true);
        }
    }//GEN-LAST:event_birthWeightKeyPressed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optiokidsire        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
        // * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         //*/
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(AddKiddingRecord.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AddKiddingRecord.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AddKiddingRecord.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AddKiddingRecord.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AddKiddingRecord().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addNewKiddingBtn;
    private javax.swing.JTextField birthWeight;
    private com.toedter.calendar.JDateChooser dateBred;
    private javax.swing.JComboBox<String> goatTags;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JTextField kidName;
    private javax.swing.JComboBox<String> kidsire;
    private javax.swing.JRadioButton rbFemale;
    private javax.swing.JRadioButton rbMale;
    private javax.swing.JTextField tattoo;
    // End of variables declaration//GEN-END:variables
}
