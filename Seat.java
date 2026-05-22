public class Seat {
    private String seatNumber;
    private SeatType seatType;
    private SeatStatus status;
    private double price;
    
    public Seat(String seatNumber, SeatType seatType, double price) {
        this.seatNumber = seatNumber;
        this.seatType = seatType;
        this.price = price;
        this.status = SeatStatus.AVAILABLE;
    }
    
    // Getters
    public String getSeatNumber() {
        return seatNumber;
    }
    
    public SeatType getSeatType() {
        return seatType;
    }
    
    public SeatStatus getStatus() {
        return status;
    }
    
    public double getPrice() {
        return price;
    }
    
    // Setters
    public void setStatus(SeatStatus status) {
        this.status = status;
    }
    
    public void setPrice(double price) {
        if(price > 0) {
            this.price = price;
        }
    }
    
    public boolean isAvailable() {
        return this.status == SeatStatus.AVAILABLE;
    }
    
    @Override
    public String toString() {
        return "Seat{" +
                "seatNumber='" + seatNumber + '\'' +
                ", seatType=" + seatType +
                ", status=" + status +
                ", price=" + price +
                '}';
    }
}
