

package chatting.application;
import javax.swing.*;  // swing comes from java extended package
import java.awt.*; 
import javax.swing.border.*; //  used for EmptyBorder
import java.awt.event.*; // it is used for implementing the interface ActionListener
import java.util.*;
import java.text.*;
import java.net.*;   // used for socket class
import java.io.*;  // package used for sending and reciving the meassage i.e DataInputStream

// here ActionListener interface implemented that is used for performing  certain action on the icons 
//public class Server extends JFrame implements ActionListener   // we are making frame so Jframe is extended which class comes from swing package  

public class Server implements ActionListener
{
    JTextField text ; 
  JPanel a1;  
  static Box vertical = Box.createVerticalBox(); // create a static vertical box to print the message in vertical manner one after another
  static JFrame f = new JFrame(); // making the object JFRame class  
  static DataOutputStream dout; // globally declaring the output  stream static object
  Server() // constructor
    {
        f.setLayout(null); // it means that i am telling the wing that i will make my own layout and i will not use yours
        
        JPanel p1 = new JPanel(); // JPanel is used to divide the frame
        p1.setBackground(new Color (7,94,84)); // setting the background color with the help of Color class
        p1.setBounds(0,0,450,70); // setting the divided folder in this size bound
        p1.setLayout(null); // setting the panel layout null
        f.add(p1); // Whatever done over here  is added to p1
        
        // Arrow icon
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/3.png"));  // setting the image on the frame(p1)
        //calling the Image class in which we get the the image of i1  and scaling(shapping) it . 
        Image i2 = i1.getImage().getScaledInstance(25, 25, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2); //storing all the value of i2 in the the image i3
        JLabel back = new JLabel(i3); // creating object back of JLabel
        back.setBounds(5,20,25,25);  
        p1.add(back);  // adding the image on the frame (p1)
        
        back.addMouseListener(new MouseAdapter()  // we are usingusing mouse to perform some action or to click on it so we override the mouse listener
                 {
             public void mouseClicked(MouseEvent ae)    // mouseClicked event function is used here on the icon(ARROR) to exit the project
             {
                System.exit(0); 
             }
         });
        
        // Profile picture(icon)
             ImageIcon i4 = new ImageIcon(ClassLoader.getSystemResource("icons/1.png"));  // setting the image on the frame(p1)
        //calling the Image class in which we get the the image of i1  and scaling(shapping) it . 
        Image i5 = i4.getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT);
        ImageIcon i6 = new ImageIcon(i5); //storing all the value of i2 in the the image i3
        JLabel profile = new JLabel(i6); // creating object back of JLabel
        profile.setBounds(40,10,50,50);  
        p1.add(profile);  // adding the image on the frame (p1)
        
        //Video icon
         ImageIcon i7 = new ImageIcon(ClassLoader.getSystemResource("icons/video.png"));  // setting the image on the frame(p1)
        //calling the Image class in which we get the the image of i1  and scaling(shapping) it . 
        Image i8 = i7.getImage().getScaledInstance(30, 30, Image.SCALE_DEFAULT);
        ImageIcon i9 = new ImageIcon(i8); //storing all the value of i2 in the the image i3
        JLabel video = new JLabel(i9); // creating object back of JLabel
        video.setBounds(300,20,30,30);  
        p1.add(video);  // adding the image on the frame (p1)
        
         //Phone (icon)
         ImageIcon i10 = new ImageIcon(ClassLoader.getSystemResource("icons/phone.png"));  // setting the image on the frame(p1)
        //calling the Image class in which we get the the image of i1  and scaling(shapping) it . 
        Image i11 = i10.getImage().getScaledInstance(35, 30, Image.SCALE_DEFAULT);
        ImageIcon i12 = new ImageIcon(i11); //storing all the value of i2 in the the image i3
        JLabel phone = new JLabel(i12); // creating object back of JLabel
        phone.setBounds(360,20,35,30);  
        p1.add(phone);  // adding the image on the frame (p1)
        
         // Morevert option (icon) that three dots in the corner
         ImageIcon i13 = new ImageIcon(ClassLoader.getSystemResource("icons/3icon.png"));  // setting the image on the frame(p1)
        //calling the Image class in which we get the the image of i1  and scaling(shapping) it . 
        Image i14 = i13.getImage().getScaledInstance(10, 25, Image.SCALE_DEFAULT);
        ImageIcon i15 = new ImageIcon(i14); //storing all the value of i2 in the the image i3
        JLabel morevert = new JLabel(i15); // creating object back of JLabel
        morevert.setBounds(420,20,10,25);  
        p1.add(morevert);  // adding the image on the frame (p1)
        
        // Wriring name
        //JLabel is used to write anything on the frame 
        JLabel name = new JLabel ("Gaitonde");
        name.setBounds(110,15,100,10); // setting the place of the name in the frame p1
        name.setForeground(Color.WHITE); // setting the text color
        name.setFont(new Font("SAN_SERIF",Font.BOLD , 18));  // setting the fonttype and its size
        p1.add(name);
        
        // Wriring status(Active now)
        //JLabel is used to write anything on the frame 
        JLabel status = new JLabel ("Active Now");
        status.setBounds(110,35,100,18); // setting the place of the name in the frame p1
        status.setForeground(Color.WHITE); // setting the text color
        status.setFont(new Font("SAN_SERIF",Font.BOLD , 14));  // setting the fonttype and its size
        p1.add(status);
        
        // now setting the text area  as making the box little small
        a1 = new JPanel();
        a1.setBounds(5,75,440,570);
        f.add(a1);
        
        // setting the Textfiled (Writing the message to send)
        text = new JTextField();
        text.setBounds(5,655,310,40);
        text.setFont(new Font("SAN_SERIF",Font.PLAIN , 16));  // setting the fonttype and its size
        f.add(text);
        
        // Adding send Button at the right lower corner side
        JButton send = new JButton("Send");
        send.setBounds(320,655,123,40);
        send.setBackground(new Color(7,94,84));
        send.setForeground(Color.WHITE);
        send.addActionListener(this);  // to add click and make responsive to the send button to send the messages
        send.setFont(new Font("SAN_SERIF",Font.PLAIN , 16));  // setting the fonttype and its size
        f.add(send);
        
        
        f.setSize(450,700);  // It is inside JFrame class and it is used to set the size of frame
        f.setLocation(200,50);     // used to shift the frame from left side i.e X-axis() and from uppes side i.e Y-axis()
        f.setUndecorated(true); 
        f.getContentPane().setBackground(Color.WHITE); // getContentPane() is used to take the full frame,setBackground is used to set the background color,(Color.WHITE) color class extended by import java.awt.*;
       f.setVisible(true); // it is used to see the frame visibility
        
    }
    
    public void actionPerformed (ActionEvent ae) //  overidden from the the interface as it have abstract class in it. 
    {
        try{  // try catch is must used in socket programming 
        String out = text.getText(); // getText()it is used to take out the text written on the text fields
        
        JPanel p2 = formatLabel(out);
      
        a1.setLayout(new BorderLayout());  // borderLayout() is used to place the element at top,bottom , left,right and center
        
        // Aligning the message at the right side
        JPanel right = new JPanel(new BorderLayout());
        right.add(p2,BorderLayout.LINE_END); /*  with the help of border layout i am sending the message at the line_end*/
        
        // for multiple message it will be align at the right side one by one
        vertical.add(right);
        vertical.add(Box.createVerticalStrut(15));  // it is used to get the message at the right side  in vertical manner ine by one with diffrence of 15 height.
        
        a1.add(vertical,BorderLayout.PAGE_START); // adding the messages on the frame so starting it from the start of the page
        
        dout.writeUTF(out);
        //making the textfield box  empty after sending the message
        text.setText("");
        
        f.repaint();
        f.invalidate();
        f.validate();
    } catch(Exception e){
        e.printStackTrace();
    }
    }
    public static JPanel formatLabel(String out)
    {
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel,BoxLayout.Y_AXIS));
        
        JLabel output = new JLabel("<html><p style=\"width: 150px\">"+ out +"</p></html>"); //sending the message with particular message with box size same
        output.setFont(new Font("Tahoma",Font.PLAIN,16)); // setting the font size
        output.setBackground(new Color (37,211,107)); // setting the background color of the text
        output.setOpaque(true);  // it is used to see the background color
        output.setBorder(new EmptyBorder(15,15,15,50)); // it comes from "import javax.swing.Border.*" and(Padding) which will show the text inside a border
        panel.add(output);
        
        // setting the time at which the mesaage is sent 
        Calendar cal = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
        
        //JLabel is used to write anything on the frame
        JLabel time  = new JLabel();
        time.setText(sdf.format(cal.getTime()));
        panel.add(time);
        return panel;
    }
   public static void main(String[] args)
   {
       new Server();  // Anonymous object
       
       try{
           ServerSocket skt = new ServerSocket (6001); // creating a server socket class object  with port no - 6001
           while(true)  // while infinite loop so that it accept the messages infinite times
           {
               Socket s =skt.accept();  // accpeting the messages and storing it into the the socket s
               DataInputStream din = new DataInputStream(s.getInputStream());  // DataInputStream is used to recieve the messages
                dout = new DataOutputStream(s.getOutputStream());  // DataOutputStream is used to send the messages
           
               while(true) // this loop is used for infinitly sending and receiving the messages  
               {
               String msg = din.readUTF();  // readUTF() is used to read the messages of string type so storing it in string type.
               JPanel panel  = formatLabel(msg); // JPanel is used here to write the messages on the frame 
               
               JPanel left = new JPanel(new BorderLayout()); // This is used to get the received messages on the left side
               left.add(panel,BorderLayout.LINE_START); // the receiving messages will be on the lest side means starting line
               vertical.add(left);
               f.validate();
               }
           }
           
       }
       catch(Exception e)
       {
           e.printStackTrace();
       }
   }
}
