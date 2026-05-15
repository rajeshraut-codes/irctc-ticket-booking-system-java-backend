/**
 * Enum for booking status in the system
 */
public enum BookingStatus {
    PENDING("Pending"),
    CONFIRMED("Confirmed"),
    CANCELLED("Cancelled"),
    COMPLETED("Completed");
    
    private String status;
    
    BookingStatus(String status) {
        this.status = status;
    }
    
    public String getStatus() {
        return status;
    }
}
