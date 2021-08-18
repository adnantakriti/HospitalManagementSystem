import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class BillingPanel extends JFrame
{
    private JLabel l,l1,l2,l3,l4,l5;
    private JTextField t1,t2,t3,t4,t5;
    private JButton b1,b2;
    private static int h;
    public BillingPanel()
    {
             setLayout(new BorderLayout());
             JPanel p=new JPanel();
              p.setLayout(new GridLayout(5,2));
              JPanel p1=new JPanel();
              p1.setLayout(new FlowLayout());
              JPanel p2=new JPanel();
              p2.setLayout(new FlowLayout());
              l=new JLabel("Enter the Following details");
              l1=new JLabel("Total Days Spent In Hospital=");
              t1=new JTextField(5);
              l2=new JLabel("Enter doctor's Fee=");
              t2=new JTextField(5);
              l3=new JLabel("Enter Medicine Charges");
              t3=new JTextField(5);
              l4=new JLabel("Enter Room Charges");
              t4=new JTextField(5);
              l5=new JLabel("Service Charges per Day=200");
              b1=new JButton("Back");
              b1.addActionListener(new abc());
              b2=new JButton("Ok");
              b2.addActionListener(new abc());
              p1.add(l);
              p.add(l1);   p.add(t1);
              p.add(l2);   p.add(t2);
              p.add(l3);   p.add(t3);
              p.add(l4);   p.add(t4);
              p.add(l5);   
              p2.add(b1);  p.add(b2);
              add(p1,BorderLayout.NORTH);
              add(p,BorderLayout.CENTER);
              add(p2,BorderLayout.SOUTH);
}
    public class abc implements ActionListener
    {
        public void actionPerformed(ActionEvent a)
        {
            if(a.getSource()==b2)
                    {
                        int x=Integer.parseInt(t1.getText());
                        int y=Integer.parseInt(t2.getText());
                        int z=Integer.parseInt(t3.getText());
                        int b=Integer.parseInt(t4.getText());
                        int g=x*b+(200*x);
                         h=g+y+z;
                        JOptionPane.showMessageDialog(null, "Your total bill is \n"+h+"\npay your bill and Sign discharge paper"+"\n THANKYOU!!!");
                         String k=Integer.toString(BillingPanel.geth());
                         patientPanel.getF().setText(k);
                    }
             if(a.getSource()==b1)
             {
                 dispose();
             }
            
        }
    }
    public static int geth()
    {
        return h;
    }
}

