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
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author jec
 */
public class teacherframe {
    public static void main(final String[] args) {
        JPanel panel = new JPanel();
        JLabel l = new JLabel("Teacher Account");
        l.setFont(new Font(Font.SANS_SERIF,Font.BOLD,15));
        JButton b1 = new JButton("Create Student Record");
        JButton b6 = new JButton("Delete Student Record");
        JButton b2 = new JButton("Enter Mark");
        JButton b4 = new JButton("Alter Mark");
        JButton b3 = new JButton("Back");
        //setting fonts and color for the buttons
        b1.setFont(new Font(Font.MONOSPACED,Font.BOLD,14));
        b2.setFont(new Font(Font.MONOSPACED,Font.BOLD,14));
        b3.setFont(new Font(Font.MONOSPACED,Font.BOLD,14));
        b4.setFont(new Font(Font.MONOSPACED,Font.BOLD,14));
        b6.setFont(new Font(Font.MONOSPACED,Font.BOLD,14));
        b6.setBackground(Color.orange);
        b1.setBackground(Color.orange);
        b2.setBackground(Color.orange);
        b3.setBackground(Color.orange);
        b4.setBackground(Color.orange);
        //setting panel properties and adding components to it
        panel.setBackground(Color.yellow);
        panel.add(l);
        panel.add(b1);
        panel.add(b6);
        panel.add(b2);
        panel.add(b4);
        panel.add(b3);
        final JFrame jf = new JFrame();
        jf.add(panel);
        jf.setSize(220,240);
        jf.setVisible(true);
        jf.setLocationRelativeTo(null);
        jf.setDefaultCloseOperation(0);
        
        b1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                create_form.main(args);
                jf.dispose();
            }
        });
        b2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                modelexamentry.main(args);
                jf.dispose();
            }
        });
        b3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                Login.main(args);
                jf.dispose();
            }
        });
        b4.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                mark_alter.main(args);
                jf.dispose();
            }
        });
       
        b6.addActionListener(new ActionListener()
        {
          public void actionPerformed(ActionEvent evt)
          {
            delete_form.main(args);
            jf.dispose();
          }
        });
    }
}

