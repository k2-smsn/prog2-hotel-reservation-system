/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package adminDashboard;

/**
 *
 * @author k2
 */
import javax.swing.*;
import java.awt.*;
import mainFrame.MainFrame;

public class AdminDashboardPanel extends JPanel {

    public AdminDashboardPanel(MainFrame frame) {
        setLayout(new BorderLayout());
        setBackground(Color.WHITE);
        
        //INITIALIZE CENTER PANEL
        JPanel centerPanel = new JPanel();
        centerPanel.setLayout(new BoxLayout(centerPanel, BoxLayout.Y_AXIS));
        centerPanel.setBackground(Color.WHITE);

        JLabel titleLabel = new JLabel("Admin Dashboard"); //TITLE
        titleLabel.setFont(new Font("Segoe UI", Font.BOLD, 24));
        titleLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        
        //BUTTONS SETUP
        JButton btnViewRooms = new JButton("View Rooms");
        JButton btnUpdateRooms = new JButton("Update Rooms");
        JButton btnUpdateReservations = new JButton("Update Reservations");
        JButton btnLogout = new JButton("Logout");

        Dimension buttonSize = new Dimension(250, 35); //BUTTON SIZING
        btnViewRooms.setMaximumSize(buttonSize);
        btnUpdateRooms.setMaximumSize(buttonSize);
        btnUpdateReservations.setMaximumSize(buttonSize);
        btnLogout.setMaximumSize(buttonSize);

        btnViewRooms.setAlignmentX(Component.CENTER_ALIGNMENT); //BUTTON ALIGNMENT
        btnUpdateRooms.setAlignmentX(Component.CENTER_ALIGNMENT);
        btnUpdateReservations.setAlignmentX(Component.CENTER_ALIGNMENT);
        btnLogout.setAlignmentX(Component.CENTER_ALIGNMENT);

        JSeparator separator = new JSeparator(); //VISUAL SEPARATOR
        separator.setMaximumSize(new Dimension(300, 1));
        
        //ASSEMBLE CENTER PANEL
        centerPanel.add(Box.createVerticalGlue());
        centerPanel.add(titleLabel);
        centerPanel.add(Box.createVerticalStrut(30));

        centerPanel.add(btnViewRooms);
        centerPanel.add(Box.createVerticalStrut(15));
        centerPanel.add(btnUpdateRooms);
        centerPanel.add(Box.createVerticalStrut(15));
        centerPanel.add(btnUpdateReservations);

        centerPanel.add(Box.createVerticalStrut(30));
        centerPanel.add(separator);
        centerPanel.add(Box.createVerticalStrut(30));

        centerPanel.add(btnLogout);
        centerPanel.add(Box.createVerticalGlue());

        // BUTTON ACTIONS
        btnLogout.addActionListener(e -> frame.showPanel("HOME"));

        add(centerPanel, BorderLayout.CENTER);
    }
}
