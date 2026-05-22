import java.util.*;

/**
 * Coach entity representing a coach in a train
 */
public class Coach {
    private String coachId;
    private SeatType seatType;
    private int totalSeats;
    private Map<String, Seat> seats;  // seatNumber -> Seat
    
    public Coach(String coachId, SeatType seatType, int totalSeats) {
        this.coachId = coachId;
        this.seatType = seatType;
        this.totalSeats = totalSeats;
        this.seats = new HashMap<>();
        initializeSeats();
    }
    
    // Initialize seats in coach
    private void initializeSeats() {
        for(int i = 1; i <= totalSeats; i++) {
            String seatNumber = coachId + "-" + i;
            seats.put(seatNumber, new Seat(seatNumber, seatType, seatType.getBasePrice()));
        }
    }
    
    // Getters
    public String getCoachId() {
        return coachId;
    }
    
    public SeatType getSeatType() {
        return seatType;
    }
    
    public int getTotalSeats() {
        return totalSeats;
    }
    
    public Map<String, Seat> getSeats() {
        return seats;
    }
    
    // Get available seats count
    public int getAvailableSeatsCount() {
        int count = 0;
        for(Seat seat : seats.values()) {
            if(seat.isAvailable()) {
                count++;
            }
        }
        return count;
    }
    
    // Book a specific seat
    public boolean bookSeat(String seatNumber) {
        Seat seat = seats.get(seatNumber);
        if(seat != null && seat.isAvailable()) {
            seat.setStatus(SeatStatus.BOOKED);
            return true;
        }
        return false;
    }
    
    // Get a specific seat
    public Seat getSeat(String seatNumber) {
        return seats.get(seatNumber);
    }
    
    // Get list of available seats
    public List<Seat> getAvailableSeats() {
        List<Seat> availableSeats = new ArrayList<>();
        for(Seat seat : seats.values()) {
            if(seat.isAvailable()) {
                availableSeats.add(seat);
            }
        }
        return availableSeats;
    }
}
