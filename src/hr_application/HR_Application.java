
package hr_application;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;
public class HR_Application {

    public static void main(String[] args) {
         SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                try {
                    new MainFrame();
                } catch (Exception ex) {
                    Logger.getLogger(HR_Application.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }
    
}
