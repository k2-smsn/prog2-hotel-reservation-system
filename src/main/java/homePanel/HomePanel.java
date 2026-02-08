/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package homePanel;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import mainFrame.MainFrame;

/**
 *
 * @author k2
 */
public class HomePanel extends JPanel{
     public HomePanel(MainFrame frame) {
        setLayout(new BorderLayout());
        
        // CENTER PANEL (70% of frame) - Background
        JPanel backgroundPanel = new JPanel();
        backgroundPanel.setBackground(new Color(40, 90, 130)); // placeholder

        // SIDE PANEL (30% of frame) - Welcome + Buttons
        JPanel sidePanel = new JPanel();
        sidePanel.setPreferredSize(new Dimension(270, 600)); // ~30% of 900
        sidePanel.setBackground(Color.WHITE);
        sidePanel.setLayout(new BoxLayout(sidePanel, BoxLayout.Y_AXIS));

        //LABEL
        JLabel welcomeLabel = new JLabel("<html><center>Welcome to<br>Hilton Hotel</center></html>");
        welcomeLabel.setFont(new Font("Segoe UI", Font.BOLD, 20));
        welcomeLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        welcomeLabel.setHorizontalAlignment(JLabel.CENTER);

        //BUTTONS
        JButton loginBtn = new JButton("Admin Login");
        JButton menuBtn = new JButton("User Menu");
        
        loginBtn.setAlignmentX(Component.CENTER_ALIGNMENT);
        menuBtn.setAlignmentX(Component.CENTER_ALIGNMENT);
        
        loginBtn.setFocusable(false);
        menuBtn.setFocusable(false);
        
        loginBtn.addActionListener(e -> {
            frame.showPanel("ADMIN_LOGIN");
        });
        
        //ASSEMBLE SIDE PANEL
        sidePanel.add(Box.createVerticalGlue());
        sidePanel.add(welcomeLabel);
        sidePanel.add(Box.createVerticalStrut(30));
        sidePanel.add(loginBtn);
        sidePanel.add(Box.createVerticalStrut(15));
        sidePanel.add(menuBtn);
        sidePanel.add(Box.createVerticalGlue());
        
        //ASSEMBLE CLASS    
        add(backgroundPanel, BorderLayout.CENTER);
        add(sidePanel, BorderLayout.EAST);
        
     }
}
