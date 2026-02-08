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

    public static final List<Room> rooms = new ArrayList<>();

    static {
        // Suites
        rooms.add(new Room(101, Room.Type.SUITE, false));
        rooms.add(new Room(102, Room.Type.SUITE, true));
        rooms.add(new Room(103, Room.Type.SUITE, false));
        rooms.add(new Room(104, Room.Type.SUITE, true));

        // Deluxe
        rooms.add(new Room(201, Room.Type.DELUXE, false));
        rooms.add(new Room(202, Room.Type.DELUXE, true));
        rooms.add(new Room(203, Room.Type.DELUXE, false));
        rooms.add(new Room(204, Room.Type.DELUXE, true));

        // Standard
        rooms.add(new Room(301, Room.Type.STANDARD, false));
        rooms.add(new Room(302, Room.Type.STANDARD, true));
        rooms.add(new Room(303, Room.Type.STANDARD, false));
        rooms.add(new Room(304, Room.Type.STANDARD, true));
    }
}
