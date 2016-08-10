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
public class credits {
    public static void main(String[] args) {
        JPanel p = new JPanel();
        JLabel l1 = new JLabel("Project done by: ");
        l1.setFont(new Font(Font.SANS_SERIF,Font.BOLD,15));
        JLabel l2 = new JLabel("Naveen Vignesh.B");
        l2.setFont(new Font(Font.MONOSPACED,Font.ITALIC,13));
        JLabel l3 = new JLabel("Dept: CSE");
        l3.setFont(new Font(Font.MONOSPACED,Font.ITALIC,13));
        JLabel l4 = new JLabel("Batch: 2014 to 2018");
        l4.setFont(new Font(Font.MONOSPACED,Font.ITALIC,13));
        JLabel l5 = new JLabel("Jaya Engineering College");
        l5.setFont(new Font(Font.MONOSPACED,Font.ITALIC,13));
        JButton b = new JButton("Back");
        b.setFont(new Font(Font.SERIF,Font.BOLD,13));
        b.setBackground(Color.orange);
        p.setBackground(Color.yellow);
        p.add(l1);
        p.add(l2);
        p.add(l3);
        p.add(l4);
        p.add(l5);
        p.add(b);
        JFrame jf = new JFrame();
        jf.setVisible(true);
        jf.add(p);
        jf.setSize(210,190);
        jf.setDefaultCloseOperation(0);
        jf.setResizable(false);
        jf.setLocationRelativeTo(null);
       
        b.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                try {
                    Home.main(args);
                    jf.dispose();
                } catch (IOException ex) {
                    Logger.getLogger(credits.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }
}
