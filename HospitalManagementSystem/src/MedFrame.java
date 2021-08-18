import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
public class MedFrame extends JFrame
{
   private JLabel l;
   private JList<String> list;
   private DefaultListModel<String> listmodel;
   private JScrollPane p;
     private Medicine[] med=new Medicine[50];
   private JButton b;
   public MedFrame()
   {
       setLayout(new BorderLayout());
       JPanel p1=new JPanel();
       p1.setLayout(new FlowLayout());
       JPanel p2=new JPanel();
       p2.setLayout(new FlowLayout());
       JPanel p3=new JPanel();
       p3.setLayout(new FlowLayout());
       l=new JLabel("Select the prescribed Medicine");
       med[0]=new Medicine("PANADOL",50);
       med[1]=new Medicine("Ativan",60);
       med[2]=new Medicine("Iboprofin",200);
       med[3]=new Medicine("Gllucophage",190);
       med[4]=new Medicine("Vebramycin",70);
       med[5]=new Medicine("Citalopram",360);
       med[6]=new Medicine("Gabapentin",260); 
       med[7]=new Medicine("Cymbalta",160);
       med[8]=new Medicine("Adderall",80);  
       med[9]=new Medicine("Naproxen",760);
       med[10]=new Medicine("Metformin",390);
       med[11]=new Medicine("Zoloft",570);
       med[12]=new Medicine("Lyrica",160);
       med[13]=new Medicine("Lexapro",790);
       med[14]=new Medicine("Codiene",360);
       med[15]=new Medicine("Amoxcillin",340);
       med[16]=new Medicine("Omeprazole",80);
       med[17]=new Medicine("Paracetamol",60); 
       med[18]=new Medicine("Amoxyll",1000);
       med[19]=new Medicine("Diane-35",670);
       med[20]=new Medicine("Tyrin",980);
       med[21]=new Medicine("Atorvastatin",900);
       med[22]=new Medicine("Clindamycin",570);
       med[23]=new Medicine("Vitsmin D",48);
       med[24]=new Medicine("pro Vitamin",90);
       med[25]=new Medicine("Cal-99",970);
       med[26]=new Medicine("Doxycyclin",96);
       med[27]=new Medicine("Oxycodone",14);
       med[28]=new Medicine("Meloxicam",77);
       med[29]=new Medicine("Xanan",580);
       med[30]=new Medicine("Tramadol",34);
       med[31]=new Medicine("Gabapentin",340);
       med[32]=new Medicine("Naproxin",150);
       med[33]=new Medicine("glucate-500",87);                  
       med[34]=new Medicine("Losartan",44);     
       med[35]=new Medicine("OKi",374);
       med[36]=new Medicine("Febrol",494);
       med[37]=new Medicine("HYdralin",608);
       med[38]=new Medicine("Strepsils",604);
       med[39]=new Medicine("Calpol",360);
       med[40]=new Medicine("Metoprolol",640);
       med[41]=new Medicine("lorazepam",640);
       med[42]=new Medicine("Ranexa",630);
       med[43]=new Medicine("Reglan",609);
       med[44]=new Medicine("Restoril",30);
       med[45]=new Medicine("Onfi",560);
       med[46]=new Medicine("Taxol",450);
       med[47]=new Medicine("Mobic",485);
       med[48]=new Medicine("Diovan",453);
       med[49]=new Medicine("Dulera",383);
      
       listmodel=new DefaultListModel<>();
       String x=null;
       for(int i=0; i<50 ; i++)
       {
            x=med[i].getmed();
            listmodel.addElement(x);
       }
       list=new JList<>(listmodel);
       
        list.setLayoutOrientation(JList.VERTICAL);
        list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        list.setSelectedIndex(0);
        list.setVisibleRowCount(10);
        p=new JScrollPane(list);
       b=new JButton("OK");
       b.addActionListener(new mylistener());
       p1.add(l);
       p2.add(p);
       p3.add(b);
       add(p1,BorderLayout.NORTH);
       add(p2,BorderLayout.CENTER);
       add(p3,BorderLayout.SOUTH); 
   }
   public class mylistener implements ActionListener
   {
       public void actionPerformed(ActionEvent e)
       { 
           if(e.getSource()==b)
           { 
               int y=0;
               String a=list.getSelectedValue();
                 patientPanel.gett().setText(a);
                 for(int i=0 ; i<50 ; i++)
                 {
                     if(med[i].getmed()==a)
                     {
                         y=med[i].getcharges();
                         
                     }
                     String z=Integer.toString(y);
                     patientPanel.getr().setText(z);
                     dispose();
                 }
               
           }
           
       }
   }
  
}
