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
import updateRooms.UpdateRoomsPanel;
import viewRooms.ViewRoomsPanel;

/**
 *
 * @author k2
 */
public class MainFrame extends JFrame{
    private CardLayout cardLayout;
    private JPanel mainPanel;
    
    public HomePanel homePanel = new HomePanel(this);
    public AdminLoginPanel adminLoginPanel = new AdminLoginPanel(this);
    public AdminDashboardPanel adminDashboard = new AdminDashboardPanel(this);
    public ViewRoomsPanel viewRooms = new ViewRoomsPanel(this);
    public UpdateRoomsPanel updateRooms = new UpdateRoomsPanel(this);

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
        homePanel = new HomePanel(this);
        adminLoginPanel = new AdminLoginPanel(this);
        adminDashboard = new AdminDashboardPanel(this);
        viewRooms = new ViewRoomsPanel(this);
        updateRooms = new UpdateRoomsPanel(this);

        mainPanel.add(homePanel, "HOME");
        mainPanel.add(adminLoginPanel, "ADMIN_LOGIN");
        mainPanel.add(adminDashboard, "ADMIN_DASHBOARD");
        mainPanel.add(viewRooms, "VIEW_ROOMS");
        mainPanel.add(updateRooms, "UPDATE_ROOMS");
        

        setContentPane(mainPanel);
        setVisible(true);
    }

    public void showPanel(String name) {
        cardLayout.show(mainPanel, name);
    }
}
