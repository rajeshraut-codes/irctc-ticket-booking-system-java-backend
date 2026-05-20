/**
 * Passenger entity (separate from User) - details of person traveling
 */
public class Passenger {
    private String passengerId;
    private String name;
    private int age;
    private String gender;
    private String idProof;
    private String seatNumber;
    
    public Passenger(String passengerId, String name, int age, String gender, String idProof) {
        this.passengerId = passengerId;
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.idProof = idProof;
    }
    
    // Getters
    public String getPassengerId() {
        return passengerId;
    }
    
    public String getName() {
        return name;
    }
    
    public int getAge() {
        return age;
    }
    
    public String getGender() {
        return gender;
    }
    
    public String getIdProof() {
        return idProof;
    }
    
    public String getSeatNumber() {
        return seatNumber;
    }
    
    // Setters
    public void setSeatNumber(String seatNumber) {
        this.seatNumber = seatNumber;
    }
    
    @Override
    public String toString() {
        return "Passenger{" +
                "passengerId='" + passengerId + '\'' +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", gender='" + gender + '\'' +
                ", seatNumber='" + seatNumber + '\'' +
                '}';
    }
}
