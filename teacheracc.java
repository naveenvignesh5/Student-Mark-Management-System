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
import javax.swing.JPasswordField;
import javax.swing.JTextField;

/**
 *
 * @author Naveen Vignesh
 */
public class teacheracc {
    static Connection con = null;
    static PreparedStatement st = null;
    static ResultSet rs = null;
    static String username,tpass,cpass,npass;
    public static void main(String[] args) {
        JPanel p = new JPanel();
        JLabel l0 = new JLabel("Account creater/password changer");
        JLabel l1 = new JLabel("   Username   ");
        JLabel l2 = new JLabel(" Old password ");
        JLabel l3 = new JLabel(" New password ");
        JLabel l4 = new JLabel("Confirm password");
        JLabel error = new JLabel();
        JTextField t1 = new JTextField(8);
        JPasswordField p1 = new JPasswordField(8);
        JPasswordField p2 = new JPasswordField(8);
        JPasswordField p3 = new JPasswordField(8);
        JButton b1 = new JButton("Change password");
        JButton b2 = new JButton("Create account");
        JButton b3 = new JButton("Back");
        //adding fonts and color to components
        p.setBackground(Color.yellow);
        b1.setBackground(Color.orange);
        b2.setBackground(Color.orange);
        b3.setBackground(Color.orange);
        l0.setFont(new Font(Font.MONOSPACED,Font.BOLD,14));
        l1.setFont(new Font(Font.SANS_SERIF,Font.ITALIC,12));
        l2.setFont(new Font(Font.SANS_SERIF,Font.ITALIC,12));
        l3.setFont(new Font(Font.SANS_SERIF,Font.ITALIC,12));
        l4.setFont(new Font(Font.SANS_SERIF,Font.ITALIC,12));
        error.setFont(new Font(Font.SERIF,Font.BOLD,11));
        //adding componenets to the panel
        p.add(l0);
        p.add(l1);
        p.add(t1);
        p.add(l2);
        p.add(p1);
        p.add(l3);
        p.add(p2);
        p.add(l4);
        p.add(p3);
        p.add(b1);
        p.add(b2);
        p.add(b3);
        p.add(error);
        JFrame fr = new JFrame();
        fr.add(p);
        fr.setSize(220,250);
        fr.setVisible(true);
        fr.setDefaultCloseOperation(0);
        fr.setResizable(false);
        fr.setLocationRelativeTo(null);
        
        //establishing connection to database
        Database db = new Database();
        con = db.getCon();
        if(con == null) error.setText("Unable to connect to database");
        b1.addActionListener(new ActionListener() 
        {
          public void actionPerformed(ActionEvent evt)
          {
           username = t1.getText();
           cpass = p1.getText();
           npass = p2.getText();
           tpass = p3.getText();
           try
           {
            st = con.prepareStatement("select pass from teachers where user = ?");
            st.setString(1,username);
            rs = st.executeQuery();
            while(rs.next())
            {
              if(cpass.equals(rs.getString("pass")))
              {
                if(npass.equals(tpass))
                {
                 try {
                  st = con.prepareStatement("insert into teachers (`pass`) values (?) where user = ?");
                  st.setString(1,username);
                  st.setString(2,npass);
                 }
                 catch(SQLException a)
                 {
                    error.setText("Unable to change password");
                 }
                }
                else
                {
                  error.setText("Passwords don't match");
                }
              }
            }
            rs.beforeFirst();
           }
           catch(SQLException a)
           {
             error.setText("Wrong username/password");
           }
          }
        });
        b2.addActionListener(new ActionListener()
        {
          public void actionPerformed(ActionEvent evt)
          {
           username = t1.getText();
           npass = p2.getText();
           tpass = p3.getText(); 
           try
           {
             if(npass.equals(tpass))
             {
               st = con.prepareStatement("insert into teachers values (?,?)");
               st.setString(1,username);
               st.setString(2,npass);
               st.execute();
               error.setText("Account created");
             }
           }
           catch(SQLException a)
           {
             error.setText("Unable to create new account");
           }
          }
        });
        b3.addActionListener(new ActionListener()
        {
          public void actionPerformed(ActionEvent evt)
          {
            teacherframe.main(args);
            fr.dispose();
          }
        });
    }
}
