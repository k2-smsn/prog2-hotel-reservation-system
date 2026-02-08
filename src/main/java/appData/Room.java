/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package appData;

/**
 *
 * @author k2
 */
public class Room {

    public enum Type {
        SUITE, DELUXE, STANDARD
    }

    private int roomNumber;
    private Type type;
    private boolean occupied;

    public Room(int roomNumber, Type type, boolean occupied) {
        this.roomNumber = roomNumber;
        this.type = type;
        this.occupied = occupied;
    }

    public int getRoomNumber() {
        return roomNumber;
    }

    public Type getType() {
        return type;
    }

    public boolean isOccupied() {
        return occupied;
    }

    public void setOccupied(boolean occupied) {
        this.occupied = occupied;
    }
}