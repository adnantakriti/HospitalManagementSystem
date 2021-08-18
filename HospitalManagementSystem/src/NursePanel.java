
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;
public class NursePanel extends JFrame 
{
    private JLabel l;
    private JButton b1,b2,b3,b4;
    public NursePanel()
    {
        setLayout(new BorderLayout());
        JPanel p1=new JPanel();
        p1.setLayout(new FlowLayout());
        JPanel p3=new JPanel();
        p3.setLayout(new FlowLayout());
        l=new JLabel("NURSES INFORMATION");
        l.setFont(new Font("serif", Font.BOLD, 40));
        b1=new JButton("Add A Nurse");
        b1.addActionListener(new NurseListener());
        b2=new JButton("Search A Nurse");
        b2.addActionListener(new NurseListener());
        b3=new JButton("Available Nurses");
        b3.addActionListener(new NurseListener());
        b4=new JButton("Back");
        b4.addActionListener(new NurseListener());
        p1.add(l);
        p3.add(b1);   p3.add(b2);   p3.add(b3);   p3.add(b4);
        add(p1,BorderLayout.NORTH);
        add(p3,BorderLayout.SOUTH);
    }
    public class NurseListener implements ActionListener
    {
        public void actionPerformed(ActionEvent ae)
        {
            if(ae.getSource()==b4)
            {
                dispose();
            }
            if(ae.getSource()==b1)
            {
                NurseFram nf=new NurseFram();
                nf.setSize(800,400);
                nf.setLocationRelativeTo(null);
                nf.setVisible(true);
            }
            if(ae.getSource()==b2)
            {
                SearchFrame sf=new SearchFrame();
                sf.setSize(400,200);
                sf.setLocationRelativeTo(null);
                sf.setVisible(true);
            }
            if(ae.getSource()==b3)
            {
                      
               Nurse n;
                FileInputStream f=null;
                ObjectInputStream x=null;
                try 
                {
                    f=new FileInputStream("NursesFile.ser");
                     x = new ObjectInputStream(f);
                    while (true) 
                    {
                        n=(Nurse)x.readObject();
                        JOptionPane.showMessageDialog(new JFrame(), "Name : " + n.getName() + "\n Phone "
                             + n.getCellnum() + "\n Gender :" + n.getGender() + "\n AGE : " + n.getAge()
            + "\n ID " + n.getID()+"\n Adress:"+n.getAdress().getStNo()+n.getAdress().gethouseNo()+n.getAdress().getCity());
                    }
                } catch (FileNotFoundException exp) {
                } catch (IOException exp) {
                } catch (ClassNotFoundException exp) {
                    
                }
            }
        }
    }
}


