package hr_application;

import com.toedter.calendar.JDateChooser;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.DateFormat;
import java.util.Date;
import javax.swing.BorderFactory;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;

public class addLeaveDialog extends JDialog{
    private JLabel typeOfLeaveLabel;
    private JLabel employeeLabel;
    private JLabel fromLabel;
    private JLabel toLabel;
    
    private JComboBox typeOfLeave;
    private JComboBox employee;
    private JDateChooser from;
    private JDateChooser to;
    private JButton addLeaveBtn;
    private JButton cancelBtn;
    
    public addLeaveDialog(JFrame parent){
     super(parent, " Add Leave ", true);
     setSize(750,200);
     setLocationRelativeTo(parent);
     setResizable(false);
     
         typeOfLeaveLabel = new JLabel(" Type :    ");
         employeeLabel = new JLabel(" Employee :   ");
         fromLabel = new JLabel(" From :   ");
         toLabel = new JLabel(" To :   ");
         addLeaveBtn = new JButton(" Add Leave ");
         cancelBtn = new JButton(" Cancel ");
         
         typeOfLeave = new JComboBox();
          DefaultComboBoxModel leaveModel = new DefaultComboBoxModel();
          leaveModel.addElement("Select leave type");
          leaveModel.addElement(" Annual Leave ");
          leaveModel.addElement(" Maternity Leave ");
          leaveModel.addElement(" Partriet Leave ");
          leaveModel.addElement(" Sick Leave ");  
          typeOfLeave.setModel(leaveModel);
          
         employee = new JComboBox();
         DefaultComboBoxModel emp = new DefaultComboBoxModel();
         emp.addElement("Select Employee");
         employee.setModel(emp);
         employee.setEditable(true);
         employee.setPrototypeDisplayValue("xxxxxxxxxxxxxxxxx");
         from = new JDateChooser();
         to = new JDateChooser();
         fillComboBox();
         addLeaveLayout();
     
     addLeaveBtn.addActionListener(new ActionListener() {
         @Override
         public void actionPerformed(ActionEvent e) {
          if(typeOfLeave.getSelectedItem() != "Select leave type"){
              if(employee.getSelectedItem().toString() != "Select Employee" ){
          try {
             Connect conn = new Connect();
             String sql = "select * from employees where username=?";
             PreparedStatement prepStmt = conn.connect.prepareStatement(sql);
             prepStmt.setString(1, employee.getSelectedItem().toString());
             ResultSet getResultSet = prepStmt.executeQuery();
             int emp_id = Integer.parseInt(getResultSet.getString("id"));
                 
               conn.disconnect();
               Connect conns = new Connect(); 
                     String sq = "insert into leave (type,fromDate,toDate,emp_id) values (?,?,?,?)";
             prepStmt = conns.connect.prepareStatement(sq);
             prepStmt.setString(1, typeOfLeave.getSelectedItem().toString());
             Date date = from.getDate();
             String dt = DateFormat.getDateInstance().format(date);
             prepStmt.setString(2, dt);
             Date date1 = to.getDate();
             String dt1 = DateFormat.getDateInstance().format(date1);
             prepStmt.setString(3, dt1);
             prepStmt.setInt(4, emp_id);
             prepStmt.executeUpdate();
            
             JOptionPane.showMessageDialog(null, "Leave successiful added to Database");
             clearField();
             prepStmt.close();
             conns.disconnect();
                 
             }catch(Exception er){
             JOptionPane.showMessageDialog(null, er);
               }
              } else {
              JOptionPane.showMessageDialog(null, "Employee field must not be empty,please Select Employee!", " EMPTY FIELD ERROR ", JOptionPane.WARNING_MESSAGE);
              }//endif
          } else {
          JOptionPane.showMessageDialog(null, "Please Select Type of Leave!", " EMPTY FIELD ERROR ", JOptionPane.WARNING_MESSAGE);
           }
         }
     });
     
     cancelBtn.addActionListener(new ActionListener() {
         @Override
         public void actionPerformed(ActionEvent e) {
           clearField();
         }
     });
     
    }
    
    public void addLeaveLayout(){
    JPanel mainPanel = new JPanel();
    JPanel btnPanel = new JPanel();
        
        Border innerBorder = BorderFactory.createTitledBorder("");
        Border outerBorder = BorderFactory.createEmptyBorder(5, 5, 5, 5);
        mainPanel.setBorder(BorderFactory.createCompoundBorder(outerBorder, innerBorder));
        //btnPanel.setBorder(BorderFactory.createCompoundBorder(outerBorder, innerBorder));
        
         mainPanel.setLayout(new GridBagLayout());
         GridBagConstraints gc = new GridBagConstraints();
        
        gc.gridx = 0;
        gc.gridy = 0;
        
        gc.ipadx = 0;
        gc.ipady = 0;
        
        gc.weightx = 1;
        gc.weighty = 1;
        gc.fill = GridBagConstraints.NONE;
        gc.anchor = GridBagConstraints.LINE_END;
        mainPanel.add(employeeLabel,gc); 
        
        gc.ipadx= 100;
        gc.ipady = 6;
        
        gc.gridx=1;
        gc.gridy = 0;
        gc.fill = GridBagConstraints.NONE;
        gc.anchor = GridBagConstraints.LINE_START;
        mainPanel.add(employee,gc);
        ///////////////////////////////////////////////////////////////////////
        gc.gridx = 2;
        gc.gridy = 0;
        
        gc.ipadx = 0;
        gc.ipady = 0;

        gc.fill = GridBagConstraints.NONE;
        gc.anchor = GridBagConstraints.LINE_END;
        mainPanel.add(typeOfLeaveLabel,gc); 
        gc.ipadx= 124;
        gc.ipady = 6;
        
        gc.gridx = 3;
        gc.gridy = 0;
        gc.anchor = GridBagConstraints.LINE_START;
        mainPanel.add(typeOfLeave,gc);
        ///////////////////////////////////////// 2nd /////////////////////////
        gc.gridx = 0;
        gc.gridy = 1;
        
        gc.ipadx = 0;
        gc.ipady = 0;

        gc.fill = GridBagConstraints.NONE;
        gc.anchor = GridBagConstraints.LINE_END;
        mainPanel.add(fromLabel,gc); 
        gc.ipadx= 160;
        gc.ipady = 6;
        
        gc.gridx = 1;
        gc.gridy = 1;
        gc.anchor = GridBagConstraints.LINE_START;
        mainPanel.add(from,gc);
        ///////////////////////////////////////////////////////////////////////
        gc.gridx = 2;
        gc.gridy = 1;
        
        gc.ipadx = 0;
        gc.ipady = 0;

        gc.fill = GridBagConstraints.NONE;
        gc.anchor = GridBagConstraints.LINE_END;
        mainPanel.add(toLabel,gc); 
        gc.ipadx= 160;
        gc.ipady = 6;
        
        gc.gridx = 3;
        gc.gridy = 1;
        gc.anchor = GridBagConstraints.LINE_START;
        mainPanel.add(to,gc);
         ///////////////////////// Buttons /////////////////////////////////////
        btnPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));
        Dimension btnSize = addLeaveBtn.getPreferredSize();
        cancelBtn.setPreferredSize(btnSize);
        JLabel emptySpace = new JLabel("          ");
        btnPanel.add(cancelBtn);
        btnPanel.add(emptySpace);
        btnPanel.add(addLeaveBtn);
        
        
        setLayout(new BorderLayout());
        add(mainPanel,BorderLayout.CENTER);
        add(btnPanel,BorderLayout.SOUTH);
    }
     private void fillComboBox(){
    try{
        Connect conn = new Connect();
      String sql = "select * from employees";
      PreparedStatement prepStmt =conn.connect.prepareStatement(sql);
      ResultSet getResult = prepStmt.executeQuery();
      
      while(getResult.next()){
        String fname = getResult.getString("firstname");
        String mname = getResult.getString("middlename");
        String lname = getResult.getString("lastname");
        employee.addItem(fname+" "+mname+" "+lname);
      }
      prepStmt.close();
      conn.disconnect();
    }catch(Exception err){
      JOptionPane.showMessageDialog(null, err);
      }
    }
      private void clearField(){
   
   from.setDate(null);
   to.setDate(null);
   } 
}
