
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

public class patientPanel extends JFrame {
    private JLabel l,l1,l2,l3,l4,l5,l6,l7,l8,l9,l10,l11,l12,l13;
    private JTextField t1,t2,t3,t4,t5,t6,t7,t8,t9,t10,t11;
    private static JTextField t12,t15,t13,t14;
    private JButton b1,b2,b3,b4,b7,b6,b5;
    public patientPanel()
    {
        setLayout(new BorderLayout());
        JPanel p1=new JPanel();
        p1.setLayout(new FlowLayout());
        JPanel p2=new JPanel();
        p2.setLayout(new GridLayout(8,2,4,4));
        JPanel p3=new JPanel();
        p3.setLayout(new FlowLayout());
        l=new JLabel("PATIENTS INFORMATION");
        l.setFont(new Font("serif", Font.BOLD, 40));
        l1=new JLabel("Name");
        l2=new JLabel("Age");
        l3=new JLabel("Gender");
        l4=new JLabel("Phone#");
        l5=new JLabel("ID");
        l6=new JLabel("Adress");
        l7=new JLabel("Date of Admission");
        l8=new JLabel("Total days in hospital");
        l9=new JLabel("Doctor Consulted");
        b7=new JButton("Medicines");
        b7.addActionListener(new myPatientListener2());
        b6=new JButton("Rooms");
        b6.addActionListener(new myPatientListener2());
        l10=new JLabel("Doc Fee:");
        l11=new JLabel("MED Charges");
        b4=new JButton("ComputeBill");
        b4.addActionListener(new myPatientListener1());
        b5=new JButton("Edit Patient");
        b5.addActionListener(new myPatientListener1());
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
        t11=new JTextField(10);  
        t12=new JTextField(10);
        t13=new JTextField(10);
        t14=new JTextField(10);
        t15=new JTextField(10);
        b1=new JButton("Save");
        b1.addActionListener(new myPatientListener1());
        b2=new JButton("Search");
         b2.addActionListener(new myPatientListener1());
        b3=new JButton("Back");
         b3.addActionListener(new myPatientListener1());
        p1.add(l);
        p2.add(l1);    p2.add(t1);
        p2.add(l2);    p2.add(t2);
        p2.add(l3);    p2.add(t3);
        p2.add(l4);    p2.add(t4);
        p2.add(l5);    p2.add(t5);
        p2.add(l6);    p2.add(t6); 
        p2.add(l7);    p2.add(t7);
        p2.add(l8);    p2.add(t8);
        p2.add(l9);    p2.add(t9); 
        p2.add(l10);   p2.add(t10);
        p2.add(b7);    p2.add(t13);
        p2.add(l11);   p2.add(t14);
        p2.add(b6);    p2.add(t15);
        p2.add(b4);   p2.add(t12);
        p3.add(b1);    p3.add(b2);   p3.add(b5);    p3.add(b3);   
        add(p1,BorderLayout.NORTH);
         add(p2,BorderLayout.CENTER);
        add(p3,BorderLayout.SOUTH);
       
    }

   
    
    public class myPatientListener1 implements ActionListener
    {
        public void actionPerformed(ActionEvent a)
        {
            if(a.getSource()==b4)
            {
                BillingPanel bp=new BillingPanel();
                bp.setSize(600,300);
                bp.setLocationRelativeTo(null);
                bp.setVisible(true);
            }
            if(a.getSource()==b3)
            {
                dispose();
            }
            if(a.getSource()==b2)
            {
                Search s=new Search();
                s.setSize(400,200);
                s.setLocationRelativeTo(null);
                s.setVisible(true);
            }
            if(a.getSource()==b5)
            {
               EditFrame ef=new EditFrame();
               ef.setSize(400,200);
               ef.setLocationRelativeTo(null);
               ef.setVisible(true);

            }
          if(a.getSource()==b1)
          {
             OutputStream out=null;
			String name,age,gender,phone,ID;
			name=t1.getText();
			age=t2.getText();
			gender=t3.getText();
			phone=t4.getText();
			ID=t5.getText();
			Adress ad=new Adress(t6.getText());
                        date d=new date(t7.getText());
                        doctor c=new doctor(t9.getText());
                        Medicine med=new Medicine(t13.getText());
                        Room r=new Room(t15.getText());
                        Bill b=new Bill(t12.getText());
			patient p= new patient(name,age,gender,phone,ID,ad,d,r,c,med,b);		
			ObjectOutputStream oo = null;
                   try
                 {
                     ArrayList<patient> pList=readAllData();
                     pList.add(p);
                     oo=new ObjectOutputStream(new FileOutputStream("PF.ser"));
                     for(int i = 0 ; i<pList.size() ; i++) 
                     {
	                  oo.writeObject(pList.get(i));

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
    public ArrayList<patient> readAllData ()
    {
 
       ArrayList<patient> pList = new ArrayList<patient>(0);
// Input stream
    ObjectInputStream inputStream = null;
try
{
// open file for reading
inputStream = new ObjectInputStream(new FileInputStream("PF.ser"));
// End Of File flag
boolean EOF = false;
// Keep reading file until file ends
while(!EOF) {
try {
// read object and type cast into CarDetails object
patient p=(patient) inputStream.readObject();

// add object into ArrayList

pList.add(p);


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

return pList;
}


    public class myPatientListener2 implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        { 
            if(e.getSource()==b7)
            { 
                MedFrame m=new MedFrame();
       m.setLocationRelativeTo(null);
       m.setSize(400,200);
       m.setVisible(true);
            }
            if(e.getSource()==b6)
            {
                RoomFrame r=new RoomFrame();
                r.setSize(500,250);
                r.setLocationRelativeTo(null);
                r.setVisible(true);
            }
        }
    }
    public static JTextField getF()
    {
        return t12;
    }
    public static JTextField gets()
    {
        return t15;
    }
      public static JTextField getr()
    {
        return t14;
    }
        public static JTextField gett()
    {
        return t13;
    }
    
}
   