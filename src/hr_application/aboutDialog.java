package hr_application;

import javax.swing.JDialog;
import javax.swing.JFrame;

public class aboutDialog extends JDialog{
    public aboutDialog(JFrame parent){
     super(parent, " About ", true);
     setSize(880,300);
     setLocationRelativeTo(parent);
    }
}
