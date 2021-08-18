import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
public class SearchFrame extends JFrame {
    private JLabel l,l1;
    private JTextField f1;
    private JButton b;
    public SearchFrame()
    {
        setLayout(new BorderLayout());
        JPanel p1=new JPanel();
        p1.setLayout(new FlowLayout());
        JPanel p2=new JPanel();
        p2.setLayout(new FlowLayout());
        JPanel p3=new JPanel();
        p3.setLayout(new FlowLayout());
        l=new JLabel("Search A Nurse");
        l1=new JLabel("Enter A Name");
        f1=new JTextField(8);
        b=new JButton("OK");
        b.addActionListener(new Listener());
        p1.add(l);
        p2.add(l1);    p2.add(f1);
        p3.add(b);
        add(p1,BorderLayout.NORTH);
        add(p2,BorderLayout.CENTER);
        add(p3,BorderLayout.SOUTH);
    }
    public class Listener implements ActionListener
    {
        public void actionPerformed(ActionEvent a)
        {
            if(a.getSource()==b)
            {
                 
            Nurse n;
                try
                {
                    ObjectInputStream x = new ObjectInputStream(new FileInputStream("NursesFile.ser"));
                    while (true)
                    {
                        n = (Nurse) x.readObject();
                        if (n.getName().equals(f1.getText())) 
                        {
                            JOptionPane.showMessageDialog(new JFrame(), "Name : " + n.getName() + "\n Phone :"
                             + n.getCellnum() + "\n Gender :" + n.getGender() + "\n AGE : " + n.getAge()
                             + "\n ID :" + n.getID());
                            break;
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

