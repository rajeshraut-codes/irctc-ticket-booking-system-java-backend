/**
 * Station entity in IRCTC System
 */
public class Station {
    private String stationCode;
    private String stationName;
    private String city;
    private String state;
    
    public Station(String stationCode, String stationName, String city, String state) {
        this.stationCode = stationCode;
        this.stationName = stationName;
        this.city = city;
        this.state = state;
    }
    
    // Getters
    public String getStationCode() {
        return stationCode;
    }
    
    public String getStationName() {
        return stationName;
    }
    
    public String getCity() {
        return city;
    }
    
    public String getState() {
        return state;
    }
    
    @Override
    public String toString() {
        return "Station{" +
                "stationCode='" + stationCode + '\'' +
                ", stationName='" + stationName + '\'' +
                ", city='" + city + '\'' +
                ", state='" + state + '\'' +
                '}';
    }
}
