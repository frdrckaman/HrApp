package hr_application;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.net.URL;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.table.AbstractTableModel;
import net.proteanit.sql.DbUtils;

public class employeeDialog extends JDialog{
    private JLabel searchLabel;
    private JLabel emptySpaces;
    private JTextField search;
    private JButton searchBtn;
    private JButton printBtn;
    private JTable empTable;
    private JLabel emptySpace;
    private JLabel emptySpace1;
    
    public employeeDialog(JFrame parent){
     super(parent, " List of Employees ", true);
     setSize(880,300);
     setLocationRelativeTo(parent);
     
     empTable = new JTable();
     emptySpaces = new JLabel("             "
             + "                               "
             + "                              "
             + "                ");
     searchLabel = new JLabel(" Search :   ");
     search = new JTextField(10);
     searchBtn = new JButton(" Search ");
     searchBtn.setToolTipText("Search for Employee");
     searchBtn.setIcon(createIcon("/Image/search.png"));
     printBtn = new JButton(" Print ");
     printBtn.setToolTipText("Print");
     printBtn.setIcon(createIcon("/Image/printer.png"));
     emptySpace = new JLabel("           ");
     emptySpace1 = new JLabel("           ");
     
     employeeDialogLayout();
     
    
    }
    
    public void employeeDialogLayout(){
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
        
        gc.weightx = 1;
        gc.weighty = 1;
        gc.fill = GridBagConstraints.NONE;
        gc.anchor = GridBagConstraints.LINE_END;
        btnPanel.add(searchLabel,gc); 
        /////////////////////////////////////////////////////////////////////////
        gc.ipadx= 124;
        gc.ipady = 6;
        
        gc.gridx = 1;
        gc.gridy = 1;
        gc.anchor = GridBagConstraints.LINE_START;
        btnPanel.add(search,gc);
        //////////////////////////////////////////////////////////////////////
        gc.ipadx= 0;
        gc.ipady = 0;
        
        gc.gridx = 2;
        gc.gridy = 1;
        gc.anchor = GridBagConstraints.LINE_START;
        btnPanel.add(searchBtn,gc);
        //////////////////////////////////////////////////////////////////////
        gc.gridx = 3;
        gc.gridy = 1;
        
        gc.ipadx = 0;
        gc.ipady = 0;
        
        gc.weightx = 1;
        gc.weighty = 1;
        gc.fill = GridBagConstraints.NONE;
        gc.anchor = GridBagConstraints.LINE_END;
        btnPanel.add(emptySpaces,gc); 
        ////////////////////////////////////////////////////////////////////
        gc.ipadx = 0;
        gc.ipady = 0;
        
        gc.gridx = 4;
        gc.gridy = 1;
        gc.anchor = GridBagConstraints.LINE_START;
        btnPanel.add(printBtn,gc);
        ///////////////////////////////////////////////////////////////////////
        gc.gridx = 0;
        gc.gridy = 2;
        
        gc.ipadx = 0;
        gc.ipady = 0;

        gc.fill = GridBagConstraints.NONE;
        gc.anchor = GridBagConstraints.LINE_END;
        btnPanel.add(emptySpace1,gc);
        
        
        TablePanel table = new TablePanel(1);
        setLayout(new BorderLayout());
        add(table,BorderLayout.CENTER);
        add(btnPanel,BorderLayout.NORTH);
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
