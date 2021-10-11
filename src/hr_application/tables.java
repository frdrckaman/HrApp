package hr_application;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import net.proteanit.sql.DbUtils; 


public class tables {
   private JTable table_main; 
   private JScrollPane mainScropane;
  
   public JTable main_table(){
        table_main = new JTable();   
     try{
     String sql = "select * from employees";
     Connect conn = new Connect();
         PreparedStatement prepStmt = conn.connect.prepareStatement(sql);
         ResultSet getResult = prepStmt.executeQuery();
         table_main.setModel(DbUtils.resultSetToTableModel(getResult));
         
     }catch(Exception e){
         JOptionPane.showMessageDialog(null, e);
     }
     return table_main;
   }
}
