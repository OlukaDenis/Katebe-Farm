
package connector;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DbConnection {
    private static final String DB_URL = "jdbc:mysql://localhost/katebe";
    
    public static Connection getConnection() {
        Connection con = null;
        
        try {        
            Class.forName("com.mysql.jdbc.Driver");
//            con = DriverManager.getConnection(DB_URL, "root","");
            con = DriverManager.getConnection(DB_URL, "denny","Premarwewin");
        } catch (Exception ex) {
           System.out.println(ex.getMessage());
        }
        
        return con;
    }
    
}
