/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app;

import app.models.Goat;
import app.screens.Home;
import app.utils.AppUtils;
import java.awt.FileDialog;
import java.awt.Image;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Eco
 */
public class UpdateGoat extends javax.swing.JFrame {

    /**
     * Creates new form UpdateGoat
     */
    private Goat goat;
    
    public UpdateGoat() {
        initComponents();
        ButtonGroup bg = new ButtonGroup();
        bg.add(updateMale);
        bg.add(updateFemale);
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
        updateBreed = new javax.swing.JTextField();
        updateGoatID = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        updateGoatName = new javax.swing.JTextField();
        updateMale = new javax.swing.JRadioButton();
        updateFemale = new javax.swing.JRadioButton();
        jLabel4 = new javax.swing.JLabel();
        updateSource = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        updateBirthDate = new com.toedter.calendar.JDateChooser();
        jLabel7 = new javax.swing.JLabel();
        updateCancel = new javax.swing.JButton();
        buttonUpdateGoat = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        updateBuckID = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        updateDoeID = new javax.swing.JTextField();
        jPanel4 = new javax.swing.JPanel();
        updateFrontImage = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        updateSideImage = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        updateRearImage = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        chooseFront = new javax.swing.JLabel();
        chooseSide = new javax.swing.JLabel();
        chooseRear = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        updateCurrentStatus = new javax.swing.JComboBox<>();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        livingStatus = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel1.add(updateBreed, new org.netbeans.lib.awtextra.AbsoluteConstraints(147, 224, 216, -1));

        updateGoatID.setEnabled(false);
        jPanel1.add(updateGoatID, new org.netbeans.lib.awtextra.AbsoluteConstraints(147, 107, 216, -1));

        jLabel2.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N
        jLabel2.setText("Name");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(95, 173, -1, -1));

        jLabel3.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N
        jLabel3.setText("ID");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(95, 113, -1, -1));
        jPanel1.add(updateGoatName, new org.netbeans.lib.awtextra.AbsoluteConstraints(147, 167, 216, -1));

        updateMale.setText("Male");
        updateMale.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateMaleActionPerformed(evt);
            }
        });
        jPanel1.add(updateMale, new org.netbeans.lib.awtextra.AbsoluteConstraints(158, 270, -1, -1));

        updateFemale.setText("Female");
        jPanel1.add(updateFemale, new org.netbeans.lib.awtextra.AbsoluteConstraints(246, 270, -1, -1));

        jLabel4.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N
        jLabel4.setText("Breed");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(96, 230, -1, -1));
        jPanel1.add(updateSource, new org.netbeans.lib.awtextra.AbsoluteConstraints(147, 318, 216, -1));

        jLabel5.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N
        jLabel5.setText("Sex");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(109, 271, -1, -1));

        jLabel6.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N
        jLabel6.setText("Source");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 320, -1, 20));
        jPanel1.add(updateBirthDate, new org.netbeans.lib.awtextra.AbsoluteConstraints(147, 368, 216, -1));

        jLabel7.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N
        jLabel7.setText("BirthDate");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 370, -1, 20));

        updateCancel.setText("Cancel");
        updateCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateCancelActionPerformed(evt);
            }
        });
        jPanel1.add(updateCancel, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 500, 90, 40));

        buttonUpdateGoat.setBackground(new java.awt.Color(255, 102, 0));
        buttonUpdateGoat.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        buttonUpdateGoat.setForeground(new java.awt.Color(255, 255, 255));
        buttonUpdateGoat.setText("Update Goat");
        buttonUpdateGoat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonUpdateGoatActionPerformed(evt);
            }
        });
        jPanel1.add(buttonUpdateGoat, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 500, 140, 40));

        jButton1.setBackground(new java.awt.Color(255, 51, 102));
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Delete");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 500, 100, 40));

        jLabel8.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N
        jLabel8.setText("Buck ID");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 106, -1, 30));

        updateBuckID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateBuckIDActionPerformed(evt);
            }
        });
        jPanel1.add(updateBuckID, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 110, 208, -1));

        jLabel9.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N
        jLabel9.setText("Doe ID");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 156, -1, 30));

        updateDoeID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateDoeIDActionPerformed(evt);
            }
        });
        jPanel1.add(updateDoeID, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 160, 208, -1));

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));

        updateFrontImage.setBackground(new java.awt.Color(255, 255, 255));
        updateFrontImage.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        updateFrontImage.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        updateFrontImage.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                updateFrontImageMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(updateFrontImage, javax.swing.GroupLayout.DEFAULT_SIZE, 95, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(updateFrontImage, javax.swing.GroupLayout.DEFAULT_SIZE, 95, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel1.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(405, 303, -1, -1));

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));

        updateSideImage.setBackground(new java.awt.Color(255, 255, 255));
        updateSideImage.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        updateSideImage.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        updateSideImage.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                updateSideImageMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(updateSideImage, javax.swing.GroupLayout.DEFAULT_SIZE, 95, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(updateSideImage, javax.swing.GroupLayout.DEFAULT_SIZE, 95, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel1.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 303, -1, 107));

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));

        updateRearImage.setBackground(new java.awt.Color(255, 255, 255));
        updateRearImage.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        updateRearImage.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        updateRearImage.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                updateRearImageMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(updateRearImage, javax.swing.GroupLayout.DEFAULT_SIZE, 98, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(updateRearImage, javax.swing.GroupLayout.DEFAULT_SIZE, 95, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel1.add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(655, 303, -1, 107));

        jLabel14.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N
        jLabel14.setText("Select Images");
        jPanel1.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 280, -1, -1));

        chooseFront.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N
        chooseFront.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        chooseFront.setText("Choose front");
        chooseFront.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        chooseFront.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                chooseFrontMouseClicked(evt);
            }
        });
        jPanel1.add(chooseFront, new org.netbeans.lib.awtextra.AbsoluteConstraints(406, 418, 110, -1));

        chooseSide.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N
        chooseSide.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        chooseSide.setText("Choose side");
        chooseSide.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        chooseSide.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                chooseSideMouseClicked(evt);
            }
        });
        jPanel1.add(chooseSide, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 420, 110, -1));

        chooseRear.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N
        chooseRear.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        chooseRear.setText("Choose rear");
        chooseRear.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        chooseRear.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                chooseRearMouseClicked(evt);
            }
        });
        jPanel1.add(chooseRear, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 420, 110, -1));

        jLabel10.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N
        jLabel10.setText("Living status");
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 416, -1, 30));

        jPanel1.add(updateCurrentStatus, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 210, 208, -1));

        jPanel2.setBackground(new java.awt.Color(61, 149, 119));

        jLabel1.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Update Record");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(346, 346, 346)
                .addComponent(jLabel1)
                .addContainerGap(361, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jLabel1)
                .addContainerGap(22, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 820, 70));

        jLabel11.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N
        jLabel11.setText("Current status");
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(405, 218, -1, -1));

        jPanel1.add(livingStatus, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 420, 200, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 820, 580));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void updateMaleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateMaleActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_updateMaleActionPerformed

    public boolean validateText() {
        
        if (updateGoatID.getText().equals("") || updateGoatName.getText().equals("") || updateBreed.getText().equals("")
                || updateBirthDate.getDate() == null || updateSource.getText().equals("") ) {
            JOptionPane.showMessageDialog(null, "All fields must be filled!");
            return false;
        } else if (updateBirthDate.getDate().compareTo(new Date()) > 0) {
            JOptionPane.showMessageDialog(null, "Please choose date which is not in the future.");
            return false;
        } else {       
            return true;
        }
    }
    
    private void buttonUpdateGoatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonUpdateGoatActionPerformed
        goat.displayGoat();
        String sex = "Male";
        if (updateFemale.isSelected()) {
            sex = "Female";
        }
        
        goat.setName(updateGoatName.getText());
        goat.setBreed(updateBreed.getText());
        goat.setSex(sex);
        goat.setSource(updateSource.getText());
        goat.setBuck_id(updateBuckID.getText());        
        goat.setDoe_id(updateDoeID.getText());
        goat.setCurrentStatus(String.valueOf(updateCurrentStatus.getSelectedItem()));
        
        if (String.valueOf(livingStatus.getSelectedItem()).equals("Alive")) {
            goat.setAlive(true);
        } else {
            goat.setAlive(false);
        }
        
        if (validateText()) {
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            String bdate = dateFormat.format(updateBirthDate.getDate());
            goat.setBirthDate(bdate);
            
            AppUtils.updateOneGoat(goat, this);
            MainApp.registered_goats.setText(Integer.toString(AppUtils.countData(("goat"))));
            Home.AllGoatsTable.setModel(new DefaultTableModel(null, new Object[]{"ID", "Name", "Breed", "Sex", "Source", "BirthDate", "BuckID", "DoeID"}));
            AppUtils.fillGoatTable(Home.AllGoatsTable, "");
        }
    }//GEN-LAST:event_buttonUpdateGoatActionPerformed

    public void getSelectedGoat(Goat selectedgoat) {
         goat = selectedgoat;
         if (goat != null) {
          populateGoat();
         }
         
    }
    
    public void populateGoat() {       
        updateGoatID.setText(goat.getID());
        updateGoatName.setText(goat.getName());
        updateBreed.setText(goat.getBreed());
        updateBuckID.setText(goat.getBuck_id());
        updateDoeID.setText(goat.getDoe_id());
        
        String itemOne = goat.getCurrentStatus();
        String itemTwo = "";
        if (itemOne.equals("In the farm")) {
            itemTwo = "Not in the farm";
        } else if(itemOne.equals("Not in the farm")) {
            itemTwo = "In the farm";
        }
       
        DefaultComboBoxModel dModel = new javax.swing.DefaultComboBoxModel<>(new String[] { itemOne, itemTwo });
        updateCurrentStatus.setModel(dModel);
        
        
        String livingOne = "";
        String livingTwo = "";
        
        if (goat.isAlive()) {
            livingOne = "Alive";
            livingTwo = "Dead";
            
        } else {
            livingOne = "Dead";
            livingTwo = "Alive";
        }
               
        DefaultComboBoxModel lm = new javax.swing.DefaultComboBoxModel<>(new String[] { livingOne, livingTwo });
        livingStatus.setModel(lm);

        if (goat.getSex().equals("Male")) {
            updateMale.setSelected(true);
        } else {
            updateFemale.setSelected(true);

        }
        updateSource.setText(goat.getSource());
            
        Date bdate;
        try {
            bdate = new SimpleDateFormat("yyyy-MM-dd").parse(goat.getBirthDate());
            updateBirthDate.setDate(bdate);
        } catch (ParseException ex) {
            Logger.getLogger(MainApp.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        ImageIcon imageFront = new ImageIcon(new ImageIcon(goat.getImage_front())
                .getImage()
                .getScaledInstance(updateFrontImage.getWidth(), updateFrontImage.getWidth(), Image.SCALE_SMOOTH)
        );
        
        ImageIcon imageRear = new ImageIcon(new ImageIcon(goat.getImage_rear())
                .getImage()
                .getScaledInstance(updateRearImage.getWidth(), updateRearImage.getWidth(), Image.SCALE_SMOOTH)
        );
        
        ImageIcon imageSide = new ImageIcon(new ImageIcon(goat.getImage_side())
                .getImage()
                .getScaledInstance(updateSideImage.getWidth(), updateSideImage.getWidth(), Image.SCALE_SMOOTH)
        );
        updateFrontImage.setIcon(imageFront);
        updateRearImage.setIcon(imageRear);
        updateSideImage.setIcon(imageSide);
    }
    
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        Goat mGoat = new Goat(updateGoatID.getText());
        
         AppUtils.deleteGoat(mGoat, this);
         MainApp.registered_goats.setText(Integer.toString(AppUtils.countData(("goat"))));
         Home.AllGoatsTable.setModel(new DefaultTableModel(null, new Object[]{"ID", "Name", "Breed", "Sex", "Source", "BirthDate", "BuckID", "DoeID"}));
         AppUtils.fillGoatTable(Home.AllGoatsTable, "");
    }//GEN-LAST:event_jButton1ActionPerformed

    private void updateCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateCancelActionPerformed
        // cancel 
        this.dispose();
    }//GEN-LAST:event_updateCancelActionPerformed

    private void updateBuckIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateBuckIDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_updateBuckIDActionPerformed

    private void updateDoeIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateDoeIDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_updateDoeIDActionPerformed

    private void openViewPic() {
        ViewPicture updateGoat = new ViewPicture();

        updateGoat.setVisible(true);
        updateGoat.pack();
        updateGoat.setLocationRelativeTo(null);
        updateGoat.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }
    
    private void updateFrontImageMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_updateFrontImageMouseClicked
       
        ImageIcon image = new ImageIcon(new ImageIcon(goat.getImage_front())
                .getImage()
                .getScaledInstance(600, 
                        600, 
                        Image.SCALE_SMOOTH)
        );
        
        ViewPicture.imageIcon = image;
        openViewPic();
    }//GEN-LAST:event_updateFrontImageMouseClicked

    private void updateSideImageMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_updateSideImageMouseClicked
        // TODO add your handling code here:
        ImageIcon image = new ImageIcon(new ImageIcon(goat.getImage_side())
                .getImage()
                .getScaledInstance(600, 
                        600, 
                        Image.SCALE_SMOOTH)
        );
        
        ViewPicture.imageIcon = image;
         openViewPic();
    }//GEN-LAST:event_updateSideImageMouseClicked

    private void updateRearImageMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_updateRearImageMouseClicked
        // TODO add your handling code here:
        ImageIcon image = new ImageIcon(new ImageIcon(goat.getImage_rear())
                .getImage()
                .getScaledInstance(600, 
                        600, 
                        Image.SCALE_SMOOTH)
        );
        
        ViewPicture.imageIcon = image;
        openViewPic();
    }//GEN-LAST:event_updateRearImageMouseClicked

    private void chooseFrontMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_chooseFrontMouseClicked

        FileDialog fd = new FileDialog(this);
        fd.show();
        String path = fd.getDirectory()+fd.getFile();
        updateFrontImage.setIcon(AppUtils.resizeImage(path, updateFrontImage));

        try {
            File image = new File(path);
            FileInputStream fis = new FileInputStream(image);
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            byte[] buffer = new byte[1024];
            for(int readNum; (readNum=fis.read(buffer))!=-1;) {
                bos.write(buffer, 0, readNum);
            }
            goat.setImage_front(bos.toByteArray());
        } catch (Exception ex) {
            Logger.getLogger(AddGoat.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
    }//GEN-LAST:event_chooseFrontMouseClicked

    private void chooseSideMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_chooseSideMouseClicked
        // TODO add your handling code here:
        FileDialog fd = new FileDialog(this);
        fd.show();
        String path = fd.getDirectory()+fd.getFile();
        updateSideImage.setIcon(AppUtils.resizeImage(path, updateSideImage));

        try {
            File image = new File(path);
            FileInputStream fis = new FileInputStream(image);
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            byte[] buffer = new byte[1024];
            for(int readNum; (readNum=fis.read(buffer))!=-1;) {
                bos.write(buffer, 0, readNum);
            }
            goat.setImage_side(bos.toByteArray());
        } catch (Exception ex) {
            Logger.getLogger(AddGoat.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
    }//GEN-LAST:event_chooseSideMouseClicked

    private void chooseRearMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_chooseRearMouseClicked
        // TODO add your handling code here:
        FileDialog fd = new FileDialog(this);
        fd.show();
        String path = fd.getDirectory()+fd.getFile();
        updateRearImage.setIcon(AppUtils.resizeImage(path, updateRearImage));

        try {
            File image = new File(path);
            FileInputStream fis = new FileInputStream(image);
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            byte[] buffer = new byte[1024];
            for(int readNum; (readNum=fis.read(buffer))!=-1;) {
                bos.write(buffer, 0, readNum);
            }
            goat.setImage_rear(bos.toByteArray());
        } catch (Exception ex) {
            Logger.getLogger(AddGoat.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
    }//GEN-LAST:event_chooseRearMouseClicked

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
            java.util.logging.Logger.getLogger(UpdateGoat.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(UpdateGoat.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(UpdateGoat.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(UpdateGoat.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new UpdateGoat().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonUpdateGoat;
    private javax.swing.JLabel chooseFront;
    private javax.swing.JLabel chooseRear;
    private javax.swing.JLabel chooseSide;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JComboBox<String> livingStatus;
    public static com.toedter.calendar.JDateChooser updateBirthDate;
    public static javax.swing.JTextField updateBreed;
    private javax.swing.JTextField updateBuckID;
    private javax.swing.JButton updateCancel;
    private javax.swing.JComboBox<String> updateCurrentStatus;
    private javax.swing.JTextField updateDoeID;
    public static javax.swing.JRadioButton updateFemale;
    private javax.swing.JLabel updateFrontImage;
    public static javax.swing.JTextField updateGoatID;
    public static javax.swing.JTextField updateGoatName;
    public static javax.swing.JRadioButton updateMale;
    private javax.swing.JLabel updateRearImage;
    private javax.swing.JLabel updateSideImage;
    public static javax.swing.JTextField updateSource;
    // End of variables declaration//GEN-END:variables

}
