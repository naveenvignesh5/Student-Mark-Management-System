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
import javax.management.openmbean.KeyAlreadyExistsException;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author Naveen Vignesh
 */
public class create_form {
    static Connection con = null;
    static PreparedStatement st = null;
    static Database db;
    public static void main(String[] args) {
        //declaring panel and defining its components...
        JPanel p = new JPanel();
        JLabel roll = new JLabel(" Student's Roll No ");
        roll.setFont(new Font(Font.MONOSPACED,Font.BOLD,14));
        JLabel dob = new JLabel(" Student's date of birth ");
        dob.setFont(new Font(Font.MONOSPACED,Font.BOLD,14));
        JLabel error = new JLabel();
        JTextField roll_entry = new JTextField(12);
        JTextField dob_entry_day = new JTextField(2);
        JTextField dob_entry_month = new JTextField(2);
        JTextField dob_entry_year = new JTextField(4);
        dob_entry_day.setText("DD");
        dob_entry_month.setText("MM");
        dob_entry_year.setText("YYYY");
        JButton entry = new JButton("Submit");
        entry.setFont(new Font(Font.SANS_SERIF,Font.ITALIC,12));
        JButton exit = new JButton("Back");
        exit.setFont(new Font(Font.SANS_SERIF,Font.ITALIC,12));
        entry.setBackground(Color.yellow);
        exit.setBackground(Color.yellow);
        //adding elements into the panel...
        p.setBackground(Color.orange);
        p.add(roll);
        p.add(roll_entry);
        p.add(dob);
        p.add(dob_entry_day);
        p.add(new JLabel("/"));
        p.add(dob_entry_month);
        p.add(new JLabel("/"));
        p.add(dob_entry_year);
        p.add(entry);
        p.add(exit);
        p.add(error);
        JFrame jf = new JFrame();
        jf.setTitle("Student Record Entry");
        jf.add(p);
        jf.setSize(210,175);
        jf.setVisible(true);
        jf.setResizable(false);
        jf.setLocationRelativeTo(null);
        jf.setDefaultCloseOperation(0);
     
        db = new Database();
        con = db.getCon();
        if(con == null)
          error.setText("Unable to connect to database");
        
        entry.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                try
                {
                    
                    long rollno = Long.parseLong(roll_entry.getText());
                    int dd = Integer.parseInt(dob_entry_day.getText());
                    int mm = Integer.parseInt(dob_entry_month.getText());
                    int yyyy = Integer.parseInt(dob_entry_year.getText());
                    String date = yyyy+"-"+mm+"-"+dd;
                    st = con.prepareStatement("insert into student values (?,?)");
                    st.setLong(1,rollno);
                    st.setString(2,date);
                    st.execute();
                    int i;
                    String j;
                    for(i=1;i<=3;i++)
                    {
                        j = String.valueOf(i);
                        st = con.prepareStatement("insert into model"+j+" (`roll`) values (?)");
                        st.setLong(1,rollno);
                        st.execute();
                    }
                    for(i=1;i<=3;i++)
                    {
                        j = String.valueOf(i);
                        st = con.prepareStatement("insert into remodel"+j+" (`roll`) values (?)");
                        st.setLong(1,rollno);
                        st.execute();
                    }
                }
                catch(SQLException a)
                {
                    error.setText("Unable to record into database...");
                }
                catch(KeyAlreadyExistsException b)
                {
                    error.setText("Record Already present in the database...");
                }}
        });
        exit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                teacherframe.main(args);
                jf.dispose();
            }
        });
    }
}
