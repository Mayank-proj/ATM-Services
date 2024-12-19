
package bankmanagementsystem;
import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Date;
import java.sql.*;

public class BalanceEnquiry extends JFrame implements ActionListener{
    
    JButton back;
    String pinnumber;
     BalanceEnquiry(String pinnumber){ 
         setLayout(null);
         this.pinnumber= pinnumber;
          getContentPane().setBackground(Color.WHITE);
    	ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
       Image i2=i1.getImage().getScaledInstance(900,900,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        image.setBounds(0,0,900,900);
        add(image);
        
        back =new JButton("BACK");
        back.setBounds(355,520,150,30);
        back.addActionListener(this);
        image.add(back);
        
          Conn c=new Conn();
           int balance=0;
            try{
                ResultSet rs= c.s.executeQuery("Select * from bank where pin_Number='"+pinnumber+"'");
               
                while(rs.next()){
                    if(rs.getString("type").equals("Deposit")){
                        balance+=Integer.parseInt(rs.getString("amount"));
                    } else{
                        
                        balance-=Integer.parseInt(rs.getString("amount"));
                    }
                }
            }catch(Exception ae){
                System.out.println(ae);
            }
            
            JLabel li=new JLabel("Your Current Account Balance is Rs.. "+balance);
            li.setForeground(Color.WHITE);
            li.setBounds(170,300,400,30);
            image.add(li);
            
         setSize(900,900);
        setLocation(300,0);
        setUndecorated(true);
        setVisible(true);
         
         
         
     }
     public void actionPerformed(ActionEvent e){
        
         setVisible(false);
         new Transactions(pinnumber).setVisible(true);
         
     }
    public static void main(String args[]){
        new BalanceEnquiry("");
    }
    
}
