
package hr_application;

import com.toedter.calendar.JDateChooser;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
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

public class EditDialog extends JDialog{
    private JLabel categoryLabel;
    private JLabel idLabel;
    private JLabel fromDateLabel;
    private JLabel toDateLabel;
    private JComboBox category;
    private JTextField id;
    private JDateChooser fromDate;
    private JDateChooser toDate;
    private JButton searchBtn;
    private JLabel emptySpace;
    private JLabel emptySpace1;
    
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
    private JButton updateBtn;
    private JButton cancelBtn;
    private JDateChooser appraisalDate;
    private int emp_id = 0;
    
    public EditDialog(JFrame parent) throws Exception{
       super(parent, " Edit Records ", true);
       setSize(1000,500);
       setLocationRelativeTo(parent);
        Connect conn = new Connect();
       
       categoryLabel = new JLabel(" Select Category :  ");
       idLabel = new JLabel(" Enter ID :  ");
       fromDateLabel = new JLabel(" From :  ");
       toDateLabel = new JLabel(" To :  ");
       emptySpace = new JLabel("           ");
       emptySpace1 = new JLabel("           ");
       
       
       category = new JComboBox();
       category.setPrototypeDisplayValue("xxxxxxxxxxxxxxxxxxx");
        DefaultComboBoxModel cat = new DefaultComboBoxModel();
        cat.addElement("Select Category");
        cat.addElement("Employee's Infomations");
        cat.addElement("Training Informations");
        cat.addElement("Leave Informations");
        category.setModel(cat);
       
       id = new JTextField(10);
       fromDate = new JDateChooser();
       toDate = new JDateChooser();
       searchBtn =  new JButton("Search");
       searchBtn.setToolTipText("Search Record");
       searchBtn.setIcon(createIcon("/Image/search.png"));
       //////////////////////////////////////////////////////////////////////////////
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
    updateBtn = new JButton(" Update Employee ");
    gender = new JComboBox();
    DefaultComboBoxModel gendModel = new DefaultComboBoxModel();
    gendModel.addElement("Chooser Gender");
    gendModel.addElement("Male");
    gendModel.addElement("Female");
    gender.setModel(gendModel);
    education.setEditable(true);
    cancelBtn = new JButton("Cancel");
       
       mainLayout();
      // fieldLayout();
      
      searchBtn.addActionListener(new ActionListener() {
           @Override
           public void actionPerformed(ActionEvent e) {
          
             if(id.getText() != null){
                 if(category.getSelectedItem().toString() == "Employee's Infomations"){
                 try {
                    
                     String sql = "select * from employees where emp_id =?";
                     PreparedStatement prepStmt = conn.connect.prepareStatement(sql);
                     prepStmt.setString(1, id.getText());
                     ResultSet getResult = prepStmt.executeQuery();
                     emp_id = getResult.getInt("id");
                     employeeID.setText(getResult.getString("emp_id"));
                     firstName.setText(getResult.getString("firstname"));
                     middleName.setText(getResult.getString("middlename"));
                     lastName.setText(getResult.getString("lastname"));
                     DateFormat df = new SimpleDateFormat("MMM dd,yyyy");
                     Date date = df.parse(getResult.getString("birthdate"));
                     bday.setDate(date);
                     education.setSelectedItem(getResult.getString("education"));
                     gender.setSelectedItem(getResult.getString("gender"));
                     qualification.setText(getResult.getString("qualification"));
                     position.setText(getResult.getString("position"));
                     DateFormat df1 = new SimpleDateFormat("MMM dd,yyyy");
                     Date date1 = df1.parse(getResult.getString("appraisal"));
                     appraisalDate.setDate(date1);
                     expirience.setText(getResult.getString("experience"));
                     salary.setText(getResult.getString("salary"));
                     yearObjective.setText(getResult.getString("objective"));
                     
                 } catch (Exception ex) {
                     Logger.getLogger(EditDialog.class.getName()).log(Level.SEVERE, null, ex);
                 }
             }//
          } //main endif
           }
       });
      updateBtn.addActionListener(new ActionListener() {
           @Override
           public void actionPerformed(ActionEvent e) {
               try {
                   
                 //  Connect conn = new Connect();
                   String fname = firstName.getText();
                   String username = firstName.getText()+" "+middleName.getText()+" "+lastName.getText();
                   String sql = "update employees set emp_id=? , firstname=? , middlename=? , lastname=? , username=? , birthdate=? , gender=? ,"
                           + " education=? , qualification=? , appraisal=? , position=? , experience=? , salary=? , objective=?  where id=? ";
                   PreparedStatement prepStmt = conn.connect.prepareStatement(sql);
             prepStmt.setString(1, employeeID.getText());
             prepStmt.setString(2,firstName.getText());  
             prepStmt.setString(3,middleName.getText());
             prepStmt.setString(4,lastName.getText());
             prepStmt.setString(5, username);
             prepStmt.setString(6,bday.getDate().toString()); 
             prepStmt.setString(7,gender.getSelectedItem().toString());
             String eduLevel = education.getSelectedItem().toString();
             prepStmt.setString(8,eduLevel);
             prepStmt.setString(9,qualification.getText());
             prepStmt.setString(10, appraisalDate.getDate().toString());
             prepStmt.setString(11,position.getText());
             prepStmt.setString(12,expirience.getText());
             prepStmt.setString(13,salary.getText());
             prepStmt.setString(14,yearObjective.getText());
             prepStmt.setInt(15, emp_id);
             prepStmt.executeUpdate();
        
             JOptionPane.showMessageDialog(null, "Employee's Infoamtion have been Updated");
               } catch (Exception ex) {
                   Logger.getLogger(EditDialog.class.getName()).log(Level.SEVERE, null, ex);
                   JOptionPane.showMessageDialog(null, ex);
               }
           
           }
       });
    }
    public void mainLayout(){
        
        JPanel mainPanel = new JPanel();
        JPanel btnPanel = new JPanel();
        JPanel buttonPanel = new JPanel();
        
        Border innerBorder = BorderFactory.createTitledBorder("");
        Border outerBorder = BorderFactory.createEmptyBorder(5, 5, 5, 5);
        mainPanel.setBorder(BorderFactory.createCompoundBorder(outerBorder, innerBorder));
        btnPanel.setBorder(BorderFactory.createCompoundBorder(outerBorder, innerBorder));
        
         btnPanel.setLayout(new GridBagLayout());
         mainPanel.setLayout(new GridBagLayout());
         GridBagConstraints gc = new GridBagConstraints();
         
        gc.gridx = 0;
        gc.gridy = 0;
        
        gc.ipadx = 0;
        gc.ipady = 0;

        gc.fill = GridBagConstraints.NONE;
        gc.anchor = GridBagConstraints.LINE_END;
        btnPanel.add(emptySpace,gc); 
        //////////////////////////////////////////////////////////////////////
        gc.gridx = 0;
        gc.gridy = 1;
        
        gc.ipadx = 0;
        gc.ipady = 0;

        gc.fill = GridBagConstraints.NONE;
        gc.anchor = GridBagConstraints.LINE_END;
        btnPanel.add(categoryLabel,gc); 
        gc.ipadx= 45;
        gc.ipady = 0;
        
        gc.gridx = 1;
        gc.gridy = 1;
        gc.fill = GridBagConstraints.NONE;
        gc.anchor = GridBagConstraints.LINE_START;
        btnPanel.add(category,gc);
        ////////////////////////////////////////////////////////////////////////
        gc.gridx = 2;
        gc.gridy = 1;
        
        gc.ipadx = 0;
        gc.ipady = 0;
        
        gc.weightx = 1;
        gc.weighty = 1;
        gc.fill = GridBagConstraints.NONE;
        gc.anchor = GridBagConstraints.LINE_END;
        btnPanel.add(idLabel,gc); 
        
        gc.ipadx= 90;
        gc.ipady = 4;
        
        gc.gridx = 3;
        gc.gridy = 1;
        gc.anchor = GridBagConstraints.LINE_START;
        btnPanel.add(id,gc);
        ///////////////////////////////////////////////////////////////////////
        gc.gridx = 4;
        gc.gridy = 1;
        
        gc.ipadx = 0;
        gc.ipady = 0;

        gc.fill = GridBagConstraints.NONE;
        gc.anchor = GridBagConstraints.LINE_END;
        btnPanel.add(fromDateLabel,gc); 
        gc.ipadx= 90;
        gc.ipady = 6;
        
        gc.gridx = 5;
        gc.gridy = 1;
        gc.anchor = GridBagConstraints.LINE_START;
        btnPanel.add(fromDate,gc);
        ///////////////////////////////////////////////////////////////////////
        gc.gridx = 6;
        gc.gridy = 1;
        
        gc.ipadx = 0;
        gc.ipady = 0;

        gc.fill = GridBagConstraints.NONE;
        gc.anchor = GridBagConstraints.LINE_END;
        btnPanel.add(toDateLabel,gc); 
        gc.ipadx= 80;
        gc.ipady = 6;
        
        gc.gridx = 7;
        gc.gridy = 1;
        gc.anchor = GridBagConstraints.LINE_START;
        btnPanel.add(toDate,gc);
        ///////////////////////////////////////////////////////////////////////
        gc.ipadx = 0;
        gc.ipady = 0;
        
        gc.gridx = 8;
        gc.gridy = 1;
        gc.anchor = GridBagConstraints.LINE_START;
        btnPanel.add(searchBtn,gc);
        //////////////////////////////////////////////////////////////////////
        gc.gridx = 0;
        gc.gridy = 2;
        
        gc.ipadx = 0;
        gc.ipady = 0;

        gc.fill = GridBagConstraints.NONE;
        gc.anchor = GridBagConstraints.LINE_END;
        btnPanel.add(emptySpace1,gc);
       
        
        
        /////////////////////////////////////////////////////////////////////////////////
        gc.gridx = 0;
        gc.gridy = 4;
        
        gc.ipadx = 0;
        gc.ipady = 0;
        
        gc.weightx = 1;
        gc.weighty = 1;
        gc.fill = GridBagConstraints.NONE;
        gc.anchor = GridBagConstraints.LINE_END;
        mainPanel.add(employeeIDLabel,gc); 
        gc.ipadx= 134;
        gc.ipady = 6;
        
        gc.gridx = 1;
        gc.gridy = 4;
        gc.anchor = GridBagConstraints.LINE_START;
        mainPanel.add(employeeID,gc);
       ////////////////////////////////////// 1st ///////////////////////////// 
        gc.gridx = 0;
        gc.gridy = 5;
        
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
        gc.gridy = 5;
        gc.anchor = GridBagConstraints.LINE_START;
        mainPanel.add(firstName,gc);
        //////////////////////////////////// 2nd //////////////////////////////
        gc.gridx = 0;
        gc.gridy = 6;
        
        gc.ipadx = 0;
        gc.ipady = 0;

        gc.fill = GridBagConstraints.NONE;
        gc.anchor = GridBagConstraints.LINE_END;
        mainPanel.add(middleNameLabel,gc); 
        gc.ipadx= 134;
        gc.ipady = 6;
        
        gc.gridx = 1;
        gc.gridy = 6;
        gc.anchor = GridBagConstraints.LINE_START;
        mainPanel.add(middleName,gc);
        ///////////////////////////////////// 3rd /////////////////////////////
        gc.gridx = 0;
        gc.gridy = 7;
        
        gc.ipadx = 0;
        gc.ipady = 0;

        gc.fill = GridBagConstraints.NONE;
        gc.anchor = GridBagConstraints.LINE_END;
        mainPanel.add(lastNameLabel,gc); 
        gc.ipadx= 134;
        gc.ipady = 6;
        
        gc.gridx = 1;
        gc.gridy = 7;
        gc.anchor = GridBagConstraints.LINE_START;
        mainPanel.add(lastName,gc);
        /////////////////////////////////////// 4th ////////////////////////////
        gc.gridx = 0;
        gc.gridy = 8;
        
        gc.ipadx = 0;
        gc.ipady = 0;

        gc.fill = GridBagConstraints.NONE;
        gc.anchor = GridBagConstraints.LINE_END;
        mainPanel.add(bdayLabel,gc); 
        gc.ipadx= 158;
        gc.ipady = 10;
        
        gc.gridx = 1;
        gc.gridy = 8;
        gc.anchor = GridBagConstraints.LINE_START;
        mainPanel.add(bday,gc);
        ////////////////////////////////////////////////////////////////////////
        gc.gridx = 0;
        gc.gridy = 9;
        
        gc.ipadx = 0;
        gc.ipady = 0;
        
        gc.fill = GridBagConstraints.NONE;
        gc.anchor = GridBagConstraints.LINE_END;
        mainPanel.add(genderLabel,gc); 
        gc.ipadx= 128;
        gc.ipady = 4;
        gc.weightx = 0;
        gc.weighty = 0;
        gc.gridx = 1;
        gc.gridy = 9;
        gc.anchor = GridBagConstraints.LINE_START;
        mainPanel.add(gender,gc);
        ///////////////////////////////////////////////////
        gc.gridx = 0;
        gc.gridy = 10;
        
        gc.ipadx = 0;
        gc.ipady = 0;

        gc.fill = GridBagConstraints.NONE;
        gc.anchor = GridBagConstraints.LINE_END;
        mainPanel.add(qualificationLabel,gc); 
        gc.ipadx= 250;
        gc.ipady = 50;
        
        gc.gridx = 1;
        gc.gridy = 10;
        gc.anchor = GridBagConstraints.LINE_START;
        mainPanel.add(new JScrollPane(qualification),gc);
        
        
 /***************************************************************************/
        gc.gridx = 2;
        gc.gridy = 4;
        
        gc.ipadx = 0;
        gc.ipady = 0;
        gc.weightx = 1;
        gc.weighty = 1;
        gc.fill = GridBagConstraints.NONE;
        gc.anchor = GridBagConstraints.LINE_END;
        mainPanel.add(educationLabel,gc); 
        gc.ipadx= 120;
        gc.ipady = 0;
        
        gc.gridx = 3;
        gc.gridy = 4;
        gc.anchor = GridBagConstraints.LINE_START;
        mainPanel.add(education,gc);
        
        /***********************************************/
        gc.gridx = 2;
        gc.gridy = 5;
        
        gc.ipadx = 0;
        gc.ipady = 0;

        gc.fill = GridBagConstraints.NONE;
        gc.anchor = GridBagConstraints.LINE_END;
        mainPanel.add(appraisalLabel,gc); 
        gc.ipadx= 161;
        gc.ipady = 4;
        
        gc.gridx = 3;
        gc.gridy = 5;
        gc.anchor = GridBagConstraints.LINE_START;
        mainPanel.add(appraisalDate,gc);
        /****************************************************/
        gc.gridx = 2;
        gc.gridy = 6;
        
        gc.ipadx = 0;
        gc.ipady = 0;

        gc.fill = GridBagConstraints.NONE;
        gc.anchor = GridBagConstraints.LINE_END;
        mainPanel.add(positionLabel,gc); 
        gc.ipadx= 135;
        gc.ipady = 6;
        
        gc.gridx = 3;
        gc.gridy = 6;
        gc.anchor = GridBagConstraints.LINE_START;
        mainPanel.add(position,gc);
        /*****************************************************/
        gc.gridx = 2;
        gc.gridy = 7;
        
        gc.ipadx = 0;
        gc.ipady = 0;

        gc.fill = GridBagConstraints.NONE;
        gc.anchor = GridBagConstraints.LINE_END;
        mainPanel.add(expirienceLabel,gc); 
        gc.ipadx= 134;
        gc.ipady = 6;
        
        gc.gridx = 3;
        gc.gridy = 7;
        gc.anchor = GridBagConstraints.LINE_START;
        mainPanel.add(expirience,gc);
        /***********************************************/
        gc.gridx = 2;
        gc.gridy = 8;
        
        gc.ipadx = 0;
        gc.ipady = 0;

        gc.fill = GridBagConstraints.NONE;
        gc.anchor = GridBagConstraints.LINE_END;
        mainPanel.add(salaryLabel,gc); 
        gc.ipadx= 134;
        gc.ipady = 6;
        
        gc.gridx = 3;
        gc.gridy = 8;
        gc.anchor = GridBagConstraints.LINE_START;
        mainPanel.add(salary,gc);
        /************************************************/
        gc.gridx = 2;
        gc.gridy = 9;
        
        gc.ipadx = 0;
        gc.ipady = 0;

        gc.fill = GridBagConstraints.NONE;
        gc.anchor = GridBagConstraints.LINE_END;
        mainPanel.add(yearObjectiveLabel,gc); 
        gc.ipadx= 250;
        gc.ipady = 50;
        
        gc.gridx = 3;
        gc.gridy = 9;
        gc.anchor = GridBagConstraints.LINE_START;
        mainPanel.add(new JScrollPane(yearObjective),gc);
 
 /***************************************************************************/
 /**************************************************************************/
 
 btnPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));
        Dimension btnSize = updateBtn.getPreferredSize();
        cancelBtn.setPreferredSize(btnSize);
        JLabel emptySpace = new JLabel("          ");
        buttonPanel.add(cancelBtn);
        buttonPanel.add(emptySpace);
        buttonPanel.add(updateBtn);
        
        setLayout(new BorderLayout());
        add(mainPanel,BorderLayout.CENTER);
        add(btnPanel,BorderLayout.NORTH);
        add(buttonPanel,BorderLayout.SOUTH);
    }
    
    private ImageIcon createIcon(String path){
    URL url = getClass().getResource(path);
    if(url == null){
    System.err.println("Unable to load Icon "+ path);
    }
    ImageIcon icon = new ImageIcon(url);
    return icon;
    }
}