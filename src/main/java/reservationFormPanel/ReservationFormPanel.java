/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package reservationFormPanel;

/**
 *
 * @author k2
 */
import appData.Reservation;
import appData.Room;
import javax.swing.*;
import java.awt.*;
import mainFrame.MainFrame;

public class ReservationFormPanel extends JPanel {

    private static int bookingCounter = 1;

    private Room selectedRoom = null;
    private JButton selectedButton = null;

    public ReservationFormPanel(MainFrame frame) {
        setLayout(new BorderLayout());
        setBackground(Color.WHITE);

        //TITLE
        JLabel title = new JLabel("Reservation Form", SwingConstants.CENTER);
        title.setFont(new Font("Segoe UI", Font.BOLD, 24));
        title.setBorder(BorderFactory.createEmptyBorder(15, 0, 15, 0));
        add(title, BorderLayout.NORTH);

        //MAIN CONTENT
        JPanel content = new JPanel();
        content.setLayout(new BoxLayout(content, BoxLayout.Y_AXIS));
        content.setBackground(Color.WHITE);

        //GUEST INFO
        JPanel guestPanel = new JPanel(new GridLayout(3, 2, 10, 10));
        guestPanel.setBorder(BorderFactory.createTitledBorder("Guest Information"));

        JTextField nameField = new JTextField();
        JTextField mobileField = new JTextField();
        JTextField emailField = new JTextField(); //TEXT FIELDS

        guestPanel.add(new JLabel("Name:"));
        guestPanel.add(nameField);
        guestPanel.add(new JLabel("Mobile:"));
        guestPanel.add(mobileField);
        guestPanel.add(new JLabel("Email:")); //ADD TO TOP PANEL
        guestPanel.add(emailField);

        //DATES (MIDDLE PANEL)
        JPanel datePanel = new JPanel(new GridLayout(2, 2, 10, 10));
        datePanel.setBorder(BorderFactory.createTitledBorder("Reservation Dates"));

        JTextField checkInField = new JTextField();
        JTextField checkOutField = new JTextField();

        datePanel.add(new JLabel("Check-in:"));
        datePanel.add(checkInField);
        datePanel.add(new JLabel("Check-out:"));
        datePanel.add(checkOutField);

        //ROOM SELECTION (THIRD PANEL)
        JPanel roomPanel = new JPanel(new GridLayout(3, 4, 10, 10));
        roomPanel.setBorder(BorderFactory.createTitledBorder("Select a Room"));

        for (Room room : appData.Data.rooms) {
            JButton roomBtn = new JButton(room.getType() + " : " + room.getRoomNumber());
            roomBtn.setOpaque(true);
            roomBtn.setForeground(Color.WHITE);
            roomBtn.setFont(new Font("Segoe UI", Font.BOLD, 14));

            if (room.isOccupied()) {
                roomBtn.setBackground(Color.GRAY);
                roomBtn.setEnabled(false);
            } else {
                roomBtn.setBackground(new Color(76, 175, 80));
            }

            roomBtn.addActionListener(e -> {
                // Unselect previous
                if (selectedButton != null) {
                    selectedButton.setBorder(UIManager.getBorder("Button.border"));
                }

                // Select new
                selectedRoom = room;
                selectedButton = roomBtn;
                roomBtn.setBorder(BorderFactory.createLineBorder(Color.BLUE, 3));
            });

            roomPanel.add(roomBtn);
        }
        
        // PRICE DISPLAY
        JLabel priceLabel = new JLabel("Final Price: ₱1000");
        priceLabel.setFont(new Font("Segoe UI", Font.BOLD, 16));
        priceLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        
        //AMENITIES
        JPanel amenitiesPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        amenitiesPanel.setBorder(BorderFactory.createTitledBorder("Amenities"));

        JCheckBox barCheck = new JCheckBox("Bar Access");
        JCheckBox poolCheck = new JCheckBox("Pool Access");
        JCheckBox breakfastCheck = new JCheckBox("Breakfast");
        
        final int BASE_PRICE = 1000;

        Runnable updatePrice = () -> {
            int price = BASE_PRICE;

            if (barCheck.isSelected()) price += 200;
            if (poolCheck.isSelected()) price += 200;
            if (breakfastCheck.isSelected()) price += 200;

            priceLabel.setText("Final Price: ₱" + price);
        };
        
        barCheck.addActionListener(e -> updatePrice.run());
        poolCheck.addActionListener(e -> updatePrice.run());
        breakfastCheck.addActionListener(e -> updatePrice.run());



        amenitiesPanel.add(barCheck);
        amenitiesPanel.add(poolCheck);
        amenitiesPanel.add(breakfastCheck);

        //ADD TO CONTENT (ASSEMBLE EVERY PANEL TO ONE)
        content.add(guestPanel);
        content.add(Box.createVerticalStrut(10));
        content.add(datePanel);
        content.add(Box.createVerticalStrut(10));
        content.add(roomPanel);
        content.add(Box.createVerticalStrut(10));
        content.add(amenitiesPanel);
        content.add(Box.createVerticalStrut(15));
        content.add(priceLabel);

        add(content, BorderLayout.CENTER);

        //SOUTH BUTTONS (BOTTOM PANEL)
        JButton backBtn = new JButton("Back");
        JButton bookBtn = new JButton("Book Now");
        
        //BOOK BUTTON FUNCTION
        bookBtn.addActionListener(e -> {
            double finalPrice = 1000;

            if (barCheck.isSelected()) finalPrice += 200;
            if (poolCheck.isSelected()) finalPrice += 200;
            if (breakfastCheck.isSelected()) finalPrice += 200;

            
            if (nameField.getText().isEmpty() //HANDLE NO INPUT ERROR
                    || mobileField.getText().isEmpty()
                    || emailField.getText().isEmpty()
                    || checkInField.getText().isEmpty()
                    || checkOutField.getText().isEmpty()
                    || selectedRoom == null) {

                JOptionPane.showMessageDialog(this,
                        "Please complete all fields and select a room.");
                return;
            }

            int bookingId = appData.Data.bookingCounter++; //INCREMENT ROOM RESERVATIONS FOR ID

            Reservation reservation = new Reservation(
                bookingId,
                nameField.getText(),
                mobileField.getText(),
                emailField.getText(),
                checkInField.getText(),
                checkOutField.getText(),
                selectedRoom,
                barCheck.isSelected(),
                poolCheck.isSelected(),
                breakfastCheck.isSelected(),
                finalPrice
            );

            appData.Data.reservations.add(reservation); //STORE NEW RESERVATION TO MINI DATABASE(ARRAYLIST)
            selectedRoom.setOccupied(true);

            JOptionPane.showMessageDialog(this,
                    "Booking Successful!\n\n" + reservation.getSummary());

            frame.showPanel("USER_LANDING");
        });

        //ASSEMBLE SOUTH PANEL
        JPanel southPanel = new JPanel();
        southPanel.setLayout(new BoxLayout(southPanel, BoxLayout.X_AXIS));
        southPanel.add(Box.createHorizontalStrut(10));
        southPanel.add(backBtn);
        southPanel.add(Box.createHorizontalGlue());
        southPanel.add(bookBtn);
        southPanel.add(Box.createHorizontalStrut(10));

        backBtn.addActionListener(e -> frame.showPanel("HOME"));

        add(southPanel, BorderLayout.SOUTH);
    }
}
