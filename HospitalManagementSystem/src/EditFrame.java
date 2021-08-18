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
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class EditFrame  extends JFrame
{
    private JLabel l,l1,l0,l2,l3,l4,l5;
    private JTextField t,t1,t2,t3,t4,t5;
    private JButton b1,b;
    public EditFrame()
    {
        setLayout(new BorderLayout());
        l=new JLabel("Enter Name To Edit Patient Info");
        l1=new JLabel("Name");
        t=new JTextField(10);
        b1=new JButton("OK");
        b1.addActionListener(new abc());
        JPanel p1=new JPanel();
        JPanel p2=new JPanel();
        p1.setLayout(new FlowLayout());
        p2.setLayout(new GridLayout(3,1));
        p1.add(l);
        p2.add(l1);
        p2.add(t);
        p2.add(b1);
        add(p1,BorderLayout.NORTH);
        add(p2,BorderLayout.CENTER);
    }
    public class abc implements ActionListener
    {
        public void actionPerformed(ActionEvent a)
        {
            if(a.getSource()==b1)
            {
                ArrayList<patient> pList = readAllData();   
  patient p;
         for(int i=0;i<pList.size();i++)
 {
    if (pList.get(i).getName().equals(t.getText()))
   
 {
   JFrame f=new JFrame();
   f.setLayout(new BorderLayout());
   JLabel l=new JLabel("Edit Info");
   JLabel l0=new JLabel("Name");
   JLabel l1=new JLabel("Age");
   JLabel l2=new JLabel("gender");
   JLabel l3=new JLabel("Cellnum");
   JLabel l4=new JLabel("Doc Consulted");
   JTextField t=new JTextField(10);
   JTextField t1=new JTextField(10);
   JTextField t2=new JTextField(10);
   JTextField t3=new JTextField(10);
   JTextField t5=new JTextField(10);
   b=new JButton("Update Record");
   b.addActionListener(new XYZ());
   JPanel p1=new JPanel(); p1.setLayout(new FlowLayout()); p1.add(l);
   JPanel p2=new JPanel(); p2.setLayout(new GridLayout(5,2));
   JPanel p3=new JPanel(); p3.setLayout(new FlowLayout());  p3.add(b);
   p2.add(l0); p2.add(t);  p2.add(l1);   p2.add(t1);
   p2.add(l2); p2.add(t2);  p2.add(l3);   p2.add(t3);
   p2.add(l4);  p2.add(t5);
   f.add(p1,BorderLayout.NORTH);
   f.add(p2,BorderLayout.CENTER);
    f.add(p3,BorderLayout.SOUTH);
   f.setSize(600,400);
   f.setLocationRelativeTo(null);
   f.setVisible(true);
   t.setText(pList.get(i).getName());
 }
 }
            }
        }
    }
    public class XYZ implements ActionListener
    {
        public void actionPerformed(ActionEvent a)
        {
            if(a.getSource()==b)
            {
               
                System.out.print("hggs");
  
              ArrayList<patient> pList = readAllData();  
  
        patient p;
  boolean flag =false;
 
 
         for(int i=0;i<pList.size();i++)
 
 {

    flag=true;
      
    pList.get(i).setName(t.getText());
       
    pList.get(i).setAge(t1.getText());
       
    pList.get(i).setCELLNUM(t3.getText());
     
    pList.get(i).setGender(t2.getText());
      
    pList.get(i).getconsultedDoc().setName(t5.getText());

     
   break;
    
  }
                
   
   ObjectOutputStream outputStream = null;

  try 
  {
   

   outputStream = new ObjectOutputStream(new FileOutputStream("PF.ser"));

   
for (int i = 0 ; i < pList.size() ; i++) 
  
 {
    outputStream.writeObject(pList.get(i));
   }

   JOptionPane.showMessageDialog(new JFrame(),"Record Updated Successfully");
   } 

   catch(IOException eee) 
   {
    System.out.println("IO Exception while opening file");
   } 
  
 finally 
   { 
    try 
    {
     if(outputStream != null) 
     
{
      outputStream.close();
 }
    } 
    catch (IOException ee) 
    {
     
System.out.println("IO Exception while closing file");
    } 
   }
            }
      
  }
    }
public ArrayList<patient>  readAllData ()

{
 ArrayList<patient> pList = new ArrayList<patient>(0);
 
ObjectInputStream inputStream = null;
 
 try
 {
  
inputStream = new ObjectInputStream(new FileInputStream("PF.ser"));
 
 boolean EOF = false;
  
  while(!EOF) 
  {
   try 
   {
  patient myObj = (patient) inputStream.readObject();
    
 pList.add(myObj);
   } 
   catch (ClassNotFoundException e) 
   {
   } 
   catch (EOFException end)
   {
   
 EOF = true;
   }
  }
 } 
 catch(FileNotFoundException e) 
 {
 } 
 catch (IOException e) 
 {
 } 
 finally
 {
  try 
  {
   if(inputStream != null)
      inputStream.close( );
  } 
  catch (IOException e) 
  {
   System.out.println("IO Exception while closing file");
  }
 }
 return pList;
}
     }

