
package app.utils;

import app.AddGoat;
import app.models.Goat;
import connector.DbConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class AppUtils {
    private static Connection conn = DbConnection.getConnection();
    public static final String INSERT = "INSERT";
    public static final String UPDATE = "INSERT";
    public static final String DELETE = "DELETE";
    
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
    
    public static void manipulateGoat(String operation, Goat goat, AddGoat context) {
        PreparedStatement ps;
        
        switch(operation) {
            case INSERT:
                try {
                    ps = conn.prepareStatement("INSERT INTO goat(ID, name, breed, sex, birthdate, source) VALUES (?, ?, ?, ?, ?, ?)");
                    ps.setString(1, goat.getID());
                    ps.setString(2, goat.getName());
                    ps.setString(3, goat.getBreed());
                    ps.setString(4, goat.getSex());
                    ps.setString(5, goat.getBirthDate());
                    ps.setString(6, goat.getSource());

                    if (ps.executeUpdate() > 0) {
                       JOptionPane.showMessageDialog(null, "New goat added successfully!");
                       context.dispose();
                    }

                } catch (SQLException ex) {
                    Logger.getLogger(AppUtils.class.getName()).log(Level.SEVERE, null, ex);
                }
                break;
                
            default:
                break;
        }
    }
    
    public static void fillGoatTable(JTable table, String searchText) {
        PreparedStatement ps;
        
        try {
            ps = conn.prepareStatement("SELECT * FROM goat WHERE CONCAT(ID, name, breed, sex, source, birthdate) LIKE ?");
            ps.setString(1, "%" + searchText + "");
            
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
}
