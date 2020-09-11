
package app.utils;

import app.AddGoat;
import app.UpdateGoat;
import app.models.Goat;
import connector.DbConnection;
import java.awt.Image;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class AppUtils {
    private static Connection conn = DbConnection.getConnection();
    public static final String INSERT = "INSERT";
    public static final String UPDATE = "UPDATE";
    public static final String DELETE = "DELETE";
    private static PreparedStatement ps;
    
    public static int countData(String tableName) {
        int total = 0;
   
        try {
            Statement statement = conn.createStatement();
            ResultSet res = statement.executeQuery("SELECT COUNT(*) AS 'total' FROM " + tableName);
            while(res.next()) {
                total = res.getInt(1);
            }
        } catch (SQLException ex) {
            Logger.getLogger(AppUtils.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return total;
    }
    
    public static void addNewGoat(Goat goat, AddGoat addGoat) {
        try {
            ps = conn.prepareStatement("INSERT INTO goat(ID, name, breed, sex, source, birthdate, buck_id, doe_id, image_front, image_rear, image_side) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
            ps.setString(1, goat.getID());
            ps.setString(2, goat.getName());
            ps.setString(3, goat.getBreed());
            ps.setString(4, goat.getSex());
            ps.setString(5, goat.getSource());
            ps.setString(6, goat.getBirthDate());
            ps.setString(7, goat.getBuck_id());
            ps.setString(8, goat.getDoe_id());
            ps.setBytes(9, goat.getImage_front());
            ps.setBytes(10, goat.getImage_rear());
            ps.setBytes(11, goat.getImage_side());


            if (ps.executeUpdate() > 0) {
               JOptionPane.showMessageDialog(null, "New goat added successfully!");
               addGoat.dispose();
            }

        } catch (SQLException ex) {
            Logger.getLogger(AppUtils.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
    }
    
    public static void updateOneGoat(Goat goat, UpdateGoat updateGoat) {
        try {
                    ps = conn.prepareStatement("UPDATE goat SET name = ?, breed = ?, sex = ?, source = ?, birthdate = ?, buck_id = ?, doe_id = ? WHERE ID = ?");
                    
                    ps.setString(1, goat.getName());
                    ps.setString(2, goat.getBreed());
                    ps.setString(3, goat.getSex());
                    ps.setString(4, goat.getSource());
                    ps.setString(5, goat.getBirthDate());                    
                    ps.setString(6, goat.getID());
                    ps.setString(7, goat.getBuck_id());
                    ps.setString(8, goat.getBuck_id());

                    if (ps.executeUpdate() > 0) {
                       JOptionPane.showMessageDialog(null, "Goat updated successfully!");
                       updateGoat.dispose();
                    }

                } catch (SQLException ex) {
                    Logger.getLogger(AppUtils.class.getName()).log(Level.SEVERE, null, ex);
                    JOptionPane.showMessageDialog(null, ex.getMessage());
                }
    }
    
    public static void deleteGoat(Goat goat, UpdateGoat updateGoat) {
        try {
            ps = conn.prepareStatement("DELETE FROM `goat` WHERE ID = ?");
            ps.setString(1, goat.getID());

            if (ps.executeUpdate() > 0) {
               JOptionPane.showMessageDialog(null, "Goat deleted successfully!");
               updateGoat.dispose();
            }

        } catch (SQLException ex) {
            Logger.getLogger(AppUtils.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
    }
    
    
    public static void fillGoatTable(JTable table, String searchText) {        
        try {
            ps = conn.prepareStatement("SELECT * FROM goat WHERE CONCAT(ID, name, breed, sex, source, birthdate, buck_id, doe_id) LIKE ?");
            ps.setString(1, "%" + searchText + "%");
            
            ResultSet rs = ps.executeQuery();
            DefaultTableModel model = (DefaultTableModel)table.getModel();
            
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
        } catch (SQLException ex) {
            Logger.getLogger(AppUtils.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static Goat singleGoat(String goatID) {
        PreparedStatement preparedStatement = null;
        Goat goat = null;
        try {
            preparedStatement = conn.prepareStatement("SELECT * FROM goat WHERE ID = ? ");
            preparedStatement.setString(1, goatID);
            
            ResultSet rs = preparedStatement.executeQuery();
                     
            while(rs.next()) {
                goat = new Goat();
                goat.setID(rs.getString(1));
                goat.setName(rs.getString(2));  
                goat.setBreed(rs.getString(3));
                goat.setSex(rs.getString(4));
                goat.setSource(rs.getString(5));
                goat.setBirthDate(rs.getString(6));
                goat.setBuck_id(rs.getString(7));
                goat.setDoe_id(rs.getString(8));
                goat.setImage_front(rs.getBytes(9));
                goat.setImage_rear(rs.getBytes(10));                  
                goat.setImage_side(rs.getBytes(11));  

            }
            
        } catch (SQLException ex) {
            Logger.getLogger(AppUtils.class.getName()).log(Level.SEVERE, null, ex);
             JOptionPane.showMessageDialog(null, ex.getMessage());
        }
        
        return goat;
    }
    
    public static ImageIcon resizeImage(String path, JLabel label) {
       ImageIcon icon = new ImageIcon(path);
       Image image = icon.getImage();
       Image img = image.getScaledInstance(label.getWidth(), label.getHeight(), Image.SCALE_SMOOTH);
       return new ImageIcon(img);
    }
}
