import java.util.*;

/**
 * IRCTC Application - Demo/Client for the Low Level Design
 * This demonstrates how the IRCTC system can be used
 */
public class IRCTCApp {
    public static void main(String[] args) {
        try {
            // Initialize Railway System
            RailwaySystem railwaySystem = new RailwaySystem();
            
            // ===== 1. ADD STATIONS =====
            System.out.println("===== Adding Stations =====");
            Station delhi = new Station("DLI", "Delhi Junction", "Delhi", "Delhi");
            Station mumbai = new Station("BCT", "Mumbai Central", "Mumbai", "Maharashtra");
            Station bangalore = new Station("SBC", "Bangalore City", "Bangalore", "Karnataka");
            
            railwaySystem.addStation(delhi);
            railwaySystem.addStation(mumbai);
            railwaySystem.addStation(bangalore);
            System.out.println("Stations added successfully\n");
            
            // ===== 2. REGISTER USERS =====
            System.out.println("===== Registering Users =====");
            User user1 = new User("USR001", "Rajesh Kumar", "rajesh@gmail.com", "9876543210", "123456789");
            User user2 = new User("USR002", "Priya Singh", "priya@gmail.com", "9876543211", "987654321");
            
            railwaySystem.registerUser(user1);
            railwaySystem.registerUser(user2);
            user1.addFundsToWallet(10000); // Add money to wallet
            user2.addFundsToWallet(15000);
            System.out.println(user1);
            System.out.println(user2);
            System.out.println();
            
            // ===== 3. CREATE TRAINS =====
            System.out.println("===== Creating Trains =====");
            Date departureTime1 = new Date(System.currentTimeMillis() + 86400000); // Tomorrow
            Date arrivalTime1 = new Date(System.currentTimeMillis() + 86400000 + 3600000 * 15); // +15 hours
            
            Train rajdhani = new Train("12001", "Rajdhani Express", delhi, mumbai, departureTime1, arrivalTime1);
            
            // Add coaches to train
            Coach coach1 = new Coach("A1", SeatType.FIRST_CLASS_AC, 5);
            Coach coach2 = new Coach("B1", SeatType.TWO_TIER_AC, 8);
            Coach coach3 = new Coach("C1", SeatType.SLEEPER, 10);
            
            rajdhani.addCoach(coach1);
            rajdhani.addCoach(coach2);
            rajdhani.addCoach(coach3);
            
            railwaySystem.addTrain(rajdhani);
            System.out.println(rajdhani);
            System.out.println("Total Available Seats: " + rajdhani.getTotalAvailableSeats());
            System.out.println();
            
            // ===== 4. SEARCH TRAINS =====
            System.out.println("===== Searching Trains =====");
            List<Train> searchResults = railwaySystem.searchTrains("DLI", "BCT");
            System.out.println("Trains from Delhi to Mumbai: " + searchResults.size());
            System.out.println();
            
            // ===== 5. CREATE BOOKING =====
            System.out.println("===== Creating Booking =====");
            Booking booking = railwaySystem.createBooking("USR001", "12001");
            System.out.println("Booking Created: " + booking.getBookingId());
            
            // Add passengers
            Passenger passenger1 = new Passenger("P001", "Rajesh Kumar", 35, "Male", "PAN123456");
            Passenger passenger2 = new Passenger("P002", "Meera Kumar", 32, "Female", "PAN654321");
            
            booking.addPassenger(passenger1);
            booking.addPassenger(passenger2);
            System.out.println("Passengers added: " + booking.getPassengers().size());
            System.out.println();
            
            // ===== 6. ADD SEATS TO BOOKING =====
            System.out.println("===== Adding Seats to Booking =====");
            List<Seat> availableSeats = coach1.getAvailableSeats();
            if(availableSeats.size() >= 2) {
                booking.addSeat(availableSeats.get(0));
                booking.addSeat(availableSeats.get(1));
                System.out.println("Seats added: " + booking.getBookedSeats().size());
                System.out.println("Seat 1: " + availableSeats.get(0).getSeatNumber() + " - ₹" + availableSeats.get(0).getPrice());
                System.out.println("Seat 2: " + availableSeats.get(1).getSeatNumber() + " - ₹" + availableSeats.get(1).getPrice());
            }
            System.out.println("Total Booking Price: ₹" + booking.getTotalPrice());
            System.out.println();
            
            // ===== 7. MAKE PAYMENT =====
            System.out.println("===== Processing Payment =====");
            Payment payment = new Payment("PAY001", booking.getTotalPrice(), "Debit Card");
            System.out.println("Payment Details: " + payment);
            
            if(user1.deductFundsFromWallet(booking.getTotalPrice())) {
                System.out.println("Payment processed successfully");
                System.out.println("User wallet after payment: ₹" + user1.getWallet());
            }
            System.out.println();
            
            // ===== 8. CONFIRM BOOKING =====
            System.out.println("===== Confirming Booking =====");
            if(railwaySystem.confirmBooking(booking.getBookingId(), payment)) {
                System.out.println("Booking confirmed successfully!");
                System.out.println(booking);
                System.out.println("Booking Status: " + booking.getStatus());
                System.out.println();
                
                // Display passenger seats
                System.out.println("Passenger Seat Assignment:");
                for(Passenger p : booking.getPassengers()) {
                    System.out.println("  " + p.getName() + " -> " + p.getSeatNumber());
                }
            }
            System.out.println();
            
            // ===== 9. VIEW BOOKING HISTORY =====
            System.out.println("===== Booking History for User =====");
            List<Booking> userBookings = railwaySystem.getBookingsByUser("USR001");
            System.out.println("Total bookings: " + userBookings.size());
            for(Booking b : userBookings) {
                System.out.println(b);
            }
            System.out.println();
            
            // ===== 10. CHECK TRAIN AVAILABILITY =====
            System.out.println("===== Checking Train Availability =====");
            int availableSeats2 = railwaySystem.getAvailableSeatsCount("12001");
            System.out.println("Available seats in Rajdhani Express: " + availableSeats2);
            
        } catch(Exception e) {
            System.err.println("Error: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
