import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RoomFrame extends JFrame
{
    private JLabel l,l1,l2,l3,l4,l5,l6,l7,l8,l9,l11,l10,l12;
    private JTextField t1,t2,t3,t4,t5;
    private JButton b,b1,b2,b3;
    public RoomFrame()
    {
        JPanel p1=new JPanel();
        p1.setLayout(new FlowLayout());
        JPanel p2=new JPanel();
        p2.setLayout(new FlowLayout());
        b1=new JButton("VIEW AVAILABLE ROOM");
        b1.addActionListener(new Listener());
        b2=new JButton("ADD A ROOM");
        b2.addActionListener(new Listener());
        b3=new JButton("BACK");
        b3.addActionListener(new Listener());
        l1=new JLabel("ROOMS INFORMATION");
        l1.setFont(new Font("Serif",Font.BOLD,40));
        p1.add(l1);
        p2.add(b1);   p2.add(b2);   p2.add(b3);
        add(p1,BorderLayout.NORTH);
        add(p2,BorderLayout.CENTER);
    }
    public class Listener implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            if(e.getSource()==b1)
            {    
                JFrame f=new JFrame();
                JPanel panel=new JPanel();
                panel.setLayout(new FlowLayout());
                JPanel p=new JPanel();
                p.setLayout(new GridLayout(6,2));
                l=new JLabel("ROOMS AVAILABLE");
                l1=new JLabel("TOTAL ROOMS");
                l2=new JLabel("25");
                l3=new JLabel("VIP ROOMS");
                l4=new JLabel("5 (Charges=5000/day)");
                l5=new JLabel("REGULAR ROOMS");
                l6=new JLabel("15(Charges=2000/day)");
                l7=new JLabel("OPERATION THEATRE's");
                l8=new JLabel("2(Charges=3000/day)");
                l9=new JLabel("OPD");
                l10=new JLabel("1(Charges=2500/day)");
                l11=new JLabel("EMERGENCY WARDS");
                l12=new JLabel("2(Charges=1500/day)");
                panel.add(l);
                p.add(l1);   p.add(l2);
                p.add(l3);   p.add(l4);
                p.add(l5);   p.add(l6);
                p.add(l7);   p.add(l8);
                p.add(l9);   p.add(l10);
                p.add(l11);  p.add(l12);
                f.add(panel,BorderLayout.NORTH);
                f.add(p,BorderLayout.CENTER);
                f.setSize(400,200);
                f.setVisible(true);
                f.setLocationRelativeTo(null);
            }
             if(e.getSource()==b3)
            {
               dispose();
            }
             if(e.getSource()==b2)
            {
                JFrame f=new JFrame();
                f.setLayout(new BorderLayout());
                l=new JLabel("MY ROOM");
                l1=new JLabel("ROOM#");
                l2=new JLabel("ROOM TYPE");
                l3=new JLabel("Charges");
               
                b1=new JButton("Done");
                b1.addActionListener(new myListener());
                t1=new JTextField(5);
                t2=new JTextField(5);
                  t3=new JTextField(5);
               
                JPanel p=new JPanel();
                p.setLayout(new FlowLayout());
                JPanel p1=new JPanel();
                p1.setLayout(new GridLayout(3,2));
                JPanel p2=new JPanel();
                p2.setLayout(new FlowLayout());
                p.add(l);
                p1.add(l1);   p1.add(t1);
                p1.add(l2);   p1.add(t2);
                p1.add(l3);   p1.add(t3);
                p2.add(b1);
                f.add(p,BorderLayout.NORTH);
                f.add(p1,BorderLayout.CENTER);
                f.add(p2,BorderLayout.SOUTH);
                f.setSize(400,200);
                f.setLocationRelativeTo(null);
                f.setVisible(true);
            }
        }
    }
    public class myListener implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            if(e.getSource()==b1)
            {
                JOptionPane.showMessageDialog(null, "Done");
                 if(t2.getText().equals("vip"))
                {
                    int x=5500;
                    String z=Integer.toString(x);
                    patientPanel.gets().setText(z);
                }
                 if(t2.getText().equals("Regular"))
                {
                    int y=2000;
                  
                    patientPanel.gets().setText(Integer.toString(y));
                }
                
            }
        }
    }
    
}

