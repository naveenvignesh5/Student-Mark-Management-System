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
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Naveen Vignesh
 */
public class Home {
    public static void main(final String[] args) throws IOException {
        JPanel panel = new JPanel();
        //declaring and defining the panel and it's layou
        JLabel lb = new JLabel("Jaya Engineering College Model Exam details Management System");
        lb.setFont(new Font(Font.MONOSPACED,Font.BOLD,12));
        //declaring the components of the frame
        JButton b1 = new JButton("Login");
        b1.setBackground(Color.orange);
        JButton b2 = new JButton("Exit");
        b2.setBackground(Color.orange);
        JButton b3 = new JButton("Credits");
        b3.setBackground(Color.orange);
        b1.setFont(new Font(Font.MONOSPACED,Font.ITALIC,12));
        b2.setFont(new Font(Font.MONOSPACED,Font.ITALIC,12));
        b3.setFont(new Font(Font.MONOSPACED,Font.ITALIC,12));
        //adding the components to the panel
        panel.setBackground(Color.yellow);
        panel.add(lb);
        panel.add(b1);
        panel.add(b2);
        panel.add(b3);
        //declaring frame and adding panel to it...
        JFrame fr = new JFrame();
        fr.setSize(450,100);
        fr.setTitle("Home - JEC Model Exam DBMS");
        fr.add(panel);
        fr.setResizable(false);
        fr.setVisible(true);
        fr.setLocationRelativeTo(null);
        fr.setDefaultCloseOperation(0);
        
         //defining commands for the buttons...
        
        b1.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent evt) {
                Login.main(args);
                fr.dispose();
            }
        });
        b2.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent evt) {
                System.exit(0);
            }
        });
        b3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                credits.main(args);
                fr.dispose();
            }
        });
    }
}
