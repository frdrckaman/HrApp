package hr_application;

import com.toedter.calendar.JDateChooser;
import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.net.URL;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.BorderFactory;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;

public class leaveDialog extends JDialog{
    private JLabel employeeLabel;
    private JLabel fromDateLabel;
    private JLabel toDateLabel;
    private JComboBox employee;
    private JDateChooser fromDate;
    private JDateChooser toDate;
    private JButton searchBtn;
    private JLabel spaceLabel;
    private JLabel emptySpace;
    private JLabel emptySpace1;

    public leaveDialog(JFrame parent){
     super(parent, " List of Leave ", true);
     setSize(880,300);
     setLocationRelativeTo(parent);
     
       employeeLabel = new JLabel(" Select Employee :  ");
       fromDateLabel = new JLabel(" From :  ");
       toDateLabel = new JLabel(" To :  ");
       spaceLabel = new JLabel("           ");
       
       employee = new JComboBox();
       employee.setPrototypeDisplayValue("xxxxxxxxxxxx");
        DefaultComboBoxModel cat = new DefaultComboBoxModel();
        cat.addElement("Select Employee");
        employee.setModel(cat);
        
       fromDate = new JDateChooser();
       toDate = new JDateChooser();
       searchBtn = new JButton("Search");
       searchBtn.setToolTipText("Search Record");
       searchBtn.setIcon(createIcon("/Image/search.png"));
       emptySpace = new JLabel("           ");
       emptySpace1 = new JLabel("           ");
     
     leaveDialogLayout();
     fillComboBox();
    }
    
    public void leaveDialogLayout() {
        JPanel mainPanel = new JPanel();
        JPanel btnPanel = new JPanel();
        
        Border innerBorder = BorderFactory.createTitledBorder("");
        Border outerBorder = BorderFactory.createEmptyBorder(5, 5, 5, 5);
        mainPanel.setBorder(BorderFactory.createCompoundBorder(outerBorder, innerBorder));
        btnPanel.setBorder(BorderFactory.createCompoundBorder(outerBorder, innerBorder));
        
         btnPanel.setLayout(new GridBagLayout());
         GridBagConstraints gc = new GridBagConstraints();
         
        gc.gridx = 0;
        gc.gridy = 0;
        
        gc.ipadx = 0;
        gc.ipady = 0;

        gc.fill = GridBagConstraints.NONE;
        gc.anchor = GridBagConstraints.LINE_END;
        btnPanel.add(emptySpace,gc);
        ////////////////////////////////////////////////////////////////////////
        gc.gridx = 0;
        gc.gridy = 1;
        
        gc.ipadx = 0;
        gc.ipady = 0;

        gc.fill = GridBagConstraints.NONE;
        gc.anchor = GridBagConstraints.LINE_END;
        btnPanel.add(employeeLabel,gc); 
        gc.ipadx= 135;
        gc.ipady = 0;
        
        gc.gridx = 1;
        gc.gridy = 1;
        gc.fill = GridBagConstraints.NONE;
        gc.anchor = GridBagConstraints.LINE_START;
        btnPanel.add(employee,gc);
        ///////////////////////////////////////////////////////////////////////
        gc.gridx = 2;
        gc.gridy = 1;
        
        gc.ipadx = 0;
        gc.ipady = 0;

        gc.fill = GridBagConstraints.NONE;
        gc.anchor = GridBagConstraints.LINE_END;
        btnPanel.add(fromDateLabel,gc); 
        gc.ipadx= 100;
        gc.ipady = 6;
        
        gc.gridx = 3;
        gc.gridy = 1;
        gc.anchor = GridBagConstraints.LINE_START;
        btnPanel.add(fromDate,gc);
        ///////////////////////////////////////////////////////////////////////
        gc.gridx = 4;
        gc.gridy = 1;
        
        gc.ipadx = 0;
        gc.ipady = 0;

        gc.fill = GridBagConstraints.NONE;
        gc.anchor = GridBagConstraints.LINE_END;
        btnPanel.add(toDateLabel,gc); 
        gc.ipadx= 100;
        gc.ipady = 6;
        
        gc.gridx = 5;
        gc.gridy = 1;
        gc.anchor = GridBagConstraints.LINE_START;
        btnPanel.add(toDate,gc);
        ///////////////////////////////////////////////////////////////////////
        gc.gridx = 6;
        gc.gridy = 1;
        
        gc.ipadx = 0;
        gc.ipady = 0;

        gc.fill = GridBagConstraints.NONE;
        gc.anchor = GridBagConstraints.LINE_END;
        btnPanel.add(spaceLabel,gc);
        
        gc.ipadx = 0;
        gc.ipady = 0;
        
        gc.gridx = 7;
        gc.gridy = 1;
        gc.anchor = GridBagConstraints.LINE_START;
        btnPanel.add(searchBtn,gc);
        ///////////////////////////////////////////////////////////////////////
        gc.gridx = 0;
        gc.gridy = 2;
        
        gc.ipadx = 0;
        gc.ipady = 0;

        gc.fill = GridBagConstraints.NONE;
        gc.anchor = GridBagConstraints.LINE_END;
        btnPanel.add(emptySpace1,gc);
        
        TablePanel table = new TablePanel(0.1);
        setLayout(new BorderLayout());
        add(table,BorderLayout.CENTER);
        add(btnPanel,BorderLayout.NORTH);
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
        String emp_id = getResult.getString("emp_id");
        employee.addItem(fname+" "+mname+" "+lname+" ID No :  "+emp_id);
      }
      prepStmt.close();
      conn.disconnect();
    }catch(Exception err){
      JOptionPane.showMessageDialog(null, err);
      }
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
