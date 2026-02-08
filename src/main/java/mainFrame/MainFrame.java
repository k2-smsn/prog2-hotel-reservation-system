/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mainFrame;

import adminDashboard.AdminDashboardPanel;
import adminLogin.AdminLoginPanel;
import homePanel.HomePanel;
import java.awt.CardLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import viewRooms.ViewRoomsPanel;

/**
 *
 * @author k2
 */
public class MainFrame extends JFrame{
    private CardLayout cardLayout;
    private JPanel mainPanel;

    public MainFrame() {
        //SETUP FRAME (this)
        setTitle("Hotel Reservation System");
        setSize(900, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);

        cardLayout = new CardLayout();
        mainPanel = new JPanel(cardLayout); //INITIALIZE MAIN PANEL W/ LAYOUT
        
        // Panels
        HomePanel homePanel = new HomePanel(this);
        AdminLoginPanel adminLoginPanel = new AdminLoginPanel(this);
        AdminDashboardPanel adminDashboard = new AdminDashboardPanel(this);
        ViewRoomsPanel viewRooms = new ViewRoomsPanel(this);

        mainPanel.add(homePanel, "HOME");
        mainPanel.add(adminLoginPanel, "ADMIN_LOGIN");
        mainPanel.add(adminDashboard, "ADMIN_DASHBOARD");
        mainPanel.add(viewRooms, "VIEW_ROOMS");
        

        setContentPane(mainPanel);
        setVisible(true);
    }

    public void showPanel(String name) {
        cardLayout.show(mainPanel, name);
    }
}
