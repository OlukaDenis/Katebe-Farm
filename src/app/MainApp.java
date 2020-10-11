/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app;

import app.models.Goat;
import app.screens.HealthScreen;
import app.screens.DoeKidding;
import app.screens.Home;
import app.screens.GoatOwnerScreen;
import app.screens.MonetaryScreen;
import app.utils.AppUtils;
import java.awt.Color;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Eco
 */
public class MainApp extends javax.swing.JFrame {

  
    Color panelDefault;
    Color panelClick;
    Color fontColor;
    
    DefaultTableModel model;
    public MainApp() {
        initComponents();
            
        panelDefault = new Color(51, 153, 102);
        panelClick = new Color(179, 255, 215);
        fontColor = new Color(0, 0, 0);
        homeJpanel.setBackground(panelClick); 
        homeText.setForeground(fontColor);
        healthJpanel.setBackground(panelDefault);
        
        Home home = new Home();
        container.add(home).setVisible(true);
       
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
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        healthJpanel = new javax.swing.JPanel();
        dewormingText = new javax.swing.JLabel();
        homeJpanel = new javax.swing.JPanel();
        homeText = new javax.swing.JLabel();
        vaccinationJpanel = new javax.swing.JPanel();
        vaccintionText = new javax.swing.JLabel();
        kiddingJpanel = new javax.swing.JPanel();
        kiddingText = new javax.swing.JLabel();
        expenseJpanel = new javax.swing.JPanel();
        expenseText = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        registered_goats = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        container = new javax.swing.JDesktopPane();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(32, 96, 64));

        jLabel2.setFont(new java.awt.Font("sansserif", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("LIMITED");

        jLabel1.setFont(new java.awt.Font("sansserif", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("KATEBE FARM");

        healthJpanel.setBackground(new java.awt.Color(51, 153, 102));
        healthJpanel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                healthJpanelMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                healthJpanelMousePressed(evt);
            }
        });

        dewormingText.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N
        dewormingText.setForeground(new java.awt.Color(255, 255, 255));
        dewormingText.setText("HEALTH RECORDS");

        javax.swing.GroupLayout healthJpanelLayout = new javax.swing.GroupLayout(healthJpanel);
        healthJpanel.setLayout(healthJpanelLayout);
        healthJpanelLayout.setHorizontalGroup(
            healthJpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(healthJpanelLayout.createSequentialGroup()
                .addGap(86, 86, 86)
                .addComponent(dewormingText)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        healthJpanelLayout.setVerticalGroup(
            healthJpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(healthJpanelLayout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(dewormingText)
                .addContainerGap(19, Short.MAX_VALUE))
        );

        homeJpanel.setBackground(new java.awt.Color(51, 153, 102));
        homeJpanel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                homeJpanelMousePressed(evt);
            }
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                homeJpanelMouseClicked(evt);
            }
        });

        homeText.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N
        homeText.setForeground(new java.awt.Color(255, 255, 255));
        homeText.setText("HOME");

        javax.swing.GroupLayout homeJpanelLayout = new javax.swing.GroupLayout(homeJpanel);
        homeJpanel.setLayout(homeJpanelLayout);
        homeJpanelLayout.setHorizontalGroup(
            homeJpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(homeJpanelLayout.createSequentialGroup()
                .addGap(119, 119, 119)
                .addComponent(homeText)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        homeJpanelLayout.setVerticalGroup(
            homeJpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(homeJpanelLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(homeText)
                .addContainerGap(16, Short.MAX_VALUE))
        );

        vaccinationJpanel.setBackground(new java.awt.Color(51, 153, 102));
        vaccinationJpanel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                vaccinationJpanelMousePressed(evt);
            }
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                vaccinationJpanelMouseClicked(evt);
            }
        });

        vaccintionText.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N
        vaccintionText.setForeground(new java.awt.Color(255, 255, 255));
        vaccintionText.setText("GOAT OWNERS");

        javax.swing.GroupLayout vaccinationJpanelLayout = new javax.swing.GroupLayout(vaccinationJpanel);
        vaccinationJpanel.setLayout(vaccinationJpanelLayout);
        vaccinationJpanelLayout.setHorizontalGroup(
            vaccinationJpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(vaccinationJpanelLayout.createSequentialGroup()
                .addGap(94, 94, 94)
                .addComponent(vaccintionText)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        vaccinationJpanelLayout.setVerticalGroup(
            vaccinationJpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(vaccinationJpanelLayout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(vaccintionText)
                .addContainerGap(19, Short.MAX_VALUE))
        );

        kiddingJpanel.setBackground(new java.awt.Color(51, 153, 102));
        kiddingJpanel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                kiddingJpanelMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                kiddingJpanelMousePressed(evt);
            }
        });

        kiddingText.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N
        kiddingText.setForeground(new java.awt.Color(255, 255, 255));
        kiddingText.setText("DOE'S KIDDING");

        javax.swing.GroupLayout kiddingJpanelLayout = new javax.swing.GroupLayout(kiddingJpanel);
        kiddingJpanel.setLayout(kiddingJpanelLayout);
        kiddingJpanelLayout.setHorizontalGroup(
            kiddingJpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(kiddingJpanelLayout.createSequentialGroup()
                .addGap(97, 97, 97)
                .addComponent(kiddingText)
                .addContainerGap(99, Short.MAX_VALUE))
        );
        kiddingJpanelLayout.setVerticalGroup(
            kiddingJpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(kiddingJpanelLayout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(kiddingText)
                .addContainerGap(25, Short.MAX_VALUE))
        );

        expenseJpanel.setBackground(new java.awt.Color(51, 153, 102));
        expenseJpanel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                expenseJpanelMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                expenseJpanelMousePressed(evt);
            }
        });

        expenseText.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N
        expenseText.setForeground(new java.awt.Color(255, 255, 255));
        expenseText.setText("EXPENSES");

        javax.swing.GroupLayout expenseJpanelLayout = new javax.swing.GroupLayout(expenseJpanel);
        expenseJpanel.setLayout(expenseJpanelLayout);
        expenseJpanelLayout.setHorizontalGroup(
            expenseJpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, expenseJpanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(expenseText)
                .addGap(107, 107, 107))
        );
        expenseJpanelLayout.setVerticalGroup(
            expenseJpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, expenseJpanelLayout.createSequentialGroup()
                .addContainerGap(20, Short.MAX_VALUE)
                .addComponent(expenseText)
                .addGap(18, 18, 18))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(homeJpanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(vaccinationJpanel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(healthJpanel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(kiddingJpanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(80, 80, 80)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(43, 43, 43)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(45, Short.MAX_VALUE))
            .addComponent(expenseJpanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6)
                .addComponent(jLabel2)
                .addGap(62, 62, 62)
                .addComponent(homeJpanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(healthJpanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(vaccinationJpanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(kiddingJpanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(expenseJpanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(201, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 280, 670));

        jPanel2.setBackground(new java.awt.Color(61, 149, 119));

        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Registered Goats:");

        registered_goats.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        registered_goats.setForeground(new java.awt.Color(255, 255, 255));
        registered_goats.setText("0");

        jButton1.setBackground(new java.awt.Color(255, 153, 0));
        jButton1.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Logout");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(registered_goats)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 653, Short.MAX_VALUE)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(17, 17, 17))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(registered_goats))
                .addContainerGap(26, Short.MAX_VALUE))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 0, 920, 60));

        javax.swing.GroupLayout containerLayout = new javax.swing.GroupLayout(container);
        container.setLayout(containerLayout);
        containerLayout.setHorizontalGroup(
            containerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 920, Short.MAX_VALUE)
        );
        containerLayout.setVerticalGroup(
            containerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 610, Short.MAX_VALUE)
        );

        getContentPane().add(container, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 60, 920, 610));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // Logout
        Login login = new Login();
        login.setVisible(true);
        login.pack();
        login.setLocationRelativeTo(null);
        this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void homeJpanelMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_homeJpanelMousePressed
        homeJpanel.setBackground(panelClick); 
        kiddingJpanel.setBackground(panelDefault); 
        vaccinationJpanel.setBackground(panelDefault); 
        healthJpanel.setBackground(panelDefault);
        expenseJpanel.setBackground(panelDefault); 
        
        vaccintionText.setForeground(Color.WHITE);
        kiddingText.setForeground(Color.WHITE);
        expenseText.setForeground(Color.WHITE);
        homeText.setForeground(Color.BLACK);
        dewormingText.setForeground(Color.WHITE);
    }//GEN-LAST:event_homeJpanelMousePressed

    private void healthJpanelMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_healthJpanelMousePressed
        homeJpanel.setBackground(panelDefault); 
        kiddingJpanel.setBackground(panelDefault); 
        vaccinationJpanel.setBackground(panelDefault); 
        healthJpanel.setBackground(panelClick);
        expenseJpanel.setBackground(panelDefault); 
        
        vaccintionText.setForeground(Color.WHITE);
        kiddingText.setForeground(Color.WHITE);
        expenseText.setForeground(Color.WHITE);
        homeText.setForeground(Color.WHITE);
        dewormingText.setForeground(Color.BLACK);
    }//GEN-LAST:event_healthJpanelMousePressed

    private void homeJpanelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_homeJpanelMouseClicked
        container.removeAll();
        Home home = new Home();
        container.add(home).setVisible(true);
    }//GEN-LAST:event_homeJpanelMouseClicked

    private void healthJpanelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_healthJpanelMouseClicked
        container.removeAll(); 
        HealthScreen deworm = new HealthScreen();
        container.add(deworm).setVisible(true);
    }//GEN-LAST:event_healthJpanelMouseClicked

    private void vaccinationJpanelMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_vaccinationJpanelMousePressed
        homeJpanel.setBackground(panelDefault); 
        kiddingJpanel.setBackground(panelDefault); 
        vaccinationJpanel.setBackground(panelClick); 
        healthJpanel.setBackground(panelDefault);
        expenseJpanel.setBackground(panelDefault); 
        
        vaccintionText.setForeground(Color.BLACK);
        kiddingText.setForeground(Color.WHITE);
        expenseText.setForeground(Color.WHITE);
        homeText.setForeground(Color.WHITE);
        dewormingText.setForeground(Color.WHITE);
    }//GEN-LAST:event_vaccinationJpanelMousePressed

    private void vaccinationJpanelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_vaccinationJpanelMouseClicked
        container.removeAll(); 
        GoatOwnerScreen vaccine = new GoatOwnerScreen();
        container.add(vaccine).setVisible(true);
    }//GEN-LAST:event_vaccinationJpanelMouseClicked

    public void showKiddingRecords() {
        homeJpanel.setBackground(panelDefault); 
        kiddingJpanel.setBackground(panelClick); 
        vaccinationJpanel.setBackground(panelDefault); 
        healthJpanel.setBackground(panelDefault);
        expenseJpanel.setBackground(panelDefault); 
        
        vaccintionText.setForeground(Color.WHITE);
        kiddingText.setForeground(Color.BLACK);
        expenseText.setForeground(Color.WHITE);
        homeText.setForeground(Color.WHITE);
        dewormingText.setForeground(Color.WHITE);
    }
    
    public void loadKiddingScreen() {
        container.removeAll(); 
        DoeKidding kidding = new DoeKidding();
        container.add(kidding).setVisible(true);
    }
    
    private void kiddingJpanelMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_kiddingJpanelMousePressed
        showKiddingRecords();
    }//GEN-LAST:event_kiddingJpanelMousePressed

    private void kiddingJpanelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_kiddingJpanelMouseClicked
        loadKiddingScreen();
    }//GEN-LAST:event_kiddingJpanelMouseClicked

    private void expenseJpanelMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_expenseJpanelMousePressed
        homeJpanel.setBackground(panelDefault); 
        kiddingJpanel.setBackground(panelDefault); 
        vaccinationJpanel.setBackground(panelDefault); 
        expenseJpanel.setBackground(panelClick); 
        healthJpanel.setBackground(panelDefault);
        
        vaccintionText.setForeground(Color.WHITE);
        expenseText.setForeground(Color.BLACK);
        kiddingText.setForeground(Color.WHITE);
        homeText.setForeground(Color.WHITE);
        dewormingText.setForeground(Color.WHITE);
    }//GEN-LAST:event_expenseJpanelMousePressed

    private void expenseJpanelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_expenseJpanelMouseClicked
        container.removeAll(); 
        MonetaryScreen monetary = new MonetaryScreen();
        container.add(monetary).setVisible(true);
    }//GEN-LAST:event_expenseJpanelMouseClicked

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
            java.util.logging.Logger.getLogger(MainApp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainApp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainApp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainApp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainApp().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JDesktopPane container;
    private javax.swing.JLabel dewormingText;
    public static javax.swing.JPanel expenseJpanel;
    private javax.swing.JLabel expenseText;
    public static javax.swing.JPanel healthJpanel;
    public static javax.swing.JPanel homeJpanel;
    private javax.swing.JLabel homeText;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    public static javax.swing.JPanel kiddingJpanel;
    private javax.swing.JLabel kiddingText;
    public static javax.swing.JLabel registered_goats;
    public static javax.swing.JPanel vaccinationJpanel;
    private javax.swing.JLabel vaccintionText;
    // End of variables declaration//GEN-END:variables
}
