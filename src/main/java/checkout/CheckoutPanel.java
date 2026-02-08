/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package checkout;

/**
 *
 * @author k2
 */
import appData.Reservation;
import javax.swing.*;
import java.awt.*;
import mainFrame.MainFrame;

public class CheckoutPanel extends JPanel {

    private Reservation currentReservation = null;

    public CheckoutPanel(MainFrame frame) {
        setLayout(new BorderLayout());
        setBackground(Color.WHITE);

        // Title
        JLabel titleLabel = new JLabel("Checkout", SwingConstants.CENTER);
        titleLabel.setFont(new Font("Segoe UI", Font.BOLD, 24));
        titleLabel.setBorder(BorderFactory.createEmptyBorder(15, 0, 15, 0));
        add(titleLabel, BorderLayout.NORTH);

        // Main content panel
        JPanel content = new JPanel();
        content.setLayout(new BoxLayout(content, BoxLayout.Y_AXIS));
        content.setBackground(Color.WHITE);

        // Reservation ID input
        JPanel searchPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JTextField reservationIdField = new JTextField(10);
        JButton searchButton = new JButton("Search");

        searchPanel.add(new JLabel("Reservation ID:"));
        searchPanel.add(reservationIdField);
        searchPanel.add(searchButton);

        // Reservation summary display
        JLabel summaryLabel = new JLabel(" ");
        summaryLabel.setVerticalAlignment(SwingConstants.TOP);
        summaryLabel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        // Payment method
        JPanel paymentPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        paymentPanel.setBorder(BorderFactory.createTitledBorder("Payment Method"));

        JRadioButton cashBtn = new JRadioButton("Cash");
        JRadioButton cardBtn = new JRadioButton("Card"); //RADIO BUTTONS

        ButtonGroup paymentGroup = new ButtonGroup();
        paymentGroup.add(cashBtn);
        paymentGroup.add(cardBtn);

        paymentPanel.add(cashBtn);
        paymentPanel.add(cardBtn);

        // Card info (hidden unless card is selected)
        JPanel cardPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JTextField cardField = new JTextField(16);
        cardPanel.add(new JLabel("Card Number:"));
        cardPanel.add(cardField);
        cardPanel.setVisible(false);

        cardBtn.addActionListener(e -> cardPanel.setVisible(true));
        cashBtn.addActionListener(e -> cardPanel.setVisible(false));

        // Confirm button
        JButton confirmButton = new JButton("Confirm Payment");

        // SEARCH LOGIC
        searchButton.addActionListener(e -> {
            try {
                int id = Integer.parseInt(reservationIdField.getText());
                currentReservation = null;

                for (Reservation r : appData.Data.reservations) {
                    if (r.getBookingId() == id) {
                        currentReservation = r;
                        break;
                    }
                }

                if (currentReservation == null) {
                    throw new Exception("Reservation not found");
                }

                summaryLabel.setText(
                        "<html>" +
                        currentReservation.getSummary().replace("\n", "<br>") +
                        "<br><br><b>Total Bill: ₱" +
                        currentReservation.getFinalPrice() +
                        "</b></html>"
                );

            } catch (Exception ex) {
                currentReservation = null;
                summaryLabel.setText(" ");
                JOptionPane.showMessageDialog(this,
                        "Invalid or non-existing reservation ID.");
            }
        });

        // CONFIRM PAYMENT LOGIC
        confirmButton.addActionListener(e -> { //NO INPUT HANDLING
            try {
                if (currentReservation == null) {
                    throw new Exception("No reservation selected");
                }

                if (!cashBtn.isSelected() && !cardBtn.isSelected()) {
                    throw new Exception("Select payment method");
                }

                if (cardBtn.isSelected() && cardField.getText().isEmpty()) {
                    throw new Exception("Enter card details");
                }

                // Mark room as available again
                currentReservation.getRoom().setOccupied(false);

                // Remove reservation from pseudo database
                appData.Data.reservations.remove(currentReservation);

                JOptionPane.showMessageDialog(this,
                        "Payment successful!\nCheckout complete.");

                frame.showPanel("HOME");

            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this,
                        "Checkout failed: " + ex.getMessage());
            }
        });

        // Assemble content
        content.add(searchPanel);
        content.add(Box.createVerticalStrut(10));
        content.add(summaryLabel);
        content.add(paymentPanel);
        content.add(cardPanel);
        content.add(Box.createVerticalStrut(15));
        content.add(confirmButton);

        add(content, BorderLayout.CENTER);

        // Back button
        JButton backButton = new JButton("Back");
        backButton.addActionListener(e -> frame.showPanel("USER_MENU"));
        
        //ASSEMBLE SOUTH PANEL
        JPanel southPanel = new JPanel();
        southPanel.setLayout(new BoxLayout(southPanel, BoxLayout.X_AXIS));
        southPanel.add(Box.createHorizontalStrut(10));
        southPanel.add(backButton);
        southPanel.add(Box.createHorizontalGlue());

        add(southPanel, BorderLayout.SOUTH);
    }
}
