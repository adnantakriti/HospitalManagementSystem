import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.Serializable;
import java.util.ArrayList;
public class DocFrame extends JFrame{
      private JLabel l,l1,l2,l3,l4,l5,l6,l7,l8;
    private JTextField t1,t2,t3,t4,t5,t6,t7,t8,t9,t10;
    private JButton b,b1,b2,b3;
    public DocFrame()
    {
        setLayout(new BorderLayout());
        JPanel p2=new JPanel();
        p2.setLayout(new GridLayout(5,2,4,4));
        JPanel p=new JPanel();
        p.setLayout(new FlowLayout());
        JPanel p1=new JPanel();
        p1.setLayout(new FlowLayout());
        JPanel p3=new JPanel();
        p3.setLayout(new FlowLayout());
        l=new  JLabel("DOCTORS INFORMATION");
        l1=new JLabel("Name");
        l2=new JLabel("Age");
        l3=new JLabel("Gender");
        l4=new JLabel("Phone#");
        l5=new JLabel("ID");
        l6=new JLabel("Adress");
        l7=new JLabel("Specialization");
        l8=new JLabel("Fee");
        b=new JButton("Appointments");
        b.addActionListener(new myListener());
        t1=new JTextField(10);
        t2=new JTextField(10);
        t3=new JTextField(10);
        t4=new JTextField(10);
        t5=new JTextField(10);
        t6=new JTextField(10);
        t7=new JTextField(10);
        t8=new JTextField(10);
        t9=new JTextField(10);
        t10=new JTextField(10);
        b1=new JButton("SAVE");
        b1.addActionListener(new DOC());
        b2=new JButton("BACK");
        b2.addActionListener(new DOC());
        b3=new JButton("Clear");
        b3.addActionListener(new DOC());
        p2.add(l1);
        p2.add(t1);
        p2.add(l2);
        p2.add(t2);
        p2.add(l3);
        p2.add(t3);
        p2.add(l4);
        p2.add(t4);
        p2.add(l5);
        p2.add(t5);
        p2.add(l7);
        p2.add(t9);
        p2.add(l8);
        p2.add(t10);
        p3.add(l6);
        p3.add(t6);
        p3.add(t7);
        p3.add(t8);
        p1.add(b);
        p2.add(p3);
        p2.add(p1);
        p.add(b1);
        p.add(b2);
        p.add(b3);
        add(p2,BorderLayout.CENTER);
        add(p,BorderLayout.SOUTH);
        
    }
    public class DOC implements ActionListener
    {
        public void actionPerformed(ActionEvent a)
        {
            if(a.getSource()==b2)
            {
                
               dispose();
            }
            else if(a.getSource()==b3)
            {
                t1.setText("");
                t2.setText("");
                t3.setText("");
                t4.setText("");
                t5.setText("");
                t6.setText("");
                t7.setText("");
                t8.setText("");
                t9.setText("");
                t10.setText("");
            }
            else if(a.getSource()==b1)
            {
                OutputStream out=null;
                 String Name,age,gender,CellNum,ID,Specialization,Fee;
                 Adress x=new Adress(t6.getText(),t7.getText(),t8.getText());
                 Name=t1.getText();
                 age=t2.getText();
                 gender=t3.getText();
                 CellNum=t4.getText();
                 ID=t5.getText();
                 Specialization=t9.getText();
                 Fee=t10.getText();
                 doctor d=new doctor(Name,age,gender,CellNum,ID,x,Specialization,Fee);
                 ObjectOutputStream oo=null;
                 try
                 {
                     ArrayList<doctor> doc=readAllData();
                     doc.add(d);
                     oo=new ObjectOutputStream(new FileOutputStream("docFile.ser"));
                     for(int i = 0 ; i<doc.size() ; i++) 
                     {
	                  oo.writeObject(doc.get(i));

                     }
                     JOptionPane.showMessageDialog (null,"record saved", "Information", JOptionPane.INFORMATION_MESSAGE);
                 }
                 catch(IOException exp)
                    {
                     System.out.println("IO Exception while opening file");
                    } 
                 finally
                {
                     try 
                {
	           if(oo!= null)
                   {
                	oo.close();
                    }

                } 
          catch (IOException exp)
         {
	System.out.println("IO Exception while closing file");
         }
                }
                }
            }
        
        }
    public ArrayList<doctor> readAllData ()
    {
 
       ArrayList<doctor> doc = new ArrayList<doctor>(0);
// Input stream
    ObjectInputStream inputStream = null;
try
{
// open file for reading
inputStream = new ObjectInputStream(new FileInputStream("docFile.ser"));
// End Of File flag
boolean EOF = false;
// Keep reading file until file ends
while(!EOF) {
try {
// read object and type cast into CarDetails object
doctor d = (doctor) inputStream.readObject();

// add object into ArrayList

doc.add(d);


}
 catch (ClassNotFoundException e) {
//System.out.println("Class not found");
}
 catch (EOFException end) {
// EOFException is raised when file ends
// set End Of File flag to true so that loop exits
EOF = true;
}
}
}
 catch(FileNotFoundException e) {

}
 catch (IOException e) {

}
 finally { 
try {
if(inputStream != null)
inputStream.close( );
} catch (IOException e) {

System.out.println("IO Exception while closing file");
}
}

return doc;
}
    public class myListener implements ActionListener
    {
        public void actionPerformed(ActionEvent a)
        {
            if(a.getSource()==b)
            {
                AppointmentFrame f=new AppointmentFrame();
                f.setSize(600,300);
                f.setLocationRelativeTo(null);
                f.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
                f.setVisible(true);
            }
        }
    }   
}
