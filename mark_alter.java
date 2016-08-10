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
public class mark_alter {
    static String[] sub;
    static Connection con = null;
    static PreparedStatement st = null;
    static ResultSet rs = null;
    static int flag,flag1;
    public static void main(String[] args) {
        JPanel panel = new JPanel();
        String[] dept = new String[] {"AERO","CIVIL","CSE","ECE","EEE","IT","MECH","TEXT"};
        String[] sem = new String[] {"01","02","03","04","05","06","07","08"};
        JComboBox<String> deptlist = new JComboBox<>(dept);
        JComboBox<String> semlist = new JComboBox<>(sem);
        JComboBox<String> sublist = new JComboBox<>();
        JLabel error = new JLabel();
        JLabel subject = new JLabel("  ********  ");
        JButton bt1 = new JButton("Get Subjects");
        JButton bt2 = new JButton("Submit");
        JButton bt3 = new JButton("Back");
        JTextField m = new JTextField(3);
        JTextField r = new JTextField(14);
        JLabel l0 = new JLabel("Roll No");
        JLabel l1 = new JLabel("Model Exam 1");
        JLabel l2 = new JLabel("Model Exam 2");
        JLabel l3 = new JLabel("Model Exam 3");
        JLabel l4 = new JLabel("Model Exam");
        JLabel l5 = new JLabel("Remodel Exam");
        ButtonGroup g1 = new ButtonGroup();
        ButtonGroup g2 =  new ButtonGroup();
        JRadioButton r1 = new JRadioButton();
        JRadioButton r2 = new JRadioButton();
        JRadioButton r3 = new JRadioButton();
        JRadioButton r4 = new JRadioButton();
        JRadioButton r5 = new JRadioButton();
        g1.add(r1);
        g1.add(r2);
        g1.add(r3);
        g2.add(r4);
        g2.add(r5);
        //adding color and fonts to components
        l0.setFont(new Font(Font.MONOSPACED,Font.BOLD,14));
        l1.setFont(new Font(Font.MONOSPACED,Font.BOLD,14));
        l2.setFont(new Font(Font.MONOSPACED,Font.BOLD,14));
        l3.setFont(new Font(Font.MONOSPACED,Font.BOLD,14));
        l4.setFont(new Font(Font.MONOSPACED,Font.BOLD,14));
        l5.setFont(new Font(Font.MONOSPACED,Font.BOLD,14));
        subject.setFont(new Font(Font.MONOSPACED,Font.BOLD,14));
        error.setFont(new Font(Font.MONOSPACED,Font.BOLD,14));
        deptlist.setFont(new Font(Font.SERIF,Font.BOLD,12));
        semlist.setFont(new Font(Font.SERIF,Font.BOLD,12));
        sublist.setFont(new Font(Font.SERIF,Font.BOLD,12));
        bt1.setFont(new Font(Font.SANS_SERIF,Font.ITALIC,13));
        bt2.setFont(new Font(Font.SANS_SERIF,Font.ITALIC,13));
        bt3.setFont(new Font(Font.SANS_SERIF,Font.ITALIC,13));
        //setting colors for components
        
        r1.setBackground(Color.orange);
        r2.setBackground(Color.orange);
        r3.setBackground(Color.orange);
        r4.setBackground(Color.orange);
        r5.setBackground(Color.orange);
        
        bt1.setBackground(Color.yellow);
        bt2.setBackground(Color.yellow);
        bt3.setBackground(Color.yellow);
        deptlist.setBackground(Color.yellow);
        sublist.setBackground(Color.yellow);
        semlist.setBackground(Color.yellow);
        
        panel.setBackground(Color.orange);
        panel.add(l0);
        panel.add(r);
        panel.add(subject);
        panel.add(m);
        panel.add(deptlist);
        panel.add(semlist);
        panel.add(sublist);
        panel.add(l1);
        panel.add(r1);
        panel.add(l2);
        panel.add(r2);
        panel.add(l3);
        panel.add(r3);
        panel.add(l4);
        panel.add(r4);
        panel.add(l5);
        panel.add(r5);
        panel.add(bt1);
        panel.add(bt2);
        panel.add(bt3);
        panel.add(error);
        //declaring frame
        JFrame jf = new JFrame();
        jf.add(panel);
        jf.setTitle("Mark change - JEC Model Exam DBMS");
        jf.setVisible(true);
        jf.setSize(200,375);
        jf.setResizable(false);
        jf.setLocationRelativeTo(null);
        jf.setDefaultCloseOperation(0);
        
        sublist.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                subject.setText("  "+(String) sublist.getSelectedItem()+"  ");
            }
        });
        Database db = new Database();
        con = db.getCon();
        if(con == null) error.setText("Unable to connect to database");
        bt1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                try
                {
                    String sdept = (String) deptlist.getSelectedItem();
                    int ssem = Integer.parseInt((String) semlist.getSelectedItem());
                    st = con.prepareStatement("select sub1,sub2,sub3,sub4,sub5,sub6 from subject where dept = ? and sem = ?");
                    st.setString(1,sdept);
                    st.setInt(2,ssem);
                    rs = st.executeQuery();
                    while(rs.next())
                    {
                        sublist.addItem(rs.getString("sub1"));
                        sublist.addItem(rs.getString("sub2"));
                        sublist.addItem(rs.getString("sub3"));
                        sublist.addItem(rs.getString("sub4"));
                        sublist.addItem(rs.getString("sub5"));
                        sublist.addItem(rs.getString("sub6"));
                    }
                    rs.beforeFirst();
                }
                catch(SQLException a)
                {
                    error.setText("Unable in connect into database");
                } }
        });
        bt2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                long rollno = Long.parseLong(r.getText());
                int mark = Integer.parseInt(m.getText());
                String no = null;
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
                    String ssub = (String)sublist.getSelectedItem();
                    String sdept = (String) deptlist.getSelectedItem();
                    int ssem = Integer.parseInt((String) semlist.getSelectedItem());
                    st = con.prepareStatement("select sub1,sub2,sub3,sub4,sub5,sub6 from subject where dept = ? and sem = ?");
                    st.setString(1,sdept);
                    st.setInt(2,ssem);
                    rs = st.executeQuery();
                    while(rs.next())
                    {
                        if(ssub.equals(rs.getString("sub1")))
                            no = "1";
                        else if(ssub.equals(rs.getString("sub2")))
                            no = "2";
                        else if(ssub.equals(rs.getString("sub3")))
                            no = "3";
                        else if(ssub.equals(rs.getString("sub4")))
                            no = "4";
                        else if(ssub.equals(rs.getString("sub5")))
                            no = "5";
                        else
                            no = "6";
                    }
                    rs.beforeFirst();
                    
                }
                catch(SQLException a)
                {
                    error.setText("Unable to connect to database");
                    System.out.println(a);
                }
                
                try
                {
                    st = con.prepareStatement("update "+exam+" set m"+no+" = ? where roll = ?");
                    st.setLong(1,rollno);
                    st.setInt(2,mark);
                    st.execute();
                    error.setText("Mark changed");
                }
                catch(SQLException a)
                {
                    error.setText("Unable to make changes");
                }
                catch(NullPointerException b)
                {
                    error.setText("No such record present");
                } }
        });
        bt3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                teacherframe.main(args);
                jf.dispose();
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