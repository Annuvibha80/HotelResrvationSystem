import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.text.SimpleDateFormat;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Create 3 hotels
        List<Hotel> hotels = new ArrayList<>();
        hotels.add(new Hotel("Hayat Hotel"));
        hotels.add(new Hotel("Taj Hotel"));
        hotels.add(new Hotel("Rajdhani Hotel"));

        System.out.println("===== Welcome to Multi-Hotel Reservation System =====");

        while (true) {
            // Step 1: Choose Hotel
            System.out.println("\nChoose a Hotel:");
            for (int i = 0; i < hotels.size(); i++) {
                System.out.println((i + 1) + ". " + hotels.get(i).getName());
            }
            System.out.println((hotels.size() + 1) + ". Exit");

            int hotelChoice = sc.nextInt();
            sc.nextLine(); // consume newline

            if (hotelChoice == hotels.size() + 1) {
                System.out.println("Thank you for using the system!");
                break;
            }

            if (hotelChoice < 1 || hotelChoice > hotels.size()) {
                System.out.println("Invalid hotel choice! Try again.");
                continue;
            }

            Hotel selectedHotel = hotels.get(hotelChoice - 1);
            System.out.println("\n--- Welcome to " + selectedHotel.getName() + " ---");

            // Step 2: Operations menu
            while (true) {
                System.out.println("\nMenu:");
                System.out.println("1. Add Room");
                System.out.println("2. View Available Rooms");
                System.out.println("3. Make Reservation");
                System.out.println("4. View Reservations");
                System.out.println("5. Cancel Reservation");
                System.out.println("6. Back to Hotel Selection");

                int choice = sc.nextInt();
                sc.nextLine(); // consume newline

                switch (choice) {
                    case 1:
                        int roomNo = 0;
                        double price = 0.0;
                        String type = "";

                        try {
                            System.out.print("Enter Room Number: ");
                            roomNo = sc.nextInt();
                            sc.nextLine(); // clear buffer

                            System.out.print("Enter Room Type: ");
                            type = sc.nextLine();

                            System.out.print("Enter Price: ");
                            price = sc.nextDouble();
                            sc.nextLine(); // clear buffer
                        } catch (Exception e) {
                            System.out.println("Invalid input! Room number and price must be numbers.");
                            sc.nextLine(); // clear invalid input
                            break; // go back to menu
                        }

                        selectedHotel.addRoom(roomNo, type, price);
                        break;


                    case 2:
                        selectedHotel.viewAvailableRooms();
                        break;

                    case 3:
                        System.out.print("Enter Customer Name: ");
                        String name = sc.nextLine();
                        System.out.print("Enter Room Number: ");
                        int rNo = sc.nextInt();
                        sc.nextLine();
                        System.out.print("Enter Date (DD-MM-YYYY): ");
                        String date = sc.nextLine();
                        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
                        sdf.setLenient(false);

                        //handle date input exception 🥱
                        try {
                            sdf.parse(date); // will throw ParseException if invalid
                            // If valid  make reservation
                            selectedHotel.makeReservation(name, rNo, date);
                        } catch (ParseException e) {
                            System.out.println("Invalid date! Please enter in DD-MM-YYYY format.");
                        }
                        break;

                    case 4:
                        selectedHotel.showReservations();
                        break;

                    case 5:
                        System.out.print("Enter Customer Name: ");
                        String cName = sc.nextLine();
                        System.out.print("Enter Room Number: ");
                        int cancelNo = sc.nextInt();
                        selectedHotel.cancelReservation(cName, cancelNo);
                        break;

                    case 6:
                        System.out.println("Going back to Hotel Selection...");
                        break;

                    default:
                        System.out.println("Invalid choice! Try again.");
                }

                if (choice == 6) break; // exit to hotel selection
            }
        }

        sc.close();
    }
}
