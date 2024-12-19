
package bankmanagementsystem;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;
public class Login extends JFrame implements ActionListener{
    JButton signin,clear,signup;
    JTextField cardTextField;
    JPasswordField pinTextField;
    Login(){
       
    	setTitle("AUTOMATED TELLER MACHINE");
         setLayout(null);
          getContentPane().setBackground(Color.WHITE);
    	ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/logo.jpg"));
        Image i2=i1.getImage().getScaledInstance(100,100,Image.SCALE_DEFAULT);
    	ImageIcon i3=new ImageIcon(i2);
        JLabel label= new JLabel(i3);
        label.setBounds(70,10,100,100);
        add(label);
        
        
        JLabel text=new JLabel("WELCOME TO THE ATM");
        text.setBounds(200,40,600,40);
        text.setFont(new Font("Osward",Font.BOLD,38));
         add(text);
         
         JLabel CardNo=new JLabel("CardNo:");
        CardNo.setBounds(120,150,600,40);
        CardNo.setFont(new Font("Railway",Font.BOLD,28));
         add(CardNo);
         
          cardTextField=new JTextField();
          cardTextField.setFont(new Font("Arial",Font.BOLD,14));
         cardTextField.setBounds(300, 160,300, 40);
         add(cardTextField);
         
           JLabel Pin=new JLabel("Pin:");
        Pin.setBounds(150,220,600,40);
        Pin.setFont(new Font("Railway",Font.BOLD,28));
         add(Pin);
         
          pinTextField=new  JPasswordField();
          pinTextField.setFont(new Font("Arial",Font.BOLD,14));
         pinTextField.setBounds(300, 220,300, 40);
         add(pinTextField);
        
          signin= new JButton("LOGIN");
         signin.setBounds(300,300,100,30);
         signin.setBackground(Color.black);
         signin.setForeground(Color.white);
         signin.addActionListener(this);
         add(signin);
         
           clear= new JButton("CLEAR");
         clear.setBounds(450,300,100,30);
         clear.setBackground(Color.black);
         clear.setForeground(Color.white);
         clear.addActionListener(this);
         add(clear);
        
         signup= new JButton("SIGN UP");
         signup.setBounds(300,340,250,30);
         signup.setBackground(Color.black);
         signup.setForeground(Color.white);
         signup.addActionListener(this);
         add(signup);
        
         
    	setSize(800,500);
    	setVisible(true);
       
    	setLocation(350,200);
    }
    public void actionPerformed (ActionEvent ae){
        
        if(ae.getSource()==clear){
            cardTextField.setText("");
            pinTextField.setText("");
        }else if(ae.getSource()==signin){
            Conn conn=new Conn();
            String cardNumber=cardTextField.getText();
            String pinnumber=pinTextField.getText();
            
            String query="select * from login where card_Number= '"+cardNumber+"' and pin_Number='"+pinnumber+"'";
            try{
                ResultSet rs =conn.s.executeQuery(query);
                if(rs.next()){
                    setVisible(false);
                    new Transactions(pinnumber).setVisible(true);
                }else{
                 JOptionPane.showMessageDialog(null,"Incorrect card Number Or Pin Number");
                }
            }catch (Exception e){
                System.out.println(e);
            }
            

          
             
        }else if(ae.getSource()==signup){
            setVisible(false);
            new SignUpOne().setVisible(true);
        }
    }
	public static void main(String[] args) {
		
      new Login();
	}

}

