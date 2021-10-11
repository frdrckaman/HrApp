package hr_application;

import java.awt.BorderLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableModel;
import net.proteanit.sql.DbUtils;

public class TablePanel extends JPanel{
    private JTable table;  
    private JTable empTable;
    public TablePanel(){
     empTable = new JTable();
    table = new JTable();
    table.setEnabled(false);
    
    setLayout(new BorderLayout());
    add(new JScrollPane(table),BorderLayout.CENTER);
    
    employeeTable();
    
    }
    public TablePanel(int x){
      empTable = new JTable();
    table = new JTable();
    table.setEnabled(false);
    employeeTableSearch();
    setLayout(new BorderLayout());
    add(new JScrollPane(table),BorderLayout.CENTER);
    }
    
    public TablePanel(String x){
      empTable = new JTable();
    table = new JTable();
    table.setEnabled(false);
    trainingTable();
    setLayout(new BorderLayout());
    add(new JScrollPane(table),BorderLayout.CENTER);
    }
    
      public TablePanel(double x){
      empTable = new JTable();
    table = new JTable();
    table.setEnabled(false);
    leaveTable();
    setLayout(new BorderLayout());
    add(new JScrollPane(table),BorderLayout.CENTER);
    }
    
    public void employeeTable(){
     try{
     String sql = "select emp_id,username,gender,position,qualification from employees";
     Connect conn = new Connect();
         PreparedStatement prepStmt = conn.connect.prepareStatement(sql);
         ResultSet getResult = prepStmt.executeQuery();
         table.setModel(DbUtils.resultSetToTableModel(getResult));
         
     }catch(Exception e){
         JOptionPane.showMessageDialog(null, e);
     }
    }
    
     public void employeeTableSearch(){
        try{
     String sql = "select emp_id,username,birthdate,gender,position,education,qualification,appraisal,experience,salary,objective from employees";
     Connect conn = new Connect();
     
        PreparedStatement prepStmt = conn.connect.prepareStatement(sql);
         ResultSet getResult = prepStmt.executeQuery();
         table.setModel(DbUtils.resultSetToTableModel(getResult));
         
     }catch(Exception e){
         JOptionPane.showMessageDialog(null, e);
     }
    
    }
     public void trainingTable(){
     try{
     String sql = "select emp_id,course,fromDate,toDate from training";
     Connect conn = new Connect();
         PreparedStatement prepStmt = conn.connect.prepareStatement(sql);
         ResultSet getResult = prepStmt.executeQuery();
         table.setModel(DbUtils.resultSetToTableModel(getResult));
         
     }catch(Exception e){
         JOptionPane.showMessageDialog(null, e);
     }
    }
      public void leaveTable(){
     try{
     String sql = "select emp_id,type,fromDate,toDate from leave";
     Connect conn = new Connect();
         PreparedStatement prepStmt = conn.connect.prepareStatement(sql);
         ResultSet getResult = prepStmt.executeQuery();
         table.setModel(DbUtils.resultSetToTableModel(getResult));
         
     }catch(Exception e){
         JOptionPane.showMessageDialog(null, e);
     }
    }
}
