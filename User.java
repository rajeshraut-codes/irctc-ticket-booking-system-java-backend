/**
 * User/Passenger entity in IRCTC System
 */
public class User {
    private String userId;
    private String name;
    private String email;
    private String phone;
    private String aadhar;
    private double wallet;
    
    public User(String userId, String name, String email, String phone, String aadhar) {
        this.userId = userId;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.aadhar = aadhar;
        this.wallet = 0.0;
    }
    
    // Getters
    public String getUserId() {
        return userId;
    }
    
    public String getName() {
        return name;
    }
    
    public String getEmail() {
        return email;
    }
    
    public String getPhone() {
        return phone;
    }
    
    public String getAadhar() {
        return aadhar;
    }
    
    public double getWallet() {
        return wallet;
    }
    
    // Setters
    public void setName(String name) {
        this.name = name;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }
    
    public void setPhone(String phone) {
        this.phone = phone;
    }
    
    public void addFundsToWallet(double amount) {
        if(amount > 0) {
            this.wallet += amount;
        }
    }
    
    public boolean deductFundsFromWallet(double amount) {
        if(this.wallet >= amount && amount > 0) {
            this.wallet -= amount;
            return true;
        }
        return false;
    }
    
    @Override
    public String toString() {
        return "User{" +
                "userId='" + userId + '\'' +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", wallet=" + wallet +
                '}';
    }
}
