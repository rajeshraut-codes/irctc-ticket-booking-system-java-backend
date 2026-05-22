import java.util.*;

/**
 * Train entity in IRCTC System
 */
public class Train {
    private String trainNumber;
    private String trainName;
    private Station source;
    private Station destination;
    private Date departureTime;
    private Date arrivalTime;
    private List<Coach> coaches;
    
    public Train(String trainNumber, String trainName, Station source, 
                 Station destination, Date departureTime, Date arrivalTime) {
        this.trainNumber = trainNumber;
        this.trainName = trainName;
        this.source = source;
        this.destination = destination;
        this.departureTime = departureTime;
        this.arrivalTime = arrivalTime;
        this.coaches = new ArrayList<>();
    }
    
    // Getters
    public String getTrainNumber() {
        return trainNumber;
    }
    
    public String getTrainName() {
        return trainName;
    }
    
    public Station getSource() {
        return source;
    }
    
    public Station getDestination() {
        return destination;
    }
    
    public Date getDepartureTime() {
        return departureTime;
    }
    
    public Date getArrivalTime() {
        return arrivalTime;
    }
    
    public List<Coach> getCoaches() {
        return coaches;
    }
    
    // Add a coach to train
    public void addCoach(Coach coach) {
        if(coach != null) {
            coaches.add(coach);
        }
    }
    
    // Get total available seats in train
    public int getTotalAvailableSeats() {
        int totalAvailable = 0;
        for(Coach coach : coaches) {
            totalAvailable += coach.getAvailableSeatsCount();
        }
        return totalAvailable;
    }
    
    // Find and book a seat
    public Seat findAndBookSeat(SeatType seatType) {
        for(Coach coach : coaches) {
            if(coach.getSeatType() == seatType) {
                List<Seat> availableSeats = coach.getAvailableSeats();
                if(!availableSeats.isEmpty()) {
                    Seat seat = availableSeats.get(0);
                    coach.bookSeat(seat.getSeatNumber());
                    return seat;
                }
            }
        }
        return null;
    }
    
    // Get coach by ID
    public Coach getCoachById(String coachId) {
        for(Coach coach : coaches) {
            if(coach.getCoachId().equals(coachId)) {
                return coach;
            }
        }
        return null;
    }
    
    @Override
    public String toString() {
        return "Train{" +
                "trainNumber='" + trainNumber + '\'' +
                ", trainName='" + trainName + '\'' +
                ", source=" + source.getStationCode() +
                ", destination=" + destination.getStationCode() +
                ", departureTime=" + departureTime +
                '}';
    }
}
