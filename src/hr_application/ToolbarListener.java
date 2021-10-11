
package hr_application;

public interface ToolbarListener {
   public void ToolbarAction(boolean t); 
   public void addTraining(boolean addT);
   public void addLeave(boolean addL);
   public void employee(boolean listE);
   public void training(boolean listT);
   public void leave(boolean listL);
   public void help(boolean about);
   public void refresh();
}
