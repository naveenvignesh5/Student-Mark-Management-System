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
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

/**
 *
 * @author Naveen Vignesh
 */
public class studentdetails {
    static Connection con = null;
    static PreparedStatement st = null;
    static ResultSet rs = null;
    static int flag,flag1;
    static long stud_roll;
    public static void main(String[] args) {
        //declaring panel and its components
        stud_roll = new student_login_frame().returnroll();
        JPanel panel = new JPanel();
        panel.setBackground(Color.orange);
        JLabel tit = new JLabel("Model Exam Details");
        tit.setFont(new Font(Font.MONOSPACED,Font.BOLD,14));
        JLabel roll = new JLabel("Reg No:");
        roll.setFont(new Font(Font.SERIF,Font.ITALIC,14));
        JLabel no = new JLabel("  ************  ");
        if(stud_roll != 0)
        {
           no.setText(String.valueOf(stud_roll));
        }
        JLabel l1 = new JLabel("  ********  ");
        JLabel l2 = new JLabel("  ********  ");
        JLabel l3 = new JLabel("  ********  ");
        JLabel l4 = new JLabel("  ********  ");
        JLabel l5 = new JLabel("  ********  ");
        JLabel l6 = new JLabel("  ********  ");
        JTextField m1 = new JTextField(3);
        JTextField m2 = new JTextField(3);
        JTextField m3 = new JTextField(3);
        JTextField m4 = new JTextField(3);
        JTextField m5 = new JTextField(3);
        JTextField m6 = new JTextField(3);
        JLabel error = new JLabel();
        JLabel mod1 = new JLabel("Exam 1");
        JLabel mod2 = new JLabel("Exam 2");
        JLabel mod3 = new JLabel("Exam 3");
        JLabel m = new JLabel("Model");
        JLabel rm = new JLabel("Re-Model");
        JRadioButton r1 = new JRadioButton();
        JRadioButton r2 = new JRadioButton();
        JRadioButton r3 = new JRadioButton();
        JRadioButton r4 = new JRadioButton();
        JRadioButton r5 = new JRadioButton();
        JButton bt = new JButton("Get Subjects");
        JButton bt1 = new JButton("Get Marks");
        JButton bt2 = new JButton("Back");
        
        ButtonGroup gr = new ButtonGroup();
        ButtonGroup gr1 = new ButtonGroup();
        
        //grouping the radio button into two groups
        gr.add(r1);
        gr.add(r2);
        gr.add(r3);
        gr1.add(r4);
        gr1.add(r5);
        //setting font label potraying the marks...
        m1.setFont(new Font(Font.MONOSPACED,Font.BOLD,11));
        m2.setFont(new Font(Font.MONOSPACED,Font.BOLD,11));
        m3.setFont(new Font(Font.MONOSPACED,Font.BOLD,11));
        m4.setFont(new Font(Font.MONOSPACED,Font.BOLD,11));
        m5.setFont(new Font(Font.MONOSPACED,Font.BOLD,11));
        m6.setFont(new Font(Font.MONOSPACED,Font.BOLD,11));
        //setting font for potraying the subjects
        l1.setFont(new Font(Font.SANS_SERIF,Font.ITALIC,14));
        l2.setFont(new Font(Font.SANS_SERIF,Font.ITALIC,14));
        l3.setFont(new Font(Font.SANS_SERIF,Font.ITALIC,14));
        l4.setFont(new Font(Font.SANS_SERIF,Font.ITALIC,14));
        l5.setFont(new Font(Font.SANS_SERIF,Font.ITALIC,14));
        l6.setFont(new Font(Font.SANS_SERIF,Font.ITALIC,14));
        //adding colors to buttons
        bt.setBackground(Color.yellow);
        bt1.setBackground(Color.yellow);
        bt2.setBackground(Color.yellow);
        r1.setBackground(Color.orange);
        r2.setBackground(Color.orange);
        r3.setBackground(Color.orange);
        r4.setBackground(Color.orange);
        r5.setBackground(Color.orange);
        
        //declaring string arrays for the combobox elements...
        String[] depts = new String[] {"AERO","CIVIL","CSE","ECE","EEE","IT","MECH","TEXT"};
        String[] sem = new String[] {"01","02","03","04","05","06","07","08"};
        
        JComboBox<String> deptlist = new JComboBox<>(depts);
        JComboBox<String> semlist = new JComboBox<>(sem);
        
        deptlist.setBackground(Color.yellow);
        semlist.setBackground(Color.yellow);
        //connection to the database
        Database db = new Database();
        con = db.getCon();
        if(con == null) error.setText("Unable to connect to database");
        
        panel.add(tit);
        panel.add(roll);
        panel.add(no);
        panel.add(deptlist);
        panel.add(semlist);
        panel.add(new JLabel("   "));
        panel.add(l1);
        panel.add(m1);
        panel.add(l2);
        panel.add(m2);
        panel.add(l3);
        panel.add(m3);
        panel.add(l4);
        panel.add(m4);
        panel.add(l5);
        panel.add(m5);
        panel.add(l6);
        panel.add(m6);
        panel.add(mod1);
        panel.add(r1);
        panel.add(mod2);
        panel.add(r2);
        panel.add(mod3);
        panel.add(r3);
        panel.add(m);
        panel.add(r4);
        panel.add(rm);
        panel.add(r5);
        panel.add(bt);
        panel.add(bt1);
        panel.add(bt2);
        JFrame jf = new JFrame();
        jf.add(panel);
        jf.setSize(180,360);
        jf.setVisible(true);
        jf.setLocationRelativeTo(null);
        jf.setResizable(false);
        jf.setDefaultCloseOperation(0);
        bt2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                try {
                    student_login_frame.main(args);
                } catch (ClassNotFoundException | SQLException ex) {
                    Logger.getLogger(studentdetails.class.getName()).log(Level.SEVERE, null, ex);
                }
                jf.dispose();
            }
        });
        bt.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                String sdept = (String) deptlist.getSelectedItem();
                int ssem = Integer.parseInt((String) semlist.getSelectedItem());
                try
                {
                    st =(PreparedStatement) con.prepareStatement("select * from subject where dept = ? and sem = ?");
                    st.setString(1,sdept);
                    st.setInt(2,ssem);
                    rs = st.executeQuery();
                    while(rs.next())
                    {
                        l1.setText(rs.getString("sub1"));
                        l2.setText(rs.getString("sub2"));
                        l3.setText(rs.getString("sub3"));
                        l4.setText(rs.getString("sub4"));
                        l5.setText(rs.getString("sub5"));
                        l6.setText(rs.getString("sub5"));
                    }
                }
                catch(SQLException b)
                {
                    error.setText("Unable to retrieve from database");
                }
            }
        });
        bt1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                String sdept = (String) deptlist.getSelectedItem();
                int ssem = Integer.parseInt((String)semlist.getSelectedItem());
                String exam;
                if(flag == 1)
                {
                    if(flag1 == 1)
                        exam = "model1";
                    else if(flag1 == 2)
                        exam = "model2";
                    else
                        exam = "model3";
                }
                else
                {
                    if(flag1 == 1)
                        exam = "remodel1";
                    else if(flag1 == 2)
                        exam = "remodel2";
                    else
                        exam = "remodel3";
                }
                try
                {
                    st = con.prepareStatement("select m1,m2,m3,m4,m5,m6 from "+exam+" where roll = ?");
                    st.setLong(1,stud_roll);
                    rs = st.executeQuery();
                    while(rs.next())
                    {
                        m1.setText(String.valueOf(rs.getInt("m1")));
                        m2.setText(String.valueOf(rs.getInt("m2")));
                        m3.setText(String.valueOf(rs.getInt("m3")));
                        m4.setText(String.valueOf(rs.getInt("m4")));
                        m5.setText(String.valueOf(rs.getInt("m5")));
                        m6.setText(String.valueOf(rs.getInt("m6")));
                    }
                    rs.beforeFirst();
                }
                catch(SQLException b)
                {
                    error.setText("Unable to retrieve marks from database");
                }
            }
        });
        r1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                flag = 1;
            }
        });
        r2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                flag = 0;
            }
        });
        r3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                flag1 = 1;
            }
        });
        r4.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                flag1 = 2;
            }
        });
        r5.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                flag1 = 3;
            }
        });
    }

}

