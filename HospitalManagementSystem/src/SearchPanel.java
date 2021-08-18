import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
public class SearchPanel extends JFrame 
{
    private JLabel l1;
    private JTextField t1;
    private JButton b1;
    public SearchPanel()
    {
        setLayout(new BorderLayout());
        JPanel p1=new JPanel();
        p1.setLayout(new FlowLayout());
        JPanel p2=new JPanel();
        p2.setLayout(new FlowLayout());
        l1=new JLabel("ENTER NAME");
        t1=new JTextField(10);
        b1=new JButton("OK");
        b1.addActionListener(new listener());
        p1.add(l1);
        p1.add(t1);
        p2.add(b1);
        add(p1,BorderLayout.CENTER);
        add(p2,BorderLayout.SOUTH);
    }
    public class listener implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            
           if(e.getSource()==(b1))
           {
    
                doctor d;
                try
                {
                    ObjectInputStream x = new ObjectInputStream(new FileInputStream("docFile.ser"));
                    while (true)
                    {
                        d = (doctor) x.readObject();
                        if (d.getName().equals(t1.getText())) 
                        {
                         JOptionPane.showMessageDialog(new JFrame(), "Name : " + d.getName() + "\n Phone :"
                         + d.getCellnum() + "\n Gender :" + d.getGender() + "\n AGE : " + d.getAge()
                         + "\n ID :" + d.getID() +"\n Fee :"+  d.getfee()+"\n Specialization :"+d.getSpecialization());
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
  
