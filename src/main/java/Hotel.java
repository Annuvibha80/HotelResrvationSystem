import java.util.ArrayList;
import java.util.List;

public class Hotel {
    private String name;
    private List<Room> rooms;
    private List<Reservation> reservations;

    // Constructor
    public Hotel(String name) {
        this.name = name;
        this.rooms = new ArrayList<>();
        this.reservations = new ArrayList<>();
    }

    // Get hotel name
    public String getName() {
        return name;
    }

    // Add a new room
    public void addRoom(int roomNumber, String type, double price) {
        rooms.add(new Room(roomNumber, type, price));
        System.out.println("Room added successfully!");
    }

    // View all available rooms
    public void viewAvailableRooms() {
        boolean found = false;
        for (Room room : rooms) {
            if (room.isAvailable()) {
                System.out.println(room);
                found = true;
            }
        }
        if (!found) {
            System.out.println("No available rooms in " + name);
        }
    }

    // Make a reservation
    public void makeReservation(String customerName, int roomNumber, String date) {
        for (Room room : rooms) {
            if (room.getRoomNumber() == roomNumber && room.isAvailable()) {
                room.setAvailable(false); // mark booked
                Reservation res = new Reservation(customerName, roomNumber, date);
                reservations.add(res);
                System.out.println("Reservation successful for " + customerName);
                return;
            }
        }
        System.out.println("Room not available for booking!");
    }

    // View all reservations
    public void showReservations() {
        if (reservations.isEmpty()) {
            System.out.println("No reservations yet in " + name);
        } else {
            for (Reservation res : reservations) {
                System.out.println(res);
            }
        }
    }

    // Cancel a reservation
    public void cancelReservation(String customerName, int roomNumber) {
        for (Reservation res : reservations) {
            if (res.getCustomerName().equalsIgnoreCase(customerName)
                    && res.getRoomNumber() == roomNumber) {
                reservations.remove(res);
                // mark room available again
                for (Room room : rooms) {
                    if (room.getRoomNumber() == roomNumber) {
                        room.setAvailable(true);
                        break;
                    }
                }
                System.out.println("Reservation cancelled successfully!");
                return;
            }
        }
        System.out.println("Reservation not found!");
    }
}
