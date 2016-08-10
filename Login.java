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
import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Naveen Vignesh
 */
public class Login {
    public static void main(final String[] args) {
        JPanel panel = new JPanel();
        JLabel l = new JLabel("Login page");
        l.setFont(new Font(Font.MONOSPACED,Font.BOLD,14));
        JButton b1 = new JButton("Student Login");
        JButton b2 = new JButton("Teacher Login");
        JButton b3 = new JButton("Back");
        b1.setFont(new Font(Font.MONOSPACED,Font.ITALIC,11));
        b2.setFont(new Font(Font.MONOSPACED,Font.ITALIC,11));
        b3.setFont(new Font(Font.MONOSPACED,Font.ITALIC,11));
        b1.setBackground(Color.yellow);
        b2.setBackground(Color.yellow);
        b3.setBackground(Color.yellow);
        panel.setBackground(Color.orange);
        panel.add(l);
        panel.add(b1);
        panel.add(b2);
        panel.add(b3);
        JFrame jf = new JFrame();
        jf.add(panel);
        jf.setTitle("Model Exam DBMS");
        jf.setSize(150,175);
        jf.setVisible(true);
        jf.setResizable(false);
        jf.setLocationRelativeTo(null);
        jf.setDefaultCloseOperation(0);
        b1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                try {
                    student_login_frame.main(args);
                    jf.dispose();
                } catch (ClassNotFoundException | SQLException ex) {
                    Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        b2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                teacher_Login_frame.main(args);
                jf.dispose();
            }
        });
        b3.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent evt) {
                try {
                    Home.main(args);
                } catch (IOException ex) {
                    Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
                }
                jf.dispose();
            }
        });
        
    }
}
