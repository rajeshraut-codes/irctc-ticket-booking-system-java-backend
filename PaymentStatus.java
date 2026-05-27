/**
 * Enum for payment status
 */
public enum PaymentStatus {
    PENDING("Pending"),
    SUCCESS("Success"),
    FAILED("Failed"),
    REFUNDED("Refunded");
    
    private String status;
    
    PaymentStatus(String status) {
        this.status = status;
    }
    
    public String getStatus() {
        return status;
    }
}
