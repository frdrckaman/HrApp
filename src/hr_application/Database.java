
package hr_application;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Database {
    private int countEmp = 0;
    public Database(){
    
    }

    public int getDbSize() throws SQLException{
        try {
            Connect conn = new Connect();
            String cheqSql = "select count(*) from employees";
            PreparedStatement checkStmt = conn.connect.prepareStatement(cheqSql);
            ResultSet checkResult = checkStmt.executeQuery();
            this.countEmp = checkResult.getInt(1);
        } catch (Exception ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
        }
        return this.countEmp;
    }
}
