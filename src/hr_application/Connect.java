
package hr_application;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Connect {
    public Connection connect;
    
    public Connect() throws ClassNotFoundException, Exception{
     Class.forName("org.sqlite.JDBC");
       try {
           this.connect = DriverManager.getConnection("jdbc:sqlite:E:\\NetBeansProjects\\HR_Application\\HR_APPLICATION.sqlite");
       } catch (SQLException ex) {
           //Logger.getLogger(addEmployeeDialog.class.getName()).log(Level.SEVERE, null, ex);
            throw new Exception("JDBC not found ");
       }
    }
   public void disconnect(){
    if(connect !=null){
        try {
            connect.close();
        } catch (SQLException ex) {
          //  Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Cant close connection");
        }
    }
    }
}
