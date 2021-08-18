import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import javax.swing.JFrame;
import javax.swing.JLabel;

//login ID admin
//password 12345
public class Gui extends JFrame {

    private JPanel mainPanel, topPanel, panel;
    private JPasswordField pw;
    private JLabel  l,label1, label2, label3, label4, label5;
    private JTextField id;
    private JButton login;

  public Gui() {
        super("Hospital Managmment System");
        setLayout(new BorderLayout());
        l=new JLabel(new ImageIcon("C:\\Users\\BASIT\\Downloads\\images.jpg"));
        add(l,BorderLayout.WEST);
        //set topPanel for Welcome to Hospital Managment System and add it to NORTH of frame
        topPanel = new JPanel(new FlowLayout());
        topPanel.setBackground(Color.GRAY);
        label1 = new JLabel("Welcome to Hospital Managment System");
        label1.setFont(new Font("serif", Font.BOLD, 40));
        topPanel.add(label1);
        add(topPanel, BorderLayout.NORTH);
            
        //mainPanel has a panel that includes rest of the components
        //add mainPanel in the center 
        mainPanel = new JPanel();
        panel = new JPanel(new GridBagLayout());
        mainPanel.add(panel);
        add(mainPanel, BorderLayout.CENTER);

        //setting components of panel placed at the center
        GridBagConstraints c = new GridBagConstraints();
        c.gridx = 0;
        c.gridy = 0;
        c.insets = new Insets(14, 14, 14, 14);
        c.anchor = GridBagConstraints.CENTER;
      
        label2 = new JLabel("Enter LoginID and Password to sign in");
        label2.setFont(new Font("serif", Font.BOLD, 20));
        panel.add(label2, c);
        c.gridx = 0;
        c.gridy = 1;
        c.anchor = GridBagConstraints.LINE_END;

        label3 = new JLabel("Login ID:");
        label3.setFont(new Font("serif", Font.BOLD, 20));
        panel.add(label3, c);
        c.gridy++;

        label4 = new JLabel("Password:");
        label4.setFont(new Font("serif", Font.BOLD, 20));
        panel.add(label4, c);

        
        c.gridx = 1;
        c.gridy = 1;
        c.anchor = GridBagConstraints.LINE_START;

        id = new JTextField(14);
        panel.add(id, c);
        c.gridy++;

        pw = new JPasswordField(10);
        pw.setEchoChar('*');
        panel.add(pw, c);
        c.gridy++;

        login = new JButton("Login");
        panel.add(login, c);

        c.gridx = 1;
        c.gridy = 4;
        label5 = new JLabel("");
        label5.setFont(new Font("serif", Font.BOLD, 20));
        label5.setForeground(Color.red);
        panel.add(label5, c);

        AuthenticateUser p = new AuthenticateUser();
        login.addActionListener(p);

    }

    //A method that checks wether the password entered is correct or not
    private boolean checkPassword(char[] enteredpw) {
        boolean result = false;
        
        char[] pw = {'1', '2', '3', '4', '5'};

        if (pw.length != enteredpw.length) {
            result = false;
        } else {
            //the equals method of arrays using both array is used to compare two array and it returns a boolean
            //if the arrays matches
            result = Arrays.equals(enteredpw, pw);
        }
        Arrays.fill(pw, '0');
        return result;
    }

    public class AuthenticateUser implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            String adminID = id.getText();
            char[] password = pw.getPassword();
            if (adminID.equals("admin")) {
                if (checkPassword(password)) {
                    mainAccessPanel  m= new mainAccessPanel();
                    m.setSize(800, 400);
                    m.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
                    m.setVisible(true);
                    m.setLocationRelativeTo(null);
                } else {
                    label5.setText("Error! Please enter the correct password ");
                }
            } else {
                label5.setText("Error! Please enter the correct id");
            }
               
           
        }

    }

}
