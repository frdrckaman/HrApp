
package hr_application;

import com.toedter.calendar.JDateChooser;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.ScrollPane;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.Border;

public class addEmployeeDialog extends JDialog{
    private JLabel employeeIDLabel;
    private JLabel firstNameLabel;
    private JLabel middleNameLabel;
    private JLabel lastNameLabel;
    private JLabel bdayLabel;
    private JLabel genderLabel;
    private JLabel educationLabel;
    private JLabel qualificationLabel;
    private JLabel positionLabel;
    private JLabel expirienceLabel;
    private JLabel salaryLabel;
    private JLabel yearObjectiveLabel;
    private JLabel appraisalLabel;
    
    private JTextField employeeID;
    private JTextField firstName;
    private JTextField middleName;
    private JTextField lastName;
    private JDateChooser bday;
    private JComboBox gender;
    private JComboBox education;
    private JTextArea qualification;
    private JTextField position;
    private JTextField expirience;
    private JTextField salary;
    private JTextArea yearObjective;
    private JButton addEmployeeBtn;
    private JButton cancelBtn;
    private JDateChooser appraisalDate;
    
    private String genderChecked;
    private Connect conn;
    public addEmployeeDialog(JFrame parent){
    super(parent, " Add Employee ", true);
    setSize(610,700);
    setLocationRelativeTo(parent);
    
    employeeIDLabel = new JLabel(" Employee ID  :   ");
    firstNameLabel = new JLabel(" First Name  :   ");
    middleNameLabel = new JLabel(" Middle Name  :   ");
    lastNameLabel = new JLabel(" Last Name  :   ");
    bdayLabel = new JLabel(" BirthDate  :   ");
    genderLabel = new JLabel(" Gender  :   ");
    educationLabel = new JLabel(" Education Level  :   ");
    qualificationLabel = new JLabel(" Qualifications  :   ");
    positionLabel = new JLabel(" Position  :   ");
    expirienceLabel = new JLabel(" Expirience  :   ");
    salaryLabel = new JLabel(" Salary  :   ");
    yearObjectiveLabel = new JLabel(" Yearly Objectives  :   ");
    appraisalLabel = new JLabel(" Appraisal Date  :   ");
    
    employeeID = new JTextField(10);
    firstName = new JTextField(10);
    middleName = new JTextField(10);
    lastName = new JTextField(10);
    bday = new JDateChooser();
    appraisalDate = new JDateChooser();
    gender = new JComboBox();
    DefaultComboBoxModel gendModel = new DefaultComboBoxModel();
    gendModel.addElement("Chooser Gender");
    gendModel.addElement("Male");
    gendModel.addElement("Female");
    gender.setModel(gendModel);
    
    education = new JComboBox();
    DefaultComboBoxModel eduModel = new DefaultComboBoxModel();
   eduModel.addElement(" Select Education ");
   eduModel.addElement(" Standard 7 ");
   eduModel.addElement(" O Level ");
   eduModel.addElement(" A Level ");
    eduModel.addElement(" Certificate ");
    eduModel.addElement(" Diploma ");
    eduModel.addElement(" Bachelor Degree ");
    eduModel.addElement(" Master Degree ");
    eduModel.addElement(" PHD ");
    education.setModel(eduModel);
    qualification = new JTextArea();
    position = new JTextField(10);
    expirience = new JTextField(10);
    salary = new JTextField(10);
    yearObjective = new JTextArea();
    addEmployeeBtn = new JButton(" Add Employee ");
    cancelBtn = new JButton(" Clear ");
  
    education.setEditable(true);
    
    addEmployeeLayout();
     
     
      cancelBtn.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
       clearText();
        }
    });
     
     addEmployeeBtn.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
         addEmployee();
        }
    });    
     
    }    

    public void addEmployeeLayout(){
    
        JPanel mainPanel = new JPanel();
        JPanel btnPanel = new JPanel();
        
        Border innerBorder = BorderFactory.createTitledBorder("");
        Border outerBorder = BorderFactory.createEmptyBorder(5, 5, 5, 5);
        mainPanel.setBorder(BorderFactory.createCompoundBorder(outerBorder, innerBorder));
        //btnPanel.setBorder(BorderFactory.createCompoundBorder(outerBorder, innerBorder));
        
        mainPanel.setLayout(new GridBagLayout());
        GridBagConstraints gc = new GridBagConstraints();
        
        /////////////////////////// 00th //////////////////////////////////////
        gc.gridx = 0;
        gc.gridy = 0;
        
        gc.ipadx = 0;
        gc.ipady = 0;
        
        gc.weightx = 1;
        gc.weighty = 1;
        gc.fill = GridBagConstraints.NONE;
        gc.anchor = GridBagConstraints.LINE_END;
        mainPanel.add(employeeIDLabel,gc); 
        gc.ipadx= 134;
        gc.ipady = 6;
        
        gc.gridx=1;
        gc.gridy = 0;
        gc.anchor = GridBagConstraints.LINE_START;
        mainPanel.add(employeeID,gc);
       ////////////////////////////////////// 1st ///////////////////////////// 
        gc.gridx = 0;
        gc.gridy = 1;
        
        gc.ipadx = 0;
        gc.ipady = 0;
        
        gc.weightx = 1;
        gc.weighty = 1;
        gc.fill = GridBagConstraints.NONE;
        gc.anchor = GridBagConstraints.LINE_END;
        mainPanel.add(firstNameLabel,gc); 
        gc.ipadx= 134;
        gc.ipady = 6;
        
        gc.gridx = 1;
        gc.gridy = 1;
        gc.anchor = GridBagConstraints.LINE_START;
        mainPanel.add(firstName,gc);
        //////////////////////////////////// 2nd //////////////////////////////
        gc.gridx = 0;
        gc.gridy = 2;
        
        gc.ipadx = 0;
        gc.ipady = 0;

        gc.fill = GridBagConstraints.NONE;
        gc.anchor = GridBagConstraints.LINE_END;
        mainPanel.add(middleNameLabel,gc); 
        gc.ipadx= 134;
        gc.ipady = 6;
        
        gc.gridx = 1;
        gc.gridy = 2;
        gc.anchor = GridBagConstraints.LINE_START;
        mainPanel.add(middleName,gc);
        ///////////////////////////////////// 3rd /////////////////////////////
        gc.gridx = 0;
        gc.gridy = 3;
        
        gc.ipadx = 0;
        gc.ipady = 0;

        gc.fill = GridBagConstraints.NONE;
        gc.anchor = GridBagConstraints.LINE_END;
        mainPanel.add(lastNameLabel,gc); 
        gc.ipadx= 134;
        gc.ipady = 6;
        
        gc.gridx = 1;
        gc.gridy = 3;
        gc.anchor = GridBagConstraints.LINE_START;
        mainPanel.add(lastName,gc);
        /////////////////////////////////////// 4th ////////////////////////////
        gc.gridx = 0;
        gc.gridy = 4;
        
        gc.ipadx = 0;
        gc.ipady = 0;

        gc.fill = GridBagConstraints.NONE;
        gc.anchor = GridBagConstraints.LINE_END;
        mainPanel.add(bdayLabel,gc); 
        gc.ipadx= 158;
        gc.ipady = 10;
        
        gc.gridx = 1;
        gc.gridy = 4;
        gc.anchor = GridBagConstraints.LINE_START;
        mainPanel.add(bday,gc);
        ///////////////////////////////// 5th /////////////////////////////////
        gc.gridx = 0;
        gc.gridy = 5;
        
        gc.ipadx = 0;
        gc.ipady = 0;
        
        gc.fill = GridBagConstraints.NONE;
        gc.anchor = GridBagConstraints.LINE_END;
        mainPanel.add(genderLabel,gc); 
        gc.ipadx= 134;
        gc.ipady = 4;
        gc.weightx = 0;
        gc.weighty = 0;
        gc.gridx = 1;
        gc.gridy = 5;
        gc.anchor = GridBagConstraints.LINE_START;
        mainPanel.add(gender,gc);
        
        ////////////////////////////// 6th ////////////////////////////////////
        gc.gridx = 0;
        gc.gridy = 6;
        
        gc.ipadx = 0;
        gc.ipady = 0;
        gc.weightx = 1;
        gc.weighty = 1;
        gc.fill = GridBagConstraints.NONE;
        gc.anchor = GridBagConstraints.LINE_END;
        mainPanel.add(educationLabel,gc); 
        gc.ipadx= 120;
        gc.ipady = 6;
        
        gc.gridx = 1;
        gc.gridy = 6;
        gc.anchor = GridBagConstraints.LINE_START;
        mainPanel.add(education,gc);
        //////////////////////////////////////////// 7th //////////////////////
        gc.gridx = 0;
        gc.gridy = 7;
        
        gc.ipadx = 0;
        gc.ipady = 0;

        gc.fill = GridBagConstraints.NONE;
        gc.anchor = GridBagConstraints.LINE_END;
        mainPanel.add(qualificationLabel,gc); 
        gc.ipadx= 250;
        gc.ipady = 50;
        
        gc.gridx = 1;
        gc.gridy = 7;
        gc.anchor = GridBagConstraints.LINE_START;
        mainPanel.add(new JScrollPane(qualification),gc);
        //////////////////////////////// 8th///////////////////////////////////////
        gc.gridx = 0;
        gc.gridy = 8;
        
        gc.ipadx = 0;
        gc.ipady = 0;

        gc.fill = GridBagConstraints.NONE;
        gc.anchor = GridBagConstraints.LINE_END;
        mainPanel.add(appraisalLabel,gc); 
        gc.ipadx= 158;
        gc.ipady = 10;
        
        gc.gridx = 1;
        gc.gridy = 8;
        gc.anchor = GridBagConstraints.LINE_START;
        mainPanel.add(appraisalDate,gc);
        ////////////////////////////////////// 9th ////////////////////////////
        gc.gridx = 0;
        gc.gridy = 9;
        
        gc.ipadx = 0;
        gc.ipady = 0;

        gc.fill = GridBagConstraints.NONE;
        gc.anchor = GridBagConstraints.LINE_END;
        mainPanel.add(positionLabel,gc); 
        gc.ipadx= 134;
        gc.ipady = 10;
        
        gc.gridx = 1;
        gc.gridy = 9;
        gc.anchor = GridBagConstraints.LINE_START;
        mainPanel.add(position,gc);
        ////////////////////////////////// 10th ////////////////////////////////
        gc.gridx = 0;
        gc.gridy = 10;
        
        gc.ipadx = 0;
        gc.ipady = 0;

        gc.fill = GridBagConstraints.NONE;
        gc.anchor = GridBagConstraints.LINE_END;
        mainPanel.add(expirienceLabel,gc); 
        gc.ipadx= 134;
        gc.ipady = 6;
        
        gc.gridx = 1;
        gc.gridy = 10;
        gc.anchor = GridBagConstraints.LINE_START;
        mainPanel.add(expirience,gc);
        ///////////////////////////////////////////// 11th ////////////////////
        gc.gridx = 0;
        gc.gridy = 11;
        
        gc.ipadx = 0;
        gc.ipady = 0;

        gc.fill = GridBagConstraints.NONE;
        gc.anchor = GridBagConstraints.LINE_END;
        mainPanel.add(salaryLabel,gc); 
        gc.ipadx= 134;
        gc.ipady = 6;
        
        gc.gridx = 1;
        gc.gridy = 11;
        gc.anchor = GridBagConstraints.LINE_START;
        mainPanel.add(salary,gc);
        /////////////////////////////////////// 12th //////////////////////////
        gc.gridx = 0;
        gc.gridy = 12;
        
        gc.ipadx = 0;
        gc.ipady = 0;

        gc.fill = GridBagConstraints.NONE;
        gc.anchor = GridBagConstraints.LINE_END;
        mainPanel.add(yearObjectiveLabel,gc); 
        gc.ipadx= 250;
        gc.ipady = 50;
        
        gc.gridx = 1;
        gc.gridy = 12;
        gc.anchor = GridBagConstraints.LINE_START;
        mainPanel.add(new JScrollPane(yearObjective),gc);
        ///////////////////////// Buttons /////////////////////////////////////
        btnPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));
        Dimension btnSize = addEmployeeBtn.getPreferredSize();
        cancelBtn.setPreferredSize(btnSize);
        JLabel emptySpace = new JLabel("          ");
        btnPanel.add(cancelBtn);
        btnPanel.add(emptySpace);
        btnPanel.add(addEmployeeBtn);
        
        setLayout(new BorderLayout());
        add(mainPanel,BorderLayout.CENTER);
        add(btnPanel,BorderLayout.SOUTH);
    }
    public void clearText(){
        employeeID.setText("");
        firstName.setText("");
        middleName.setText("");
        lastName.setText("");
        bday.setDate(null);
        qualification.setText("");
        position.setText("");
        expirience.setText("");
        salary.setText("");
        yearObjective.setText("");
    }
    
    public void addEmployee(){
    try {
            conn = new Connect();
             String sql = "insert into employees (emp_id,firstname,middlename,lastname,username,birthdate,gender,education,"
                     + "qualification,appraisal,position,experience,salary,objective) values (?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
             PreparedStatement prepStmt = conn.connect.prepareStatement(sql);
             prepStmt.setString(1, employeeID.getText());
             prepStmt.setString(2,firstName.getText());
             prepStmt.setString(3,middleName.getText());
             prepStmt.setString(4,lastName.getText());
             String username = firstName.getText()+" "+middleName.getText()+" "+lastName.getText();
             prepStmt.setString(5, username);
             Date date = bday.getDate();
             String dt = DateFormat.getDateInstance().format(date);
             prepStmt.setString(6,dt); 
             prepStmt.setString(7,gender.getSelectedItem().toString());
             String eduLevel = education.getSelectedItem().toString();
             prepStmt.setString(8,eduLevel);
             prepStmt.setString(9,qualification.getText());
             Date date1 = appraisalDate.getDate();
             String dt1 = DateFormat.getDateInstance().format(date1);
             prepStmt.setString(10, dt1);
             prepStmt.setString(11,position.getText());
             prepStmt.setString(12,expirience.getText());
             prepStmt.setString(13,salary.getText());
             prepStmt.setString(14,yearObjective.getText());
             prepStmt.executeUpdate();
             
             JOptionPane.showMessageDialog(null, "Employee successiiful add to Database");
             clearText();
             conn.disconnect();
             TablePanel tablePanel = new TablePanel();
             
         }catch(Exception er){
             JOptionPane.showMessageDialog(null, er);
           }
    }
    
}
