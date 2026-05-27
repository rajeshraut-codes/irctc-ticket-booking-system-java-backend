import java.util.*;

/**
 * Payment entity in IRCTC System
 */
public class Payment {
    private String paymentId;
    private double amount;
    private PaymentStatus status;
    private Date paymentDate;
    private String paymentMethod;
    
    public Payment(String paymentId, double amount, String paymentMethod) {
        this.paymentId = paymentId;
        this.amount = amount;
        this.paymentMethod = paymentMethod;
        this.status = PaymentStatus.PENDING;
        this.paymentDate = new Date();
    }
    
    // Getters
    public String getPaymentId() {
        return paymentId;
    }
    
    public double getAmount() {
        return amount;
    }
    
    public PaymentStatus getStatus() {
        return status;
    }
    
    public Date getPaymentDate() {
        return paymentDate;
    }
    
    public String getPaymentMethod() {
        return paymentMethod;
    }
    
    // Setters
    public void setStatus(PaymentStatus status) {
        this.status = status;
    }
    
    public boolean processPayment() {
        // Validation logic
        if(amount <= 0) {
            this.status = PaymentStatus.FAILED;
            return false;
        }
        
        // Simulate payment processing
        this.status = PaymentStatus.SUCCESS;
        this.paymentDate = new Date();
        return true;
    }
    
    public boolean refundPayment() {
        if(this.status == PaymentStatus.SUCCESS) {
            this.status = PaymentStatus.REFUNDED;
            return true;
        }
        return false;
    }
    
    @Override
    public String toString() {
        return "Payment{" +
                "paymentId='" + paymentId + '\'' +
                ", amount=" + amount +
                ", status=" + status +
                ", paymentMethod='" + paymentMethod + '\'' +
                '}';
    }
}
