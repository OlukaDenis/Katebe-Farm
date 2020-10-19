
package app.utils;

import app.AddDeworming;
import app.AddDipping;
import app.AddExpense;
import app.AddGoat;
import app.AddKiddingRecord;
import app.AddVaccine;

import app.AddOwner;
import app.AddTreatment;

import app.UpdateGoat;
import app.UpdateKiddingRecord;
import app.models.Deworming;
import app.models.Dipping;
import app.models.Expense;
import app.models.Goat;
import app.models.GoatOwner;
import app.models.Kidding;
import app.models.Treatment;
import app.models.Vaccination;
import connector.DbConnection;
import java.awt.Image;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class AppUtils {
    private static Connection conn = DbConnection.getConnection();
    private static PreparedStatement ps;
    
    public AppUtils() {
    }
    
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
    
    //GOAT
    public static void addNewGoat(Goat goat, AddGoat addGoat) {
        try {
            ps = conn.prepareStatement("INSERT INTO goat(ID, name, breed, sex, source, birthdate, buckID, doeID, currentStatus, imageFront, imageRear, imageSide) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
            ps.setString(1, goat.getID());
            ps.setString(2, goat.getName());
            ps.setString(3, goat.getBreed());
            ps.setString(4, goat.getSex());
            ps.setString(5, goat.getSource());
            ps.setString(6, goat.getBirthDate());
            ps.setString(7, goat.getBuck_id());
            ps.setString(8, goat.getDoe_id());            
            ps.setString(9, goat.getCurrentStatus());
            ps.setBytes(10, goat.getImage_front());
            ps.setBytes(11, goat.getImage_rear());
            ps.setBytes(12, goat.getImage_side());


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
            ps = conn.prepareStatement("UPDATE goat SET name = ?, breed = ?, sex = ?, source = ?, birthDate = ?, buckID = ?, doeID = ?, currentStatus = ?, alive = ?,  imageFront = ?, imageRear = ?, imageSide = ? WHERE ID = ?");

            ps.setString(1, goat.getName());
            ps.setString(2, goat.getBreed());
            ps.setString(3, goat.getSex());
            ps.setString(4, goat.getSource());
            ps.setString(5, goat.getBirthDate());
            ps.setString(6, goat.getBuck_id());
            ps.setString(7, goat.getDoe_id());
            ps.setString(8, goat.getCurrentStatus());
            ps.setBoolean(9, goat.isAlive());
            ps.setBytes(10, goat.getImage_front());
            ps.setBytes(11, goat.getImage_rear());
            ps.setBytes(12, goat.getImage_side());
            ps.setString(13, goat.getID());

            if (ps.executeUpdate() > 0) {
               JOptionPane.showMessageDialog(null, "Goat updated successfully!");
               updateGoat.dispose();
            } else {
                JOptionPane.showMessageDialog(null, "Error while updating goat!");
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
            ps = conn.prepareStatement("SELECT * FROM goat WHERE CONCAT(ID, name, breed, sex, source, birthdate, buckID, doeID) LIKE ?");
            ps.setString(1, "%" + searchText + "%");
            
            ResultSet rs = ps.executeQuery();
            DefaultTableModel model = (DefaultTableModel)table.getModel();
            
            Object[] row;
            
            while(rs.next()) {
                row = new Object[9];
                
                String name = rs.getString(2);
                String source = rs.getString(5);
                String bd = rs.getString(6);
                
                row[0] = rs.getString(1); 
                
                row[1] =  name;
                row[2] = rs.getString(3);
                row[3] = rs.getString(4);
                row[4] = source;
                row[5] =  getRecentWeight(rs.getString(1));
                row[6] =  bd;                               
                row[7] = rs.getString(7);
                row[8] = rs.getString(8);

                model.addRow(row);

            }
        } catch (SQLException ex) {
            Logger.getLogger(AppUtils.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static String getRecentWeight(String tag) {
        double weight = 0.0;
         try {
            ps = conn.prepareStatement("SELECT quantity FROM weight WHERE goatID = ? ORDER BY capturedDate DESC LIMIT 1");
            ps.setString(1, tag);
            
            ResultSet rs = ps.executeQuery();           
            while(rs.next()) {
                weight = rs.getDouble(1);
            }
        } catch (SQLException ex) {
            Logger.getLogger(AppUtils.class.getName()).log(Level.SEVERE, null, ex);
        }
         
         return String.valueOf(weight);
    }
    
     public static void addWeight(String weight, String tag) {
        double value = (weight.isEmpty()) ? 0.0 : Double.parseDouble(weight);
        
        try {
            ps = conn.prepareStatement("INSERT INTO weight(capturedDate, quantity, goatID) VALUES (?, ?, ?)");
            ps.setString(1, Helpers.currentDate());
            ps.setDouble(2, value);
            ps.setString(3, tag);
            
            if (ps.executeUpdate() > 0) {
               System.out.println("Add weight sucesss");
            }

        } catch (SQLException ex) {
            Logger.getLogger(AppUtils.class.getName()).log(Level.SEVERE, null, ex);
            System.err.println( ex.getMessage());
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
                goat.setCurrentStatus(rs.getString(9));
                goat.setAlive(rs.getBoolean(10));
                goat.setImage_front(rs.getBytes(11));
                goat.setImage_rear(rs.getBytes(12));                  
                goat.setImage_side(rs.getBytes(13));  

            }
            
        } catch (SQLException ex) {
            Logger.getLogger(AppUtils.class.getName()).log(Level.SEVERE, null, ex);
             JOptionPane.showMessageDialog(null, ex.getMessage());
        }
        
        return goat;
    }
    
    // End Goat
    
    
    //DEWORMING
    public static void addDeworming(Deworming deworming, AddDeworming addDeworming) {
        try {
            ps = conn.prepareStatement("INSERT INTO deworming(dewormingDate, dewormerUsed, doseAdministered, nextDueDate, goatID) VALUES (?, ?, ?, ?, ?)");
            ps.setString(1, deworming.getDewormingDate());
            ps.setString(2, deworming.getDewormUsed());
            ps.setString(3, deworming.getDoseAdministered());
            ps.setString(4, deworming.getNextDueDate());
            ps.setString(5, deworming.getGoatTag());
            
            if (ps.executeUpdate() > 0) {
               JOptionPane.showMessageDialog(null, "New deworming record added successfully!");
               addDeworming.dispose();
            }

        } catch (SQLException ex) {
            Logger.getLogger(AppUtils.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
    }
    
    public static void fillDewormingTable(JTable table, String searchText) {        
        try {
            ps = conn.prepareStatement("SELECT * FROM deworming WHERE CONCAT(id, dewormingDate, dewormerUsed, doseAdministered, nextDueDate, goatID) LIKE ?");
            ps.setString(1, "%" + searchText + "%");
            
            ResultSet rs = ps.executeQuery();
            DefaultTableModel model = (DefaultTableModel)table.getModel();
            
            Object[] row;
            
            while(rs.next()) {
                row = new Object[6];
                
                row[0] = rs.getString(1);                
                row[1] = rs.getString(2);
                row[2] = rs.getString(3);
                row[3] = rs.getString(4);
                row[4] = rs.getString(5);
                row[5] = rs.getString(6);  
                
                model.addRow(row);

            }
        } catch (SQLException ex) {
            Logger.getLogger(AppUtils.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    //End Deworming
    
     //Diping
    public static void addDipping(Dipping dipping, AddDipping addDipping) {
        try {
            ps = conn.prepareStatement("INSERT INTO dipping(dippingDate, comments, goatID) VALUES (?, ?, ?)");
            ps.setString(1, dipping.getDippingDate());
            ps.setString(2, dipping.getComments());
            ps.setString(3, dipping.getGoatTag());
            
            if (ps.executeUpdate() > 0) {
               JOptionPane.showMessageDialog(null, "New dipping record added successfully!");
               addDipping.dispose();
            }

        } catch (SQLException ex) {
            Logger.getLogger(AppUtils.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
    }
    
    public static void fillDippingTable(JTable table, String searchText) {        
        try {
            ps = conn.prepareStatement("SELECT * FROM dipping WHERE CONCAT(id, dippingDate, comments, goatID) LIKE ?");
            ps.setString(1, "%" + searchText + "%");
            
            ResultSet rs = ps.executeQuery();
            DefaultTableModel model = (DefaultTableModel)table.getModel();
            
            Object[] row;
            
            while(rs.next()) {
                row = new Object[6];
                
                row[0] = rs.getString(1);                
                row[1] = rs.getString(2);
                row[2] = rs.getString(3);
                row[3] = rs.getString(4); 
                
                model.addRow(row);

            }
        } catch (SQLException ex) {
            Logger.getLogger(AppUtils.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    //End dipping
    
    
    //Treatment
    public static void addTreatment(Treatment treatment, AddTreatment addTreatment) {
        try {
            ps = conn.prepareStatement("INSERT INTO othertreament(treatmentDate, description, goatID) VALUES (?, ?, ?)");
            ps.setString(1, treatment.getTreatmentDate());
            ps.setString(2, treatment.getDescription());
            ps.setString(3, treatment.getGoatTag());
            
            if (ps.executeUpdate() > 0) {
               JOptionPane.showMessageDialog(null, "New treament record added successfully!");
               addTreatment.dispose();
            }

        } catch (SQLException ex) {
            Logger.getLogger(AppUtils.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
    }
    
    public static void fillTreatmentTable(JTable table, String searchText) {        
        try {
            ps = conn.prepareStatement("SELECT * FROM othertreament WHERE CONCAT(id, treatmentDate, description, goatID) LIKE ?");
            ps.setString(1, "%" + searchText + "%");
            
            ResultSet rs = ps.executeQuery();
            DefaultTableModel model = (DefaultTableModel)table.getModel();
            
            Object[] row;
            
            while(rs.next()) {
                row = new Object[4];
                
                row[0] = rs.getString(1);                
                row[1] = rs.getString(2);
                row[2] = rs.getString(3);
                row[3] = rs.getString(4);  
                
                model.addRow(row);

            }
        } catch (SQLException ex) {
            Logger.getLogger(AppUtils.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    //End treatment
    
    
    //VACCIINATION
    
    public static void addVaccination(Vaccination vaccination, AddVaccine addVaccination) {

        try {
            ps = conn.prepareStatement("INSERT INTO vaccination(vaccinationDate, vaccineName, nextDueDate, goatID) VALUES (?, ?, ?, ?)");
            ps.setString(1, vaccination.getVaccinationDate());
            ps.setString(2, vaccination.getVaccineName());
            ps.setString(3, vaccination.getNextDueDate());
            ps.setString(4, vaccination.getGoatTag());
            
            if (ps.executeUpdate() > 0) {
               JOptionPane.showMessageDialog(null, "New vaccination record added successfully!");
               addVaccination.dispose();
            }

        } catch (SQLException ex) {
            Logger.getLogger(AppUtils.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
    }
    
    public static void fillVaccinationTable(JTable table, String searchText) {        
        try {
            ps = conn.prepareStatement("SELECT * FROM vaccination WHERE CONCAT(id, vaccinationDate, vaccineName, nextDueDate, goatID) LIKE ?");
            ps.setString(1, "%" + searchText + "%");
            
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
    //End Vaccination
    
    
    //EXPENSE
    public static void addExpense(Expense expense, AddExpense addExpense) {

        try {
            ps = conn.prepareStatement("INSERT INTO expenses(expenseDate, item, cost, goatID) VALUES (?, ?, ?, ?)");
            ps.setString(1, expense.getExpenseDate());
            ps.setString(2, expense.getItem());
            ps.setInt(3, expense.getCost());
            ps.setString(4, expense.getGoatTag());
            
            if (ps.executeUpdate() > 0) {
               JOptionPane.showMessageDialog(null, "New vaccination record added successfully!");
               addExpense.dispose();
            }

        } catch (SQLException ex) {
            Logger.getLogger(AppUtils.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
    }
    
    public static void fillExpenseTable(JTable table, String searchText) {        
        try {
            ps = conn.prepareStatement("SELECT * FROM expenses WHERE CONCAT(id, expenseDate, item, cost, goatID) LIKE ?");
            ps.setString(1, "%" + searchText + "%");
            
            ResultSet rs = ps.executeQuery();
            DefaultTableModel model = (DefaultTableModel)table.getModel();
            
            Object[] row;
            
            while(rs.next()) {
                row = new Object[5];
                String price = Helpers.formatCurrency(rs.getInt(4));
                
                row[0] = rs.getString(1);                
                row[1] = rs.getString(2);
                row[2] = rs.getString(3);
                row[3] = price;
                row[4] = rs.getString(5); 
                
                model.addRow(row);

            }
        } catch (SQLException ex) {
            Logger.getLogger(AppUtils.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    //End Expense
    
    //GOAT OWNER
    
    public static void addGoatOwner(GoatOwner goatOwner, AddOwner addOwner) {
        try {
            ps = conn.prepareStatement("INSERT INTO goatowner(name, address, phone, farm, goatID) VALUES (?, ?, ?, ?, ?)");
            ps.setString(1, goatOwner.getName());
            ps.setString(2, goatOwner.getAdress());
            ps.setString(3, goatOwner.getPhone());
            ps.setString(4, goatOwner.getFarm());
            ps.setString(5, goatOwner.getGoatTag());
            
            if (ps.executeUpdate() > 0) {
               JOptionPane.showMessageDialog(null, "New goat owner added successfully!");
               addOwner.dispose();
            }

        } catch (SQLException ex) {
            Logger.getLogger(AppUtils.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
    }
    
    public static void fillGoatOwnerTable(JTable table, String searchText) {        
        try {
            ps = conn.prepareStatement("SELECT * FROM goatowner WHERE CONCAT(id, name, address, phone, farm, goatID) LIKE ?");
            ps.setString(1, "%" + searchText + "%");
            
            ResultSet rs = ps.executeQuery();
            DefaultTableModel model = (DefaultTableModel)table.getModel();
            
            Object[] row;
            
            while(rs.next()) {
                row = new Object[6];
                
                row[0] = rs.getInt(1);                
                row[1] = rs.getString(2);
                row[2] = rs.getString(3);
                row[3] = rs.getString(4);
                row[4] = rs.getString(5); 
                row[5] = rs.getString(6);
                
                model.addRow(row);

            }
        } catch (SQLException ex) {
            Logger.getLogger(AppUtils.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
    }
    //End Owner
    
    //KIDDING
    public static void addKidding(Kidding kidding, AddKiddingRecord addKidding) {
        try {
            ps = conn.prepareStatement("INSERT INTO kidding(dateBred, kiddingDate, kidSire, goatID) VALUES (?, ?, ?, ?)");
            ps.setString(1, kidding.getDateBred());
            ps.setString(2, kidding.getKiddingDate());         
            ps.setString(3, kidding.getKidSire());
            ps.setString(4, kidding.getGoatTag());
            
            if (ps.executeUpdate() > 0) {
               JOptionPane.showMessageDialog(null, "New kidding record added successfully!");
               addKidding.dispose();
            }

        } catch (SQLException ex) {
            Logger.getLogger(AppUtils.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
    }

    public static void fillKiddingTable(JTable table, String searchText) {        
        try {
            ps = conn.prepareStatement("SELECT * FROM kidding WHERE CONCAT(id, dateBred, kiddingDate, sex, kidName, kidSire, birthWeight, tattoo, goatID) LIKE ?");
            ps.setString(1, "%" + searchText + "%");
            
            ResultSet rs = ps.executeQuery();
            DefaultTableModel model = (DefaultTableModel)table.getModel();
            
            Object[] row;
            Kidding kidding;
            
            while(rs.next()) {
                row = new Object[10];
                int days = Helpers.daysBetweenDate(rs.getString(3));
                String numDays = String.valueOf(days) + " days left";
                
                row[0] = rs.getInt(1);
                row[1] = rs.getString(9);                
                row[2] = rs.getString(2);
                row[3] = rs.getString(3);
                row[4] = rs.getString(4);
                row[5] = rs.getString(5);
                row[6] = rs.getString(6); 
                row[7] = rs.getDouble(7); 
                row[8] = rs.getString(8); 
                row[9] = numDays;
                               
                model.addRow(row);

            }
        } catch (SQLException ex) {
            Logger.getLogger(AppUtils.class.getName()).log(Level.SEVERE, null, ex);
             JOptionPane.showMessageDialog(null, ex.getMessage());
        }
    }
    
    public static void updateKiddingRecord(Kidding kidding, UpdateKiddingRecord updateKidding) {
        try {
            ps = conn.prepareStatement("UPDATE kidding SET dateBred = ?, kiddingDate = ?, sex = ?, kidName = ?, kidSire = ?, birthWeight = ?, tattoo = ?, goatID = ? WHERE id = ?");

            ps.setString(1, kidding.getDateBred());
            ps.setString(2, kidding.getKiddingDate());
            ps.setString(3, kidding.getSex());
            ps.setString(4, kidding.getKidName());
            ps.setString(5, kidding.getKidSire());
            ps.setDouble(6, kidding.getBirthWeight());
            ps.setString(7, kidding.getTattoo());
            ps.setString(8, kidding.getGoatTag());
            ps.setInt(9, kidding.getId());

            if (ps.executeUpdate() > 0) {
               JOptionPane.showMessageDialog(null, "Kidding record updated successfully!");
               updateKidding.dispose();
            } else {
                JOptionPane.showMessageDialog(null, "Error while updating kidding records!");
            }

        } catch (SQLException ex) {
            Logger.getLogger(AppUtils.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
    }
    
    public static void deleteKidding(int kiddingID, UpdateKiddingRecord updateKidding) {
        try {
            ps = conn.prepareStatement("DELETE FROM `kidding` WHERE id = ?");
            ps.setInt(1, kiddingID);

            if (ps.executeUpdate() > 0) {
               JOptionPane.showMessageDialog(null, "Kidding record deleted successfully!");
               updateKidding.dispose();
            }

        } catch (SQLException ex) {
            Logger.getLogger(AppUtils.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
    }
    
     public static Kidding singleKidding(String kiddingId) {
        PreparedStatement preparedStatement = null;
        Kidding kidding = null;
        try {
            preparedStatement = conn.prepareStatement("SELECT * FROM kidding WHERE id = ? ");
            preparedStatement.setString(1, kiddingId);
            
            ResultSet rs = preparedStatement.executeQuery();
                     
            while(rs.next()) {
                kidding = new Kidding();
                kidding.setId(rs.getInt(1));
                kidding.setDateBred(rs.getString(2));  
                kidding.setKiddingDate(rs.getString(3));
                kidding.setSex(rs.getString(4));
                kidding.setKidName(rs.getString(5));
                kidding.setKidSire(rs.getString(6));
                kidding.setBirthWeight(rs.getDouble(7));
                kidding.setTattoo(rs.getString(8));
                kidding.setGoatTag(rs.getString(9));
                kidding.setDateAdded(rs.getString(10));  

            }
            
        } catch (SQLException ex) {
            Logger.getLogger(AppUtils.class.getName()).log(Level.SEVERE, null, ex);
             JOptionPane.showMessageDialog(null, ex.getMessage());
        }
        
        return kidding;
    }
    
    // End Kidding
        
    
    //Helper functions
           
    public static ImageIcon resizeImage(String path, JLabel label) {
       ImageIcon icon = new ImageIcon(path);
       Image image = icon.getImage();
       Image img = image.getScaledInstance(label.getWidth(), label.getHeight(), Image.SCALE_SMOOTH);
       return new ImageIcon(img);
    }
}
