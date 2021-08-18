
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
import java.util.ArrayList;

public class AppointmentFrame extends JFrame 
{
      private JLabel l1,l2,l3,l4,l5,l6,l7,l8;
      private JTextField t1,t2,t3,t4,t5,t6,t7,t8,t9,t10,t11;
      private JButton b1,b2,b3;
      public AppointmentFrame()
      {
          setLayout(new BorderLayout());
          JPanel p1=new JPanel();
          p1.setLayout(new FlowLayout());
          JPanel p2=new JPanel();
          p2.setLayout(new FlowLayout());
          JPanel p4=new JPanel();
          p4.setLayout(new GridLayout(4,2));
          JPanel p5=new JPanel();
          p5.setLayout(new FlowLayout());
          l1=new JLabel("APPOINTMENTS ENTRY");
          l1.setFont(new Font("Serif",Font.BOLD,40));
          l2=new JLabel("AP#");
          l3=new JLabel("Date");
          l4=new JLabel("Time");
          l5=new JLabel("Doctor Name");
          l6=new JLabel("Doctor contact");
          l7=new JLabel("Patient Name");
          l8=new JLabel("Patient's Contact");
          t1=new JTextField(2);
          t2=new JTextField(2);
          t3=new JTextField(3);
          t4=new JTextField(2);
          t5=new JTextField(2);
          t6=new JTextField(2);
          t7=new JTextField(2);
           t8=new JTextField(11);
          t9=new JTextField(11);
          t10=new JTextField(11);
          t11=new JTextField(11);
          b1=new JButton("ok");
          b1.addActionListener(new Listener());
          b2=new JButton("clear");
          b2.addActionListener(new Listener());
          b3=new JButton("DONE");
          b3.addActionListener(new Listener());
          p1.add(l1);
          p2.add(l2); p2.add(t1);   
          p2.add(l3);  p2.add(t2);   p2.add(t3);   p2.add(t4);
          p2.add(l4);  p2.add(t5);   p2.add(t6);    p2.add(t7);
          p4.setPreferredSize(new Dimension(200,10));
          t8.setPreferredSize(new Dimension(150,20));
          t9.setPreferredSize(new Dimension(150,20));
          t10.setPreferredSize(new Dimension(150,20));
          t11.setPreferredSize(new Dimension(150,20));
          p4.add(l5);   p4.add(t8); p4.add(l6);   p4.add(t9);
          p4.add(l7);   p4.add(t10);  p4.add(l8); p4.add(t11);
          p5.add(b1);   p5.add(b2);   p5.add(b3);
          add(p1,BorderLayout.NORTH);
          add(p2,BorderLayout.WEST);
          add(p4,BorderLayout.CENTER); 
          add(p5,BorderLayout.SOUTH);
      }
      public class Listener implements ActionListener
      {
          public void actionPerformed(ActionEvent a)
          {
            if(a.getSource()==b2)
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
                t11.setText("");
            }
            else if(a.getSource()==b3)
            {
              dispose();
                
            }
            else if(a.getSource()==b1)
            {
                 OutputStream out=null;
                 String appointmentNum;
                 appointmentNum=t1.getText();
                 patient p=new patient(t10.getText(),t11.getText());
                 doctor  d=new doctor(t8.getText(),t9.getText());
                 Time t=new Time(t5.getText(),t6.getText(),t7.getText());
                 date z=new date(t2.getText(),t3.getText(),t4.getText());
                 Appointment x=new Appointment(p,d,appointmentNum,t,z);
                 ObjectOutputStream oo=null;
                 try
                 {
                     ArrayList<Appointment> app=readAllData();
                     app.add(x);
                     oo=new ObjectOutputStream(new FileOutputStream("apointmentFile.ser"));
                     for(int i = 0 ; i<app.size() ; i++) 
                     {
	            oo.writeObject(app.get(i));

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
    public ArrayList<Appointment> readAllData ()
    {
 
       ArrayList<Appointment> app = new ArrayList<Appointment>(0);
// Input stream
    ObjectInputStream inputStream = null;
try
{
// open file for reading
inputStream = new ObjectInputStream(new FileInputStream("appointmentFile.ser"));
// End Of File flag
boolean EOF = false;
// Keep reading file until file ends
while(!EOF) {
try {
// read object and type cast into CarDetails object
Appointment x= (Appointment) inputStream.readObject();

// add object into ArrayList

app.add(x);


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

return app;
}
}

