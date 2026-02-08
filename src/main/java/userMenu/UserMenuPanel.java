/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package userMenu;

/**
 *
 * @author k2
 */
import javax.swing.*;
import java.awt.*;
import mainFrame.MainFrame;

public class UserMenuPanel extends JPanel {

    public UserMenuPanel(MainFrame frame) {
        setLayout(new BorderLayout());
        setBackground(Color.WHITE);

        // Title
        JLabel titleLabel = new JLabel("User Menu", SwingConstants.CENTER);
        titleLabel.setFont(new Font("Segoe UI", Font.BOLD, 24));
        titleLabel.setBorder(BorderFactory.createEmptyBorder(20, 0, 20, 0));
        add(titleLabel, BorderLayout.NORTH);

        // Center buttons panel
        JPanel centerPanel = new JPanel();
        centerPanel.setLayout(new BoxLayout(centerPanel, BoxLayout.Y_AXIS));
        centerPanel.setBackground(Color.WHITE);

        JButton viewRoomsBtn = new JButton("View Rooms");
        JButton bookBtn = new JButton("Book a room");
        JButton checkoutBtn = new JButton("Checkout");

        Dimension btnSize = new Dimension(220, 40);
        viewRoomsBtn.setMaximumSize(btnSize);
        bookBtn.setMaximumSize(btnSize);
        checkoutBtn.setMaximumSize(btnSize);

        viewRoomsBtn.setAlignmentX(Component.CENTER_ALIGNMENT);
        bookBtn.setAlignmentX(Component.CENTER_ALIGNMENT);
        checkoutBtn.setAlignmentX(Component.CENTER_ALIGNMENT);

        centerPanel.add(viewRoomsBtn);
        centerPanel.add(Box.createVerticalStrut(15));
        centerPanel.add(bookBtn);
        centerPanel.add(Box.createVerticalStrut(15));
        centerPanel.add(checkoutBtn);

        add(centerPanel, BorderLayout.CENTER);

        // Back button (south, left aligned)
        JButton backButton = new JButton("Back");
        backButton.addActionListener(e -> frame.showPanel("HOME"));

        JPanel southPanel = new JPanel();
        southPanel.setLayout(new BoxLayout(southPanel, BoxLayout.X_AXIS));
        southPanel.add(Box.createHorizontalStrut(10));
        southPanel.add(backButton);
    }
}