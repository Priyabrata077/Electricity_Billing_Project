package electricity.billing.system;
 
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class Login extends JFrame implements ActionListener {
     JButton login, cancel, signup;
     JTextField username, password;
     Choice logginin;
    Login() {
        super ("Login Page");
        getContentPane().setBackground(Color.WHITE);
        setLayout (null);
        
        JLabel lblusername = new JLabel("Username");
        lblusername.setBounds(350, 40, 100, 20);
        add (lblusername);
        
        username = new JTextField();
        username.setBounds(450, 40, 150, 20);
        add(username);
        
        JLabel lblpassword = new JLabel("Password");
        lblpassword.setBounds(350, 80, 100, 20);
        add (lblpassword);
        
        password = new JTextField();
        password.setBounds(450, 80, 150, 20);
        add(password);
        
        
        JLabel loggininas = new JLabel("Loggin in as");
        loggininas.setBounds(350, 120, 100, 20);
        add (loggininas);
        
        logginin = new Choice();
        logginin.add("Admin");
        logginin.add("Customer");
        logginin. setBounds(450, 120, 150, 20);
        add (logginin);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("Icon/login.png"));
        Image i2 = i1.getImage() .getScaledInstance(16, 16, Image.SCALE_DEFAULT);
        login = new JButton("Login" , new ImageIcon(i2));
        login.setBounds(350, 180, 100, 20);
        login.addActionListener(this);
        add(login);
        
        ImageIcon i3 = new ImageIcon(ClassLoader.getSystemResource("Icon/cancel.jpg"));
        Image i4 = i3.getImage() .getScaledInstance(16, 16, Image.SCALE_DEFAULT);
        cancel = new JButton("Cancle", new ImageIcon(i4));
        cancel.setBounds(480, 180, 100, 20);
        cancel.addActionListener(this);
        add(cancel);
        
        ImageIcon i5 = new ImageIcon(ClassLoader.getSystemResource("Icon/signup.png"));
        Image i6 = i5.getImage() .getScaledInstance(16, 16, Image.SCALE_DEFAULT);
        signup = new JButton("Signup", new ImageIcon(i6));
        signup.setBounds(420, 220, 100, 20);
        signup.addActionListener(this);
        add(signup);
                
        ImageIcon i7 = new ImageIcon(ClassLoader.getSystemResource("Icon/second.jpg"));
        Image i8 = i7.getImage() .getScaledInstance(250, 250, Image.SCALE_DEFAULT);
        ImageIcon i9 = new ImageIcon(i8);
        JLabel image = new JLabel(i9);
        image.setBounds(0, 0, 250, 250);
        add(image);
        
                
        
        setSize (660, 400);
        setLocation(400,200);
        setVisible(true);
        
    }
 public void actionPerformed(ActionEvent ae) {
     if(ae.getSource() ==  login){
         String susername = username.getText();
         String spassword = password.getText();
         String user = logginin.getSelectedItem();
         
         try{
             Conn c = new Conn();
              String query = "select * from login where username = '"+susername+"' and password = '"+spassword+"' and user = '"+user+"'";
              
              ResultSet rs = c.s.executeQuery(query);
              
              if (rs.next()) {
                  setVisible(false);
                  new Project();
              } else {
                  JOptionPane.showMessageDialog(null, "Invalid Login");
                  username.setText("");
                  password.setText("");
                  
                  
              }
              
         } catch (Exception e) {
             e.printStackTrace();
         }
         
     }else if (ae.getSource() == cancel) {
        setVisible(false); 
     }else if (ae.getSource() == signup) {
         setVisible(false);
         
         new Signup();
     }
 }   
    public static void main(String[] args) {
        new Login();
    }
            
    
}