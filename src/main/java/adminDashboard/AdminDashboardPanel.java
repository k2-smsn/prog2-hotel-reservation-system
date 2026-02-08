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
        JButton viewRoomsBtn = new JButton("View Rooms");
        JButton updateRoomsBtn = new JButton("Update Rooms");
        JButton updateResBtn = new JButton("Update Reservations");
        JButton logoutBtn = new JButton("Logout");

        Dimension buttonSize = new Dimension(250, 35); //BUTTON SIZING
        viewRoomsBtn.setMaximumSize(buttonSize);
        updateRoomsBtn.setMaximumSize(buttonSize);
        updateResBtn.setMaximumSize(buttonSize);
        logoutBtn.setMaximumSize(buttonSize);

        viewRoomsBtn.setAlignmentX(Component.CENTER_ALIGNMENT); //BUTTON ALIGNMENT
        updateRoomsBtn.setAlignmentX(Component.CENTER_ALIGNMENT);
        updateResBtn.setAlignmentX(Component.CENTER_ALIGNMENT);
        logoutBtn.setAlignmentX(Component.CENTER_ALIGNMENT);

        JSeparator separator = new JSeparator(); //VISUAL SEPARATOR
        separator.setMaximumSize(new Dimension(300, 1));
        
        //ASSEMBLE CENTER PANEL
        centerPanel.add(Box.createVerticalGlue());
        centerPanel.add(titleLabel);
        centerPanel.add(Box.createVerticalStrut(30));

        centerPanel.add(viewRoomsBtn);
        centerPanel.add(Box.createVerticalStrut(15));
        centerPanel.add(updateRoomsBtn);
        centerPanel.add(Box.createVerticalStrut(15));
        centerPanel.add(updateResBtn);

        centerPanel.add(Box.createVerticalStrut(30));
        centerPanel.add(separator);
        centerPanel.add(Box.createVerticalStrut(30));

        centerPanel.add(logoutBtn);
        centerPanel.add(Box.createVerticalGlue());

        // BUTTON ACTIONS
        viewRoomsBtn.addActionListener(e -> {
            frame.showPanel("VIEW_ROOMS");
            frame.viewRooms.updateRooms();
        });
        
        updateRoomsBtn.addActionListener(e -> frame.showPanel("UPDATE_ROOMS"));
        logoutBtn.addActionListener(e -> frame.showPanel("HOME"));

        add(centerPanel, BorderLayout.CENTER);
    }
}
