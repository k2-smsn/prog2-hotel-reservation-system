/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package appData;

/**
 *
 * @author k2
 */
import java.util.ArrayList;
import java.util.List;

// Static database
public class Data {

    public static final List<Room> rooms = new ArrayList<>(); //ROOMS
    
    //RESERVATIONS
    public static final List<Reservation> reservations = new ArrayList<>();

    public static int bookingCounter = 1;

    static { //ROOMS
        // Suites
        rooms.add(new Room(101, Room.Type.SUITE, false));
        rooms.add(new Room(102, Room.Type.SUITE, false));
        rooms.add(new Room(103, Room.Type.SUITE, false));
        rooms.add(new Room(104, Room.Type.SUITE, false));

        // Deluxe
        rooms.add(new Room(201, Room.Type.DELUXE, false));
        rooms.add(new Room(202, Room.Type.DELUXE, false));
        rooms.add(new Room(203, Room.Type.DELUXE, false));
        rooms.add(new Room(204, Room.Type.DELUXE, false));

        // Standard
        rooms.add(new Room(301, Room.Type.STANDARD, false));
        rooms.add(new Room(302, Room.Type.STANDARD, false));
        rooms.add(new Room(303, Room.Type.STANDARD, false));
        rooms.add(new Room(304, Room.Type.STANDARD, false));
    }
}
