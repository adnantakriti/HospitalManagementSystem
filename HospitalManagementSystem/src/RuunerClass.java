
import javax.swing.JFrame;
public class RuunerClass 
{
    public static void main(String[]args)
    {
        Gui frame= new Gui();  
        frame.setTitle("HOSPITAL MANAGEMENT SYSTEM");
        frame.setSize(800,400);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
    
}