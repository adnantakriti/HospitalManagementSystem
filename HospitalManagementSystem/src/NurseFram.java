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

public class NurseFram extends JFrame
{
    private JLabel l,l1,l2,l3,l4,l5,l6;
    private JTextField t1,t2,t3,t4,t5,t6,t7,t8;
    private JButton b1,b2,b3;
    public NurseFram()
    {
    setLayout(new BorderLayout());
        JPanel p1=new JPanel();
        p1.setLayout(new FlowLayout());
        JPanel p2=new JPanel();
        p2.setLayout(new GridLayout(3,2));
        JPanel p3=new JPanel();
        p3.setLayout(new FlowLayout());
        JPanel p=new JPanel();
        p.setLayout(new FlowLayout());
        l=new JLabel("ADD A NEW NURSE");
        l.setFont(new Font("serif", Font.BOLD, 40));      
        l1=new JLabel("Name");
        l2=new JLabel("Age");
        l3=new JLabel("Gender");
        l4=new JLabel("Phone#");
        l5=new JLabel("ID");
        l6=new JLabel("Adress");
        t1=new JTextField(10);
        t2=new JTextField(10);
        t3=new JTextField(10);
        t4=new JTextField(10);
        t5=new JTextField(10);
        t6=new JTextField(10);
        t7=new JTextField(10);
        t8=new JTextField(10);
        b1=new JButton("SAVE");
        b1.addActionListener(new Listener());
        b2=new JButton("CLEAR");
        b2.addActionListener(new Listener());
        b3=new JButton("BACK");
        b3.addActionListener(new Listener());
        p1.add(l);
        p2.add(l1);   p2.add(t1);
        p2.add(l2);   p2.add(t2);
        p2.add(l3);   p2.add(t3);
        p2.add(l4);   p2.add(t4);
        p2.add(l5);   p2.add(t5);
        p.add(l6);    p.add(t6);   p.add(t7);  p.add(t8);
        p3.add(b1);   p3.add(b2);   p3.add(b3);
        p2.add(p);
        add(p1,BorderLayout.NORTH);
        add(p2,BorderLayout.CENTER);
        add(p3,BorderLayout.SOUTH);
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
                    }
                    else if(a.getSource()==b3)
                    {
                       dispose();
                    }
                    else if(a.getSource()==b1)
                    {
                       OutputStream out=null;
                 String Name,age,gender,CellNum,ID;
                 Adress x=new Adress(t6.getText(),t7.getText(),t8.getText());
                 Name=t1.getText();
                 age=t2.getText();
                 gender=t3.getText();
                 CellNum=t4.getText();
                 ID=t5.getText();
                 Nurse n=new Nurse(Name,age,gender,CellNum,ID,x);
                 ObjectOutputStream oo=null;
                 try
                 {
                     ArrayList<Nurse> NurseList=readAllData();
                     NurseList.add(n);
                     oo=new ObjectOutputStream(new FileOutputStream("NursesFile.ser"));
                     for(int i = 0 ; i<NurseList.size() ; i++) 
                     {
	                oo.writeObject(NurseList.get(i));
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
        
        
    public ArrayList<Nurse> readAllData ()
    {
 
       ArrayList<Nurse> NurseList = new ArrayList<Nurse>(0);
// Input stream
    ObjectInputStream inputStream = null;
try
{
// open file for reading
inputStream = new ObjectInputStream(new FileInputStream("NursesFile.ser"));
// End Of File flag
boolean EOF = false;
// Keep reading file until file ends
while(!EOF) {
try {
// read object and type cast into CarDetails object
Nurse n = (Nurse) inputStream.readObject();

// add object into ArrayList

NurseList.add(n);


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
} catch (IOException e) 
{

System.out.println("IO Exception while closing file");
}
}

return NurseList;
}
}
}
