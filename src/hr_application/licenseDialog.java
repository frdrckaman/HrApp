package hr_application;

import javax.swing.JDialog;
import javax.swing.JFrame;

public class licenseDialog extends JDialog{
    public licenseDialog(JFrame parent){
     super(parent, " License ", true);
     setSize(880,300);
     setLocationRelativeTo(parent);
    }
}
