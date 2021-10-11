
package hr_application;

import com.toedter.calendar.JDateChooser;
import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.net.URL;
import javax.swing.BorderFactory;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;

public class deleteDialog extends JDialog{
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
    
    public deleteDialog(JFrame parent){
       super(parent, " Delete Records ", true);
       setSize(1140,300);
       setLocationRelativeTo(parent);
       
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
       
       mainLayout();
       
    }
    public void mainLayout(){
        
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
        gc.ipadx= 80;
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
         
        setLayout(new BorderLayout());
       // add(mainPanel,BorderLayout.CENTER);
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

