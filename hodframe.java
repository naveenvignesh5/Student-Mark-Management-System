/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package jdbc;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author Naveen Vignesh
 */
public class hodframe {
    public static void main(String[] args) {
        JPanel p = new JPanel();
        JButton b1 = new JButton("Create Teacher Record");
        JButton b2 = new JButton("Alter Student Mark");
        JButton b3 = new JButton("View Student Details");
        JButton b4 = new JButton("Back");
        
        JFrame fr = new JFrame("HOD Panel");
        fr.setSize(200,400);
        fr.setLocationRelativeTo(null);
        fr.setDefaultCloseOperation(0);
        fr.setVisible(true);
        
        //adding command to buttons
        b4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                hod_login.main(args);
                fr.dispose();
            }
        });
        
        b2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mark_alter.main(args);
                fr.dispose();
            }
        });
        
        
    }
}
