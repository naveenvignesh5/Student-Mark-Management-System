/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package jdbc;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author Naveen Vignesh
 */
public class student_login_frame  {
   static Connection con = null;
   static PreparedStatement st = null;
   static ResultSet rs = null;
   static public long rollno,temp;
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        JPanel panel = new JPanel();
        panel.setBackground(Color.yellow);
        JTextField dd = new JTextField(2);
        JTextField mm = new JTextField(2);
        JTextField yyyy = new JTextField(3);
        JTextField roll_entry = new JTextField(12);
        JLabel error = new JLabel(); 
        JLabel tit = new JLabel("Student Login - Marks DBMS");
        tit.setFont(new Font(Font.MONOSPACED,Font.BOLD,14));
        JLabel dob = new JLabel("Date of Birth :");
        dob.setFont(new Font(Font.SANS_SERIF,Font.ITALIC,12));
        JLabel roll = new JLabel("Roll No :");
        roll.setFont(new Font(Font.SANS_SERIF,Font.ITALIC,12));
        JButton submit = new JButton("Login");
        JButton back = new JButton("Back");
        //setting color and fonts for buttons
        submit.setFont(new Font(Font.SERIF,Font.BOLD,13));
        back.setFont(new Font(Font.SERIF,Font.BOLD,13));
        submit.setBackground(Color.orange);
        back.setBackground(Color.orange);
        dd.setText("DD");
        mm.setText("MM");
        yyyy.setText("YYYY");
        //connecting to mysql
          
        Database db = new Database();
        con = db.getCon();
        if(con == null) error.setText("Unable to connect to database");
        //adding components to the panel
        panel.add(tit);
        panel.add(roll);
        panel.add(roll_entry);
        panel.add(dob);
        panel.add(dd);
        panel.add(new JLabel("/"));
        panel.add(mm);
        panel.add(new JLabel("/"));
        panel.add(yyyy);
        panel.add(submit);
        panel.add(back);
        panel.add(error);
        
        JFrame fr = new JFrame();
        fr.add(panel);
        fr.setSize(250,170);
        fr.setVisible(true);
        fr.setLocationRelativeTo(null);
        fr.setDefaultCloseOperation(0);
        //defining command for the button  
      
        submit.addActionListener(new ActionListener() 
        {
            public void actionPerformed(ActionEvent evt) {
                try {
                    rollno = Long.parseLong(roll_entry.getText());
                    String DD = dd.getText();
                    String MM = mm.getText();
                    String YY = yyyy.getText();
                    String date = YY+"-"+MM+"-"+DD;
                    st = (PreparedStatement) con.prepareStatement("select * from student where roll = ?");
                    st.setLong(1, rollno);
                    rs = st.executeQuery();
                    while(rs.next())
                    {
                        temp = rs.getLong("roll");
                        if(date.equals(rs.getString("dob")))
                        {
                            studentdetails.main(args);
                            fr.dispose();
                        }
                    }
                    rs.beforeFirst();
                }catch(SQLException a)
                {
                    error.setText("Wrong Username / Password...");
                }
                try
                {
                    Thread.sleep(1000);
                    error.setText("");
                }
                catch(InterruptedException a)
                {
                    Thread.currentThread().interrupt();
                }
            }
        });
        back.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                Login.main(args);
                fr.dispose();
            }
        });
        
    }
    public long returnroll()
    {
      return temp;
    }
}
