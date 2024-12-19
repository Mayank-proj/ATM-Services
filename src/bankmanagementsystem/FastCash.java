
package bankmanagementsystem;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Date;
import java.sql.*;

public class FastCash extends JFrame implements ActionListener{
    
    
    JButton deposit,fastcash,balanceEnquiry,exit,withdrawl,pinchange,statement;
    String pinnumber;
    FastCash(String pinnumber){
            this.pinnumber= pinnumber;
        setTitle("AUTOMATED TELLER MACHINE");
        
         setLayout(null);
         
          getContentPane().setBackground(Color.WHITE);
    	ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
       Image i2=i1.getImage().getScaledInstance(900,900,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        image.setBounds(0,0,900,900);
        add(image);
        
        
        
        JLabel text=new JLabel("Please select your Transaction");
        text.setBounds(210,300,700,35);
        text.setForeground(Color.white);
        text.setFont(new Font("System",Font.BOLD,16));
      image.add(text);
        
        
         deposit=new JButton("Rs.100");
        deposit.setBounds(170,415,150,30);
        deposit.addActionListener(this);
        image.add(deposit);
        
         withdrawl=new JButton("Rs.200");
        withdrawl.setBounds(350,415,150,30);
        withdrawl.addActionListener(this);
        image.add(withdrawl);
        
        
         fastcash=new JButton("Rs.500");
        fastcash.setBounds(170,450,150,30);
        fastcash.addActionListener(this);
        image.add(fastcash);
        
         statement=new JButton("Rs.1000");
        statement.setBounds(350,450,150,30);
        statement.addActionListener(this);
        image.add(statement);
        
        
         pinchange=new JButton("Rs.5000");
        pinchange.setBounds(170,490,150,30);
        pinchange.addActionListener(this);
        image.add(pinchange);
        
        
         balanceEnquiry=new JButton("Rs.10000");
        balanceEnquiry.setBounds(350,490,150,30);
        balanceEnquiry.addActionListener(this);
        image.add(balanceEnquiry);
        
          
         exit=new JButton("Back");
        exit.setBounds(350,525,150,25);
        exit.addActionListener(this);
        image.add(exit);  
        
        
        
        
       setSize(900,900);
        setLocation(300,0);
        setUndecorated(true);
        setVisible(true);
             
        
    }
    
    public void actionPerformed(ActionEvent e){
        if(e.getSource()==exit){
            setVisible(false);
            new Transactions(pinnumber).setVisible(true);
        }else{
            String amount=((JButton)e.getSource()).getText().substring(3);
            Conn c=new Conn();
            try{
                ResultSet rs= c.s.executeQuery("Select * from bank where pin_Number='"+pinnumber+"'");
                int balance=0;
                while(rs.next()){
                    if(rs.getString("type").equals("Deposit")){
                        balance+=Integer.parseInt(rs.getString("amount"));
                    } else{
                        
                        balance-=Integer.parseInt(rs.getString("amount"));
                    }
                }
                if(e.getSource()!=exit && balance < Integer.parseInt(amount) ){
                 JOptionPane.showMessageDialog(null,"Insufficient Balance");
                 return;
                }
                Date date=new Date();
                String query="insert into bank values('"+pinnumber+"','"+date+"','Withdrawl','"+amount+"')";
                c.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null,"Rs "+amount+"Debit Succesfuuly");
                
                setVisible(false);
                new Transactions(pinnumber).setVisible(true);
            }catch (Exception ae){
                System.out.println(ae);
            }
        }
    }
    public static void main(String args[]){
       new FastCash(""); 
    }
}
  