/**
 * Enum for different seat types in a train
 */
public enum SeatType {
    SLEEPER("SL", 500),
    THREE_TIER_AC("3A", 1500),
    TWO_TIER_AC("2A", 2000),
    FIRST_CLASS_AC("1A", 3500),
    GENERAL("GN", 200),
    UNRESERVED("UR", 150);
    
    private String code;
    private int basePrice;
    
    SeatType(String code, int basePrice) {
        this.code = code;
        this.basePrice = basePrice;
    }
    
    public String getCode() {
        return code;
    }
    
    public int getBasePrice() {
        return basePrice;
    }
}
