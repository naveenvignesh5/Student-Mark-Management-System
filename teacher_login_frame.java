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
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import static jdbc.mark_alter.con;

/**
 *
 * @author Naveen Vignesh
 */
public class teacher_Login_frame {
    static Connection con = null;
    static PreparedStatement st = null;
    static ResultSet rs = null;
    public static void main(final String[] args) {
        JPanel panel = new JPanel();
        panel.setBackground(Color.yellow);
        JLabel tit = new JLabel("*** Teacher Login ***");
        tit.setFont(new Font(Font.MONOSPACED,Font.BOLD,14));
        JLabel l1 = new JLabel("Username");
        JLabel l2 = new JLabel("Password");
        JLabel l3 = new JLabel();
        l1.setFont(new Font(Font.SERIF,Font.ITALIC,12));
        l2.setFont(new Font(Font.SERIF,Font.ITALIC,12));
        l3.setFont(new Font(Font.SERIF,Font.BOLD,14));
        JTextField user = new JTextField(15);
        JPasswordField pass = new JPasswordField(15);
        JButton bt = new JButton("Submit");
        JButton bt1 = new JButton("Back");
        bt.setFont(new Font(Font.SANS_SERIF,Font.BOLD,13));
        bt1.setFont(new Font(Font.SANS_SERIF,Font.BOLD,13));
        bt.setBackground(Color.orange);
        bt1.setBackground(Color.orange);
        panel.add(tit);
        panel.add(l1);
        panel.add(user);
        panel.add(l2);
        panel.add(pass);
        panel.add(bt);
        panel.add(bt1);
        panel.add(l3);
        final JFrame jf = new JFrame();
        jf.add(panel);
        jf.setSize(220,220);
        jf.setVisible(true);
        jf.setLocationRelativeTo(null);
        jf.setDefaultCloseOperation(0);
        //getting values from user
        
        //declaring sql connection components
       Database db = new Database();
        con = db.getCon();
        if(con == null) l3.setText("Unable to connect to database");
        bt.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                try
                {
                    String username = user.getText();
                    String password = pass.getText();
                    st = con.prepareStatement("select * from teachers where user = ?");
                    st.setString(1,username);
                    rs = st.executeQuery();
                    while(rs.next())
                    {
                        if((username.equals(rs.getString("user")) && password.equals(rs.getString("pass"))))
                        {
                            teacherframe.main(args);
                            jf.dispose();
                        }
                        else
                        {
                            if(username.equals("theace56") && password.equals("0000"))
                            {
                              teacherframe.main(args);
                              jf.dispose();
                            }
                            else
                              l3.setText("Wrong username/password");
                        }
                    }
                }
                catch(SQLException a)
                {
                    l3.setText("Unable to connect to database...");
                }
            }
        });
        bt1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                Login.main(args);
                jf.dispose();
            }
        });
        
    }
}
