/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package jdbc;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
/**
 *
 * @author Naveen Vignesh
 */
public class hod_login {
    public static void main(String[] args) {
        JPanel p = new JPanel();
        JLabel tit = new JLabel();
        JLabel l1 = new JLabel("Username");
        JLabel l2 = new JLabel("Password");
        JTextField t1 = new JTextField(15);
        JPasswordField p1 = new JPasswordField(15);
        JButton b1 = new JButton("Login");
        JButton b2 = new JButton("Back");
        
        //adding components to panel
        p.add(tit);
        p.add(l1);
        p.add(t1);
        p.add(l2);
        p.add(p1);
        p.add(b1);
        p.add(b2);
        
        //declaring frame and adding panel to it
        JFrame fr = new JFrame("Login");
        fr.add(p);
        fr.setSize(200,400);
        fr.setVisible(true);
        fr.setLocationRelativeTo(null);
        fr.setDefaultCloseOperation(0);
        
        //adding panel button commands 
        b1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               
            }
        });
        
        b2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
            }
        });
    }
}
