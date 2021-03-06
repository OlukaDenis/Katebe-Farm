/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.screens;

import app.AddKiddingRecord;
import app.UpdateKiddingRecord;
import app.models.Kidding;
import static app.screens.HealthScreen.dewormingTable;
import app.utils.AppUtils;
import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.plaf.basic.BasicInternalFrameUI;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Eco
 */
public class DoeKidding extends javax.swing.JInternalFrame {

    /**
     * Creates new form DoeKidding
     */
    
    DefaultTableModel model;
    public DoeKidding() {
        initComponents();
        
        AppUtils.fillKiddingTable(kiddingTable, "");
        model = (DefaultTableModel)kiddingTable.getModel();
        kiddingTable.setRowHeight(40);
        kiddingTable.setSelectionBackground(Color.decode("#66cc99"));
        
        this.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));
        BasicInternalFrameUI bi = (BasicInternalFrameUI)this.getUI();
        bi.setNorthPane(null);
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
        jScrollPane1 = new javax.swing.JScrollPane();
        kiddingTable = new javax.swing.JTable();
        addKiddingBtn = new javax.swing.JButton();

        setPreferredSize(new java.awt.Dimension(920, 610));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        kiddingTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Doe Tag", "Date Bred", "Kidding Date", "Sex", "Kid Name", "Kid Sire", "Birth Weight", "Tattoo", "Days Remaining"
            }
        ));
        kiddingTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                kiddingTableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(kiddingTable);

        addKiddingBtn.setText("Add Kidding Record");
        addKiddingBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addKiddingBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 910, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(addKiddingBtn)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 24, Short.MAX_VALUE)
                .addComponent(addKiddingBtn)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 510, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 910, 580));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void addKiddingBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addKiddingBtnActionPerformed
        AddKiddingRecord kidding = new AddKiddingRecord();
        kidding.setVisible(true);
        kidding.pack();
        kidding.setLocationRelativeTo(null);
        kidding.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }//GEN-LAST:event_addKiddingBtnActionPerformed

    private void kiddingTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_kiddingTableMouseClicked
         int rowIndex = kiddingTable.getSelectedRow();
         Kidding mKidding = AppUtils.singleKidding(model.getValueAt(rowIndex, 0).toString());
         
         UpdateKiddingRecord updateKidding = new UpdateKiddingRecord();
        updateKidding.getSelectedKidding(mKidding);

        updateKidding.setVisible(true);
        updateKidding.pack();
        updateKidding.setLocationRelativeTo(null);
        updateKidding.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
         
    }//GEN-LAST:event_kiddingTableMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addKiddingBtn;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    public static javax.swing.JTable kiddingTable;
    // End of variables declaration//GEN-END:variables
}
