public class Room {
    private int roomNumber;
    private String type;
    private double price;
    private boolean available;

    // Constructor
    public Room(int roomNumber, String type, double price) {
        this.roomNumber = roomNumber;
        this.type = type;
        this.price = price;
        this.available = true; // by default room is available
    }

    // Getters
    public int getRoomNumber() {
        return roomNumber;
    }

    public String getType() {
        return type;
    }

    public double getPrice() {
        return price;
    }

    public boolean isAvailable() {
        return available;
    }

    // Setter for availability
    public void setAvailable(boolean available) {
        this.available = available;
    }

    @Override
    public String toString() {
        return "Room " + roomNumber + " [" + type + "] - ₹" + price +
                (available ? " (Available)" : " (Booked)");
    }
}
