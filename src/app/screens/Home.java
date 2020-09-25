/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.screens;

import app.AddGoat;
import app.UpdateGoat;
import app.models.Goat;
import app.utils.AppUtils;
import connector.DbConnection;
import java.awt.Color;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.plaf.basic.BasicInternalFrameUI;
import javax.swing.table.DefaultTableModel;
import org.jdesktop.swingx.autocomplete.AutoCompleteDecorator;

/**
 *
 * @author Eco
 */
public class Home extends javax.swing.JInternalFrame {

    /**
     * Creates new form Home
     */
    private DefaultTableModel model;
    private static Connection conn;
     
    public Home() {
        initComponents();
        
        conn = DbConnection.getConnection();             
//        AutoCompleteDecorator.decorate(filterGoatTag);
       
        AppUtils.fillGoatTable(AllGoatsTable, "");
        model = (DefaultTableModel)AllGoatsTable.getModel();
        AllGoatsTable.setRowHeight(40);
        AllGoatsTable.setSelectionBackground(Color.decode("#66cc99"));
        
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

        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        AllGoatsTable = new javax.swing.JTable();
        jButton2 = new javax.swing.JButton();
        searchGoat = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        statusFilter = new javax.swing.JComboBox<>();
        jSeparator1 = new javax.swing.JSeparator();
        filterBtn = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        sexFilter = new javax.swing.JComboBox<>();
        breedFilter = new javax.swing.JComboBox<>();

        setBackground(new java.awt.Color(255, 255, 255));
        setPreferredSize(new java.awt.Dimension(920, 610));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        AllGoatsTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Goat Tag", "Name", "Breed", "Sex", "Source", "BirthDate", "BuckID", "DoeID"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        AllGoatsTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                AllGoatsTableMouseClicked(evt);
            }
        });
        AllGoatsTable.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                AllGoatsTableKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                AllGoatsTableKeyReleased(evt);
            }
        });
        jScrollPane1.setViewportView(AllGoatsTable);

        jButton2.setText("Add new Goat");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        searchGoat.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                searchGoatKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                searchGoatKeyTyped(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel4.setText("Search Goat");

        jLabel1.setText("Breed");

        jLabel3.setText("Status");

        statusFilter.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "None", "In the farm", "Not in the farm" }));

        filterBtn.setText("Filter");
        filterBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                filterBtnActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 153, 153));
        jLabel5.setText("Clear Filters");
        jLabel5.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        jLabel6.setText("Sex");

        sexFilter.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "None", "Male", "Female" }));

        breedFilter.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "None", "Local", "Exotic" }));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jButton2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(searchGoat, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(49, 49, 49))
            .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(166, 166, 166)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(breedFilter, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(statusFilter, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(sexFilter, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 75, Short.MAX_VALUE)
                .addComponent(filterBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel5)
                .addGap(62, 62, 62))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton2)
                    .addComponent(jLabel4)
                    .addComponent(searchGoat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel3)
                    .addComponent(statusFilter, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(filterBtn)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6)
                    .addComponent(sexFilter, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(breedFilter, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 458, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void AllGoatsTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_AllGoatsTableMouseClicked

        int rowIndex = AllGoatsTable.getSelectedRow();
        Goat mGoat = AppUtils.singleGoat(model.getValueAt(rowIndex, 0).toString());
                
        UpdateGoat updateGoat = new UpdateGoat();
        updateGoat.getSelectedGoat(mGoat);

        updateGoat.setVisible(true);
        updateGoat.pack();
        updateGoat.setLocationRelativeTo(null);
        updateGoat.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

    }//GEN-LAST:event_AllGoatsTableMouseClicked

    private void populateGoatTags() {
//        filterGoatTag.addItem("None");
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement("SELECT * FROM `goat`");
            
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()) {
//                filterGoatTag.addItem(rs.getString(1));
            }
        } catch (SQLException ex) {
            Logger.getLogger(AppUtils.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void AllGoatsTableKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_AllGoatsTableKeyPressed

    }//GEN-LAST:event_AllGoatsTableKeyPressed

    private void AllGoatsTableKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_AllGoatsTableKeyReleased

    }//GEN-LAST:event_AllGoatsTableKeyReleased

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        AddGoat addGoat = new AddGoat();
        addGoat.setVisible(true);
        addGoat.pack();
        addGoat.setLocationRelativeTo(null);
        addGoat.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void searchGoatKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_searchGoatKeyReleased
        AllGoatsTable.setModel(new DefaultTableModel(null, new Object[]{"ID", "Name", "Breed", "Sex", "Source", "BirthDate", "BuckID", "DoeID"}));
        AppUtils.fillGoatTable(AllGoatsTable, searchGoat.getText());
    }//GEN-LAST:event_searchGoatKeyReleased

    private void searchGoatKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_searchGoatKeyTyped

    }//GEN-LAST:event_searchGoatKeyTyped

    private void filterBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_filterBtnActionPerformed
        PreparedStatement ps = null;
        try {
            String status = statusFilter.getSelectedItem().toString();
            String breed  = breedFilter.getSelectedItem().toString();
            String sex = sexFilter.getSelectedItem().toString();
            
            ps = conn.prepareStatement("SELECT * FROM `goat` WHERE `breed` = ? AND `currentStatus` = ? AND `sex` = ? ");
            ps.setString(1, breed);
            ps.setString(2, status);
            ps.setString(3, sex);
            
            ResultSet rs = ps.executeQuery();
            DefaultTableModel model = new DefaultTableModel(null, new Object[]{"ID", "Name", "Breed", "Sex", "Source", "BirthDate", "BuckID", "DoeID"});
            
            Object[] row;
            
            while(rs.next()) {
                row = new Object[8];
                
                row[0] = rs.getString(1);                
                row[1] = rs.getString(2);
                row[2] = rs.getString(3);
                row[3] = rs.getString(4);
                row[4] = rs.getString(5);
                row[5] = rs.getString(6);                
                row[6] = rs.getString(7);
                row[7] = rs.getString(8); 
                
                model.addRow(row);

            }
            
            AllGoatsTable.setModel(model);
        } catch (SQLException ex) {
            Logger.getLogger(AppUtils.class.getName()).log(Level.SEVERE, null, ex);
             JOptionPane.showMessageDialog(null, ex.getMessage());
        }
    }//GEN-LAST:event_filterBtnActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JTable AllGoatsTable;
    private javax.swing.JComboBox<String> breedFilter;
    private javax.swing.JButton filterBtn;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTextField searchGoat;
    private javax.swing.JComboBox<String> sexFilter;
    private javax.swing.JComboBox<String> statusFilter;
    // End of variables declaration//GEN-END:variables
}
