/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package adminLogin;

/**
 *
 * @author k2
 */
import javax.swing.*;
import java.awt.*;
import mainFrame.MainFrame;

public class AdminLoginPanel extends JPanel {

    public AdminLoginPanel(MainFrame frame) {
        setLayout(new BorderLayout());
        setBackground(Color.WHITE);

        // CENTER PANEL (Login Form)
        JPanel centerPanel = new JPanel();
        centerPanel.setLayout(new BoxLayout(centerPanel, BoxLayout.Y_AXIS));
        centerPanel.setBackground(Color.WHITE);

        JLabel titleLabel = new JLabel("Admin Login"); //TOP LABEL
        titleLabel.setFont(new Font("Segoe UI", Font.BOLD, 24));
        titleLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        JTextField adminField = new JTextField(); //USERNAME FIELD
        adminField.setMaximumSize(new Dimension(250, 30));
        adminField.setBorder(BorderFactory.createTitledBorder("Admin Username")); //TITLED BORDER
        adminField.setAlignmentX(Component.CENTER_ALIGNMENT);

        JPasswordField passwordField = new JPasswordField(); //PASSWORD FIELD
        passwordField.setMaximumSize(new Dimension(250, 30));
        passwordField.setBorder(BorderFactory.createTitledBorder("Password"));
        passwordField.setAlignmentX(Component.CENTER_ALIGNMENT);
        
        JButton loginButton = new JButton("Login"); //LOGIN BUTTON
        loginButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        
        //ASSEMBLE CENTER PANEL
        centerPanel.add(Box.createVerticalGlue());
        centerPanel.add(titleLabel);
        centerPanel.add(Box.createVerticalStrut(30));
        centerPanel.add(adminField);
        centerPanel.add(Box.createVerticalStrut(15));
        centerPanel.add(passwordField);
        centerPanel.add(Box.createVerticalStrut(25));
        centerPanel.add(loginButton);
        centerPanel.add(Box.createVerticalGlue());

        // SOUTH PANEL (Back Button)
        JPanel southPanel = new JPanel();
        southPanel.setLayout(new BoxLayout(southPanel, BoxLayout.X_AXIS));
        southPanel.setBackground(Color.WHITE);

        JButton backButton = new JButton("Back");
        
        //PLACE TO BOTTOM LEFT
        southPanel.add(Box.createHorizontalStrut(15));
        southPanel.add(backButton);
        southPanel.add(Box.createHorizontalGlue());
        southPanel.add(Box.createVerticalStrut(15));

        // Actions
        backButton.addActionListener(e -> frame.showPanel("HOME")); //GO BACK TO HOME

        add(centerPanel, BorderLayout.CENTER);
        add(southPanel, BorderLayout.SOUTH);
    }
}

