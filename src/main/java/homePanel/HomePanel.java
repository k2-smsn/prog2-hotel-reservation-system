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

        // LEFT PANEL (30%) - Welcome + Buttons
        JPanel leftPanel = new JPanel();
        leftPanel.setPreferredSize(new Dimension(270, 600)); // ~30% of 900
        leftPanel.setBackground(Color.WHITE);
        leftPanel.setLayout(new BoxLayout(leftPanel, BoxLayout.Y_AXIS));

        JLabel welcomeLabel = new JLabel("<html><center>Welcome to<br>Hotel Reservation System</center></html>");
        welcomeLabel.setFont(new Font("Segoe UI", Font.BOLD, 20));
        welcomeLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        JButton btnReserve = new JButton("Make a Reservation");
        JButton btnView = new JButton("View Reservations");
        
        btnReserve.setAlignmentX(Component.CENTER_ALIGNMENT);
        btnView.setAlignmentX(Component.CENTER_ALIGNMENT);

        leftPanel.add(Box.createVerticalGlue());
        leftPanel.add(welcomeLabel);
        leftPanel.add(Box.createVerticalStrut(30));
        leftPanel.add(btnReserve);
        leftPanel.add(Box.createVerticalStrut(15));
        leftPanel.add(btnView);
        leftPanel.add(Box.createVerticalGlue());
        
        // RIGHT PANEL (70%) - Background
        JPanel backgroundPanel = new JPanel();
        backgroundPanel.setBackground(new Color(40, 90, 130)); // placeholder

        add(leftPanel, BorderLayout.WEST);
        add(backgroundPanel, BorderLayout.CENTER);
     }
}
