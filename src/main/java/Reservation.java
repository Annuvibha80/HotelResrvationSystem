public class Reservation {
    private String customerName;
    private int roomNumber;
    private String date;

    // Constructor
    public Reservation(String customerName, int roomNumber, String date) {
        this.customerName = customerName;
        this.roomNumber = roomNumber;
        this.date = date;
    }

    // Getters
    public String getCustomerName() {
        return customerName;
    }

    public int getRoomNumber() {
        return roomNumber;
    }

    public String getDate() {
        return date;
    }

    @Override
    public String toString() {
        return "Reservation [Customer: " + customerName +
                ", Room: " + roomNumber +
                ", Date: " + date + "]";
    }
}
