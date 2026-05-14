/**
 * Enum for seat availability status
 */
public enum SeatStatus {
    AVAILABLE("Available"),
    BOOKED("Booked"),
    RESERVED("Reserved"),
    MAINTENANCE("Maintenance");
    
    private String status;
    
    SeatStatus(String status) {
        this.status = status;
    }
    
    public String getStatus() {
        return status;
    }
}
