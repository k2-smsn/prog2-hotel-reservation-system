/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package viewReservations;

/**
 *
 * @author k2
 */
import appData.Reservation;
import javax.swing.*;
import java.awt.*;
import mainFrame.MainFrame;

public class ViewReservationsPanel extends JPanel {
    private JPanel listPanel = new JPanel();

    public ViewReservationsPanel(MainFrame frame) {
        setLayout(new BorderLayout());
        setBackground(Color.WHITE);

        // Title at the top
        JLabel titleLabel = new JLabel("Current Reservations", SwingConstants.CENTER);
        titleLabel.setFont(new Font("Segoe UI", Font.BOLD, 24));
        titleLabel.setBorder(BorderFactory.createEmptyBorder(15, 0, 15, 0));
        add(titleLabel, BorderLayout.NORTH);

        // Panel that will hold all reservation labels vertically
        listPanel.setLayout(new BoxLayout(listPanel, BoxLayout.Y_AXIS));
        listPanel.setBackground(Color.WHITE);

        updateList(); //UPDATE LIST VIEW

        // Scroll pane allows the list to grow without breaking layout
        JScrollPane scrollPane = new JScrollPane(listPanel);
        scrollPane.setBorder(null);
        add(scrollPane, BorderLayout.CENTER);

        // Back button at the bottom-left
        JButton backButton = new JButton("Back");
        backButton.addActionListener(e -> frame.showPanel("ADMIN_DASHBOARD"));

        JPanel southPanel = new JPanel();
        southPanel.setLayout(new BoxLayout(southPanel, BoxLayout.X_AXIS));
        southPanel.add(Box.createHorizontalStrut(10));
        southPanel.add(backButton);
        southPanel.add(Box.createHorizontalGlue());

        add(southPanel, BorderLayout.SOUTH);
    }
    
    public void updateList() {
        listPanel.removeAll(); //CLEAR LIST FOR RE RENDER
        
        // If there are no reservations, show a simple message
        if (appData.Data.reservations.isEmpty()) {

            JLabel emptyLabel = new JLabel("No reservations found.");
            emptyLabel.setFont(new Font("Segoe UI", Font.ITALIC, 16));
            emptyLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

            listPanel.add(emptyLabel);

        } 
        else {
            // Create one label per reservation
            for (Reservation reservation : appData.Data.reservations) {

                // JLabel supports HTML, so we can display multi-line text cleanly
                JLabel reservationLabel = new JLabel(
                        "<html>" +
                        reservation.getSummary().replace("\n", "<br>") +
                        "</html>"
                );

                reservationLabel.setFont(new Font("Segoe UI", Font.PLAIN, 14));
                reservationLabel.setAlignmentX(Component.LEFT_ALIGNMENT);

                // Light border and padding so each reservation looks like a card
                reservationLabel.setBorder(
                        BorderFactory.createCompoundBorder(
                                BorderFactory.createLineBorder(Color.LIGHT_GRAY),
                                BorderFactory.createEmptyBorder(10, 10, 10, 10)
                        )
                );

                listPanel.add(reservationLabel);
                listPanel.add(Box.createVerticalStrut(10));
            }
        }
        
        listPanel.revalidate();
        listPanel.repaint();
    }
}
