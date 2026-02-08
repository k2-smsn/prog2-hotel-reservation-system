/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package updateRooms;

/**
 *
 * @author k2
 */
import appData.Room;
import javax.swing.*;
import java.awt.*;
import mainFrame.MainFrame;

public class UpdateRoomsPanel extends JPanel {

    private static final int ROWS = 3;
    private static final int COLUMNS = 4;
    private JPanel gridPanel;

    public UpdateRoomsPanel(MainFrame frame) {
        setLayout(new BorderLayout());
        setBackground(Color.WHITE);

        // Title
        JLabel titleLabel = new JLabel("Update Rooms", SwingConstants.CENTER);
        titleLabel.setFont(new Font("Segoe UI", Font.BOLD, 24));
        titleLabel.setBorder(BorderFactory.createEmptyBorder(15, 0, 15, 0));
        add(titleLabel, BorderLayout.NORTH);
        
        // Grid panel
        gridPanel = new JPanel(new GridLayout(ROWS, COLUMNS, 10, 10));
        gridPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        gridPanel.setBackground(Color.WHITE);
        
        updateGridPanel();
        
                
        add(gridPanel, BorderLayout.CENTER);

        // Back button
        JButton backButton = new JButton("Back");
        backButton.addActionListener(e -> frame.showPanel("ADMIN_DASHBOARD"));

        JPanel southPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        southPanel.add(backButton);
        add(southPanel, BorderLayout.SOUTH);
    }
    
    private void updateGridPanel() {
        gridPanel.removeAll(); //CLEAR GRID FOR RE RENDER
        
        int index = 0;
        for (int r = 0; r < ROWS; r++) {
            for (int c = 0; c < COLUMNS; c++) {
                if (index < appData.Data.rooms.size()) { //HANLDE OUT OF BOUNDS EXCEPTION
                    Room room = appData.Data.rooms.get(index++);
                    JButton roomBtn = new JButton(room.getType() + " : " + room.getRoomNumber());

                    roomBtn.setOpaque(true);
                    roomBtn.setForeground(Color.WHITE);
                    roomBtn.setFont(new Font("Segoe UI", Font.BOLD, 16));
                    roomBtn.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY));
                    
                    // Set background color based on availability
                    if (room.isOccupied()) {
                        roomBtn.setBackground(new Color(244, 67, 54)); //Red
                    }
                    else {
                        roomBtn.setBackground(new Color(76, 175, 80)); //Green
                    }

                    // Toggle availability when clicked
                    roomBtn.addActionListener(e -> {
                        room.setOccupied(!room.isOccupied()); // toggle
                        
                        if (room.isOccupied()) {
                            roomBtn.setBackground(new Color(244, 67, 54)); 
                        }
                        else {
                            roomBtn.setBackground(new Color(76, 175, 80)); 
                        }
                        
                        updateGridPanel();
                    });

                    gridPanel.add(roomBtn);
                }
            }
        }
        
        gridPanel.revalidate();
        gridPanel.repaint();

    }
    
}
