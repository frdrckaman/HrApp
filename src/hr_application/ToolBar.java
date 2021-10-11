
package hr_application;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JToolBar;


public class ToolBar extends JToolBar implements ActionListener{ 
    private JButton addEmployeeBtn;
    private JButton addTrainingBtn;
    private JButton addLeaveBtn;
  /*  private JButton employeeReportBtn;
    private JButton trainingReportBtn;*/
    private JButton leaveBtn;
    private JButton employeesBtn;
    private JButton trainingBtn;
    private JButton helpBtn;
    private JButton refreshBtn;
    //private fuelDialog fuelCalc;
    
    private ToolbarListener toolBarListener;
   
    public ToolBar() {
        
        setBorder( BorderFactory.createEtchedBorder());
        setFloatable(false);
     addEmployeeBtn = new JButton();
     addEmployeeBtn.setBorder(null);
     addEmployeeBtn.setToolTipText("Add Employee");
     addEmployeeBtn.setIcon(createIcon("/Image/addEmployee.png"));
     addTrainingBtn =  new JButton(); 
     addTrainingBtn.setBorder(null);
     addTrainingBtn.setIcon(createIcon("/Image/addTraining.png"));
     addTrainingBtn.setToolTipText("Add Training");
     addLeaveBtn = new JButton();
     addLeaveBtn.setBorder(null);
     addLeaveBtn.setToolTipText("Add Leave");
     addLeaveBtn.setIcon(createIcon("/Image/addLeave.png"));
    /* employeeReportBtn = new JButton();
     employeeReportBtn.setBorder(null);
     employeeReportBtn.setToolTipText("Employees Report");
     employeeReportBtn.setIcon(createIcon("/Image/AddTrip.png"));
     trainingReportBtn = new JButton();
     trainingReportBtn.setBorder(null);
     trainingReportBtn.setToolTipText("Training Report");
     trainingReportBtn.setIcon(createIcon("/Image/AddDriver.png"));*/
     leaveBtn = new JButton();
     leaveBtn.setBorder(null);
     leaveBtn.setToolTipText("List of Leaves");
     leaveBtn.setIcon(createIcon("/Image/leave.png")); 
     employeesBtn = new JButton();
     employeesBtn.setBorder(null);
     employeesBtn.setToolTipText("List of Employees");
     employeesBtn.setIcon(createIcon("/Image/employees.png"));
     trainingBtn = new JButton();
     trainingBtn.setBorder(null);
     trainingBtn.setToolTipText("list of Trainings");
     trainingBtn.setIcon(createIcon("/Image/training.png"));
     helpBtn = new JButton();
     helpBtn.setBorder(null);
     helpBtn.setToolTipText("Help");
     helpBtn.setIcon(createIcon("/Image/help.png"));
     refreshBtn = new JButton();
     refreshBtn.setBorder(null);
     refreshBtn.setToolTipText("Refresh Table");
     refreshBtn.setIcon(createIcon("/Image/refresh.png"));
     
     addEmployeeBtn.addActionListener(this);
     addTrainingBtn.addActionListener(this);
     addLeaveBtn.addActionListener(this);
    /* employeeReportBtn.addActionListener(this);
     trainingReportBtn.addActionListener(this);*/
     leaveBtn.addActionListener(this);
     employeesBtn.addActionListener(this);
     trainingBtn.addActionListener(this);
     refreshBtn.addActionListener(this);
     
     setLayout(new FlowLayout(FlowLayout.LEFT));
     add(addEmployeeBtn);
     addSeparator();
     add(addTrainingBtn);
     addSeparator();
     add(addLeaveBtn);
     addSeparator();
    /* add(employeeReportBtn);
     addSeparator();
     add(trainingReportBtn);
     addSeparator();*/
     add(employeesBtn);
     addSeparator();
     add(trainingBtn);
     addSeparator();
     add(leaveBtn);
     addSeparator();
     add(refreshBtn);
     addSeparator();
     add(helpBtn);
     
    // fuelBtn.addActionListener();
    }
    private ImageIcon createIcon(String path){
    URL url = getClass().getResource(path);
    if(url == null){
    System.err.println("Unable to load Icon "+ path);
    }
    ImageIcon icon = new ImageIcon(url);
    return icon;
    }
    
    public void  setToolbarListener(ToolbarListener listener){
    this.toolBarListener = listener;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton click = (JButton)e.getSource();
       
        if(click == addEmployeeBtn){
        //System.out.println("Fuel icon clicked");
        toolBarListener.ToolbarAction(true);
        } 
        else if(click == addTrainingBtn) {
        toolBarListener.addTraining(true);
        }
        else if(click == addLeaveBtn) {
           // System.out.println("Fuel icon clicked");
        toolBarListener.addLeave(true);
        }
        else if(click == employeesBtn) {
           // System.out.println("Fuel icon clicked");
        toolBarListener.employee(true);
        }
        else if(click == trainingBtn) {
        toolBarListener.training(true);
        }
        else if(click == leaveBtn) {
        toolBarListener.leave(true);
        }
        else if(click == refreshBtn) {
        toolBarListener.refresh();
        }
        else if(click == helpBtn) {
        toolBarListener.help(true);
        }
    }
    
}
