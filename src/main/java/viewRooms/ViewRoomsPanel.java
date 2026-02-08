/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package viewRooms;

/**
 *
 * @author k2
 */
import appData.Room;
import javax.swing.*;
import java.awt.*;
import mainFrame.MainFrame;

public class ViewRoomsPanel extends JPanel {

    private static final int ROWS = 3;
    private static final int COLUMNS = 4;
    private JPanel gridPanel;

    public ViewRoomsPanel(MainFrame frame) {
        setLayout(new BorderLayout());
        setBackground(Color.LIGHT_GRAY);

        // Title
        JLabel titleLabel = new JLabel("H I L T O N  |  View Rooms", SwingConstants.CENTER);
        titleLabel.setFont(new Font("Segoe UI", Font.BOLD, 24));
        titleLabel.setBorder(BorderFactory.createEmptyBorder(15, 0, 15, 0));
        add(titleLabel, BorderLayout.NORTH);

        // Grid panel
        gridPanel = new JPanel(new GridLayout(ROWS, COLUMNS, 10, 10));
        gridPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        gridPanel.setBackground(Color.LIGHT_GRAY);
        
        updateRooms();
        
        //ADD GRID TO MAIN PANEL CENTER
        add(gridPanel, BorderLayout.CENTER);

        // SOUTH PANEL (Back button)
        JButton backButton = new JButton("Back");
        backButton.addActionListener(e -> frame.showPanel("USER_MENU"));

        JPanel southPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        southPanel.add(backButton);
        add(southPanel, BorderLayout.SOUTH);
    }
    
    public void updateRooms() {
        //CLEAR ROOMS FOR RE RENDER
        gridPanel.removeAll();
        
        //CREATE LABELS(ROOM) TO PUT ON GRID
        int index = 0;
        for (int r = 0; r < ROWS; r++) { //BY GRID LOOP
            for (int c = 0; c < COLUMNS; c++) {
                if (index < appData.Data.rooms.size()) { //HANDLE OUT OF BOUNDS IN ROOMS DATA ARRAY
                    
                    //GET ROOM BY INDEX
                    Room room = appData.Data.rooms.get(index++);
                    
                    //CREATE NEW JLABEL SET TO ROOM DATA
                    JLabel roomLabel = new JLabel(room.getType() + " : " + room.getRoomNumber(),
                            SwingConstants.CENTER); //CENTER ALIGN
                    
                    //DESIGN LABEL
                    roomLabel.setOpaque(true);
                    roomLabel.setForeground(Color.WHITE);
                    roomLabel.setFont(new Font("Segoe UI", Font.BOLD, 16));
                    roomLabel.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY));

                    // Set background color based on availability
                    if (room.isOccupied()) {
                        roomLabel.setBackground(new Color(244, 67, 54)); //Red
                    }
                    else {
                        roomLabel.setBackground(new Color(76, 175, 80)); //Green
                    }

                    gridPanel.add(roomLabel);
                }
            }
        }
    }
}
