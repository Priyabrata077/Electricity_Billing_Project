package electricity.billing.system;
import javax.swing.*;
import java.awt.*;

public class Splash extends JFrame implements Runnable  {
    Thread t;
    Splash(){
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("Icon/elect.jpg"));
        JLabel image = new JLabel(i1);
        add(image);
         setVisible(true);
    for(int i = 2; i < 500; i++){
        setSize(i, i);
        setLocation(500, 150);
        try{
            Thread.sleep(2);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
      t =new Thread(this);
      t.start();
     setVisible(true);   
    }
    public void run(){
        try{ 
            Thread.sleep(7000);
            setVisible(false);
            
            //login page
            new Login();
        }catch (Exception e){
        e.printStackTrace();
        }
        
    }
    
    
    public static void main(String[] args) {
        new Splash();
    }
    
}
