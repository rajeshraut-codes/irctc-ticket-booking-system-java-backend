import java.util.*;

/**
 * Railway System Service - Main service class for managing trains, bookings, and operations
 */
public class RailwaySystem {
    private List<Train> trains;
    private Map<String, Booking> bookings;  // bookingId -> Booking
    private Map<String, User> users;  // userId -> User
    private Map<String, Station> stations;  // stationCode -> Station
    
    public RailwaySystem() {
        this.trains = new ArrayList<>();
        this.bookings = new HashMap<>();
        this.users = new HashMap<>();
        this.stations = new HashMap<>();
    }
    
    // Register a new user
    public boolean registerUser(User user) {
        if(user != null && !users.containsKey(user.getUserId())) {
            users.put(user.getUserId(), user);
            return true;
        }
        return false;
    }
    
    // Get user by ID
    public User getUserById(String userId) {
        return users.get(userId);
    }
    
    // Add a station
    public boolean addStation(Station station) {
        if(station != null && !stations.containsKey(station.getStationCode())) {
            stations.put(station.getStationCode(), station);
            return true;
        }
        return false;
    }
    
    // Get station by code
    public Station getStationByCode(String code) {
        return stations.get(code);
    }
    
    // Add a train to the system
    public boolean addTrain(Train train) {
        if(train != null && !trains.contains(train)) {
            trains.add(train);
            return true;
        }
        return false;
    }
    
    // Search trains by source and destination
    public List<Train> searchTrains(String sourceCode, String destinationCode) {
        List<Train> result = new ArrayList<>();
        for(Train train : trains) {
            if(train.getSource().getStationCode().equals(sourceCode) && 
               train.getDestination().getStationCode().equals(destinationCode)) {
                result.add(train);
            }
        }
        return result;
    }
    
    // Search trains by train number
    public Train getTrainByNumber(String trainNumber) {
        for(Train train : trains) {
            if(train.getTrainNumber().equals(trainNumber)) {
                return train;
            }
        }
        return null;
    }
    
    // Create a new booking
    public Booking createBooking(String userId, String trainNumber) throws Exception {
        User user = getUserById(userId);
        Train train = getTrainByNumber(trainNumber);
        
        if(user == null) {
            throw new Exception("User not found");
        }
        if(train == null) {
            throw new Exception("Train not found");
        }
        
        String bookingId = UUID.randomUUID().toString();
        Booking booking = new Booking(bookingId, user, train);
        bookings.put(bookingId, booking);
        
        return booking;
    }
    
    // Get booking by ID
    public Booking getBookingById(String bookingId) {
        return bookings.get(bookingId);
    }
    
    // Get all bookings for a user
    public List<Booking> getBookingsByUser(String userId) {
        List<Booking> userBookings = new ArrayList<>();
        for(Booking booking : bookings.values()) {
            if(booking.getUser().getUserId().equals(userId)) {
                userBookings.add(booking);
            }
        }
        return userBookings;
    }
    
    // Confirm a booking
    public boolean confirmBooking(String bookingId, Payment payment) {
        Booking booking = getBookingById(bookingId);
        if(booking != null && payment != null) {
            if(payment.processPayment()) {
                booking.setPayment(payment);
                booking.assignSeatsToPassengers();
                booking.confirmBooking();
                return true;
            }
        }
        return false;
    }
    
    // Cancel a booking
    public boolean cancelBooking(String bookingId) {
        Booking booking = getBookingById(bookingId);
        if(booking != null) {
            return booking.cancelBooking();
        }
        return false;
    }
    
    // Get all trains
    public List<Train> getAllTrains() {
        return new ArrayList<>(trains);
    }
    
    // Get number of available seats in a train
    public int getAvailableSeatsCount(String trainNumber) {
        Train train = getTrainByNumber(trainNumber);
        if(train != null) {
            return train.getTotalAvailableSeats();
        }
        return 0;
    }
}
