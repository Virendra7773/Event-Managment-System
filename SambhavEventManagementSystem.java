import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Hotel {
    String name;
    String rating;
    String subscription;
    int eventsBooked;

    Hotel(String name, String rating, String subscription) {
        this.name = name;
        this.rating = rating;
        this.subscription = subscription;
        this.eventsBooked = 0;
    }
}

class Event {
    String customerName;
    String eventType;
    String facilities;
    String paymentStatus;

    Event(String customerName, String eventType, String facilities, String paymentStatus) {
        this.customerName = customerName;
        this.eventType = eventType;
        this.facilities = facilities;
        this.paymentStatus = paymentStatus;
    }
}

public class SambhavEventManagementSystem {
    private List<Hotel> hotels = new ArrayList<>();
    private List<Event> events = new ArrayList<>();
    private final String adminUsername = "VIRENDRA";
    private final String adminPassword = "sambhav";
    private final String customerUsername = "customer";
    private final String customerPassword = "customer123";

    public void login(Scanner scanner) {
        System.out.print("Enter username: ");
        String username = scanner.nextLine();
        System.out.print("Enter password: ");
        String password = scanner.nextLine();

        if (username.equals(adminUsername) && password.equals(adminPassword)) {
            adminMenu(scanner);
        } else if (username.equals(customerUsername) && password.equals(customerPassword)) {
            customerMenu(scanner);
        } else {
            System.out.println("Invalid credentials.");
        }
    }

    private void adminMenu(Scanner scanner) {
        while (true) {
            System.out.println("\nSAMBHAV - Admin Menu");
            System.out.println("1. Entry of Hotels");
            System.out.println("2. Display all Hotel Data");
            System.out.println("3. Manually Organize Event for Customer");
            System.out.println("4. Logout");

            System.out.print("Enter your choice: ");
            int choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {
                case 1:
                    entryOfHotels(scanner);
                    break;
                case 2:
                    displayHotelData();
                    break;
                case 3:
                    organizeEventForCustomer(scanner);
                    break;
                case 4:
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private void entryOfHotels(Scanner scanner) {
        System.out.print("Enter hotel name: ");
        String name = scanner.nextLine();
        System.out.print("Enter hotel rating: ");
        String rating = scanner.nextLine();
        System.out.print("Enter room subscription (Basic/Premium/Platinum): ");
        String subscription = scanner.nextLine();

        hotels.add(new Hotel(name, rating, subscription));
        System.out.println("Hotel entry successful.");
    }

    private void displayHotelData() {
        System.out.println("\nHotel Data:");
        for (Hotel hotel : hotels) {
            System.out.println("Name: " + hotel.name + ", Rating: " + hotel.rating + 
                               ", Subscription: " + hotel.subscription + 
                               ", Events Booked: " + hotel.eventsBooked);
        }
    }

    private void organizeEventForCustomer(Scanner scanner) {
        System.out.print("Enter customer name: ");
        String customerName = scanner.nextLine();
        System.out.print("Enter event type (Birthday/Anniversary/Other): ");
        String eventType = scanner.nextLine();
        System.out.print("Enter facilities (Food/Drinks/Room Stay/Trips): ");
        String facilities = scanner.nextLine();
        System.out.print("Enter payment status: ");
        String paymentStatus = scanner.nextLine();

        events.add(new Event(customerName, eventType, facilities, paymentStatus));
        System.out.println("Event organized successfully.");
    }

    private void customerMenu(Scanner scanner) {
        while (true) {
            System.out.println("\nSAMBHAV - Customer Menu");
            System.out.println("1. View Hotel Types and Book");
            System.out.println("2. Organize Event");
            System.out.println("3. Logout");

            System.out.print("Enter your choice: ");
            int choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {
                case 1:
                    viewAndBookHotels(scanner);
                    break;
                case 2:
                    organizeEvent(scanner);
                    break;
                case 3:
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private void viewAndBookHotels(Scanner scanner) {
        System.out.println("\nAvailable Hotel Types:");
        for (Hotel hotel : hotels) {
            System.out.println("Name: " + hotel.name + ", Rating: " + hotel.rating + 
                               ", Subscription: " + hotel.subscription);
        }

        System.out.print("Enter the hotel name you want to book: ");
        String hotelName = scanner.nextLine();

        for (Hotel hotel : hotels) {
            if (hotel.name.equals(hotelName)) {
                hotel.eventsBooked++;
                System.out.println("Booking successful for " + hotelName);
                return;
            }
        }

        System.out.println("Hotel " + hotelName + " not found.");
    }

    private void organizeEvent(Scanner scanner) {
        organizeEventForCustomer(scanner);
    }

    public static void main(String[] args) {
        System.out.println("SAMBHAV - Event Management System");

        SambhavEventManagementSystem system = new SambhavEventManagementSystem();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n1. Login");
            System.out.println("2. Exit");

            System.out.print("Enter your choice: ");
            int choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {
                case 1:
                    system.login(scanner);
                    break;
                case 2:
                    System.out.println("Exiting SAMBHAV Event Management System. Goodbye!");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
