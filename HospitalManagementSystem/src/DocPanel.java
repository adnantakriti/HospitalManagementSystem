import javax.swing.*;
import java.awt.*;
import java.awt.AWTEvent;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.io.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DocPanel extends JFrame {
  
    private JButton b,b1,b2,b3,b4,b5;
    private JLabel l;
    private JTextField t;
    public DocPanel()
    { 
        setLayout(new GridLayout(6,1));
        JPanel p1=new JPanel();
        p1.setLayout(new FlowLayout());
        JPanel p3=new JPanel();
        p3.setLayout(new FlowLayout());
        JPanel p2=new JPanel();
        p2.setLayout(new FlowLayout());
        JPanel p4=new JPanel();
        p4.setLayout(new FlowLayout());
        JPanel p5=new JPanel();
        p5.setLayout(new FlowLayout());
        JPanel p6=new JPanel();
        p6.setLayout(new FlowLayout());
        b1=new JButton("ADD A DOCTOR");
        b1.setPreferredSize(new Dimension(150,50));
        b1.addActionListener(new myDocListener1());
        b2=new JButton("SEARCH");
        b2.setPreferredSize(new Dimension(150,50));
        b2.addActionListener(new myDocListener2());
        b3=new JButton("Current Doctors");
        b3.setPreferredSize(new Dimension(150,50));
        b3.addActionListener(new myDocListener2());
        b4=new JButton("Back");
        b4.setPreferredSize(new Dimension(150,50));
        b4.addActionListener(new myDocListener1());
        b5=new JButton("Delete");
        b5.setPreferredSize(new Dimension(150,50));
        b5.addActionListener(new myDocListener2());
        l=new JLabel("DOCTORS INFORMATION");
        l.setFont(new Font("serif", Font.BOLD, 40));
        p1.add(l);
        p1.setBackground(Color.WHITE);
        p3.add(b1);
        p2.add(b2);
        p4.add(b3);
        p5.add(b5);
        p6.add(b4);
        add(p1);
        add(p2);
        add(p3);
        add(p4);
        add(p5);
        add(p6);
    } 
    public class myDocListener1 implements ActionListener
    {
        public void actionPerformed(ActionEvent ae)
        {
            if(ae.getSource()==b1)
            {
               DocFrame d=new DocFrame();
               
               d.setSize(1000,400);
               d.setLocationRelativeTo(null);
               d.setVisible(true);
            }
            else if(ae.getSource()==b4)
            {
               dispose();
            }
            else if(ae.getSource()==b)
            {   
               
                 ArrayList<doctor> doc = readDataToDelete();
                    try {
               ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("docFile.ser"));
                    for (int i = 0; i < doc.size(); i++) {
                           oos.writeObject(doc.get(i));
                        }
                    } catch (FileNotFoundException ex) {
                    } catch (IOException ex) {
                    }
                    //JOptionPane.showMessageDialog(new JFrame(), "Data Deleted");

                }
            }
    }

            public ArrayList<doctor> readDataToDelete() {
                
                ArrayList<doctor> doc = new ArrayList<>();
                doctor d;
                     
                try {
                    ObjectInputStream x = new ObjectInputStream(new FileInputStream("docFile.ser"));
                    while (true) {
                         d= (doctor) x.readObject();
                         for(int i=0; i<doc.size();i++)
                        {
                        if(d.getName().equals(t.getText())) {
                            
                            JOptionPane.showMessageDialog(new JFrame(), "Record deleted");
                        }
                        else 
                        {
                            doc.add(d);
                        }
                        }
                    
                    }
                } catch (EOFException ex) {
                    
                     
                } catch (FileNotFoundException ex) {
                } catch (IOException ex) {
                } catch (ClassNotFoundException ex) {
                }
                return doc;
            }
    public class myDocListener2 implements ActionListener
    {
        public void actionPerformed(ActionEvent z)
        {
            if(z.getSource()==b2)
            {
                 SearchPanel s=new SearchPanel();
                 s.setSize(400,200);
                 s.setLocationRelativeTo(null);
                 s.setVisible(true);
            }
            else if(z.getSource()==b3)
            { 
                doctor d;
                FileInputStream f=null;
                ObjectInputStream x=null;
                try 
                {
                    f=new FileInputStream("docFile.ser");
                     x = new ObjectInputStream(f);
                    while (true) 
                    {
                        d=(doctor)x.readObject();
                        JOptionPane.showMessageDialog(new JFrame(), "Name : " + d.getName() + "\n Phone : "
                         + d.getCellnum() + "\n Gender :" + d.getGender() + " \n AGE : " + d.getAge()
                        + "\n ID : " + d.getID() +"\nFee"+  d.getfee()+"\nSpecialization"+d.getSpecialization()+
                        "\n Adress: "+d.getAdress().getStNo()+""+d.getAdress().gethouseNo()+""+d.getAdress().getCity());
                    }
                } catch (FileNotFoundException exp) {
                } catch (IOException exp) {
                } catch (ClassNotFoundException exp) {
                    
                }
              }
            if(z.getSource()==b5)
            {
                JFrame p=new JFrame();
                l=new JLabel("Enter name to delete the records");
                t=new JTextField(8);
                b=new JButton("DELETE");
                JPanel f=new JPanel();
                f.setLayout(new GridLayout(3,1));
                p.setLayout(new FlowLayout());
                f.add(l);
                f.add(t);
                f.add(b);
                b.addActionListener(new myDocListener1());
                p.setSize(400,200);
                p.setLocationRelativeTo(null);
                p.setVisible(true);
                p.add(f,BorderLayout.CENTER);
            }
           
            }
   
        }
    
}

