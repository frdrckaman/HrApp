
package hr_application;

import com.sun.glass.events.KeyEvent;
import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JTextArea;
import javax.swing.KeyStroke;

public class MainFrame extends JFrame{
    
 /*   private TextPanel textPanel;
    private JButton button;*/
    private ToolBar toolbar;
  // private FormPanel formPanel;
    private addEmployeeDialog employeeDialog;
    private addTrainingDialog trainingDialog;
    private addLeaveDialog leaveDialog;
    private employeeDialog employDialog;
    private trainingDialog trainDialog;
    private leaveDialog leavDialog;
    private aboutDialog aboutD;
    private licenseDialog licenseD;
   // private tables mainTable;
    private TablePanel tablePanel;
    private employeeReportDialog employeeR;
    private generalReportDialog generalR;
    private deleteDialog deleteD;
    private EditDialog editD;
    
    public MainFrame() throws Exception {
     super("HR Database Application");
       setLayout(new BorderLayout());  
      toolbar = new ToolBar();
      employeeDialog =  new addEmployeeDialog(this);
      trainingDialog = new addTrainingDialog(this);
      leaveDialog = new addLeaveDialog(this);
      employDialog = new employeeDialog(this);
      trainDialog = new trainingDialog(this);
      leavDialog = new leaveDialog(this);
      aboutD = new aboutDialog(this);
      licenseD =  new licenseDialog(this);
      tablePanel = new TablePanel();
      employeeR = new employeeReportDialog(this);
      generalR = new generalReportDialog(this);
      deleteD = new deleteDialog(this);
      editD = new EditDialog(this);
     // mainTable = new tables();
      
    //   mainLayout layout = new mainLayout();
       
       add(toolbar,BorderLayout.NORTH);
   
       setJMenuBar(createMenuBar());
       add(tablePanel,BorderLayout.CENTER);
     //  add(mainTable.main_table(),BorderLayout.CENTER);
       
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      setVisible(true);
      setSize(1280, 600);
      
  toolbar.setToolbarListener(new ToolbarListener() {
         @Override
         public void ToolbarAction(boolean t) {
            employeeDialog.setVisible(t);
         }

         @Override
         public void addTraining(boolean addT) {
           trainingDialog.setVisible(addT);
           
         }

         @Override
         public void addLeave(boolean addL) {
           leaveDialog.setVisible(addL);
         }

         @Override
         public void employee(boolean listE) {
           employDialog.setVisible(listE);
         }

         @Override
         public void training(boolean listT) {
           trainDialog.setVisible(listT);
         }

         @Override
         public void leave(boolean listL) {
           leavDialog.setVisible(listL);
         }
          @Override
         public void refresh() {
             tablePanel.employeeTable();
         }

         @Override
         public void help(boolean help) {
           
         }       
     });
      
    }
    private JMenuBar createMenuBar(){
    JMenuBar menuBar = new JMenuBar();
    JMenu fileMenu = new JMenu(" File ");
    JMenu report = new JMenu(" Reports ");
    JMenu help = new JMenu(" Help ");
    JMenu view = new JMenu(" View "); 
    JMenu edit = new JMenu(" Edit ");
    JMenu delete = new JMenu(" Delete ");
    JMenu settings = new JMenu("Settings");
    
    menuBar.add(fileMenu);
    JMenuItem newEmployee = new JMenuItem(" Add Employee ");
    JMenuItem newTraining = new JMenuItem(" Add Training ");
    JMenuItem newLeave = new JMenuItem(" Add Leave ");
    
    JMenuItem Delete = new JMenuItem(" Delete ");
  /*  JMenuItem deleteEmployee = new JMenuItem(" Delete Employee ");
    JMenuItem deleteTraining = new JMenuItem(" Delete Trainging ");
    JMenuItem deleteLeave = new JMenuItem(" Delete Leave ");*/
    
    JMenuItem Edit = new JMenuItem(" Edit ");
   /* JMenuItem editEmployee = new JMenuItem(" Edit Employee Info ");
    JMenuItem editTraining = new JMenuItem(" Edit Training Info ");
    JMenuItem editLeave = new JMenuItem(" Edit Leave Info ");*/
    
    JMenuItem Exit = new JMenuItem(" Exit "); 
    
    fileMenu.add(newEmployee);
    fileMenu.add(newTraining);
    fileMenu.add(newLeave);
    fileMenu.addSeparator();
    
   /* edit.add(editEmployee);
    edit.add(editTraining);
    edit.add(editLeave);*/
    fileMenu.add(Edit);
     
   /* delete.add(deleteEmployee);
    delete.add(deleteTraining);
    delete.add(deleteLeave);*/
    fileMenu.add(Delete);
    
    
    fileMenu.addSeparator();
    fileMenu.add(Exit);   
    
    menuBar.add(report);
    JMenuItem employeeReport = new JMenuItem(" Employee Report ");
    JMenuItem generalReport = new JMenuItem(" General Report ");
   // JMenuItem trainingReport = new JMenuItem(" Trainging Report ");
   // JMenuItem leaveReport = new JMenuItem(" Leave Report ");
    report.add(employeeReport);
    report.add(generalReport);
  //  report.add(trainingReport);
  //  report.add(leaveReport); 
   
    menuBar.add(view);
    JMenuItem employee = new JMenuItem(" Employees ");
    JMenuItem training = new JMenuItem(" Trainings ");
    JMenuItem leave = new JMenuItem(" Leaves ");
    view.add(employee);
    view.add(training);
    view.add(leave);
    
    menuBar.add(settings);
    JMenuItem preference = new JMenuItem(" Preference ");
    settings.add(preference);
    
    menuBar.add(help);
    JMenuItem helpContent = new JMenuItem(" Help Content ");
    JMenuItem about = new JMenuItem(" About ");
    JMenuItem licence = new JMenuItem(" Product Lincence ");
    help.add(helpContent);
    help.add(licence);
    help.add(about);
    
    
    fileMenu.setMnemonic(KeyEvent.VK_F);
    report.setMnemonic(KeyEvent.VK_R);
    view.setMnemonic(KeyEvent.VK_V);
    help.setMnemonic(KeyEvent.VK_H);
    Exit.setMnemonic(KeyEvent.VK_X);
    
    Exit.addActionListener(new ActionListener () {
        @Override
        public void actionPerformed(ActionEvent e) {
            System.exit(0);
        }
    }); 
    
    newEmployee.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
        employeeDialog.setVisible(true);
        }
    });
    newTraining.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
       trainingDialog.setVisible(true);
        }
    });
    newLeave.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
        leaveDialog.setVisible(true);
        }
    });
    employee.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
       employDialog.setVisible(true);
        }
    });
    training.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
       trainDialog.setVisible(true);
        }
    });
    leave.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
       leavDialog.setVisible(true);
        }
    });
    licence.addActionListener(new ActionListener () {
        @Override
        public void actionPerformed(ActionEvent e) {
       licenseD.setVisible(true);
        }
    });
    about.addActionListener(new ActionListener () {
        @Override
        public void actionPerformed(ActionEvent e) {
       aboutD.setVisible(true);
        }
    });
    employeeReport.addActionListener(new ActionListener () {
        @Override
        public void actionPerformed(ActionEvent e) {
       employeeR.setVisible(true);
        }
    });
    generalReport.addActionListener(new ActionListener () {
        @Override
        public void actionPerformed(ActionEvent e) {
       generalR.setVisible(true);
        }
    });
    Edit.addActionListener(new ActionListener () {
        @Override
        public void actionPerformed(ActionEvent e) {
        editD.setVisible(true);
        }
    });
    Delete.addActionListener(new ActionListener () {
        @Override
        public void actionPerformed(ActionEvent e) {
        deleteD.setVisible(true);
        }
    });
    
    
    //fileItems content
    newEmployee.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_E, ActionEvent.CTRL_MASK));
    newTraining.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_T, ActionEvent.CTRL_MASK));
    newLeave.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_L, ActionEvent.CTRL_MASK));
    
    Edit.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_E, ActionEvent.CTRL_MASK | ActionEvent.SHIFT_MASK));
    
    Delete.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_D, ActionEvent.CTRL_MASK | ActionEvent.SHIFT_MASK));
   
    Exit.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X, ActionEvent.CTRL_MASK));
    
    //ReportItems contents
    employeeReport.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_E, ActionEvent.CTRL_MASK | ActionEvent.SHIFT_MASK));
    generalReport.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_G,ActionEvent.CTRL_MASK | ActionEvent.SHIFT_MASK));
   /* trainingReport.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_T, ActionEvent.CTRL_MASK | ActionEvent.SHIFT_MASK));
    leaveReport.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_L, ActionEvent.CTRL_MASK  | ActionEvent.SHIFT_MASK));*/
    
    //ViewItems content
    employee.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_E, ActionEvent.ALT_MASK));
    training.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_T, ActionEvent.ALT_MASK));
    leave.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_L, ActionEvent.ALT_MASK));
    
    return menuBar;
    }
    
}

