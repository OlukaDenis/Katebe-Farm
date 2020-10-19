/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app;

import app.models.Goat;
import app.models.GoatOwner;
import app.utils.AppUtils;
import connector.DbConnection;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import java.io.ByteArrayOutputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import static jdk.nashorn.internal.objects.Global.undefined;

/**
 *
 * @author Eco
 */

public class PrintReport extends javax.swing.JFrame {

    /**
     * Creates new form PrintReporrt
     */
    private Goat goat;
    private static Connection conn;
    private  Image defaultImage;
    
    public PrintReport() {
        initComponents();
        conn = DbConnection.getConnection();
        
        //default image
        try {
            defaultImage = ImageIO.read(getClass().getResource("/images/default.png"));
        } catch (Exception ex) {
             Logger.getLogger(MainApp.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    
    public void selectedGoat(Goat selectedGoat) {
        goat = selectedGoat;
        
        if (goat != null) {
            populateDetails();
        }
    }
    
    private void populateDetails() {
        goatTag.setText(goat.getID());
        goatBreed.setText(goat.getBreed());
        goatDOB.setText(goat.getBirthDate());
        goatSireTag.setText(goat.getBuck_id());
        goatDoeTag.setText(goat.getDoe_id());
        
        ImageIcon imageSide;
        if (goat.getImage_side() == null ) {
                imageSide = new ImageIcon(new ImageIcon(defaultImage)
                    .getImage()
                    .getScaledInstance(goatImage.getWidth(), goatImage.getHeight(), Image.SCALE_SMOOTH)
            );
            
        } else {
            imageSide = new ImageIcon(new ImageIcon(goat.getImage_side())
                   .getImage()
                   .getScaledInstance(goatImage.getWidth(), goatImage.getHeight(), Image.SCALE_SMOOTH)
           );
        }
        
        goatImage.setIcon(imageSide);
        getOwnerInfo();
        getHealthRecords(healthRecordsTable);
    }
    
    public void getHealthRecords(JTable table) {
        PreparedStatement ps = null;
        
        try {
           String sql = "SELECT dewormingDate, dewormerUsed, doseAdministered, vaccineName, vaccinationDate "
                + "FROM deworming "
                + "LEFT JOIN vaccination "
                + "ON deworming.goatID=vaccination.goatID "
                + "WHERE deworming.goatID=?";
            ps = conn.prepareStatement(sql); 
             ps.setString(1, goat.getID());
            ResultSet rs = ps.executeQuery();
            
          DefaultTableModel model = (DefaultTableModel)table.getModel();           
            Object[] row;
            
            while(rs.next()) {
                row = new Object[5];
                
                row[0] = rs.getString(1);                
                row[1] = rs.getString(2);
                row[2] = rs.getString(3);
                row[3] = rs.getString(4);
                row[4] = rs.getString(5);
                
                model.addRow(row);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(AppUtils.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void getOwnerInfo() {
        GoatOwner owner = new GoatOwner();
        
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement("SELECT * FROM `goatowner` WHERE `goatID` = ? ");
            ps.setString(1, goat.getID());
            
            ResultSet rs = ps.executeQuery();
          
            while(rs.next()) {
                owner.setId(rs.getInt(1));
                owner.setName(rs.getString(2));
                owner.setAdress(rs.getString(3));
                owner.setPhone(rs.getString(4));
                owner.setFarm(rs.getString(5));
                owner.setGoatTag(goat.getID());
            }
        } catch (SQLException ex) {
            Logger.getLogger(AppUtils.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
        
        if (owner != null || owner != undefined) {
            
            if (owner.getName() != null) {
                goatOwnerName.setText(owner.getName());
            } else {
                goatOwnerName.setText("No record");
            }
           
            if (owner.getAdress()!= null) {
                 goatOwnerAddress.setText(owner.getAdress());
            } else {
                goatOwnerAddress.setText("No record");
            }
           
            if (owner.getPhone()!= null) {
                goatOwnerPhone.setText(owner.getPhone());
            } else {
                goatOwnerPhone.setText("No record");
            }
           
            if (owner.getFarm()!= null) {
                goatOwnerFarm.setText(owner.getFarm());
            } else {
                 goatOwnerFarm.setText("No record");
            }
        }
    }
    
    private void PrintGoatReport(JPanel panel) {
       
       PrinterJob job = PrinterJob.getPrinterJob();
       job.setJobName("Print Goat Record");
       job.setPrintable(new Printable() {
           @Override
           public int print(Graphics graphics, PageFormat pageFormat, int pageIndex) throws PrinterException {

               if (pageIndex > 0) {
                   return Printable.NO_SUCH_PAGE;
               }
               
               Graphics2D graphics2D = (Graphics2D)graphics;
               
               graphics2D.translate(pageFormat.getImageableX()*2, pageFormat.getImageableY()*2);
               graphics2D.scale(0.5, 0.5);
               
               panel.paint(graphics2D);
               
               return Printable.PAGE_EXISTS;
           }
       });
       boolean doPrint = job.printDialog();
       
       if (doPrint) {
           try {
               job.print();
           } catch (PrinterException e) {
               JOptionPane.showMessageDialog(null, "Print error: " + e.getMessage());
           }
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

        jScrollPane2 = new javax.swing.JScrollPane();
        printJPanel = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        goatImage = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        goatSireTag = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        goatBreed = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        goatDOB = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel6 = new javax.swing.JLabel();
        goatTag = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        goatDoeTag = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel8 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        goatOwnerAddress = new javax.swing.JLabel();
        goatOwnerFarm = new javax.swing.JLabel();
        goatOwnerName = new javax.swing.JLabel();
        goatOwnerPhone = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        healthRecordsTable = new javax.swing.JTable();
        printReport = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(891, 876));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jScrollPane2.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane2.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        jScrollPane2.setPreferredSize(new java.awt.Dimension(890, 875));

        printJPanel.setBackground(new java.awt.Color(255, 255, 255));
        printJPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Calibri", 1, 36)); // NOI18N
        jLabel1.setText("KATEBE FARM LIMITED ANIMAL PROFILE RECORD");
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 20, -1, -1));

        printJPanel.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 20, 820, 80));

        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel3.add(goatImage, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 270, 250));

        printJPanel.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 160, 290, 270));

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        goatSireTag.setText("HDJ78");
        jPanel4.add(goatSireTag, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 210, 120, 20));

        jLabel4.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        jLabel4.setText("TAG NO:");
        jPanel4.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, -1, -1));

        goatBreed.setText("Local");
        jPanel4.add(goatBreed, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 110, 120, 20));

        jLabel5.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        jLabel5.setText("Date of Birth:");
        jPanel4.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, -1, -1));

        goatDOB.setText("09-04-1992");
        jPanel4.add(goatDOB, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 70, 120, 20));

        jLabel2.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        jLabel2.setText("LIINEAGE");
        jPanel4.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 159, -1, 30));
        jPanel4.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 190, 450, 10));

        jLabel6.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        jLabel6.setText("Breed:");
        jPanel4.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 110, -1, -1));

        goatTag.setText("UGONS");
        jPanel4.add(goatTag, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 30, 120, 20));

        jLabel7.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        jLabel7.setText("Doe Tag NO:");
        jPanel4.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 250, -1, -1));

        goatDoeTag.setText("SHDK90");
        jPanel4.add(goatDoeTag, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 250, 120, 20));

        jLabel9.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        jLabel9.setText("Sire Tag NO:");
        jPanel4.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 210, -1, -1));

        printJPanel.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 160, 490, 330));

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));
        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel5.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, 390, 10));

        jLabel8.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        jLabel8.setText("OWNER INFORMATION");
        jPanel5.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 9, -1, 30));

        jLabel3.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        jLabel3.setText("Farm:");
        jPanel5.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 220, -1, -1));

        jLabel10.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        jLabel10.setText("Name:");
        jPanel5.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 70, -1, -1));

        jLabel11.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        jLabel11.setText("Address:");
        jPanel5.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 120, -1, -1));

        jLabel12.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        jLabel12.setText("Phone:");
        jPanel5.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 170, -1, -1));

        goatOwnerAddress.setText("Kitintiale");
        jPanel5.add(goatOwnerAddress, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 120, 140, 20));

        goatOwnerFarm.setText("DT Farm");
        jPanel5.add(goatOwnerFarm, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 220, 140, 20));

        goatOwnerName.setText("Denis");
        jPanel5.add(goatOwnerName, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 70, 140, 20));

        goatOwnerPhone.setText("90768790");
        jPanel5.add(goatOwnerPhone, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 170, 140, 20));

        printJPanel.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 520, 420, 280));
        printJPanel.add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -60, 870, 60));

        healthRecordsTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Deworming date", "Dewormer Used", "Dose Administered", "Vaccination Name", "Vaccination date"
            }
        ));
        jScrollPane1.setViewportView(healthRecordsTable);

        printJPanel.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 820, 810, 300));

        jScrollPane2.setViewportView(printJPanel);

        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 870, 590));

        printReport.setText("Print Report");
        printReport.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                printReportActionPerformed(evt);
            }
        });
        getContentPane().add(printReport, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 20, 170, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void printReportActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_printReportActionPerformed
        // TODO add your handling code here:
        PrintGoatReport(printJPanel);
    }//GEN-LAST:event_printReportActionPerformed

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
            java.util.logging.Logger.getLogger(PrintReport.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PrintReport.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PrintReport.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PrintReport.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PrintReport().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel goatBreed;
    private javax.swing.JLabel goatDOB;
    private javax.swing.JLabel goatDoeTag;
    private javax.swing.JLabel goatImage;
    private javax.swing.JLabel goatOwnerAddress;
    private javax.swing.JLabel goatOwnerFarm;
    private javax.swing.JLabel goatOwnerName;
    private javax.swing.JLabel goatOwnerPhone;
    private javax.swing.JLabel goatSireTag;
    private javax.swing.JLabel goatTag;
    private javax.swing.JTable healthRecordsTable;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JPanel printJPanel;
    private javax.swing.JButton printReport;
    // End of variables declaration//GEN-END:variables
}
