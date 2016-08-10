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
public class delete_form {
    static Database db;
    static Connection con = null;
    static PreparedStatement st = null;
    public static void main(String[] args) {
        JPanel p = new JPanel();
        JLabel l1 = new JLabel ("   Delete Form   ");
        JLabel l2 = new JLabel("   Enter Roll No   ");
        JLabel error = new JLabel();
        l1.setFont(new Font(Font.MONOSPACED,Font.BOLD,14));
        l2.setFont(new Font(Font.SANS_SERIF,Font.ITALIC,13));
        JTextField t = new JTextField(15);
        JButton bt = new JButton("Delete record");
        JButton bt1 = new JButton("Back");
        bt.setFont(new Font(Font.SERIF,Font.BOLD,12));
        bt1.setFont(new Font(Font.SERIF,Font.BOLD,12));
        p.setBackground(Color.orange);
        bt.setBackground(Color.yellow);
        bt1.setBackground(Color.yellow);
        p.add(l1);
        p.add(l2);
        p.add(t);
        p.add(bt);
        p.add(bt1);
        p.add(error);
        JFrame jf = new JFrame();
        jf.setVisible(true);
        jf.setSize(200,170);
        jf.add(p);
        jf.setResizable(false);
        jf.setLocationRelativeTo(null);
        jf.setDefaultCloseOperation(0);
        
        db = new Database();
        con = db.getCon();
        if(con == null) error.setText("Unable to connect to database");
        //declaring commands for buttons
        bt.addActionListener(new ActionListener()
        {
          public void actionPerformed(ActionEvent evt)
          {
            long rollno = Long.parseLong(t.getText());
            int i;
            try
            {
                st = con.prepareStatement("delete from student where roll = ?");
                st.setLong(1,rollno);
                st.execute();
                error.setText("Record deleted");
            }
            catch(SQLException b)
            {
              error.setText("Unable to delete from database");
            }
            for(i=1;i<=3;i++)
            {
              try
              {
                st = con.prepareStatement("delete from model"+String.valueOf(i)+" where roll = ?");
                st.setLong(1,rollno);
                st.execute();
                error.setText("Record deleted");
              }
              catch(SQLException b)
              {
                 error.setText("Unable to delete from database");
              } 
            }
            for(i=1;i<=3;i++)
            {
              try
              {
                st = con.prepareStatement("delete from remodel"+String.valueOf(i)+" where roll = ?");
                st.setLong(1,rollno);
                st.execute();
                error.setText("Record deleted");
              }
              catch(SQLException b)
              {
                 error.setText("Unable to delete from database");
              } 
            }
          }
        });
        bt1.addActionListener(new ActionListener()
        {
           public void actionPerformed(ActionEvent evt)
           {
             teacherframe.main(args);
             jf.dispose();
           }
        });
    }
}
