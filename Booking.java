import java.util.*;

/**
 * Booking entity in IRCTC System
 */
public class Booking {
    private String bookingId;
    private User user;
    private Train train;
    private List<Passenger> passengers;
    private List<Seat> bookedSeats;
    private BookingStatus status;
    private Payment payment;
    private Date bookingDate;
    private double totalPrice;
    
    public Booking(String bookingId, User user, Train train) {
        this.bookingId = bookingId;
        this.user = user;
        this.train = train;
        this.passengers = new ArrayList<>();
        this.bookedSeats = new ArrayList<>();
        this.status = BookingStatus.PENDING;
        this.bookingDate = new Date();
        this.totalPrice = 0.0;
    }
    
    // Getters
    public String getBookingId() {
        return bookingId;
    }
    
    public User getUser() {
        return user;
    }
    
    public Train getTrain() {
        return train;
    }
    
    public List<Passenger> getPassengers() {
        return passengers;
    }
    
    public List<Seat> getBookedSeats() {
        return bookedSeats;
    }
    
    public BookingStatus getStatus() {
        return status;
    }
    
    public Payment getPayment() {
        return payment;
    }
    
    public Date getBookingDate() {
        return bookingDate;
    }
    
    public double getTotalPrice() {
        return totalPrice;
    }
    
    // Add passenger to booking
    public void addPassenger(Passenger passenger) {
        if(passenger != null && !passengers.contains(passenger)) {
            passengers.add(passenger);
        }
    }
    
    // Add seat to booking
    public void addSeat(Seat seat) {
        if(seat != null && !bookedSeats.contains(seat)) {
            bookedSeats.add(seat);
            totalPrice += seat.getPrice();
        }
    }
    
    // Remove passenger from booking
    public void removePassenger(Passenger passenger) {
        passengers.remove(passenger);
    }
    
    // Set payment
    public void setPayment(Payment payment) {
        this.payment = payment;
    }
    
    // Confirm booking
    public boolean confirmBooking() {
        if(passengers.isEmpty() || bookedSeats.isEmpty()) {
            return false;
        }
        
        if(passengers.size() != bookedSeats.size()) {
            return false;
        }
        
        this.status = BookingStatus.CONFIRMED;
        return true;
    }
    
    // Cancel booking
    public boolean cancelBooking() {
        if(this.status == BookingStatus.CONFIRMED || this.status == BookingStatus.PENDING) {
            this.status = BookingStatus.CANCELLED;
            
            // Process refund
            if(payment != null) {
                payment.refundPayment();
            }
            return true;
        }
        return false;
    }
    
    // Assign seats to passengers
    public boolean assignSeatsToPassengers() {
        if(passengers.size() != bookedSeats.size()) {
            return false;
        }
        
        for(int i = 0; i < passengers.size(); i++) {
            passengers.get(i).setSeatNumber(bookedSeats.get(i).getSeatNumber());
        }
        return true;
    }
    
    @Override
    public String toString() {
        return "Booking{" +
                "bookingId='" + bookingId + '\'' +
                ", user=" + user.getName() +
                ", train=" + train.getTrainNumber() +
                ", status=" + status +
                ", totalPrice=" + totalPrice +
                ", passengers=" + passengers.size() +
                '}';
    }
}
