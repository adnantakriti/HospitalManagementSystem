import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
public class Search extends JFrame{
    private JLabel l1,l2;
    private JTextField t1;
    private JButton b1;
    public Search()
    {
        setLayout(new BorderLayout());
        l1=new JLabel("SEARCH A PATIENT");
        l2=new JLabel("Enter Name");
        t1=new JTextField(8);
        b1=new JButton("OK");
        b1.addActionListener(new XYZ());
        JPanel p1=new JPanel();
        p1.setLayout(new FlowLayout());
        JPanel p2=new JPanel();
        p2.setLayout(new GridLayout(3,1));
        p1.add(l1);
        p2.add(l2);   p2.add(t1);   p2.add(b1);
        add(p1,BorderLayout.NORTH);
        add(p2,BorderLayout.CENTER);
    }
    public class XYZ implements ActionListener
    {
        public void actionPerformed(ActionEvent ae)
        {
            if(ae.getSource()==b1)
            {
                   patient p;
                try
                {
                    ObjectInputStream x = new ObjectInputStream(new FileInputStream("PF.ser"));
                    while (true)
                    {
                        p= (patient) x.readObject();
                        if (p.getName().equals(t1.getText())) 
                        {
                         JOptionPane.showMessageDialog(new JFrame(), "Name : " + p.getName() + "\n Phone :"
                         + p.getCellnum() + "\n Gender :" + p.getGender() + "\n AGE : " + p.getAge()
                         + "\n ID :" + p.getID() +"\n Doctor consulted  "+p.getconsultedDoc().getName());
                         
                        }
                    }
                } 
                catch (FileNotFoundException exp) 
                {
                }
                catch (IOException exp)
                {
                } 
                catch (ClassNotFoundException exp)
                {
                }
            }
        }
    }
    
}

