public class Region {

    private String country;
    private String city;
    private String neighbourhood;

    
    public Region(String country, String city, String neighbourhood) {
        this.country = country;
        this.city = city;
        this.neighbourhood = neighbourhood;
    }


    // getters
    public String getCountry() {
        return country;
    }
    public String getNeighbourhood() {
        return neighbourhood;
    }
    public String getCity() {
        return city;
    }
    
    //setters
    public void setNeighbourhood(String neighbourhood) {
        this.neighbourhood = neighbourhood;
    }
    public void setCity(String city) {
        this.city = city;
    }
    public void setCountry(String country) {
        this.country = country;
    }
    
    
}
