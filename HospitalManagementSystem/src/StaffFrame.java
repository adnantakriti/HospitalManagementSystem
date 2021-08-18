import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import javax.imageio.ImageIO;
public class StaffFrame extends JFrame {
    private JButton b1,b2,b3;
    private JLabel l;
    public StaffFrame() throws IOException
    {
        setLayout(new BorderLayout());
        JPanel p1=new JPanel();
        p1.setLayout(new FlowLayout());
        JPanel p2=new JPanel();
        p2.setLayout(new FlowLayout());
        l=new JLabel("STAFF INFORMATION");
        l.setFont(new Font("serif", Font.BOLD, 40));
        b1=new JButton("GO TO DOCTORS INFORMATION");
        b1.addActionListener(new myStaffListener());
        b2=new JButton("GO TO NURSES INFORMATION");
        b2.addActionListener(new myStaffListener());
        b3=new JButton("Back");
        b3.addActionListener(new myStaffListener());
        ImageIcon image=new ImageIcon("C:\\Users\\BASIT\\Downloads\\doctors-and-nurses.jpg");
        JLabel il=new JLabel();
        il.setIcon(image);
        p1.add(l);
        p2.add(b1);
        p2.add(b2);
        p2.add(b3);
        p2.add(il);
        add(p1,BorderLayout.NORTH);
        add(p2,BorderLayout.CENTER);
    }
    public class myStaffListener implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            if(e.getSource()==b1)
            {
                DocPanel d=new DocPanel();
                d.setSize(800,400);
                d.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
                d.setVisible(true);
                d.setLocationRelativeTo(null);
            }
            else if(e.getSource()==b2)
            {
                NursePanel n=new NursePanel();
                n.setSize(800,400);
                n.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
                n.setLocationRelativeTo(null);
                n.setVisible(true);
            }
            else if(e.getSource()==b3)
            {
                   dispose();            }
            
        }
    }
    
}
