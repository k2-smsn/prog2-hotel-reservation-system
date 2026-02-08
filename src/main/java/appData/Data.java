/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package appData;

/**
 *
 * @author k2
 */
import java.util.*;

public class Data {

    private static final List<Room> rooms = new ArrayList<>();

    static {
        // Initial data 
        rooms.add(new Room(101, Room.Type.SUITE, false));
        rooms.add(new Room(102, Room.Type.SUITE, true));

        rooms.add(new Room(201, Room.Type.DELUXE, true));
        rooms.add(new Room(202, Room.Type.DELUXE, false));

        rooms.add(new Room(301, Room.Type.STANDARD, false));
        rooms.add(new Room(302, Room.Type.STANDARD, true));
    }

    public static List<Room> getRooms() {
        return rooms;
    }

    public static List<Room> getRoomsByType(Room.Type type) {
        List<Room> result = new ArrayList<>();
        for (Room r : rooms) {
            if (r.getType() == type) {
                result.add(r);
            }
        }
        return result;
    }

    public static void setRoomOccupied(int roomNumber, boolean occupied) {
        for (Room r : rooms) {
            if (r.getRoomNumber() == roomNumber) {
                r.setOccupied(occupied);
                break;
            }
        }
    }
}
