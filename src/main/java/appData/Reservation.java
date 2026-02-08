/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package appData;

/**
 *
 * @author k2
 */
public class Reservation {

    private int bookingId;

    // Guest info
    private String name;
    private String mobile;
    private String email;

    // Dates
    private String checkIn;
    private String checkOut;

    // Room
    private Room room;

    // Amenities
    private boolean barAccess;
    private boolean poolAccess;
    private boolean breakfast;
    
    // Price
    private double finalPrice;

    public Reservation(int bookingId,
                       String name,
                       String mobile,
                       String email,
                       String checkIn,
                       String checkOut,
                       Room room,
                       boolean barAccess,
                       boolean poolAccess,
                       boolean breakfast,
                       double finalPrice) {

        this.bookingId = bookingId;
        this.name = name;
        this.mobile = mobile;
        this.email = email;
        this.checkIn = checkIn;
        this.checkOut = checkOut;
        this.room = room;
        this.barAccess = barAccess;
        this.poolAccess = poolAccess;
        this.breakfast = breakfast;
        this.finalPrice = finalPrice;
    }
    
    //DATA GETTERS
    public int getBookingId() { return bookingId; }
    public Room getRoom() { return room; }
    public double getFinalPrice() { return finalPrice; } 

    public String getSummary() {
        return "Booking ID: " + bookingId +
               "\nName: " + name +
               "\nRoom: " + room.getType() + " " + room.getRoomNumber() +
               "\nCheck-in: " + checkIn +
               "\nCheck-out: " + checkOut +
               "\nAmenities: " +
               (barAccess ? "Bar " : "") +
               (poolAccess ? "Pool " : "") +
               (breakfast ? "Breakfast " : "") +
               "\nFinal Price: ₱" + finalPrice;
    }

}
