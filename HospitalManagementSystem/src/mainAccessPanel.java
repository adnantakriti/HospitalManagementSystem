import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;

public class mainAccessPanel extends JFrame {
    private JButton b1,b2,b3;
    private JLabel l;
    public mainAccessPanel()
    {
        JPanel p1=new JPanel();
        p1.setLayout(new FlowLayout());
        JPanel p2=new JPanel();
        p2.setLayout(new FlowLayout());
        l=new JLabel("HOSPITAL MANAGMENT SYSTEM");
        l.setFont(new Font("serif", Font.BOLD, 40));
        b1=new JButton("Go to Staff");
        b1.addActionListener(new MyMainListener() );
        b2=new JButton("Go to Patients INformation");
        b2.addActionListener(new MyMainListener() );
        b3=new JButton("EXIT");
        b3.addActionListener(new MyMainListener() );
        p1.add(l);
        p2.add(b1);
        p2.add(b2);
        p2.add(b3);
        add(p1,BorderLayout.NORTH);
        add(p2,BorderLayout.CENTER);
       
    }
    public class MyMainListener implements ActionListener
    {
        public void actionPerformed(ActionEvent a)
        {
            if(a.getSource()==b1)
                    {
                try {
                    StaffFrame s=new StaffFrame();
                    s.setSize(1000, 500);
                    s.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
                    s.setVisible(true);
                    s.setLocationRelativeTo(null);
                } catch (IOException ex) {
                    Logger.getLogger(mainAccessPanel.class.getName()).log(Level.SEVERE, null, ex);
                }
                    }
            else if(a.getSource()==b2)
            {
                patientPanel p=new patientPanel();
                p.setSize(800, 400);
                p.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
                p.setLocationRelativeTo(null);
                p.setVisible(true);
            }
            else if(a.getSource()==b3)
            {
                System.exit(0);
            }
        }
        
    }
}

